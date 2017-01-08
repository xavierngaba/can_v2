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
@Table(name = "administration")
@NamedQueries({
    @NamedQuery(name = "Administration.findAll", query = "SELECT a FROM Administration a"),
    @NamedQuery(name = "Administration.findByIdadmin", query = "SELECT a FROM Administration a WHERE a.idadmin = :idadmin"),
    @NamedQuery(name = "Administration.findByNomAdmin", query = "SELECT a FROM Administration a WHERE a.nomAdmin = :nomAdmin"),
    @NamedQuery(name = "Administration.findByPrenomAdmin", query = "SELECT a FROM Administration a WHERE a.prenomAdmin = :prenomAdmin"),
    @NamedQuery(name = "Administration.findByStatut", query = "SELECT a FROM Administration a WHERE a.statut = :statut")})
public class Administration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadmin")
    private long idadmin;
    @Column(name = "nom_admin")
    private String nomAdmin;
    @Column(name = "prenom_admin")
    private String prenomAdmin;
    @Column(name = "statut")
    private String statut;
    @JoinColumn(name = "idequipe", referencedColumnName = "idequipe")
    @ManyToOne
    private Equipe idequipe;

    public Administration() {
    }

    public Administration(String nomAdmin, String prenomAdmin, String statut, Equipe idequipe) {
        this.nomAdmin = nomAdmin;
        this.prenomAdmin = prenomAdmin;
        this.statut = statut;
        this.idequipe = idequipe;
    }

    public long getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(long idadmin) {
        this.idadmin = idadmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Equipe getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Equipe idequipe) {
        this.idequipe = idequipe;
    }  
}
