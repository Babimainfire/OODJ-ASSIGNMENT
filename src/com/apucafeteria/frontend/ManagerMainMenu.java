package com.apucafeteria.frontend;

import com.apucafeteria.backend.controllers.ManagerController;
import com.apucafeteria.models.Menu;
import com.apucafeteria.models.Order;
import com.apucafeteria.models.Payment;
import com.apucafeteria.models.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManagerMainMenu extends javax.swing.JFrame {

    public String username;
    public String password;
    ManagerController managerController;
    
    public ManagerMainMenu(String user, String pass) {
        this.username = user;
        this.password = pass;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtMenuName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblMenuPrice = new javax.swing.JLabel();
        btnAddMenu = new javax.swing.JButton();
        txtMenuPrice = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShowMenu = new javax.swing.JTable();
        secondPanel = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblViewCustomer = new javax.swing.JTable();
        btnRemoveCustomer = new javax.swing.JButton();
        cmbCustomerList = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblViewManager = new javax.swing.JTable();
        txtManagerRole = new javax.swing.JComboBox<>();
        txtManagerName = new javax.swing.JTextField();
        txtManagerPassword = new javax.swing.JPasswordField();
        btnCreate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbProcessOrder = new javax.swing.JComboBox<>();
        btnAvailable = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblViewOrders = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnCheckMenu = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblViewMenu = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setForeground(new java.awt.Color(66, 66, 66));
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mainPanelComponentShown(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(66, 66, 66));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jLabel1.setText("Menu");

        lblMenuPrice.setText("Price");

        btnAddMenu.setText("Add");
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        tblShowMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblShowMenu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMenuName)
                    .addComponent(txtMenuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMenu)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMenuPrice)))
                    .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.addTab("Menu", jPanel1);

        secondPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                secondPanelComponentShown(evt);
            }
        });

        tblViewCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblViewCustomer);

        btnRemoveCustomer.setText("Remove");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(cmbCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        secondPanel.addTab("Customer", jPanel4);

        tblViewManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblViewManager);

        txtManagerRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManagerRoleActionPerformed(evt);
            }
        });

        txtManagerName.setToolTipText("");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Password");

        jLabel4.setText("Role");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtManagerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtManagerRole, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtManagerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtManagerRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        secondPanel.addTab("Manager", jPanel5);

        mainPanel.addTab("User Group", secondPanel);

        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        btnAvailable.setBackground(new java.awt.Color(30, 185, 128));
        btnAvailable.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailable.setText("Accept");
        btnAvailable.setAutoscrolls(true);
        btnAvailable.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAvailable.setMargin(null);
        btnAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailableActionPerformed(evt);
            }
        });

        btnDecline.setBackground(new java.awt.Color(255, 104, 89));
        btnDecline.setForeground(new java.awt.Color(255, 255, 255));
        btnDecline.setText("Decline");
        btnDecline.setToolTipText("");
        btnDecline.setMargin(null);
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        tblViewOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblViewOrders);

        jLabel5.setText("Incoming Orders");

        btnCheckMenu.setBackground(new java.awt.Color(255, 207, 68));
        btnCheckMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckMenu.setText("Check Menu");
        btnCheckMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckMenuActionPerformed(evt);
            }
        });

        tblViewMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblViewMenu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(btnAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cmbProcessOrder, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProcessOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCheckMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnDecline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        mainPanel.addTab("Orders", jPanel3);

        jMenu1.setText("Logout");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        LoadMenuTable();
    }//GEN-LAST:event_jPanel1ComponentShown

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        String name = txtMenuName.getText();
        String price = txtMenuPrice.getValue().toString();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in the Empty Field.");
        } else {
            try{
                managerController = new ManagerController(username, password);
                managerController.CreateMenuItems(name, price);
                JOptionPane.showMessageDialog(null, "Successfully Added to the Menu.");
                txtMenuName.setText("");
                lblMenuPrice.setText("0");
                LoadMenuTable();
            }catch (IOException ex) {
                Logger.getLogger(CustomerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void txtManagerRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManagerRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManagerRoleActionPerformed

    private void mainPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainPanelComponentShown
        
    }//GEN-LAST:event_mainPanelComponentShown

    private void secondPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_secondPanelComponentShown
        LoadCustomerTable("C");
        LoadManagerTable("A");
    }//GEN-LAST:event_secondPanelComponentShown

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        LoadOrdersTable();
    }//GEN-LAST:event_jPanel3ComponentShown

    private void btnCheckMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckMenuActionPerformed

        try {
            managerController = new ManagerController();
            managerController.checkOrderMenu(cmbProcessOrder.getSelectedItem().toString(), tblShowMenu);
        } catch (IOException ex) {
            Logger.getLogger(ManagerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCheckMenuActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        if(txtManagerName.getText().isEmpty() ||
            txtManagerPassword.getText().isEmpty() ){
               JOptionPane.showMessageDialog(null, "Please fill in the empty field.");
        }else {
            managerController = new ManagerController();
//            managerController.createManager()
        }
            
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailableActionPerformed
        try{
            managerController = new ManagerController();   
            managerController.updateOrderStatus(cmbProcessOrder.getSelectedItem().toString(), "Y");
            LoadOrdersTable();  
        }   catch(IOException ex){}
    }//GEN-LAST:event_btnAvailableActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        try{
            managerController = new ManagerController();    
            managerController.updateOrderStatus(cmbProcessOrder.getSelectedItem().toString(), "D");
            LoadOrdersTable();  
        }   catch(IOException ex){}
    }//GEN-LAST:event_btnDeclineActionPerformed
    
    public void LoadMenuTable(){
        try {
            managerController = new ManagerController();
            List<Menu> menus = managerController.findAllMenu();
            String[] header = new String[] {"Menu ID", "Name", "Price","Created Date"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            for(Menu menu: menus){
                model.addRow( new String[] { menu.getMenuID(), menu.getName(), menu.getPrice(), menu.getCreatedDate()});
            }   
            tblShowMenu.setModel(model);
        } catch (IOException ex) {
            Logger.getLogger(CustomerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void LoadCustomerTable(String role){
        try {
            cmbCustomerList.removeAllItems();
            managerController = new ManagerController();
            List<User> users = managerController.findAllCustomers(role);
            String[] header = new String[] {"UUID", "Username", "Status", "Last Active Date","Created Date"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            for(User user: users){
                model.addRow( new String[] { user.getUUID(), user.getUsername(), user.getStatus(), user.getLastUpdateDate(), user.getCreatedDate()});
                cmbCustomerList.addItem(user.getUsername());
            }
            tblViewCustomer.setModel(model);
        } catch (IOException ex) {
            Logger.getLogger(ManagerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void LoadManagerTable(String role){
        try {
            managerController = new ManagerController();
            List<User> users = managerController.findAllManager(role);
            String[] header = new String[] {"UUID", "Username", "Status", "Last Active Date","Created Date"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            for(User user: users){
                model.addRow( new String[] { user.getUUID(), user.getUsername(), user.getStatus(), user.getLastUpdateDate(), user.getCreatedDate()});
            }
            tblViewManager.setModel(model);
        } catch (IOException ex) {
            Logger.getLogger(ManagerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void LoadOrdersTable(){
        try{
            cmbProcessOrder.removeAllItems();
            managerController = new ManagerController();
            List<Order> orders = managerController.findAllOrders();
            String[] header = new String[] {"OrderID", "Username", "Status", "Created Date"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            for(Order order: orders){
                model.addRow( new String[] { order.getOrderID(), order.getUser().getUsername(), order.getStatus(), order.getCreatedDate()});
                if(order.getStatus().equals("N")){
                    cmbProcessOrder.addItem(order.getOrderID());
                }
            }
            tblViewOrders.setModel(model);
        } catch (IOException ex) {
            Logger.getLogger(ManagerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JButton btnAvailable;
    private javax.swing.JButton btnCheckMenu;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnRemoveCustomer;
    private javax.swing.JComboBox<String> cmbCustomerList;
    private javax.swing.JComboBox<String> cmbProcessOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMenuPrice;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JTabbedPane secondPanel;
    private javax.swing.JTable tblShowMenu;
    private javax.swing.JTable tblViewCustomer;
    private javax.swing.JTable tblViewManager;
    private javax.swing.JTable tblViewMenu;
    private javax.swing.JTable tblViewOrders;
    private javax.swing.JTextField txtManagerName;
    private javax.swing.JPasswordField txtManagerPassword;
    private javax.swing.JComboBox<String> txtManagerRole;
    private javax.swing.JTextField txtMenuName;
    private javax.swing.JSpinner txtMenuPrice;
    // End of variables declaration//GEN-END:variables
}
