package com.apucafeteria.models;

public class Wallet {

    public String WalletID;
    public String UserID;
    public String Total;

    public String getWalletID() {
        return WalletID;
    }

    public void setWalletID(String walletID) {
        WalletID = walletID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "{" + WalletID + "," + UserID + "," + Total + "}";
    }
}
