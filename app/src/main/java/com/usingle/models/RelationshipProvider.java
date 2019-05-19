package com.usingle.models;

import java.util.ArrayList;
import java.util.HashMap;

public class RelationshipProvider
{
    static DataBase dataBase;
    static HashMap<Account, Relationships> relationshipsHashMap;
    static ArrayList<Account> accounts;

    static {
        dataBase = new DataBase();
        relationshipsHashMap = new HashMap<Account,Relationships>();
        accounts = new ArrayList<Account>();
    }

    public RelationshipProvider(ArrayList<Account> accounts)
    {
        dataBase = new DataBase();
        this.accounts = accounts;
        for(Account elem: accounts)
        {
            dataBase.addAccount(elem);
        }
        relationshipsHashMap = new HashMap<Account,Relationships>();
    }
    public RelationshipProvider()
    {
        dataBase = new DataBase();
        dataBase.addAccount();
    }

    public static void addRelationships()
    {
        ArrayList<Account> temp;
        for(Account elem: accounts)
        {
            temp = new ArrayList<>(accounts);
            temp.remove(elem);
            Relationships relationships = new Relationships(elem);
            relationships.checkCompatibility(temp);
            relationshipsHashMap.put(elem, relationships);

        }
    }
    public static  void  putNewRelationShip(Relationships relationships, Account account)
    {
        relationshipsHashMap.put(account,relationships);
    }

    public static Relationships getRelationShips(Account account)
    {
        return relationshipsHashMap.get(account);
    }
}
