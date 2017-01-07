package coucheDAO;

import ConnectionDB.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import personnel.Entraineur;

public class EntraineurDAO{

	protected Connection connect;
	
        /**
         * méthode DAO permmettant la connexion à la 
         * base de donnée de l'application
         * @throws SQLException 
         */
	public EntraineurDAO() throws SQLException{
	 this.connect = ConnectionDB.getConnexion();
	}
	
        /**
         * méthode DAO permettant de créer un entraineur
         * @param nom
         * @param prenom
         * @param nationalite
         * @param statut
         * @param idequipe
         * @return Entraineur
         */
	public Entraineur creer(String nom,String prenom,String nationalite,String statut,int idequipe){
            Entraineur entraineur = new Entraineur();
             String insert = "INSERT INTO `entraineur`(`nom_ent`,`prenom_ent`,`nationalite`,`statut_ent`,`idequipe`) VALUES('"+nom+"','"+prenom+"','"+nationalite+"','"+statut+"',"+idequipe+")";
            String select = "SELECT max(`identraineur`) as lastId FROM `entraineur`";
            int id = 0;
            
            try{
                Statement state = connect.createStatement();
                state.executeUpdate(insert);
                ResultSet res = state.executeQuery(select);
                
                if(res.first()){
                    id = res.getInt("lastId");
                }
                res = state.executeQuery("SELECT * FROM `entraineur` WHERE identraineur ="+id);
                
                if(res.first()){
                    entraineur = new Entraineur(res.getInt("identraineur"), res.getString("nom_ent"), res.getString("prenom_ent"), null, res.getString("nationalite"), res.getString("statut_ent"));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return entraineur;
	}
	
        /**
         * méthode DAO permettant de modifier une entraineur
         * @return Entraineur
         */
	public Entraineur modif(){
            Entraineur entraineur = new Entraineur();
            
            return entraineur;
	}
	
        /**
         * méthode DAO permettant de chercher tous les entraineurs 
         * d'une équipe nationale
         * @param nom_eq
         * @return ArrayList<Entraineur>
         */
	public  ArrayList<Entraineur> cherche(String nom_eq){
            ArrayList<Entraineur> entraineur = new ArrayList<>();
            String select = "SELECT * FROM `entraineur` WHERE `idequipe` = (SELECT `idequipe` FROM `equipe` WHERE `nom_eq`="+nom_eq+")";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                
                
                if(res.first()){
                    entraineur.add(new Entraineur(res.getInt("identraineur"), res.getString("nom_ent"), res.getString("prenom_ent"), null, res.getString("nationalite"), res.getString("statut_ent")));
                }
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
            
            return entraineur;
	}
}