/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;  //add this to pass "Doesn't override abstract method" error
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author LanternGenie
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        this.setTitle("Inventory Management");
        this.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLogin.setFont(new java.awt.Font("Tahoma", 1, 28));
        Btn_OK.setFont(new java.awt.Font("Tahoma", 1, 28));
        jCB_ShowPassword.setFont(new java.awt.Font("Tahoma", 0, 20));
        //return false;
    }

    //Set Timer
    Timer timer1 = new Timer(30, new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(jPanel_Message.getHeight() != 105) {
                jPanel_Message.setBounds(0,0,Login.this.getSize().width,jPanel_Message.getHeight()+5);
                if(jPanel_Message.getHeight() == 105) {
                    timer1.stop();
                }
            }
        }
    });
    
    //@SuppressWarnings("unchecked");
    Timer timer2 = new Timer(30, new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(jPanel_Message.getHeight() != 0) {
                jPanel_Message.setBounds(0,0,Login.this.getSize().width,jPanel_Message.getHeight()-5);
                if(jPanel_Message.getHeight() == 0) {
                    timer2.stop();
                }
            }
        }
    });
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLogin = new javax.swing.JButton();
        jCB_ShowPassword = new javax.swing.JCheckBox();
        jPanel_Message = new javax.swing.JPanel();
        Btn_OK = new javax.swing.JButton();
        jLabel_Message = new javax.swing.JLabel();
        txt_pwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_ID.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Password:");

        jLogin.setText("Login");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        jCB_ShowPassword.setText("Show password");
        jCB_ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_ShowPasswordActionPerformed(evt);
            }
        });

        jPanel_Message.setBackground(new java.awt.Color(204, 255, 255));

        Btn_OK.setText("OK");
        Btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OKActionPerformed(evt);
            }
        });

        jLabel_Message.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N

        javax.swing.GroupLayout jPanel_MessageLayout = new javax.swing.GroupLayout(jPanel_Message);
        jPanel_Message.setLayout(jPanel_MessageLayout);
        jPanel_MessageLayout.setHorizontalGroup(
            jPanel_MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MessageLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel_MessageLayout.setVerticalGroup(
            jPanel_MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MessageLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel_MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Message))
                .addGap(60, 60, 60))
        );

        txt_pwd.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCB_ShowPassword)
                    .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jCB_ShowPassword)
                .addGap(52, 52, 52)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void Btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OKActionPerformed
        timer2.start();
    }//GEN-LAST:event_Btn_OKActionPerformed

    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        
         Connection conn;
         PreparedStatement ps;
            
         try {   
            conn = DriverManager.getConnection("jdbc:mysql://localhost/products_db2", "root", "");
            ps = conn.prepareStatement("SELECT `username`, `password` FROM `users` WHERE `username` = ?AND `password` = ?");
            // It's `, NOT '
            ps.setString(1, txt_ID.getText());
            ps.setString(2, String.valueOf(txt_pwd.getPassword()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                jLabel_Message.setText("Login Successesfully");
                jLabel_Message.setForeground(Color.GREEN);
                timer1.start();
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    //</editor-fold>

                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            //new Login().setVisible(true);     //create login window 
                            setVisible(false); 
                            //this.confirmExit();
                            //JFrame.EXIT_ON_CLOSE;
                            new Main_Window().setVisible(true);  
                            //System.exit(0);       
                        }
                    });
        
            } else {
                jLabel_Message.setText("Invalid Username Or Password");
                jLabel_Message.setForeground(Color.RED);
                timer1.start();                
            }
    } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLoginActionPerformed

    private void jCB_ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_ShowPasswordActionPerformed
        if(jCB_ShowPassword.isSelected()) {
            txt_pwd.setEchoChar((char)0);
        } else {
            txt_pwd.setEchoChar('*');            
        }
    }//GEN-LAST:event_jCB_ShowPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    /**public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
               //</editor-fold>

        /* Create and display the form */
        /**java.awt.EventQueue.invokeLater(new Runnable() {
        *    public void run() {
         *       new Login().setVisible(true);
         *   }
        *});
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_OK;
    private javax.swing.JCheckBox jCB_ShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Message;
    private javax.swing.JButton jLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Message;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JPasswordField txt_pwd;
    // End of variables declaration//GEN-END:variables
}
