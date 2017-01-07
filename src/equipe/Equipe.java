package equipe;

import java.util.ArrayList;
import personnel.Administration;
import personnel.Entraineur;
import personnel.Joueur;

/**
 *
 * @author groupe 2
 */
public class Equipe {

  // Les Attributs de la classe 
  private  int id ;

  private  String nom ;

  private int rg;

  private int jr ;

  private int g ;

  private int n ;

  private int p ;

  private int bm ;

  private int be ;

  private int diff ;

  private int pts ;

  private int nbPar ;

  private boolean quart ;

  private boolean demi ;
  
  private boolean pfinale ;

  private boolean finale ;

  private boolean vainqueur ;
  
  private ArrayList<Joueur> listJoueur ;
  
  private ArrayList<Entraineur> listEntraineur ;
  
  private ArrayList<Administration> listAdministration ;
  
  
  //le Constructeur par defaut de la classe Equipe
  public Equipe(){}
  
  
  /**
   * Constructeur par initialisation de la classe Equipe
   * @param id int
   * @param nom String
   * @param rg int
   * @param jr int
   * @param g int
   * @param n int
   * @param p int
   * @param bm int
   * @param be int
   * @param diff int
   * @param pts int
   * @param nbPar int
   * @param quart boolean
   * @param demi boolean
   * @param pfinale boolean
   * @param finale boolean
   * @param vainqueur  boolean
   */
  public Equipe(int id,String nom,int rg,int jr,int g,int n,int p,int bm,int be,int diff,int pts,int nbPar,boolean quart,boolean demi,boolean pfinale, boolean finale,boolean vainqueur){
      this.id = id;
      this.nom = nom;
      this.rg = rg;
      this.jr = jr;
      this.g = g;
      this.n = n;
      this.p = p;
      this.bm = bm;
      this.be = be;
      this.diff = diff;
      this.pts = pts;
      this.nbPar = nbPar;
      this.quart = quart;
      this.demi = demi;
      this.pfinale = finale;
      this.finale = finale;
      this.vainqueur = vainqueur;
  }

  /**
   * Constructeur par initialisation de la classe Equipe
   * @param id int
   * @param nom String
   * @param rg int
   * @param jr int
   * @param g int
   * @param n int
   * @param p int
   * @param bm int
   * @param be int
   * @param diff int
   * @param pts int
   * @param nbPar int
   * @param quart boolean
   * @param demi boolean
   * @param pfinale boolean
   * @param finale boolean
   * @param vainqueur boolean
   * @param listJoueur ArrayList<Joueur>
   * @param listEntraineur ArrayList<Entraineur>
   * @param listAdministration ArrayList<Administration>
   */
    public Equipe(int id, String nom, int rg, int jr, int g, int n, int p, int bm, int be, int diff, int pts, int nbPar, boolean quart, boolean demi, boolean pfinale, boolean finale, boolean vainqueur, ArrayList<Joueur> listJoueur, ArrayList<Entraineur> listEntraineur, ArrayList<Administration> listAdministration) {
        this.id = id;
        this.nom = nom;
        this.rg = rg;
        this.jr = jr;
        this.g = g;
        this.n = n;
        this.p = p;
        this.bm = bm;
        this.be = be;
        this.diff = diff;
        this.pts = pts;
        this.nbPar = nbPar;
        this.quart = quart;
        this.demi = demi;
        this.pfinale = pfinale;
        this.finale = finale;
        this.vainqueur = vainqueur;
        this.listJoueur = listJoueur;
        this.listEntraineur = listEntraineur;
        this.listAdministration = listAdministration;
    }
  
  
  
 /**
  * méthode permettant de retourner l'id d'une équipe
  * @return int  l'id d'une équipe
  */
  public int getId() {
  return id;
  }

  /**
   * méthode permettant de retourner le nom d'une équipe
   * @return int  le nom d'une équipe
   */
  public String getNom() {
  return nom;
  }

  /**
   * méthode permettant de retourner le rang d'une équipe
   * pendant les phases de poule
   * @return int  le rang d'une équipe
   */
  public int getRg() {
  return rg;
  }

  /**
   * méthode permettant de retourner la journée d'une équipe
   * pendant les phases de poule
   * @return int  la journée d'une équipe
   */
  public int getJr() {
  return jr;
  }

  /**
   * méthode permettant de retourner le nombre de match gagné d'une équipe
   * pendant une phase de poule
   * @return int  le nombre de match gagné d'une équipe
   */
  public int getG() {
  return g;
  }

  /** 
   * méthode permettant de retourner le nombre de match nul d'une équipe
   * pendant une phase de poule 
   * @return int  le nombre de match nul d'une équipe
   */
  public int getN() {
  return n;
  }

  /** 
   * méthode permettant de retourner le nombre de match perdu d'une équipe
   * pendant une phase de poule 
   * @return int  le nombre de match perdu d'une équipe
   */
  public int getP() {
  return p;
  }

  /** 
   * méthode permettant de retourner le nombre de but marqué par une équipe
   * pendant une phase de poule 
   * @return int  le nombre de but marqué par une équipe
   */
  public int getBm() {
  return bm;
  }

  /** 
   * méthode permettant de retourner le nombre de but encaissé par une équipe
   * pendant une phase de poule 
   * @return int  le nombre de but encaissé par une équipe
   */
  public int getBe() {
  return be;
  }

  /** 
   * méthode permettant de retourner la différence de but d'une équipe
   * pendant une phase de poule 
   * @return int  la différence de but d'une équipe
   */
  public int getDiff() {
  return diff;
  }

  /** 
   * méthode permettant de retourner le nombre de point d'une équipe
   * pendant une phase de poule 
   * @return int  le nombre de point d'une équipe
   */
  public int getPts() {
  return pts;
  }

  /** 
   * méthode permettant de retourner le nombre de participation d'une équipe
   * lors d'une édition de la CAN 
   * @return int  le nombre de participation d'une équipe
   */
  public int getNbPar() {
  return nbPar;
  }

  /** 
   * méthode permettant de retourner l'indicateur de qualification d'une équipe 
   * pour les quart de finale
   * @return boolean boolean - l'indicateur de qualification d'une équipe pour les quart de finale
   */
  public boolean getQuart() {
  return quart;
  }

  /** 
   * méthode permettant de retourner l'indicateur de qualification d'une équipe 
   * pour les demi de finale
   * @return boolean boolean  l'indicateur de qualification d'une équipe pour les demi de finale
   */
  public boolean getDemi() {
  return demi;
  }

  /** 
   * méthode permettant de retourner l'indicateur de qualification d'une équipe 
   * pour le match de 3e place de la CAN
   * @return boolean boolean   l'indicateur de qualification d'une équipe pour le match de 3e de place
   */
  public boolean getPfinale() {
  return pfinale;
  }
  
  /** 
   * méthode permettant de retourner l'indicateur de qualification d'une équipe 
   * pour la finale de la CAN
   * @return boolean boolean booléen - l'indicateur de qualification d'une équipe pour la finale
   */
  public boolean getFinale() {
  return finale;
  }

  /** 
   * méthode permettant de retourner un indicateur 
   * pour l'équipe qui remporte l'édition de la CAN
   * @return boolean booléen - l'indicateur de l'équipe ayant gagné la finale
   */
  public boolean getVainqueur() {
  return vainqueur;
  }
  
  /**
   * méthode permettant de retourner la liste des joueurs 
   * d'une équipe
   * @return ArrayList<Joueur> - la liste des joueurs d'une équipe
   */
  public ArrayList<Joueur> getListJoueur(){
      return listJoueur;
  }
  
  /**
   * méthode permettant de retourner la liste des entraineurs 
   * d'une équipe
   * @return ArrayList<Entraineur> - la liste des entraineurs d'une équipe
   */
  public ArrayList<Entraineur> getListEntraineur(){
      return listEntraineur;
  }
  
  /**
   * méthode permettant de retourner la liste du personnel administratif 
   * d'une équipe
   * @return ArrayList<Administration> - la liste du personnel administratif d'une équipe
   */
  public ArrayList<Administration> getListAdministration(){
      return listAdministration;
  }
  
  /**
   * méthode permettant de modifier le rang d'une équipe
   * pendant les phases de poule
   * @param rg int  le rang d'une équipe
   */
  public void setRg(int rg) {
      this.rg = rg;
  }

  /**
   * méthode permettant de modifier la journée d'une équipe
   * pendant les phases de poule
   * @param jr int  la journée d'une équipe
   */
  public void setJr(int jr) {
      this.jr = this.jr + jr;
  }

  /**
   * méthode permettant de modifier le nombre de victoire d'une équipe
   * pendant les phases de poule
   * @param g int  le nombre de victoire d'une équipe
   */
  public void setG(int g) {
      this.g = this.g + g;
  }

  /**
   * méthode permettant de modifier le nombre de match nul d'une équipe
   * pendant les phases de poule
   * @param n int  le nombre de match nul d'une équipe
   */
  public void setN(int n) {
      this.n = this.n + n;
  }

  /**
   * méthode permettant de modifier le nombre défaite d'une équipe
   * pendant les phases de poule
   * @param p int  le nombre défaite d'une équipe
   */
  public void setP(int p) {
      this.p = this.p + p;
  }

  /**
   * méthode permettant de modifier le nombre de but marqué par une équipe
   * pendant les phases de poule 
   * @param Bm int le nombre de but marqué par une équipe
   */
  public void setBm(int Bm) {
      this.bm = this.bm + Bm;
  }

  /**
   * méthode permettant de modifier le nombre de but encaissé par une équipe
   * pendant les phases de poule 
   * @param Be int  le nombre de but encaissé par une équipe
   */
  public void setBe(int Be) {
      this.be = this.be + Be;
  }

  /**
   * méthode permettant de modifier la différence de but d'une équipe
   * pendant les phases de poule
   * @param bm int  le nombre de but marqué par une équipe
   * @param be int  le nombre de but encaissé par une équipe
   */
  public void setDiff(int bm,int be) {
      this.diff = bm - be;
  }

  /**
   * méthode permettant de modifier le nombre de points d'une équipe
   * pendant les phases de poule
   * @param Pts int le nombre de point d'une équipe en phase de poule
   */
  public void setPts(int Pts) {
      this.pts = Pts;
  }

  /**
   * méthode permettant de modifier le nombre de participation d'une équipe
   * lors d'une édition de la CAN
   * @param NbPar int le nombre de participation d'une équipe lors d'une édition
   */
  public void setNbPar(int NbPar) {
      this.nbPar = this.nbPar + NbPar;
  }

  /**
   * méthode permettant de qualifier une équipe 
   * en quart de finale
   * @param quart boolean l'indicateur de l'équipe qualifiée pour les quart de final
   */
  public void setQuart(boolean quart){
      this.quart = quart;
  }

  /**
   * méthode permettant de qualifier une équipe 
   * en demi de finale
   * @param demi boolean l'indicateur de l'équipe qualifiée pour les demi de final
   */
  public void setDemi(boolean demi) {
      this.demi = demi;
  }

  /**
   * méthode permettant de qualifier une équipe 
   * au match de 3e de place
   * @param pfinale boolean l'indicateur de l'équipe qualifiée pour le match de 3e place
   */
  public void setPfinale(boolean pfinale) {
      this.pfinale = pfinale;
  }
  
  /**
   * méthode permettant de qualifier une équipe 
   * en finale
   * @param finale boolean l'indicateur de l'équipe qualifiée pour la finale
   */
  public void setFinale(boolean finale) {
      this.finale = finale;
  }

  /**
   * méthode permettant de designer le vainqueur
   * d'une édition de la CAN
   * @param vainqueur boolean l'indicateur de l'équipe qui remporte une édition de la CAN
   */
  public void setVainqueur(boolean vainqueur) {
      this.vainqueur = vainqueur;
  }
  
  /**
   * méthode permettant d'attribuer à une équipe  
   * une liste des membres du personnel administratif 
   * @param listAdministration ArrayList<Administration> la liste des membres de l'administration d'une équipe 
   */
  public void setListAdministration(ArrayList<Administration> listAdministration) {
        this.listAdministration = listAdministration;
    }

  /**
   * méthode permettant de modifier l'id d'une équipe
   * @param id int désignant l'id d'une équipe
   */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * méthode permettant d'attribuer à une équipe  
     * une liste des joueurs
     * @param listJoueur ArrayList<Joueur> la liste des joueurs d'une équipe
     */
    public void setListJoueur(ArrayList<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }

    /**
     * méthode permettant d'attribuer à une équipe  
     * une liste des Entraineurs
     * @param listEntraineur ArrayList<Entraineur> la liste des Entraineurs d'une équipe
     */
    public void setListEntraineur(ArrayList<Entraineur> listEntraineur) {
        this.listEntraineur = listEntraineur;
    }
  
  //Methode propre à la Classe Equipe
    
    /**
     * méthode permettant de calculer automatiquement les points d'une équipe
     * @param jr int désignant le nombre de match joué par une équipe
     * @param g int désignant le nombre de match gagné par une équipe
     * @param p int désignant le nombre de match perdu par une équipe
     * @param n int désignant le nombre de match nul par une équipe
     * @return int le nombre point d'une équipe
     */
  public int calculPts(int jr,int g,int p,int n){
      int pt = 0;
      
      if((jr >= 0) && (jr <= 3)){
          pt = (3 * g) + (1 * n) + (0 * p);
      }
    return pt;
  }  
}