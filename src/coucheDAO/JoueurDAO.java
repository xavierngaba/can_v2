package coucheDAO;

import ConnectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import personnel.Joueur;

/**
 *
 * @author Groupe 2
 */
public class JoueurDAO{
        
	protected Connection connect;
	
        /**
         * méthode DAO permettant la connexion à la 
         * base de donnéen de l'application
         * @throws SQLException 
         */
	public JoueurDAO() throws SQLException{
	  this.connect = ConnectionDB.getConnexion();
	}
	
        /**
         * méthode DAO permettant de créer un joueur
         * @param nom chaine de caratère désignant le nom du joueur
         * @param prenom chaine de caratère désignant le prénom du joueur
         * @param poste chaine de caratère désignant le poste du joueur
         * @param dateNaiss chaine de caratère désignant la date de naissance du joueur
         * @param dossard entier désignant le dossard du joueur 
         * @param idEquipe entier désignant l'id de l'équipe du joueur
         * @return Joueur classe Joueur
         */
	public Joueur creer(String nom, String prenom, String poste, String dateNaiss,int dossard, int idEquipe){
          Joueur joueur = new Joueur();
            String insert = "INSERT INTO `joueur`(`nom_j`,`prenom_j`,`date_naiss`,`poste`,`dossard`,`butc`,`butt`,`idequipe`) VALUES ('"+nom+"','"+prenom+"','"+dateNaiss+"','"+poste+"',"+dossard+",0,0,"+idEquipe+")";
            String select = "SELECT max(`idJoueur`) as lastId FROM `joueur`";
            int idJoueur = 0;
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);
                ResultSet res = state.executeQuery(select);
                
                if(res.first()){
                    idJoueur = res.getInt("lastId");
                }
                
                res = state.executeQuery("SELECT * FROM `joueur` WHERE idJoueur ="+idJoueur);
                
                if(res.first()){
                    joueur = new Joueur(res.getInt("idJoueur"), res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        
          return joueur;
	}
	
        /**
         * méthode DAO permettant de modifier un joueur
         * @param idjoueur entier désignant l'id du joueur
         * @param nom chaine de caratère désignant le nom du joueur
         * @param prenom chaine de caratère désignant le prénom du joueur
         * @param poste chaine de caratère désignant le poste du joueur
         * @param dateNaiss chaine de caratère désignant la date de naissance du joueur
         * @param dossard entier désignant le dossard du jou
         * @param idEquipe entier désignant l'id de l'équipe du joueur
         * @return Joueur classe Joueur
         */
	public Joueur modif(int idjoueur,String nom, String prenom, String poste,Date dateNaiss ,int dossard,int idEquipe){
            Joueur joueur = new Joueur();
           String query = "UPDATE `joueur` SET `nom_j`='"+nom+"',`prenom_j`='"+prenom+"',`date_naiss`='"+dateNaiss+"',`poste`='"+poste+"',`dossard`="+dossard+" WHERE `idjoueur`="+idjoueur+" AND `idequipe`="+idEquipe;
           String select = "SELECT * FROM `joueur` WHERE `idJoueur` ="+idjoueur+" AND `idequipe`="+idEquipe;
           try{
               Statement state = connect.createStatement();
               state.executeUpdate(query);
               ResultSet res = state.executeQuery(select);
               
               if(res.first()){
                    joueur = new Joueur(res.getInt("idJoueur"), res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"));
                }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
          return joueur;
	}
	
        /**
         * méthode DAO permettant de chercher les joueurs 
         * en fonction du nom d'une équipe nationale
         * @param nom_eq chaine de caratère désignant le nom d'une équipe
         * @return ArrayList<Joueur> une liste de joueur appartenant à cette équipe
         */
	public ArrayList<Joueur> cherche(String nom_eq, int idedition){
            ArrayList<Joueur> joueur = new ArrayList<>();
            String query = "SELECT * FROM `joueur` WHERE `idequipe` in (select `idequipe` from `participer` where `idedition` ='"+idedition+"'and `idequipe` in (SELECT `idequipe` FROM `equipe` WHERE `nom_eq`='"+nom_eq+"'));";
          
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(query);
               
               while(res.next()){
                    joueur.add(new Joueur(res.getInt("idJoueur"), res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt")));
                }
           }catch(SQLException e){
                //JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
          return joueur;
	}
        
        /**
         * méthode DAO permettant de retourner le nombre total de joueur 
         * d'une équipe nationale
         * @param nom_eq chaine de caratère désignant le nom d'une équipe
         * @return int le nombre total de joueur de cette "quipe
         */
        public int joueurEquipe(String nom_eq, int idedition){
            int nb = 0;
            String query = "SELECT count(`idjoueur`) as maxjoueur FROM `joueur` WHERE `idequipe` in (select `idequipe` from `participer` where `idedition` ='"+idedition+"'and `idequipe` in (SELECT `idequipe` FROM `equipe` WHERE `nom_eq`='"+nom_eq+"'));";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                while(res.next()){
                    nb = res.getInt("maxjoueur");
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return nb;
        }
	
        /**
         * méthode DAO permettant d'ajouter un but à un joueur 
         * lors de l'édition d'une CAN
         * @param butC int désignant le nombre de but marqué à une édition par un joueur
         * @param idJoueur int désignant l'id d'un joueur
         */
	public void ajoutButC(int butC, int idJoueur){
            Joueur joueur = new Joueur();
            String select = "SELECT * FROM `joueur` WHERE `idJoueur` ="+idJoueur;
            
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(select);
               
               while(res.next()){
                    joueur = new Joueur(res.getInt("idJoueur"), res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"));
                }
               state.executeUpdate("UPDATE `Joueur` SET `butc`="+butC+" WHERE `idjoueur`="+joueur.getId()+"");
               
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
	
        /**
         * méthode DAO permettant de totaliser le nombre de but 
         * d'un joueur sur toutes les éditions d'une CAN
         * @param butT int désignant le nombre de but marqué à une édition par un joueur
         * @param idJoueur int désignant l'id d'un joueur
         */
	public void ajoutButT(int butT, int idJoueur){
		Joueur joueur = new Joueur();
                String select = "SELECT * FROM `joueur` WHERE `idJoueur` ="+idJoueur;
            
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(select);
               
               while(res.next()){
                    joueur = new Joueur(res.getInt("idJoueur"), res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"));
                }
               state.executeUpdate("UPDATE `Joueur` SET `butT`="+butT+" WHERE `idjoueur`="+joueur.getId()+"");
               
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant totaliser le nombre de but d'un joueur
         * lors d'un match
         * @param nb int le nombre de but d'un joueur pendant un match
         * @param idJoueur int désignant l'id d'un joueur 
         * @param idmatch int désignant l'id d'un match
         */
        public void ajoutButMatch(int nb, int idJoueur, int idmatch){
		
            try{
               Statement state = connect.createStatement();
               state.executeUpdate("INSERT INTO `joueur_matchs`(`idjoueur`,`idmatchs`,`nbut`) VALUES ("+idJoueur+","+idmatch+","+nb+")");
               
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
        
        /**
         * méthode DAO permettant d'afficher les meilleurs buteurs
         * d'une édition de la CAN
         * @return ArrayList<Joueur> une liste de joueur
         */
        public ArrayList<Joueur> chercheButeur(int idedition){
            ArrayList<Joueur> joueur = new ArrayList<>();
            String query = "SELECT * FROM `joueur` where `butc` >= 0 and `idequipe` in (select `idequipe` from `participer` where `idedition` ="+idedition+")order by `butc` desc";
          
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(query);
               
               while(res.next()){
                    joueur.add(new Joueur(res.getInt("idJoueur"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"),res.getInt("idequipe"),res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss")));
                }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
          return joueur;
	}
        
        /**
         * méthode DAO permettant d'afficher les meilleurs buteurs
         * de toute l'histoire édition de la CAN
         * @return ArrayList<Joueur> une liste de joueur
         */
        public ArrayList<Joueur> chercheButeurH(){
            ArrayList<Joueur> joueur = new ArrayList<>();
            String query = "SELECT * FROM `joueur` where `butt` >= 1 order by `butc` desc";
          
            try{
               Statement state = connect.createStatement();
               ResultSet res = state.executeQuery(query);
               
               while(res.next()){
                    joueur.add(new Joueur(res.getInt("idJoueur"),res.getString("poste"), res.getInt("dossard"),res.getInt("butc"),res.getInt("butt"),res.getInt("idequipe"),res.getString("nom_j"), res.getString("prenom_j"), res.getString("date_naiss")));
                }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
          return joueur;
	}
}