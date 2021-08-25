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
public class OrderItem {
    public int id;
    public String itemCode;
    public String orderRandId;
    public int quantity;
    
    public OrderItem(String itemCode ,String orderRandId,int quantity){
        
        this.itemCode = itemCode;
        this.orderRandId = orderRandId;
        this.quantity = quantity;
    }
}
