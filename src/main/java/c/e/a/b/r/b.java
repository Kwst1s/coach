package c.e.a.b.r;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import c.e.a.b.r.d;

/* compiled from: CircularRevealFrameLayout */
public class b extends FrameLayout implements d {

    /* renamed from: b  reason: collision with root package name */
    private final c f3425b;

    @Override // c.e.a.b.r.d
    public void a() {
        this.f3425b.b();
    }

    @Override // c.e.a.b.r.d
    public void b() {
        this.f3425b.a();
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f3425b;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f3425b.d();
    }

    @Override // c.e.a.b.r.d
    public int getCircularRevealScrimColor() {
        return this.f3425b.e();
    }

    @Override // c.e.a.b.r.d
    public d.e getRevealInfo() {
        return this.f3425b.f();
    }

    public boolean isOpaque() {
        c cVar = this.f3425b;
        if (cVar != null) {
            return cVar.g();
        }
        return super.isOpaque();
    }

    @Override // c.e.a.b.r.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f3425b.h(drawable);
    }

    @Override // c.e.a.b.r.d
    public void setCircularRevealScrimColor(int i2) {
        this.f3425b.i(i2);
    }

    @Override // c.e.a.b.r.d
    public void setRevealInfo(d.e eVar) {
        this.f3425b.j(eVar);
    }
}
