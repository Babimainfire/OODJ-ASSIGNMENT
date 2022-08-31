package com.apucafeteria.models;

public class Order {
    public String OrderID;
    public User User;
    public String Menu;
    public String Status;
    public String CreatedDate;

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public com.apucafeteria.models.User getUser() {
        return User;
    }

    public void setUser(com.apucafeteria.models.User user) {
        User = user;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String Menu) {
        this.Menu = Menu;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public String toString() {
        return OrderID + "," + User + "," + Menu + "," + Status + "," + CreatedDate;
    }
}
