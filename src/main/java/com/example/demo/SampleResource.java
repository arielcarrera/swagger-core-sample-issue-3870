package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/sample")
public interface SampleResource {

    @GET
    @Path("/{id}")
    @Operation(summary = "Find by id", description = "Find by id operation")
    @ApiResponse(responseCode = "200", description = "Ok")
    @ApiResponse(responseCode = "201", description = "201", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "204",
		 description = "No Content",
		 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    TestDTO find(@Parameter(description = "ID") @PathParam("id") Integer id);

    @GET
    @Path("/default/{id}")
    @Operation(summary = "Find by id (default)", description = "Find by id operation (default)")
    TestDTO findDefault(@Parameter(description = "ID") @PathParam("id") Integer id);
}