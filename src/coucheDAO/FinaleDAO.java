package coucheDAO;

import ConnectionDB.ConnectionDB;
import finale.Finale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author XAVIER
 */
public class FinaleDAO {
    protected Connection connect;
    
    public FinaleDAO() throws SQLException{
        this.connect = ConnectionDB.getConnexion();
    }
    
    /**
     * 
     * @param idEdition
     * @return Finale
     * @throws SQLException 
     */
    public Finale afficher(int idEdition) throws SQLException{
        Finale finale = new Finale();
        String select = "SELECT * FROM `finale` WHERE `idedition`="+idEdition;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(select);
            while(res.next()){
                finale = new Finale(res.getInt("idfinale"),res.getString("libellef"),res.getInt("idedition"));
                
            }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
           }
        
        return finale;
    }
}
