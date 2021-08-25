/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.DB;
import model.User;

/**
 *
 * @author sandakelum
 */
public class UserController {

    User user;

    public UserController(User user) {
        this.user = user;
    }

    public UserController() {
    }

    public boolean auth() {
        boolean isAuth = false;

        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet r = stmt.executeQuery(sql);
            while (r.next()) {
                if (r.getString("userName").equals(user.userName) && r.getString("password").equals(user.password)) {
                    isAuth = true;
                }
            }
        } catch (Exception e) {
        }
        return isAuth;
    }

    public boolean updatePassword(String oldp,String newp) {
        boolean isOk = false;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM user WHERE userName = 'admin'";
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()){
                if(r.getString("password").equals(oldp)){
                    String sql2 = "UPDATE user SET password='"+newp+"' WHERE userName = 'admin'";
                    if(stmt.executeUpdate(sql2) > 0){
                        isOk = true;
                    }
                }
            }

        } catch (Exception e) {
        }
        
        return isOk;
    }
}
