/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lichadejewellers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author radake_a
 */
public class HomePage extends javax.swing.JFrame {

    
    float Gold24K;
    float Gold22K;
    float SILVER_PRIC;
    public HomePage()
    {
        initComponents(); setLocationRelativeTo(null);
        		
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
        jPanel2 = new javax.swing.JPanel();
        reports_button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        add_new_product_button = new javax.swing.JButton();
        Sale_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        price_updation_gold_22k = new javax.swing.JTextField();
        price_updation_silver = new javax.swing.JTextField();
        price_updation_gold_24k = new javax.swing.JTextField();
        button_update_commodities_price = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        currect_gold_rates = new javax.swing.JTextField();
        today_rate_button_for_homepage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(9, 52, 70));
        jPanel2.setForeground(new java.awt.Color(9, 52, 70));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        reports_button.setBackground(new java.awt.Color(8, 40, 75));
        reports_button.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        reports_button.setForeground(new java.awt.Color(255, 255, 255));
        reports_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-online-60.png"))); // NOI18N
        reports_button.setText("REPORTS");
        reports_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reports_buttonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(8, 40, 75));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-approval-48.png"))); // NOI18N
        jButton3.setText("VERIFY INVOICE");

        add_new_product_button.setBackground(new java.awt.Color(8, 40, 75));
        add_new_product_button.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        add_new_product_button.setForeground(new java.awt.Color(255, 255, 255));
        add_new_product_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-add-tag-48.png"))); // NOI18N
        add_new_product_button.setText("ADD PRODUCT");
        add_new_product_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_product_buttonActionPerformed(evt);
            }
        });

        Sale_button.setBackground(new java.awt.Color(8, 40, 75));
        Sale_button.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Sale_button.setForeground(new java.awt.Color(255, 255, 255));
        Sale_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-gold-64(1).png"))); // NOI18N
        Sale_button.setText("SALE");
        Sale_button.setToolTipText("");
        Sale_button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Sale_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Sale_button.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Sale_buttonMouseMoved(evt);
            }
        });
        Sale_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sale_buttonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 119, 182));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 51, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UPDATE GOLD PRICES");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gold 22k/ 10gm");

        price_updation_gold_22k.setBackground(new java.awt.Color(51, 51, 51));
        price_updation_gold_22k.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        price_updation_gold_22k.setForeground(new java.awt.Color(255, 255, 255));
        price_updation_gold_22k.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        price_updation_silver.setBackground(new java.awt.Color(51, 51, 51));
        price_updation_silver.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        price_updation_silver.setForeground(new java.awt.Color(255, 255, 255));
        price_updation_silver.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        price_updation_gold_24k.setBackground(new java.awt.Color(51, 51, 51));
        price_updation_gold_24k.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        price_updation_gold_24k.setForeground(new java.awt.Color(255, 255, 255));
        price_updation_gold_24k.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        button_update_commodities_price.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_update_commodities_price.setText("Update");
        button_update_commodities_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_update_commodities_priceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gold 24k/ 10gm");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Silver/ 10gm");

        jPasswordField1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Secret PIN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price_updation_gold_24k, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price_updation_gold_22k, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button_update_commodities_price, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(price_updation_silver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price_updation_gold_24k, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_updation_gold_22k, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(price_updation_silver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(button_update_commodities_price, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Lucida Console", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(9, 52, 70));
        jLabel7.setText("KHEDIKAR JEWELLERS");

        currect_gold_rates.setEditable(false);
        currect_gold_rates.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        currect_gold_rates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currect_gold_ratesActionPerformed(evt);
            }
        });

        today_rate_button_for_homepage.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        today_rate_button_for_homepage.setText("Today's Rate");
        today_rate_button_for_homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                today_rate_button_for_homepageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Sale_button, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reports_button, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_new_product_button, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(485, 485, 485))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(today_rate_button_for_homepage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currect_gold_rates, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(511, 511, 511))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(today_rate_button_for_homepage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currect_gold_rates, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sale_button, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reports_button, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_new_product_button, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_new_product_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_product_buttonActionPerformed
        new addNewProductToDB().setVisible(true);
    }//GEN-LAST:event_add_new_product_buttonActionPerformed

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
    jPasswordField1.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void reports_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reports_buttonActionPerformed
       new Reports_Admin().setVisible(true); dispose();
    }//GEN-LAST:event_reports_buttonActionPerformed

    private void button_update_commodities_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_update_commodities_priceActionPerformed
       
      
         
        if (!price_updation_gold_24k.getText().equals("") && !price_updation_gold_22k.getText().equals("") && !price_updation_silver.getText().equals(""))
        {
        float Gold24k= Float.parseFloat(price_updation_gold_24k.getText());         
        float Gold22k= Float.parseFloat(price_updation_gold_22k.getText());        
        float SILVER=  Float.parseFloat(price_updation_silver.getText());
            
        // Getting secret key
        int SECRET_KEY=0;    
        
        if (jPasswordField1.getText().length()==0 && jPasswordField1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please provide secret key");
        }
        
        else
        {
         SECRET_KEY=Integer.parseInt(jPasswordField1.getText());
        //System.out.println("Secret key  "+SECRET_KEY);
        }
      
        if (SECRET_KEY==2022)
        {
        try
        {
           
                Connection con= ConnectionProvider.getCon();
                PreparedStatement Gold24k_update= con.prepareStatement("update jewellery_product_rates set prices="+Gold24k+" where product_name='GOLD_24K'" );              
                //System.out.println("update jewellery_product_rates set prices="+Gold24k+" where product_name='GOLD_24K'");
                Gold24k_update.executeUpdate(); 
                
              
                PreparedStatement Gold_22k_update= con.prepareStatement("update jewellery_product_rates set prices="+Gold22k+" where product_name='GOLD_22K'");
                Gold_22k_update.executeUpdate();
                
                
                PreparedStatement Silver_update= con.prepareStatement("update jewellery_product_rates set prices="+SILVER+" where product_name='SILVER'");
                Silver_update.executeUpdate(); 
                
                // SUCCESS MESSAGE                       
                JOptionPane.showMessageDialog(null, "SUCCESS...! Prices updated");
                // New Screen
                con.close();
                price_updation_gold_22k.setText(""); price_updation_silver.setText(""); price_updation_gold_24k.setText("");
                
                
            }
          
            catch(Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR.!! PRICE UPDATE FAILED");
            }
        
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR.!! WRONG SECRET PIN");
        }
        }
        else
        {
             JOptionPane.showMessageDialog(null, "PRICES ARE MISSING");
        }
    }//GEN-LAST:event_button_update_commodities_priceActionPerformed

    private void currect_gold_ratesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currect_gold_ratesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currect_gold_ratesActionPerformed

    private void Sale_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sale_buttonActionPerformed
       new GenerateBill().setVisible(true); dispose();
      // btn.setBorder(new RoundBtn(15));   
      
    }//GEN-LAST:event_Sale_buttonActionPerformed

    private void today_rate_button_for_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_today_rate_button_for_homepageActionPerformed
        ResultSet rs= null;
        try
        {
            
            
            Connection con= ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Select prices from jewellery_product_rates where product_name='GOLD_24K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);          
            rs=ps.executeQuery(); 
            rs.first();
            Gold24K=rs.getInt("prices");                     
            PreparedStatement pss= con.prepareStatement("Select prices from jewellery_product_rates where product_name='GOLD_22K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=pss.executeQuery();
            rs.first();
            Gold22K=rs.getInt("prices"); // System.out.println(Gold22K);
        
            PreparedStatement ps_SILVER= con.prepareStatement("Select prices from jewellery_product_rates where product_name='SILVER'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=ps_SILVER.executeQuery();
            rs.first();
            SILVER_PRIC=rs.getInt("prices"); // System.out.println(SILVER_PRIC);
            
            currect_gold_rates.setText("Gold 24k: "+Gold24K + "  Gold 22k: "+Gold22K +"  Silver: "+SILVER_PRIC);
        }
        catch( Exception e)
        {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_today_rate_button_for_homepageActionPerformed

    private void Sale_buttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sale_buttonMouseMoved
        
    }//GEN-LAST:event_Sale_buttonMouseMoved

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sale_button;
    private javax.swing.JButton add_new_product_button;
    private javax.swing.JButton button_update_commodities_price;
    private javax.swing.JTextField currect_gold_rates;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField price_updation_gold_22k;
    private javax.swing.JTextField price_updation_gold_24k;
    private javax.swing.JTextField price_updation_silver;
    private javax.swing.JButton reports_button;
    private javax.swing.JButton today_rate_button_for_homepage;
    // End of variables declaration//GEN-END:variables
}
