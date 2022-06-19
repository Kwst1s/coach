package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.github.mikephil.charting.R;

/* compiled from: NumberPicker */
public class c0 extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    private g f10067b;

    /* compiled from: NumberPicker */
    class a implements NumberPicker.OnValueChangeListener {
        a() {
        }

        public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
            numberPicker.setContentDescription(c0.this.getContext().getString(R.string.selected_number) + " " + Integer.toString(i3));
            numberPicker.announceForAccessibility(c0.this.getContext().getString(R.string.selected_number) + " " + Integer.toString(i3));
        }
    }

    /* compiled from: NumberPicker */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            c0.this.dismiss();
        }
    }

    /* compiled from: NumberPicker */
    class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f10070b;

        c(NumberPicker numberPicker) {
            this.f10070b = numberPicker;
        }

        public void onClick(View view) {
            c0.this.f10067b.a(this.f10070b.getValue());
            c0.this.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: NumberPicker */
    public class d implements NumberPicker.OnValueChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f10072a;

        d(String[] strArr) {
            this.f10072a = strArr;
        }

        public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
            numberPicker.setContentDescription(c0.this.getContext().getString(R.string.selected) + " " + this.f10072a[i3]);
            numberPicker.announceForAccessibility(c0.this.getContext().getString(R.string.selected) + " " + this.f10072a[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: NumberPicker */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            c0.this.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: NumberPicker */
    public class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f10075b;

        f(NumberPicker numberPicker) {
            this.f10075b = numberPicker;
        }

        public void onClick(View view) {
            c0.this.f10067b.a(this.f10075b.getValue());
            c0.this.dismiss();
        }
    }

    /* compiled from: NumberPicker */
    public interface g {
        void a(int i2);
    }

    public c0(Context context) {
        super(context);
    }

    public void b(int i2, int i3, g gVar) {
        this.f10067b = gVar;
        requestWindowFeature(1);
        setContentView(R.layout.number_picker_layout);
        Window window = getWindow();
        double p = (double) j.p(getContext());
        Double.isNaN(p);
        window.setLayout((int) (p / 1.2d), -2);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.number_picker_picker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(i3);
        if (i2 == -1) {
            numberPicker.setValue(0);
        } else {
            numberPicker.setValue(i2);
        }
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new a());
        ((TextView) findViewById(R.id.number_picker_txt_cancel)).setOnClickListener(new b());
        ((TextView) findViewById(R.id.number_picker_txt_confirm)).setOnClickListener(new c(numberPicker));
    }

    public void c(int i2, int i3, String[] strArr, g gVar) {
        this.f10067b = gVar;
        requestWindowFeature(1);
        setContentView(R.layout.number_picker_layout);
        Window window = getWindow();
        double p = (double) j.p(getContext());
        Double.isNaN(p);
        window.setLayout((int) (p / 1.2d), -2);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.number_picker_picker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(i3);
        numberPicker.setDescendantFocusability(393216);
        if (i2 == -1) {
            numberPicker.setValue(0);
        } else {
            numberPicker.setValue(i2);
        }
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setOnValueChangedListener(new d(strArr));
        ((TextView) findViewById(R.id.number_picker_txt_cancel)).setOnClickListener(new e());
        ((TextView) findViewById(R.id.number_picker_txt_confirm)).setOnClickListener(new f(numberPicker));
    }
}
