package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.k.e;

/* compiled from: Placeholder */
public class g extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f971b;

    /* renamed from: c  reason: collision with root package name */
    private View f972c;

    /* renamed from: d  reason: collision with root package name */
    private int f973d;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f972c != null) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f972c.getLayoutParams();
            bVar2.m0.T0(0);
            e.b y = bVar.m0.y();
            e.b bVar3 = e.b.FIXED;
            if (y != bVar3) {
                bVar.m0.U0(bVar2.m0.R());
            }
            if (bVar.m0.O() != bVar3) {
                bVar.m0.v0(bVar2.m0.v());
            }
            bVar2.m0.T0(8);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f971b == -1 && !isInEditMode()) {
            setVisibility(this.f973d);
        }
        View findViewById = constraintLayout.findViewById(this.f971b);
        this.f972c = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).a0 = true;
            this.f972c.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f972c;
    }

    public int getEmptyVisibility() {
        return this.f973d;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f971b != i2) {
            View view = this.f972c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.b) this.f972c.getLayoutParams()).a0 = false;
                this.f972c = null;
            }
            this.f971b = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f973d = i2;
    }
}
