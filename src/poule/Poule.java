package poule;

import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author GROUPE 2
 */
public class Poule {

    private int id;

    private String nom;

    private ArrayList<Equipe> listEquipe;
    
    private int idedition;

    public Poule() {
    }

    /**
     * Constructeur par initialisation de la classe poule
     * @param id int désignant l'id d'une poule 
     * @param nom  String désignant le nom de la poule 
     */
    public Poule(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Constructeur par initialisation de la classe poule
     * @param id int désignant l'id d'une poule
     * @param nom String désignant le nom de la poule
     * @param listEquipe ArrayList désignant la liste des équipes d'une poule
     */
    public Poule(int id, String nom, ArrayList<Equipe> listEquipe) {
        this.id = id;
        this.nom = nom;
        this.listEquipe = listEquipe;
    }

    /**
     * 
     * @param id
     * @param nom
     * @param idedition 
     */
    public Poule(int id, String nom, int idedition) {
        this.id = id;
        this.nom = nom;
        this.idedition = idedition;
    }

    
    /**
     * méthode permettant de retourner l'id d'une poule 
     * @return int l'id d'une poule
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @return 
     */
    public int getIdedition() {
        return idedition;
    }

    /**
     * méthode permettant de modifier l'id d'une poule
     * @param id int désignant l'id d'une poule
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @param idedition 
     */
    public void setIdedition(int idedition) {
        this.idedition = idedition;
    }
    
    /**
     * méthode permettant de modifier le nom d'une poule
     * @param nom String désignant le nom d'une poule
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * méthode permettant de retourner le nom d'une poule
     * @return String le nom d'une poule 
     */
    public String getNom() {
        return nom;
    }

    /**
     * méthode retournant la liste des équipes d'une poule
     * @return ArrayList<Equipe> la liste des équipes d'une poule
     */
    public ArrayList<Equipe> getListEquipe() {
        return listEquipe;
    }

    /**
     * méthode permettant de modifier la liste des équipes d'une poule
     * @param listEquipe ArrayList désignant la liste des équipes d'une poule
     */
    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    }

    //Methode propre à la classe Poule
    
    /**
     * méthode permettant de retourner le classement d'une poule 
     * @return ArrayList<Equipe> la liste des équipes d'une poule 
     */
    public ArrayList<Equipe>  rang() {
        
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
