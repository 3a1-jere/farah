/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author farah
 */
public class connection {
    private static final String URL="jdbc:mysql://localhost/pidevtest";
    private static final String username="root";
    private static final String password="";
    static Connection con;
    static connection connexion;

    private connection() {
        try{
           con = DriverManager.getConnection(URL,username,password);
           System.out.println("connexion etablie");
           
       }
       catch(SQLException e)
                   {System.out.println("erreur");
       }
    }
    
    
    public Connection getConn(){
        return con;
    }
    
    public static connection getInstance()
    {
        if (connexion==null)
        {connexion =new connection();
    }
    return connexion;
    }
            
    }

    
    
    
    
    
    
