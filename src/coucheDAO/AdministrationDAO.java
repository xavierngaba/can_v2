package coucheDAO;

import ConnectionDB.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import personnel.Administration;

public class AdministrationDAO{
 
  protected Connection connect;
	
        /**
         * méthode DAO permettant la connexion de l'application 
         * à la base de donnée
         * @throws SQLException 
         */
	public AdministrationDAO() throws SQLException{
	 this.connect = ConnectionDB.getConnexion();
	}
	
        /**
         * méthode DAO permettant de créer un membre de l'administration
         * @param nom
         * @param prenom
         * @param statut
         * @param idequipe
         * @return Administration
         */
	public Administration creer(String nom,String prenom,String statut,int idequipe){
            Administration administration = new Administration();
            String insert = "INSERT INTO `administration`(`nom_admin`,`prenom_admin`,`statut`,`idequipe`) VALUES('"+nom+"','"+prenom+"','"+statut+"',"+idequipe+")";
            String select = "SELECT max(`idJoueur`) as lastId FROM `joueur`";
            int id = 0;
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);
                ResultSet res = state.executeQuery(select);
                
                if(res.first()){
                    id = res.getInt("lastId");
                }
                res = state.executeQuery("SELECT * FROM `administration` WHERE idadmin ="+id);
                
                if(res.first()){
                    administration = new Administration(res.getInt("idadmin"), res.getString("nom_admin"), res.getString("prenom_admin"), null, res.getString("statut"));
                }
                 
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return administration;
	}
	
        /**
         * méthode permettant de modifier un membre de l'administration
         * @return Administration
         */
	public Administration modif(){
            Administration administration = new Administration();
            
            return administration;
	}
	
        /**
         * méthode DAO permettant de chercher tous les membres de 
         * l'administration d'une équipe nationale
         * @param nom_eq
         * @return ArrayList<Administration>
         */
	public ArrayList<Administration> cherche(String nom_eq){
            ArrayList<Administration> administration = new ArrayList<>();
            String select = "SELECT * FROM `joueur` WHERE `idequipe` = (SELECT `idequipe` FROM `equipe` WHERE `nom_eq`="+nom_eq+")";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                
                if(res.first()){
                    administration.add(new Administration(res.getInt("idadmin"), res.getString("nom_admin"), res.getString("prenom_admin"), null, res.getString("statut")));
                }
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return administration;
	}
}