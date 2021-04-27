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

@Path("/fiches")
@Produces({"application/json", "application/xml"})
public class FicheResource{

    private  static  final Logger logger =Logger.getLogger(FicheResource.class.getName());
    FicheDAO daofiche;

    public FicheResource(){
        this.daofiche = new FicheDAO();
    }

    @GET
    @Path("/hello")
    public String helloWorld() {
        return "hello fiche";
    }
    /*http://localhost:8080/utilisateur/Thibault*/
   /* @GET
    @Path("/{ficheName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getFicheName(@PathParam("ficheName") String ficheName)  {
        //return new Utilisateur();
        return daofiche.findByName(ficheName);
    }*/
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getFiches()  {
        //return new Utilisateur();
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