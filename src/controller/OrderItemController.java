/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.DB;
import model.OrderItem;



/**
 *
 * @author sandakelum
 */
public class OrderItemController {

    Tools tools;
    OrderItem orderItem;

    public OrderItemController() {
        this.tools = new Tools();
    }

    public OrderItemController(OrderItem orderItem) {
        this.tools = new Tools();
        this.orderItem = orderItem;
    }

    public void orderItemSave() {

        try {
            Connection con = DB.createConnetion();
            String sql = "INSERT INTO orderItems (itemCode,orderRandId,quantity) VALUES (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, orderItem.itemCode);
            stm.setString(2, orderItem.orderRandId);
            stm.setInt(3, orderItem.quantity);
           

            int response = stm.executeUpdate();
//            if (response > 0) {
//                JOptionPane.showMessageDialog(tools.getVisibleContent(), "New Order added", "Info", JOptionPane.INFORMATION_MESSAGE);
//            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
//            JOptionPane.showMessageDialog(tools.getVisibleContent(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public ResultSet getOrderItemsByRef(String ref){
            ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM orderItems WHERE orderRandId = '"+ref+"'";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;
    
    }
    
}
