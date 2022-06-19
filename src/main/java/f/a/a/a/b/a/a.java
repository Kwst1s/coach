package f.a.a.a.b.a;

import android.app.Dialog;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f0;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;

/* compiled from: NumberPickerTB */
public class a extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    private int f8851b = 0;

    /* renamed from: c  reason: collision with root package name */
    private i f8852c;

    /* renamed from: f.a.a.a.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: NumberPickerTB */
    class C0181a implements f0.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f8854b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String[] f8855c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8856d;

        C0181a(boolean z, TextView textView, String[] strArr, LinearLayout linearLayout) {
            this.f8853a = z;
            this.f8854b = textView;
            this.f8855c = strArr;
            this.f8856d = linearLayout;
        }

        @Override // androidx.appcompat.widget.f0.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            a.this.f8851b = menuItem.getItemId();
            if (this.f8853a) {
                a.this.f8851b++;
            }
            this.f8854b.setText(this.f8855c[menuItem.getItemId()]);
            this.f8856d.setContentDescription(a.this.getContext().getString(R.string.selected) + " " + this.f8855c[menuItem.getItemId()] + " " + a.this.getContext().getString(R.string.button));
            s.a(this.f8856d);
            return true;
        }
    }

    /* compiled from: NumberPickerTB */
    class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f8858b;

        b(a aVar, f0 f0Var) {
            this.f8858b = f0Var;
        }

        public void onClick(View view) {
            this.f8858b.e();
        }
    }

    /* compiled from: NumberPickerTB */
    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* compiled from: NumberPickerTB */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            a.this.f8852c.a(a.this.f8851b);
            a.this.dismiss();
        }
    }

    /* compiled from: NumberPickerTB */
    class e implements f0.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f8861a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f8862b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8863c;

        e(TextView textView, String[] strArr, LinearLayout linearLayout) {
            this.f8861a = textView;
            this.f8862b = strArr;
            this.f8863c = linearLayout;
        }

        @Override // androidx.appcompat.widget.f0.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            a.this.f8851b = menuItem.getItemId();
            this.f8861a.setText(this.f8862b[a.this.f8851b]);
            LinearLayout linearLayout = this.f8863c;
            linearLayout.setContentDescription(a.this.getContext().getString(R.string.selected) + " " + this.f8862b[a.this.f8851b] + " " + a.this.getContext().getString(R.string.button));
            s.a(this.f8863c);
            return true;
        }
    }

    /* compiled from: NumberPickerTB */
    class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f8865b;

        f(a aVar, f0 f0Var) {
            this.f8865b = f0Var;
        }

        public void onClick(View view) {
            this.f8865b.e();
        }
    }

    /* compiled from: NumberPickerTB */
    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* compiled from: NumberPickerTB */
    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View view) {
            a.this.f8852c.a(a.this.f8851b);
            a.this.dismiss();
        }
    }

    /* compiled from: NumberPickerTB */
    public interface i {
        void a(int i2);
    }

    public a(Context context) {
        super(context);
    }

    public void d(String str, int i2, int i3, i iVar) {
        this.f8852c = iVar;
        requestWindowFeature(1);
        setContentView(R.layout.number_picker_layout_tb);
        Window window = getWindow();
        double p = (double) j.p(getContext());
        Double.isNaN(p);
        window.setLayout((int) (p / 1.1d), -2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.number_picker_layout);
        TextView textView = (TextView) findViewById(R.id.number_picker_txt);
        ((TextView) findViewById(R.id.number_picker_title)).setText(str);
        String[] strArr = new String[i3];
        f0 f0Var = new f0(getContext(), linearLayout);
        for (int i4 = 1; i4 < i3; i4++) {
            strArr[i4] = Integer.toString(i4);
            f0Var.a().add(-1, i4, i4, strArr[i4]);
        }
        if (i2 == -1) {
            this.f8851b = 0;
        } else {
            this.f8851b = i2;
        }
        textView.setText(strArr[this.f8851b]);
        linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + strArr[this.f8851b]);
        f0Var.d(new e(textView, strArr, linearLayout));
        linearLayout.setOnClickListener(new f(this, f0Var));
        if (i2 == -1) {
            this.f8851b = 0;
        } else {
            this.f8851b = i2;
        }
        ((TextView) findViewById(R.id.number_picker_txt_cancel)).setOnClickListener(new g());
        ((TextView) findViewById(R.id.number_picker_txt_confirm)).setOnClickListener(new h());
    }

    public void e(String str, int i2, int i3, String[] strArr, i iVar, boolean z) {
        this.f8852c = iVar;
        requestWindowFeature(1);
        setContentView(R.layout.number_picker_layout_tb);
        Window window = getWindow();
        double p = (double) j.p(getContext());
        Double.isNaN(p);
        window.setLayout((int) (p / 1.1d), -2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.number_picker_layout);
        TextView textView = (TextView) findViewById(R.id.number_picker_txt);
        ((TextView) findViewById(R.id.number_picker_title)).setText(str);
        f0 f0Var = new f0(getContext(), linearLayout);
        for (int i4 = 0; i4 < i3; i4++) {
            f0Var.a().add(-1, i4, i4, strArr[i4]);
        }
        if (i2 <= -1) {
            this.f8851b = 0;
        } else {
            this.f8851b = i2;
        }
        if (z) {
            int i5 = this.f8851b;
            if (i5 > 28) {
                textView.setText(R.string.last_day);
            } else {
                textView.setText(Integer.toString(i5));
            }
            int i6 = this.f8851b;
            if (i6 == 0) {
                linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + strArr[this.f8851b] + " " + getContext().getString(R.string.button));
            } else if (i6 > 28) {
                linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + getContext().getString(R.string.last_day) + " " + getContext().getString(R.string.button));
            } else {
                linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + strArr[this.f8851b - 1] + " " + getContext().getString(R.string.button));
            }
        } else {
            int i7 = this.f8851b;
            if (i7 > 28) {
                textView.setText(R.string.last_day);
                linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + getContext().getString(R.string.last_day) + " " + getContext().getString(R.string.button));
            } else {
                textView.setText(strArr[i7 - 1]);
                linearLayout.setContentDescription(getContext().getString(R.string.selected) + " " + strArr[this.f8851b - 1] + " " + getContext().getString(R.string.button));
            }
        }
        f0Var.d(new C0181a(z, textView, strArr, linearLayout));
        linearLayout.setOnClickListener(new b(this, f0Var));
        if (i2 == -1) {
            this.f8851b = 0;
        } else {
            this.f8851b = i2;
        }
        ((TextView) findViewById(R.id.number_picker_txt_cancel)).setOnClickListener(new c());
        ((TextView) findViewById(R.id.number_picker_txt_confirm)).setOnClickListener(new d());
    }
}
