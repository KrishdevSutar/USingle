package com.usingle.models;

import java.util.ArrayList;

public class Biography {

    String gender;
    String stat;
    String lok;
    ArrayList<String> r;
    String sp;
    String uno;
    int age;
    ArrayList<String> hob = new ArrayList();


    public enum Status {
        SINGLE, TAKEN
    }
    public enum Looks {
        CASUAL, SERIOUS, OPEN, FBW, SUGAR
    }
    public enum Race {
        ABORIGINAL, ARABIAN, BLACK, CHINESE, FILIPINO, JAPANESE, KOREAN, LATINO,SASIAN,SEASIAN, WHITE, OTHER
    }
    public enum Uni {
        RYERSON, UOFT, UTSC, UTM, MCMASTER, WATERLOO
    }
    public enum SexPre{
        MALE, FEMALE, OTHER
    }

    public Biography() {
        this.gender = "";
        this.stat = "";
        this.lok = "";
        this.uno = "";
        this.age = 69;
        this.sp = "";
    }

    public Biography(String gen, String a, String b, String d, int e, String sexp) {
        this.gender = gen;
        this.stat = a;
        this.lok = b;
        this.uno = d;
        this.age = e;
        this.sp = sexp;
    }
    //setters
    public  void  changeGender(String gender){this.gender=gender;}
    public void changeStatus(String newSt){
        this.stat=newSt;
    }

    public void changeLook(String newLo){
        this.lok=newLo;
    }

    public void addRacialPreference(String newR){
        r.add(newR);
    }

    public void changeUni(String newUi){
        this.uno=newUi;
    }

    public void changeSexpre(String newSp){
        this.sp=newSp;
    }

    public void changeAge(int newAg){
        this.age=newAg;
    }

    public void addHobby(String newHob){
        hob.add(newHob);
    }

    //getters
    public String getGender(){return gender;}

    public String getStatus() {
        return stat;
    }

    public String getLooks()
    {
        return lok;
    }

    public String getUni()
    {
        return uno;
    }

    public int getAge()
    {
        return age;
    }

    public ArrayList<String> getRace()
    {
        return r;
    }

    public String getSexpre() {
        return this.sp;
    }

    public ArrayList<String> getHob(){
        return this.hob;
    }

    public String toString()
    {
        return "Status: " + stat + " Looking for: " + lok + " Ethnicity: " + r + " Sexual Preference: " + sp + "University: " + uno + " Age" + age + " Hobbies" + hob;
    }
}