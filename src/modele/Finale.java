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
@Table(name = "finale")
@NamedQueries({
    @NamedQuery(name = "Finale.findAll", query = "SELECT f FROM Finale f"),
    @NamedQuery(name = "Finale.findByIdfinale", query = "SELECT f FROM Finale f WHERE f.idfinale = :idfinale")})
public class Finale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinale")
    private long idfinale;
    @Lob
    @Column(name = "libellef")
    private String libellef;
    @JoinColumn(name = "idedition", referencedColumnName = "idedition")
    @ManyToOne
    private Edition idedition;
    @OneToMany(mappedBy = "idfinale")
    private List<Matchs> matchsList;

    public Finale() {
    }

    public Finale(String libellef, Edition idedition) {
        this.libellef = libellef;
        this.idedition = idedition;
    }
    
    public long getIdfinale() {
        return idfinale;
    }

    public void setIdfinale(long idfinale) {
        this.idfinale = idfinale;
    }

    public String getLibellef() {
        return libellef;
    }

    public void setLibellef(String libellef) {
        this.libellef = libellef;
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
