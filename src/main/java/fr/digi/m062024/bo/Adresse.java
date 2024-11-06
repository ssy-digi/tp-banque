package fr.digi.m062024.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    @Column(name = "NUM")
    private int numero;
    @Column(name = "RUE", length = 100)
    private String rue;
    @Column(name = "VILLE", length = 100)
    private String ville;
    @Column(name = "CODE_POSTAL")
    private String codePostal;

    public Adresse() {
    }

    public Adresse(int numero, String rue, String ville, String codePostal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Adresse{");
        sb.append("numero=").append(numero);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
