package controllers;

import models.Email;
import services.EmailService;

import javax.inject.Inject;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by PAVILION-DV6 on 9/4/2017.
 */
@Path("/user")
public class EmailController {
    @Inject
    private EmailService emailService;

    @Path("/email/{userid}")
    @GET
    @Produces("application/json")
    public JsonObject getEmail(@PathParam("userid") int userid) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder builder1 = Json.createArrayBuilder();
        for (Email email : emailService.getEmail(userid)) {
            builder1.add(Json.createObjectBuilder()
                    .add("EMAIL", email.getEmail())
                    .add("EMAIL_TYPE", email.getEmail_type()));
        }
        return builder.add("Email", builder1).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createEmail")
    public void addEmail(Email email) {
        emailService.addEmail(email);
    }
}
