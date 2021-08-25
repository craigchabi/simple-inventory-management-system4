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
public class Customer {

    public int id;
    public String name;
    public String address;
    public int telephone;
    public String email;

    public Customer(String name, String address, int telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public Customer(int id, String name, String address, int telephone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        
    }
}
