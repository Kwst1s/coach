package com.google.android.vending.expansion.downloader.impl;

import android.os.Build;
import com.google.android.vending.expansion.downloader.impl.e;

/* compiled from: CustomNotificationFactory */
public class c {
    public static e.a a() {
        if (Build.VERSION.SDK_INT > 13) {
            return new h();
        }
        return new i();
    }
}
