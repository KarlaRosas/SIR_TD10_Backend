package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import fr.istic.taa.jaxrs.dao.generic.DaoUtilisateur;
import fr.istic.taa.jaxrs.dao.generic.UtilisateursDAO;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.logging.Logger;

@Path("/utilisateur")
//@Produces({"application/json", "application/xml"})
public class UtilisateurResource{

    UtilisateursDAO daob = new UtilisateursDAO();
    /*private  static  final Logger logger =Logger.getLogger(UtilisateurResource.class.getName());
    DaoUtilisateur daoutilisateur;

    public UtilisateurResource(){
        this.daoutilisateur = new DaoUtilisateur();
    }*/

    @GET
    @Path("/test")
    public String helloWorld() {
        return "hello bebe";
    }
/*http://localhost:8080/utilisateur/Thibault*/
    @GET
    @Path("/{utilisateurName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurName(@PathParam("utilisateurName") String utilisateurName)  {
        //return new Utilisateur();
        return daob.findByName(utilisateurName);
    }
    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateurs()  {
        //return new Utilisateur();
        return daob.get2UtilisateursASC();
    }

    @POST
    @Consumes("application/json")
    public Response addUtilisateur(
            @Parameter(description = "User object that needs to be added to the store", required = true) Utilisateur utilisateur) {
        return Response.ok().entity("SUCCESS").build();
    }
}