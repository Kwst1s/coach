package com.google.gson.u;

import java.util.Objects;

/* compiled from: $Gson$Preconditions */
public final class a {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
