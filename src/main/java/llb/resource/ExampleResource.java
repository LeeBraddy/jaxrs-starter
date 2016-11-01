package llb.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import llb.model.HelloMessage;
import llb.server.Logged;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by lee on 10/31/16.
 */
@Logged
@Api("example")
@Path("example")
public class ExampleResource {
    @ApiOperation(
            value = "Say \"Hello world!\"",
            response = HelloMessage.class
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld() {
        HelloMessage message = new HelloMessage();
        message.message = "Hello world!";
        return Response.ok(message).build();
    }

    @ApiOperation(
            value = "Say \"Hello You!\" with the name given from the request",
            response = HelloMessage.class
    )
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloYou(@ApiParam("Someone's name") @PathParam("name") String name) {
        HelloMessage message = new HelloMessage();
        message.name = name;
        message.message = "Hello You! " + name;

        return Response.ok(message).build();
    }
}
