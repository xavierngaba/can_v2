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
@Table(name = "edition")
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e"),
    @NamedQuery(name = "Edition.findMaxIdedition", query = "SELECT max(e.idedition) FROM Edition e"),
    @NamedQuery(name = "Edition.findByIdedition", query = "SELECT e FROM Edition e WHERE e.idedition = :idedition"),
    @NamedQuery(name = "Edition.findByAnnee", query = "SELECT e FROM Edition e WHERE e.annee = :annee"),
    @NamedQuery(name = "Edition.findByPaysorg", query = "SELECT e FROM Edition e WHERE e.paysorg = :paysorg")})
public class Edition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idedition")
    private long idedition;
    @Column(name = "annee")
    private String annee;
    @Column(name = "paysorg")
    private String paysorg;
    @JoinTable(name = "participer", joinColumns = {
        @JoinColumn(name = "idedition", referencedColumnName = "idedition")}, inverseJoinColumns = {
        @JoinColumn(name = "idequipe", referencedColumnName = "idequipe")})
    @ManyToMany
    private List<Equipe> equipeList;
    @OneToMany(mappedBy = "idedition")
    private List<Quart> quartList;
    @OneToMany(mappedBy = "idedition")
    private List<Pfinale> pfinaleList;
    @OneToMany(mappedBy = "idedition")
    private List<Poule> pouleList;
    @OneToMany(mappedBy = "idedition")
    private List<Finale> finaleList;
    @OneToMany(mappedBy = "idedition")
    private List<Demi> demiList;

    public Edition() {
    }

    public Edition(String annee, String paysorg) {
        this.annee = annee;
        this.paysorg = paysorg;
    }

    public long getIdedition() {
        return idedition;
    }

    public void setIdedition(long idedition) {
        this.idedition = idedition;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getPaysorg() {
        return paysorg;
    }

    public void setPaysorg(String paysorg) {
        this.paysorg = paysorg;
    }

    public List<Equipe> getEquipeList() {
        return equipeList;
    }

    public void setEquipeList(List<Equipe> equipeList) {
        this.equipeList = equipeList;
    }

    public List<Quart> getQuartList() {
        return quartList;
    }

    public void setQuartList(List<Quart> quartList) {
        this.quartList = quartList;
    }

    public List<Pfinale> getPfinaleList() {
        return pfinaleList;
    }

    public void setPfinaleList(List<Pfinale> pfinaleList) {
        this.pfinaleList = pfinaleList;
    }

    public List<Poule> getPouleList() {
        return pouleList;
    }

    public void setPouleList(List<Poule> pouleList) {
        this.pouleList = pouleList;
    }

    public List<Finale> getFinaleList() {
        return finaleList;
    }

    public void setFinaleList(List<Finale> finaleList) {
        this.finaleList = finaleList;
    }

    public List<Demi> getDemiList() {
        return demiList;
    }

    public void setDemiList(List<Demi> demiList) {
        this.demiList = demiList;
    }
}
