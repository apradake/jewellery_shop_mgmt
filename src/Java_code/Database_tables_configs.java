/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import lichadejewellers.ConnectionProvider;

/**
 *
 * @author radake_a
 */
public class Database_tables_configs 

{
    public void CreateDatabase(){
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");               
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","sqlmaster");   
        
        PreparedStatement crateDb= con.prepareStatement("create database if not exists biling" );              
        PreparedStatement UseDB= con.prepareStatement("use biling" );
        crateDb.executeUpdate();  UseDB.executeUpdate();
        

       
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
    public void CreateTables()
    {
     
       try
       {
     Connection con= ConnectionProvider.getCon();
     
     PreparedStatement createTable= con.prepareStatement("create table if not exists final_invoice(invoice_number varchar(100), customer_name varchar(100), invoice_product_list mediumtext, invoice_bill_amount float, invoice_billing_date date, invoice_billing_timestamp timestamp default current_timestamp, customer_contact varchar(15), invoice_gst_paid float)");   
     createTable.executeUpdate();
     
     PreparedStatement creatLogin= con.prepareStatement("create table if not exists app_user(username varchar(50), passkey varchar(50))");  
     creatLogin.execute();
     
     PreparedStatement createMetalCategeory= con.prepareStatement("create table if not exists jewellery_product_rates(product_name varchar(100), prices float)");  
     createMetalCategeory.execute();
     
     PreparedStatement productCategeory= con.prepareStatement("create table if not exists jewellery_type_list(product_description varchar(100))");  
     productCategeory.execute();
     
     ResultSet rs = null;
 
     
     
           // POPULATING TABLES WITH DEFAULT VALUES
            PreparedStatement ps= con.prepareStatement("Select * from app_user where username ="+ "'"+"admin"+"'");

            rs=ps.executeQuery();
                
            if (rs.next()== true)
            {
            do 
            {
                 System.out.println("Defaul user exist");
            }
            while(rs.next());
            
            } 
            else if (rs.next() == false) 
            {
             PreparedStatement default_llogin= con.prepareStatement("insert into app_user values('admin','gama2022')");
    
             default_llogin.execute();   
               
            }
        
        // ADDING DEFAULT GOLD VALUES
        
         PreparedStatement populatMetal= con.prepareStatement("Select * from jewellery_product_rates where product_name ='GOLD_24K'");
        
         rs=populatMetal.executeQuery();
                
            if (rs.next()== true)
            {
            do 
            {
                 System.out.println("Metal Categeory assigned");
            }
            while(rs.next());
            
            } 
            else if (rs.next() == false) 
            {
             PreparedStatement GOLD_22K= con.prepareStatement("insert into jewellery_product_rates values('GOLD_22K',50000)");
             PreparedStatement GOLD_24K= con.prepareStatement("insert into jewellery_product_rates values('GOLD_24K',52000)");
             PreparedStatement SILVER= con.prepareStatement("insert into jewellery_product_rates values('SILVER',7500)");
             GOLD_22K.execute();
             GOLD_24K.execute();
             SILVER.execute();
               
            }
        
       }
       catch( Exception e)
       {
           e.printStackTrace();;
       }
        
        
    }
    
    
    
    
    
    
}
