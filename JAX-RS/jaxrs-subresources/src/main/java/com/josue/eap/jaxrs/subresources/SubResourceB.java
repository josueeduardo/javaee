/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josue.eap.jaxrs.subresources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class SubResourceB {

    @Context
    private UriInfo context;

    @GET
    @Produces("text/plain")
    @Path("subB1")
    public Response getText1() {
        return Response.status(Response.Status.CREATED).entity("SUB1").build();
    }

    @GET
    @Produces("text/plain")
    @Path("sub2")
    public Object getText2() {
        return "subB2";
    }

}