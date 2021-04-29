package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Utilisateur;

import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Produces({"application/json", "application/xml"})
public class UtilisateurResource {

    private static final Logger logger = Logger.getLogger(UtilisateurResource.class.getName());
    UtilisateurDAO daoutilisateur;

    public UtilisateurResource() {
        this.daoutilisateur = new UtilisateurDAO();
    }

    @GET
    @Path("/utilisateur/name/{utilisateurName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurName(@PathParam("utilisateurName") String utilisateurName) {
        return daoutilisateur.findByFirstname(utilisateurName);
    }

    @GET
    @Path("/utilisateur/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur getUtilisateurId(@PathParam("id") long id) {
        return daoutilisateur.findOne(id);
    }

    @GET
    @Path("/utilisateur/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurs() {
        return daoutilisateur.findAll();
    }
    @POST
    @Path("/utilisateur/ajouter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addUtilisateur(@PathParam("id") Long id, Utilisateur utilisateur){
        daoutilisateur.save(utilisateur);
    }
    @PUT
    @Path("/utilisateur/editer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur editUtilisateur(Utilisateur utilisateur){
        return daoutilisateur.update(utilisateur);
    }
}