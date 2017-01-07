package personnel;

/**
 *
 * @author groupe 2
 */
public class Joueur extends Personnel {

  private int id;

  private String poste;

  private int dossard;

  private int butsC;

  private int butsT;
  
  private int idequipe;
  
  public Joueur(){
      super();
  }
  
  /**
   * Constructeur par initialisation de la classe Joueur
   * @param id un entier désignant l'id d'un joueur
   * @param nom une chaine de caractère désignant le nom d'un joueur
   * @param prenom une chaine de caractère désignant le prénom d'un joueur
   * @param dateNaiss une chaine de caractère désignant la date de naissance d'un joueur
   * @param poste une chaine de caractère désignant le poste d'un joueur
   * @param dossard un entier désignant le dossard d'un joueur
   * @param butsC un entier désignant le nombre de but marqué lors d'une édition par un joueur
   * @param butsT un entier désignant le nombre total de but marqué lors de toutes les éditions des CAN par un joueur
   */
  public Joueur(int id,String nom,String prenom,String dateNaiss,String poste,int dossard,int butsC,int butsT){
      super(nom, prenom, dateNaiss);
      this.id = id;
      this.poste = poste;
      this.dossard = dossard;
      this.butsC = butsC;
      this.butsT = butsT;
  }

  /**
   * Constructeur par initialisation de la classe Joueur
   * @param id un entier désignant l'id d'un joueur
   * @param poste une chaine de caractère désignant le poste d'un joueur
   * @param dossard un entier désignant le dossard d'un joueur
   * @param butsC un entier désignant le nombre de but marqué lors d'une édition par un joueur
   * @param butsT un entier désignant le nombre total de but marqué lors de toutes les éditions des CAN par un joueur
   * @param idequipe un entier désignant l'id de l'équipe d'un joueur
   * @param nom une chaine de caractère désignant le nom d'un joueur
   * @param prenom une chaine de caractère désignant le prénom d'un joueur
   * @param dateNaiss une chaine de caractère désignant la date de naissance d'un joueur 
   */
    public Joueur(int id, String poste, int dossard, int butsC, int butsT, int idequipe, String nom, String prenom, String dateNaiss) {
        super(nom, prenom, dateNaiss);
        this.id = id;
        this.poste = poste;
        this.dossard = dossard;
        this.butsC = butsC;
        this.butsT = butsT;
        this.idequipe = idequipe;
    }

 
  
  /**
   * méthode permettant de retourner l'id d'un joueur
   * @return int l'id d'un joueur
   */
  public int getId() {
  return id;
  }

  /**
   * méthode permettant de retourner le poste d'un joueur
   * @return String le poste d'un joueur
   */
  public String getPoste() {
  return poste;
  }

  /**
   * méthode permettant de retourner le dossard d'un joueur
   * @return int  le dossard d'un joueur
   */
  public int getDossard() {
  return dossard;
  }

  /**
   * méthode permettant de retourner le nombre de but
   * réalisé par un joueur lors pendant une édition
   * @return int le nombre de but marqué par un joueur lors d'une édition
   */
  public int getButsC() {
  return butsC;
  }

  /**
   * méthode permettant de retourner le nombre de but
   * total réalisé par un joueur pendant toutes les 
   * éditions de la CAN
   * @return int le nombre de but marqué par un joueur lors de toute les éditions de la CAN
   */
  public int getButsT() {
  return butsT;
  }

  /**
   * méthode permettant de retourner l'id de l'équipe d'un joueur
   * @return int l'id de l'équipe d'un joueur
   */
    public int getIdequipe() {
        return idequipe;
    }

    /**
     * méthode de modifier l'id de l'équipe d'un joueur
     * @param idequipe int désignant l'id de l'équipe d'un joueur
     */
    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

  
    
  /**
   * méthode permettant de modifier le poste d'un joueur
   * @param poste String désignant le poste d'un joueur
   */
  public void setPoste(String poste) {
      this.poste = poste;
  }

  /**
   * méthode permettant d'attribuer un but à un joueur 
   * lors d'une édition de la CAN
   * @param butsC int désignant le nombre de but marqué par un joueur lors d'une édition
   */
  public void setButsC(int butsC) {
      this.butsC = this.butsC + butsC;
  }

  /**
   * méthode permettant d'augmenter le nombre de but 
   * total d'un joueur dans toute les éditions de la CAN
   * @param butsT int désignant le nombre de but marqué par un joueur lors de toute les éditions de la CAN 
   */
  public void setButsT(int butsT) {
      this.butsT = this.butsT + butsT;
  }

  /**
   * méthode permettant de modidifer le dossard d'un joueur 
   * lors de l'édition d'une CAN
   * @param dossard int désignant le dossard d'un joueur 
   */
    public void setDossard(int dossard) {
        this.dossard = dossard;
    }

}
