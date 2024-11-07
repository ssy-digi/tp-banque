package fr.digi.m062024.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
public class Virement extends Operation {

    @Column(name = "BENEFICIAIRE", nullable = false)
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Virement{");
        sb.append("beneficiaire='").append(beneficiaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
