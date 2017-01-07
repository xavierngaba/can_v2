package coucheDAO;

import ConnectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pfinale.Pfinale;

/**
 *
 * @author XAVIER
 */
public class PfinaleDAO {
    protected Connection connect;
    
    public PfinaleDAO() throws SQLException{
        this.connect = ConnectionDB.getConnexion();
    }
    
    /**
     * 
     * @param idEdition
     * @return Pfinale
     * @throws SQLException 
     */
    public Pfinale afficher(int idEdition) throws SQLException{
        Pfinale pfinale = new Pfinale();
        String select = "SELECT * FROM `pfinale` WHERE `idedition`="+idEdition;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(select);
            while(res.next()){
                pfinale = new Pfinale(res.getInt("idpfinale"),res.getString("libellepf"),res.getInt("idedition"));
                
            }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
           }
        
        return pfinale;
    }
}
