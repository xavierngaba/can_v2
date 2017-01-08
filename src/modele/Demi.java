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
@Table(name = "demi")
@NamedQueries({
    @NamedQuery(name = "Demi.findAll", query = "SELECT d FROM Demi d"),
    @NamedQuery(name = "Demi.findByIddemi", query = "SELECT d FROM Demi d WHERE d.iddemi = :iddemi")})
public class Demi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddemi")
    private long iddemi;
    @Column(name = "libelled")
    private String libelled;
    @JoinColumn(name = "idedition", referencedColumnName = "idedition")
    @ManyToOne
    private Edition idedition;
    @OneToMany(mappedBy = "iddemi")
    private List<Matchs> matchsList;

    public Demi() {
    }

    public Demi(int id, String libelle, Edition idedition) {
        this.iddemi = id;
        this.libelled = libelle;
        this.idedition = idedition;
    }

    public long getIddemi() {
        return iddemi;
    }

    public void setIddemi(long iddemi) {
        this.iddemi = iddemi;
    }

    public String getLibelled() {
        return libelled;
    }

    public void setLibelled(String libelled) {
        this.libelled = libelled;
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
