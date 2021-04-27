package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tableau;

import javax.persistence.EntityTransaction;
import java.util.List;

/**Query Section**/
public class SectionDAO extends AbstractJpaDao<Section, Long> {

    public SectionDAO() {
        super(Section.class);
    }
/*
    public void addSectionFiche(Long id, Fiche fiche){
        Section SectionFiche = findOne(id);
        fiche.setSection(SectionFiche);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(fiche);
        transaction.commit();
    }*/
}
/*public class SectionDAO {

    public void saveSection(Section section) {
        EntityTransaction s = EntityManagerHelper.getEntityManager().getTransaction();

        s.begin();
        EntityManagerHelper.getEntityManager().persist(section);
        s.commit();
    }
    public List<Section> getAllSectionsDao() {
        String query = "select s from Section as s";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSection1() {
        String query = "select s from Section as s where s.name='À faire B'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSectionsSansTableauDao() {
        String query = "select s from Section as s where s.tableau is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSectionsNameLong6() {
        String query = "select s from Section as s " +
                "where LENGTH(s.name) = 6";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getSectionASC() {
        String query = "select s from Section as s ORDER BY s.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(10)
                .getResultList();
    }
    public List<Section> getSectionDESC() {
            String query = "select s from Section as s ORDER BY s.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(10)
                .getResultList();
    }

    public List<Section> getAllSectionsNative() {
        String query = "select * from Section ";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Section.class).getResultList();
    }
    public List<Section> getAllSectionParam(String name) {
        String query = "select t from Section as t join t.fiches as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class)
                .setParameter("name", name).getResultList();
    }

}
*/