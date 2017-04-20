package controllers;

import models.User;
import services.UserService;

import javax.inject.Inject;
import javax.json.*;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by PAVILION-DV6 on 9/4/2017.
 */
@Path("/user")
public class UserController {
    @Inject
    private UserService userService;

    @Path("/basic/{userid}")
    @GET
    @Produces("application/json")
    public JsonObject getUserBasic(@PathParam("userid") int userid) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonObjectBuilder builder1 = Json.createObjectBuilder();
        for (User user : userService.getUser(userid)) {
            builder.add("IDENTIFICATION",user.getIdentification())
                    .add("FIRST_NAME", user.getFirst_name())
                    .add("LAST_NAME", user.getLast_name())
                    .add("GENDER", user.getGender())
                    .add("DATE_OF_BIRTH", user.getDate_of_birth());
            builder1.add("ADDRESS",user.getAddress())
                    .add("ADDRESS_CITY",user.getAddress_city())
                    .add("POSTAL_CODE",user.getPostal_code());
            builder.add("ADDRESS",builder1);
        }
        return builder.build();
    }

    @Path("/address/{userid}")
    @GET
    @Produces("application/json")
    public JsonArray getUserAddress(@PathParam("userid") int userid) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (User user : userService.getUser(userid)) {
            builder.add(Json.createObjectBuilder().add("ADDRESS_CITY", user.getAddress_city())
                    .add("ADDRESS", user.getAddress())
                    .add("POSTAL_CODE", user.getPostal_code()));
        }
        return builder.build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createUser")
    public void addUser(User user) {
        userService.addUser(user);
    }
}
