package com.yalantis_task2.data;

public class ContactInfo {
    private int imageEnterprise;
    private String nameEnterprise;
    private String titleStreet;
    private int imageLike;
    private String amountLikes;
    private String titleDate;
    private String amountDays;

    public void setImageEnterprise(int idImageEnterprise) {
        imageEnterprise = idImageEnterprise;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public void setTitleStreet(String titleStreet) {
        this.titleStreet = titleStreet;
    }

    public void setImageLike(int idImageLike) {
        imageLike = idImageLike;
    }

    public void setAmountLikes(String amountLikes) {
        this.amountLikes = amountLikes;
    }

    public void setTitleDate(String titleDate) {
        this.titleDate = titleDate;
    }

    public void setAmountDays(String amountDays) {
        this.amountDays = amountDays;
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
}