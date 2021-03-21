package dev.icedcoffee;

import dev.icedcoffee.JsonObjects.*;
import java.util.*;
import javax.inject.Inject;
import javax.transaction.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/reports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReportResource {

    @Inject
    FrontendSocket ws;

    public ReportResource() {}

    @POST
    @Transactional
    public void newReprot(JSONReport r) {
        Report n = new Report();
        n.lat = r.lat;
        n.lng = r.lng;
        n.image = r.image;
        n.persistAndFlush();

        ws.broadcast(WebSocketEvent.ADDPIN, n);
    }

    @POST
    @Path("/update")
    @Transactional
    public void updateStatus(Report newr) {
        Report r = Report.findById(newr.id);
        if (r == null) return;
        r.priority = newr.priority;
        r.status = newr.status;
        r.persistAndFlush();
        if (r.status == Status.RESOLVED) {
            ws.broadcast(WebSocketEvent.DELETEPIN, r);
        } else {
            ws.broadcast(WebSocketEvent.UPDATEPIN, r);
        }
    }

    @GET
    public List<Report> getUnresovled() {
        return Report.getUnresolved();
    }

    @GET
    @Path("/all")
    public List<Report> getAllReports() {
        return Report.listAll();
    }
}
