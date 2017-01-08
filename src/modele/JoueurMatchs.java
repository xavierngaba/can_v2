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
@Table(name = "joueur_matchs")
@NamedQueries({
    @NamedQuery(name = "JoueurMatchs.findAll", query = "SELECT j FROM JoueurMatchs j"),
    @NamedQuery(name = "JoueurMatchs.findByIdjoueur", query = "SELECT j FROM JoueurMatchs j WHERE j.joueurMatchsPK.idjoueur = :idjoueur"),
    @NamedQuery(name = "JoueurMatchs.findByIdmatchs", query = "SELECT j FROM JoueurMatchs j WHERE j.joueurMatchsPK.idmatchs = :idmatchs"),
    @NamedQuery(name = "JoueurMatchs.findByNbut", query = "SELECT j FROM JoueurMatchs j WHERE j.nbut = :nbut")})
public class JoueurMatchs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JoueurMatchsPK joueurMatchsPK;
    @Basic(optional = false)
    @Column(name = "nbut")
    private int nbut;
    @JoinColumn(name = "idmatchs", referencedColumnName = "idmatchs", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matchs matchs;
    @JoinColumn(name = "idjoueur", referencedColumnName = "idjoueur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joueur joueur;

    public JoueurMatchs() {
    }

    public JoueurMatchs(JoueurMatchsPK joueurMatchsPK) {
        this.joueurMatchsPK = joueurMatchsPK;
    }

    public JoueurMatchs(JoueurMatchsPK joueurMatchsPK, int nbut) {
        this.joueurMatchsPK = joueurMatchsPK;
        this.nbut = nbut;
    }

    public JoueurMatchs(int idjoueur, int idmatchs) {
        this.joueurMatchsPK = new JoueurMatchsPK(idjoueur, idmatchs);
    }

    public JoueurMatchsPK getJoueurMatchsPK() {
        return joueurMatchsPK;
    }

    public void setJoueurMatchsPK(JoueurMatchsPK joueurMatchsPK) {
        this.joueurMatchsPK = joueurMatchsPK;
    }

    public int getNbut() {
        return nbut;
    }

    public void setNbut(int nbut) {
        this.nbut = nbut;
    }

    public Matchs getMatchs() {
        return matchs;
    }

    public void setMatchs(Matchs matchs) {
        this.matchs = matchs;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
