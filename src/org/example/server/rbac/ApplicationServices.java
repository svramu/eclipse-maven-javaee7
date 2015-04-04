package org.example.server.rbac;

import org.picketlink.authorization.annotations.RolesAllowed;
import org.picketlink.credential.DefaultLoginCredentials;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.example.server.rbac.ApplicationRole.ADMINISTRATOR;
import static org.example.server.rbac.ApplicationRole.DEVELOPER;
import static org.example.server.rbac.ApplicationRole.PROJECT_MANAGER;

@Path("/")
public class ApplicationServices {

    @GET
    @Path("/risksManagement")
    @RolesAllowed({PROJECT_MANAGER, ADMINISTRATOR})
    public Response risksManagement(DefaultLoginCredentials credential) {
        return Response.ok().entity("You're allowed to manage risks.").type(MediaType.TEXT_PLAIN).build();
    }

    @GET
    @Path("/timesheet")
    @RolesAllowed({PROJECT_MANAGER, DEVELOPER, ADMINISTRATOR})
    public Response timesheet(DefaultLoginCredentials credential) {
        return Response.ok().entity("You're allowed to work with your timesheet.").type(MediaType.TEXT_PLAIN).build();
    }

    @GET
    @Path("/systemAdministration")
    @RolesAllowed({ADMINISTRATOR})
    public Response systemAdministration(DefaultLoginCredentials credential) {
        return Response.ok().entity("You're allowed to perform system administration tasks.").type(MediaType.TEXT_PLAIN).build();
    }

}
