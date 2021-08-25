/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ItemController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import view.internal.About;
import view.internal.AddCustomer;
import view.internal.ViewItem;

import view.internal.AddItem;
import view.internal.AddOrder;
import view.internal.ChangePassword;
import view.internal.GenerateOrderReport;

import view.internal.ViewCustomer;
import view.internal.ViewOrder;

/**
 *
 * @author sandakelum
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    private void setToCenter(JInternalFrame iframe, JDesktopPane dt) {
        Dimension dtSize = dt.getSize();
        Dimension ifSize = iframe.getSize();
        iframe.setLocation((dtSize.width - ifSize.width) / 2, (dtSize.height - ifSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/view/Images/bg.jpg"));
        Image img = icon.getImage();
        vDesktop = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        miNewItem = new javax.swing.JMenuItem();
        miViewItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        miNewOrder = new javax.swing.JMenuItem();
        miViewOrders = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miNewCustomer = new javax.swing.JMenuItem();
        miViewCustomer = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        miItemReport = new javax.swing.JMenuItem();
        miOrderReport = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miChangePass = new javax.swing.JMenuItem();
        miAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management System | Main Window");
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        vDesktop.setAutoscrolls(true);
        vDesktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(vDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(vDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );

        jMenu3.setText("Items");

        miNewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK));
        miNewItem.setText("Add new item");
        miNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewItemActionPerformed(evt);
            }
        });
        jMenu3.add(miNewItem);

        miViewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        miViewItem.setText("View items");
        miViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewItemActionPerformed(evt);
            }
        });
        jMenu3.add(miViewItem);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Orders");

        miNewOrder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
        miNewOrder.setText("New Order");
        miNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewOrderActionPerformed(evt);
            }
        });
        jMenu4.add(miNewOrder);

        miViewOrders.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        miViewOrders.setText("View Orders");
        miViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewOrdersActionPerformed(evt);
            }
        });
        jMenu4.add(miViewOrders);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Customers");

        miNewCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        miNewCustomer.setText("New Customer");
        miNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewCustomerActionPerformed(evt);
            }
        });
        jMenu5.add(miNewCustomer);

        miViewCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        miViewCustomer.setText("View Customers");
        miViewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewCustomerActionPerformed(evt);
            }
        });
        jMenu5.add(miViewCustomer);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Reports");

        miItemReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        miItemReport.setText("Item Report");
        miItemReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miItemReportActionPerformed(evt);
            }
        });
        jMenu6.add(miItemReport);

        miOrderReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        miOrderReport.setText("Order Report");
        miOrderReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOrderReportActionPerformed(evt);
            }
        });
        jMenu6.add(miOrderReport);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Settings");

        miChangePass.setText("Change Password");
        miChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangePassActionPerformed(evt);
            }
        });
        jMenu7.add(miChangePass);

        miAbout.setText("About");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        jMenu7.add(miAbout);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewItemActionPerformed
        AddItem addi = new AddItem();
        setToCenter(addi, vDesktop);
        vDesktop.add(addi).setVisible(true);
    }//GEN-LAST:event_miNewItemActionPerformed

    private void miViewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewItemActionPerformed
        ViewItem vi = new ViewItem();
        setToCenter(vi, vDesktop);
        vDesktop.add(vi).setVisible(true);
    }//GEN-LAST:event_miViewItemActionPerformed

    private void miNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewCustomerActionPerformed
        AddCustomer ac = new AddCustomer();
        setToCenter(ac, vDesktop);
        vDesktop.add(ac).setVisible(true);
    }//GEN-LAST:event_miNewCustomerActionPerformed

    private void miViewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewCustomerActionPerformed
        ViewCustomer vc = new ViewCustomer();
        setToCenter(vc, vDesktop);
        vDesktop.add(vc).setVisible(true);
    }//GEN-LAST:event_miViewCustomerActionPerformed

    private void miNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewOrderActionPerformed
        AddOrder ao = new AddOrder();
        setToCenter(ao, vDesktop);
        vDesktop.add(ao).setVisible(true);
    }//GEN-LAST:event_miNewOrderActionPerformed

    private void miViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewOrdersActionPerformed
        ViewOrder vo = new ViewOrder();
        setToCenter(vo, vDesktop);
        vDesktop.add(vo).setVisible(true);
    }//GEN-LAST:event_miViewOrdersActionPerformed

    private void miItemReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miItemReportActionPerformed
        ItemController ic = new ItemController();

        try {
            String strHtml = "<html>"
                    + "<head><meta name='viewport' content='width=device-width', initial-scale=1.0'>"
                    + "<style>"
                    + "body{"
                    + "font-family:arial;"
                    + "}"
                    + ".rhead{background-color:#001e6c; }"
                    + ".col-head{background-color:#035397;}"
                    + ".wh{color:#ffffff;}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<div>"
                    + "<table style='width:100%'>"
                    + "<tr class='rhead' ><th colspan='4'><h1 class='wh' >Item Report</h1></th></tr>"
                    + "<tr><th colspan='4'><p style='color:red'>Items less than 20 are displayes in red color</th></tr>"
                    + "<tbody style='font-size:13px;' >"
                    + "<tr class='col-head' ><td class='wh' ><b>Item Code</b></td>"
                    + "<td class='wh' ><b>Item Name</b></td>"
                    + "<td class='wh' ><b>Item Price</b></td>"
                    + "<td class='wh' ><b>Item Quantity</b></td></tr>";

            ResultSet r = ic.loadItems();
            while (r.next()) {
                String trow = "";
                if (r.getInt("quantity") < 20) {
                    trow = "<tr style='color:red;'>"
                            + "<td>" + r.getString("itemCode") + "</td>"
                            + "<td>" + r.getString("itemName") + "</td>"
                            + "<td>" + r.getFloat("itemPrice") + "</td>"
                            + "<td>" + r.getInt("quantity") + "</td>"
                            + "</tr>";
                } else {
                    trow = "<tr>"
                            + "<td>" + r.getString("itemCode") + "</td>"
                            + "<td>" + r.getString("itemName") + "</td>"
                            + "<td>" + r.getFloat("itemPrice") + "</td>"
                            + "<td>" + r.getInt("quantity") + "</td>"
                            + "</tr>";
                }
                strHtml = strHtml + trow;
            }

            strHtml = strHtml + "</tbody></table></div></body></html>";

            HtmlReport hr = new HtmlReport(this, true);
            hr.setLocationRelativeTo(this);
            hr.loadHtml(strHtml);
            hr.setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_miItemReportActionPerformed

    private void miOrderReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOrderReportActionPerformed
        GenerateOrderReport gor = new GenerateOrderReport();
        setToCenter(gor, vDesktop);
        vDesktop.add(gor).setVisible(true);
    }//GEN-LAST:event_miOrderReportActionPerformed

    private void miChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miChangePassActionPerformed
        ChangePassword cp = new ChangePassword();
        setToCenter(cp, vDesktop);
        vDesktop.add(cp).setVisible(true);
    }//GEN-LAST:event_miChangePassActionPerformed

    private void miAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutActionPerformed
        About about = new About();
        setToCenter(about, vDesktop);
        vDesktop.add(about).setVisible(true);
    }//GEN-LAST:event_miAboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miChangePass;
    private javax.swing.JMenuItem miItemReport;
    private javax.swing.JMenuItem miNewCustomer;
    private javax.swing.JMenuItem miNewItem;
    private javax.swing.JMenuItem miNewOrder;
    private javax.swing.JMenuItem miOrderReport;
    private javax.swing.JMenuItem miViewCustomer;
    private javax.swing.JMenuItem miViewItem;
    private javax.swing.JMenuItem miViewOrders;
    private javax.swing.JDesktopPane vDesktop;
    // End of variables declaration//GEN-END:variables
}