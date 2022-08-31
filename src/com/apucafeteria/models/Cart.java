package com.apucafeteria.models;

public class Cart {

    public Menu Menu;
    public String Quantity;

    public Menu getMenu() {
        return Menu;
    }

    public void setMenu(Menu Menu) {
        this.Menu = Menu;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return Menu + "," + Quantity;
    }

    
}
