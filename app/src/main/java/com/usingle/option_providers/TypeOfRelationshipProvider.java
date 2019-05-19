package com.usingle.option_providers;

import java.util.ArrayList;

public class TypeOfRelationshipProvider {
    private static ArrayList<String> relationships;

    static {
        relationships = new ArrayList<>();
        relationships.add("Casual");
        relationships.add("Serious");
        relationships.add("Open");
    }

    public static String getTypeOfRelationship(int i) {
        return relationships.get(i);
    }

    public static int getNumberOfRelationships() {
        return relationships.size();
    }
}
