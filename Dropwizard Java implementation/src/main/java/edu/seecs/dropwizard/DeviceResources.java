package edu.seecs.dropwizard;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.db.main.GWClass;
import spring.db.model.Person;

@Path("/device")
@Api(value = "/IoT", description = "IoT Case study")
public class DeviceResources {

	private final Validator validator_;

	public DeviceResources(Validator validator) {
		validator_ = validator;
	}

	@GET
	@Path("/{deviceId}")
	@ApiOperation(value = "Get device", notes = "Get device", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("deviceId") long deviceId) {
		GWClass gwClass = new  GWClass("spring.xml");
		List<Person> persons = gwClass.listPerson();
		for(Person  personRet  : persons){
			System.out.println(personRet.getFirstName());
		}
		return Response.ok(persons).build();

	}

	@POST
	@ApiOperation(value = "Add device.", notes = "Add device", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@Valid DeviceDataDTO deviceDataDTO) {
		return Response.ok().build();
	}

	@PUT
	@Path("/{deviceId}")
	@ApiOperation(value = "Update device.", notes = "Update device", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Updated device"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("deviceId") long deviceId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{deviceId}")
	@ApiOperation(value = "Delete device", notes = "Delete device", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Device deleted"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response del(@PathParam("deviceId") long deviceId) {
		return Response.ok().build();
	}

}
