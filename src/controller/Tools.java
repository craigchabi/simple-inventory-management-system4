/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.util.Random;

/**
 *
 * @author sandakelum
 */
public class Tools {

    public Window getVisibleContent() {
        Window r = null;
        for (Window w : Window.getWindows()) {
            if (w.isVisible()) {
                r = w;
            }
        }
        return r;
    }

    public String randomString(int limit) {
//        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijlmnopqrstuvwxyz";
        String all = "0123456789";

        String gstr = "";
        Random rand = new Random();
        
        for(int i=0;i<limit;i++){
            int len = all.length();
            
            gstr = gstr + all.charAt(rand.nextInt(len));
        }

        return "OR-"+gstr;
    }
}
