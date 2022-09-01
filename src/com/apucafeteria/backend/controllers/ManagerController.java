package com.apucafeteria.backend.controllers;

import com.apucafeteria.backend.utils.ApplicationPath;
import com.apucafeteria.backend.utils.FileUtils;
import com.apucafeteria.models.Menu;
import com.apucafeteria.models.Order;
import com.apucafeteria.models.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerController {
    
    public String username;
    public String password;
    Date date = new Date();
    FileUtils utils = new FileUtils();
    BufferedReader reader;
    BufferedWriter writer;
    UUID uuid = UUID.randomUUID();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public ManagerController(){}
    
    public ManagerController(String user, String pass){
        this.username = user;
        this.password = pass;
    }
    
    public boolean GetUserAuthorization()throws IOException {
        try{
            String line;
            reader = utils.read(ApplicationPath.Origin.userTable);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] param = line.split(",");
                if(username.equals(param[1]) && password.equals(param[2])){
                    return true;
                }
            }
            utils.close();
        }finally {
            if(reader == null){
                reader.close();
            }
        }
        return false;
    }
    
    public void CreateMenuItems(String menu, String price) throws IOException{
        String data = uuid + "," + menu + "," + price + "," + formatter.format(date);
        utils.write(ApplicationPath.Origin.menuTable, data);
    }
  
    public List<Menu> findAllMenu() throws IOException {
        try{
            String line;
            List<Menu> menus = new LinkedList<>();
            reader = utils.read(ApplicationPath.Origin.menuTable);
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                Menu menu = new Menu();
                menu.setMenuID(data[0]);
                menu.setName(data[1]);
                menu.setPrice(data[2]);
                menu.setCreatedDate(data[3]);
                menus.add(menu);
            }
            utils.close();
        return menus;
        } finally {
            if(reader == null){
                reader.close();
            }
        }
    }
    
    public List<User> findAllCustomers(String role) throws IOException {
        try{
            String line;
            List<User> users = new LinkedList<>();
            reader = utils.read(ApplicationPath.Origin.userTable);
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\,");
                if(data[3].equals(role)){
                    User user = new User();
                    user.setUUID(data[0]);
                    user.setUsername(data[1]);
                    user.setPassword(data[2]);
                    if (data[4].equals("P")){
                        user.setStatus("Active");
                    } else if (data[4].equals("A")){
                        user.setStatus("Blocked");
                    }
                    user.setLastUpdateDate(data[5]);
                    user.setCreatedDate(data[6]);
                    users.add(user);
                    System.out.println(user);
                }
            }
            utils.close();
            return users;
            } finally {
                if(reader == null){
                    reader.close();
                }
            }
        
    }
    
    public List<User> findAllManager(String role) throws IOException{
        try{
            String line;
            List<User> users = new LinkedList<>();
            reader = utils.read(ApplicationPath.Origin.userTable);
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\,");
                if(data[3].equals(role)){
                    User user = new User();
                    user.setUUID(data[0]);
                    user.setUsername(data[1]);
                    user.setPassword(data[2]);
                    if (data[4].equals("P")){
                        user.setStatus("Active");
                    } else if (data[4].equals("A")){
                        user.setStatus("Blocked");
                    }
                    user.setLastUpdateDate(data[5]);
                    user.setCreatedDate(data[6]);
                    users.add(user);
                }
            }
            utils.close();
            return users;
        } finally {
            if(reader == null){
                reader.close();
            }
        }
    }
    
    public List<Order> findAllOrders() throws IOException{
        try{
            String line;
            List<Order> orders = new LinkedList<>();
            File file = new File(ApplicationPath.Origin.orderTable);
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\[");
                String[] data2 = data[0].split(",");
                String[] data3 = data[1].split("\\],");
                String[] data4 = data3[1].split("\\,");
                User user = new User();
                Order order = new Order();
                user.setUUID(data2[1]);
                user.setUsername(data2[2]);
                user.setPassword(data2[3]);
                user.setRole(data2[4]);
                user.setStatus(data2[5]);
                user.setCreatedDate(data2[6]);
                user.setLastUpdateDate(data2[7]);
                order.setOrderID(data2[0]);
                order.setUser(user);
                order.setStatus(data4[0]);
                order.setCreatedDate(data4[1]);
                orders.add(order);
            }
            fileStream.close();
            input.close();
            reader.close();
            return orders;
        } finally {
            
        }
    }
    
    public Menu GetUserDetailByID(String id) throws IOException {
        try{
            String line;
            reader = utils.read(ApplicationPath.Origin.menuTable);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(id.equals(data[0])){
                    Menu menu = new Menu();
                    menu.setMenuID(id);
                    menu.setName(data[1]);
                    menu.setPrice(data[2]);
                    return menu;
                }
            }
            utils.close();
            return null;
        } catch (IOException ex) { System.out.println(ex.getMessage()); }  
        finally {
            if(reader == null){
                reader.close();
            }
        }
        return null;
    }
    
    public void updateOrderStatus(String selectedId, String status) throws IOException {
        String line;
        Integer count = 0;
        File file = new File(ApplicationPath.Origin.orderTable);
        File temp = new File(ApplicationPath.Temp.orderTable);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        BufferedWriter writer = new BufferedWriter(new FileWriter(temp, true));
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String[] data2 = line.split("\\[");
            String[] data3 = data2[1].split("\\]");
            String[] data4 = data3[1].split(",");
            if(selectedId.equals(data[0])){
                if(count != 0){ writer.append("\r\n"); } 
                    String c = data2[0] + "[" + data3[0] + "]," + status + "," + data4[2];
                    writer.append(c);
            }
            else if(!selectedId.equals(data[0])) {
                if(count != 0){ writer.append("\r\n"); }
                writer.append(line);
            }
            count++;
        }
        
        writer.close();
        reader.close();
        input.close();
        fileStream.close();
        
        if(file.exists() == true){
        boolean isDelete = file.delete();
        System.out.println("updateOrderStatus: " + isDelete);
        if(isDelete == true){
            temp.renameTo(file);
        }
      }
    }
    
    public void checkOrderMenu(String uid, JTable tblMenu)throws IOException{
         try{
            String line;
//            List<String> menus = new LinkedList<>();
//            reader = utils.read(ApplicationPath.Origin.orderTable);
            String[] header = new String[] {"Menu", "Quantity"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\[");
                String[] data2 = data[0].split(",");
                String[] data3 = data[1].split("\\]");
                
                if(uid.equals(data2[0])){
                    
//                    Menu menu = GetUserDetailByID(data3[0]);
                            
                    if(!data3[0].contains(","))
                    {
//                        menus.add(data3[0]);
                    } else {
//                        menus.add("[" + data3[0] + "]");
                    }
                }
            }
            tblMenu.setModel(model);
            
//            if(reader == null || reader.equals(""))
//            {
//                reader.close(); 
//            }
//            return orders;
        } finally {
            if(reader == null){
                reader.close();
            }
        }
    }
    
//    public void create                                                                                                                                                                                                                                                                                                                                                                                                         Manager(String txtManagerName, String txtManagerPassword){
//                if(IsUsernameValid(username)) {
//            //userid,username,password,role,status,lastUpdateDate,createdDate
//            String user = uuid + "," + username + "," + password + ",C,P," + formatter.format(date) + "," + formatter.format(date);
//            util.write(ApplicationPath.Origin.userTable, user);
//            return 0;
//        } else if (!IsUsernameValid(username)){
//            return 1;
//        } else {
//            return 2;
//        }
//    }
//   
//    public boolean IsUsernameValid(String username) throws IOException {
//        String line;
//        reader = util.read(ApplicationPath.Origin.userTable);
//        while ((line = reader.readLine()) != null) {
//            String[] param = line.split(",");
//            if(username.equals(param[1])){
//                return false;
//            }
//        }
//        if(reader == null){
//            reader.close();
//        }
//        return true;
//    }
}
