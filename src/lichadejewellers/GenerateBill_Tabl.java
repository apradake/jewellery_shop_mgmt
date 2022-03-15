/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lichadejewellers;

import Java_code.Number_to_word_desc;
import com.sun.corba.se.spi.ior.MakeImmutable;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import javax.swing.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.LocalTime;
/**
 *
 * @author radake_a
 */
public class GenerateBill_Tabl extends javax.swing.JFrame 
{

    /**
     * Creates new form GenerateBill
     */
     DefaultListModel<String> list_product_individual_amount;
     DefaultListModel<String> list_product_individual_name;
     float Gold24K_pergrams=0; float Gold22k_pergrams=0; float Silver_pergrams=0;
     
     ResultSet rs= null;
     int bill_counter_for_the_invoice;
     
     float Gold24K;
     float Gold22K;
     float SILVER_PRIC;
     float after_GST=0;
     
  
      
     // GETTING SYSTEM DATE
   //  long millis_for_invoice=System.currentTimeMillis(); 
  
     //java.sql.Date date_for_invoice = new java.sql.Date(millis_for_invoice);
     
     LocalDate date_for_invoice= java.time.LocalDate.now();
      // GETTING TIMESTAMP
    
     
    public GenerateBill_Tabl()
    {
        // INITIALIZE OF DATA
        initComponents();
        setLocationRelativeTo(null);
        ResultSet rs= null;
        //CREATING A LIST
        
        list_product_individual_amount= new DefaultListModel<>();
        list_product_individual_name = new DefaultListModel<>();
        making_charges_amount.setText("0");
        customer_mobile.setText("0");
            
        // Get rates from DB and calculate  
        try
        {
            Connection con= ConnectionProvider.getCon();
              
            long millis=System.currentTimeMillis();       
            // creating a new object of the class Date  
            java.sql.Date date = new java.sql.Date(millis);
            
            
            // GETTING COUNTER OF INVOICE
            PreparedStatement countCheck= con.prepareStatement("Select * from invoice_counter", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=countCheck.executeQuery();
            rs.next();
            int count=rs.getInt("count");
        
            
            // GENERATING INVOICE NUMBER
            
            bill_counter_for_the_invoice=count+1;
            invoice_number.setText("KJ-"+String.valueOf(bill_counter_for_the_invoice));
          
            
            
            PreparedStatement ps = con.prepareStatement("Select prices from jewellery_product_rates where product_name='GOLD_24K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);          
            rs=ps.executeQuery(); 
            rs.first();
            Gold24K=rs.getInt("prices");
          //  System.out.println(Gold24K);
           // ps.close();
                     
            PreparedStatement pss= con.prepareStatement("Select prices from jewellery_product_rates where product_name='GOLD_22K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=pss.executeQuery();
            rs.first();
            Gold22K=rs.getInt("prices"); // System.out.println(Gold22K);
         //   pss.close();
            PreparedStatement ps_SILVER= con.prepareStatement("Select prices from jewellery_product_rates where product_name='SILVER'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=ps_SILVER.executeQuery();
            rs.first();
            SILVER_PRIC=rs.getInt("prices"); // System.out.println(SILVER_PRIC);
         //   ps_SILVER.close();c   
             
            
            Gold24K_pergrams+=Gold24K/10;
            Gold22k_pergrams+=Gold22K/10;
            Silver_pergrams+=SILVER_PRIC/10;
            
            PreparedStatement config_product_available= con.prepareStatement("Select product_description  from jewellery_type_list", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=config_product_available.executeQuery();
            
            while(rs.next())
            {
                
                
                selected_product_for_billing.addItem(rs.getString("product_description"));
            
            }
            
            PreparedStatement config_purity_selected= con.prepareStatement("Select product_name from jewellery_product_rates", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=config_purity_selected.executeQuery();
            
            while(rs.next())
            {
                
                
             purity_selected .addItem(rs.getString("product_name"));
            
            }
            

            
            con.close();
        }
        
        catch (Exception e)
	{
            e.printStackTrace(); 
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
        jPanel2 = new javax.swing.JPanel();
        selected_product_for_billing = new javax.swing.JComboBox<>();
        add_selected_prod_for_billing = new javax.swing.JButton();
        purity_selected = new javax.swing.JComboBox<>();
        grasm_weight_of_selected_product = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        making_charges_amount = new javax.swing.JTextField();
        final_billing_amount = new javax.swing.JTextField();
        discount_on_total_bill = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        product_exchange_value = new javax.swing.JTextField();
        total_amount_before_GST = new javax.swing.JTextField();
        gst_on_product_bill = new javax.swing.JTextField();
        Reset_bill = new javax.swing.JButton();
        print_invoice_generate_pdf = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CUSTOMER_NAME = new javax.swing.JTextField();
        customer_mobile = new javax.swing.JTextField();
        remove_gst_button = new javax.swing.JButton();
        in_words_final_billing_amount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        invoice_number = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 800));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        selected_product_for_billing.setBackground(new java.awt.Color(8, 40, 75));
        selected_product_for_billing.setFont(new java.awt.Font("Franklin Gothic Book", 0, 20)); // NOI18N
        selected_product_for_billing.setForeground(new java.awt.Color(255, 255, 255));
        selected_product_for_billing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selected_product_for_billingActionPerformed(evt);
            }
        });

        add_selected_prod_for_billing.setBackground(new java.awt.Color(255, 255, 255));
        add_selected_prod_for_billing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-add-48.png"))); // NOI18N
        add_selected_prod_for_billing.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        add_selected_prod_for_billing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_selected_prod_for_billingActionPerformed(evt);
            }
        });

        purity_selected.setBackground(new java.awt.Color(8, 40, 75));
        purity_selected.setFont(new java.awt.Font("Franklin Gothic Book", 0, 20)); // NOI18N
        purity_selected.setForeground(new java.awt.Color(255, 255, 255));

        grasm_weight_of_selected_product.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Lucida Console", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(9, 52, 70));
        jLabel7.setText("KHEDIKAR JEWELLERS");

        making_charges_amount.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        making_charges_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                making_charges_amountActionPerformed(evt);
            }
        });

        final_billing_amount.setEditable(false);
        final_billing_amount.setBackground(new java.awt.Color(8, 40, 75));
        final_billing_amount.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        final_billing_amount.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Discount");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Product Exchange value");

        total_amount_before_GST.setEditable(false);
        total_amount_before_GST.setBackground(new java.awt.Color(8, 40, 75));
        total_amount_before_GST.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        total_amount_before_GST.setForeground(new java.awt.Color(255, 255, 255));

        gst_on_product_bill.setBackground(new java.awt.Color(8, 40, 75));
        gst_on_product_bill.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gst_on_product_bill.setForeground(new java.awt.Color(255, 255, 255));
        gst_on_product_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gst_on_product_billActionPerformed(evt);
            }
        });

        Reset_bill.setBackground(new java.awt.Color(0, 119, 182));
        Reset_bill.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Reset_bill.setForeground(new java.awt.Color(255, 255, 255));
        Reset_bill.setText("Reset Bill");
        Reset_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reset_billActionPerformed(evt);
            }
        });

        print_invoice_generate_pdf.setBackground(new java.awt.Color(0, 119, 182));
        print_invoice_generate_pdf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        print_invoice_generate_pdf.setForeground(new java.awt.Color(255, 255, 255));
        print_invoice_generate_pdf.setText("Print Bill");
        print_invoice_generate_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_invoice_generate_pdfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Customer Billing name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Customer Mobile Number");

        CUSTOMER_NAME.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        customer_mobile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        remove_gst_button.setBackground(new java.awt.Color(0, 119, 182));
        remove_gst_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remove_gst_button.setForeground(new java.awt.Color(255, 255, 255));
        remove_gst_button.setText("Remove GST");
        remove_gst_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_gst_buttonActionPerformed(evt);
            }
        });

        in_words_final_billing_amount.setBackground(new java.awt.Color(8, 40, 75));
        in_words_final_billing_amount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        in_words_final_billing_amount.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("INVOICE NO");

        invoice_number.setEditable(false);
        invoice_number.setBackground(new java.awt.Color(255, 255, 255));
        invoice_number.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoice_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_numberActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-64.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-minus-48.png"))); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-minus-48.png"))); // NOI18N

        jTable1.setBackground(new java.awt.Color(0, 51, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Type", "HSN", "Net Wt", "Rate", "Total Amt", "Making per gram", "Total Making", "CGST", "SGST", "Bill amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(234, 234, 234)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(total_amount_before_GST, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(gst_on_product_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(remove_gst_button)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(final_billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Reset_bill)
                                        .addGap(67, 67, 67)
                                        .addComponent(print_invoice_generate_pdf)))
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(product_exchange_value, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(418, 418, 418))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel11))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(selected_product_for_billing, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(purity_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(grasm_weight_of_selected_product, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CUSTOMER_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customer_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(making_charges_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(discount_on_total_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(in_words_final_billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(add_selected_prod_for_billing)
                                .addGap(229, 229, 229)))))
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(add_selected_prod_for_billing, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(making_charges_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(discount_on_total_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selected_product_for_billing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(purity_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(grasm_weight_of_selected_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CUSTOMER_NAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customer_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(product_exchange_value, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in_words_final_billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(total_amount_before_GST, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(remove_gst_button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gst_on_product_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(final_billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Reset_bill)
                            .addComponent(print_invoice_generate_pdf))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remove_gst_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_gst_buttonActionPerformed
       // System.out.println(after_GST);
        int making_charg= Integer.parseInt( making_charges_amount.getText());
        float gst_to_remove=Float.parseFloat(gst_on_product_bill.getText());
        float invoice_amount_Aftergst_deduct= (after_GST-gst_to_remove)+making_charg;
        //System.out.println(invoice_amount_Aftergst_deduct);
      
        final_billing_amount.setText(String.valueOf(invoice_amount_Aftergst_deduct));
        total_amount_before_GST.setText(String.valueOf(invoice_amount_Aftergst_deduct));
        gst_on_product_bill.setText("0.0");
        in_words_final_billing_amount.setText(Number_to_word_desc.convertToWords((long) invoice_amount_Aftergst_deduct));
        
    }//GEN-LAST:event_remove_gst_buttonActionPerformed

    private void print_invoice_generate_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_invoice_generate_pdfActionPerformed

if (!CUSTOMER_NAME.getText().equals("")  )       
{    
        final_billing_amount.getText();
        ResultSet rs=null;
         String final_invoice_product_name="";
        for(int i=0;i< list_product_individual_name.getSize();i++)
        {
            final_invoice_product_name += list_product_individual_name;
        }
      
       
        float invoice_bill_amount=  Float.parseFloat(final_billing_amount.getText());
        //System.out.println("555");
        String invoice_number_for_bill=invoice_number.getText();  ///  System.out.println("556");      
        String customer_name=CUSTOMER_NAME.getText(); 
       // System.out.println(customer_name);//System.out.println("557");
       // System.out.println("558");   
        LocalDate invoice_billing_date=date_for_invoice;
        
        String customer_mob= customer_mobile.getText() ; 
        
        float gst_on_invoice=Float.parseFloat(gst_on_product_bill.getText()); 
    //    System.out.println("563");
      
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        
        java.sql.Timestamp invoice_billing_timestamp =new java.sql.Timestamp(date.getTime());
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date invoice_billing_date_for_db = new Date();  
      //  System.out.println(formatter.format(invoice_billing_date_for_db));  
       // System.out.println(final_invoice_product_name);
      
        try
        {
        Connection con= ConnectionProvider.getCon();
        
        PreparedStatement adding_final_invoice= con.prepareStatement("insert into final_invoice(invoice_number,customer_name,invoice_product_list,invoice_billing_date, invoice_bill_amount,customer_contact,invoice_gst_paid )values (?,?,?,?,?,?,?)" );
        adding_final_invoice.setString(1, invoice_number_for_bill);
        adding_final_invoice.setString(2, customer_name);
        adding_final_invoice.setString(3, final_invoice_product_name);
        adding_final_invoice.setString(4,formatter.format(invoice_billing_date_for_db));
        adding_final_invoice.setFloat(5,invoice_bill_amount );
        adding_final_invoice.setString(6,customer_mob );
        adding_final_invoice.setFloat(7,gst_on_invoice );       
        adding_final_invoice.executeUpdate();
        PreparedStatement update_couint= con.prepareStatement("update invoice_counter set count="+bill_counter_for_the_invoice );              
        update_couint.executeUpdate();        
        JOptionPane.showMessageDialog(null, "SUCCESS...! Invoice Generated with  "+invoice_number_for_bill);

        con.close();
        new GenerateBill_Tabl().setVisible(true);
        
        dispose();;
       
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "ERROR.!! INVOICE GENRATE FAILED");
           e.printStackTrace();
       }
        
}

else{
   JOptionPane.showMessageDialog(null, "CUSTOMER MOBILE OR NAME IS MISSING"); 
}
        
    }//GEN-LAST:event_print_invoice_generate_pdfActionPerformed

    private void gst_on_product_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gst_on_product_billActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gst_on_product_billActionPerformed

    private void making_charges_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_making_charges_amountActionPerformed
        int Making_charges=Integer.parseInt(making_charges_amount.getText());

    }//GEN-LAST:event_making_charges_amountActionPerformed

    private void selected_product_for_billingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selected_product_for_billingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selected_product_for_billingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new HomePage().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Reset_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reset_billActionPerformed
        new GenerateBill_Tabl().setVisible(true);
        dispose();
    }//GEN-LAST:event_Reset_billActionPerformed

    private void invoice_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoice_numberActionPerformed

    private void add_selected_prod_for_billingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_selected_prod_for_billingActionPerformed

        if (!grasm_weight_of_selected_product.getText().equals("") )
        {
            // GETTING PRODUCT BILLING DETAILS
            String Selected_product_billing=(String) selected_product_for_billing.getSelectedItem();

            String Selected_Purity_billing = (String) purity_selected.getSelectedItem();
            // System.out.println("purity value  "+Selected_Purity_billing);

            float grams_of_selected_product= Float.parseFloat(grasm_weight_of_selected_product.getText());

            float product_final_amount=0;
            float billing_rate=0;

            if (Selected_Purity_billing.equalsIgnoreCase("GOLD_24K"))
            {
                billing_rate+=Gold24K;
                product_final_amount+= (Gold24K_pergrams*grams_of_selected_product);
                //System.out.println("insider 658 "+product_final_amount);

            }
            if (Selected_Purity_billing.equalsIgnoreCase("GOLD_22K"))
            {
                product_final_amount+= (Gold22k_pergrams*grams_of_selected_product);
                billing_rate+=Gold22K;   //System.out.println("insider 658 "+product_final_amount);
            }
            if (Selected_Purity_billing.equalsIgnoreCase("SILVER"))
            {
                // System.out.println("Inside SIlver");
                product_final_amount+= (Silver_pergrams*grams_of_selected_product);
                billing_rate+=SILVER_PRIC;   //System.out.println("insider 658 "+product_final_amount);
            }
            // System.out.println("Final amount "+product_final_amount);

            list_product_individual_amount.addElement(String.valueOf(product_final_amount));
           // list2.add(Selected_product_billing+ " "+Selected_Purity_billing+" "+" Net Wt[gms]-"+grams_of_selected_product+" Billing Rate-"+billing_rate+"\n");
            list_product_individual_name.addElement("Product-"+Selected_product_billing+ " "+"Quality-"+Selected_Purity_billing+" "+" Net Wt[gms]-"+grams_of_selected_product+" Billing Rate-"+billing_rate);
            //list1.add(String.valueOf(product_final_amount)+"\n");
            //    final_invoice_product_name+=(String) selected_product_for_billing.getSelectedItem();

            float total_cost=0;
            // CALCULATING FINAL BILLING AMOUNT
            for(int i=0;i< list_product_individual_amount.getSize();i++)
            {
                total_cost +=Float.parseFloat(list_product_individual_amount.getElementAt(i));

            }

            float before_GST=total_cost;

            after_GST=before_GST+(before_GST/100)*3;
            //System.out.println(after_GST);
            gst_on_product_bill.setText(Float.toString((before_GST/100)*3));
            //  System.out.println((before_GST/100)*3);
            final_billing_amount.setText(Float.toString(after_GST));
            // System.out.println(after_GST);
            // Number to word conversion
            in_words_final_billing_amount.setText(Number_to_word_desc.convertToWords((long) after_GST));
            //  System.out.println(after_GST);
            total_amount_before_GST.setText(Float.toString(total_cost));
            //System.out.println(total_cost);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please provide weight");
        }

    }//GEN-LAST:event_add_selected_prod_for_billingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(GenerateBill_Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateBill_Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateBill_Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateBill_Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateBill_Tabl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CUSTOMER_NAME;
    private javax.swing.JButton Reset_bill;
    private javax.swing.JButton add_selected_prod_for_billing;
    private javax.swing.JTextField customer_mobile;
    private javax.swing.JTextField discount_on_total_bill;
    private javax.swing.JTextField final_billing_amount;
    private javax.swing.JTextField grasm_weight_of_selected_product;
    private javax.swing.JTextField gst_on_product_bill;
    private javax.swing.JTextField in_words_final_billing_amount;
    private javax.swing.JTextField invoice_number;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField making_charges_amount;
    private javax.swing.JButton print_invoice_generate_pdf;
    private javax.swing.JTextField product_exchange_value;
    private javax.swing.JComboBox<String> purity_selected;
    private javax.swing.JButton remove_gst_button;
    private javax.swing.JComboBox<String> selected_product_for_billing;
    private javax.swing.JTextField total_amount_before_GST;
    // End of variables declaration//GEN-END:variables

    
    
}
