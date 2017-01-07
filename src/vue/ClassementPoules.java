/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import coucheDAO.EditionDAO;
import coucheDAO.EquipeDAO;
import coucheDAO.PouleDAO;
import edition.Edition;
import equipe.Equipe;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import poule.Poule;

/**
 *
 * @author Landry
 */
public class ClassementPoules extends javax.swing.JFrame {

    /**
     * Creates new form ClassementPoule
     */
    public ClassementPoules() {
        initComponents();
        try {
            // TODO add your handling code here:
            PouleDAO pouleDAO = new PouleDAO();
            EditionDAO editionDAO = new EditionDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            Edition edition = editionDAO.cherche();
            Poule poule = pouleDAO.afficher((String)cb1.getSelectedItem(), edition.getId());
            
            ArrayList<Equipe> equipe = new ArrayList<>();
            if(pouleDAO.equipePoule(poule.getId(), edition.getId()) == 0){
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null,null,null,null,null,null,null,null,null},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 1){
                    equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getBm(), equipe.get(0).getBe(),equipe.get(0).getDiff(), equipe.get(0).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 2){
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getBm(), equipe.get(0).getBe(),equipe.get(0).getDiff(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getBm(), equipe.get(1).getBe(),equipe.get(1).getDiff(), equipe.get(1).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 3){
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getBm(), equipe.get(0).getBe(),equipe.get(0).getDiff(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getBm(), equipe.get(1).getBe(),equipe.get(1).getDiff(), equipe.get(1).getPts()},
                            {equipe.get(2).getRg(), equipe.get(2).getNom(), equipe.get(2).getJr(), equipe.get(2).getG(), equipe.get(2).getN(), equipe.get(2).getP(), equipe.get(2).getBm(), equipe.get(2).getBe(),equipe.get(2).getDiff(), equipe.get(2).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else{
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getBm(), equipe.get(0).getBe(),equipe.get(0).getDiff(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getBm(), equipe.get(1).getBe(),equipe.get(1).getDiff(), equipe.get(1).getPts()},
                            {equipe.get(2).getRg(), equipe.get(2).getNom(), equipe.get(2).getJr(), equipe.get(2).getG(), equipe.get(2).getN(), equipe.get(2).getP(), equipe.get(2).getBm(), equipe.get(2).getBe(),equipe.get(2).getDiff(), equipe.get(2).getPts()},
                            {equipe.get(3).getRg(), equipe.get(3).getNom(), equipe.get(3).getJr(), equipe.get(2).getG(), equipe.get(3).getN(), equipe.get(3).getP(), equipe.get(3).getBm(), equipe.get(3).getBe(),equipe.get(3).getDiff(), equipe.get(3).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            poule = pouleDAO.afficher((String)cb2.getSelectedItem(), edition.getId());
            ArrayList<Equipe> equipe2 = new ArrayList<>();
            if(pouleDAO.equipePoule(poule.getId(), edition.getId()) == 0){
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null,null,null,null,null,null,null,null,null},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 1){
                    equipe2 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe2.get(0).getRg(), equipe2.get(0).getNom(), equipe2.get(0).getJr(), equipe2.get(0).getG(), equipe2.get(0).getN(), equipe2.get(0).getP(), equipe2.get(0).getBm(), equipe2.get(0).getBe(),equipe2.get(0).getDiff(), equipe2.get(0).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 2){
                 equipe2 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe2.get(0).getRg(), equipe2.get(0).getNom(), equipe2.get(0).getJr(), equipe2.get(0).getG(), equipe2.get(0).getN(), equipe2.get(0).getP(), equipe2.get(0).getBm(), equipe2.get(0).getBe(),equipe2.get(0).getDiff(), equipe2.get(0).getPts()},
                            {equipe2.get(1).getRg(), equipe2.get(1).getNom(), equipe2.get(1).getJr(), equipe2.get(1).getG(), equipe2.get(1).getN(), equipe2.get(1).getP(), equipe2.get(1).getBm(), equipe2.get(1).getBe(),equipe2.get(1).getDiff(), equipe2.get(1).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 3){
                 equipe2 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe2.get(0).getRg(), equipe2.get(0).getNom(), equipe2.get(0).getJr(), equipe2.get(0).getG(), equipe2.get(0).getN(), equipe2.get(0).getP(), equipe2.get(0).getBm(), equipe2.get(0).getBe(),equipe2.get(0).getDiff(), equipe2.get(0).getPts()},
                            {equipe2.get(1).getRg(), equipe2.get(1).getNom(), equipe2.get(1).getJr(), equipe2.get(1).getG(), equipe2.get(1).getN(), equipe2.get(1).getP(), equipe2.get(1).getBm(), equipe2.get(1).getBe(),equipe2.get(1).getDiff(), equipe2.get(1).getPts()},
                            {equipe2.get(2).getRg(), equipe2.get(2).getNom(), equipe2.get(2).getJr(), equipe2.get(2).getG(), equipe2.get(2).getN(), equipe2.get(2).getP(), equipe2.get(2).getBm(), equipe2.get(2).getBe(),equipe2.get(2).getDiff(), equipe2.get(2).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else{
                 equipe2 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe2.get(0).getRg(), equipe2.get(0).getNom(), equipe2.get(0).getJr(), equipe2.get(0).getG(), equipe2.get(0).getN(), equipe2.get(0).getP(), equipe2.get(0).getBm(), equipe2.get(0).getBe(),equipe2.get(0).getDiff(), equipe2.get(0).getPts()},
                            {equipe2.get(1).getRg(), equipe2.get(1).getNom(), equipe2.get(1).getJr(), equipe2.get(1).getG(), equipe2.get(1).getN(), equipe2.get(1).getP(), equipe2.get(1).getBm(), equipe2.get(1).getBe(),equipe2.get(1).getDiff(), equipe2.get(1).getPts()},
                            {equipe2.get(2).getRg(), equipe2.get(2).getNom(), equipe2.get(2).getJr(), equipe2.get(2).getG(), equipe2.get(2).getN(), equipe2.get(2).getP(), equipe2.get(2).getBm(), equipe2.get(2).getBe(),equipe2.get(2).getDiff(), equipe2.get(2).getPts()},
                            {equipe2.get(3).getRg(), equipe2.get(3).getNom(), equipe2.get(3).getJr(), equipe2.get(2).getG(), equipe2.get(3).getN(), equipe2.get(3).getP(), equipe2.get(3).getBm(), equipe2.get(3).getBe(),equipe2.get(3).getDiff(), equipe2.get(3).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            poule = pouleDAO.afficher((String)cb3.getSelectedItem(), edition.getId());
            ArrayList<Equipe> equipe3 = new ArrayList<>();
            if(pouleDAO.equipePoule(poule.getId(), edition.getId()) == 0){
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null,null,null,null,null,null,null,null,null},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 1){
                    equipe3 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe3.get(0).getRg(), equipe3.get(0).getNom(), equipe3.get(0).getJr(), equipe3.get(0).getG(), equipe3.get(0).getN(), equipe3.get(0).getP(), equipe3.get(0).getBm(), equipe3.get(0).getBe(),equipe3.get(0).getDiff(), equipe3.get(0).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 2){
                 equipe3 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe3.get(0).getRg(), equipe3.get(0).getNom(), equipe3.get(0).getJr(), equipe3.get(0).getG(), equipe3.get(0).getN(), equipe3.get(0).getP(), equipe3.get(0).getBm(), equipe3.get(0).getBe(),equipe3.get(0).getDiff(), equipe3.get(0).getPts()},
                            {equipe3.get(1).getRg(), equipe3.get(1).getNom(), equipe3.get(1).getJr(), equipe3.get(1).getG(), equipe3.get(1).getN(), equipe3.get(1).getP(), equipe3.get(1).getBm(), equipe3.get(1).getBe(),equipe3.get(1).getDiff(), equipe3.get(1).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 3){
                 equipe3 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe3.get(0).getRg(), equipe3.get(0).getNom(), equipe3.get(0).getJr(), equipe3.get(0).getG(), equipe3.get(0).getN(), equipe3.get(0).getP(), equipe3.get(0).getBm(), equipe3.get(0).getBe(),equipe3.get(0).getDiff(), equipe3.get(0).getPts()},
                            {equipe3.get(1).getRg(), equipe3.get(1).getNom(), equipe3.get(1).getJr(), equipe3.get(1).getG(), equipe3.get(1).getN(), equipe3.get(1).getP(), equipe3.get(1).getBm(), equipe3.get(1).getBe(),equipe3.get(1).getDiff(), equipe3.get(1).getPts()},
                            {equipe3.get(2).getRg(), equipe3.get(2).getNom(), equipe3.get(2).getJr(), equipe3.get(2).getG(), equipe3.get(2).getN(), equipe3.get(2).getP(), equipe3.get(2).getBm(), equipe3.get(2).getBe(),equipe3.get(2).getDiff(), equipe3.get(2).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else{
                 equipe3 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe3.get(0).getRg(), equipe3.get(0).getNom(), equipe3.get(0).getJr(), equipe3.get(0).getG(), equipe3.get(0).getN(), equipe3.get(0).getP(), equipe3.get(0).getBm(), equipe3.get(0).getBe(),equipe3.get(0).getDiff(), equipe3.get(0).getPts()},
                            {equipe3.get(1).getRg(), equipe3.get(1).getNom(), equipe3.get(1).getJr(), equipe3.get(1).getG(), equipe3.get(1).getN(), equipe3.get(1).getP(), equipe3.get(1).getBm(), equipe3.get(1).getBe(),equipe3.get(1).getDiff(), equipe3.get(1).getPts()},
                            {equipe3.get(2).getRg(), equipe3.get(2).getNom(), equipe3.get(2).getJr(), equipe3.get(2).getG(), equipe3.get(2).getN(), equipe3.get(2).getP(), equipe3.get(2).getBm(), equipe3.get(2).getBe(),equipe3.get(2).getDiff(), equipe3.get(2).getPts()},
                            {equipe3.get(3).getRg(), equipe3.get(3).getNom(), equipe3.get(3).getJr(), equipe3.get(2).getG(), equipe3.get(3).getN(), equipe3.get(3).getP(), equipe3.get(3).getBm(), equipe3.get(3).getBe(),equipe3.get(3).getDiff(), equipe3.get(3).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            poule = pouleDAO.afficher((String)cb4.getSelectedItem(), edition.getId());
            ArrayList<Equipe> equipe4 = new ArrayList<>();
            if(pouleDAO.equipePoule(poule.getId(), edition.getId()) == 0){
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null,null,null,null,null,null,null,null,null},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 1){
                    equipe4 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe4.get(0).getRg(), equipe4.get(0).getNom(), equipe4.get(0).getJr(), equipe4.get(0).getG(), equipe4.get(0).getN(), equipe4.get(0).getP(), equipe4.get(0).getBm(), equipe4.get(0).getBe(),equipe4.get(0).getDiff(), equipe4.get(0).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 2){
                 equipe4 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe4.get(0).getRg(), equipe4.get(0).getNom(), equipe4.get(0).getJr(), equipe4.get(0).getG(), equipe4.get(0).getN(), equipe4.get(0).getP(), equipe4.get(0).getBm(), equipe4.get(0).getBe(),equipe4.get(0).getDiff(), equipe4.get(0).getPts()},
                            {equipe4.get(1).getRg(), equipe4.get(1).getNom(), equipe4.get(1).getJr(), equipe4.get(1).getG(), equipe4.get(1).getN(), equipe4.get(1).getP(), equipe4.get(1).getBm(), equipe4.get(1).getBe(),equipe4.get(1).getDiff(), equipe4.get(1).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 3){
                 equipe4 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe4.get(0).getRg(), equipe4.get(0).getNom(), equipe4.get(0).getJr(), equipe4.get(0).getG(), equipe4.get(0).getN(), equipe4.get(0).getP(), equipe4.get(0).getBm(), equipe4.get(0).getBe(),equipe4.get(0).getDiff(), equipe4.get(0).getPts()},
                            {equipe4.get(1).getRg(), equipe4.get(1).getNom(), equipe4.get(1).getJr(), equipe4.get(1).getG(), equipe4.get(1).getN(), equipe4.get(1).getP(), equipe4.get(1).getBm(), equipe4.get(1).getBe(),equipe4.get(1).getDiff(), equipe4.get(1).getPts()},
                            {equipe4.get(2).getRg(), equipe4.get(2).getNom(), equipe4.get(2).getJr(), equipe4.get(2).getG(), equipe4.get(2).getN(), equipe4.get(2).getP(), equipe4.get(2).getBm(), equipe4.get(2).getBe(),equipe4.get(2).getDiff(), equipe4.get(2).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
            else{
                 equipe4 = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe4.get(0).getRg(), equipe4.get(0).getNom(), equipe4.get(0).getJr(), equipe4.get(0).getG(), equipe4.get(0).getN(), equipe4.get(0).getP(), equipe4.get(0).getBm(), equipe4.get(0).getBe(),equipe4.get(0).getDiff(), equipe4.get(0).getPts()},
                            {equipe4.get(1).getRg(), equipe4.get(1).getNom(), equipe4.get(1).getJr(), equipe4.get(1).getG(), equipe4.get(1).getN(), equipe4.get(1).getP(), equipe4.get(1).getBm(), equipe4.get(1).getBe(),equipe4.get(1).getDiff(), equipe4.get(1).getPts()},
                            {equipe4.get(2).getRg(), equipe4.get(2).getNom(), equipe4.get(2).getJr(), equipe4.get(2).getG(), equipe4.get(2).getN(), equipe4.get(2).getP(), equipe4.get(2).getBm(), equipe4.get(2).getBe(),equipe4.get(2).getDiff(), equipe4.get(2).getPts()},
                            {equipe4.get(3).getRg(), equipe4.get(3).getNom(), equipe4.get(3).getJr(), equipe4.get(2).getG(), equipe4.get(3).getN(), equipe4.get(3).getP(), equipe4.get(3).getBm(), equipe4.get(3).getBe(),equipe4.get(3).getDiff(), equipe4.get(3).getPts()},
                        },
                        new String [] {
                            "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
                        }
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreationPoule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox();
        cb4 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel1.setText("Classsement de toutes les Poules");

        jLabel2.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel2.setText("Poule");

        cb1.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A" }));
        cb1.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        jButton1.setText("Fermer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
            },
            new String [] {
                "Rang", "Equipe", "G", "N", "P", "Bm", "Be", "Diff", "Points"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(jTable1);

        cb2.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        cb2.setSelectedIndex(1);
        cb2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel3.setText("Poule");

        jTable2.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
            },
            new String [] {
                "Rang", "Equipe", "G", "N", "P", "Bm", "Be", "Diff", "Points"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.setGridColor(new java.awt.Color(0, 204, 204));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
            },
            new String [] {
                "Rang", "Equipe", "G", "N", "P", "Bm", "Be", "Diff", "Points"
            }
        ));
        jTable3.setEnabled(false);
        jTable3.setGridColor(new java.awt.Color(0, 204, 204));
        jScrollPane3.setViewportView(jTable3);

        jLabel4.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel4.setText("Poule");

        cb3.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        cb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        cb3.setSelectedIndex(2);
        cb3.setEnabled(false);

        cb4.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        cb4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        cb4.setSelectedIndex(3);
        cb4.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel5.setText("Poule");

        jTable4.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
            },
            new String [] {
                "Rang", "Equipe", "G", "N", "P", "Bm", "Be", "Diff", "Points"
            }
        ));
        jTable4.setEnabled(false);
        jScrollPane4.setViewportView(jTable4);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caf - Copy.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(402, 402, 402)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(399, 399, 399))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(400, 400, 400))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(390, 390, 390))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(172, 172, 172)
                        .addComponent(jLabel6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassementPoules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassementPoules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassementPoules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassementPoules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassementPoules().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb1;
    private javax.swing.JComboBox cb2;
    private javax.swing.JComboBox cb3;
    private javax.swing.JComboBox cb4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
