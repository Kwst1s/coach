package f.a.a.a.b.a;

import android.app.Dialog;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f0;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.Calendar;

/* compiled from: TimePickerTB */
public class b extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    private int f8868b = 12;

    /* renamed from: c  reason: collision with root package name */
    private int f8869c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8870d = true;

    /* compiled from: TimePickerTB */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8871b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8872c;

        /* renamed from: f.a.a.a.b.a.b$a$a  reason: collision with other inner class name */
        /* compiled from: TimePickerTB */
        class C0182a implements f0.d {
            C0182a() {
            }

            @Override // androidx.appcompat.widget.f0.d
            public boolean onMenuItemClick(MenuItem menuItem) {
                b.this.f8868b = Integer.parseInt(menuItem.getTitle().toString());
                a.this.f8872c.setText(menuItem.getTitle());
                Context context = b.this.getContext();
                LinearLayout linearLayout = a.this.f8871b;
                j.U(context, linearLayout, b.this.getContext().getString(R.string.hour_text) + " " + Integer.toString(b.this.f8868b));
                s.a(a.this.f8871b);
                return true;
            }
        }

        a(LinearLayout linearLayout, TextView textView) {
            this.f8871b = linearLayout;
            this.f8872c = textView;
        }

        public void onClick(View view) {
            f0 f0Var = new f0(b.this.getContext(), this.f8871b);
            f0Var.b().inflate(R.menu.menu_hours, f0Var.a());
            f0Var.d(new C0182a());
            f0Var.e();
        }
    }

    /* renamed from: f.a.a.a.b.a.b$b  reason: collision with other inner class name */
    /* compiled from: TimePickerTB */
    class View$OnClickListenerC0183b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8875b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8876c;

        /* renamed from: f.a.a.a.b.a.b$b$a */
        /* compiled from: TimePickerTB */
        class a implements f0.d {
            a() {
            }

            @Override // androidx.appcompat.widget.f0.d
            public boolean onMenuItemClick(MenuItem menuItem) {
                b.this.f8869c = Integer.parseInt(menuItem.getTitle().toString());
                View$OnClickListenerC0183b.this.f8876c.setText(menuItem.getTitle());
                Context context = b.this.getContext();
                LinearLayout linearLayout = View$OnClickListenerC0183b.this.f8875b;
                j.U(context, linearLayout, b.this.getContext().getString(R.string.minutes) + " " + Integer.toString(b.this.f8869c));
                s.a(View$OnClickListenerC0183b.this.f8875b);
                return true;
            }
        }

        View$OnClickListenerC0183b(LinearLayout linearLayout, TextView textView) {
            this.f8875b = linearLayout;
            this.f8876c = textView;
        }

        public void onClick(View view) {
            f0 f0Var = new f0(b.this.getContext(), this.f8875b);
            f0Var.b().inflate(R.menu.menu_minutes, f0Var.a());
            f0Var.d(new a());
            f0Var.e();
        }
    }

    /* compiled from: TimePickerTB */
    class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8879b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8880c;

        /* compiled from: TimePickerTB */
        class a implements f0.d {
            a() {
            }

            @Override // androidx.appcompat.widget.f0.d
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.am) {
                    b.this.f8870d = true;
                    c.this.f8880c.setText("AM");
                    j.U(b.this.getContext(), c.this.f8879b, "AM");
                } else if (itemId == R.id.pm) {
                    b.this.f8870d = false;
                    c.this.f8880c.setText("PM");
                    j.U(b.this.getContext(), c.this.f8879b, "PM");
                }
                s.a(c.this.f8879b);
                return true;
            }
        }

        c(LinearLayout linearLayout, TextView textView) {
            this.f8879b = linearLayout;
            this.f8880c = textView;
        }

        public void onClick(View view) {
            f0 f0Var = new f0(b.this.getContext(), this.f8879b);
            f0Var.b().inflate(R.menu.menu_ampm, f0Var.a());
            f0Var.d(new a());
            f0Var.e();
        }
    }

    /* compiled from: TimePickerTB */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* compiled from: TimePickerTB */
    class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f8884b;

        e(f fVar) {
            this.f8884b = fVar;
        }

        public void onClick(View view) {
            int i2;
            if (!b.this.f8870d) {
                i2 = b.this.f8868b;
                if (b.this.f8868b != 12) {
                    i2 = b.this.f8868b + 12;
                }
            } else if (b.this.f8868b == 12) {
                i2 = 0;
            } else {
                i2 = b.this.f8868b;
            }
            this.f8884b.a(i2, b.this.f8869c);
            b.this.dismiss();
        }
    }

    /* compiled from: TimePickerTB */
    public interface f {
        void a(int i2, int i3);
    }

    public b(Context context) {
        super(context);
    }

    public void g(String str, long j2, f fVar) {
        requestWindowFeature(1);
        setContentView(R.layout.time_picker_layout);
        getWindow().setLayout(j.p(getContext()), -2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.time_picker_hour_layout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.time_picker_minutes_layout);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.time_picker_ampm_layout);
        TextView textView = (TextView) findViewById(R.id.time_picker_hour_txt);
        TextView textView2 = (TextView) findViewById(R.id.time_picker_minutes_txt);
        TextView textView3 = (TextView) findViewById(R.id.time_picker_amppm_txt);
        ((TextView) findViewById(R.id.time_picker_title)).setText(str);
        if (j2 != -1) {
            Calendar d2 = s.d();
            d2.setTimeInMillis(j2);
            int i2 = d2.get(11);
            this.f8869c = d2.get(12);
            if (i2 == 0) {
                this.f8870d = true;
                this.f8868b = 12;
            } else if (i2 == 12) {
                this.f8870d = false;
            } else if (i2 > 12) {
                this.f8868b = i2 - 12;
                this.f8870d = false;
            } else {
                this.f8868b = i2;
                this.f8870d = true;
            }
            textView.setText(String.format("%02d", Integer.valueOf(this.f8868b)));
            textView2.setText(String.format("%02d", Integer.valueOf(this.f8869c)));
            Context context = getContext();
            j.U(context, linearLayout, getContext().getString(R.string.hour_text) + " " + Integer.toString(this.f8868b));
            Context context2 = getContext();
            j.U(context2, linearLayout2, getContext().getString(R.string.minutes) + " " + Integer.toString(this.f8869c));
            if (this.f8870d) {
                textView3.setText("AM");
                j.U(getContext(), linearLayout3, "AM");
            } else {
                textView3.setText("PM");
                j.U(getContext(), linearLayout3, "PM");
            }
        } else {
            Context context3 = getContext();
            j.U(context3, linearLayout, getContext().getString(R.string.hour_text) + " " + Integer.toString(12));
            Context context4 = getContext();
            j.U(context4, linearLayout2, getContext().getString(R.string.minutes) + " " + Integer.toString(0));
            j.U(getContext(), linearLayout3, "AM");
        }
        linearLayout.setOnClickListener(new a(linearLayout, textView));
        linearLayout2.setOnClickListener(new View$OnClickListenerC0183b(linearLayout2, textView2));
        linearLayout3.setOnClickListener(new c(linearLayout3, textView3));
        ((TextView) findViewById(R.id.duration_picker_txt_cancel)).setOnClickListener(new d());
        ((TextView) findViewById(R.id.duration_picker_txt_confirm)).setOnClickListener(new e(fVar));
    }
}
