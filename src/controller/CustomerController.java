/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Customer;
import model.DB;

/**
 *
 * @author sandakelum
 */
public class CustomerController {

    Customer customer;
    Tools tools;

    public CustomerController() {
        tools = new Tools();
    }

    public CustomerController(Customer customer) {
        this.customer = customer;
        tools = new Tools();
    }

    public void saveCustomer() {
        try {
            Connection con = DB.createConnetion();
            String sql = "INSERT INTO customers ( name,address,telephone,email) VALUES (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, customer.name);
            stm.setString(2, customer.address);
            stm.setInt(3, customer.telephone);
            stm.setString(4, customer.email);

            int response = stm.executeUpdate();
            if (response > 0) {
                JOptionPane.showMessageDialog(tools.getVisibleContent(), "New customer added", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
//            System.out.println("error" + e.getMessage());
            JOptionPane.showMessageDialog(tools.getVisibleContent(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet loadCustomers() {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM customers";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }

    public ArrayList<Customer> loadCustomersAsArray() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            ResultSet r = loadCustomers();
            while (r.next()) {
                customers.add(new Customer(r.getInt("id"), r.getString("name"), r.getString("address"), r.getInt("telephone"), r.getString("email")));
            }
        } catch (Exception e) {

        }
        return customers;
    }

    public void deleteCustomer(String id) {
        try {
            Connection con = DB.createConnetion();
            String sql = "DELETE FROM customers WHERE id = '" + id + "'";
            Statement stm = con.createStatement();

            if (JOptionPane.showConfirmDialog(tools.getVisibleContent(),
                    "Are you sure?", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                int response = stm.executeUpdate(sql);
//                if (response > 0) {
//                    JOptionPane.showMessageDialog(getVisibleContent(), "Item deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
//                }
            }

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }
    


    public void updateCustomer() {
        try {
            Connection con = DB.createConnetion();
            String sql = "UPDATE customers SET name='"
                    + customer.name + "' , address='"
                    + customer.address + "', telephone="
                    + customer.telephone + ", email = '"
                    + customer.email + "' WHERE id = " + customer.id + " ";

//            System.out.println(sql);
            Statement stm = con.createStatement();

            int response = stm.executeUpdate(sql);
            if (response > 0) {
                JOptionPane.showMessageDialog(tools.getVisibleContent(), "Item Updated", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
//            System.out.println("error" + e.getMessage());
            JOptionPane.showMessageDialog(tools.getVisibleContent(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ResultSet searchCustomers(String data) {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM customers WHERE name LIKE '" + data + "%'";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }
    
    public String getCutomerNameById(int id){
        ResultSet r = null;
        String name = "";
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT name FROM customers WHERE id = "+id;
            r = stmt.executeQuery(sql);
            while(r.next()){
                name = r.getString("name");
            }
        } catch (Exception e) {
        }
        return name;
    }

}
