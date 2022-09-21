/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcorp;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DC
 */
public final class Dettes extends javax.swing.JPanel {

    /**
     * Creates new form Client
     */
    Connect conn = new Connect();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model = new DefaultTableModel();

    public Dettes() {
        initComponents();

        identifiant.setEditable(false);

        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Montant");
        model.addColumn("Date Paiement");

        Afficher();

        listeDettes.setRowHeight(25);
        listeDettes.setShowGrid(true);
        listeDettes.setGridColor(new Color(102, 102, 102));
        listeDettes.setSelectionBackground(new Color(0, 108, 155));

    }

    //METHODES****************************************************************************************************************
    void Afficher() {
        try {
            model.setRowCount(0);
            stm = conn.obtenirconnexion().createStatement();
            Rs = stm.executeQuery("select * from dette");
            while (Rs.next()) {
                model.addRow(new Object[]{
                    Rs.getString("codeDette"),
                    Rs.getString("nom"),
                    Rs.getString("montant"),
                    Rs.getString("datePayement")
                });
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        listeDettes.setModel(model);
    }

    void Inserer() {
        try {
            String name = nom.getText();
            String amount = montant.getText();
            String thedate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String requete = "insert into dette(nom,montant,datePayement) VALUES ('"
                    + name + "','"
                    + amount + "','"
                    + thedate + "')";
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Enregistrement reussi");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
    }

    void Modifier() {
        try {
            if (JOptionPane.showConfirmDialog(null, "Confirmer la modification", "Modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                String name = nom.getText();
                String amount = montant.getText();
                String thedate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
                stm.executeUpdate(
                        "UPDATE dette SET nom='"
                        + name
                        + "', montant='"
                        + amount
                        + "',datePayement='"
                        + thedate
                        + "' WHERE codeDette=" + identifiant.getText()
                );
                JOptionPane.showMessageDialog(null, "Modifications reussies");
                Afficher();
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de modification" + e.getMessage());
            System.err.println(e);
        }
    }

    void Supprimer() {
        try {
            if (JOptionPane.showConfirmDialog(null, "Attention, voulez-vous vraiment faire cette opération de suppression?", "Suppression",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (identifiant.getText().length() != 0) {
                    stm.executeUpdate("Delete From dette where codeDette = " + identifiant.getText());
                    Afficher();
                    JOptionPane.showMessageDialog(null, "Suppression reussie");
                }
            }
            Afficher();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de suppression" + e.getMessage());
        }
    }

    void deplace(int i) {
        try {
            identifiant.setText(model.getValueAt(i, 0).toString());
            nom.setText(model.getValueAt(i, 1).toString());
            montant.setText(model.getValueAt(i, 2).toString());
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }
    }

    void Actualiser() {
        identifiant.setText("");
        nom.setText("");
        date.setDate(null);
        sc.setText("");
        montant.setText("");
    }
    void Exit(){
        if(JOptionPane.showConfirmDialog(null, "Voluez-vous vraiment quitter ce programme?","Quitter",
            JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                System.exit(0);
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

        acceuil = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        identifiant = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        montant = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeDettes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acceuil.setBackground(new java.awt.Color(255, 255, 255));
        acceuil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        identifiant.setEditable(false);
        identifiant.setEnabled(false);
        identifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantjTextField2ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel42.setText("Code Dette");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_32.png"))); // NOI18N
        jLabel12.setText("Ajouter");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modify_32.png"))); // NOI18N
        jLabel13.setText("Modifier");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomjTextField2ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel58.setText("Nom");

        jLabel59.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel59.setText("DatePayement");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_32.png"))); // NOI18N
        jLabel14.setText("Supprimer");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_32.png"))); // NOI18N
        jLabel15.setText("Actualiser");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel60.setText("Montant");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sr_16.png"))); // NOI18N

        sc.setBackground(new java.awt.Color(204, 204, 204));
        sc.setBorder(null);
        sc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scjTextField2ActionPerformed(evt);
            }
        });
        sc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                scKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        montant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montantjTextField2ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel15)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(18, 18, 18)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 366, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        acceuil.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 190));

        listeDettes.setBackground(new java.awt.Color(204, 204, 204));
        listeDettes.setFont(new java.awt.Font("Aeroportal", 0, 12)); // NOI18N
        listeDettes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listeDettes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeDettesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listeDettes);

        acceuil.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 810, 290));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_32.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        acceuil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 40, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DETTES");
        acceuil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back2.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        acceuil.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));

        add(acceuil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void identifiantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identifiantjTextField2ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Inserer();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Modifier();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void nomjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjTextField2ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Actualiser();

    }//GEN-LAST:event_jLabel15MouseClicked

    private void listeDettesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeDettesMouseClicked
        try {
            int i = listeDettes.getSelectedRow();
            deplace(i);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }              // TODO add your handling code here:
    }//GEN-LAST:event_listeDettesMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Exit();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void scjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scjTextField2ActionPerformed

    private void scKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scKeyReleased
        DefaultTableModel table = (DefaultTableModel) listeDettes.getModel();
        String search = sc.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        listeDettes.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_scKeyReleased

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Supprimer();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void montantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montantjTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acceuil;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField identifiant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listeDettes;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField sc;
    // End of variables declaration//GEN-END:variables
}
