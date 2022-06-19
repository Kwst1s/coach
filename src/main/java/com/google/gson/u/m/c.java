package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u.e;
import com.google.gson.u.i;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter */
public final class c extends r<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final s f8393b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<DateFormat> f8394a;

    /* compiled from: DateTypeAdapter */
    class a implements s {
        a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f8394a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.e()) {
            arrayList.add(i.c(2, 2));
        }
    }

    /* renamed from: d */
    public synchronized void c(com.google.gson.stream.a aVar, Date date) {
        if (date == null) {
            aVar.P();
        } else {
            aVar.c0(this.f8394a.get(0).format(date));
        }
    }
}
