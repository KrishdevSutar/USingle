package com.usingle.models;

import java.util.HashMap;
import java.util.ArrayList;

public class DataBase {
    static HashMap<Integer, Account> dataBase;
    static Integer whichOneIsUser;

    static Biography fred = new Biography("male", "Single", "Casual", "Ryerson University", 18, "Men");
    static Biography sam = new Biography("female", "Single", "Serious", "University of Toronto", 19, "Men");
    static Biography tim = new Biography("male", "Single", "Serious", "University of Toronto Mississauga", 22, "Women");
    static Biography harry = new Biography("male", "Single", "Casual", "MacMaster University", 20, "Women");
    static Biography ryan = new Biography("female", "Single", "Serious", "Ryerson University", 21, "Women");
    public static ArrayList<Biography> array = new ArrayList<Biography>();


    static {
        array.add(fred);
        array.add(sam);
        array.add(tim);
        array.add(harry);
        array.add(ryan);

        dataBase = new HashMap<Integer, Account>();
    }

    public static Biography getBiography(int i) {

        return array.get(i);
    }

    public static HashMap<Integer, Account> getDataBase() {
        return dataBase;
    }

    //Standard addAccount method
    public static int addAccount(Account account) {
        int userID = (int) (Math.random() * 10000) + 10000;
        dataBase.put(userID, account);
        return userID;
    }

    public static Integer getWhichOneIsUser() {
        return whichOneIsUser;
    }

    public static void setWhichOneIsUser(Integer whichOneIsUser) {
        DataBase.whichOneIsUser = whichOneIsUser;
    }

    public static Account getUser() {
        return dataBase.get(whichOneIsUser);
    }

    //demo addAccount method
    public static void addAccount() {
        dataBase.put(00001, new Account("Robert Robot","albert", "tallsnakes", "albert@ryerson.ca", "Computer Science", 2000, 12, 31, array.get(0)));
        dataBase.put(00002, new Account("Parth Patel", "partholemew", "brownhammer", "parth.mew@ryerson.ca", "Physics", 1999, 3, 29, array.get(1)));
        dataBase.put(00003, new Account("Le Ka Yee", "adelle", "gasStove", "a.ky@utoronto.ca", "Math", 1998, 4, 5, array.get(2)));

        dataBase.put(00004, new Account("Andy Tang", "jamesee", "dukkeai", "james.kt@utoronto.ca", "Criminology", 2000, 1, 18, array.get(3)));
        dataBase.put(00005, new Account("Eyho Cao","Ayhoe", "natTwenty", "a.cao@mcmaster.ca", "Data Science", 1997, 5, 13, array.get(4)));
    }

    /**
     * gets account from user id
     *
     * @param userID id of user
     * @return account attatched to user
     */
    public static Account getAccount(int userID) {
        return dataBase.get(userID);
    }
//filters

    public static ArrayList<Account> filterByUniversity(String university) {
        ArrayList<Account> filteredAccounts = new ArrayList<Account>();
        for (int key : dataBase.keySet()) {
            if (dataBase.get(key).equals(university)) {
                filteredAccounts.add(dataBase.get(key));
            }
        }
        return filteredAccounts;
    }
}
   