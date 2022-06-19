package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.b.c.b.d;
import com.rd.c.c.a;

/* compiled from: ScaleDrawer */
public class g extends a {
    public g(Paint paint, a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            float m = (float) this.f8616b.m();
            int p = this.f8616b.p();
            int q = this.f8616b.q();
            int r = this.f8616b.r();
            int f2 = this.f8616b.f();
            if (this.f8616b.z()) {
                if (i2 == r) {
                    m = (float) dVar.e();
                    p = dVar.a();
                } else if (i2 == q) {
                    m = (float) dVar.f();
                    p = dVar.b();
                }
            } else if (i2 == q) {
                m = (float) dVar.e();
                p = dVar.a();
            } else if (i2 == f2) {
                m = (float) dVar.f();
                p = dVar.b();
            }
            this.f8615a.setColor(p);
            canvas.drawCircle((float) i3, (float) i4, m, this.f8615a);
        }
    }
}
