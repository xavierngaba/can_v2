/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author XAVIER
 */
@Entity
@Table(name = "equipe")
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdpoule", query = "SELECT e FROM Equipe e WHERE e.idpoule.idpoule = :idpoule"),
    @NamedQuery(name = "Equipe.findByIdpouleOrderRg", query = "SELECT e FROM Equipe e WHERE e.idpoule.idpoule = :idpoule ORDER BY e.rg"),
    @NamedQuery(name = "Equipe.findByIdequipe", query = "SELECT e FROM Equipe e WHERE e.idequipe = :idequipe"),
    @NamedQuery(name = "Equipe.findByNomEq", query = "SELECT e FROM Equipe e WHERE e.nomEq = :nomEq"),
    @NamedQuery(name = "Equipe.findByRg", query = "SELECT e FROM Equipe e WHERE e.rg = :rg"),
    @NamedQuery(name = "Equipe.findByJr", query = "SELECT e FROM Equipe e WHERE e.jr = :jr"),
    @NamedQuery(name = "Equipe.findByG", query = "SELECT e FROM Equipe e WHERE e.g = :g"),
    @NamedQuery(name = "Equipe.findByN", query = "SELECT e FROM Equipe e WHERE e.n = :n"),
    @NamedQuery(name = "Equipe.findByP", query = "SELECT e FROM Equipe e WHERE e.p = :p"),
    @NamedQuery(name = "Equipe.findByBm", query = "SELECT e FROM Equipe e WHERE e.bm = :bm"),
    @NamedQuery(name = "Equipe.findByBe", query = "SELECT e FROM Equipe e WHERE e.be = :be"),
    @NamedQuery(name = "Equipe.findByDiff", query = "SELECT e FROM Equipe e WHERE e.diff = :diff"),
    @NamedQuery(name = "Equipe.findByPts", query = "SELECT e FROM Equipe e WHERE e.pts = :pts"),
    @NamedQuery(name = "Equipe.findByNbpar", query = "SELECT e FROM Equipe e WHERE e.nbpar = :nbpar"),
    @NamedQuery(name = "Equipe.findByQuart", query = "SELECT e FROM Equipe e WHERE e.quart = :quart"),
    @NamedQuery(name = "Equipe.findByDemi", query = "SELECT e FROM Equipe e WHERE e.demi = :demi"),
    @NamedQuery(name = "Equipe.findByPfinale", query = "SELECT e FROM Equipe e WHERE e.pfinale = :pfinale"),
    @NamedQuery(name = "Equipe.findByFinale", query = "SELECT e FROM Equipe e WHERE e.finale = :finale"),
    @NamedQuery(name = "Equipe.findByVainqueur", query = "SELECT e FROM Equipe e WHERE e.vainqueur = :vainqueur")})
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipe")
    private long idequipe;
    @Column(name = "nom_eq")
    private String nomEq;
    @Column(name = "rg")
    private int rg;
    @Column(name = "jr")
    private int jr;
    @Column(name = "g")
    private int g;
    @Column(name = "n")
    private int n;
    @Column(name = "p")
    private int p;
    @Column(name = "bm")
    private int bm;
    @Column(name = "be")
    private int be;
    @Column(name = "diff")
    private int diff;
    @Column(name = "pts")
    private int pts;
    @Column(name = "nbpar")
    private int nbpar;
    @Column(name = "quart")
    private boolean quart;
    @Column(name = "demi")
    private boolean demi;
    @Column(name = "pfinale")
    private boolean pfinale;
    @Column(name = "finale")
    private boolean finale;
    @Column(name = "vainqueur")
    private boolean vainqueur;
    @ManyToMany(mappedBy = "equipeList")
    private List<Edition> editionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe")
    private List<EquipeMatchs> equipeMatchsList;
    @JoinColumn(name = "idpoule", referencedColumnName = "idpoule")
    @ManyToOne
    private Poule idpoule;
    @OneToMany(mappedBy = "idequipe")
    private List<Entraineur> entraineurList;
    @OneToMany(mappedBy = "idequipe")
    private List<Joueur> joueurList;
    @OneToMany(mappedBy = "idequipe")
    private List<Administration> administrationList;

    public Equipe() {
    }

    public Equipe(String nomEq, int rg, int jr, int g, int n, int p, int bm, int be, int diff, int pts, int nbpar, boolean quart, boolean demi, boolean pfinale, boolean finale, boolean vainqueur, Poule idpoule) {
        this.nomEq = nomEq;
        this.rg = rg;
        this.jr = jr;
        this.g = g;
        this.n = n;
        this.p = p;
        this.bm = bm;
        this.be = be;
        this.diff = diff;
        this.pts = pts;
        this.nbpar = nbpar;
        this.quart = quart;
        this.demi = demi;
        this.pfinale = pfinale;
        this.finale = finale;
        this.vainqueur = vainqueur;
        this.idpoule = idpoule;
    }

    public long getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(long idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomEq() {
        return nomEq;
    }

    public void setNomEq(String nomEq) {
        this.nomEq = nomEq;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getJr() {
        return jr;
    }

    public void setJr(int jr) {
        this.jr = jr;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public Integer getBm() {
        return bm;
    }

    public void setBm(int bm) {
        this.bm = bm;
    }

    public int getBe() {
        return be;
    }

    public void setBe(int be) {
        this.be = be;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getNbpar() {
        return nbpar;
    }

    public void setNbpar(int nbpar) {
        this.nbpar = nbpar;
    }

    public boolean getQuart() {
        return quart;
    }

    public void setQuart(Boolean quart) {
        this.quart = quart;
    }

    public boolean getDemi() {
        return demi;
    }

    public void setDemi(boolean demi) {
        this.demi = demi;
    }

    public boolean getPfinale() {
        return pfinale;
    }

    public void setPfinale(boolean pfinale) {
        this.pfinale = pfinale;
    }

    public boolean getFinale() {
        return finale;
    }

    public void setFinale(boolean finale) {
        this.finale = finale;
    }

    public boolean getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(boolean vainqueur) {
        this.vainqueur = vainqueur;
    }

    public List<Edition> getEditionList() {
        return editionList;
    }

    public void setEditionList(List<Edition> editionList) {
        this.editionList = editionList;
    }

    public List<EquipeMatchs> getEquipeMatchsList() {
        return equipeMatchsList;
    }

    public void setEquipeMatchsList(List<EquipeMatchs> equipeMatchsList) {
        this.equipeMatchsList = equipeMatchsList;
    }

    public Poule getIdpoule() {
        return idpoule;
    }

    public void setIdpoule(Poule idpoule) {
        this.idpoule = idpoule;
    }

    public List<Entraineur> getEntraineurList() {
        return entraineurList;
    }

    public void setEntraineurList(List<Entraineur> entraineurList) {
        this.entraineurList = entraineurList;
    }

    public List<Joueur> getJoueurList() {
        return joueurList;
    }

    public void setJoueurList(List<Joueur> joueurList) {
        this.joueurList = joueurList;
    }

    public List<Administration> getAdministrationList() {
        return administrationList;
    }

    public void setAdministrationList(List<Administration> administrationList) {
        this.administrationList = administrationList;
    }
    
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
