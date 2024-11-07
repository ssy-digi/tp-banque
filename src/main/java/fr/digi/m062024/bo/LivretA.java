package fr.digi.m062024.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {

    @Column(name = "TAUX")
    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LivretA{");
        sb.append("taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
