package finale;

import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author XAVIER
 */
public class Finale {

  private int id ;

  private String libelle ;

  private ArrayList<Equipe> listEquipe ;
  
  private int idedition;
  
  public Finale(){
      
  }

  /**
   * Constructeur par initialisation de la classe Finale
   * @param id
   * @param libelle
   * @param listEquipe 
   */
    public Finale(int id, String libelle, ArrayList<Equipe> listEquipe) {
        this.id = id;
        this.libelle = libelle;
        this.listEquipe = listEquipe;
    }

    /**
     * Constructeur par initialisation de la classe Finale
     * @param id
     * @param libelle 
     */
  public Finale(int id, String libelle){
      this.id = id;
      this.libelle = libelle;
  }

  /**
   * 
   * @param id
   * @param libelle
   * @param idedition 
   */
    public Finale(int id, String libelle, int idedition) {
        this.id = id;
        this.libelle = libelle;
        this.idedition = idedition;
    }
  
  
  /**
   * méthode permettant de retourner l'id d'un match 
   * de final
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
   * méthode permettant de retourner le libellé d'un match 
   * de final
   * @return String 
   */
  public String getLibelle() {
  return libelle;
  }

  /**
     * méthode permettant de modifier la liste des équipes 
     * qui joueront le match de final 
     * @param listEquipe 
     */
    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    }

    /**
   * méthode permettant de retourner les équipes qui 
   * joueront le match de final
   * @return ArrayList<Equipe>
   */
    public ArrayList<Equipe> getListEquipe() {
        return listEquipe;
    }
}
