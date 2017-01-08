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
@Embeddable
public class JoueurMatchsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idjoueur")
    private long idjoueur;
    @Basic(optional = false)
    @Column(name = "idmatchs")
    private long idmatchs;

    public JoueurMatchsPK() {
    }

    public JoueurMatchsPK(int idjoueur, int idmatchs) {
        this.idjoueur = idjoueur;
        this.idmatchs = idmatchs;
    }

    public long getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(long idjoueur) {
        this.idjoueur = idjoueur;
    }

    public long getIdmatchs() {
        return idmatchs;
    }

    public void setIdmatchs(long idmatchs) {
        this.idmatchs = idmatchs;
    } 
}
