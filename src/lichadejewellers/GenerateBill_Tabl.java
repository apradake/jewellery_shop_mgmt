/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lichadejewellers;

import Java_code.Number_to_word_desc;
import Java_code.UtilityMethods;
import com.itextpdf.layout.element.Paragraph;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;

import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.corba.se.spi.ior.MakeImmutable;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import javax.swing.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static org.apache.commons.io.IOUtils.writer;


import Java_code.*;
import com.itextpdf.layout.properties.TextAlignment;
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
     float amount_before_making_and_gst=0;
     String Gold24K_HSN;
     String Gold22K_HSN; 
     String SILVER_HSN;
     String Billing_HSN;
     
     
     LocalDate date_for_invoice= java.time.LocalDate.now();
      // GETTING TIMESTAMP
     
     int billing_year=date_for_invoice.getYear();
     
    public GenerateBill_Tabl()
    {
        // INITIALIZE OF DATA
        initComponents();
        setLocationRelativeTo(null);
        ResultSet rs= null;
        //CREATING A LIST
        
        list_product_individual_amount= new DefaultListModel<>();
        list_product_individual_name = new DefaultListModel<>();
     
        customer_mobile.setText("0");
       
        // HALL AMRKING INITI
        hallmark_unit.setText("0"); 
        
        grasm_weight_of_selected_product.requestFocus();
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
            invoice_number.setText("KJ-"+billing_year+"-"+String.valueOf(bill_counter_for_the_invoice));
          
            
            
            PreparedStatement ps = con.prepareStatement("Select * from jewellery_product_rates where product_name='GOLD_24K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);          
            rs=ps.executeQuery(); 
            rs.first();
            Gold24K=rs.getInt("prices");
            Gold24K_HSN=rs.getString("HSN");
                     
            PreparedStatement pss= con.prepareStatement("Select * from jewellery_product_rates where product_name='GOLD_22K'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=pss.executeQuery();
            rs.first();
            Gold22K=rs.getInt("prices"); Gold22K_HSN=rs.getString("HSN");
        
            PreparedStatement ps_SILVER= con.prepareStatement("Select * from jewellery_product_rates where product_name='SILVER'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=ps_SILVER.executeQuery();
            rs.first();
            SILVER_PRIC=rs.getInt("prices"); SILVER_HSN=rs.getString("HSN");
      
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
        purity_selected = new javax.swing.JComboBox<>();
        grasm_weight_of_selected_product = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        final_billing_amount = new javax.swing.JTextField();
        total_amount_before_GST = new javax.swing.JTextField();
        gst_on_product_bill = new javax.swing.JTextField();
        Reset_bill = new javax.swing.JButton();
        print_invoice_generate_pdf = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CUSTOMER_NAME = new javax.swing.JTextField();
        customer_mobile = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        invoice_number = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoice_table = new javax.swing.JTable();
        without_gst_making = new javax.swing.JTextField();
        making_total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cust_address = new javax.swing.JTextField();
        add_hallmarking_to_invoice = new javax.swing.JButton();
        hallmark_unit = new javax.swing.JTextField();
        test_print = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hallmark_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 800));

        jPanel2.setBackground(new java.awt.Color(8, 40, 75));

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
        selected_product_for_billing.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selected_product_for_billing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selected_product_for_billingActionPerformed(evt);
            }
        });

        purity_selected.setBackground(new java.awt.Color(8, 40, 75));
        purity_selected.setFont(new java.awt.Font("Franklin Gothic Book", 0, 20)); // NOI18N
        purity_selected.setForeground(new java.awt.Color(255, 255, 255));
        purity_selected.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        grasm_weight_of_selected_product.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        grasm_weight_of_selected_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grasm_weight_of_selected_productActionPerformed(evt);
            }
        });
        grasm_weight_of_selected_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grasm_weight_of_selected_productKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Lucida Console", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(9, 52, 70));
        jLabel7.setText("KHEDIKAR JEWELLERS");

        final_billing_amount.setEditable(false);
        final_billing_amount.setBackground(new java.awt.Color(8, 40, 75));
        final_billing_amount.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        final_billing_amount.setForeground(new java.awt.Color(255, 255, 255));

        total_amount_before_GST.setEditable(false);
        total_amount_before_GST.setBackground(new java.awt.Color(8, 40, 75));
        total_amount_before_GST.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        total_amount_before_GST.setForeground(new java.awt.Color(255, 255, 255));
        total_amount_before_GST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_amount_before_GSTActionPerformed(evt);
            }
        });

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
        jLabel6.setText("Customer Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Customer Mobile ");

        CUSTOMER_NAME.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        customer_mobile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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

        invoice_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        invoice_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Type", "HSN", "Net Wt", "Rate", "Total Amt", "Making/gm", "Total Making", "CGST", "SGST", "Final Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoice_table);
        if (invoice_table.getColumnModel().getColumnCount() > 0) {
            invoice_table.getColumnModel().getColumn(0).setResizable(false);
            invoice_table.getColumnModel().getColumn(0).setPreferredWidth(150);
            invoice_table.getColumnModel().getColumn(3).setResizable(false);
            invoice_table.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        without_gst_making.setEditable(false);
        without_gst_making.setBackground(new java.awt.Color(8, 40, 75));
        without_gst_making.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        without_gst_making.setForeground(new java.awt.Color(255, 255, 255));
        without_gst_making.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                without_gst_makingActionPerformed(evt);
            }
        });

        making_total.setEditable(false);
        making_total.setBackground(new java.awt.Color(8, 40, 75));
        making_total.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        making_total.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Before Making & GST");

        jLabel2.setText("After Making and GST");

        jLabel3.setText("Making Charges");

        jLabel4.setText("GST 3 %");

        jLabel5.setText("Total Payabale amoiunt");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Breakup");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Address");

        cust_address.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        add_hallmarking_to_invoice.setBackground(new java.awt.Color(0, 119, 182));
        add_hallmarking_to_invoice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add_hallmarking_to_invoice.setForeground(new java.awt.Color(255, 255, 255));
        add_hallmarking_to_invoice.setText("Add HallMark");
        add_hallmarking_to_invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_hallmarking_to_invoiceMouseClicked(evt);
            }
        });
        add_hallmarking_to_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_hallmarking_to_invoiceActionPerformed(evt);
            }
        });

        hallmark_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallmark_unitActionPerformed(evt);
            }
        });

        test_print.setText("Print bill");
        test_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_printActionPerformed(evt);
            }
        });

        hallmark_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HallMarking charges", "unit", "Total", "SGCT", "CGST", "Invoice Amt"
            }
        ));
        jScrollPane2.setViewportView(hallmark_table);
        if (hallmark_table.getColumnModel().getColumnCount() > 0) {
            hallmark_table.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(360, 360, 360)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(customer_mobile, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CUSTOMER_NAME, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cust_address, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(selected_product_for_billing, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(purity_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(grasm_weight_of_selected_product, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240)
                                .addComponent(test_print))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(without_gst_making, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(making_total, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(Reset_bill))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(print_invoice_generate_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_amount_before_GST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gst_on_product_bill)
                                    .addComponent(final_billing_amount)
                                    .addComponent(add_hallmarking_to_invoice, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hallmark_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))))))
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selected_product_for_billing)
                        .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(purity_selected)
                        .addComponent(grasm_weight_of_selected_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(test_print)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CUSTOMER_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(cust_address, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(without_gst_making, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(making_total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_amount_before_GST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gst_on_product_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(final_billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_hallmarking_to_invoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hallmark_unit))
                        .addGap(32, 32, 32)
                        .addComponent(Reset_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(print_invoice_generate_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void invoice_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoice_numberActionPerformed

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
        /**INVOICE SAVED IN DB */  
        
   /*******************************************************************************************************************/     
        String path = "Invoice";    
        //declaraing path variable
        Document doc = new Document();

        com.lowagie.text.Paragraph p = new com.lowagie.text.Paragraph("KHEDIKAR JEWELLERS", //will be used as a paragraph and show paragraph
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(8,40,75)));
        p.setAlignment(Element.ALIGN_CENTER);

        com.lowagie.text.Paragraph invoice = new com.lowagie.text.Paragraph("Customer Name:"+ CUSTOMER_NAME.getText() + "       "+ invoice_number_for_bill+"   " + invoice_billing_date_for_db,
                FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, new Color(0, 0, 0)));
        invoice.setAlignment(Element.ALIGN_CENTER);
        
        PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(path + "\\"+invoice_number_for_bill+".pdf"));

        doc.open();     // opening pdf so that work can be done in it.
        
        
        MyFooter f = new MyFooter();   //making object of footer class
        f.onEndPage(pdf, doc);         //calling method to add header and footer

            PdfPTable tbl = new PdfPTable(11);     
            
            tbl.addCell("Product")  ;             
            tbl.addCell("Type");
            tbl.addCell("HSN");
            tbl.addCell("Net Wt");
            tbl.addCell("Rate");
            tbl.addCell("Total Amt");
            tbl.addCell("Making Charge/gm");
            tbl.addCell("Total Making ");
            tbl.addCell("C GST"); 
            tbl.addCell("S GST");
            tbl.addCell("Final Amt");
                  

            for (int i = 0; i < invoice_table.getRowCount(); i++) 
            {

                String prod = invoice_table.getValueAt(i, 0).toString();
                String type = invoice_table.getValueAt(i, 1).toString();
                String hsn = invoice_table.getValueAt(i, 2).toString();
                String net_wt = invoice_table.getValueAt(i, 3).toString();
                String rate = invoice_table.getValueAt(i, 4).toString();
                String total_amt = invoice_table.getValueAt(i, 5).toString();
                String making_p_gm = invoice_table.getValueAt(i, 6).toString();
                String tot_making = invoice_table.getValueAt(i, 7).toString();
                String cgst = invoice_table.getValueAt(i, 8).toString();
                String sgst = invoice_table.getValueAt(i, 9).toString();
                String finak_amt = invoice_table.getValueAt(i, 10).toString();
               
                
                tbl.addCell(prod);
                tbl.addCell(type);
                tbl.addCell(hsn);
                tbl.addCell(net_wt);
                tbl.addCell(rate);
                tbl.addCell(total_amt);
                tbl.addCell(making_p_gm);
                tbl.addCell(tot_making);
                tbl.addCell(cgst);
                tbl.addCell(sgst);
                tbl.addCell(finak_amt);
                
            }

            Image image = Image.getInstance("C:\\Users\\radake_a\\OneDrive\\Documents\\NetBeansProjects\\Aniket Radake work\\Aniket Radake work\\Aniket Radake work\\Clientswork\\src\\logo.jpg");  //adding image as a logo
            image.scaleToFit(75, 200);  //trimming the size of photo
            doc.add(image);             // adding image in the pdf
            for (int i = 0; i < 1; i++) {          // making the gap of 1 line
                doc.add(new com.lowagie.text.Paragraph(" "));
            }

            doc.add(p);                      // adding paragraph in the pdf
            for (int i = 0; i < 1; i++) {
                doc.add(new com.lowagie.text.Paragraph(" "));
            }
            doc.add(invoice);                     //adding another paragraph
            for (int i = 0; i < 1; i++)
            {
                doc.add(new com.lowagie.text.Paragraph(" "));
            }
            doc.add(tbl);                           //adding table in it.
            doc.close();
            
            JOptionPane.showMessageDialog(null, "Invoice generated");

            new GenerateBill_Tabl().setVisible(true);
            dispose();;

 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "ERROR.!! INVOICE GENRATE FAILED");
           e.printStackTrace();
       }
        
}

    else
    {
       JOptionPane.showMessageDialog(null, "CUSTOMER MOBILE OR NAME IS MISSING"); 
    }
       

    }//GEN-LAST:event_print_invoice_generate_pdfActionPerformed



    private void Reset_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reset_billActionPerformed
        new GenerateBill_Tabl().setVisible(true);
        dispose();
    }//GEN-LAST:event_Reset_billActionPerformed

    private void grasm_weight_of_selected_productKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grasm_weight_of_selected_productKeyPressed

        UtilityMethods utility= new UtilityMethods();

        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            if (!grasm_weight_of_selected_product.getText().equals("") )
            {
                // GETTING PRODUCT BILLING DETAILS
                String Selected_product_billing=(String) selected_product_for_billing.getSelectedItem();
                String Selected_Purity_billing = (String) purity_selected.getSelectedItem();
                float grams_of_selected_product= Float.parseFloat(grasm_weight_of_selected_product.getText());
            
                float product_final_amount=0;
                float billing_rate=0;

                if (Selected_Purity_billing.equalsIgnoreCase("GOLD_24K"))
                {
                    billing_rate+=Gold24K;
                    product_final_amount+= (Gold24K_pergrams*grams_of_selected_product);
                    amount_before_making_and_gst=product_final_amount;
                    float making_charges = utility.returnMakingChargesIndividial(Selected_product_billing, grams_of_selected_product);
                    product_final_amount+=making_charges;
                  
                    Billing_HSN=Gold24K_HSN;

                }
                if (Selected_Purity_billing.equalsIgnoreCase("GOLD_22K"))
                {
                    product_final_amount+= (Gold22k_pergrams*grams_of_selected_product);
                    amount_before_making_and_gst=product_final_amount;
                    billing_rate+=Gold22K;
                    float making_charges = utility.returnMakingChargesIndividial(Selected_product_billing, grams_of_selected_product);
                    product_final_amount+=making_charges;
                    
                    Billing_HSN=Gold22K_HSN;
                }
                if (Selected_Purity_billing.equalsIgnoreCase("SILVER"))
                {
                    product_final_amount+= (Silver_pergrams*grams_of_selected_product);
                    amount_before_making_and_gst=product_final_amount;
                    billing_rate+=SILVER_PRIC;
                    float making_charges = utility.returnMakingChargesIndividial(Selected_product_billing, grams_of_selected_product);
                    product_final_amount+=making_charges;
                   
                    Billing_HSN=SILVER_HSN;
                }
/*--------------------------------------------------------------------------------------------------------------------------------*/
                list_product_individual_amount.addElement(String.valueOf(product_final_amount));
                list_product_individual_name.addElement("Product-"+Selected_product_billing+ " "+"Quality-"+Selected_Purity_billing+" "+" Net Wt[gms]-"+grams_of_selected_product+" Billing Rate-"+billing_rate);

                float total_cost=0;
                // CALCULATING FINAL BILLING AMOUNT
                for(int i=0;i< list_product_individual_amount.getSize();i++)
                {
                    total_cost +=Float.parseFloat(list_product_individual_amount.getElementAt(i));
                }

                float before_GST=total_cost;
                after_GST=before_GST+(before_GST/100)*3;
                gst_on_product_bill.setText(Float.toString((before_GST/100)*3));
                final_billing_amount.setText(Float.toString(after_GST));
                
                // Number to words conversion
 //               in_words_final_billing_amount.setText(Number_to_word_desc.convertToWords((long) after_GST));
 
                total_amount_before_GST.setText(Float.toString(total_cost));
                // getting making chagrs
                Connection con= ConnectionProvider.getCon();
                float making_item_wise = 0;
                try
                {
                    PreparedStatement making_chrge= con.prepareStatement("Select * from jewellery_type_list where product_description="+"'"+Selected_product_billing+"'", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
                    rs=making_chrge.executeQuery();
                    rs.first();
                    making_item_wise=rs.getFloat("making_charge_per_gm");
                }
                catch ( Exception e)
                {
                    e.printStackTrace();
                }
/*--------------------------------------------------------------------------------------------------------------------------------*/
                float returnMakingChargesIndividual=utility.returnMakingChargesIndividial(Selected_product_billing, grams_of_selected_product);
                float amount_after_making_chrge=amount_before_making_and_gst+returnMakingChargesIndividual;
                float CGST=utility.returnCGST(amount_after_making_chrge);
                float SGST=utility.returnCGST(amount_after_making_chrge);
                float final_invoice_amount=utility.returnInvoiceAMount(amount_before_making_and_gst, returnMakingChargesIndividual, CGST, SGST);

                String inp[]=
                { Selected_product_billing,
                    Selected_Purity_billing,
                    Billing_HSN,String.valueOf(grams_of_selected_product),
                    String.valueOf(billing_rate),
                    String.valueOf(amount_before_making_and_gst),
                    String.valueOf(making_item_wise),
                    String.valueOf(returnMakingChargesIndividual),
                    String.valueOf(CGST),
                    String.valueOf(SGST),
                    String.valueOf(final_invoice_amount)
                };

                DefaultTableModel tbMod= (DefaultTableModel) invoice_table.getModel();

                tbMod.addRow(inp);

                JOptionPane.showMessageDialog(null,"Product added to Invoice");
/*--------------------------------------------------------------------------------------------------------------------------------*/
                // Program to populate some fields
                  float without_gst_making_i = 0;
                  float making_tot=0;
                  float cgst_tot=0;  float sgst_tot=0;
                  for(int i = 0; i < invoice_table.getRowCount(); i++)
                  {
                      // 10: becuz 10th column in Table
                      without_gst_making_i = without_gst_making_i + Float.parseFloat(invoice_table.getValueAt(i, 5).toString());
                      making_tot = making_tot + Float.parseFloat(invoice_table.getValueAt(i, 7).toString());
                  }

                  without_gst_making.setText(Float.toString(without_gst_making_i));
                  making_total.setText(Float.toString(making_tot));


            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please provide weight");
            }

        }

    }//GEN-LAST:event_grasm_weight_of_selected_productKeyPressed

    private void grasm_weight_of_selected_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grasm_weight_of_selected_productActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grasm_weight_of_selected_productActionPerformed

    private void selected_product_for_billingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selected_product_for_billingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selected_product_for_billingActionPerformed

    private void gst_on_product_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gst_on_product_billActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gst_on_product_billActionPerformed

    private void total_amount_before_GSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_amount_before_GSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_amount_before_GSTActionPerformed

    private void without_gst_makingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_without_gst_makingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_without_gst_makingActionPerformed

    private void test_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_printActionPerformed
 
         try
         {
             String path="Invoice\\"+invoice_number.getText()+".pdf";           
             Document document= new Document();           
             PdfWriter.getInstance(document, new FileOutputStream(path));
             document.open();
             PdfPTable inv_tb= new PdfPTable(11);
             
             com.lowagie.text.Paragraph p= new  com.lowagie.text.Paragraph("KHEDIKAR JEWELLERS");
             document.add(p);
             
             document.addTitle("Khedikar jewwellers");
             document.addHeader("heading","welcome to jewellers");
             
             inv_tb.addCell("Product");
             inv_tb.addCell("TYPE");
             inv_tb.addCell("HSN");
             inv_tb.addCell("NET WT");
             inv_tb.addCell("RATE");
             inv_tb.addCell("TOTAL AMT");
             inv_tb.addCell("MAKING/GM");
             inv_tb.addCell("TOTAL MAKING");
             inv_tb.addCell("CGST");
             inv_tb.addCell("SGST");
             inv_tb.addCell("FINAL AMOUNT");
             
             for ( int i=0;i<invoice_table.getRowCount();i++)
             {
                 String Product=invoice_table.getValueAt(i, 0).toString();
                 String TYPE=invoice_table.getValueAt(i, 1).toString();
                 String HSN=invoice_table.getValueAt(i, 2).toString();
                 String NET_WT=invoice_table.getValueAt(i, 3).toString();
                 String RATE=invoice_table.getValueAt(i, 4).toString();
                 String TOTAL_AMT=invoice_table.getValueAt(i, 5).toString();
                 String MAKING_P_GM=invoice_table.getValueAt(i, 6).toString();
                 String TOT_MAKING=invoice_table.getValueAt(i, 7).toString();
                 String CGST=invoice_table.getValueAt(i, 8).toString();
                 String SGST=invoice_table.getValueAt(i, 9).toString();
                 String FINAL_AMT=invoice_table.getValueAt(i, 10).toString();       
                 inv_tb.addCell(Product);
                 inv_tb.addCell(TYPE);
                 inv_tb.addCell(HSN);
                 inv_tb.addCell(NET_WT);
                 inv_tb.addCell(RATE);
                 inv_tb.addCell(TOTAL_AMT);
                 inv_tb.addCell(MAKING_P_GM);
                 inv_tb.addCell(TOT_MAKING);
                 inv_tb.addCell(CGST);
                 inv_tb.addCell(SGST);
                 inv_tb.addCell(FINAL_AMT);
             }
        
             try
             { 
                 document.add(inv_tb);JOptionPane.showMessageDialog(null, "DONE"); 
             }
             catch (DocumentException ex)
             { JOptionPane.showMessageDialog(null, "FAILED"); Logger.getLogger(GenerateBill_Tabl.class.getName()).log(Level.SEVERE, null, ex);
             }
             finally{
             document.close();
             }
             
             
             
         } catch (FileNotFoundException ex) 
         {
             Logger.getLogger(GenerateBill_Tabl.class.getName()).log(Level.SEVERE,null, ex);
         } catch (DocumentException ex) {
             Logger.getLogger(GenerateBill_Tabl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       
         
  
    }//GEN-LAST:event_test_printActionPerformed

    private void add_hallmarking_to_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_hallmarking_to_invoiceActionPerformed
          float hallmarking_charge_per_item = 0;
                 UtilityMethods utility= new UtilityMethods();
                try
                {
                    Connection con= ConnectionProvider.getCon();
                    PreparedStatement hallmark= con.prepareStatement("Select * from hallmarking_rates ", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
                    rs=hallmark.executeQuery();
                    rs.first();
                    hallmarking_charge_per_item=rs.getFloat("price_per_unit");
                }
                catch ( Exception e)
                {
                    e.printStackTrace();
                }
                
                float total_hallmark=hallmarking_charge_per_item * Float.parseFloat( hallmark_unit.getText()) ;
                float hall_mark_split_gst=utility.returnGST_Hallmarking(total_hallmark);
                
                float total_for_hallmark_section=total_hallmark+hall_mark_split_gst+hall_mark_split_gst;
                
                String inp[]=
                { 
                   String.valueOf(hallmarking_charge_per_item),
                   String.valueOf(hallmark_unit.getText()),
                   String.valueOf( total_hallmark), 
                   String.valueOf( hall_mark_split_gst), 
                   String.valueOf( hall_mark_split_gst),
                   String.valueOf(  total_for_hallmark_section)                          
                
                };

                DefaultTableModel tbMod= (DefaultTableModel) hallmark_table.getModel();

                tbMod.addRow(inp);

                JOptionPane.showMessageDialog(null,"Hall Marking charges added");      
    }//GEN-LAST:event_add_hallmarking_to_invoiceActionPerformed

    private void hallmark_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallmark_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hallmark_unitActionPerformed

    private void add_hallmarking_to_invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_hallmarking_to_invoiceMouseClicked
      
    }//GEN-LAST:event_add_hallmarking_to_invoiceMouseClicked

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
    private javax.swing.JButton add_hallmarking_to_invoice;
    private javax.swing.JTextField cust_address;
    private javax.swing.JTextField customer_mobile;
    private javax.swing.JTextField final_billing_amount;
    private javax.swing.JTextField grasm_weight_of_selected_product;
    private javax.swing.JTextField gst_on_product_bill;
    private javax.swing.JTable hallmark_table;
    private javax.swing.JTextField hallmark_unit;
    private javax.swing.JTextField invoice_number;
    private javax.swing.JTable invoice_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField making_total;
    private javax.swing.JButton print_invoice_generate_pdf;
    private javax.swing.JComboBox<String> purity_selected;
    private javax.swing.JComboBox<String> selected_product_for_billing;
    private javax.swing.JButton test_print;
    private javax.swing.JTextField total_amount_before_GST;
    private javax.swing.JTextField without_gst_making;
    // End of variables declaration//GEN-END:variables

    
    
}
