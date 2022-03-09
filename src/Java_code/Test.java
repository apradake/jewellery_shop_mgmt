/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lichadejewellers.ConnectionProvider;

/**
 *
 * @author radake_a
 */
public class Test {
   
    public static void main(String[] args)
    {
        ResultSet rs= null;
        try
        {
            Connection con= ConnectionProvider.getCon();
            // GETTING COUNTER OF INVOICE
            PreparedStatement countCheck= con.prepareStatement("Select * from invoice_counter");

            rs=countCheck.executeQuery();
            
            int count=rs.getInt("count");
            System.out.println("Counter is "+count);
         }
        catch( Exception e)
        {
            e.getMessage();
        }
    }  
}
