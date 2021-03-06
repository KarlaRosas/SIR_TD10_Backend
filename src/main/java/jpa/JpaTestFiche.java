package jpa;
import fr.istic.taa.jaxrs.domain.*;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class JpaTestFiche {

    private EntityManager manager;

    public JpaTestFiche(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
		/*EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();*/

        EntityManager manager = EntityManagerHelper.getEntityManager();
        JpaTestFiche test = new JpaTestFiche(manager);


        EntityTransaction tx = manager.getTransaction();


        tx.begin();
        try {
            test.createFiches();



        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listFiches();


        manager.close();
        System.out.println(".. done");
        EntityManagerHelper.closeEntityManagerFactory();
    }

    private void createFiches() {
        int numOfFiches = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (numOfFiches == 0) {
            Tableau tableau1 = new Tableau("Tableau Backend");
            Tableau tableau2 = new Tableau("Tableau Frontend");

            Section section1 = new Section("À faire B",tableau1);
            Section section2 = new Section("En processus B",tableau1);
            Section section3 = new Section("Taches finis  B ",tableau1);
            Section section4 = new Section("À faire F",tableau2);
            Section section5 = new Section("En processus F",tableau2);
            Section section6 = new Section("Taches finis  F ",tableau2 );
            //List<Fiche> fiches = new ArrayList<Fiche>();
            Fiche fiche1 = new Fiche("fiche1",section1,"https://www.univ-rennes1.fr/", "Bordeaux", "Faire TP1",60);
            Fiche fiche2 = new Fiche("fiche2",section2,"https://www.univ-rennes1.fr/", "Marseille", "Faire TP2",60);
            Fiche fiche3 = new Fiche("fiche3",section3,"https://www.univ-rennes1.fr/", "Lille", "Faire TP3",60);
            Fiche fiche4 = new Fiche("fiche1",section4,"https://www.univ-rennes1.fr/", "Strasbourg", "Faire TP4",60);
            Fiche fiche5 = new Fiche("fiche2",section5,"https://www.univ-rennes1.fr/", "Paris", "Faire TP5",60);
            Fiche fiche6 = new Fiche("fiche3",section6,"https://www.univ-rennes1.fr/", "Lyon", "Faire TP6",60);

            Tars tag1 = new Tars("Priority",fiche2);
            Tars tag2 = new Tars("Important",fiche5);

            Utilisateur utilisateur1 = new Utilisateur("Karla Rosas",fiche1);
            Utilisateur utilisateur2 = new Utilisateur("Rabeea Kessal",fiche4);
            Utilisateur utilisateur3 = new Utilisateur("Leo Varieras",fiche6);

            //fiches.add(fiche2);

            manager.persist(tableau1);
            manager.persist(tableau2);

            manager.persist(section1);
            manager.persist(section2);
            manager.persist(section3);
            manager.persist(section4);
            manager.persist(section5);
            manager.persist(section6);

            manager.persist(fiche1);
            manager.persist(fiche2);
            manager.persist(fiche3);
            manager.persist(fiche4);
            manager.persist(fiche5);
            manager.persist(fiche6);

            manager.persist(utilisateur1 );
            manager.persist(utilisateur2 );
            manager.persist(utilisateur3 );
            manager.persist(tag1);
            manager.persist(tag2);

/*          Autre forme d'ajouter les données dans BD
            manager.persist(new Fiche("Jakab Gipsz",section));
            manager.persist(new Fiche("Captain Nemo",section));
            manager.persist(new Fiche("Bon Toronja",section));
            manager.persist(new Fiche("Thibault Mich",section));
            manager.persist(new Utilisateur("user1",fiche));
            manager.persist(new Utilisateur("user2",fiche2));
            manager.persist(new Section("section1",tableau));
            manager.persist(new Section("section2",tableau2));
            manager.persist(new Tars("tars1", fiche));
            manager.persist(new Tars("tars2", fiche2));*/



        }
    }

    private void listFiches() {
        List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
        System.out.println("num of fiches:" + resultList.size());
        for (Fiche next : resultList) {
            System.out.println("next fiche: " + next);
        }
    }

    private void getFicheThibaultMich() {
        Fiche resultFiche = manager.createQuery("SELECT t from Fiche as t " + " where t.name='Thibault Mich'", Fiche.class).getSingleResult();
        System.out.println("La ficha es " + resultFiche);

    }

    private void listTableaux() {
        List<Tableau> resultList = manager.createQuery("Select a From Tableau a", Tableau.class).getResultList();
        System.out.println("num of fiches:" + resultList.size());
        for (Tableau next : resultList) {
            System.out.println("next Tableau: id=" + next.getId() +" Name: "+ next.getName()+" Sections: "+next.getSections());
        }
    }
}



