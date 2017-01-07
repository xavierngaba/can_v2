package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {

    //URL de connexion
    private static final String url = "jdbc:mysql://localhost:3306/can_db";
    //Nom du user
    private static final String user = "root";
    //Mot de passe de l'utilisateur
    private static final String passwd = "";
    //Objet Connection
    private static Connection connect = null;

    public static Connection getConnexion() throws SQLException { 
        try {
        Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,passwd);
        }catch(  ClassNotFoundException | SQLException cnfe) {
           JOptionPane.showMessageDialog(null,"Echec de la connexion à la base de donnée... \n Veuillez vérifier votre accès à la base de donnée");
        }
	return connect;
	}
}
