package personnel;

/**
 *
 * @author GROUPE 2
 */
public abstract class Personnel {

  private String nom;

  private String prenom;

  private String dateNaiss;

  public Personnel(){}
  
  /**
   * constructeur par initialisation de la classe Personnel
   * @param nom - le nom d'une personne
   * @param prenom - le prénom d'une personne 
   * @param dateNaiss - la date de naissance d'une personne 
   */
  public Personnel(String nom,String prenom,String dateNaiss){
      this.nom = nom;
      this.prenom = prenom;
      this.dateNaiss = dateNaiss;
  }
  
  /**
   * méthode pour retourner le nom d'un personnel
   * @return String - le nom d'une personne
   */
  public String getNom() {
  return nom;
  }

  /**
   * méthode pour retourner le prénom d'un personnel
   * @return String - le prénom d'une personne
   */
  public String getPrenom() {
  return prenom;
  }

  /**
   * méthode pour retourner la date de naissance d'un personnel
   * @return String - la date de naissance d'une personne
   */
  public String getDateNaiss() {
  return dateNaiss;
  }

  /**
   * méthode permettant de modifier le nom d'un personnel
   * @param nom une chaine de caractère
   */
  public void setNom(String nom) {
      this.nom = nom;
  }

  /**
   * méthode permettant de modifier le prénom d'un personnel
   * @param prenom une chaine de caractère
   */
  public void setPrenom(String prenom) {
      this.prenom = prenom;
  }

  /**
   * méthode permettant de modifier la date de naissance d'un personnel
   * @param dateNaiss une chaine de caractère
   */
  public void setDateNaiss(String dateNaiss) {
      this.dateNaiss = dateNaiss;
  }

}
