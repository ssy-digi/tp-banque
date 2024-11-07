package fr.digi.m062024.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {

    @Column(name = "DATE_FIN", nullable = false)
    private LocalDate date;
    @Column(name = "TX")
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, double solde, LocalDate date, double taux) {
        super(numero, solde);
        this.date = date;
        this.taux = taux;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AssuranceVie{");
        sb.append("date=").append(date);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
