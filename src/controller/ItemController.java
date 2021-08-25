/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DB;
import model.Item;

/**
 *
 * @author sandakelum
 */
public class ItemController {

    Item item;
    Tools tools;

    public ItemController() {
        tools = new Tools();
    }

    public ItemController(Item item) {
        this.item = item;
        tools = new Tools();

    }

    public void saveItem() {
        try {
            Connection con = DB.createConnetion();
            String sql = "INSERT INTO items ( itemCode,itemName,itemPrice,quantity) VALUES (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, item.itemCode);
            stm.setString(2, item.itemName);
            stm.setFloat(3, item.price);
            stm.setInt(4, item.quantity);

            int response = stm.executeUpdate();
            if (response > 0) {
                JOptionPane.showMessageDialog(tools.getVisibleContent(), "New item added", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
//            System.out.println("error" + e.getMessage());
            JOptionPane.showMessageDialog(tools.getVisibleContent(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteItem(String itemCode) {
        try {
            Connection con = DB.createConnetion();
            String sql = "DELETE FROM items WHERE itemCode = '" + itemCode + "'";
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

    public void updateItem() {
        try {
            Connection con = DB.createConnetion();
            String sql = "UPDATE items SET itemName='" + item.itemName + "' , itemPrice= " + item.price + " , quantity = " + item.quantity + " WHERE itemCode = '" + item.itemCode + "' ";
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

    public ResultSet loadItems() {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM items";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }

    public ArrayList<Item> loadItemsAsArray() {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            ResultSet r = loadItems();

            while (r.next()) {
                items.add(new Item(r.getString("itemCode"), r.getString("itemName"), r.getFloat("itemPrice"), r.getInt("quantity")));

            }
        } catch (Exception e) {
        }
        return items;
    }

    public int getItemQuantity(String itemCode) {
        ResultSet r = null;
        int q = 0;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT quantity FROM items WHERE itemCode = '" + itemCode + "'";
            r = stmt.executeQuery(sql);
            while (r.next()) {
                q = r.getInt("quantity");
            }

//            System.out.println(q);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return q;
    }

    public float getItemPrice(String itemCode) {
        ResultSet r = null;
        float p = 0;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT itemPrice FROM items WHERE itemCode = '" + itemCode + "'";
            r = stmt.executeQuery(sql);
            while (r.next()) {
                p = r.getInt("itemPrice");
            }

//            System.out.println(q);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return p;
    }

    public boolean checkItemQuantity(String itemCode, int demand) {
        if (getItemQuantity(itemCode) < demand) {
            return false;
        } else {
            return true;

        }
    }

    public ResultSet searchItems(String col, String data) {
        ResultSet r = null;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM items WHERE " + col + " LIKE '" + data + "%'";
            r = stmt.executeQuery(sql);
        } catch (Exception e) {
        }
        return r;

    }

    public void updateItemQuantity(String itemCode, int demand) {
        int newq = getItemQuantity(itemCode) - demand;
        try {
            Connection con = DB.createConnetion();
            Statement stmt = con.createStatement();
            String sql = "UPDATE items SET quantity = " + newq + " WHERE itemCode = '" + itemCode + "'";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }

}
