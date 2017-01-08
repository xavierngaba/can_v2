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
@Table(name = "equipe_matchs")
@NamedQueries({
    @NamedQuery(name = "EquipeMatchs.findAll", query = "SELECT e FROM EquipeMatchs e"),
    @NamedQuery(name = "EquipeMatchs.findByIdequipe", query = "SELECT e FROM EquipeMatchs e WHERE e.equipeMatchsPK.idequipe = :idequipe"),
    @NamedQuery(name = "EquipeMatchs.findByIdmatchs", query = "SELECT e FROM EquipeMatchs e WHERE e.equipeMatchsPK.idmatchs = :idmatchs"),
    @NamedQuery(name = "EquipeMatchs.findScoreByIdequipeIdmatch", query = "SELECT e.score  FROM EquipeMatchs e WHERE e.equipeMatchsPK.idequipe = :idequipe AND e.equipeMatchsPK.idmatchs = :idmatchs")})
public class EquipeMatchs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipeMatchsPK equipeMatchsPK;
    @Column(name = "score")
    private int score;
    @JoinColumn(name = "idmatchs", referencedColumnName = "idmatchs", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matchs matchs;
    @JoinColumn(name = "idequipe", referencedColumnName = "idequipe", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipe equipe;

    public EquipeMatchs() {
    }

    public EquipeMatchs(EquipeMatchsPK equipeMatchsPK) {
        this.equipeMatchsPK = equipeMatchsPK;
    }

    public EquipeMatchs(int idequipe, int idmatchs,int score) {
        this.equipeMatchsPK = new EquipeMatchsPK(idequipe, idmatchs);
        this.score = score;
    }

    public EquipeMatchsPK getEquipeMatchsPK() {
        return equipeMatchsPK;
    }

    public void setEquipeMatchsPK(EquipeMatchsPK equipeMatchsPK) {
        this.equipeMatchsPK = equipeMatchsPK;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Matchs getMatchs() {
        return matchs;
    }

    public void setMatchs(Matchs matchs) {
        this.matchs = matchs;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    } 
}
