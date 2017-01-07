/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import coucheDAO.DemiDAO;
import coucheDAO.EditionDAO;
import coucheDAO.EquipeDAO;
import coucheDAO.FinaleDAO;
import coucheDAO.MatchDAO;
import coucheDAO.PfinaleDAO;
import coucheDAO.PouleDAO;
import coucheDAO.QuartDAO;
import demi.Demi;
import edition.Edition;
import equipe.Equipe;
import finale.Finale;
import java.math.MathContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import match.Match;
import pfinale.Pfinale;
import poule.Poule;
import quart.Quart;

/**
 *
 * @author Landry
 */
public class ResultatMatchs extends javax.swing.JFrame {

    /**
     * Creates new form AfficherRencontre
     */
    public ResultatMatchs() {
        initComponents();
        jComboBox1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel1.setText("ReSULTATS DES MATCHS");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel2.setText("Edition");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jRadioButton1.setText("Poule");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jRadioButton2.setText("1/4");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jRadioButton3.setText("1/2");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jRadioButton4.setText("3e place");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jRadioButton5.setText("Finale");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},

            },
            new String [] {
                "Date et Heure", "Lieu", "Arbitre"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caf - Copy.gif"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        jComboBox1.setVisible(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        try{
            EditionDAO edDAO = new EditionDAO();
            Edition edition = edDAO.cherche();
            jLabel4.setText(edition.getAnnee());
        }catch(SQLException ex){

        }

        jTable2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null,null,null, null, null},

            },
            new String [] {
                "   Equipe 1    ","","-","","   Equipe 2    "
            }
        ));
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jButton1.setText("fermer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
          // TODO add your handling code here:
        jComboBox1.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jComboBox1.setVisible(false); 
        try {
            // TODO add your handling code here:
            EditionDAO edDAO = new EditionDAO();
            Edition ed = edDAO.cherche();
            QuartDAO quartDAO = new QuartDAO();
            ArrayList<Quart> quart = quartDAO.afficher(edDAO.cherche().getId());
            MatchDAO matchDAO = new MatchDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            ArrayList<Equipe> equipe =  new ArrayList<>();
            ArrayList<Match> matchs = new ArrayList<>();
            for(int i = 0; i < jComboBox1.getItemCount(); i++){
               matchs.add(matchDAO.ChercheMatch(quart.get(i).id())); 
            }
            
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchs.get(0).getDate(), matchs.get(0).getLieu(), matchs.get(0).getArbitre()},
                            {matchs.get(1).getDate(), matchs.get(1).getLieu(), matchs.get(1).getArbitre()},
                            {matchs.get(2).getDate(), matchs.get(2).getLieu(), matchs.get(2).getArbitre()},
                            {matchs.get(3).getDate(), matchs.get(3).getLieu(), matchs.get(3).getArbitre()},
                            },
                        new String [] {
                            "Date et Heure", "Lieu", "Arbitre"}
                ) );
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getId(), matchs.get(0).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getId(), matchs.get(0).getId()),matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getId(), matchs.get(1).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getId(), matchs.get(1).getId()),matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getNom() },
                            {matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(0).getId(), matchs.get(2).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(1).getId(), matchs.get(2).getId()),matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(0).getId(), matchs.get(3).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(1).getId(), matchs.get(3).getId()),matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(1).getNom() },
                        },
                        new String [] {
                            "   Equipe 1   ","","-","","  Equipe 2  "}
                ) );
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatchs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jComboBox1.setVisible(false);
        
        try {
            // TODO add your handling code here:
            EditionDAO edDAO = new EditionDAO();
            Edition ed = edDAO.cherche();
            DemiDAO demiDAO = new DemiDAO();
            ArrayList<Demi> demi = demiDAO.afficher(edDAO.cherche().getId());
            MatchDAO matchDAO = new MatchDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            ArrayList<Equipe> equipe =  new ArrayList<>();
            ArrayList<Match> matchs = new ArrayList<>();
            for(int i = 0; i < jComboBox1.getItemCount(); i++){
               matchs.add(matchDAO.ChercheMatchDemi(demi.get(i).getId())); 
            }
            
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchs.get(0).getDate(), matchs.get(0).getLieu(), matchs.get(0).getArbitre()},
                            {matchs.get(1).getDate(), matchs.get(1).getLieu(), matchs.get(1).getArbitre()},
                            },
                        new String [] {
                            "Date et Heure", "Lieu", "Arbitre"}
                ) );
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getId(), matchs.get(0).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getId(), matchs.get(0).getId()),matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getId(), matchs.get(1).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getId(), matchs.get(1).getId()),matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getNom() },
                        },
                        new String [] {
                            "   Equipe 1   ","","-","","  Equipe 2  "}
                ) );
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatchs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jComboBox1.setVisible(false);
        
        try {
            // TODO add your handling code here:
            EditionDAO edDAO = new EditionDAO();
            Edition ed = edDAO.cherche();
            PfinaleDAO pfDAO = new PfinaleDAO();
            Pfinale pfinale = pfDAO.afficher(edDAO.cherche().getId());
            MatchDAO matchDAO = new MatchDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            ArrayList<Equipe> equipe =  new ArrayList<>();
            Match matchs = new Match();
               matchs = matchDAO.ChercheMatchPfinale(pfinale.getId()); 
            
            
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchs.getDate(), matchs.getLieu(), matchs.getArbitre()},
                            },
                        new String [] {
                            "Date et Heure", "Lieu", "Arbitre"}
                ) );
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchDAO.chercherEquipeMatch(matchs.getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.getId()).get(0).getId(), matchs.getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.getId()).get(1).getId(), matchs.getId()),matchDAO.chercherEquipeMatch(matchs.getId()).get(1).getNom()},
                        },
                        new String [] {
                            "   Equipe 1   ","","-","","  Equipe 2  "}
                ) );
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatchs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jComboBox1.setVisible(false);
        try {
            // TODO add your handling code here:
            EditionDAO edDAO = new EditionDAO();
            Edition ed = edDAO.cherche();
            FinaleDAO fDAO = new FinaleDAO();
            Finale finale = fDAO.afficher(edDAO.cherche().getId());
            MatchDAO matchDAO = new MatchDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            ArrayList<Equipe> equipe =  new ArrayList<>();
            Match matchs = new Match();
               matchs = matchDAO.ChercheMatchFinale(finale.getId()); 
            
            
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchs.getDate(), matchs.getLieu(), matchs.getArbitre()},
                            },
                        new String [] {
                            "Date et Heure", "Lieu", "Arbitre"}
                ) );
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchDAO.chercherEquipeMatch(matchs.getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.getId()).get(0).getId(), matchs.getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.getId()).get(1).getId(), matchs.getId()),matchDAO.chercherEquipeMatch(matchs.getId()).get(1).getNom()},
                        },
                        new String [] {
                            "   Equipe 1   ","","-","","  Equipe 2  "}
                ) );
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatchs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            PouleDAO pouleDAO = new PouleDAO();
            EditionDAO editionDAO = new EditionDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            Edition edition = editionDAO.cherche();
            Poule poule = pouleDAO.afficher((String)jComboBox1.getSelectedItem(), edition.getId());
            MatchDAO matchDAO = new MatchDAO();
            ArrayList<Equipe> equipe =  new ArrayList<>();
            ArrayList<Match> matchs = new ArrayList<>();
            matchs = matchDAO.chercherMatch((poule.getId()));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchs.get(0).getDate(), matchs.get(0).getLieu(), matchs.get(0).getArbitre()},
                            {matchs.get(1).getDate(), matchs.get(1).getLieu(), matchs.get(1).getArbitre()},
                            {matchs.get(2).getDate(), matchs.get(2).getLieu(), matchs.get(2).getArbitre()},
                            {matchs.get(3).getDate(), matchs.get(3).getLieu(), matchs.get(3).getArbitre()},
                            {matchs.get(4).getDate(), matchs.get(4).getLieu(), matchs.get(4).getArbitre()},
                            {matchs.get(5).getDate(), matchs.get(5).getLieu(), matchs.get(5).getArbitre()},
                            },
                        new String [] {
                            "Date et Heure", "Lieu", "Arbitre"}
                ) );
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(0).getId(), matchs.get(0).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getId(), matchs.get(0).getId()),matchDAO.chercherEquipeMatch(matchs.get(0).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(0).getId(), matchs.get(1).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getId(), matchs.get(1).getId()),matchDAO.chercherEquipeMatch(matchs.get(1).getId()).get(1).getNom() },
                            {matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(0).getId(), matchs.get(2).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(1).getId(), matchs.get(2).getId()),matchDAO.chercherEquipeMatch(matchs.get(2).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(0).getId(), matchs.get(3).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(1).getId(), matchs.get(3).getId()),matchDAO.chercherEquipeMatch(matchs.get(3).getId()).get(1).getNom() },
                            {matchDAO.chercherEquipeMatch(matchs.get(4).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(4).getId()).get(0).getId(), matchs.get(4).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(4).getId()).get(1).getId(), matchs.get(4).getId()),matchDAO.chercherEquipeMatch(matchs.get(4).getId()).get(1).getNom() },                        
                            {matchDAO.chercherEquipeMatch(matchs.get(5).getId()).get(0).getNom(),matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(5).getId()).get(0).getId(), matchs.get(5).getId())," - " ,matchDAO.resultScore(matchDAO.chercherEquipeMatch(matchs.get(5).getId()).get(1).getId(), matchs.get(5).getId()),matchDAO.chercherEquipeMatch(matchs.get(5).getId()).get(1).getNom() },
                        },
                        new String [] {
                            "   Equipe 1   ","","-","","  Equipe 2  "}
                ) );
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatchs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
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
            java.util.logging.Logger.getLogger(ResultatMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultatMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultatMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultatMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultatMatchs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
