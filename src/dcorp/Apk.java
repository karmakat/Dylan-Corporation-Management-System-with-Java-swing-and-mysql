package dcorp;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Apk extends javax.swing.JFrame {

    public Apk() {
        initComponents();
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50)); 
    }

    
    void setColor (JPanel color){
    color.setBackground(new Color(0, 108, 155));
    }
    
    void resetColor (JPanel color){
    color.setBackground(new Color(0, 0, 0));
    }
 
    public void Replace1 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
   
   public void Replace2 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
   
    public void Replace3 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
    
public void Replace4 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }

 public void Replace5 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
 
  public void Replace6 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
  
  public void Replace7 (JPanel p1){
   change.removeAll();
   change.add(p1);
   change.repaint();
   change.revalidate();
   }
 
   void Exit(){
        if(JOptionPane.showConfirmDialog(null, "Voluez-vous vraiment quitter ce programme?","Quitter",
            JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                System.exit(0);
         }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pan1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pan2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pan3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pan5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pan6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pan7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        change = new javax.swing.JPanel();
        acceuil = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back_16.png"))); // NOI18N
        jLabel4.setText("Acceuil");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        pan1.setBackground(new java.awt.Color(0, 0, 0));
        pan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan1MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clients_32.png"))); // NOI18N
        jLabel2.setText("Etudiants");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan2.setBackground(new java.awt.Color(0, 0, 0));
        pan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan2MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/projet_32.png"))); // NOI18N
        jLabel3.setText("Projets");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan3.setBackground(new java.awt.Color(0, 0, 0));
        pan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan3MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/formation_32.png"))); // NOI18N
        jLabel1.setText("Formation");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan3Layout = new javax.swing.GroupLayout(pan3);
        pan3.setLayout(pan3Layout);
        pan3Layout.setHorizontalGroup(
            pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan3Layout.setVerticalGroup(
            pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan4.setBackground(new java.awt.Color(0, 0, 0));
        pan4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan4MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/partenaire_32.png"))); // NOI18N
        jLabel5.setText("Partenaires");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan4Layout = new javax.swing.GroupLayout(pan4);
        pan4.setLayout(pan4Layout);
        pan4Layout.setHorizontalGroup(
            pan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan4Layout.setVerticalGroup(
            pan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan5.setBackground(new java.awt.Color(0, 0, 0));
        pan5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan5MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/personnel_32.png"))); // NOI18N
        jLabel6.setText("Personnel");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pan5Layout = new javax.swing.GroupLayout(pan5);
        pan5.setLayout(pan5Layout);
        pan5Layout.setHorizontalGroup(
            pan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan5Layout.setVerticalGroup(
            pan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("D-CORP");

        jLabel13.setFont(new java.awt.Font("Aeroportal", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 108, 155));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sys_32.png"))); // NOI18N
        jLabel13.setText("management Sys");

        pan6.setBackground(new java.awt.Color(0, 0, 0));
        pan6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan6MouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remb_32.png"))); // NOI18N
        jLabel14.setText("Caisse");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan6Layout = new javax.swing.GroupLayout(pan6);
        pan6.setLayout(pan6Layout);
        pan6Layout.setHorizontalGroup(
            pan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan6Layout.setVerticalGroup(
            pan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pan7.setBackground(new java.awt.Color(0, 0, 0));
        pan7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan7MouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caisse_32.png"))); // NOI18N
        jLabel18.setText("Dettes");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan7Layout = new javax.swing.GroupLayout(pan7);
        pan7.setLayout(pan7Layout);
        pan7Layout.setHorizontalGroup(
            pan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan7Layout.setVerticalGroup(
            pan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 5, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel13)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pan5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pan6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pan7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        change.setLayout(new java.awt.BorderLayout());

        acceuil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("WELCOME ");
        acceuil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 670, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_32.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        acceuil.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 30, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg4.jpg"))); // NOI18N
        jLabel12.setToolTipText("");
        acceuil.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("WELCOME ");
        acceuil.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 810, 100));

        change.add(acceuil, java.awt.BorderLayout.CENTER);

        getContentPane().add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, 550));

        setSize(new java.awt.Dimension(1010, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Replace1(new Etudiants());
        setColor  (pan1);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);
        
      
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Replace2(new Projets());
        setColor  (pan2);
        resetColor(pan1);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Replace3(new Formation ()); 
        setColor  (pan3);
        resetColor(pan2);
        resetColor(pan1);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);
       
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Replace4(new Partenaires ());  
        setColor  (pan4);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan1);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7); 
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Replace5(new Personnels ());
        setColor  (pan5);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan1);
        resetColor(pan6);
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void pan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan1MouseClicked
        Replace1(new Etudiants());
        setColor  (pan1);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);
        ;// TODO add your handling code here:
    }//GEN-LAST:event_pan1MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
         Exit();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Apk open = new Apk();
        open.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Replace6(new Caisse());
        setColor(pan6);
        resetColor(pan1);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        ;// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void pan6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan6MouseClicked
        Replace6(new Caisse ());
        setColor  (pan6);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan1);
        resetColor(pan7);// TODO add your handling code here:
    }//GEN-LAST:event_pan6MouseClicked

    private void pan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan1MouseEntered
        setColor(pan1);        // TODO add your handling code here:
    }//GEN-LAST:event_pan1MouseEntered

    private void pan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan1MouseExited
        resetColor(pan1);        // TODO add your handling code here:
    }//GEN-LAST:event_pan1MouseExited

    private void pan4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan4MouseClicked
        Replace4(new Partenaires ());
        setColor  (pan4);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan1);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);     // TODO add your handling code here:
    }//GEN-LAST:event_pan4MouseClicked

    private void pan5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan5MouseClicked
        Replace5(new Personnels ()); 
        setColor  (pan5);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan1);
        resetColor(pan6);
        resetColor(pan7);// TODO add your handling code here:
    }//GEN-LAST:event_pan5MouseClicked

    private void pan3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan3MouseClicked
        Replace3(new Formation ());
        setColor  (pan3);
        resetColor(pan2);
        resetColor(pan1);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);// TODO add your handling code here:
    }//GEN-LAST:event_pan3MouseClicked

    private void pan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan2MouseClicked
        Replace2(new Projets());
        setColor  (pan2);
        resetColor(pan1);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan7);// TODO add your handling code here:
    }//GEN-LAST:event_pan2MouseClicked

    private void pan2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan2MouseEntered
setColor(pan2);        // TODO add your handling code here:
    }//GEN-LAST:event_pan2MouseEntered

    private void pan2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan2MouseExited
resetColor(pan2);        // TODO add your handling code here:
    }//GEN-LAST:event_pan2MouseExited

    private void pan3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan3MouseEntered
setColor(pan3);        // TODO add your handling code here:
    }//GEN-LAST:event_pan3MouseEntered

    private void pan3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan3MouseExited
resetColor(pan3);        // TODO add your handling code here:
    }//GEN-LAST:event_pan3MouseExited

    private void pan4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan4MouseEntered
setColor(pan4);        // TODO add your handling code here:
    }//GEN-LAST:event_pan4MouseEntered

    private void pan4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan4MouseExited
resetColor(pan4);        // TODO add your handling code here:
    }//GEN-LAST:event_pan4MouseExited

    private void pan5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan5MouseEntered
setColor(pan5);        // TODO add your handling code here:
    }//GEN-LAST:event_pan5MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void pan5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan5MouseExited
resetColor(pan5);        // TODO add your handling code here:
    }//GEN-LAST:event_pan5MouseExited

    private void pan6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan6MouseEntered
setColor(pan6);        // TODO add your handling code here:
    }//GEN-LAST:event_pan6MouseEntered

    private void pan6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan6MouseExited
resetColor(pan6);        // TODO add your handling code here:
    }//GEN-LAST:event_pan6MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        
        setColor  (pan7);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan1); 
        /*
        JOptionPane.showMessageDialog(null, "Vous devez etre un super utilisateur!!!");
        JOptionPane.showMessageDialog(null, change);
        panAccess.setVisible(true);
        String adm = identifiant.getText();
        String psw = pass.getText();
        if("super-admin".equals(adm) && "1324".equals(psw)){
            Replace7(new Dettes ()); 
            panAccess.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Access denied!!!");
             panAccess.setVisible(false);
            
        }*/
        
        
        Replace7(new Dettes ()); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void pan7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan7MouseClicked
        Replace7(new Dettes ());
        setColor  (pan7);
        resetColor(pan2);
        resetColor(pan3);
        resetColor(pan4);
        resetColor(pan5);
        resetColor(pan6);
        resetColor(pan1);        // TODO add your handling code here:
    }//GEN-LAST:event_pan7MouseClicked

    private void pan7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan7MouseEntered
setColor(pan7);        // TODO add your handling code here:
    }//GEN-LAST:event_pan7MouseEntered

    private void pan7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan7MouseExited
resetColor(pan7);          // TODO add your handling code here:
    }//GEN-LAST:event_pan7MouseExited

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
            java.util.logging.Logger.getLogger(Apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acceuil;
    private javax.swing.JPanel change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    private javax.swing.JPanel pan3;
    private javax.swing.JPanel pan4;
    private javax.swing.JPanel pan5;
    private javax.swing.JPanel pan6;
    private javax.swing.JPanel pan7;
    // End of variables declaration//GEN-END:variables
}
