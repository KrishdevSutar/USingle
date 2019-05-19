package com.usingle.models;

import java.util.ArrayList;
import java.util.Collection;

public class Relationships
{
    private ArrayList<Account> incompatible;
    private ArrayList<Account> compatible;
    private ArrayList<Account> connected;
    private Account profile;

    public Relationships(Account account)
    {
        incompatible = new ArrayList<Account>();
        compatible = new ArrayList<Account>();
        connected = new ArrayList<Account>();
        profile = account;
    }

    public void addIncompatible(Account account)
    {
        incompatible.add(account);
    }
    public void addCompatible(Account account)
    {
        compatible.add(account);
    }
    public void formConnection(Account account)
    {
        compatible.remove(account);
        connected.add(account);
    }

    public void removeCompatible(Account account)
    {
        compatible.remove(account);
        incompatible.add(account);
    }

    public ArrayList<Account> getCompatible()
    {
        return compatible;
    }
    public ArrayList<Account> getConnected()
    {
        return connected;
    }

    public void checkCompatibility(ArrayList<Account> accounts)
    {
        int compatibilness = 0;
        for(Account elem: accounts)
        {
            if (elem == profile) {
                continue;
            }
            if(elem.getBiography().getUni().equals(profile.getBiography().getUni()))
            {
                compatibilness++;
            }
            if(profile.getBiography().getLooks().equals(elem.getBiography().getLooks()))
            {
                compatibilness++;
            }
            if(Math.abs(profile.getBiography().getAge()-elem.getBiography().getAge())<3)
            {
                compatibilness++;
            }
            if(compatibilness < 2)
            {
                incompatible.add(elem);
            } else {
                compatible.add(elem);
            }
        }
    }
}
