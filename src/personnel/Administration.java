package personnel;

/**
 *
 * @author GROUPE 2
 */
public class Administration extends Personnel {

  private int id;

  private String statut;

  public Administration(){
     super();
  }

  /**
   * Constructeur par initialisation de la classe Administration
   * @param id entier désignant l'id d'un membre de l'administration
   * @param nom chaine de caractère désignant le nom d'un membre de l'administration
   * @param prenom chaine de caractère désignant le prénom d'un membre de l'administration
   * @param dateNaiss chaine de caractère désignant la date de naissance d'un membre de l'administration
   * @param statut chaine de caractère désignant le statut d'un membre de l'administration
   */
  public Administration(int id,String nom,String prenom,String dateNaiss,String statut){
      super(nom, prenom, dateNaiss);
      this.id = id;
      this.statut = statut;
  }
  
  /**
   * méthode permettant de retourner l'id d'un membre de l'administration
   * @return int l'id d'un membre de l'administration 
   */
  public int getId() {
  return id;
  }

  /**
   * méthode peremettant de retourner le statut d'un membre de l'administration
   * @return String chaine de caractère désignant le statut d'un membre de l'administration
   */
  public String getstatut() {
  return statut;
  }

  /**
   * méthode peremettant de modifier le statut d'un membre de l'administration
   * @param statut chaine de caractère désignant le statut d'un membre de l'administration
   */
  public void setStatut(String statut){ 
        this.statut = statut;  
  }

}