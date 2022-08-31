package com.apucafeteria.models;

public class Menu {
    public String MenuID;
    public String Name;
    public String Price;
    public String CreatedDate;

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public String toString() {
        return MenuID + "," + Name + "," + Price + "," + CreatedDate;
    }
}
