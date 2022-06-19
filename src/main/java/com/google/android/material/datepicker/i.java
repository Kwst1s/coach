package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.h.k.u;
import c.e.a.b.c0.g;
import c.e.a.b.e;
import c.e.a.b.f;
import c.e.a.b.h;
import c.e.a.b.j;
import c.e.a.b.k;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: MaterialDatePicker */
public final class i<S> extends androidx.fragment.app.c {
    static final Object C0 = "CONFIRM_BUTTON_TAG";
    static final Object D0 = "CANCEL_BUTTON_TAG";
    static final Object E0 = "TOGGLE_BUTTON_TAG";
    private g A0;
    private Button B0;
    private final LinkedHashSet<j<? super S>> l0 = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> m0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> n0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> o0 = new LinkedHashSet<>();
    private int p0;
    private d<S> q0;
    private p<S> r0;
    private a s0;
    private h<S> t0;
    private int u0;
    private CharSequence v0;
    private boolean w0;
    private int x0;
    private TextView y0;
    private CheckableImageButton z0;

    /* compiled from: MaterialDatePicker */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.material.datepicker.j */
        /* JADX WARN: Multi-variable type inference failed */
        public void onClick(View view) {
            Iterator it = i.this.l0.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.h2());
            }
            i.this.M1();
        }
    }

    /* compiled from: MaterialDatePicker */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Iterator it = i.this.m0.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            i.this.M1();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialDatePicker */
    public class c extends o<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s) {
            i.this.m2();
            i.this.B0.setEnabled(i.this.q0.e());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MaterialDatePicker */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            i.this.B0.setEnabled(i.this.q0.e());
            i.this.z0.toggle();
            i iVar = i.this;
            iVar.n2(iVar.z0);
            i.this.l2();
        }
    }

    private static Drawable d2(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, b.a.k.a.a.d(context, e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], b.a.k.a.a.d(context, e.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int e2(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(c.e.a.b.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(c.e.a.b.d.mtrl_calendar_days_of_week_height);
        int i2 = m.f7723g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(c.e.a.b.d.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_bottom_padding);
    }

    private static int g2(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_content_padding);
        int i2 = l.m().f7719e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(c.e.a.b.d.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_month_horizontal_padding));
    }

    private int i2(Context context) {
        int i2 = this.p0;
        if (i2 != 0) {
            return i2;
        }
        return this.q0.b(context);
    }

    private void j2(Context context) {
        this.z0.setTag(E0);
        this.z0.setImageDrawable(d2(context));
        this.z0.setChecked(this.x0 != 0);
        u.m0(this.z0, null);
        n2(this.z0);
        this.z0.setOnClickListener(new d());
    }

    static boolean k2(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.e.a.b.z.b.c(context, c.e.a.b.b.materialCalendarStyle, h.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l2() {
        int i2 = i2(p1());
        this.t0 = h.b2(this.q0, i2, this.s0);
        this.r0 = this.z0.isChecked() ? k.M1(this.q0, i2, this.s0) : this.t0;
        m2();
        androidx.fragment.app.u j2 = v().j();
        j2.p(f.mtrl_calendar_frame, this.r0);
        j2.k();
        this.r0.K1(new c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m2() {
        String f2 = f2();
        this.y0.setContentDescription(String.format(Q(j.mtrl_picker_announce_current_selection), f2));
        this.y0.setText(f2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n2(CheckableImageButton checkableImageButton) {
        String str;
        if (this.z0.isChecked()) {
            str = checkableImageButton.getContext().getString(j.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(j.mtrl_picker_toggle_to_text_input_mode);
        }
        this.z0.setContentDescription(str);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void K0(Bundle bundle) {
        super.K0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.p0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.q0);
        a.b bVar = new a.b(this.s0);
        if (this.t0.X1() != null) {
            bVar.b(this.t0.X1().f7721g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.u0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.v0);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        Window window = R1().getWindow();
        if (this.w0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.A0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = K().getDimensionPixelOffset(c.e.a.b.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.A0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new c.e.a.b.t.a(R1(), rect));
        }
        l2();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void M0() {
        this.r0.L1();
        super.M0();
    }

    @Override // androidx.fragment.app.c
    public final Dialog Q1(Bundle bundle) {
        Dialog dialog = new Dialog(p1(), i2(p1()));
        Context context = dialog.getContext();
        this.w0 = k2(context);
        int c2 = c.e.a.b.z.b.c(context, c.e.a.b.b.colorSurface, i.class.getCanonicalName());
        g gVar = new g(context, null, c.e.a.b.b.materialCalendarStyle, k.Widget_MaterialComponents_MaterialCalendar);
        this.A0 = gVar;
        gVar.M(context);
        this.A0.X(ColorStateList.valueOf(c2));
        this.A0.W(u.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public String f2() {
        return this.q0.a(w());
    }

    public final S h2() {
        return this.q0.h();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void o0(Bundle bundle) {
        super.o0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.p0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.q0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.s0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.u0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.v0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.x0 = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.c
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.n0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.o0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) T();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public final View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.w0 ? h.mtrl_picker_fullscreen : h.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.w0) {
            inflate.findViewById(f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(g2(context), -2));
        } else {
            View findViewById = inflate.findViewById(f.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(f.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(g2(context), -1));
            findViewById2.setMinimumHeight(e2(p1()));
        }
        TextView textView = (TextView) inflate.findViewById(f.mtrl_picker_header_selection_text);
        this.y0 = textView;
        u.o0(textView, 1);
        this.z0 = (CheckableImageButton) inflate.findViewById(f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(f.mtrl_picker_title_text);
        CharSequence charSequence = this.v0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.u0);
        }
        j2(context);
        this.B0 = (Button) inflate.findViewById(f.confirm_button);
        if (this.q0.e()) {
            this.B0.setEnabled(true);
        } else {
            this.B0.setEnabled(false);
        }
        this.B0.setTag(C0);
        this.B0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(f.cancel_button);
        button.setTag(D0);
        button.setOnClickListener(new b());
        return inflate;
    }
}
