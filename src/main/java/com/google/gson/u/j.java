package com.google.gson.u;

import java.lang.reflect.Type;

/* compiled from: Primitives */
public final class j {
    public static boolean a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }
}
