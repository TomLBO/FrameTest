package com.example.retrofitdemo.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bob
 * on 17.6.12.
 */

public class Login {

    @SerializedName("LoginId")
    private String account;

    @SerializedName("Password")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
