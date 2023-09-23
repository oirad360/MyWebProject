package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MyRESTWS1 {

    @GET
    @Path("/saluta/{nome}")
    @Produces(MediaType.TEXT_PLAIN)
    public String saluta(@PathParam("nome") String nome) {
        return "Ciao "+nome+"!";
    }
}