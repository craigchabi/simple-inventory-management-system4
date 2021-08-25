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
public class Order {

    public String randId;    
    public int customerId;
    public String date;
    public float price;

    public Order(String randId, int customerId, String date, float price) {
        this.randId = randId;
        this.customerId = customerId;
        this.date = date;
        this.price = price;
    }


}
