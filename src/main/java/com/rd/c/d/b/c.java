package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.c.c.a;

/* compiled from: ColorDrawer */
public class c extends a {
    public c(Paint paint, a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof com.rd.b.c.b.a) {
            com.rd.b.c.b.a aVar2 = (com.rd.b.c.b.a) aVar;
            float m = (float) this.f8616b.m();
            int p = this.f8616b.p();
            int q = this.f8616b.q();
            int r = this.f8616b.r();
            int f2 = this.f8616b.f();
            if (this.f8616b.z()) {
                if (i2 == r) {
                    p = aVar2.a();
                } else if (i2 == q) {
                    p = aVar2.b();
                }
            } else if (i2 == q) {
                p = aVar2.a();
            } else if (i2 == f2) {
                p = aVar2.b();
            }
            this.f8615a.setColor(p);
            canvas.drawCircle((float) i3, (float) i4, m, this.f8615a);
        }
    }
}
