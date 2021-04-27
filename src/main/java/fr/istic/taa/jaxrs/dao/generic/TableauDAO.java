package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import javafx.scene.control.Tab;
import javax.persistence.*;
import javax.persistence.EntityTransaction;
import java.util.List;



/**Query Tableau**/
import javax.persistence.EntityTransaction;

public class TableauDAO extends AbstractJpaDao<Tableau, Long> {
    public TableauDAO() {
        super(Tableau.class);
    }

    public void addSectionTableau(Long id, Section section){
        Tableau TableauKanban = findOne(id);
        section.setTableau(TableauKanban);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(section);
        transaction.commit();
    }
    public List<Tableau> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select tab from Tableau as tab where tab.name = :name", Tableau.class)
                .setParameter("name", name).getResultList();

    }
    public List<Tableau> getAllTableaux() {
        String query = "select tab from Tableau as tab";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

/*
public class TableauDAO extends AbstractJpaDao<Tableau, String> {


    public void saveTableau(Tableau tableau) {
        EntityTransaction tab = EntityManagerHelper.getEntityManager().getTransaction();

        tab.begin();
        EntityManagerHelper.getEntityManager().persist(tableau);
        tab.commit();
    }

    public List<Tableau> getAllTableaux() {
        String query = "select tab from Tableau as tab";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


    public List<Tableau> getAllTableaux1() {
        String query = "select tab from Tableau as tab where tab.name='Tableau Backend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableaux2() {
        String query = "select tab from Tableau as tab where tab.name='Tableau Frontend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableauxSansSectionDao() {
        String query = "select tab from Tableau as tab where tab.sections is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


    public List<Tableau> getAllTableauxNamelong15() {
        String query = "select tab from Tableau as tab " +
                "where LENGTH(tab.name) = 15";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getTableauASC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }
    public List<Tableau> getTableauDESC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }

    public List<Tableau> getAllTableauxNatifs() {
        String query = "select * from Tableau";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllSectionOFTableauParam(String name) {
        String query = "select t from Tableau as t join t.sections as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class)
                .setParameter("name", name).getResultList();
    }

*/
}
