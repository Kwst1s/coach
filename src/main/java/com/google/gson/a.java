package com.google.gson;

import com.google.gson.u.e;
import com.google.gson.u.i;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter */
final class a extends r<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final List<DateFormat> f8277a;

    a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f8277a = arrayList;
        d(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private static Class<? extends Date> d(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    /* renamed from: e */
    public void c(com.google.gson.stream.a aVar, Date date) {
        if (date == null) {
            aVar.P();
            return;
        }
        synchronized (this.f8277a) {
            aVar.c0(this.f8277a.get(0).format(date));
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f8277a.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f8277a = arrayList;
        d(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (e.e()) {
            arrayList.add(i.c(i2, i3));
        }
    }
}
