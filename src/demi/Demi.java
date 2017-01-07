package demi;

import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author GROUPE 2
 */
public class Demi {

  private int id ;

  private String libelle ;
  
  private ArrayList<Equipe> listEquipe ;
  
  private int idedition;

 public Demi(){}

 /**
  * Constructeur par initialisation de la classe Demi
  * @param id
  * @param libelle 
  */
 public Demi(int id,String libelle){
     this.id = id;
     this.libelle = libelle;
 }

 /**
  * Constructeur par initialisation de la classe Demi
  * @param id
  * @param libelle
  * @param listEquipe 
  */
    public Demi(int id, String libelle, ArrayList<Equipe> listEquipe) {
        this.id = id;
        this.libelle = libelle;
        this.listEquipe = listEquipe;
    }

    /**
     * 
     * @param id
     * @param libelle
     * @param idedition 
     */
    public Demi(int id, String libelle, int idedition) {
        this.id = id;
        this.libelle = libelle;
        this.idedition = idedition;
    }
 
    
    /**
     * méthode permettant de retourner l'id d'une 
     * demi finale
     * @return int
     */
  public int getId() {
  return id;
  }

  /**
   * méthode permettant de retourner l'id d'une édition
   * @return int
   */
    public int getIdedition() {
        return idedition;
    }

  
  /**
   * méthode permettant de retourner le libellé 
   * d'une demi finale
   * @return int 
   */
  public String getLibelle() {
  return libelle;
  }

  /** 
   * méthode permettant de retourner les équipes qualifiées 
   * pour un match de demi final
   * @return ArrayList<Equipe>
   */
    public ArrayList<Equipe> getListEquipe() {
        return listEquipe;
    }

    /**
     * méthode permettant de modifier la liste des équipes 
     * qualifiées pour les matchs de demi-fifnal
     * @param listEquipe 
     */
    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    }
}
