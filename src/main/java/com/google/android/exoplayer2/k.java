package com.google.android.exoplayer2;

import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f5969a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f5970b = "goog.exo.core";

    public static synchronized void a(String str) {
        synchronized (k.class) {
            if (f5969a.add(str)) {
                f5970b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (k.class) {
            str = f5970b;
        }
        return str;
    }
}
