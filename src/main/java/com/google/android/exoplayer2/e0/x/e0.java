package com.google.android.exoplayer2.e0.x;

import android.util.SparseArray;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;
import java.util.List;

/* compiled from: TsPayloadReader */
public interface e0 {

    /* compiled from: TsPayloadReader */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f5445a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5446b;

        public a(String str, int i2, byte[] bArr) {
            this.f5445a = str;
            this.f5446b = bArr;
        }
    }

    /* compiled from: TsPayloadReader */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5447a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5448b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f5449c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f5450d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.f5447a = i2;
            this.f5448b = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f5449c = list2;
            this.f5450d = bArr;
        }
    }

    /* compiled from: TsPayloadReader */
    public interface c {
        SparseArray<e0> a();

        e0 b(int i2, b bVar);
    }

    /* compiled from: TsPayloadReader */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f5451a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5452b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5453c;

        /* renamed from: d  reason: collision with root package name */
        private int f5454d;

        /* renamed from: e  reason: collision with root package name */
        private String f5455e;

        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        private void d() {
            if (this.f5454d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2 = this.f5454d;
            this.f5454d = i2 == Integer.MIN_VALUE ? this.f5452b : i2 + this.f5453c;
            this.f5455e = this.f5451a + this.f5454d;
        }

        public String b() {
            d();
            return this.f5455e;
        }

        public int c() {
            d();
            return this.f5454d;
        }

        public d(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = BuildConfig.FLAVOR;
            }
            this.f5451a = str;
            this.f5452b = i3;
            this.f5453c = i4;
            this.f5454d = Integer.MIN_VALUE;
        }
    }

    void a();

    void b(a0 a0Var, i iVar, d dVar);

    void c(s sVar, boolean z);
}
