package com.esafirm.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.h.k.u;
import b.h.k.y;
import c.c.a.c;
import c.c.a.d;
import c.c.a.f;
import com.github.mikephil.charting.utils.Utils;

public class SnackBarView extends RelativeLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f4582d = new b.m.a.a.a();

    /* renamed from: b  reason: collision with root package name */
    private TextView f4583b;

    /* renamed from: c  reason: collision with root package name */
    private Button f4584c;

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f4585b;

        /* renamed from: com.esafirm.imagepicker.view.SnackBarView$a$a  reason: collision with other inner class name */
        class RunnableC0117a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f4587b;

            RunnableC0117a(View view) {
                this.f4587b = view;
            }

            public void run() {
                a.this.f4585b.onClick(this.f4587b);
            }
        }

        a(View.OnClickListener onClickListener) {
            this.f4585b = onClickListener;
        }

        public void onClick(View view) {
            SnackBarView.this.b(new RunnableC0117a(view));
        }
    }

    public SnackBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(Runnable runnable) {
        y d2 = u.d(this);
        d2.k((float) getHeight());
        d2.d(200);
        d2.a(0.5f);
        d2.l(runnable);
    }

    private void c() {
        View.inflate(getContext(), d.ef_imagepikcer_snackbar, this);
        if (!isInEditMode()) {
            u.E0(this, (float) getContext().getResources().getDimensionPixelSize(c.c.a.a.ef_height_snackbar));
            u.p0(this, Utils.FLOAT_EPSILON);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.c.a.a.ef_spacing_double);
            setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.f4583b = (TextView) findViewById(c.ef_snackbar_txt_bottom_caption);
            this.f4584c = (Button) findViewById(c.ef_snackbar_btn_action);
        }
    }

    public void d(int i2, View.OnClickListener onClickListener) {
        if (i2 == 0) {
            i2 = f.ef_ok;
        }
        this.f4584c.setText(i2);
        this.f4584c.setOnClickListener(new a(onClickListener));
    }

    public void e(int i2, View.OnClickListener onClickListener) {
        setText(i2);
        d(0, onClickListener);
        y d2 = u.d(this);
        d2.k(Utils.FLOAT_EPSILON);
        d2.d(200);
        d2.e(f4582d);
        d2.a(1.0f);
    }

    public void setText(int i2) {
        this.f4583b.setText(i2);
    }

    public SnackBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
