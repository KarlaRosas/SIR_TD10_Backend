package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Utilisateur;

import java.util.List;

public class DaoUtilisateur extends GenericDaoJpaImpl<Utilisateur, String> {

    public List<Utilisateur> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.name = :name", Utilisateur.class)
                .setParameter("name", name).getResultList();

    }


    public List<Utilisateur> findByFirstname(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.name = :name", Utilisateur.class)
                .setParameter("name", name).getResultList();

    }


    public List<Utilisateur> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class)
                .getResultList();
    }


}
