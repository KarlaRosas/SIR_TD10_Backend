package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.*;

import javax.persistence.EntityTransaction;
import java.util.List;


/**Query Fiche**/

public class FicheDAO extends AbstractJpaDao<Fiche, Long> {
        public FicheDAO() {
            super(Fiche.class);
        }

    public void saveFiche(Fiche fiche) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        t.begin();
        EntityManagerHelper.getEntityManager().persist(fiche);
        t.commit();
    }
    public List<Fiche> getAllFiches() {
        String query = "select t from Fiche as t";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Fiche as u where u.name = :name", Fiche.class)
                .setParameter("name", name).getResultList();

    }

    public List<Fiche> getAllFiche1() {
        String query = "select t from Fiche as t where t.name='fiche1'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> getAllFichesSansUtilisateurDao() {
        String query = "select t from Fiche as t where t.utilisateurs is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> getAllFichesSansTagsDao() {
        String query = "select t from Fiche as t where t.tars is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> getAllFichesTagsImportantDao() {
        String query = "select t from Fiche as t join t.tars as a where a.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> getAllFichesTagsPriorityDao() {
        String query = "select t from Fiche as t join t.tars as a where a.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> getFichesName(String name) {
        String query = "select t from Fiche as t join t.tars as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class)
                .setParameter("name", name).getResultList();
    }

    public List<Fiche> getAllFichesNamelong6() {
        String query = "select t from Fiche as t " +
                "where LENGTH(t.name) = 6";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public List<Fiche> get4FichesASCfiches() {
        String query = "select t from Fiche as t ORDER BY t.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Fiche.class)
                .setFirstResult(1).setMaxResults(4)
                .getResultList();
    }
    public List<Fiche> get4FirstDESCfiches() {
        String query = "select t from Fiche as t ORDER BY t.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Fiche.class)
                .setFirstResult(1).setMaxResults(4)
                .getResultList();
    }

    public List<Fiche> getAllMFichenative() {
        String query = "select * from Fiche";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Fiche.class).getResultList();
    }
    public List<Fiche> getAllficheswithutilisateursLoaded() {
        String query = "SELECT t from Fiche as t "
                + "where t.name='fiche1' join fetch t.utilisateurs.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }
    public void addTagFiche(Long id, Tars tag){
        Fiche Fiche = findOne(id);
        tag.setFiche(Fiche);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(tag);
        transaction.commit();
    }


}
