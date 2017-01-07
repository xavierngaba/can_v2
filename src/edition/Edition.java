package edition;

import equipe.Equipe;
import java.util.ArrayList;

/**
 *
 * @author XAVIER
 */
public class Edition {

  private int id;
  
  private String annee ;

  private String paysOrg ;
  
  private ArrayList<Equipe> listEquipe;
  
 public Edition(){
     
 }
 
 public Edition(int id,String annee,String paysOrg){
     this.id = id;
     this.annee = annee;
     this.paysOrg = paysOrg;
 }

    public Edition(int id, String annee, String paysOrg, ArrayList<Equipe> listEquipe) {
        this.id = id;
        this.annee = annee;
        this.paysOrg = paysOrg;
        this.listEquipe = listEquipe;
    }
  
  public int getId() {
    return id;
  }

  public String getAnnee() {
  return annee;
  }

  public String getPaysOrg() {
  return paysOrg;
  }
  
  public void setAnnee(String annee) {
      this.annee = annee;
  }

  public void setPaysOrg(String paysOrg) {
      this.paysOrg = paysOrg;
  }

    public ArrayList<Equipe> getListEquipe() {
        return listEquipe;
    }

    public void setListEquipe(ArrayList<Equipe> listEquipe) {
        this.listEquipe = listEquipe;
    }

    public void setId(int id) {
        this.id = id;
    }

}
