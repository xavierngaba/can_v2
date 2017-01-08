/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author XAVIER
 */
@Entity
@Table(name = "joueur")
@NamedQueries({
    @NamedQuery(name = "Joueur.findAll", query = "SELECT j FROM Joueur j"),
    @NamedQuery(name = "Joueur.findAllByIdequipeByIdedition", query = "SELECT j FROM Joueur j WHERE j.idequipe.idequipe = :idequipe AND j.idequipe.idpoule.idedition.idedition = :idedition"),
    @NamedQuery(name = "Joueur.findAllButeur", query = "SELECT j FROM Joueur j WHERE j.idequipe.idpoule.idedition.idedition = :idedition AND j.butc > 0  ORDER BY j.butc DESC"),
    @NamedQuery(name = "Joueur.findByIdjoueur", query = "SELECT j FROM Joueur j WHERE j.idjoueur = :idjoueur"),
    @NamedQuery(name = "Joueur.findByNomJ", query = "SELECT j FROM Joueur j WHERE j.nomJ = :nomJ"),
    @NamedQuery(name = "Joueur.findByPrenomJ", query = "SELECT j FROM Joueur j WHERE j.prenomJ = :prenomJ"),
    @NamedQuery(name = "Joueur.findByDateNaiss", query = "SELECT j FROM Joueur j WHERE j.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Joueur.findByPoste", query = "SELECT j FROM Joueur j WHERE j.poste = :poste"),
    @NamedQuery(name = "Joueur.findByDossard", query = "SELECT j FROM Joueur j WHERE j.dossard = :dossard"),
    @NamedQuery(name = "Joueur.findByButc", query = "SELECT j FROM Joueur j WHERE j.butc = :butc"),
    @NamedQuery(name = "Joueur.findByButt", query = "SELECT j FROM Joueur j WHERE j.butt = :butt")})
public class Joueur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjoueur")
    private long idjoueur;
    @Column(name = "nom_j")
    private String nomJ;
    @Column(name = "prenom_j")
    private String prenomJ;
    @Column(name = "date_naiss")
    private String dateNaiss;
    @Column(name = "poste")
    private String poste;
    @Column(name = "dossard")
    private int dossard;
    @Column(name = "butc")
    private int butc;
    @Column(name = "butt")
    private int butt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joueur")
    private List<JoueurMatchs> joueurMatchsList;
    @JoinColumn(name = "idequipe", referencedColumnName = "idequipe")
    @ManyToOne
    private Equipe idequipe;

    public Joueur() {
    }

    public Joueur(String nomJ, String prenomJ, String dateNaiss, String poste, int dossard, int butc, int butt, List<JoueurMatchs> joueurMatchsList, Equipe idequipe) {
        this.nomJ = nomJ;
        this.prenomJ = prenomJ;
        this.dateNaiss = dateNaiss;
        this.poste = poste;
        this.dossard = dossard;
        this.butc = butc;
        this.butt = butt;
        this.joueurMatchsList = joueurMatchsList;
        this.idequipe = idequipe;
    }

    public long getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(long idjoueur) {
        this.idjoueur = idjoueur;
    }

    public String getNomJ() {
        return nomJ;
    }

    public void setNomJ(String nomJ) {
        this.nomJ = nomJ;
    }

    public String getPrenomJ() {
        return prenomJ;
    }

    public void setPrenomJ(String prenomJ) {
        this.prenomJ = prenomJ;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getDossard() {
        return dossard;
    }

    public void setDossard(int dossard) {
        this.dossard = dossard;
    }

    public int getButc() {
        return butc;
    }

    public void setButc(int butc) {
        this.butc = butc;
    }

    public int getButt() {
        return butt;
    }

    public void setButt(int butt) {
        this.butt = butt;
    }

    public List<JoueurMatchs> getJoueurMatchsList() {
        return joueurMatchsList;
    }

    public void setJoueurMatchsList(List<JoueurMatchs> joueurMatchsList) {
        this.joueurMatchsList = joueurMatchsList;
    }

    public Equipe getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Equipe idequipe) {
        this.idequipe = idequipe;
    }
}
