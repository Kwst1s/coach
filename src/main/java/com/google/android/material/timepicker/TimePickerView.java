package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.h.k.u;
import c.e.a.b.h;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

class TimePickerView extends ConstraintLayout {
    private e A;
    private final Chip u;
    private final Chip v;
    private final MaterialButtonToggleGroup w;
    private final View.OnClickListener x;
    private f y;
    private g z;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (TimePickerView.this.z != null) {
                TimePickerView.this.z.a(((Integer) view.getTag(c.e.a.b.f.selection_type)).intValue());
            }
        }
    }

    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
            int i3 = i2 == c.e.a.b.f.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.y != null && z) {
                TimePickerView.this.y.a(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.A != null) {
                TimePickerView.this.A.a();
            }
            return onDoubleTap;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GestureDetector f8094b;

        d(TimePickerView timePickerView, GestureDetector gestureDetector) {
            this.f8094b = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f8094b.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public interface e {
        void a();
    }

    /* access modifiers changed from: package-private */
    public interface f {
        void a(int i2);
    }

    /* access modifiers changed from: package-private */
    public interface g {
        void a(int i2);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void x() {
        Chip chip = this.u;
        int i2 = c.e.a.b.f.selection_type;
        chip.setTag(i2, 12);
        this.v.setTag(i2, 10);
        this.u.setOnClickListener(this.x);
        this.v.setOnClickListener(this.x);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void y() {
        d dVar = new d(this, new GestureDetector(getContext(), new c()));
        this.u.setOnTouchListener(dVar);
        this.v.setOnTouchListener(dVar);
    }

    private void z() {
        if (this.w.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.g(this);
            int i2 = 1;
            if (u.B(this) == 0) {
                i2 = 2;
            }
            dVar.e(c.e.a.b.f.material_clock_display, i2);
            dVar.c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            z();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = new a();
        LayoutInflater.from(context).inflate(h.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(c.e.a.b.f.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(c.e.a.b.f.material_clock_period_toggle);
        this.w = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.u = (Chip) findViewById(c.e.a.b.f.material_minute_tv);
        this.v = (Chip) findViewById(c.e.a.b.f.material_hour_tv);
        ClockHandView clockHandView = (ClockHandView) findViewById(c.e.a.b.f.material_clock_hand);
        y();
        x();
    }
}
