package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
public final class j extends r<Time> {

    /* renamed from: b  reason: collision with root package name */
    public static final s f8418b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f8419a = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter */
    class a implements s {
        a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() == Time.class) {
                return new j();
            }
            return null;
        }
    }

    /* renamed from: d */
    public synchronized void c(com.google.gson.stream.a aVar, Time time) {
        aVar.c0(time == null ? null : this.f8419a.format(time));
    }
}
