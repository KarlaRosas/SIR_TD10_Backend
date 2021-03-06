package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TableauDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;
import javafx.scene.control.Tab;

import java.util.List;
import java.util.logging.Logger;

@Path("/api")
@Produces({"application/json", "application/xml"})
public class TableauResource  {

    private  static  final Logger logger =Logger.getLogger(UtilisateurResource.class.getName());
    TableauDAO daotableau;

    public TableauResource(){
        this.daotableau = new TableauDAO();
    }

    @GET
    @Path("/tableau/name/{tableauName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableau> getTableauName(@PathParam("tableauName") String tableauName)  {
        return daotableau.findByName(tableauName);
    }
    @GET
    @Path("/tableau/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tableau getTableauId(@PathParam("id") long id)  {
        return daotableau.findOne(id);
    }

    @GET
    @Path("/tableau/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableau> getAllTableaux() {
        return daotableau.findAll();
    }

    @POST
    @Path("/tableau/{id}/ajouter-section")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addSectionTabelau(@PathParam("id") Long id, Section section){
        daotableau.addSectionTableau(id, section);
    }

    @POST
    @Path("tableau/ajouter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addTableau(@PathParam("id") Long id, Tableau tabelau){
        daotableau.save(tabelau);
    }

    @PUT
    @Path("/tableau/editer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tableau editTableau(Tableau tableau){
        return daotableau.update(tableau);
    }


}