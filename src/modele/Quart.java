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
@Table(name = "quart")
@NamedQueries({
    @NamedQuery(name = "Quart.findAll", query = "SELECT q FROM Quart q"),
    @NamedQuery(name = "Quart.findByIdquart", query = "SELECT q FROM Quart q WHERE q.idquart = :idquart")})
public class Quart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquart")
    private long idquart;
    @Lob
    @Column(name = "libelle")
    private String libelle;
    @JoinColumn(name = "idedition", referencedColumnName = "idedition")
    @ManyToOne
    private Edition idedition;
    @OneToMany(mappedBy = "idquart")
    private List<Matchs> matchsList;

    public Quart() {
    }

    public Quart(String libelle, Edition idedition) {
        this.libelle = libelle;
        this.idedition = idedition;
    }

    public long getIdquart() {
        return idquart;
    }

    public void setIdquart(long idquart) {
        this.idquart = idquart;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Edition getIdedition() {
        return idedition;
    }

    public void setIdedition(Edition idedition) {
        this.idedition = idedition;
    }

    public List<Matchs> getMatchsList() {
        return matchsList;
    }

    public void setMatchsList(List<Matchs> matchsList) {
        this.matchsList = matchsList;
    }    
}
