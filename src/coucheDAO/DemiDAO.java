package coucheDAO;

import ConnectionDB.ConnectionDB;
import demi.Demi;
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
public class DemiDAO {
    protected Connection connect;
    
    public DemiDAO() throws SQLException{
        this.connect = ConnectionDB.getConnexion();
    }
    
    /**
     * 
     * @param idEdition
     * @return ArrayList<Quart>
     * @throws SQLException 
     */
    public ArrayList<Demi> afficher(int idEdition) throws SQLException{
        ArrayList<Demi> demi = new ArrayList<>();
        String select = "SELECT * FROM `demi` WHERE `idedition`="+idEdition;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(select);
            while(res.next()){
                demi.add(new Demi(res.getInt("iddemi"),res.getString("libelled"),res.getInt("idedition")));
                
            }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
           }
        
        return demi;
    }
}
