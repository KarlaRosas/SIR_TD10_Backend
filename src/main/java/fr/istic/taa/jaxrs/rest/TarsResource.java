package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TagsDAO;

import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Tars;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.logging.Logger;

@Path("/tags")
@Produces({"application/json", "application/xml"})
public class TarsResource {
    private  static  final Logger logger =Logger.getLogger(TarsResource.class.getName());
    TagsDAO daotags;

    public TarsResource(){
        this.daotags = new TagsDAO();
    }

    @GET
    @Path("/name/{tagsName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tars> getTagsName(@PathParam("tagsName") String tagsName)  {
        return daotags.findByName(tagsName);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tars getTagsId(@PathParam("id") long id)  {
        return daotags.findOne(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tars> getTags()  {
        return daotags.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addTars(
            @Parameter(description = "Tags object that needs to be added to the store", required = true) Tars tars) {
        return Response.ok().entity("SUCCESS").build();
    }
}