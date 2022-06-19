package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.c.c.a;

/* compiled from: BasicDrawer */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f8617c;

    public b(Paint paint, a aVar) {
        super(paint, aVar);
        Paint paint2 = new Paint();
        this.f8617c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f8617c.setAntiAlias(true);
        this.f8617c.setStrokeWidth((float) aVar.s());
    }

    public void a(Canvas canvas, int i2, boolean z, int i3, int i4) {
        Paint paint;
        float m = (float) this.f8616b.m();
        int s = this.f8616b.s();
        float o = this.f8616b.o();
        int p = this.f8616b.p();
        int t = this.f8616b.t();
        int q = this.f8616b.q();
        com.rd.b.d.a b2 = this.f8616b.b();
        if ((b2 == com.rd.b.d.a.SCALE && !z) || (b2 == com.rd.b.d.a.SCALE_DOWN && z)) {
            m *= o;
        }
        if (i2 != q) {
            p = t;
        }
        if (b2 != com.rd.b.d.a.FILL || i2 == q) {
            paint = this.f8615a;
        } else {
            paint = this.f8617c;
            paint.setStrokeWidth((float) s);
        }
        paint.setColor(p);
        canvas.drawCircle((float) i3, (float) i4, m, paint);
    }
}
