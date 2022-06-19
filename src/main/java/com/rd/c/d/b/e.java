package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.b.c.b.c;
import com.rd.c.c.a;

/* compiled from: FillDrawer */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f8618c;

    public e(Paint paint, a aVar) {
        super(paint, aVar);
        Paint paint2 = new Paint();
        this.f8618c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f8618c.setAntiAlias(true);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int t = this.f8616b.t();
            float m = (float) this.f8616b.m();
            int s = this.f8616b.s();
            int q = this.f8616b.q();
            int r = this.f8616b.r();
            int f2 = this.f8616b.f();
            if (this.f8616b.z()) {
                if (i2 == r) {
                    t = cVar.a();
                    m = (float) cVar.e();
                    s = cVar.g();
                } else if (i2 == q) {
                    t = cVar.b();
                    m = (float) cVar.f();
                    s = cVar.h();
                }
            } else if (i2 == q) {
                t = cVar.a();
                m = (float) cVar.e();
                s = cVar.g();
            } else if (i2 == f2) {
                t = cVar.b();
                m = (float) cVar.f();
                s = cVar.h();
            }
            this.f8618c.setColor(t);
            this.f8618c.setStrokeWidth((float) this.f8616b.s());
            float f3 = (float) i3;
            float f4 = (float) i4;
            canvas.drawCircle(f3, f4, (float) this.f8616b.m(), this.f8618c);
            this.f8618c.setStrokeWidth((float) s);
            canvas.drawCircle(f3, f4, m, this.f8618c);
        }
    }
}
