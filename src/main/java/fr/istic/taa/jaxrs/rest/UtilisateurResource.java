package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Utilisateur;

import java.util.List;
import java.util.logging.Logger;

@Path("/utilisateur")
//@Produces({"application/json", "application/xml"})
public class UtilisateurResource{

    private  static  final Logger logger =Logger.getLogger(UtilisateurResource.class.getName());
    UtilisateurDAO daoutilisateur;

    public UtilisateurResource(){
        this.daoutilisateur = new UtilisateurDAO();
    }

    @GET
    @Path("/name/{utilisateurName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurName(@PathParam("utilisateurName") String utilisateurName)  {
        return daoutilisateur.findByFirstname(utilisateurName);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur getUtilisateurId(@PathParam("id") long id)  {
        return daoutilisateur.findOne(id);
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurs()  {
        //return new Utilisateur();
        return daoutilisateur.findAll();
    }
/*
    @POST
    @Path("/ajouter/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Utilisateur createUtilisateur(Utilisateur u) {

        return this.daoutilisateur.save(u);

    }*/
    /*
    public Response addUtilisateur(
            @Parameter(description = "User object that needs to be added to the store", required = true) Utilisateur utilisateur) {
        return Response.ok().entity("SUCCESS").build();
    }*/
}