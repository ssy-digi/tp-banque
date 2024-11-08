package fr.digi.m062024.ihm;

import fr.digi.m062024.bo.*;
import fr.digi.m062024.dal.PersistenceManager;
import jakarta.persistence.*;
import org.mariadb.jdbc.util.StringUtils;

import java.util.List;

public class App {
    public static void main(String[] args) {



        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        EntityManagerFactory emf2 = PersistenceManager.getEntityManagerFactory();
       /* Client client = new Client("Toto", "Titi");


        //Création de la banque
        Banque banque = new Banque("BNP");

        client.setBanque(banque);
        banque.ajouterClient(client);

        //Création de deux clients
        Client clientA = new Client("SYLLA", "Séga", LocalDate.now(), new Adresse(11, "rue de la soif", "44980", "Sainte Luce"), banque);
//        banque.getClients().add(clientA); => Devient obsolète avec la
//        em.persist(clientA);
        Client clientB = new Client("SYLLA", "Maryam", LocalDate.now(), new Adresse(11, "rue de la soif", "44980", "Sainte Luce"), banque);
//        banque.getClients().add(clientB);
//        em.persist(clientB);

        Client client1 = em.find(Client.class, client.getId());
        em.persist(banque);
        //Création des comptes
        System.out.println(banque.getClients());*/


        //Création d'un compte courant
        Compte compteJoint = new LivretA("CLI123456", 1000.0, 3.5);
        Client sega = em.find(Client.class, 3);
        Client nenette = em.find(Client.class, 2);
        compteJoint.ajouterClient(sega);
        compteJoint.ajouterClient(nenette);
        em.persist(compteJoint);

        //Sélection des clients qui habitent Nantes
        TypedQuery<Banque> query = em.createQuery("select b from Banque b join b.clients c where c.adresse.codePostal = 'Nantes'", Banque.class);
        List<Banque> banquesQuiOntDesClientsANtes = query.getResultList();

        System.out.println(banquesQuiOntDesClientsANtes);


        Query removeQuery = em.createQuery("delete from Client where nom = :nom");
        removeQuery.setParameter("nom", "toto");
        removeQuery.executeUpdate();

        em.getTransaction().commit();
        em.close();
        emf.close();

        try(EntityManager em2 = PersistenceManager.getEntityManagerFactory().createEntityManager()) {

        }
    }
}