package com.usingle.models;

import java.util.ArrayList;

public class Finder extends DataBase {
    Biography t;
    Biography arr[] = new Biography[5];
    public static ArrayList<Biography> arra = new ArrayList<Biography>();

    public Finder(Biography temp, ArrayList<Biography> a) {
        this.t = temp;
        for(int x = 0; x < a.size(); x++){
            arra.set(x,a.get(x));
        }
    }

    public void search(Biography s){
        int k = 0;
        while(k < arra.size()) {
            if (s.stat == arra.get(k).stat) {
                //Each of these if statements will determine which profiles are visibl or not to the user based on matches in bio
            }
            if (s.lok == arra.get(k).lok) {

            }
            if (s.r == arra.get(k).r) {

            }
            if (s.uno == arra.get(k).uno) {

            }
            if (s.age == arra.get(k).age) {

            }
            if (s.sp == arra.get(k).sp) {

            }
            if (s.hob == arra.get(k).hob) {

            }
            k++;
        }
    }
}