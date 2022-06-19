package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class i extends r<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final s f8416b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f8417a = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter */
    class a implements s {
        a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new i();
            }
            return null;
        }
    }

    /* renamed from: d */
    public synchronized void c(com.google.gson.stream.a aVar, Date date) {
        aVar.c0(date == null ? null : this.f8417a.format(date));
    }
}
