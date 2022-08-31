package com.apucafeteria.frontend;

import com.apucafeteria.backend.controllers.CustomerController;
import com.apucafeteria.backend.controllers.ManagerController;
import com.apucafeteria.backend.utils.ApplicationPath;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    CustomerController customerController = new CustomerController();
    ManagerController managerController;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCusRegister = new javax.swing.JButton();
        btnCusLogin = new javax.swing.JButton();
        txtCusUsername = new javax.swing.JTextField();
        txtCusPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdmLogin = new javax.swing.JButton();
        txtAdmUsername = new javax.swing.JTextField();
        txtAdmPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCusRegister.setText("Register");
        btnCusRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusRegisterActionPerformed(evt);
            }
        });

        btnCusLogin.setText("Login");
        btnCusLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCusRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCusUsername)
                        .addComponent(txtCusPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(btnCusLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCusUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(txtCusPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnCusLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCusRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        btnAdmLogin.setText("Login");
        btnAdmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdmLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdmPassword)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtAdmUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdmUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnAdmLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manager", jPanel2);

        jLabel1.setText("Login as");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCusLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusLoginActionPerformed
        try{
        if(txtCusUsername.getText().isEmpty() || txtCusPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in the Empty Field.");
        } else {
            String[] data = customerController.GetValidUserCredential(txtCusUsername.getText(), txtCusPassword.getText());            
            //C - Customer
            switch (data[3]) {
                case "C":
                    //P - Allowed
                    if(data[4].equals("P")){
                        JOptionPane.showMessageDialog(null, "Login Successful.");
                        customerController.updateUserActiveDateTime(ApplicationPath.Origin.userTable, ApplicationPath.Temp.userTable, txtCusUsername.getText());
                        new CustomerMainMenu(txtCusUsername.getText()).setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Your Account has been Blocked.");
                    }   break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Account.");
                    break;
            }
        }
        } catch (IOException ex) { System.out.println( ex.getMessage()); }
    }//GEN-LAST:event_btnCusLoginActionPerformed

    private void btnCusRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusRegisterActionPerformed
        new Register().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCusRegisterActionPerformed

    private void btnAdmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmLoginActionPerformed
        try{
            String username = txtAdmUsername.getText();
            String password = txtAdmPassword.getText();
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill in the Empty Field.");
            } else {
                managerController = new ManagerController(username, password);
                boolean data = managerController.GetUserAuthorization();            
                if(data){
                    JOptionPane.showMessageDialog(null, "Login Successful.");
                    new ManagerMainMenu(username, password).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Account.");
                }
            }
        } catch (IOException ex) { 
            System.out.println( ex.getMessage()); 
        }
    }//GEN-LAST:event_btnAdmLoginActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmLogin;
    private javax.swing.JButton btnCusLogin;
    private javax.swing.JButton btnCusRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField txtAdmPassword;
    private javax.swing.JTextField txtAdmUsername;
    private javax.swing.JPasswordField txtCusPassword;
    private javax.swing.JTextField txtCusUsername;
    // End of variables declaration//GEN-END:variables
}
