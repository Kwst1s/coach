package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.b.c.b.e;
import com.rd.c.c.a;
import com.rd.c.c.b;

/* compiled from: SlideDrawer */
public class h extends a {
    public h(Paint paint, a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof e) {
            int a2 = ((e) aVar).a();
            int t = this.f8616b.t();
            int p = this.f8616b.p();
            int m = this.f8616b.m();
            this.f8615a.setColor(t);
            float f2 = (float) i2;
            float f3 = (float) i3;
            float f4 = (float) m;
            canvas.drawCircle(f2, f3, f4, this.f8615a);
            this.f8615a.setColor(p);
            if (this.f8616b.g() == b.HORIZONTAL) {
                canvas.drawCircle((float) a2, f3, f4, this.f8615a);
            } else {
                canvas.drawCircle(f2, (float) a2, f4, this.f8615a);
            }
        }
    }
}
