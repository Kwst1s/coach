package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.b.c.b.b;
import com.rd.c.c.a;

/* compiled from: DropDrawer */
public class d extends a {
    public d(Paint paint, a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            int t = this.f8616b.t();
            int p = this.f8616b.p();
            this.f8615a.setColor(t);
            canvas.drawCircle((float) i2, (float) i3, (float) this.f8616b.m(), this.f8615a);
            this.f8615a.setColor(p);
            if (this.f8616b.g() == com.rd.c.c.b.HORIZONTAL) {
                canvas.drawCircle((float) bVar.c(), (float) bVar.a(), (float) bVar.b(), this.f8615a);
            } else {
                canvas.drawCircle((float) bVar.a(), (float) bVar.c(), (float) bVar.b(), this.f8615a);
            }
        }
    }
}
