package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* compiled from: ManufacturerUtils */
public class e {
    public static boolean a() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }
}
