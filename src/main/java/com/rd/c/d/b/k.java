package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.rd.b.c.b.h;
import com.rd.c.c.a;
import com.rd.c.c.b;

/* compiled from: WormDrawer */
public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    public RectF f8619c = new RectF();

    public k(Paint paint, a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof h) {
            h hVar = (h) aVar;
            int b2 = hVar.b();
            int a2 = hVar.a();
            int m = this.f8616b.m();
            int t = this.f8616b.t();
            int p = this.f8616b.p();
            if (this.f8616b.g() == b.HORIZONTAL) {
                RectF rectF = this.f8619c;
                rectF.left = (float) b2;
                rectF.right = (float) a2;
                rectF.top = (float) (i3 - m);
                rectF.bottom = (float) (i3 + m);
            } else {
                RectF rectF2 = this.f8619c;
                rectF2.left = (float) (i2 - m);
                rectF2.right = (float) (i2 + m);
                rectF2.top = (float) b2;
                rectF2.bottom = (float) a2;
            }
            this.f8615a.setColor(t);
            float f2 = (float) i2;
            float f3 = (float) i3;
            float f4 = (float) m;
            canvas.drawCircle(f2, f3, f4, this.f8615a);
            this.f8615a.setColor(p);
            canvas.drawRoundRect(this.f8619c, f4, f4, this.f8615a);
        }
    }
}
