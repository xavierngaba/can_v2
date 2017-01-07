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
public class ClassementPouleC extends javax.swing.JFrame {

    /**
     * Creates new form ClassementPoule
     */
    public ClassementPouleC() {
        initComponents();
        try {
            // TODO add your handling code here:
            PouleDAO pouleDAO = new PouleDAO();
            EditionDAO editionDAO = new EditionDAO();
            EquipeDAO equipeDAO = new EquipeDAO();
            Edition edition = editionDAO.cherche();
            Poule poule = pouleDAO.afficher("C", edition.getId());
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel1.setText("Classsement d'une Poule");

        jLabel2.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel2.setText("Poule");

        cb1.setFont(new java.awt.Font("Felix Titling", 0, 11)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        cb1.setSelectedIndex(2);
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
                "Rang", "Equipe", "J", "G", "N", "P", "Bm", "Be", "Diff", "Pts"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(0, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caf - Copy.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jButton1)))
                .addGap(0, 286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ClassementPouleC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassementPouleC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassementPouleC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassementPouleC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassementPouleC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
