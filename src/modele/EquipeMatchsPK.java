/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author XAVIER
 */
@Embeddable
public class EquipeMatchsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idequipe")
    private int idequipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatchs")
    private int idmatchs;

    public EquipeMatchsPK() {
    }

    public EquipeMatchsPK(int idequipe, int idmatchs) {
        this.idequipe = idequipe;
        this.idmatchs = idmatchs;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public int getIdmatchs() {
        return idmatchs;
    }

    public void setIdmatchs(int idmatchs) {
        this.idmatchs = idmatchs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idequipe;
        hash += (int) idmatchs;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipeMatchsPK)) {
            return false;
        }
        EquipeMatchsPK other = (EquipeMatchsPK) object;
        if (this.idequipe != other.idequipe) {
            return false;
        }
        if (this.idmatchs != other.idmatchs) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EquipeMatchsPK[ idequipe=" + idequipe + ", idmatchs=" + idmatchs + " ]";
    }
    
}
