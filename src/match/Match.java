package match;

/**
 *
 * @author Groupe 2
 */
public class Match {

  private int id ;

  private String lieu ;

  private String arbitre ;

  private boolean jouer ;
  
  private String date ;
 
  public Match(){
      
  }
  
  /**
   * Constructeur par initialisation de la classe Match
   * @param id int désignant l'id d'un match
   * @param lieu String désignant le lieu d'un match
   * @param arbitre String désignant le nom et le prénom d'un arbitre
   * @param date String désignant la date d'un match
   * @param jouer boolean indiquant si le match est joué ou non
   */
  public Match(int id,String lieu,String arbitre,String date,boolean jouer){
      this.id = id;
      this.lieu = lieu;
      this.arbitre = arbitre;
      this.date = date;
      this.jouer = jouer;
  }
  
  /**
   * méthode permettant l'id d'un match
   * @return int l'id d'un match
   */
  public int getId(){
      return id;
  }
  
  /**
   * méthode permettant de modifier l'id d'un match
   * @param id int désignant l'id d'un match
   */
  public void setId(int id){
      this.id = id;
  }
  
  /**
   * méthode permettant de retourner le lieu d'un match
   * @return String le lieu d'un match
   */
  public String getLieu(){
      return lieu;
  }

  /**
   * méthode permettant modifier le lieu d'un match
   * @param lieu String désignant le lieu d'un match
   */
  public void setLieu(String lieu) {
      this.lieu = lieu;
  }

  /**
   * méthode permettant de retourner l'arbitre 
   * d'un match
   * @return String  le nom et le prénom de l'arbitre d'un match
   */
  public String getArbitre(){
      return arbitre;
  }
  
  /**
   * méthode permettant de modifier l'arbitre d'un match
   * @param arbitre String désignant le nom et le prénom d'un arbitre
   */
  public void setArbitre(String arbitre) {
      this.arbitre = arbitre;
  }

  /**
   * méthode permettant de retourner l'indicateur d'un match joué
   * @return boolean indicateur si le match est joué ou non
   */
  public boolean getJouer(){
      return jouer;
  }
  
  /**
   * méthode permettant de modidier l'indicateur d'un match joué
   * @param jouer boolean indiquant si le match est joué ou non
   */
  public void setJouer(boolean jouer) {
      this.jouer = jouer;
  }

  /**
   * méthode permettant de retourner la date d'un match
   * @return String la date d'un match
   */
  public String getDate(){
      return date;
  }

  /**
   * méthode permettant de modifier la date d'un match
   * @param date String désignant la date d'un match
   */
  public void setDate(String date){
      this.date = date;
  }
}
