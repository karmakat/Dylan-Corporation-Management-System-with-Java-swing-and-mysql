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
public final class Personnels extends javax.swing.JPanel {

    /**
     * Creates new form Compte
     */
    Connect conn = new Connect();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model = new DefaultTableModel();

    public Personnels() {
        initComponents();
        initComponents();
        identifiant.setEditable(false);

        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Contact");
        model.addColumn("Mail");
        model.addColumn("Adresse");
        model.addColumn("Statut");

        Afficher();

        listePersonnels.setRowHeight(25);
        listePersonnels.setShowGrid(true);
        listePersonnels.setGridColor(new Color(102, 102, 102));
        listePersonnels.setSelectionBackground(new Color(0, 108, 155));
    }

    //METHODES****************************************************************************************************************
    void Afficher() {
        try {
            model.setRowCount(0);
            stm = conn.obtenirconnexion().createStatement();
            Rs = stm.executeQuery("select * from personnel");
            while (Rs.next()) {
                model.addRow(new Object[]{
                    Rs.getString("codePersonnel"),
                    Rs.getString("nom"),
                    Rs.getString("contact"),
                    Rs.getString("mail"),
                    Rs.getString("adresse"),
                    Rs.getString("statut")
                });
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        listePersonnels.setModel(model);
    }

    void Inserer() {
        try {
            String name = nom.getText();
            String thecontact = contact.getText();
            String theadress = adresse.getText();
            String themail = mail.getText();
            String thestatus = statut.getText();

            String requete = "insert into personnel(nom,contact,mail,adresse,statut) VALUES ('"
                    + name + "','"
                    + thecontact + "','"
                    + themail + "','"
                    + theadress + "','"
                    + thestatus + "')";
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
                String thecontact = contact.getText();
                String theadress = adresse.getText();
                String themail = mail.getText();
                String thestatus = statut.getText();

                stm.executeUpdate(
                        "UPDATE personnel SET nom='"
                        + name
                        + "', contact='"
                        + thecontact
                        + "',mail='"
                        + themail
                        + "',adresse='"
                        + theadress
                        + "',statut='"
                        + thestatus
                        + "' WHERE codePersonnel=" + identifiant.getText()
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
                    stm.executeUpdate("Delete From personnel where codePersonnel = " + identifiant.getText());
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
            contact.setText(model.getValueAt(i, 2).toString());
            mail.setText(model.getValueAt(i, 3).toString());
            adresse.setText(model.getValueAt(i, 4).toString());
            statut.setText(model.getValueAt(i, 5).toString());

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }
    }

    void Actualiser() {
        identifiant.setText("");
        nom.setText("");
        contact.setText("");
        sc.setText("");
        adresse.setText("");
        statut.setText("");
        mail.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        identifiant = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        statut = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        sc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listePersonnels = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        acceuil.setBackground(new java.awt.Color(255, 255, 255));
        acceuil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel3.setText("PERSONNEL");
        acceuil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        identifiant.setEditable(false);
        identifiant.setEnabled(false);
        identifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantjTextField2ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel42.setText("Code Personel");

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
        jLabel59.setText("Adresse");

        adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adressejTextField2ActionPerformed(evt);
            }
        });

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
        jLabel60.setText("Contact");

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactjTextField2ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel61.setText("Mail");

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailjTextField2ActionPerformed(evt);
            }
        });

        statut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statutjTextField2ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel62.setText("Statut");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 51, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel15)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        acceuil.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 190));

        listePersonnels.setBackground(new java.awt.Color(204, 204, 204));
        listePersonnels.setFont(new java.awt.Font("Aeroportal", 0, 12)); // NOI18N
        listePersonnels.setModel(new javax.swing.table.DefaultTableModel(
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
        listePersonnels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listePersonnelsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listePersonnels);

        acceuil.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 810, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back2.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        acceuil.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(acceuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(acceuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Exit();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

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

    private void adressejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adressejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adressejTextField2ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Supprimer();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Actualiser();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void contactjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactjTextField2ActionPerformed

    private void mailjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailjTextField2ActionPerformed

    private void statutjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statutjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statutjTextField2ActionPerformed

    private void listePersonnelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listePersonnelsMouseClicked
        try {
            int i = listePersonnels.getSelectedRow();
            deplace(i);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }                  // TODO add your handling code here:
    }//GEN-LAST:event_listePersonnelsMouseClicked

    private void scjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scjTextField2ActionPerformed

    private void scKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scKeyReleased
        DefaultTableModel table = (DefaultTableModel) listePersonnels.getModel();
        String search = sc.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        listePersonnels.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_scKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acceuil;
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField contact;
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
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listePersonnels;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField sc;
    private javax.swing.JTextField statut;
    // End of variables declaration//GEN-END:variables
}
