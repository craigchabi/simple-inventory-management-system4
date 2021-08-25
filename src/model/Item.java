/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sandakelum
 */
public class Item {
    public String itemCode;
    public String itemName;
    public float price;
    public int quantity;
    
    public Item(String itemCode,String itemName,float price,int quantity){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
}
