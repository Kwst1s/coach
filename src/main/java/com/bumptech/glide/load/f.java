package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3924a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
