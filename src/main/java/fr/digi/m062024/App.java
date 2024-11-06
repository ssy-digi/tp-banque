package fr.digi.m062024;

import fr.digi.m062024.bo.Adresse;
import fr.digi.m062024.bo.Banque;
import fr.digi.m062024.bo.Client;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

       /* Client client = new Client("Toto", "Titi");


        //Création de la banque
        Banque banque = new Banque("BNP");
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
    }
}