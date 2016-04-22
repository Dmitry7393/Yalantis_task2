package com.yalantis_task2;

import android.os.Parcel;
import android.os.Parcelable;


public class ContactInfo  implements Parcelable {
    private int imageEnterprise;
    private String nameEnterprise;
    private String titleStreet;
    private int imageLike;
    private String amountLikes;
    private String titleDate;
    private String amountDays;

    public void setImageEnterprise(int i){
        imageEnterprise = i;
    }
    public void setNameEnterprise(String s){
        nameEnterprise = s;
    }
    public  void setTitleStreet(String s){
        titleStreet = s;
    }
    public void setImageLike(int r) {
        imageLike = r;
    }
    public void setAmountLikes(String s){
        amountLikes = s;
    }
    public void setTitleDate(String s){
        titleDate = s;
    }
    public void setAmountDays(String s){
        amountDays = s;
    }
    ////
    public int getImageEnterprise(){
       return imageEnterprise;
    }
    public String getNameEnterprise(){
        return nameEnterprise;
    }
    public  String getTitleStreet(){
        return   titleStreet ;
    }
    public int getImageLike() {
        return imageLike ;
    }
    public String getAmountLikes(){
        return amountLikes;
    }
    public String getTitleDate(){
        return  titleDate ;
    }
    public String getAmountDays(){
        return  amountDays;
    }
    public ContactInfo() {

    }
    private ContactInfo(Parcel in) {
        imageEnterprise = in.readInt();
        nameEnterprise = in.readString();
        titleStreet = in.readString();
        imageLike = in.readInt();
        amountLikes = in.readString();
        titleDate = in.readString();
        amountDays = in.readString();
    }

   public static final Parcelable.Creator<ContactInfo> CREATOR
            = new Parcelable.Creator<ContactInfo>() {
        public ContactInfo createFromParcel(Parcel in) {
            return new ContactInfo(in);
        }

        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 1;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageEnterprise);
        dest.writeString(nameEnterprise);
        dest.writeString(titleStreet);
        dest.writeInt(imageLike);
        dest.writeString(amountLikes);
        dest.writeString(titleDate);
        dest.writeString(amountDays);
    }
}