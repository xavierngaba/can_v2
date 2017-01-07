package coucheDAO;

import ConnectionDB.ConnectionDB;
import edition.Edition;
import equipe.Equipe;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EquipeDAO{
  protected Connection connect;
	
        /**
         * méthode DAO permettant la connexion de l'application à la base 
         * de donnée
         * @throws SQLException 
         */
	public EquipeDAO() throws SQLException{
	 this.connect = ConnectionDB.getConnexion();
	}
    
        /**
         * méthode DAO permettant de créer une équipe nationale dans une 
         * édition de la CAN
         * @param pays String désignant le nom d'une équipe nationale
         * @param idpoule int désignant l'id d'une poule
         * @param idEdition int désignant l'id d'une édition
         * @return Equipe objet de classe Equipe
         */
	public Equipe creer(String pays,int idpoule, int idEdition){
            Equipe equipe = new Equipe();
            String select = "SELECT count(`nom_eq`) as nbpar FROM `equipe` WHERE `nom_eq`= '"+pays+"'";
            String selectEq = "SELECT max(`idequipe`) as lastId FROM `equipe`";
            int count = 0;
            int id = 0;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    count = res.getInt("nbpar");
                }
                state.executeUpdate("INSERT INTO `equipe`(`nom_eq`,`jr`, `g`, `n`, `p`, `bm`, `be`, `diff`, `pts`,`nbpar`, `quart`, `demi`, `pfinale`, `finale`, `vainqueur`, `idpoule`) "+
                           "VALUES ('"+pays+"',0,0,0,0,0,0,0,0,"+(count + 1)+",0,0,0,0,0,"+idpoule+")");
                
                res = state.executeQuery(selectEq);
                while(res.next()){
                    id = res.getInt("lastId");
                }
                state.executeUpdate("INSERT INTO `participer`(`idequipe`,`idedition`) VALUES ("+id+","+idEdition+")");
                res = state.executeQuery("SELECT * FROM `equipe` WHERE `idequipe` ="+id);
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return equipe;
	}
        
        /**
         * méthode DAO permettant de chercher une équipe
         * @param idEquipe int désignant l'id d'une équipe
         * @return Equipe objet de classe Equipe
         */
        public Equipe cherche(int idEquipe){
            Equipe Equipe = new Equipe();
            String query = "SELECT * FROM `equipe` WHERE `idequipe` ="+idEquipe;
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                while(res.next()){
                   Equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                  }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return Equipe;
        }
        
        /**
         * méthode DAO permettant de chercher les équipes 
         * en fonction de leurs poules respectives 
         * et de l'édition en cours
         * @param idpoule int désignant l'id d'une poule
         * @param idEdition int désignant l'id d'une édition
         * @return ArrayList<Equipe> la liste des équipes d'une poule lors d'une édition
         */
        public ArrayList<Equipe> chercher(int idpoule, int idEdition){
            ArrayList<Equipe> listEquipe = new ArrayList<>();
            String query = "SELECT * FROM `equipe` WHERE `idpoule` = (SELECT `idpoule` FROM `poule` WHERE `idpoule` = "+idpoule+" AND `idedition` = "+idEdition+") order by rg";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                while(res.next()){
                   listEquipe.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                  }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return listEquipe;
        }
        
        /**
         * méthode DAO permettant de chercher toutes les équipes 
         * qui participent à une édition
         * @param idEdition int désignant l'id d'une édition
         * @return ArrayList<Equipe> la liste des équipes d'une édition
         */
        public ArrayList<Equipe> chercher(int idEdition){
            ArrayList<Equipe> listEquipe = new ArrayList<>();
            String query = "SELECT * FROM `equipe` WHERE `idequipe` IN (SELECT `idequipe` FROM `participer` WHERE `idedition` = "+idEdition+")";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                while(res.next()){
                   listEquipe.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return listEquipe;
        }
        
        /**
         * méthode DAO permettant de retourner la plus grande id d'une équipe 
         * @param nom_eq String désignant le nom d'une équipe
         * @return int la plus garnde id de l'équipe cherchée dans la base de donnée
         */
        public int trouveEquipe(String nom_eq){
            int id = 0;
            String select = "SELECT max(`idequipe`) as idequipe FROM `equipe` WHERE `nom_eq`='"+nom_eq+"'";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    id = res.getInt("idequipe");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return id;
        }
        
        /**
         * méthode DAO permettant de chercher les éditions d'une CAN jouées
         * par une équipe
         * @param nom_eq String désignant le nom d'une équipe
         * @return ArrayList<Edition> la liste des éditions jouées par une équipe
         */
        public ArrayList<Edition> editionJouer(String nom_eq){
            ArrayList<Edition> listEdition = new ArrayList<>();
            String select = "select * from `edition` where `idedition` in (SELECT (`idedition`) FROM `participer` WHERE `idequipe` in (SELECT `idequipe` from `equipe` where `nom_eq`='"+nom_eq+"'))";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    listEdition.add(new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg")));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return listEdition;
        }
        
        /**
         * méthode DAO permettant de vérifier la participation d'une
         * équipe à une édition
         * @param nom_eq String désignant le nom d'une équipe
         * @param idEdition int désignant l'id d'une édition
         * @return boolean vrai si l'équipe participe à une édition de la CAN
         *                 faux sinon
         */
        public boolean verifParticipe(String nom_eq,int idEdition){
            boolean flags = false;
            String select = "SELECT `nom_eq` FROM `equipe` WHERE `idpoule` IN (SELECT `idpoule` FROM `poule` WHERE `idedition` = "+idEdition+");";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    if(nom_eq.equals(res.getString("nom_eq")))
                        flags = true;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return flags;
        }
	
        /**
         * méthode DAO permettant de modifier le rang d'une équipe 
         * lors des phases de poule 
         * @param rg int désignant le rang de l'équipe dans une poule
         * @param Nom_eq String désignant le nom d'une équipe
         */
	public void modifRang(int rg,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                equipe.setRg(rg);
                state.executeUpdate("UPDATE `equipe` SET `rg`="+equipe.getRg()+" WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            } 
	}
	
        /**
         * méthode DAO permettant de modifier les points d'une équipe 
         * lors des phases de poule 
         * @param pts int désignant le nombre de points d'une équipe dans une poule
         * @param Nom_eq String désignant le nom d'une équipe
         */
	public void modifPts(int pts,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `pts`="+pts+" WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
	
        /**
         * méthode DAO permettant de modifier les journées d'une équipe 
         * lors des phases de poule 
         * @param Jr int désignant le nombre de match joué par une équipe dans une poule
         * @param Nom_eq String désignant le nom d'une équipe
         */
	public void modifJr(int Jr,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe` SET `jr`="+Jr+" WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
	
        /**
         * méthode DAO permettant de modifier le nombre de but marqué par une équipe 
         * lors des phases de poule 
         * @param butM int désignant le nombre de but marqué par une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
	public void modifButM(int butM, String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe` SET `bm`="+butM+" WHERE `idequipe`="+equipe.getId()+"");
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de modifier le nombre de but encaissé par une équipe 
         * lors des phases de poule 
         * @param butE int désignant le nombre de but encaissé par une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void modifButE(int butE, String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `be`="+butE+" WHERE `idequipe`="+equipe.getId()+"");
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de modifier la différence de but d'une équipe 
         * lors des phases de poule 
         * @param bm int désignant le nombre de but marqué par une équipe
         * @param be int désignant le nombre de but encaissé par une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void modifDiff(int bm,int be,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `diff`="+(bm - be)+" WHERE `idequipe`="+equipe.getId()+"");
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de modifier le nombre match gagné d'une équipe 
         * lors des phases de poule
         * @param g int désignant le nombre de match gagné par une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void modifGagne(int g,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `g`="+g+" WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de modifier le nombre match nul d'une équipe 
         * lors des phases de poule
         * @param n int désignant le nombre de match nul d'une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void modifNul(int n, String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `n`="+n+" WHERE `idequipe`="+equipe.getId()+"");
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de modifier le nombre match perdu d'une équipe 
         * lors des phases de poule
         * @param p int désignant le nombre de match perdu par une équipe
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void modifPerdu(int p,String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                state.executeUpdate("UPDATE `equipe` SET `p`="+p+" WHERE `idequipe`="+equipe.getId()+"");
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant de qualifier une équipe pour les 
         * quart de final 
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void qualifQuart( String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                 state.executeUpdate("UPDATE `equipe` SET `quart`= 1  WHERE `idequipe`="+equipe.getId()+"");
                
               
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de qualifier une équipe pour les 
         * demi de final
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void qualifDemi( String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                 state.executeUpdate("UPDATE `equipe` SET `demi`= 1  WHERE `idequipe`="+equipe.getId()+"");   
                
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de qualifier une équipe pour le 
         * match de 3e place
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void qualifPfinale( String Nom_eq){
           Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                 state.executeUpdate("UPDATE `equipe` SET `pfinale`= 1  WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            } 
        }
       
        /**
         * méthode DAO permettant de qualifier une équipe pour la finale
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void qualifFinale(String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                 state.executeUpdate("UPDATE `equipe` SET `finale` = 1  WHERE `idequipe`="+equipe.getId()+"");
               
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de designer une équipe vainqueur
         * d'une édition de la CAN
         * @param Nom_eq String désignant le nom d'une équipe
         */
        public void gagne(String Nom_eq){
            Equipe equipe = new Equipe();
            String query = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+Nom_eq+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                    equipe = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                 state.executeUpdate("UPDATE `equipe` SET `vainqueur`= 1  WHERE `idequipe`="+equipe.getId()+"");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
       public ArrayList<Edition> editionGagnee(String nom_eq){
            ArrayList<Edition> listEdition = new ArrayList<>();
            String select = "select * from `edition` where `idedition` in (SELECT (`idedition`) FROM `participer` WHERE `idequipe` in (SELECT `idequipe` from `equipe` where `nom_eq`='"+nom_eq+"' and `vainqueur`='"+1+"'))";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    listEdition.add(new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg")));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return listEdition;
        }
        
       public String victoire (ArrayList<Edition> edition){
           String win = new String();
           win = " "; 
           try {
                EquipeDAO equipeDAO = new EquipeDAO();
                EditionDAO edDAO = new EditionDAO();
                for (int i=0; i < edition.size(); i++){
                    win = win+" "+edition.get(i).getAnnee();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return win;
       }
}