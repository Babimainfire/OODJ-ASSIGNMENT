package com.apucafeteria.models;

public class Order {
    public String OrderID;
    public User User;
    public Menu Menu;
    public String Status;
    public String ReservedDate;
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

    public com.apucafeteria.models.Menu getMenu() {
        return Menu;
    }

    public void setMenu(com.apucafeteria.models.Menu menu) {
        Menu = menu;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getReservedDate() {
        return ReservedDate;
    }

    public void setReservedDate(String reservedDate) {
        ReservedDate = reservedDate;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public String toString() {
        return OrderID + "," + User + "," + Menu + "," + Status + "," + ReservedDate + "," + CreatedDate;
    }
}
