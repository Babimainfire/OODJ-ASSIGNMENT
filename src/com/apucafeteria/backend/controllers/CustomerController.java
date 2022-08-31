package com.apucafeteria.backend.controllers;

import com.apucafeteria.backend.utils.ApplicationPath;
import com.apucafeteria.backend.utils.FileUtils;
import com.apucafeteria.models.Cart;
import com.apucafeteria.models.Menu;
import com.apucafeteria.models.Order;
import com.apucafeteria.models.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        if(reader == null){
            reader.close();
        }
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
        if(reader == null){
            reader.close();
        }
        return null;
    }
    public void updateUserActiveDateTime(String originFile, String tempFile, String username) throws IOException {
        String line;
        int lineCount = 0;
        File file = new File(originFile);
        File temp = new File(tempFile);
        writer = new BufferedWriter(new FileWriter(temp, true));
        var fileStream = new FileInputStream(ApplicationPath.Origin.userTable);
        InputStreamReader input = new InputStreamReader(fileStream);
        var reader = new BufferedReader(input);
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
        
        reader.close();
        input.close();
        fileStream.close();
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
        var fileStream = new FileInputStream(ApplicationPath.Origin.userTable);
        InputStreamReader input = new InputStreamReader(fileStream);
        var reader = new BufferedReader(input);
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if(username.equals(data[1])){
                return data;
            }
        }
        reader.close();
        input.close();
        fileStream.close();
        return null;
    }
    // --- Login ---
    
    // --- Main Menu ---
    
    public DefaultTableModel GetAllMenuDisplay(JComboBox cmbMenu) throws IOException {
        String line;
        Integer count = 1;
        var fileStream = new FileInputStream(ApplicationPath.Origin.menuTable);
        InputStreamReader input = new InputStreamReader(fileStream);
        var reader = new BufferedReader(input);
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
        input.close();
        fileStream.close();
        return model;
    }
    
    public void AddNewItemToCart(String selected)throws IOException {
        String line;
        Integer count = 0;
        boolean flag = true;
        File file = new File(ApplicationPath.Origin.cartTable);
        File temp = new File(ApplicationPath.Temp.cartTable);
        try{
            String[] data = selected.split(" - ");
            var fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            
            var writer = new BufferedWriter(new FileWriter(file, true));
            var writerTermp = new BufferedWriter(new FileWriter(temp, false));

            //if file line is bigger than 0
            if(util.GetLineCount(ApplicationPath.Origin.cartTable) == 0){
                Cart cart = new Cart();
                Menu menu = GetMenuDetailByID(data[0]);
                cart.setMenu(menu);
                cart.setQuantity("1");
                JOptionPane.showMessageDialog(null, "You have Successfully Added in Cart.");
                if(util.GetLineCount(ApplicationPath.Origin.cartTable) != 0){ writer.append("\r\n"); }
                writer.append(cart.toString());
                writer.close();
            } else {
                flag = false; // to avoid double .close()
                while((line = reader.readLine()) != null){
                    String[] a = line.split(",");
                    Cart cart = new Cart();
                    Menu menu = GetMenuDetailByID(data[0]);
                    cart.setMenu(menu);
                    if(data[0].equals(a[0]))
                    {
                        if (count >= 1) { writer.append("\r\n"); }
                        Integer total = Integer.parseInt(a[4]) + 1;
                        cart.setQuantity(total.toString());
                    } else {
                        writer.append("\r\n");
                        cart.setQuantity("1");
                    }
                    if(util.GetLineCount(ApplicationPath.Temp.cartTable) != 0){ writerTermp.append("\r\n"); }
                    writerTermp.append(cart.toString());
                    count++;
                }
                
                JOptionPane.showMessageDialog(null, "You have Successfully Added in Cart.");
                reader.close();
                input.close(); 
                fileStream.close();  
                writerTermp.close();
                
                if(file.exists() == true){
                  boolean isDelete = file.delete();
                  System.out.println("AddNewItemToCart: " + isDelete);
                  if(isDelete == true){
                      temp.renameTo(file);
                  }
                }
            }
            
            if(flag){
                reader.close();
                input.close(); 
                fileStream.close();  
            }
        } catch (FileNotFoundException ex) {  System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); }
        catch (NullPointerException ex) { System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); }
        catch (IOException ex) { System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); } 
            
    }
    
    public Menu GetMenuDetailByID(String id) throws IOException {
        try{
            String line;
            File file = new File(ApplicationPath.Origin.menuTable);
            var fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(id.equals(data[0])){
                    Menu menu = new Menu();
                    menu.setMenuID(id);
                    menu.setName(data[1]);
                    menu.setPrice(data[2]);
                    menu.setCreatedDate(data[3]); 
                    return menu;
                }
            }
            reader.close();
            input.close();
            fileStream.close();
            return null;
        } catch (IOException ex) { System.out.println(ex.getMessage()); }  
        finally {
            
        }
        return null;
    }
    
    public List<Cart> GetAllCartDetails() throws IOException {
        try{
            String line;
            List<Cart> carts = new LinkedList();
            File file = new File(ApplicationPath.Origin.cartTable);
            var fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Cart cart = new Cart();
                Menu menu = GetMenuDetailByID(data[0]);
                cart.setMenu(menu);
                cart.setQuantity(data[4]);
                carts.add(cart);
            }
            
            reader.close();
            input.close();
            fileStream.close();
            
            return carts;
        } catch (IOException ex) { System.out.println(ex.getMessage()); }  
        finally {
           if(reader == null || reader.equals("")){
                    reader.close();
                }
        }
        return null;
    }
    
    public DefaultTableModel GetAllCartDisplay(JComboBox cmbCart) throws IOException {
        String line;
        Integer count = 1;  
        cmbCart.removeAllItems();
        String[] header = new String[] {"No", "Menu ID", "Menu", "Price", "Quantity" };
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try{
            File file = new File(ApplicationPath.Origin.cartTable);
            var fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split("\\,");
                model.addRow(new String[] {count.toString() ,data[0], data[1], "RM" + data[2], data[4]});
                cmbCart.addItem(data[0] + " - " + data[1] + " - " + data[2]);
                count++;
            }
            
            reader.close();
            input.close();
            fileStream.close();
            
            return model;
        } catch (FileNotFoundException ex) {  System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); }
        catch (NullPointerException ex) { System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); }
        catch (IOException ex) { System.out.println(CustomerController.class.getName() + " : " + ex.getMessage()); } 
        return model;
    }
    
    public User GetUserDetailByID (String id) throws IOException {
        try{
            String line;
            var fileStream = new FileInputStream(ApplicationPath.Origin.userTable);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(id.equals(data[0])){
                    User user = new User();
                    user.setUUID(id);
                    user.setUsername(data[1]);
                    user.setPassword(data[2]);
                    user.setRole(data[3]);
                    user.setStatus(data[4]);
                    user.setLastUpdateDate(data[5]);
                    user.setCreatedDate(data[6]);
                    return user;
                }
            }
            if(reader == null || reader.equals("")){
                    reader.close();
                }
            return null;
        } catch (IOException ex) { System.out.println(ex.getMessage()); }  
        finally {
            if(reader == null || reader.equals("")){
                    reader.close();
                }
        }
        return null;
    }
    
    public User GetUserDetailByUsername(String username) throws IOException {
        try{
            String line;
            reader = util.read(ApplicationPath.Origin.userTable);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(username.equals(data[1])){
                    User user = new User();
                    user.setUUID(data[0]);
                    user.setUsername(data[1]);
                    user.setPassword(data[2]);
                    user.setRole(data[3]);
                    user.setStatus(data[4]);
                    user.setLastUpdateDate(data[5]);
                    user.setCreatedDate(data[6]);
                    return user;
                }
            }
            if(reader == null || reader.equals("")){
                    reader.close();
                }
            return null;
        } catch (IOException ex) { System.out.println(ex.getMessage()); }  
        finally {
            if(reader == null || reader.equals("")){
                    reader.close();
                }
        }
        return null;
    }
    
    public void CreateOrder(String userId) throws IOException {
        String line;
        List<String> menuList = new LinkedList();
        User user = GetUserDetailByUsername(userId);
        Order order = new Order();
        order.setOrderID(uuid.toString());
        order.setUser(user);
        File file = new File(ApplicationPath.Origin.cartTable);
        var fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        var reader = new BufferedReader(input);
        while ((line = reader.readLine()) != null){
            String[] data = line.split("\\,");
            menuList.add(data[0] + "|" + data[4]);
        }
        
        reader.close();
        input.close();
        fileStream.close();
       
        order.setMenu(menuList.toString());
        order.setStatus("N");
        order.setCreatedDate(formatter.format(date));
        util.write(ApplicationPath.Origin.orderTable, order.toString());
        boolean is_delete = file.delete();
        System.out.print(is_delete);
        if(util.CheckFileExist(ApplicationPath.Origin.cartTable) == false){
            util.write(ApplicationPath.Origin.cartTable, "");
        }
    }
    
    public List<Order> findAllOrders() throws IOException{
        return null;
    }
}
