package com.rd.c.b;

import android.graphics.Canvas;
import android.view.MotionEvent;

/* compiled from: DrawController */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private com.rd.b.c.a f8578a;

    /* renamed from: b  reason: collision with root package name */
    private com.rd.c.d.a f8579b;

    /* renamed from: c  reason: collision with root package name */
    private com.rd.c.c.a f8580c;

    /* renamed from: d  reason: collision with root package name */
    private AbstractC0173b f8581d;

    /* access modifiers changed from: package-private */
    /* compiled from: DrawController */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8582a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
            // Method dump skipped, instructions count: 121
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.c.b.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.rd.c.b.b$b  reason: collision with other inner class name */
    /* compiled from: DrawController */
    public interface AbstractC0173b {
        void a(int i2);
    }

    public b(com.rd.c.c.a aVar) {
        this.f8580c = aVar;
        this.f8579b = new com.rd.c.d.a(aVar);
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        boolean z = this.f8580c.z();
        int q = this.f8580c.q();
        int r = this.f8580c.r();
        boolean z2 = true;
        boolean z3 = !z && (i2 == q || i2 == this.f8580c.f());
        if (!z || !(i2 == q || i2 == r)) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        this.f8579b.k(i2, i3, i4);
        if (this.f8578a == null || !z4) {
            this.f8579b.a(canvas, z4);
        } else {
            c(canvas);
        }
    }

    private void c(Canvas canvas) {
        switch (a.f8582a[this.f8580c.b().ordinal()]) {
            case 1:
                this.f8579b.a(canvas, true);
                return;
            case 2:
                this.f8579b.b(canvas, this.f8578a);
                return;
            case 3:
                this.f8579b.e(canvas, this.f8578a);
                return;
            case 4:
                this.f8579b.j(canvas, this.f8578a);
                return;
            case 5:
                this.f8579b.g(canvas, this.f8578a);
                return;
            case 6:
                this.f8579b.d(canvas, this.f8578a);
                return;
            case 7:
                this.f8579b.i(canvas, this.f8578a);
                return;
            case 8:
                this.f8579b.c(canvas, this.f8578a);
                return;
            case 9:
                this.f8579b.h(canvas, this.f8578a);
                return;
            case 10:
                this.f8579b.f(canvas, this.f8578a);
                return;
            default:
                return;
        }
    }

    private void d(float f2, float f3) {
        int d2;
        if (this.f8581d != null && (d2 = com.rd.e.a.d(this.f8580c, f2, f3)) >= 0) {
            this.f8581d.a(d2);
        }
    }

    public void a(Canvas canvas) {
        int c2 = this.f8580c.c();
        for (int i2 = 0; i2 < c2; i2++) {
            b(canvas, i2, com.rd.e.a.g(this.f8580c, i2), com.rd.e.a.h(this.f8580c, i2));
        }
    }

    public void e(AbstractC0173b bVar) {
        this.f8581d = bVar;
    }

    public void f(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            d(motionEvent.getX(), motionEvent.getY());
        }
    }

    public void g(com.rd.b.c.a aVar) {
        this.f8578a = aVar;
    }
}
