package com.autoeurope.carrental.util;

import java.sql.*; 

/**
 *
 * @author shraddha bhatt
 */
public class DBConnection{
    
    public Connection con;
    public DBConnection(){
        
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            // Establish connection
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/auto_europe","root","root");
                    
            }
            catch(Exception e){ System.out.println(e);}  
    } 
    
    // return the connection object
    public Connection getConnection() throws Exception {
       	return con;
    }
    
 }

