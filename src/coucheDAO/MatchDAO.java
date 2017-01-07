package coucheDAO;

import ConnectionDB.ConnectionDB;
import demi.Demi;
import equipe.Equipe;
import finale.Finale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import match.Match;
import pfinale.Pfinale;
import poule.Poule;
import quart.Quart;

/**
 *
 * @author GROUPE 2
 */
public class MatchDAO {
    protected Connection connect;
    
    /**
     * méthode DAO permettant la connexion de l'application 
     * à la base de donnée
     * @throws SQLException 
     */
    public MatchDAO() throws SQLException{
        this.connect = ConnectionDB.getConnexion();
    }
    
    /**
     * méthode DAO permettant de créer un match de poule
     * @param lieu String désignant le lieu du match
     * @param arbitre String désignant le nom et le prénom de l'arbitre
     * @param date String désignant la date du match
     * @param idEq1 int désignant l'id de la 1ère équipe 
     * @param idEq2 int désignant l'id de la 2e équipe
     * @param idPoule int désignant l'id de la poule 
     * @param idEdition int désignant l'id de l'édition
     * @return Match Match 
     * @throws SQLException 
     */
    public Match creerMatchPoule(String lieu,String arbitre,String date,int idEq1,int idEq2,int idPoule,int idEdition) throws SQLException{
        Match match = new Match();
        Poule poule = new Poule();
        PouleDAO pouleDAO = new PouleDAO();
        ArrayList<Equipe> listEquipe = new ArrayList<>();
        String query = "INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idpoule`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+idPoule+")";
        String selectPoule = "SELECT * FROM `poule` WHERE `idpoule`="+idPoule+" AND `idedition`="+idEdition;
        String select = "SELECT max(`idmatchs`) as lastId FROM `matchs`";
        int id = 0;
        
        try{
                Statement state = connect.createStatement();
                state.executeUpdate(query);
                ResultSet res = state.executeQuery(select);
                if(res.first()){
                    id = res.getInt("lastId");
                }
                res = state.executeQuery("SELECT * FROM `matchs` WHERE `idmatchs`="+id);
                if(res.first()){
                    match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                }
                res = state.executeQuery(selectPoule);
                
                while(res.next()){
                    poule = pouleDAO.afficher(res.getString("nom"), idEdition);
                 }
                
                listEquipe = poule.getListEquipe();
               
                for(int i = 0; i < listEquipe.size(); i++){
                    if(listEquipe.get(i).getId() == idEq1 || listEquipe.get(i).getId() == idEq2){
                      if(listEquipe.get(i).getJr() <= 3){
                        state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe.get(i).getId()+","+id+")");
                      }else{
                          JOptionPane.showMessageDialog(null,"tous les 3 matchs de cette équipe sont déjà programmés!!!");
                      }   
                     } 
                }
               
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        
        return match;
    }
    
    /**
     * méthode DAO permettant de chercher un match 
     * opposant deux équipes
     * @param nom_eq1 String désignant le nom de la 1ère équipe
     * @param nom_eq2 String désignant le nom de la 2e équipe
     * @return Match un objet de la classe Match
     * @throws SQLException 
     */
    public Match ChercheMatch(String nom_eq1,String nom_eq2) throws SQLException{
        Match match = new Match();
        ArrayList listMatch = new ArrayList<>();
        ArrayList listMatch2 = new ArrayList<>();
        String selectEq1 = "SELECT `idmatchs` FROM `equipe_matchs` WHERE `idequipe` = (SELECT max(`idequipe`) FROM `equipe` WHERE `nom_eq` ='"+nom_eq1+"')";
        String selectEq2 = "SELECT `idmatchs` FROM `equipe_matchs` WHERE `idequipe` = (SELECT max(`idequipe`) FROM `equipe` WHERE `nom_eq` ='"+nom_eq2+"')";
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
                listMatch.add(res.getInt("idmatchs"));  
            }
            
            res = state.executeQuery(selectEq2);
            
            while(res.next()){
                listMatch2.add(res.getInt("idmatchs"));   
            }
            
            for(int i = 0; i < listMatch.size(); i++){
                for(int j = 0; j < listMatch2.size(); j++){
                    if(listMatch.get(i) == listMatch2.get(j)){
                        res = state.executeQuery("Select * from `matchs` where `idmatchs`="+listMatch.get(i));
                        while(res.next()){
                            match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                        }
                        break;
                    }
                }
            }
            
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return match;
    }
    
    /**
     * méthode DAO permettant de vérifier une rencontre entre deux équipes
     * @param nom_eq1 String désignant le nom de la 1ère équipe
     * @param nom_eq2 String désignant le nom de la 2e équipe
     * @return boolean vrai si les deux équipes ont un match programmé
     *                 faux sinon
     * @throws SQLException 
     */
    public boolean verifierRencontreEquipe(String nom_eq1,String nom_eq2) throws SQLException{
        boolean flags = false;
        ArrayList listMatch = new ArrayList<>();
        ArrayList listMatch2 = new ArrayList<>();
        String selectEq1 = "SELECT `idmatchs` FROM `equipe_matchs` WHERE `idequipe` = (SELECT max(`idequipe`) FROM `equipe` WHERE `nom_eq` ='"+nom_eq1+"')";
        String selectEq2 = "SELECT `idmatchs` FROM `equipe_matchs` WHERE `idequipe` = (SELECT max(`idequipe`) FROM `equipe` WHERE `nom_eq` ='"+nom_eq2+"')";
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
                listMatch.add(res.getInt("idmatchs"));  
            }
            
            res = state.executeQuery(selectEq2);
            
            while(res.next()){
                listMatch2.add(res.getInt("idmatchs"));   
            }
            
            for(int i = 0; i < listMatch.size(); i++){
                for(int j = 0; j < listMatch2.size(); j++){
                    if(listMatch.get(i) == listMatch2.get(j)){
                        flags = true;
                        break;
                    }
                }
            }
            
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return flags;
    }
    
    /**
     * méthode DAO permettant vérifier une rencontre de quart de finale
     * @param id int désignant l'id d'un quart de final
     * @return boolean
     * @throws SQLException 
     */
    public boolean verifierRencontreQuart(int id) throws SQLException{
        boolean flags = false;
        String selectEq1 = "SELECT `idmatchs` FROM `matchs` WHERE `idquart` ="+id;
        int idmatch = 0;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
                idmatch = res.getInt("idmatchs");  
            }
            
             if(idmatch != 0){
               flags = true;
              }   
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return flags;
    }
    
    /**
     * méthode DAO permettant de vérifier une rencontre de demi finale
     * @param id int désignant l'id d'une demi de finale
     * @return boolean
     * @throws SQLException 
     */
    public boolean verifierRencontreDemi(int id) throws SQLException{
        boolean flags = false;
        String selectEq1 = "SELECT `idmatchs` FROM `matchs` WHERE `iddemi` ="+id;
        int idmatch = 0;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
                idmatch = res.getInt("idmatchs");  
            }
            
             if(idmatch != 0){
               flags = true;
              }   
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return flags;
    }
    
    /**
     * méthode DAO permettant de vérifier un match de 3e place
     * @param id
     * @return boolean
     * @throws SQLException 
     */
    public boolean verifierRencontrePfinale(int id) throws SQLException{
        boolean flags = false;
        String selectEq1 = "SELECT * FROM `matchs` WHERE `idpfinale` ="+id;
        int idmatch = 0;
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
               idmatch = res.getInt("idmatchs"); 
            }
            
             if(idmatch != 0){
               flags = true;
              }   
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return flags;
    }
    
    /**
     * méthode DAO permettant de vérifier un match de final
     * @param id
     * @return boolean
     * @throws SQLException 
     */
    public boolean verifierRencontreFinale(int id) throws SQLException{
        boolean flags = false;
        String selectEq1 = "SELECT * FROM `matchs` WHERE `idfinale` =";
        int idmatch = 0;
        
       try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(selectEq1);
           
            while(res.next()){
               idmatch = res.getInt("idmatchs"); 
            }
            
             if(idmatch != 0){
               flags = true;
              }   
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return flags;
    }
    
    /**
     * méthode DAO permettant de retourner tous les matchs d'une poule
     * @param id int désignant l'id d'une poule 
     * @return ArrayList<Match>
     */
    public ArrayList<Match> chercherMatch(int id){
        ArrayList<Match> listMatch = new ArrayList<>();
        String select = "select * from `matchs` where `idpoule` ="+id;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   listMatch.add( new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), res.getString("datem"), res.getBoolean("joue")));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return listMatch;
    }
    
    /**
     * méthode DAO permettant de retourner le nombre de but marqué par une 
     * équipe lors d'un match
     * @param idEq1 int désignant l'id d'une équipe
     * @param idMatch int désignant l'id d'un match
     * @return int le nombre de but marqué par l'équipe en question
     */
    public int resultScore (int idEq1, int idMatch){
        int score = 0;
        String select = "select `score` from `equipe_matchs` where `idequipe` ="+idEq1+" and `idmatchs`="+idMatch;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   score = res.getInt("score");
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return score;
    }
    
    /**
     * méthode DAO permettant de retourner les équipes 
     * qui doivent jouer un match
     * @param id int désignant l'id d'un match
     * @return ArrayList<Equipe>
     */
    public ArrayList<Equipe> chercherEquipeMatch(int id){
        ArrayList<Equipe> listEquipe = new ArrayList<>();
        String select = "select * from `equipe` where `idequipe` in (select `idequipe` from `equipe_matchs` where `idmatchs` ='"+id+"')";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   listEquipe.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return listEquipe;
    }
    
    /**
     * méthode DAO permettant de retourner un match de quart de final
     * @param idquart int désignant l'id du match de quart de final
     * @return Match objet de classe Match
     * @throws SQLException 
     */
    public Match ChercheMatch(int idquart) throws SQLException{
        Match match = new Match();
        String select = "select * from `matchs` where `idquart`="+idquart;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return match;
    }
   
    /**
     * méthode DAO permettant de retourner un match de demi
     * @param id int désignant l'id d'un match de demi final
     * @return Match objet de classe Match
     * @throws SQLException 
     */
    public Match ChercheMatchDemi(int id) throws SQLException{
        Match match = new Match();
        String select = "select * from `matchs` where `iddemi`="+id;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return match;
    }
    
    /**
     * méthode DAO permettant de retourner un match de 3e de place
     * @param id
     * @return Match objet de classe Match
     * @throws SQLException 
     */
    public Match ChercheMatchPfinale(int id) throws SQLException{
        Match match = new Match();
        String select = "select * from `matchs` where `idpfinale`="+id;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return match;
    }
    
    /**
     * méthode DAO permettant de retourner un match de final
     * @param id
     * @return Match objet de classe Match
     * @throws SQLException 
     */
    public Match ChercheMatchFinale(int id) throws SQLException{
        Match match = new Match();
        String select = "select * from `matchs` where `idfinale`="+id;
        try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(select);
                while(res.next()){
                   match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"),res.getBoolean("joue"));
                 }    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        return match;
    }
    
    /**
     * méthode DAO permettant de gérer les résultats d'un match de poule
     * @param idmatch int désignant l'id du match de poule 
     * @param nom_Eq1 String désignant le nom de la 1ère équipe
     * @param butEq1 int désignant le nombre de but de la 1ère équipe
     * @param nom_Eq2 String désignant le nom de la 2e équipe
     * @param butEq2 int désignant le nombre de but de la 2e équipe
     * @throws SQLException 
     */
    public void resultatMatchPoule(int idmatch,String nom_Eq1,int butEq1,String nom_Eq2,int butEq2) throws SQLException{
        Match match = new Match();
        EquipeDAO eqDAO = new EquipeDAO();
        String match1 = "select * from `matchs` where `idmatchs`="+idmatch;
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        String Eq1 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq1+"')";
        String Eq2 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq2+"')";
        
        try{
            Statement state = connect.createStatement();
            ResultSet res = state.executeQuery(match1);
            
            while(res.next()){
                match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"), res.getBoolean("joue"));
            }
            state.executeUpdate("UPDATE `matchs` SET `joue`= 1  WHERE `idmatchs`="+match.getId()+"");
            
            res = state.executeQuery(Eq1);
            while(res.next()){
                    equipe1 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
            
            res = state.executeQuery(Eq2);
            while(res.next()){
                    equipe2 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
            
            state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq1+" WHERE `idequipe`= "+equipe1.getId()+" AND `idmatchs`= "+match.getId()+"");
            state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq2+" WHERE `idequipe`= "+equipe2.getId()+" AND `idmatchs`= "+match.getId()+"");
            
            equipe1.setBm(butEq1);equipe1.setBe(butEq2);
            eqDAO.modifButM(equipe1.getBm(),equipe1.getNom());
            eqDAO.modifButE(equipe1.getBe(),equipe1.getNom());
            eqDAO.modifDiff(equipe1.getBm(),equipe1.getBe(),equipe1.getNom());
                                
            equipe2.setBm(butEq2);equipe2.setBe(butEq1);
            eqDAO.modifButM(equipe2.getBm(),equipe2.getNom());
            eqDAO.modifButE(equipe2.getBe(),equipe2.getNom());
            eqDAO.modifDiff(equipe2.getBm(),equipe2.getBe(),equipe2.getNom());
            
            if(butEq1 > butEq2){
                equipe1.setJr(1);equipe1.setG(1);equipe1.setPts(equipe1.calculPts(equipe1.getJr(),equipe1.getG(),equipe1.getN(),equipe1.getP()));
                eqDAO.modifJr(equipe1.getJr(),equipe1.getNom());
                eqDAO.modifGagne(equipe1.getG(),equipe1.getNom());
                eqDAO.modifPts(equipe1.getPts(),equipe1.getNom());
                                    
                equipe2.setJr(1);equipe2.setP(1);
                eqDAO.modifJr(equipe2.getJr(),equipe2.getNom());
                eqDAO.modifPerdu(equipe2.getP(),equipe2.getNom());
                eqDAO.modifPts(equipe2.getPts(),equipe2.getNom());
            }else if(butEq1 < butEq2){
                 equipe1.setJr(1);equipe1.setP(1);
                 eqDAO.modifJr(equipe1.getJr(),equipe1.getNom());
                 eqDAO.modifPerdu(equipe1.getP(),equipe1.getNom());
                 eqDAO.modifPts(equipe1.getPts(),equipe1.getNom());
                                    
                 equipe2.setJr(1);equipe2.setG(1);equipe2.setPts(equipe2.calculPts(equipe2.getJr(),equipe2.getG(),equipe2.getN(),equipe2.getP()));
                 eqDAO.modifJr(equipe2.getJr(),equipe2.getNom());
                 eqDAO.modifGagne(equipe2.getG(),equipe2.getNom());
                 eqDAO.modifPts(equipe2.getPts(),equipe2.getNom());
            }else if(butEq1 == butEq2){
                equipe1.setJr(1);equipe1.setN(1);equipe1.setPts(equipe1.calculPts(equipe1.getJr(),equipe1.getG(),equipe1.getN(),equipe1.getP()));
                eqDAO.modifJr(equipe1.getJr(),equipe1.getNom());
                eqDAO.modifNul(equipe1.getN(),equipe1.getNom());
                eqDAO.modifPts(equipe1.getPts(),equipe1.getNom());
                                    
                equipe2.setJr(1);equipe2.setN(1);equipe2.setPts(equipe2.calculPts(equipe2.getJr(),equipe2.getG(),equipe2.getN(),equipe2.getP()));
                eqDAO.modifJr(equipe2.getJr(),equipe2.getNom());
                eqDAO.modifNul(equipe2.getN(),equipe2.getNom());
                eqDAO.modifPts(equipe2.getPts(),equipe2.getNom());
            }
            
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
    }
   
    /**
     * méthode DAO permettant de créer un match de quart de final 
     * automatiquement
     * @param num int désignant l'id d'un match de quart
     * @param lieu String désignant le lieu d'un match
     * @param arbitre String désignant le nom et le prénom d'un arbitre
     * @param date String désignant la date du match
     */
    public void creerMatchQuart(int num,String lieu,String arbitre,String date){
        try{
            Match match = new Match();
            EditionDAO editionDAO = new EditionDAO();
            ArrayList<Equipe> listEquipe1 = new ArrayList<>();
            ArrayList<Equipe> listEquipe2 = new ArrayList<>();
            QuartDAO quartDAO = new QuartDAO();
            ArrayList<Quart> quart = quartDAO.afficher(editionDAO.cherche().getId());
            int pre = 1;
            int deu = 2;
            String selectEq1 = "SELECT * FROM `equipe` WHERE `rg`="+pre+" and `idpoule` in(select `idpoule` from `poule` where `idedition`="+editionDAO.cherche().getId()+") order by `idpoule`";
            String selectEq2 = "SELECT * FROM `equipe` WHERE `rg`="+deu+" and `idpoule` in(select `idpoule` from `poule` where `idedition`="+editionDAO.cherche().getId()+") order by `idpoule`";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(selectEq1);
                while(res.next()){
                    listEquipe1.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                res = state.executeQuery(selectEq2);
                while(res.next()){
                    listEquipe2.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                
                if(num == 0){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idquart`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+quart.get(0).id()+")"); 
                }else if(num == 1){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idquart`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+quart.get(1).id()+")"); 
                }else if(num == 2){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idquart`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+quart.get(2).id()+")"); 
                }else if(num == 3){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idquart`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+quart.get(3).id()+")"); 
                }
                
                
                String select = "SELECT max(`idmatchs`) as lastId FROM `matchs`";
                int id = 0;
                res = state.executeQuery(select);
                while(res.next()){
                    id = res.getInt("lastId");
                }
                if((num + 1) == 1){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(0).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(1).getId()+","+id+")");
                }
                else if((num + 1)==2){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(1).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(0).getId()+","+id+")");
                }
                else if((num + 1)==3){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(2).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(3).getId()+","+id+")");
                }
                else if((num + 1)==4){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(3).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(2).getId()+","+id+")");
                }
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    /**
     * méthode DAO permettant de gérer les résultats d'un match de quart de final
     * @param idmatch int désignant l'id du match de quart
     * @param nom_Eq1 String désignant le nom de la 1ère équipe
     * @param butEq1 int désignant le nombre de but de la 1ère équipe
     * @param nom_Eq2 String désignant le nom de la 2e équipe
     * @param butEq2 int désignant le nombre de but de la 2e équipe
     */
    public void resultatMatchQuart(int idmatch,String nom_Eq1,int butEq1,String nom_Eq2,int butEq2){
        
        try{
            Match match = new Match();
            EquipeDAO eqDAO = new EquipeDAO();
            String match1 = "select * from `matchs` where `idmatchs`="+idmatch;
            Equipe equipe1 = new Equipe();
            Equipe equipe2 = new Equipe();
            String Eq1 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq1+"')";
            String Eq2 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq2+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(match1);
                
                while(res.next()){
                    match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"), res.getBoolean("joue"));
                }
                state.executeUpdate("UPDATE `matchs` SET `joue`= 1  WHERE `idmatchs`="+match.getId()+"");
                
                res = state.executeQuery(Eq1);
                while(res.next()){
                    equipe1 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                res = state.executeQuery(Eq2);
                while(res.next()){
                    equipe2 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq1+" WHERE `idequipe`= "+equipe1.getId()+" AND `idmatchs`= "+match.getId()+"");
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq2+" WHERE `idequipe`= "+equipe2.getId()+" AND `idmatchs`= "+match.getId()+"");
                
                equipe1.setBm(butEq1);equipe1.setBe(butEq2);
                eqDAO.modifButM(equipe1.getBm(),equipe1.getNom());
                eqDAO.modifButE(equipe1.getBe(),equipe1.getNom());
                eqDAO.modifDiff(equipe1.getBm(),equipe1.getBe(),equipe1.getNom());
                
                equipe2.setBm(butEq2);equipe2.setBe(butEq1);
                eqDAO.modifButM(equipe2.getBm(),equipe2.getNom());
                eqDAO.modifButE(equipe2.getBe(),equipe2.getNom());
                eqDAO.modifDiff(equipe2.getBm(),equipe2.getBe(),equipe2.getNom());
                
                if(butEq1 > butEq2){
                    eqDAO.qualifDemi(nom_Eq1);
                }else if(butEq1 < butEq2){
                    eqDAO.qualifDemi(nom_Eq2);
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
                Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
            } 
    }
   
    /**
     * méthode DAO permettant de créer un match de demi de final 
     * automatiquement
     * @param num int désignant l'id d'un match de quart
     * @param lieu String désignant le lieu d'un match
     * @param arbitre String désignant le nom et le prénom d'un arbitre
     * @param date String désignant la date du match 
     */
    public void creerMatchDemi(int num,String lieu,String arbitre,String date){
        try{
            EditionDAO editionDAO = new EditionDAO();
            ArrayList<Equipe> listEquipe1 = new ArrayList<>();
            ArrayList<Equipe> listEquipe2 = new ArrayList<>();
            
            QuartDAO quartDAO = new QuartDAO();
            ArrayList<Quart> quart = quartDAO.afficher(editionDAO.cherche().getId());
            
            DemiDAO demiDAO = new DemiDAO();
            ArrayList<Demi> demi = demiDAO.afficher(editionDAO.cherche().getId());
            
            String selectEq1 = "SELECT * FROM `equipe` WHERE `idequipe` in(select `idequipe` from `equipe_matchs` where `idmatchs` in (select `idmatchs` from `matchs` where `idquart`="+quart.get(0).id()+" or `idquart`="+quart.get(3).id()+")) and `demi`="+1;
            String selectEq2 = "SELECT * FROM `equipe` WHERE `idequipe` in(select `idequipe` from `equipe_matchs` where `idmatchs` in (select `idmatchs` from `matchs` where `idquart`="+quart.get(1).id()+" or `idquart`="+quart.get(2).id()+")) and `demi`="+1;
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(selectEq1);
                while(res.next()){
                    listEquipe1.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                res = state.executeQuery(selectEq2);
                while(res.next()){
                    listEquipe2.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                
                if(num == 0){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`iddemi`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+demi.get(0).getId()+")"); 
                }else if(num == 1){
                   state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`iddemi`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+demi.get(1).getId()+")"); 
                }
                
                String select = "SELECT max(`idmatchs`) as lastId FROM `matchs`";
                int id = 0;
                res = state.executeQuery(select);
                while(res.next()){
                    id = res.getInt("lastId");
                }
                if((num + 1)==1){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(0).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(1).getId()+","+id+")");
                }
                else if((num + 1)==2){
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(1).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe2.get(0).getId()+","+id+")");
                }              
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    /**
     * méthode DAO permettant de gérer les résultats d'un match de demi de final
     * @param idmatch int désignant l'id du match de quart
     * @param nom_Eq1 String désignant le nom de la 1ère équipe
     * @param butEq1 int désignant le nombre de but de la 1ère équipe
     * @param nom_Eq2 String désignant le nom de la 2e équipe
     * @param butEq2 int désignant le nombre de but de la 2e équipe 
     */
    public void resultatMatchDemi(int idmatch,String nom_Eq1,int butEq1,String nom_Eq2,int butEq2){
       try{
            Match match = new Match();
            EquipeDAO eqDAO = new EquipeDAO();
            String match1 = "select * from `matchs` where `idmatchs`="+idmatch;
            Equipe equipe1 = new Equipe();
            Equipe equipe2 = new Equipe();
            String Eq1 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq1+"')";
            String Eq2 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq2+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(match1);
                
                while(res.next()){
                    match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"), res.getBoolean("joue"));
                }
                state.executeUpdate("UPDATE `matchs` SET `joue`= 1  WHERE `idmatchs`="+match.getId()+"");
                
                res = state.executeQuery(Eq1);
                while(res.next()){
                    equipe1 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                res = state.executeQuery(Eq2);
                while(res.next()){
                    equipe2 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq1+" WHERE `idequipe`= "+equipe1.getId()+" AND `idmatchs`= "+match.getId()+"");
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq2+" WHERE `idequipe`= "+equipe2.getId()+" AND `idmatchs`= "+match.getId()+"");
                
                equipe1.setBm(butEq1);equipe1.setBe(butEq2);
                eqDAO.modifButM(equipe1.getBm(),equipe1.getNom());
                eqDAO.modifButE(equipe1.getBe(),equipe1.getNom());
                eqDAO.modifDiff(equipe1.getBm(),equipe1.getBe(),equipe1.getNom());
                
                equipe2.setBm(butEq2);equipe2.setBe(butEq1);
                eqDAO.modifButM(equipe2.getBm(),equipe2.getNom());
                eqDAO.modifButE(equipe2.getBe(),equipe2.getNom());
                eqDAO.modifDiff(equipe2.getBm(),equipe2.getBe(),equipe2.getNom());
                
                if(butEq1 > butEq2){
                    eqDAO.qualifFinale(nom_Eq1);
                    eqDAO.qualifPfinale(nom_Eq2);
                }else if(butEq1 < butEq2){
                    eqDAO.qualifFinale(nom_Eq2);
                    eqDAO.qualifPfinale(nom_Eq1);
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
                Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
            }  
    }
    
    /**
     * méthode DAO permettant de créer un match de 3e place
     * automatiquement
     * @param lieu String désignant le lieu d'un match
     * @param arbitre String désignant le nom et le prénom d'un arbitre
     * @param date String désignant la date du match 
     */
    public void creerMatchPfinale(String lieu,String arbitre,String date){
        try{
            EditionDAO editionDAO = new EditionDAO();
            PfinaleDAO pfDAO = new PfinaleDAO();
            Pfinale pfinale = pfDAO.afficher(editionDAO.cherche().getId());
            ArrayList<Equipe> listEquipe1 = new ArrayList<>();
            String selectEq1 = "SELECT * FROM `equipe` WHERE `idequipe` in(select `idequipe` from `equipe_matchs` where `idmatchs` in (select `idmatchs` from `matchs` where `pfinale`="+1+"))";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(selectEq1);
                while(res.next()){
                    listEquipe1.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idpfinale`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+pfinale.getId()+")");
                
                String select = "SELECT max(`idmatchs`) as lastId FROM `matchs`";
                int id = 0;
                res = state.executeQuery(select);
                while(res.next()){
                    id = res.getInt("lastId");
                }               
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(0).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(1).getId()+","+id+")");
                             
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    /**
     * méthode DAO permettant de gérer les résultats d'un match de 3e place
     * @param idmatch int désignant l'id du match de quart
     * @param nom_Eq1 String désignant le nom de la 1ère équipe
     * @param butEq1 int désignant le nombre de but de la 1ère équipe
     * @param nom_Eq2 String désignant le nom de la 2e équipe
     * @param butEq2 int désignant le nombre de but de la 2e équipe 
     */
    public void resultatMatchPfinale(int idmatch,String nom_Eq1,int butEq1,String nom_Eq2,int butEq2){
        try{
            Match match = new Match();
            EquipeDAO eqDAO = new EquipeDAO();
            String match1 = "select * from `matchs` where `idmatchs`="+idmatch;
            Equipe equipe1 = new Equipe();
            Equipe equipe2 = new Equipe();
            String Eq1 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq1+"')";
            String Eq2 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq2+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(match1);
                
                while(res.next()){
                    match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"), res.getBoolean("joue"));
                }
                state.executeUpdate("UPDATE `matchs` SET `joue`= 1  WHERE `idmatchs`="+match.getId()+"");
                
                res = state.executeQuery(Eq1);
                while(res.next()){
                    equipe1 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                res = state.executeQuery(Eq2);
                while(res.next()){
                    equipe2 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq1+" WHERE `idequipe`= "+equipe1.getId()+" AND `idmatchs`= "+match.getId()+"");
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq2+" WHERE `idequipe`= "+equipe2.getId()+" AND `idmatchs`= "+match.getId()+"");
                
                equipe1.setBm(butEq1);equipe1.setBe(butEq2);
                eqDAO.modifButM(equipe1.getBm(),equipe1.getNom());
                eqDAO.modifButE(equipe1.getBe(),equipe1.getNom());
                eqDAO.modifDiff(equipe1.getBm(),equipe1.getBe(),equipe1.getNom());
                
                equipe2.setBm(butEq2);equipe2.setBe(butEq1);
                eqDAO.modifButM(equipe2.getBm(),equipe2.getNom());
                eqDAO.modifButE(equipe2.getBe(),equipe2.getNom());
                eqDAO.modifDiff(equipe2.getBm(),equipe2.getBe(),equipe2.getNom());
                
                if(butEq1 > butEq2){
                    JOptionPane.showMessageDialog(null, nom_Eq1 +" termine 3e de cette édition de la coupe d'afrique des nations \n et "+nom_Eq2+" 4e de la compétition");
                }else if(butEq1 < butEq2){
                    JOptionPane.showMessageDialog(null, nom_Eq2 +" termine 3e de cette édition de la coupe d'afrique des nations \n et "+nom_Eq1+" 4e de la compétition");
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
                Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
            }
    }
    
    /**
     * méthode DAO permettant de créer un match de final
     * automatiquement
     * @param lieu String désignant le lieu d'un match
     * @param arbitre String désignant le nom et le prénom d'un arbitre
     * @param date String désignant la date du match 
     */
    public void creerMatchFinale(String lieu,String arbitre,String date){
       try{
            EditionDAO editionDAO = new EditionDAO();
            FinaleDAO fDAO = new FinaleDAO();
            Finale finale = fDAO.afficher(editionDAO.cherche().getId());
            ArrayList<Equipe> listEquipe1 = new ArrayList<>();
            String selectEq1 = "SELECT * FROM `equipe` WHERE `idequipe` in(select `idequipe` from `equipe_matchs` where `idmatchs` in (select `idmatchs` from `matchs` where `finale`="+1+"))";
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(selectEq1);
                while(res.next()){
                    listEquipe1.add(new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur")));
                }
                state.executeUpdate("INSERT INTO `matchs`(`lieu`, `arbitre`, `datem`, `joue`,`idfinale`) VALUES('"+lieu+"','"+arbitre+"','"+date+"',0,"+finale.getId()+")");
                
                String select = "SELECT max(`idmatchs`) as lastId FROM `matchs`";
                int id = 0;
                res = state.executeQuery(select);
                while(res.next()){
                    id = res.getInt("lastId");
                }               
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(0).getId()+","+id+")");
                state.executeUpdate("INSERT INTO `equipe_matchs`(`idequipe`, `idmatchs`) VALUES ("+listEquipe1.get(1).getId()+","+id+")");
                             
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
            Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
        } 
    }
    
    /**
     * méthode DAO permettant de gérer les résultats d'un match de  final
     * @param idmatch int désignant l'id du match de quart
     * @param nom_Eq1 String désignant le nom de la 1ère équipe
     * @param butEq1 int désignant le nombre de but de la 1ère équipe
     * @param nom_Eq2 String désignant le nom de la 2e équipe
     * @param butEq2 int désignant le nombre de but de la 2e équipe 
     */
    public void resultatMatchFinale(int idmatch,String nom_Eq1,int butEq1,String nom_Eq2,int butEq2){
        try{
            Match match = new Match();
            EquipeDAO eqDAO = new EquipeDAO();
            String match1 = "select * from `matchs` where `idmatchs`="+idmatch;
            Equipe equipe1 = new Equipe();
            Equipe equipe2 = new Equipe();
            String Eq1 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq1+"')";
            String Eq2 = "select * from `equipe` where `idequipe` = (select max(`idequipe`) from `equipe` where `Nom_eq`= '"+nom_Eq2+"')";
            
            try{
                Statement state = connect.createStatement();
                ResultSet res = state.executeQuery(match1);
                
                while(res.next()){
                    match = new Match(res.getInt("idmatchs"), res.getString("lieu"), res.getString("arbitre"), (String) res.getObject("datem"), res.getBoolean("joue"));
                }
                state.executeUpdate("UPDATE `matchs` SET `joue`= 1  WHERE `idmatchs`="+match.getId()+"");
                
                res = state.executeQuery(Eq1);
                while(res.next()){
                    equipe1 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                res = state.executeQuery(Eq2);
                while(res.next()){
                    equipe2 = new Equipe(res.getInt("idequipe"), res.getString("nom_eq"), res.getInt("rg"), res.getInt("jr"), res.getInt("g"), res.getInt("n"), res.getInt("p"), res.getInt("bm"), res.getInt("be"), res.getInt("diff"), res.getInt("pts"), res.getInt("nbpar"), res.getBoolean("quart"), res.getBoolean("demi"), res.getBoolean("pfinale"), res.getBoolean("finale"),res.getBoolean("vainqueur"));
                }
                
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq1+" WHERE `idequipe`= "+equipe1.getId()+" AND `idmatchs`= "+match.getId()+"");
                state.executeUpdate("UPDATE `equipe_matchs` SET `score`= "+butEq2+" WHERE `idequipe`= "+equipe2.getId()+" AND `idmatchs`= "+match.getId()+"");
                
                equipe1.setBm(butEq1);equipe1.setBe(butEq2);
                eqDAO.modifButM(equipe1.getBm(),equipe1.getNom());
                eqDAO.modifButE(equipe1.getBe(),equipe1.getNom());
                eqDAO.modifDiff(equipe1.getBm(),equipe1.getBe(),equipe1.getNom());
                
                equipe2.setBm(butEq2);equipe2.setBe(butEq1);
                eqDAO.modifButM(equipe2.getBm(),equipe2.getNom());
                eqDAO.modifButE(equipe2.getBe(),equipe2.getNom());
                eqDAO.modifDiff(equipe2.getBm(),equipe2.getBe(),equipe2.getNom());
                
                if(butEq1 > butEq2){
                    eqDAO.gagne(nom_Eq1);
                    JOptionPane.showMessageDialog(null, nom_Eq1 +" remporte cette édition de la coupe d'afrique des nations \n et "+nom_Eq2+" termine 2e de la compétition");
                }else if(butEq1 < butEq2){
                    eqDAO.gagne(nom_Eq2);
                    JOptionPane.showMessageDialog(null, nom_Eq2 +" remporte cette édition de la coupe d'afrique des nations \n et "+nom_Eq1+" termine 2e de la compétition");
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erreur......"+e.getMessage());
            }
        }catch(SQLException ex){
                Logger.getLogger(MatchDAO.class.getName()).log(Level.SEVERE,null, ex);
            }
    }  
}
