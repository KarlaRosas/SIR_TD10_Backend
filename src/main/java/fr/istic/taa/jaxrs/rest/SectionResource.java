package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.SectionDAO;
import fr.istic.taa.jaxrs.dao.generic.TagsDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tars;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Produces({"application/json", "application/xml"})

    public class SectionResource {
        private  static  final Logger logger =Logger.getLogger(fr.istic.taa.jaxrs.rest.SectionResource.class.getName());
        SectionDAO daosection;

        public SectionResource(){
            this.daosection = new SectionDAO();
        }

    @GET
    @Path("/section/name/{sectionName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Section> getSectionName(@PathParam("sectionName") String sectionName)  {
        return daosection.findByName(sectionName);
    }

    @GET
    @Path("/section/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Section getSectionById(@PathParam("id") long id)  {
        return daosection.findOne(id);
    }

    @GET
    @Path("/section/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Section> getAllSections()  {
        return daosection.findAll();
    }


    @POST
    @Consumes("application/json")
    public Response addSection(
            @Parameter(description = "Section object that needs to be added to the store", required = true) Section section) {
        return Response.ok().entity("SUCCESS").build();
    }
}