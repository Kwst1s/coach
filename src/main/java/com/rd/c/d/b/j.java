package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.rd.b.c.b.g;
import com.rd.c.c.a;
import com.rd.c.c.b;

/* compiled from: ThinWormDrawer */
public class j extends k {
    public j(Paint paint, a aVar) {
        super(paint, aVar);
    }

    @Override // com.rd.c.d.b.k
    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            int b2 = gVar.b();
            int a2 = gVar.a();
            int e2 = gVar.e() / 2;
            int m = this.f8616b.m();
            int t = this.f8616b.t();
            int p = this.f8616b.p();
            if (this.f8616b.g() == b.HORIZONTAL) {
                RectF rectF = this.f8619c;
                rectF.left = (float) b2;
                rectF.right = (float) a2;
                rectF.top = (float) (i3 - e2);
                rectF.bottom = (float) (e2 + i3);
            } else {
                RectF rectF2 = this.f8619c;
                rectF2.left = (float) (i2 - e2);
                rectF2.right = (float) (e2 + i2);
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
