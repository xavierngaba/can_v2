package personnel;

/**
 *
 * @author XAVIER
 */
public class Entraineur extends Personnel {

  private int id;

  private String nationalite;

  private String statut;
  
  public Entraineur(){
     super();
  }
/**
 * Constructeur par initialisation de la classe Entraineur
 * @param id l'id de l'entraineur
 * @param nom le nom de l'entraineur
 * @param prenom le prénom de l'entraineur
 * @param dateNaiss la date de naissance de l'entraineur
 * @param nationalite la nationalité de l'entraineur
 * @param statut la position de l'entraineur (principal,adjoint) 
 */
  public Entraineur(int id,String nom,String prenom,String dateNaiss,String nationalite,String statut){
      super(nom, prenom, dateNaiss);
      this.id = id;
      this.nationalite = nationalite;
      this.statut = statut;
  }
  
  /**
   * méthode permettant de retourner l'id d'un entraineur
   * @return int l'id d'un entraineur
   */
  public int getId() {
  return id;
  }

  /**
   * méthode permettant de retourner la nationalité d'un entraineur
   * @return String la nationalité de l'entraineur 
   */
  public String getNationalite() {
  return nationalite;
  }

  /**
   * méthode permettant de retourner le statut d'un entraineur
   * @return String le statut d'un entraineur
   */
  public String getStatut(){
      return statut;
  }
  
  /**
   * méthode permettant de modifier la nationalité d'un entraineur
   * @param nationalite  chaine de caractère designant la nationalité de l'entraineur
   */
  public void setNationalite(String nationalite) {
      this.nationalite = nationalite;
  }

  /**
   * méthode permettant de modifier la nationalité d'un entraineur
   * @param statut chaine de caractère designant le statut de l'entraineur 
   */
    public void setStatut(String statut) {
        this.statut = statut;
    }

}
