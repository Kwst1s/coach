package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: CalendarConstraints */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0151a();

    /* renamed from: b  reason: collision with root package name */
    private final l f7662b;

    /* renamed from: c  reason: collision with root package name */
    private final l f7663c;

    /* renamed from: d  reason: collision with root package name */
    private final c f7664d;

    /* renamed from: e  reason: collision with root package name */
    private l f7665e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7666f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7667g;

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.a$a  reason: collision with other inner class name */
    /* compiled from: CalendarConstraints */
    public static class C0151a implements Parcelable.Creator<a> {
        C0151a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a((l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), null);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* compiled from: CalendarConstraints */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        static final long f7668e = s.a(l.k(1900, 0).f7721g);

        /* renamed from: f  reason: collision with root package name */
        static final long f7669f = s.a(l.k(2100, 11).f7721g);

        /* renamed from: a  reason: collision with root package name */
        private long f7670a = f7668e;

        /* renamed from: b  reason: collision with root package name */
        private long f7671b = f7669f;

        /* renamed from: c  reason: collision with root package name */
        private Long f7672c;

        /* renamed from: d  reason: collision with root package name */
        private c f7673d = f.g(Long.MIN_VALUE);

        b(a aVar) {
            this.f7670a = aVar.f7662b.f7721g;
            this.f7671b = aVar.f7663c.f7721g;
            this.f7672c = Long.valueOf(aVar.f7665e.f7721g);
            this.f7673d = aVar.f7664d;
        }

        public a a() {
            l lVar;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f7673d);
            l l = l.l(this.f7670a);
            l l2 = l.l(this.f7671b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f7672c;
            if (l3 == null) {
                lVar = null;
            } else {
                lVar = l.l(l3.longValue());
            }
            return new a(l, l2, cVar, lVar, null);
        }

        public b b(long j2) {
            this.f7672c = Long.valueOf(j2);
            return this;
        }
    }

    /* compiled from: CalendarConstraints */
    public interface c extends Parcelable {
        boolean d(long j2);
    }

    /* synthetic */ a(l lVar, l lVar2, c cVar, l lVar3, C0151a aVar) {
        this(lVar, lVar2, cVar, lVar3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f7662b.equals(aVar.f7662b) || !this.f7663c.equals(aVar.f7663c) || !b.h.j.c.a(this.f7665e, aVar.f7665e) || !this.f7664d.equals(aVar.f7664d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7662b, this.f7663c, this.f7665e, this.f7664d});
    }

    /* access modifiers changed from: package-private */
    public l n(l lVar) {
        if (lVar.compareTo(this.f7662b) < 0) {
            return this.f7662b;
        }
        return lVar.compareTo(this.f7663c) > 0 ? this.f7663c : lVar;
    }

    public c o() {
        return this.f7664d;
    }

    /* access modifiers changed from: package-private */
    public l p() {
        return this.f7663c;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f7667g;
    }

    /* access modifiers changed from: package-private */
    public l r() {
        return this.f7665e;
    }

    /* access modifiers changed from: package-private */
    public l s() {
        return this.f7662b;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.f7666f;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7662b, 0);
        parcel.writeParcelable(this.f7663c, 0);
        parcel.writeParcelable(this.f7665e, 0);
        parcel.writeParcelable(this.f7664d, 0);
    }

    private a(l lVar, l lVar2, c cVar, l lVar3) {
        this.f7662b = lVar;
        this.f7663c = lVar2;
        this.f7665e = lVar3;
        this.f7664d = cVar;
        if (lVar3 != null && lVar.compareTo(lVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (lVar3 == null || lVar3.compareTo(lVar2) <= 0) {
            this.f7667g = lVar.t(lVar2) + 1;
            this.f7666f = (lVar2.f7718d - lVar.f7718d) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }
}
