package com.apucafeteria.backend.controllers;

import com.apucafeteria.backend.utils.ApplicationPath;
import com.apucafeteria.backend.utils.FileUtils;
import com.apucafeteria.models.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ManagerController {
    
    public String username;
    public String password;
    
    FileUtils utils = new FileUtils();
    BufferedReader reader;
    BufferedWriter writer;
    UUID uuid = UUID.randomUUID();
    Date date = new Date();
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
        System.out.println(menus);
        reader.close();
        return menus;
    }
}
