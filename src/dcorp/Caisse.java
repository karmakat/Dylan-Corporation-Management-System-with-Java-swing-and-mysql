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
public final class Caisse extends javax.swing.JPanel {

    /**
     * Creates new form Compte
     */
    Connect conn = new Connect();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model = new DefaultTableModel();

    public Caisse() {
        initComponents();

        identifiant.setEditable(false);
        codeEtudiant.setEditable(false);
        codeFormation.setEditable(false);

        model.addColumn("Id");
        model.addColumn("Montant");
        model.addColumn("Date");
        model.addColumn("Etudiant");
        model.addColumn("Formation");

        Afficher();

        comboEtudiant();
        comboFormation();

        listeCaisse.setRowHeight(25);
        listeCaisse.setShowGrid(true);
        listeCaisse.setGridColor(new Color(102, 102, 102));
        listeCaisse.setSelectionBackground(new Color(0, 108, 155));
    }

    void Afficher() {
        try {
            model.setRowCount(0);
            stm = conn.obtenirconnexion().createStatement();
            Rs = stm.executeQuery("select * from show_caisse_one");
            while (Rs.next()) {
                model.addRow(new Object[]{
                    Rs.getString("codeCaisse"),
                    Rs.getString("MontantPaye"),
                    Rs.getString("datePayement"),
                    Rs.getString("nom"),
                    Rs.getString("nomFormation")
                });
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        listeCaisse.setModel(model);
    }

    void comboEtudiant() {
        try {
            Rs = stm.executeQuery("select * from show_formation");
            while (Rs.next()) {
                nomEtudiant.addItem(Rs.getString("nom"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void getEtudiantId() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from etudiant where nom = '" + nomEtudiant.getSelectedItem() + "'";
            ResultSet Res = stm.executeQuery(sql);
            if (Res.next()) {
                String id = Res.getString("codeEtudiant");
                codeEtudiant.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void getEtudiantIdView() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from show_caisse_one where codeCaisse = '" + identifiant.getText() + "'";
            ResultSet Res = stm.executeQuery(sql);
            if (Res.next()) {
                String id = Res.getString("codeEtudiant");
                codeEtudiant.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void comboFormation() {
        try {
            Rs = stm.executeQuery("select * from formation");
            while (Rs.next()) {
                nomFormation.addItem(Rs.getString("nomFormation"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void getFormationId() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from formation where nomFormation = '" + nomFormation.getSelectedItem() + "'";
            ResultSet Res = stm.executeQuery(sql);
            if (Res.next()) {
                String id = Res.getString("codeFormation");
                codeFormation.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void getFormationIdView() {
        try {
            stm = conn.obtenirconnexion().createStatement();

            String sql = "select * from show_caisse_one where codeCaisse = '" + identifiant.getText() + "'";
            ResultSet Res = stm.executeQuery(sql);
            if (Res.next()) {
                String id = Res.getString("codeFormation");
                codeFormation.setText(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void Inserer() {
        try {
            String codeEt = codeEtudiant.getText();
            String amount = montant.getText();
            String codeFo = codeFormation.getText();
            String thedate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String requete = "insert into caisse(MontantPaye,datePayement,codeEtudiant,codeFormation) VALUES ('"
                    + amount + "','"
                    + thedate + "','"
                    + codeEt + "','"
                    + codeFo + "')";
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
                String codeEt = codeEtudiant.getText();
                String amount = montant.getText();
                String codeFo = codeFormation.getText();
                String thedate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
                stm.executeUpdate(
                        "UPDATE caisse SET codeEtudiant='"
                        + codeEt
                        + "', MontantPaye='"
                        + amount
                        + "',codeFormation='"
                        + codeFo
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
                    stm.executeUpdate("Delete From caisse where codeCaisse = " + identifiant.getText());
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
            montant.setText(model.getValueAt(i, 1).toString());
            codeEtudiant.setText(model.getValueAt(i, 3).toString());
            codeFormation.setText(model.getValueAt(i, 4).toString());
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }
    }

    void Actualiser() {
        identifiant.setText("");
        codeFormation.setText("");
        codeEtudiant.setText("");
        montant.setText("");
        date.setDate(null);
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
        jLabel57 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TypeCompte = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nomEtudiant = new javax.swing.JComboBox();
        nomFormation = new javax.swing.JComboBox();
        codeFormation = new javax.swing.JTextField();
        codeEtudiant = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        montant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeCaisse = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        jLabel42.setText("CodeCaisse");

        jLabel57.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel57.setText("Formation");

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

        TypeCompte.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        TypeCompte.setText("NomEtudiant");

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

        nomFormation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nomFormationItemStateChanged(evt);
            }
        });
        nomFormation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomFormationMouseClicked(evt);
            }
        });
        nomFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomFormationActionPerformed(evt);
            }
        });

        codeFormation.setEditable(false);
        codeFormation.setEnabled(false);
        codeFormation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codeFormationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                codeFormationMouseEntered(evt);
            }
        });
        codeFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFormationjTextField2ActionPerformed(evt);
            }
        });
        codeFormation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeFormationKeyReleased(evt);
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

        jLabel58.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel58.setText("Montant paye");

        jLabel59.setFont(new java.awt.Font("Avian", 0, 12)); // NOI18N
        jLabel59.setText("DatePayement");

        date.setDateFormatString("yyyy-MM-dd");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sr_16.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel15)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel14)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(sc, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TypeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nomFormation, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeFormation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel58)
                                .addGap(18, 18, 18)
                                .addComponent(montant, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel59)
                                .addGap(18, 18, 18)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TypeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel57)
                                .addComponent(nomFormation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codeFormation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel59)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );

        acceuil.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 190));

        listeCaisse.setBackground(new java.awt.Color(204, 204, 204));
        listeCaisse.setFont(new java.awt.Font("Aeroportal", 0, 12)); // NOI18N
        listeCaisse.setModel(new javax.swing.table.DefaultTableModel(
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
        listeCaisse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeCaisseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listeCaisse);

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
        jLabel3.setText("CAISSE");
        acceuil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 30));

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

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Actualiser();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void codeFormationjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFormationjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFormationjTextField2ActionPerformed

    private void codeEtudiantjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeEtudiantjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantjTextField2ActionPerformed

    private void listeCaisseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeCaisseMouseClicked
        try {
            int i = listeCaisse.getSelectedRow();
            deplace(i);
            getEtudiantIdView();
            getFormationIdView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de deplacement" + e.getLocalizedMessage());
        }            // TODO add your handling code here:    */// TODO add your handling code here:
    }//GEN-LAST:event_listeCaisseMouseClicked

    private void codeEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeEtudiantMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantMouseClicked

    private void codeFormationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeFormationMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFormationMouseEntered

    private void codeFormationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeFormationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFormationMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Exit();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Supprimer();
        Actualiser();
        Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void codeEtudiantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeEtudiantKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantKeyReleased

    private void codeFormationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeFormationKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFormationKeyReleased

    private void nomFormationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nomFormationItemStateChanged
        getFormationId();
    }//GEN-LAST:event_nomFormationItemStateChanged

    private void nomEtudiantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nomEtudiantItemStateChanged
        getEtudiantId();
    }//GEN-LAST:event_nomEtudiantItemStateChanged

    private void nomFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFormationActionPerformed

    private void scjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scjTextField2ActionPerformed

    private void scKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scKeyReleased
        DefaultTableModel table = (DefaultTableModel) listeCaisse.getModel();
        String search = sc.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        listeCaisse.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_scKeyReleased

    private void nomEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomEtudiantMouseClicked
        getEtudiantId();
    }//GEN-LAST:event_nomEtudiantMouseClicked

    private void nomFormationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomFormationMouseClicked
        getFormationId();
    }//GEN-LAST:event_nomFormationMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TypeCompte;
    private javax.swing.JPanel acceuil;
    private javax.swing.JTextField codeEtudiant;
    private javax.swing.JTextField codeFormation;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listeCaisse;
    private javax.swing.JTextField montant;
    private javax.swing.JComboBox nomEtudiant;
    private javax.swing.JComboBox nomFormation;
    private javax.swing.JTextField sc;
    // End of variables declaration//GEN-END:variables
}
