/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author XAVIER
 */
@Entity
@Table(name = "entraineur")
@NamedQueries({
    @NamedQuery(name = "Entraineur.findAll", query = "SELECT e FROM Entraineur e"),
    @NamedQuery(name = "Entraineur.findByIdentraineur", query = "SELECT e FROM Entraineur e WHERE e.identraineur = :identraineur"),
    @NamedQuery(name = "Entraineur.findByNomEnt", query = "SELECT e FROM Entraineur e WHERE e.nomEnt = :nomEnt"),
    @NamedQuery(name = "Entraineur.findByPrenomEnt", query = "SELECT e FROM Entraineur e WHERE e.prenomEnt = :prenomEnt"),
    @NamedQuery(name = "Entraineur.findByNationalite", query = "SELECT e FROM Entraineur e WHERE e.nationalite = :nationalite"),
    @NamedQuery(name = "Entraineur.findByStatutEnt", query = "SELECT e FROM Entraineur e WHERE e.statutEnt = :statutEnt")})
public class Entraineur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identraineur")
    private long identraineur;
    @Column(name = "nom_ent")
    private String nomEnt;
    @Column(name = "prenom_ent")
    private String prenomEnt;
    @Column(name = "nationalite")
    private String nationalite;
    @Column(name = "statut_ent")
    private String statutEnt;
    @JoinColumn(name = "idequipe", referencedColumnName = "idequipe")
    @ManyToOne
    private Equipe idequipe;

    public Entraineur() {
    }

    public Entraineur(String nomEnt, String prenomEnt, String nationalite, String statutEnt, Equipe idequipe) {
        this.nomEnt = nomEnt;
        this.prenomEnt = prenomEnt;
        this.nationalite = nationalite;
        this.statutEnt = statutEnt;
        this.idequipe = idequipe;
    }

    public long getIdentraineur() {
        return identraineur;
    }

    public void setIdentraineur(long identraineur) {
        this.identraineur = identraineur;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public void setNomEnt(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public String getPrenomEnt() {
        return prenomEnt;
    }

    public void setPrenomEnt(String prenomEnt) {
        this.prenomEnt = prenomEnt;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getStatutEnt() {
        return statutEnt;
    }

    public void setStatutEnt(String statutEnt) {
        this.statutEnt = statutEnt;
    }

    public Equipe getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Equipe idequipe) {
        this.idequipe = idequipe;
    }
}
