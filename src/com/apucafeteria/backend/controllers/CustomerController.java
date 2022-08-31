package com.apucafeteria.backend.controllers;

import com.apucafeteria.backend.utils.ApplicationPath;
import com.apucafeteria.backend.utils.FileUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class CustomerController {

    BufferedReader reader;
    BufferedWriter writer;
    FileUtils util = new FileUtils();
    UUID uuid = UUID.randomUUID();
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    //--- Register ---
    public int CreatePendingCustomer(String username, String password) throws IOException {
        if(IsUsernameValid(username)) {
            //userid,username,password,role,status,lastUpdateDate,createdDate
            String user = uuid + "," + username + "," + password + ",C,P," + formatter.format(date) + "," + formatter.format(date);
            util.write(ApplicationPath.Origin.userTable, user);
            return 0;
        } else if (!IsUsernameValid(username)){
            return 1;
        } else {
            return 2;
        }
    }
    public boolean IsUsernameValid(String username) throws IOException {
        String line;
        reader = util.read(ApplicationPath.Origin.userTable);
        while ((line = reader.readLine()) != null) {
            String[] param = line.split(",");
            if(username.equals(param[1])){
                return false;
            }
        }
        reader.close();
        return true;
    }
    // --- Register ---
    
    // --- Login ---
    public String[] GetValidUserCredential(String username, String password)throws IOException {
        String line;
        reader = util.read(ApplicationPath.Origin.userTable);
        while ((line = reader.readLine()) != null) {
            String[] param = line.split(",");
            if(username.equals(param[1]) && password.equals(param[2])){
                return param;
            }
        }
        reader.close();
        return null;
    }
    public void updateUserActiveDateTime(String originFile, String tempFile, String username) throws IOException {
        String line;
        int lineCount = 0;
        File file = new File(originFile);
        File temp = new File(tempFile);
        writer = new BufferedWriter(new FileWriter(temp, true));
        reader = util.read(originFile);
        while (( line = reader.readLine()) != null) {
            String[] data = line.split("\\,");
            lineCount++;
            if(!data[1].equals(username)) {
                 if(lineCount != 0){ writer.append("\r\n"); }
                 writer.append(line);
            }
            if(data[1].equals(username)){
                String updatedLine =  data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + formatter.format(date) + "," + data[6];
                writer.append(updatedLine);
            }
        }
        
        if(reader == null){
            reader.close();
        }
        reader.close();
        writer.close();
       
        if(file.exists() == true)
        {
            if(reader == null) {reader.close();}
            boolean isDelete = file.delete();
            System.out.println(isDelete);
            if(isDelete == true){
                temp.renameTo(file);
            }
        }
    }
    public String[] GetUserDetails(String username)throws IOException {
        String line;
        reader = util.read(ApplicationPath.Origin.userTable);
        while ((line = reader.readLine()) != null) {
            String[] param = line.split(",");
            if(username.equals(param[1])){
                return param;
            }
        }
        reader.close();
        return null;
    }
    // --- Login ---
    
    // --- Main Menu ---
    
    public DefaultTableModel GetAllMenuDetails(JComboBox cmbMenu) throws IOException {
        String line;
        Integer count = 1;
        reader = util.read(ApplicationPath.Origin.menuTable);
        String[] header = new String[] {"No", "Menu ID", "Menu", "Price", "Created Date" };
        DefaultTableModel model = new DefaultTableModel(header, 0);
        while ((line = reader.readLine()) != null)
        {
            String[] data = line.split("\\,");
            model.addRow(new String[] { count.toString() ,data[0], data[1], "RM " + data[2], data[3]});
            cmbMenu.addItem(data[0] + " - " + data[1] + " - " + "RM " + data[2]);
            count++;
        }
        reader.close();
        return model;
    }
    
}
