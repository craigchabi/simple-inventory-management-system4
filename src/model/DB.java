/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sandakelum
 */
public class DB {
    public static Connection createConnetion() throws Exception{
       String url = "jdbc:mysql://localhost/eadcw2";
       Connection con = DriverManager.getConnection(url,"root","");
       return con;
    }
}
