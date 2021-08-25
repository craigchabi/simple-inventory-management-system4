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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DB;
import model.Order;

/**
 *
 * @author sandakelum
 */
public class OrderController {

    Tools tools;
    Order order;

    public OrderController() {
        tools = new Tools();

    }

    public OrderController(Order order) {
        this.order = order;
    }

    public void orderSave() {
        try {
            Connection con = DB.createConnetion();
            String sql = "INSERT INTO orders (randId,customerId,date,price) VALUES (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, order.randId);
            stm.setInt(2, order.customerId);
            stm.setString(3, order.date);
            stm.setFloat(4, order.price);

            int response = stm.executeUpdate();
            if (response > 0) {
                JOptionPane.showMessageDialog(tools.getVisibleContent(), "New Order added", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
//            System.out.println("error" + e.getMessage());
//            JOptionPane.showMessageDialog(tools.getVisibleContent(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet loadOrders() {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM orders";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }
    
        public ResultSet loadOrdersBetweenDate(String from,String to) {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM orders WHERE date BETWEEN '"+from+"' AND '"+to+"'";
//            System.out.println(sql);
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }

    public ResultSet searchOrdersByCustomerName(String name) {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT orders.*  FROM customers,orders WHERE customers.id = orders.customerId and customers.name LIKE '"+name+"%'";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }

    public ArrayList<Order> loadOrdersAsArray() {

        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            ResultSet r = loadOrders();

            while (r.next()) {
                orders.add(new Order(r.getString("randId"), r.getInt("customerId"), r.getString("date"), r.getFloat("price")));

            }
        } catch (Exception e) {
        }
        return orders;
    }
    
    public void deleteOrders(String orderRef){
        try {
            Connection con = DB.createConnetion();
            String sql = "DELETE FROM orders WHERE randId = '" + orderRef + "'";
            String sql2 = "DELETE FROM orderItems WHERE orderRandId = '" + orderRef + "'";
            Statement stm = con.createStatement();

            if (JOptionPane.showConfirmDialog(tools.getVisibleContent(),
                    "Are you sure?", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                stm.executeUpdate(sql);
                stm.executeUpdate(sql2);

            }

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }
}
