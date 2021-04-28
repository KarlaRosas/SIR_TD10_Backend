package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDAO;
import fr.istic.taa.jaxrs.dao.generic.FicheDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Produces({"application/json", "application/xml"})
public class FicheResource{

    private  static  final Logger logger =Logger.getLogger(FicheResource.class.getName());
    FicheDAO daofiche;

    public FicheResource(){
        this.daofiche = new FicheDAO();
    }


    @GET
    @Path("/fiches/name/{ficheName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getFicheName(@PathParam("ficheName") String ficheName)  {
        return daofiche.findByName(ficheName);
    }
    @GET
    @Path("/fiches/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fiche getFicheId(@PathParam("id") long id)  {
        return daofiche.findOne(id);
    }
    @GET
    @Path("/fiches/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getAllFiches()  {
        return daofiche.findAll();
    }
/*
    @POST
    @Path("/ajouter/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fiche createUtilisateur(Fiche u) {
        return  this.daofiche.save(u);
    }

    public Response addUtilisateur(
            @Parameter(description = "User object that needs to be added to the store", required = true) Utilisateur utilisateur) {
        return Response.ok().entity("SUCCESS").build();
    }*/
}
/*@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheResource {

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {

        return new Fiche();
    }

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Fiche object that needs to be added to the store", required = true) Fiche fiche) {
        return Response.ok().entity("SUCCESS").build();
    }
}*/