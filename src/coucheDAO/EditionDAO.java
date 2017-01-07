package coucheDAO;

import ConnectionDB.ConnectionDB;
import edition.Edition;
import equipe.Equipe;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditionDAO{
  protected Connection connect;
	
        /**
         * méthode DAO permettant de se connecter à la base de donnée 
         * de l'application
         * @throws SQLException 
         */
	public EditionDAO() throws SQLException{
	this.connect = ConnectionDB.getConnexion();
	}
	
        /**
         * méthode DAO permettant de créer une édition de la CAN
         * @param annee
         * @param paysOrg
         * @return Edition
         */
	public Edition creer(String annee, String paysOrg){
            Edition edition = new Edition();
            String insert = "INSERT INTO `edition`(`annee`,`paysorg`) VALUES('"+annee+"','"+paysOrg+"')";
            String select = "SELECT max(`idedition`) as lastId FROM `edition`";
            int id = 0;
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);
                ResultSet res = state.executeQuery(select);
                
                if(res.next()){
                    id = res.getInt("lastId");
                }
                
                res = state.executeQuery("SELECT * FROM `edition` WHERE `idedition` ="+id);
                
                while(res.next()){
                    edition = new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg"));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return edition;
	}
	
        /**
         * méthode DAO permettant de créer toutes les poules d'une édition
         * @param nom_poule String désignant le nom d'une poule
         * @param idedition int désignant l'id de l'édition en cours
         */
        public void creerPouleEdition(String nom_poule,int idedition){
            String insert = "INSERT INTO `poule`(`nom`,`idedition`) VALUES ('"+nom_poule+"',"+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);   
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de créer les quarts de finale d'une édition
         * @param libelle String 
         * @param idedition int désignant l'id de l'édition en cours
         */
        public void creerQuartEdition(String libelle,int idedition){
            String insert = "INSERT INTO `quart`(`libelle`,`idedition`) VALUES ('"+libelle+"',"+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);   
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de créer les demi-final d'une édition
         * @param libelle String 
         * @param idedition int désignant l'id de l'édition en cours
         */
        public void creerDemiEdition(String libelle,int idedition){
            String insert = "INSERT INTO `demi`(`libelled`,`idedition`) VALUES ('"+libelle+"',"+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);   
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de créer le match de 3e place d'une édition
         * @param libelle String 
         * @param idedition int désignant l'id de l'édition en cours
         */
        public void creerPfinalEdition(String libelle,int idedition){
            String insert = "INSERT INTO `pfinale`(`libellepf`,`idedition`) VALUES ('"+libelle+"',"+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);   
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
         /**
         * méthode DAO permettant de créer le match de 3e place d'une édition
         * @param libelle String 
         * @param idedition int désignant l'id de l'édition en cours
         */
        public void creerFinalEdition(String libelle,int idedition){
            String insert = "INSERT INTO `finale`(`libellef`,`idedition`) VALUES ('"+libelle+"',"+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);   
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permettant de modifier une édition
         * @return Edition
         */
	public Edition modif(){
            Edition edition = new Edition();
            
            
            return edition;
	}
	
        /**
         * méthode DAO permettant de retourner une édition en cours 
         * @return Edition
         */
	public Edition cherche(){
            Edition edition = new Edition();
            String select = "SELECT max(`idedition`) as lastId FROM `edition`";
            int id = 0;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                if(res.next()){
                    id = res.getInt("lastId");
                }
                
                res = state.executeQuery("SELECT * FROM `edition` WHERE `idedition` ="+id);
                
                if(res.next()){
                    edition = new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg"));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return edition;
	}

        /**
         * méthode DAO permettant de retourner une édition en cours
         * @param nom_ed
         * @return Edition
         */
        public Edition cherche(String nom_ed){
            Edition edition = new Edition();
            String select = "SELECT * FROM `edition` WHERE `annee`="+nom_ed;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    edition = new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg"));
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return edition;
	}
        
        /**
         * méthode DAO permettant de retourner toutes les éditions qui ont eu lieu
         * @return ArrayList<Edition>
         */
        public ArrayList<Edition> trouve(){
            ArrayList<Edition> edition = new ArrayList<>();
            String query = "SELECT * FROM `edition`";
          
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(query);
               
               while(res.next()){
                    edition.add(new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg")));
                }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
          return edition;
	}
        
        /**
         * méthode DAO permettant de savoir si la derniere édition est achevee 
         * @return termine
         */
	public boolean verifEditionTermine(int idEdition) throws SQLException{
            boolean termine = false;
            Edition edition = new Edition();
            EquipeDAO equipeDAO =  new EquipeDAO();
            ArrayList<Equipe> equipe = new ArrayList<>();
            String select = "SELECT max(`idedition`) as lastId FROM `edition`";
            int id = 0;
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    id = res.getInt("lastId");
                }
                
                res = state.executeQuery("select * from `equipe` where `idequipe` in (SELECT `idequipe` FROM `participer` WHERE `idedition` ="+id+") and `vainqueur`="+1);
                
                while(res.next()){
                    equipe.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                
                if(!equipe.isEmpty()){
                    termine = true;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return termine;
	}
        
        public boolean editionDejaCree(String nom_ed){
            ArrayList<Edition> edition = new ArrayList<>();
            boolean trouve = false;
            String select = "SELECT * FROM `edition` WHERE `annee`="+nom_ed;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                    edition.add(new Edition(res.getInt("idedition"), res.getString("annee"), res.getString("paysorg")));
                }
                
                if(!edition.isEmpty()){
                    trouve = true;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return trouve;
	}
}