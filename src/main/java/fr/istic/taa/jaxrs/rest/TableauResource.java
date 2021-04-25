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
import fr.istic.taa.jaxrs.dao.generic.TableauDAO;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.logging.Logger;

@Path("/tableau")
@Produces({"application/json", "application/xml"})
public class TableauResource {

    private  static  final Logger logger =Logger.getLogger(UtilisateurResource.class.getName());
    TableauDAO daotableau;

    public TableauResource(){
        this.daotableau = new TableauDAO();
    }

    @GET
    @Path("/test")
    public String helloWorld() {
        return "hello bebe";
    }
    /*http://localhost:8080/utilisateur/Thibault*/
    @GET
    @Path("/{tableauName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableau> getTableauName(@PathParam("tableauName") String tableauName)  {
        //return new Utilisateur();
        return daotableau.findByName(tableauName);
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableau> getTableaux()  {
        return daotableau.getAllTableaux();
    }

    @POST
    @Path("ajouter/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Tableau createUtilisateur(Tableau t) {

        return this.daotableau.save(t);

    }

}