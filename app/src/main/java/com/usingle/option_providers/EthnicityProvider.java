package com.usingle.option_providers;

import java.util.ArrayList;

public class EthnicityProvider {
    private static ArrayList<String> ethnicities;

    static {
        ethnicities = new ArrayList<>();
        ethnicities.add("Aboriginal");
        ethnicities.add("Arabian");
        ethnicities.add("Black");
        ethnicities.add("Chinese");
        ethnicities.add("Filipino");
        ethnicities.add("Japanese");
        ethnicities.add("Korean");
        ethnicities.add("Latin American");
        ethnicities.add("South Asian");
        ethnicities.add("South East Asian");
        ethnicities.add("White (Caucasian)");
        ethnicities.add("Other");
    }

    public static String getEthnicity(int i) {
        return ethnicities.get(i);
    }

    public static int getNumberOfEthnicities() {
        return ethnicities.size();
    }
}
