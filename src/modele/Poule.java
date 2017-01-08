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
@Table(name = "poule")
@NamedQueries({
    @NamedQuery(name = "Poule.findAll", query = "SELECT p FROM Poule p"),
    @NamedQuery(name = "Poule.findByIdpoule", query = "SELECT p FROM Poule p WHERE p.idpoule = :idpoule"),
    @NamedQuery(name = "Poule.findByIdedition", query = "SELECT p FROM Poule p WHERE p.idedition.idedition = :idedition"),
    @NamedQuery(name = "Poule.findByNom", query = "SELECT p FROM Poule p WHERE p.nom = :nom")})
public class Poule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpoule")
    private long idpoule;
    @Column(name = "nom")
    private Character nom;
    @JoinColumn(name = "idedition", referencedColumnName = "idedition")
    @ManyToOne
    private Edition idedition;
    @OneToMany(mappedBy = "idpoule")
    private List<Equipe> listEquipe;
    @OneToMany(mappedBy = "idpoule")
    private List<Matchs> matchsList;

    public Poule() {
    }

    public Poule(Character nom, Edition idedition) {
        this.nom = nom;
        this.idedition = idedition;
    }

    public long getIdpoule() {
        return idpoule;
    }

    public void setIdpoule(long idpoule) {
        this.idpoule = idpoule;
    }

    public Character getNom() {
        return nom;
    }

    public void setNom(Character nom) {
        this.nom = nom;
    }

    public Edition getIdedition() {
        return idedition;
    }

    public void setIdedition(Edition idedition) {
        this.idedition = idedition;
    }

    public List<Equipe> getEquipeList() {
        return listEquipe;
    }

    public void setEquipeList(List<Equipe> equipeList) {
        this.listEquipe = equipeList;
    }

    public List<Matchs> getMatchsList() {
        return matchsList;
    }

    public void setMatchsList(List<Matchs> matchsList) {
        this.matchsList = matchsList;
    }
    public List<Equipe> rang() {
        
        if (((listEquipe.get(0).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(1).getBm()))
                && ((listEquipe.get(0).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(2).getBm()))
                && ((listEquipe.get(0).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(3).getBm()))) {
            listEquipe.get(0).setRg(1);
            listEquipe.get(0).setQuart(true);
            if (((listEquipe.get(1).getPts() > listEquipe.get(2).getPts() ) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(2).getBm()))
                    && ((listEquipe.get(1).getPts() > listEquipe.get(3).getPts() ) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(1).setRg(2);
                listEquipe.get(1).setQuart(true);
                if (((listEquipe.get(2).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                }
            } else if (((listEquipe.get(2).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(1).getBm()))
                    && ((listEquipe.get(2).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(2).setRg(2);
                listEquipe.get(2).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                }
            } else if (((listEquipe.get(3).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(1).getBm()))
                    && ((listEquipe.get(3).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(2).getBm()))) {
                listEquipe.get(3).setRg(2);
                listEquipe.get(3).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                } else if (((listEquipe.get(2).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                }
            }
        } else if (((listEquipe.get(1).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(0).getBm()))
                && ((listEquipe.get(1).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(2).getBm()))
                && ((listEquipe.get(1).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(3).getBm()))) {
            listEquipe.get(1).setRg(1);
            listEquipe.get(1).setQuart(true);
            if (((listEquipe.get(0).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(2).getBm()))
                   && ((listEquipe.get(0).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(0).setRg(2);
                listEquipe.get(0).setQuart(true);
                if (((listEquipe.get(2).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                }
            } else if (((listEquipe.get(2).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(0).getBm()))
                    && ((listEquipe.get(2).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(2).setRg(2);
                listEquipe.get(2).setQuart(true);
                if (((listEquipe.get(0).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                }
            } else if (((listEquipe.get(3).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(0).getBm()))
                    && ((listEquipe.get(3).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(2).getBm()))) {
                listEquipe.get(3).setRg(2);
                listEquipe.get(3).setQuart(true);
                if (((listEquipe.get(0).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                } else if (((listEquipe.get(2).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                }
            }
        } else if (((listEquipe.get(2).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(1).getBm()))
                && ((listEquipe.get(2).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(0).getBm()))
                && ((listEquipe.get(2).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(3).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(3).getBm()))) {
            listEquipe.get(2).setRg(1);
            listEquipe.get(2).setQuart(true);
            if (((listEquipe.get(1).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(0).getBm()))
                    && ((listEquipe.get(1).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(1).setRg(2);
                listEquipe.get(1).setQuart(true);
                if (((listEquipe.get(0).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                }
            } else if (((listEquipe.get(0).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(1).getBm()))
                    && ((listEquipe.get(0).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(3).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(3).getBm()))) {
                listEquipe.get(0).setRg(2);
                listEquipe.get(0).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(3).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(3).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(3).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(3).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(3).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(3).setRg(4);
                    listEquipe.get(3).setQuart(false);
                } else if (((listEquipe.get(3).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(3).setRg(3);
                    listEquipe.get(3).setQuart(false);
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                }
            } else if (((listEquipe.get(3).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(0).getBm()))
                    && ((listEquipe.get(3).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(1).getBm()))) {
                listEquipe.get(3).setRg(2);
                listEquipe.get(3).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                } else if (((listEquipe.get(0).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                }
            }
        } else if (((listEquipe.get(3).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(1).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(1).getBm()))
                && ((listEquipe.get(3).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(0).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(0).getBm()))
                && ((listEquipe.get(3).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(3).getPts() == listEquipe.get(2).getPts() && listEquipe.get(3).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(3).getBm() > listEquipe.get(2).getBm()))) {
            listEquipe.get(3).setRg(1);
            listEquipe.get(3).setQuart(true);
            if (((listEquipe.get(1).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(2).getBm()))
                    && ((listEquipe.get(1).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(0).getBm()))) {
                listEquipe.get(1).setRg(2);
                listEquipe.get(1).setQuart(true);
                if (((listEquipe.get(2).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                } else if (((listEquipe.get(0).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                }
            } else if (((listEquipe.get(2).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(1).getBm()))
                    && ((listEquipe.get(2).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(0).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(0).getBm()))) {
                listEquipe.get(2).setRg(2);
                listEquipe.get(2).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(0).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(0).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(0).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(0).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(0).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(0).setRg(4);
                    listEquipe.get(0).setQuart(false);
                } else if (((listEquipe.get(0).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(0).setRg(3);
                    listEquipe.get(0).setQuart(false);
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                }
            } else if (((listEquipe.get(0).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(1).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(1).getBm()))
                    && ((listEquipe.get(0).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(0).getPts() == listEquipe.get(2).getPts() && listEquipe.get(0).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(0).getBm() > listEquipe.get(2).getBm()))) {
                listEquipe.get(0).setRg(2);
                listEquipe.get(0).setQuart(true);
                if (((listEquipe.get(1).getPts() > listEquipe.get(2).getPts()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() > listEquipe.get(2).getDiff()) || (listEquipe.get(1).getPts() == listEquipe.get(2).getPts() && listEquipe.get(1).getDiff() == listEquipe.get(2).getDiff() && listEquipe.get(1).getBm() > listEquipe.get(2).getBm()))) {
                    listEquipe.get(1).setRg(3);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(2).setRg(4);
                    listEquipe.get(2).setQuart(false);
                } else if (((listEquipe.get(2).getPts() > listEquipe.get(1).getPts()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() > listEquipe.get(1).getDiff()) || (listEquipe.get(2).getPts() == listEquipe.get(1).getPts() && listEquipe.get(2).getDiff() == listEquipe.get(1).getDiff() && listEquipe.get(2).getBm() > listEquipe.get(1).getBm()))) {
                    listEquipe.get(1).setRg(4);
                    listEquipe.get(1).setQuart(false);
                    listEquipe.get(2).setRg(3);
                    listEquipe.get(2).setQuart(false);
                }
            }
        }
        return listEquipe;
    }
}
