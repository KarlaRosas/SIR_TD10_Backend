package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tars;
import sun.security.krb5.internal.ccache.Tag;

import java.util.List;

/**Query Tags**/

public class TagsDAO extends AbstractJpaDao<Tars, Long> {
    public TagsDAO() {
            super(Tars.class);
        }

    public List<Tars> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Tars as u where u.name = :name", Tars.class)
                .setParameter("name", name).getResultList();

    }
    public List<Tars> getAllTagsDao() {
        String query = "select ta from Tars as ta";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tars.class).getResultList();
    }


    public List<Tars> getAllTagsImportantDao() {
        String query = "select ta from Tars as ta where ta.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tars.class).getResultList();
    }

    public List<Tag> getAllTagsPriorityDao() {
        String query = "select ta from Tars as ta where ta.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }


    public List<Tag> getImportantTagsWithFichesLoaded() {
        String query = "SELECT ta from Tars as ta "
                + "where ta.name='Important' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }
    public List<Tag> getPriorityTagsWithFichesLoaded() {
        String query = "SELECT ta from Tars as ta "
                + "where ta.name='Priority' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }

}
