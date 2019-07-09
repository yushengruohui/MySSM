package com.yusheng.pojo;

public class User {
    private int uId;
    private String uName;
    private String uPassword;
    private String UFavorite;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUFavorite() {
        return UFavorite;
    }

    public void setUFavorite(String UFavorite) {
        this.UFavorite = UFavorite;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", UFavorite='" + UFavorite + '\'' +
                '}';
    }
}
