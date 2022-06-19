package com.google.android.exoplayer2.text.r;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.util.m;

/* compiled from: WebvttCue */
public final class e extends com.google.android.exoplayer2.text.a {

    /* renamed from: e  reason: collision with root package name */
    public final long f6831e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6832f;

    /* access modifiers changed from: package-private */
    /* compiled from: WebvttCue */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6833a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.android.exoplayer2.text.r.e.a.f6833a = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.google.android.exoplayer2.text.r.e.a.f6833a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.google.android.exoplayer2.text.r.e.a.f6833a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.r.e.a.<clinit>():void");
        }
    }

    /* compiled from: WebvttCue */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private long f6834a;

        /* renamed from: b  reason: collision with root package name */
        private long f6835b;

        /* renamed from: c  reason: collision with root package name */
        private SpannableStringBuilder f6836c;

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f6837d;

        /* renamed from: e  reason: collision with root package name */
        private float f6838e;

        /* renamed from: f  reason: collision with root package name */
        private int f6839f;

        /* renamed from: g  reason: collision with root package name */
        private int f6840g;

        /* renamed from: h  reason: collision with root package name */
        private float f6841h;

        /* renamed from: i  reason: collision with root package name */
        private int f6842i;

        /* renamed from: j  reason: collision with root package name */
        private float f6843j;

        public b() {
            c();
        }

        private b b() {
            Layout.Alignment alignment = this.f6837d;
            if (alignment == null) {
                this.f6842i = Integer.MIN_VALUE;
            } else {
                int i2 = a.f6833a[alignment.ordinal()];
                if (i2 == 1) {
                    this.f6842i = 0;
                } else if (i2 == 2) {
                    this.f6842i = 1;
                } else if (i2 != 3) {
                    m.f("WebvttCueBuilder", "Unrecognized alignment: " + this.f6837d);
                    this.f6842i = 0;
                } else {
                    this.f6842i = 2;
                }
            }
            return this;
        }

        public e a() {
            if (this.f6841h != Float.MIN_VALUE && this.f6842i == Integer.MIN_VALUE) {
                b();
            }
            return new e(this.f6834a, this.f6835b, this.f6836c, this.f6837d, this.f6838e, this.f6839f, this.f6840g, this.f6841h, this.f6842i, this.f6843j);
        }

        public void c() {
            this.f6834a = 0;
            this.f6835b = 0;
            this.f6836c = null;
            this.f6837d = null;
            this.f6838e = Float.MIN_VALUE;
            this.f6839f = Integer.MIN_VALUE;
            this.f6840g = Integer.MIN_VALUE;
            this.f6841h = Float.MIN_VALUE;
            this.f6842i = Integer.MIN_VALUE;
            this.f6843j = Float.MIN_VALUE;
        }

        public b d(long j2) {
            this.f6835b = j2;
            return this;
        }

        public b e(float f2) {
            this.f6838e = f2;
            return this;
        }

        public b f(int i2) {
            this.f6840g = i2;
            return this;
        }

        public b g(int i2) {
            this.f6839f = i2;
            return this;
        }

        public b h(float f2) {
            this.f6841h = f2;
            return this;
        }

        public b i(int i2) {
            this.f6842i = i2;
            return this;
        }

        public b j(long j2) {
            this.f6834a = j2;
            return this;
        }

        public b k(SpannableStringBuilder spannableStringBuilder) {
            this.f6836c = spannableStringBuilder;
            return this;
        }

        public b l(Layout.Alignment alignment) {
            this.f6837d = alignment;
            return this;
        }

        public b m(float f2) {
            this.f6843j = f2;
            return this;
        }
    }

    public e(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public boolean a() {
        return this.f6656c == Float.MIN_VALUE && this.f6657d == Float.MIN_VALUE;
    }

    public e(long j2, long j3, CharSequence charSequence) {
        this(j2, j3, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.f6831e = j2;
        this.f6832f = j3;
    }
}
