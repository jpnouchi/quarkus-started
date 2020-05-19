package org.acme.getting.started;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dev")
public class GreetingResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getDev(@PathParam("id") Long id) {
        return Developer.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer dev) {
        dev.persist();
        return Response.created(URI.create("/dev/" + dev.id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getAllDevs(){
        return Developer.findAll().list();
    }
    
    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByName(@NotNull @PathParam("name") String name){
        return Developer.find("name", name).firstResult();
    }

    @GET
    @Path("name/{name}/age/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByNameAge(@PathParam("name") String name , @PathParam("age") Integer age){
        return Developer.find("name = ?1 and age = ?2", name,age).firstResult();
    }
    
}