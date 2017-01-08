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
@Table(name = "matchs")
@NamedQueries({
    @NamedQuery(name = "Matchs.findAll", query = "SELECT m FROM Matchs m"),
    @NamedQuery(name = "Matchs.findByIdmatchs", query = "SELECT m FROM Matchs m WHERE m.idmatchs = :idmatchs"),
    @NamedQuery(name = "Matchs.findMatchsByPoule", query = "SELECT m FROM Matchs m WHERE m.idpoule.idpoule = :idpoule"),
    @NamedQuery(name = "Matchs.findMatchsByQuart", query = "SELECT m FROM Matchs m WHERE m.idquart.idquart = :idquart"),
    @NamedQuery(name = "Matchs.findMatchsByDemi", query = "SELECT m FROM Matchs m WHERE m.iddemi.iddemi = :iddemi"),
    @NamedQuery(name = "Matchs.findMatchsByPfinale", query = "SELECT m FROM Matchs m WHERE m.idpfinale.idpfinale = :idpfinale"),
    @NamedQuery(name = "Matchs.findMatchsByFinale", query = "SELECT m FROM Matchs m WHERE m.idfinale.idfinale = :idfinale"),
    @NamedQuery(name = "Matchs.findByLieu", query = "SELECT m FROM Matchs m WHERE m.lieu = :lieu"),
    @NamedQuery(name = "Matchs.findByArbitre", query = "SELECT m FROM Matchs m WHERE m.arbitre = :arbitre"),
    @NamedQuery(name = "Matchs.findByDatem", query = "SELECT m FROM Matchs m WHERE m.datem = :datem"),
    @NamedQuery(name = "Matchs.findByJoue", query = "SELECT m FROM Matchs m WHERE m.joue = :joue")})
public class Matchs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatchs")
    private long idmatchs;
    @Column(name = "lieu")
    private String lieu;
    @Column(name = "arbitre", length = 100)
    private String arbitre;
    @Column(name = "datem")
    private String datem;
    @Column(name = "joue")
    private boolean joue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchs")
    private List<JoueurMatchs> joueurMatchsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchs")
    private List<EquipeMatchs> equipeMatchsList;
    @JoinColumn(name = "idquart", referencedColumnName = "idquart")
    @ManyToOne
    private Quart idquart;
    @JoinColumn(name = "idpoule", referencedColumnName = "idpoule")
    @ManyToOne
    private Poule idpoule;
    @JoinColumn(name = "idpfinale", referencedColumnName = "idpfinale")
    @ManyToOne
    private Pfinale idpfinale;
    @JoinColumn(name = "idfinale", referencedColumnName = "idfinale")
    @ManyToOne
    private Finale idfinale;
    @JoinColumn(name = "iddemi", referencedColumnName = "iddemi")
    @ManyToOne
    private Demi iddemi;

    public Matchs() {
    }

    public Matchs(String lieu, String arbitre, String datem, boolean joue, Quart idquart, Poule idpoule, Pfinale idpfinale, Finale idfinale, Demi iddemi) {
        this.lieu = lieu;
        this.arbitre = arbitre;
        this.datem = datem;
        this.joue = joue;
        this.idquart = idquart;
        this.idpoule = idpoule;
        this.idpfinale = idpfinale;
        this.idfinale = idfinale;
        this.iddemi = iddemi;
    }

    public long getIdmatchs() {
        return idmatchs;
    }

    public void setIdmatchs(long idmatchs) {
        this.idmatchs = idmatchs;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getArbitre() {
        return arbitre;
    }

    public void setArbitre(String arbitre) {
        this.arbitre = arbitre;
    }

    public String getDatem() {
        return datem;
    }

    public void setDatem(String datem) {
        this.datem = datem;
    }

    public Boolean getJoue() {
        return joue;
    }

    public void setJoue(boolean joue) {
        this.joue = joue;
    }

    public List<JoueurMatchs> getJoueurMatchsList() {
        return joueurMatchsList;
    }

    public void setJoueurMatchsList(List<JoueurMatchs> joueurMatchsList) {
        this.joueurMatchsList = joueurMatchsList;
    }

    public List<EquipeMatchs> getEquipeMatchsList() {
        return equipeMatchsList;
    }

    public void setEquipeMatchsList(List<EquipeMatchs> equipeMatchsList) {
        this.equipeMatchsList = equipeMatchsList;
    }

    public Quart getIdquart() {
        return idquart;
    }

    public void setIdquart(Quart idquart) {
        this.idquart = idquart;
    }

    public Poule getIdpoule() {
        return idpoule;
    }

    public void setIdpoule(Poule idpoule) {
        this.idpoule = idpoule;
    }

    public Pfinale getIdpfinale() {
        return idpfinale;
    }

    public void setIdpfinale(Pfinale idpfinale) {
        this.idpfinale = idpfinale;
    }

    public Finale getIdfinale() {
        return idfinale;
    }

    public void setIdfinale(Finale idfinale) {
        this.idfinale = idfinale;
    }

    public Demi getIddemi() {
        return iddemi;
    }

    public void setIddemi(Demi iddemi) {
        this.iddemi = iddemi;
    } 
}
