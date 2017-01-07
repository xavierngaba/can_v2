package quart;

import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author Groupe 2
 */
public class Quart {

  private int id ;

  private String libelle ;
  
  private ArrayList<Equipe> listEquipe ;
  
  private int idedition;
  
  public Quart(){}

  /**
   * constructeur par initialisation de la classe Quart
   * @param id
   * @param libelle 
   */
  public Quart(int id,String libelle){
      this.id = id;
      this.libelle = libelle;
  }

  /**
   * Constructeur par initialisation de la classe quart
   * @param id
   * @param libelle
   * @param listEquipe 
   */
    public Quart(int id, String libelle, ArrayList<Equipe> listEquipe) {
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
    public Quart(int id, String libelle, int idedition) {
        this.id = id;
        this.libelle = libelle;
        this.idedition = idedition;
    }
  
    
    /**
     * méthode permettant de retourner l'id d'un match de quart
     * @return int
     */
  public int id() {
    return id;
  }

  /**
   * méthode permettant de retourner l'id de l'édition 
   * @return int
   */
    public int getIdedition() {
        return idedition;
    }
  /**
   * méthode permettant de retourner le libelle d'un quart-final
   * @return String
   */
  public String getLibelle() {
  return libelle;
  }

  /**
   * méthode permettant de retourner la liste des équipes qualifiées 
   * pour chaque quart de finale
   * @return ArrayList<Equipe>
   */
  public ArrayList<Equipe> getListEquipe(){
      return listEquipe;
  }
/**
 * méthode permettant de modifier la liste des équipes 
 * qualifiées pour chaque quart de finale
 * @param listEquipe 
 */
    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    } 
}
