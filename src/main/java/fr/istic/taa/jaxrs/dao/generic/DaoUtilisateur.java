package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Utilisateur;

import java.util.List;

public class DaoUtilisateur{

    public Utilisateur save(Utilisateur b ){
        EntityManagerHelper.beginTransaction();
        if (b.getId() != 0) {
            EntityManagerHelper.getEntityManager().merge(b);

        } else {
            EntityManagerHelper.getEntityManager().persist(b);

        }
        EntityManagerHelper.commit();
        return b;

    }

    public Utilisateur findById(long id) {
        return EntityManagerHelper.getEntityManager().find(Utilisateur.class, id);

    }

    public List<Utilisateur> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select b from Utilisateur as b", Utilisateur.class)
                .getResultList();
    }

    public List<Utilisateur> UtilisateurAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class)
                .getResultList();
    }

}
