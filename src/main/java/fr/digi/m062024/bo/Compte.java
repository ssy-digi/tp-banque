package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUM", length = 10, unique = true, nullable = false)
    private String numero;
    @Column(name = "SOLDE")
    private double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    {
        clients = new HashSet<>();
        operations = new HashSet<>();
    }

    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void ajouterClient(Client client) {
        if (client != null) {
            client.ajouterCompte(this);
        }
    }

    public void retirerClient(Client client) {
        if (client != null) {
            client.retirerCompte(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Compte{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Objects.equals(numero, compte.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
