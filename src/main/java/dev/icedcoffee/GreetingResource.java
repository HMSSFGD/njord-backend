package dev.icedcoffee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {

    @GET
    @Path("/hello")
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/wow/{e}")
    public String wow(@PathParam("e") String echo) {
        return "Wow " + echo;
    }
}
