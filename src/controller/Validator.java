/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author sandakelum
 */
public class Validator {

    public void disableSubmit(JButton btns[]) {
//       
        for (int i = 0; i < btns.length; i++) {
            btns[i].setEnabled(false);
        }
    }

    public void txtBoxIsEmpty(JTextField txts[], JButton btns[]) {
        int ready = txts.length;
        for (int i = 0; i < txts.length; i++) {
            if (txts[i].getText().equals("")) {
                ready--;
            }
        }

        if (ready == txts.length) {
            for (int j = 0; j < btns.length; j++) {
                btns[j].setEnabled(true);
            }
        } else {
            for (int j = 0; j < btns.length; j++) {
                btns[j].setEnabled(false);
            }
        }

    }

    public void txtMax(JTextField txt, int max) {
        if (txt.getText().length() > max) {
            txt.setText(txt.getText().substring(0, max));
        }
    }

    public void txtDigit(JTextField txt) {
        for (int i = 0; i < txt.getText().length(); i++) {
            if (!Character.isDigit(txt.getText().charAt(i))) {
                txt.setText(txt.getText().substring(0, i));
            }
        }
    }

    public void isEmail(JTextField txt, JButton btns[]) {
        String rule = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(txt.getText());
        if (!matcher.matches()) {
            txt.setCaretColor(Color.red);
            txt.setForeground(Color.red);
            for (int i = 0; i < btns.length; i++) {
                btns[i].setEnabled(false);
            }
        } else {
            txt.setCaretColor(Color.black);
            txt.setForeground(Color.black);

            for (int i = 0; i < btns.length; i++) {
                btns[i].setEnabled(true);
            }
        }
    }
    
        public void dateIsEmpty(JDateChooser dates[], JButton btns[]) {
        int ready = dates.length;
        for (int i = 0; i < dates.length; i++) {
            if (dates[i].getDate().toString().equals("")) {
                ready--;
            }
        }

        if (ready == dates.length) {
            for (int j = 0; j < btns.length; j++) {
                btns[j].setEnabled(true);
            }
        } else {
            for (int j = 0; j < btns.length; j++) {
                btns[j].setEnabled(false);
            }
        }

    }

}
