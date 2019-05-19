package com.usingle.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account {
    /**
     * instance variables
     */
    private String userName;
    private String realName;
    private String password;
    private String email;
    private String major;
    private Calendar birthDate;
    private Biography biography;
    private int minAge;
    private int maxAge;
    private int avatarID;

    public Account() {
        biography = new Biography();
        this.userName = "";
        this.realName = "";
        this.password = "";
        this.email = "";
        this.major = "";
        GregorianCalendar date = new GregorianCalendar(0, 0, 0);
        birthDate = date;
    }

    /**
     * constructor variable
     *
     * @param userName   user's username
     * @param password   user's password
     * @param email      user's email
     * @param major      user's major
     * @param year       user's birth year
     * @param month      user's birth month
     * @param day        user's birth day
     */
    public Account(String userName, String realName, String password, String email, String major, int year, int month, int day, Biography bio) {
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.email = email;
        this.major = major;
        GregorianCalendar date = new GregorianCalendar(year, month, day);
        birthDate = date;
        biography = bio;
    }

    // getters
    public String getUserName() {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getRealName() {
        return realName;
    }

    public int getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(int avatarID) {
        this.avatarID = avatarID;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthDate() {
        SimpleDateFormat displayDate = new SimpleDateFormat("EEE, MMM dd, yyyy");
        return displayDate.format(birthDate.getTime());
    }

    public Biography getBiography(){return biography;}

    //setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setBirthDate(int year, int month, int day) {
        GregorianCalendar date = new GregorianCalendar(year, month, day);
        birthDate = date;

    }

    public String toStringShort()
    {
        return "User name: " + userName + " Age: " + biography.getAge() + " Ethnicity: " + biography.getRace() + " University: " + biography.getUni();
    }

    public String toStringLong(){
        return "User name: " + userName + " " + biography.toString();
    }

}