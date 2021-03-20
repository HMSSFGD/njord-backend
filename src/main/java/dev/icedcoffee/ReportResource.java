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
        n.persistAndFlush();

        ws.broadcast(n);
    }

    @GET
    public List<Report> getAllReports() {
        return Report.listAll();
    }
}
