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
@Table(name = "pfinale")
@NamedQueries({
    @NamedQuery(name = "Pfinale.findAll", query = "SELECT p FROM Pfinale p"),
    @NamedQuery(name = "Pfinale.findByIdpfinale", query = "SELECT p FROM Pfinale p WHERE p.idpfinale = :idpfinale")})
public class Pfinale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpfinale")
    private long idpfinale;
    @Lob
    @Column(name = "libellepf")
    private String libellepf;
    @JoinColumn(name = "idedition", referencedColumnName = "idedition")
    @ManyToOne
    private Edition idedition;
    @OneToMany(mappedBy = "idpfinale")
    private List<Matchs> matchsList;

    public Pfinale() {
    }

    public Pfinale(String libellepf, Edition idedition) {
        this.libellepf = libellepf;
        this.idedition = idedition;
    }
    
    public long getIdpfinale() {
        return idpfinale;
    }

    public void setIdpfinale(long idpfinale) {
        this.idpfinale = idpfinale;
    }

    public String getLibellepf() {
        return libellepf;
    }

    public void setLibellepf(String libellepf) {
        this.libellepf = libellepf;
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
