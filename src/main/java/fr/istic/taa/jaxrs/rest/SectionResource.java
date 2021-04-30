package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.SectionDAO;
import fr.istic.taa.jaxrs.domain.Section;

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
        return daosection.findByName(sectionName); }

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
    @Path("section/ajouter")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSection(@PathParam("id") Long id, Section section){
        daosection.save(section);
    }

    @PUT
    @Path("/section/editer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Section editSection(Section sec){
        return daosection.update(sec);
    }


}