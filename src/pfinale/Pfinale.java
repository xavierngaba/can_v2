package pfinale;

/**
 *
 * @author XAVIER
 */
import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author XAVIER
 */
public class Pfinale {

  private int id ;

  private String libelle ;

  private ArrayList<Equipe> listEquipe ;
  
  private int idedition;
  
  public Pfinale(){
      
  }

  /**
   * Constructeur par initialisation de la classe Pfinale
   * @param id
   * @param libelle
   * @param listEquipe 
   */
    public Pfinale(int id, String libelle, ArrayList<Equipe> listEquipe) {
        this.id = id;
        this.libelle = libelle;
        this.listEquipe = listEquipe;
    }

    /**
     * Constructeur par initialisation de la classe Pfinale
     * @param id
     * @param libelle 
     */
  public Pfinale(int id, String libelle){
      this.id = id;
      this.libelle = libelle;
  }

  /**
   * 
   * @param id
   * @param libelle
   * @param idedition 
   */
    public Pfinale(int id, String libelle, int idedition) {
        this.id = id;
        this.libelle = libelle;
        this.idedition = idedition;
    }
 
  
  /**
   * méthode permettant de retourner l'id d'un match 
   * de 3e place
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
   * de 3e place
   * @return String 
   */
  public String getLibelle() {
  return libelle;
  }

  /**
   * méthode permettant de retourner les équipes qui 
   * joueront le match de 3e place
   * @return ArrayList<Equipe>
   */
    public ArrayList<Equipe> getListEquipe() {
        return listEquipe;
    }

    /**
     * méthode permettant de modifier la liste des équipes 
     * qui joueront le match de 3e place 
     * @param listEquipe 
     */
    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    }
}
