package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* access modifiers changed from: package-private */
/* compiled from: Month */
public final class l implements Comparable<l>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f7716b;

    /* renamed from: c  reason: collision with root package name */
    final int f7717c;

    /* renamed from: d  reason: collision with root package name */
    final int f7718d;

    /* renamed from: e  reason: collision with root package name */
    final int f7719e;

    /* renamed from: f  reason: collision with root package name */
    final int f7720f;

    /* renamed from: g  reason: collision with root package name */
    final long f7721g;

    /* renamed from: h  reason: collision with root package name */
    private String f7722h;

    /* compiled from: Month */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return l.k(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public l[] newArray(int i2) {
            return new l[i2];
        }
    }

    private l(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = s.d(calendar);
        this.f7716b = d2;
        this.f7717c = d2.get(2);
        this.f7718d = d2.get(1);
        this.f7719e = d2.getMaximum(7);
        this.f7720f = d2.getActualMaximum(5);
        this.f7721g = d2.getTimeInMillis();
    }

    static l k(int i2, int i3) {
        Calendar k2 = s.k();
        k2.set(1, i2);
        k2.set(2, i3);
        return new l(k2);
    }

    static l l(long j2) {
        Calendar k2 = s.k();
        k2.setTimeInMillis(j2);
        return new l(k2);
    }

    static l m() {
        return new l(s.i());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f7717c == lVar.f7717c && this.f7718d == lVar.f7718d) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public int compareTo(l lVar) {
        return this.f7716b.compareTo(lVar.f7716b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7717c), Integer.valueOf(this.f7718d)});
    }

    /* access modifiers changed from: package-private */
    public int n() {
        int firstDayOfWeek = this.f7716b.get(7) - this.f7716b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f7719e : firstDayOfWeek;
    }

    /* access modifiers changed from: package-private */
    public long o(int i2) {
        Calendar d2 = s.d(this.f7716b);
        d2.set(5, i2);
        return d2.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public int p(long j2) {
        Calendar d2 = s.d(this.f7716b);
        d2.setTimeInMillis(j2);
        return d2.get(5);
    }

    /* access modifiers changed from: package-private */
    public String q(Context context) {
        if (this.f7722h == null) {
            this.f7722h = e.c(context, this.f7716b.getTimeInMillis());
        }
        return this.f7722h;
    }

    /* access modifiers changed from: package-private */
    public long r() {
        return this.f7716b.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public l s(int i2) {
        Calendar d2 = s.d(this.f7716b);
        d2.add(2, i2);
        return new l(d2);
    }

    /* access modifiers changed from: package-private */
    public int t(l lVar) {
        if (this.f7716b instanceof GregorianCalendar) {
            return ((lVar.f7718d - this.f7718d) * 12) + (lVar.f7717c - this.f7717c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7718d);
        parcel.writeInt(this.f7717c);
    }
}
