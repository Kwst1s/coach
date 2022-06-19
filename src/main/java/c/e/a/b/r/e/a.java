package c.e.a.b.r.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import c.e.a.b.r.c;
import c.e.a.b.r.d;

/* compiled from: CircularRevealCardView */
public class a extends c.e.a.b.p.a implements d {
    private final c s;

    @Override // c.e.a.b.r.d
    public void a() {
        this.s.b();
    }

    @Override // c.e.a.b.r.d
    public void b() {
        this.s.a();
    }

    public void draw(Canvas canvas) {
        c cVar = this.s;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.s.d();
    }

    @Override // c.e.a.b.r.d
    public int getCircularRevealScrimColor() {
        return this.s.e();
    }

    @Override // c.e.a.b.r.d
    public d.e getRevealInfo() {
        return this.s.f();
    }

    public boolean isOpaque() {
        c cVar = this.s;
        if (cVar != null) {
            return cVar.g();
        }
        return super.isOpaque();
    }

    @Override // c.e.a.b.r.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.s.h(drawable);
    }

    @Override // c.e.a.b.r.d
    public void setCircularRevealScrimColor(int i2) {
        this.s.i(i2);
    }

    @Override // c.e.a.b.r.d
    public void setRevealInfo(d.e eVar) {
        this.s.j(eVar);
    }
}
