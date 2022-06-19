package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: UtcDates */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference<r> f7739a = new AtomicReference<>();

    static long a(long j2) {
        Calendar k2 = k();
        k2.setTimeInMillis(j2);
        return d(k2).getTimeInMillis();
    }

    @TargetApi(24)
    static DateFormat b(Locale locale) {
        return c("MMMEd", locale);
    }

    @TargetApi(24)
    private static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(j());
        return instanceForSkeleton;
    }

    static Calendar d(Calendar calendar) {
        Calendar l = l(calendar);
        Calendar k2 = k();
        k2.set(l.get(1), l.get(2), l.get(5));
        return k2;
    }

    private static java.text.DateFormat e(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(h());
        return dateInstance;
    }

    static java.text.DateFormat f(Locale locale) {
        return e(0, locale);
    }

    static r g() {
        r rVar = f7739a.get();
        return rVar == null ? r.c() : rVar;
    }

    private static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar i() {
        Calendar a2 = g().a();
        a2.set(11, 0);
        a2.set(12, 0);
        a2.set(13, 0);
        a2.set(14, 0);
        a2.setTimeZone(h());
        return a2;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar k() {
        return l(null);
    }

    static Calendar l(Calendar calendar) {
        Calendar instance = Calendar.getInstance(h());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    @TargetApi(24)
    static DateFormat m(Locale locale) {
        return c("yMMMEd", locale);
    }
}
