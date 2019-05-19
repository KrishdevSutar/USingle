package com.usingle.models;

import android.graphics.Bitmap;

import java.util.HashMap;

public class BitMapProvider {
    static HashMap<Integer, Bitmap> blep = new HashMap<Integer, Bitmap>();

    public BitMapProvider()
    {
    }

    public static int addBitmap(Bitmap bitmap)
    {
        blep.put(blep.size(), bitmap);
        return blep.size() - 1;
    }

    public static Bitmap getBitmap (Integer i)
    {
        return blep.get(i);
    }
}
