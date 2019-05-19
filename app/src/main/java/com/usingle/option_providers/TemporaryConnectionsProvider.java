package com.usingle.option_providers;

import java.util.ArrayList;

public class TemporaryConnectionsProvider {
    private static ArrayList<String> matches;

    static {
        matches = new ArrayList<>();
        matches.add("This person is interesting and more!");
        matches.add("This person is funny and more!");
        matches.add("This person is boring, just like you... and more!");
        matches.add("This person is James.");
    }

    public static String getConnection(int i) {
        return matches.get(i);
    }

    public static int getNumberOfConnections() {
        return matches.size();
    }
}
