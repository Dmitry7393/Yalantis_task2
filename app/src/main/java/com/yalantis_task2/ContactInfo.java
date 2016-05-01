package com.yalantis_task2;

public class ContactInfo {
    private int imageEnterprise;
    private String nameEnterprise;
    private String titleStreet;
    private int imageLike;
    private String amountLikes;
    private String titleDate;
    private String amountDays;

    public void setImageEnterprise(int i) {
        imageEnterprise = i;
    } //[Comment] s,i,r wrong argument names

    public void setNameEnterprise(String s) {
        nameEnterprise = s;
    }

    public void setTitleStreet(String s) {
        titleStreet = s;
    }

    public void setImageLike(int r) {
        imageLike = r;
    }

    public void setAmountLikes(String s) {
        amountLikes = s;
    }

    public void setTitleDate(String s) {
        titleDate = s;
    }

    public void setAmountDays(String s) {
        amountDays = s;
    }

    public int getImageEnterprise() {
        return imageEnterprise;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public String getTitleStreet() {
        return titleStreet;
    }

    public int getImageLike() {
        return imageLike;
    }

    public String getAmountLikes() {
        return amountLikes;
    }

    public String getTitleDate() {
        return titleDate;
    }

    public String getAmountDays() {
        return amountDays;
    }

    public ContactInfo() { //[Comment] Unnecessary. Objects already have default constructor

    }
}