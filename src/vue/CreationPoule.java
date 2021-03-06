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
import javax.swing.JOptionPane;
import personnel.Joueur;
import poule.Poule;

/**
 *
 * @author Dry Bass
 */
public class CreationPoule extends javax.swing.JFrame {

    /**
     * Creates new form poule
     */
    public CreationPoule() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox();
        cb2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remplissage des Poules");
        setBackground(new java.awt.Color(0, 153, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        jLabel1.setText("Poule");

        lb2.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        lb2.setText("Equipe");

        cb1.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });

        cb2.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afrique du Sud", "Algérie", "Angola", "Bénin", "Burkina Faso", "Burundi", "Botwana", "Cameroun", "Cap-Vert", "Comores", "Côte Ivoire", "Djibouti", "Egypte", "Erythrée", "Gabon", "Gambie", "Ghana", "Guinnée", "Guinnée B", "Guinnée E.", "Kenya", "Liberia", "Lybie", "Madagascar", "Malawi", "Mali", "Maroc", "Maurice", "Mozambique", "Niger", "Nigeria", "RCA", "RDC", "Sao Tomé", "Sénégal", "Soudan", "Tchad", "Togo", "Tunisie", "Zambie", "Zimbabwé" }));

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
            },
            new String [] {
                "Numero", "Pays", "J", "G", "N", "P", "Pts"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setName(""); // NOI18N
        jTable1.setSelectionBackground(new java.awt.Color(50, 211, 212));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        bt1.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        bt1.setText("Actualiser");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt3.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        bt3.setText("Ajouter");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt4.setFont(new java.awt.Font("DigifaceWide", 0, 11)); // NOI18N
        bt4.setText("Terminer");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt2.setFont(new java.awt.Font("DigifaceWide", 0, 10)); // NOI18N
        bt2.setText("Supprimer");
        bt2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("DigifaceWide", 0, 18)); // NOI18N
        jLabel3.setText("Constitution des Poules");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/can1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(138, 138, 138)))
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt3)
                            .addComponent(bt1))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bt4)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt1)
                            .addComponent(bt2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt3)
                            .addComponent(bt4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb2)
                            .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb1ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bt4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        bt2.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        try {
            // TODO add your handling code here:
            PouleDAO pouleDAO = new PouleDAO();
            EditionDAO editionDAO = new EditionDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            Edition edition = editionDAO.cherche();
            Poule poule = pouleDAO.afficher((String)cb1.getSelectedItem(), edition.getId());
            if (equipeDAO.verifParticipe((String)cb2.getSelectedItem(), edition.getId()) == false){
                if (pouleDAO.equipePoule(poule.getId(), edition.getId())!= 4)
                    pouleDAO.creer((String)cb2.getSelectedItem(), poule.getNom(), edition.getId());
                else if (pouleDAO.equipePoule(poule.getId(), edition.getId())== 4)
                    JOptionPane.showMessageDialog(null, "la Poule "+poule.getNom()+" est pleine");
            }
            else {
                JOptionPane.showMessageDialog(null, "L'equipe "+(String)cb2.getSelectedItem()+" est déja enregistrée dans une Poule");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreationPoule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
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
                            {null, null,null,null,null,null,null},
                        },
                        new String [] {
                            "Numero", "Pays", "J", "G", "N", "P", "Pts"
                        }
                ));
            }else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 1){
                    equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getPts()},
                        },
                        new String [] {
                            "Numero", "Pays", "J", "G", "N", "P", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 2){
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getPts()},
                        },
                        new String [] {
                            "Numero", "Pays", "J", "G", "N", "P", "Pts"
                        }
                ));
            }
            else if (pouleDAO.equipePoule(poule.getId(), edition.getId()) == 3){
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getPts()},
                            {equipe.get(2).getRg(), equipe.get(2).getNom(), equipe.get(2).getJr(), equipe.get(2).getG(), equipe.get(2).getN(), equipe.get(2).getP(), equipe.get(2).getPts()},
                        },
                        new String [] {
                            "Numero", "Pays", "J", "G", "N", "P", "Pts"
                        }
                ));
            }
            else{
                 equipe = equipeDAO.chercher(poule.getId(), edition.getId());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {equipe.get(0).getRg(), equipe.get(0).getNom(), equipe.get(0).getJr(), equipe.get(0).getG(), equipe.get(0).getN(), equipe.get(0).getP(), equipe.get(0).getPts()},
                            {equipe.get(1).getRg(), equipe.get(1).getNom(), equipe.get(1).getJr(), equipe.get(1).getG(), equipe.get(1).getN(), equipe.get(1).getP(), equipe.get(1).getPts()},
                            {equipe.get(2).getRg(), equipe.get(2).getNom(), equipe.get(2).getJr(), equipe.get(2).getG(), equipe.get(2).getN(), equipe.get(2).getP(), equipe.get(2).getPts()},
                            {equipe.get(3).getRg(), equipe.get(3).getNom(), equipe.get(3).getJr(), equipe.get(2).getG(), equipe.get(3).getN(), equipe.get(3).getP(), equipe.get(3).getPts()},
                        },
                        new String [] {
                            "Numero", "Pays", "J", "G", "N", "P", "Pts"
                        }
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreationPoule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(CreationPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreationPoule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JComboBox cb1;
    private javax.swing.JComboBox cb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb2;
    // End of variables declaration//GEN-END:variables
}
