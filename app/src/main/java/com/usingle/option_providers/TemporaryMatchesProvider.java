package com.usingle.option_providers;

import java.util.ArrayList;

public class TemporaryMatchesProvider {
    private static ArrayList<String> matches;

    static {
        matches = new ArrayList<>();
        matches.add("This person is interesting.");
        matches.add("This person is funny.");
        matches.add("This person is boring, just like you...");
        matches.add("This person is James.");
    }

    public static String getMatch(int i) {
        return matches.get(i);
    }

    public static int getNumberOfMatches() {
        return matches.size();
    }
}
