package coucheDAO;

import ConnectionDB.ConnectionDB;
import equipe.Equipe;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poule.Poule;

public class PouleDAO{
  protected Connection connect;
	
        /**
         * méthode DAO permettant la connexion de l'application 
         * à la base de donnée
         * @throws SQLException 
         */
	public PouleDAO() throws SQLException{
	 this.connect = ConnectionDB.getConnexion();
   }
	
        /**
         * méthode DAO permettant de créer une poule 
         * @param pays String désignant le nom d'une équipe
         * @param nom_poule int désignant le nom de la poule d'une équipe
         * @param idedition int désignant l'id de l'édition
         */
	public void creer(String pays, String nom_poule, int idedition){
            Equipe equipe = new Equipe();
            String select = "SELECT * FROM `poule` WHERE `nom`='"+nom_poule+"' AND `idedition`="+idedition;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                 EquipeDAO eqDAO = new EquipeDAO();
                 equipe = eqDAO.creer(pays,res.getInt("idpoule"), idedition);   
               }
                                      
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
	}
	
        /**
         * méthode DAO permettant de retourner une poule d'une édition de la CAN
         * @param nom_poule String désignant le nom d'une poule 
         * @param idedition int désignant l'id de l'édition
         * @return Poule objet de la classe Poule
         */
	public Poule afficher(String nom_poule, int idedition){
            Poule poule = new Poule();
            String select = "SELECT * FROM `poule` WHERE `nom`='"+nom_poule+"' AND `idedition`="+idedition;
            
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                if(res.next()){
                    poule = new Poule(res.getInt("idpoule"), res.getString("nom"),new EquipeDAO().chercher(res.getInt("idpoule"), idedition));
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return poule;
        }
        
        /**
         * méthode DAO permettant d'effectuer le classement d'une poule d'une édition
         * @param idPoule int désignant l'id de la poule d'une équipe
         * @param idEdition int désignant l'id de l'édition
         * @throws SQLException 
         */
        public void classerPoule(int idPoule,int idEdition) throws SQLException{
            Poule poule = new Poule();
            String select = "SELECT * FROM `poule` WHERE `idpoule`="+idPoule+" AND `idedition`="+idEdition;
            ArrayList<Equipe> equipe =  new ArrayList<>();
            EquipeDAO eqDAO = new EquipeDAO();
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                while(res.next()){
                   poule = new Poule(res.getInt("idpoule"), res.getString("nom"),new EquipeDAO().chercher(res.getInt("idpoule"), idEdition)); 
                }
                
                equipe = poule.rang();
                for (Equipe equipe1 : equipe) {
                        eqDAO.modifRang(equipe1.getRg(), equipe1.getNom());
                        eqDAO.qualifQuart(equipe1.getNom());
                    }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }
        
        /**
         * méthode DAO permattant de retourner le nombre total des équipes d'une poule 
         * lors d'une édition
         * @param idpoule int désignant l'id de la poule d'une équipe
         * @param idedition int désignant l'id de l'édition
         * @return int le nombre maximal des équipes d'une poule
         */
        public int equipePoule(int idpoule,int idedition){
            int nb = 0;
            String query = "SELECT count(`idequipe`) as maxpoule  FROM `equipe` WHERE `idpoule` IN (SELECT `idpoule` FROM `poule` WHERE `idpoule` = "+idpoule+" AND `idedition` = "+idedition+")";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(query);
                while(res.next()){
                    nb = res.getInt("maxpoule");
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            return nb;
        }
}