package com.usingle.option_providers;

import java.util.ArrayList;

public class SexualPreferenceProvider {
    private static ArrayList<String> preferences;

    static {
        preferences = new ArrayList<>();
        preferences.add("Male");
        preferences.add("Female");
        preferences.add("Other");
    }

    public static String getSexualPreference(int i) {
        return preferences.get(i);
    }

    public static int getNumberOfSexualPreferences() {
        return preferences.size();
    }
}
