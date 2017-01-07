package coucheDAO;

import ConnectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import quart.Quart;

/**
 *
 * @author XAVIER
 */
public class QuartDAO {
    protected Connection connect;
    
    public QuartDAO() throws SQLException{
        this.connect = ConnectionDB.getConnexion();
    }
    /**
     * 
     * @param idEdition
     * @return ArrayList<Quart>
     * @throws SQLException 
     */
    public ArrayList<Quart> afficher(int idEdition) throws SQLException{
        ArrayList<Quart> quart = new ArrayList<>();
        String select = "SELECT * FROM `quart` WHERE `idedition`="+idEdition;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(select);
            while(res.next()){
                quart.add(new Quart(res.getInt("idquart"),res.getString("libelle"),res.getInt("idedition")));
                
            }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
           }
        
        return quart;
    }
    
}
