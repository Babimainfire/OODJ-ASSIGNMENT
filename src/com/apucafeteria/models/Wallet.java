package com.apucafeteria.models;

public class Wallet {

    public String WalletID;
    public Object User;
    public String Total;

    public String getWalletID() {
        return WalletID;
    }

    public void setWalletID(String walletID) {
        WalletID = walletID;
    }

    public Object getUser() {
        return User;
    }

    public void setUser(Object User) {
        this.User = User;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    @Override
    public String toString() {
        return WalletID + "," + User + "," + Total;
    }
}
