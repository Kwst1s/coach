package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.g;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: CardViewBaseImpl */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f831a = new RectF();

    /* compiled from: CardViewBaseImpl */
    class a implements g.a {
        a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            float f3 = 2.0f * f2;
            float width = (rectF.width() - f3) - 1.0f;
            float height = (rectF.height() - f3) - 1.0f;
            if (f2 >= 1.0f) {
                float f4 = f2 + 0.5f;
                float f5 = -f4;
                c.this.f831a.set(f5, f5, f4, f4);
                int save = canvas.save();
                canvas.translate(rectF.left + f4, rectF.top + f4);
                canvas.drawArc(c.this.f831a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, Utils.FLOAT_EPSILON);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f831a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, Utils.FLOAT_EPSILON);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f831a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, Utils.FLOAT_EPSILON);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f831a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f6 = rectF.top;
                canvas.drawRect((rectF.left + f4) - 1.0f, f6, (rectF.right - f4) + 1.0f, f6 + f4, paint);
                float f7 = rectF.bottom;
                canvas.drawRect((rectF.left + f4) - 1.0f, f7 - f4, (rectF.right - f4) + 1.0f, f7, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
        }
    }

    c() {
    }

    private g o(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new g(context.getResources(), colorStateList, f2, f3, f4);
    }

    private g p(d dVar) {
        return (g) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return p(dVar).i();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList b(d dVar) {
        return p(dVar).f();
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        g o = o(context, colorStateList, f2, f3, f4);
        o.m(dVar.e());
        dVar.d(o);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void d(d dVar, float f2) {
        p(dVar).p(f2);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float e(d dVar) {
        return p(dVar).l();
    }

    @Override // androidx.cardview.widget.e
    public void f() {
        g.r = new a();
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return p(dVar).g();
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return p(dVar).j();
    }

    @Override // androidx.cardview.widget.e
    public float i(d dVar) {
        return p(dVar).k();
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, float f2) {
        p(dVar).r(f2);
    }

    @Override // androidx.cardview.widget.e
    public void l(d dVar) {
        p(dVar).m(dVar.e());
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, ColorStateList colorStateList) {
        p(dVar).o(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, float f2) {
        p(dVar).q(f2);
        q(dVar);
    }

    public void q(d dVar) {
        Rect rect = new Rect();
        p(dVar).h(rect);
        dVar.c((int) Math.ceil((double) i(dVar)), (int) Math.ceil((double) h(dVar)));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
