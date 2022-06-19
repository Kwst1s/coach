package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* compiled from: AudioAttributes */
public final class h {

    /* renamed from: e  reason: collision with root package name */
    public static final h f4778e = new b().a();

    /* renamed from: a  reason: collision with root package name */
    public final int f4779a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4780b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4781c;

    /* renamed from: d  reason: collision with root package name */
    private AudioAttributes f4782d;

    /* compiled from: AudioAttributes */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f4783a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f4784b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f4785c = 1;

        public h a() {
            return new h(this.f4783a, this.f4784b, this.f4785c);
        }
    }

    @TargetApi(21)
    public AudioAttributes a() {
        if (this.f4782d == null) {
            this.f4782d = new AudioAttributes.Builder().setContentType(this.f4779a).setFlags(this.f4780b).setUsage(this.f4781c).build();
        }
        return this.f4782d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f4779a == hVar.f4779a && this.f4780b == hVar.f4780b && this.f4781c == hVar.f4781c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f4779a) * 31) + this.f4780b) * 31) + this.f4781c;
    }

    private h(int i2, int i3, int i4) {
        this.f4779a = i2;
        this.f4780b = i3;
        this.f4781c = i4;
    }
}
