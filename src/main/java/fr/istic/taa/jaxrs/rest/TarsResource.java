package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.TagsDAO;

import fr.istic.taa.jaxrs.domain.Tars;

import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Produces({"application/json", "application/xml"})
public class TarsResource {
    private  static  final Logger logger =Logger.getLogger(TarsResource.class.getName());
    TagsDAO daotags;

    public TarsResource(){
        this.daotags = new TagsDAO();
    }

    @GET
    @Path("/tags/name/{tagsName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tars> getTagsName(@PathParam("tagsName") String tagsName)  {
        return daotags.findByName(tagsName);
    }

    @GET
    @Path("/tags/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tars getTagsId(@PathParam("id") long id)  {
        return daotags.findOne(id);
    }

    @GET
    @Path("/tags/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tars> getTags()  {
        return daotags.findAll();
    }

    @POST
    @Path("tags/ajouter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addTag(@PathParam("id") Long id, Tars tag){
        daotags.save(tag);
    }

    @PUT
    @Path("/tags/editer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tars editTag(Tars tag){
        return daotags.update(tag);
    }

}