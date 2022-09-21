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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DC
 */
public final class Formation extends javax.swing.JPanel {

    /**
     * Creates new form Emprunts
     */
    Connect conn = new Connect();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model = new DefaultTableModel();

    public Formation() {
        initComponents();
        identifiant.setEditable(false);

        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Statut");
        model.addColumn("Etudiant");
        model.addColumn("Montant");

        Afficher();

        ChargerComboBox();
        ChargerComboBoxStatut();

        listeFormations.setRowHeight(25);
        listeFormations.setShowGrid(true);
        listeFormations.setGridColor(new Color(102, 102, 102));
        listeFormations.setSelectionBackground(new Color(0, 108, 155));

    }

    void Afficher() {
        try {
            model.setRowCount(0);
            stm = conn.obtenirconnexion().createStatement();
            Rs = stm.executeQuery("select * from show_formation");
            while (Rs.next()) {
                model.addRow(new Object[]{
                    Rs.getString("codeFormation"),
                    Rs.getString("nomFormation"),
                    Rs.getString("statut"),
                    Rs.getString("nom"),
                    Rs.getString("montantformation")
                });
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        listeFormations.setModel(model);
    }

    void ChargerComboBox() {
        try {
            ResultSet Rs = stm.executeQuery("select * from etudiant");
            while (Rs.next()) {
                nomEtudiant.addItem(Rs.getString("nom"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    void ChargerComboBoxStatut() {
        try {
            Rs = stm.executeQuery("select * from projet");
            while (Rs.next()) {
                statut.addItem(Rs.getString("statut"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    void getId() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from etudiant where nom = '" + nomEtudiant.getSelectedItem() + "'";
            Rs = stm.executeQuery(sql);
            if (Rs.next()) {
                String id = Rs.getString("codeEtudiant");
                codeEtudiant.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    void Inserer() {
        try {
            String name = nom.getText();
            String stat = (String) statut.getSelectedItem();
            String amount = montant.getText();
            String codeEt = codeEtudiant.getText();

            String requete = "insert into formation(nomFormation,statut,montantformation,codeEtudiant) VALUES ('"
                    + name + "','"
                    + stat + "','"
                    + amount + "','"
                    + codeEt + "')";
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
                String stat = (String) statut.getSelectedItem();
                String amount = montant.getText();
                String codeEt = codeEtudiant.getText();

                stm.executeUpdate(
                        "UPDATE formation SET nomFormation='"
                        + name
                        + "', statut='"
                        + stat
                        + "',montantformation='"
                        + amount
                        + "',codeEtudiant='"
                        + codeEt
                        + "' WHERE codeFormation=" + identifiant.getText()
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
                    stm.executeUpdate("Delete From formation where codeFormation = " + identifiant.getText());
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
            montant.setText(model.getValueAt(i, 4).toString());
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }
    }

    void getIdEtudiant() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from show_formation where codeFormation = '" + identifiant.getText() + "'";
            ResultSet Res = stm.executeQuery(sql);
            if (Res.next()) {
                String id = Res.getString("codeEtudiant");
                codeEtudiant.setText(id);
            }

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }
    }

    void Actualiser() {
        identifiant.setText("");
        codeEtudiant.setText("");
        montant.setText("");
        nom.setText("");
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

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        identifiant = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        table = new javax.swing.JLabel();
        codeEtudiant = new javax.swing.JTextField();
        nomEtudiant = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        montant = new javax.swing.JTextField();
        sc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        statut = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeFormations = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORMATION");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_32.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 40, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        identifiant.setEditable(false);
        identifiant.setEnabled(false);
        identifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantjTextField2ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel42.setText("Code Formation");

        jLabel57.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel57.setText("Statut");

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

        jLabel58.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel58.setText("NomEtudiant");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_32.png"))); // NOI18N
        jLabel14.setText("Supprimer");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        table.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_32.png"))); // NOI18N
        table.setText("Actualiser");
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        codeEtudiant.setEditable(false);
        codeEtudiant.setEnabled(false);
        codeEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codeEtudiantMouseClicked(evt);
            }
        });
        codeEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeEtudiantjTextField2ActionPerformed(evt);
            }
        });
        codeEtudiant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeEtudiantKeyReleased(evt);
            }
        });

        nomEtudiant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nomEtudiantItemStateChanged(evt);
            }
        });
        nomEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomEtudiantMouseClicked(evt);
            }
        });
        nomEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomEtudiantActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel43.setText("NomFormation");

        jLabel44.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel44.setText("Montant");

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomjTextField2ActionPerformed(evt);
            }
        });

        montant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montantjTextField2ActionPerformed(evt);
            }
        });

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sr_16.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        statut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statutItemStateChanged(evt);
            }
        });
        statut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(38, 38, 38)
                        .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom)
                            .addComponent(montant, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(nomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 190));

        listeFormations.setBackground(new java.awt.Color(204, 204, 204));
        listeFormations.setFont(new java.awt.Font("Aeroportal", 0, 12)); // NOI18N
        listeFormations.setModel(new javax.swing.table.DefaultTableModel(
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
        listeFormations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeFormationsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listeFormations);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 810, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back2.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void identifiantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identifiantjTextField2ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Inserer();
        Actualiser();
        Afficher();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Modifier();
        Actualiser();
        Afficher();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        Actualiser();
    }//GEN-LAST:event_tableMouseClicked

    private void codeEtudiantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeEtudiantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantjTextField2ActionPerformed

    private void listeFormationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeFormationsMouseClicked
        try {
            int i = listeFormations.getSelectedRow();
            deplace(i);
            getIdEtudiant();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_listeFormationsMouseClicked

    private void codeEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeEtudiantMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Supprimer();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Exit();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void codeEtudiantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeEtudiantKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantKeyReleased

    private void nomEtudiantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nomEtudiantItemStateChanged
        getId();        // TODO add your handling code here:
    }//GEN-LAST:event_nomEtudiantItemStateChanged

    private void nomjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjTextField2ActionPerformed

    private void montantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montantjTextField2ActionPerformed

    private void nomEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomEtudiantActionPerformed

    private void scjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scjTextField2ActionPerformed

    private void scKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scKeyReleased
        DefaultTableModel table = (DefaultTableModel) listeFormations.getModel();
        String search = sc.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        listeFormations.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_scKeyReleased

    private void statutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statutItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_statutItemStateChanged

    private void statutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statutActionPerformed

    private void nomEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomEtudiantMouseClicked
        getId();
    }//GEN-LAST:event_nomEtudiantMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeEtudiant;
    private javax.swing.JTextField identifiant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listeFormations;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField nom;
    private javax.swing.JComboBox nomEtudiant;
    private javax.swing.JTextField sc;
    private javax.swing.JComboBox statut;
    private javax.swing.JLabel table;
    // End of variables declaration//GEN-END:variables
}
