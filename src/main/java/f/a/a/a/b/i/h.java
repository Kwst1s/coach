package f.a.a.a.b.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import b.h.d.e.f;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.VerticalSeekBar;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.b;

/* compiled from: Frag_distress_meter */
public class h extends b implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private Act_manage c0;
    private VerticalSeekBar d0;
    private ImageView e0;
    private ImageView f0;
    private AppCompatTextView g0;
    private AppCompatTextView h0;
    private ImageButton i0;
    private ImageButton j0;
    private ButtonTracking k0;
    private ButtonTracking l0;
    private b0 m0;
    private a0 n0;
    private int o0;
    private String p0;
    private int q0 = -1;

    public static h W1(b0 b0Var, a0 a0Var, int i2, String str) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        hVar.v1(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
    }

    public void X1() {
        String str = Q(R.string.distress_level_thermometer) + " " + Q(R.string.level) + " " + this.q0;
        if (this.q0 > 8) {
            this.h0.setTypeface(f.b(n(), R.font.font_semibold));
        } else {
            this.h0.setTypeface(f.b(n(), R.font.font_regular));
        }
        int i2 = this.q0;
        if (i2 == -1) {
            this.h0.setText("--");
            this.h0.setContentDescription(Q(R.string.set_your_distress_level_with_distress_meter));
            this.k0.setEnabled(false);
        } else {
            this.h0.setText(Integer.toString(i2));
            this.h0.setContentDescription(str);
            this.k0.setEnabled(true);
        }
        this.d0.setContentDescription(str);
        this.d0.announceForAccessibility(str);
    }

    public void Y1(View view, float f2) {
        float e2 = (float) ((int) j.e(6.0f, n()));
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_10).getLayoutParams()).setMargins(0, (int) e2, 0, 0);
        float e3 = e2 - ((float) ((int) j.e(3.0f, n())));
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_9).getLayoutParams()).setMargins(0, (int) ((0.1f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_8).getLayoutParams()).setMargins(0, (int) ((0.2f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_7).getLayoutParams()).setMargins(0, (int) ((0.3f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_6).getLayoutParams()).setMargins(0, (int) ((0.4f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_5).getLayoutParams()).setMargins(0, (int) ((0.5f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_4).getLayoutParams()).setMargins(0, (int) ((0.59f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_3).getLayoutParams()).setMargins(0, (int) ((0.69f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_2).getLayoutParams()).setMargins(0, (int) ((0.79f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_1).getLayoutParams()).setMargins(0, (int) ((0.89f * f2) + e3), 0, 0);
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.distress_meter_line_0).getLayoutParams()).setMargins(0, (int) (e3 + (f2 * 0.99f)), 0, 0);
    }

    public void Z1() {
        int i2;
        double q = (double) j.q(n());
        Double.isNaN(q);
        double k2 = (double) j.k(n());
        Double.isNaN(k2);
        int i3 = (int) ((q / 2.75d) - k2);
        int r = j.r(n()) / 10;
        double r2 = (double) j.r(n());
        Double.isNaN(r2);
        int i4 = (int) (r2 / 4.7d);
        double r3 = (double) j.r(n());
        Double.isNaN(r3);
        int i5 = (int) (r3 / 6.3d);
        this.d0.setPadding(0, 0, 0, 0);
        this.f0.getLayoutParams().width = i4;
        this.f0.getLayoutParams().height = i4;
        this.e0.getLayoutParams().width = i5;
        this.e0.getLayoutParams().height = i5;
        int i6 = i4 - i5;
        if (j.E(n()) || j.J(n())) {
            i2 = K().getDimensionPixelOffset(R.dimen.padding_small);
        } else {
            i2 = K().getDimensionPixelOffset(R.dimen.padding_large) + K().getDimensionPixelOffset(R.dimen.padding_x_small) + K().getDimensionPixelOffset(R.dimen.padding_xx_small);
        }
        this.d0.setMinimumWidth(r);
        this.d0.getLayoutParams().width = r;
        this.d0.setMinimumHeight(i3);
        this.d0.getLayoutParams().height = i3;
        ImageView imageView = this.f0;
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = d2 * 1.73d;
        imageView.setY((float) (-d3));
        ImageView imageView2 = this.e0;
        double d4 = (double) (((float) i6) / 2.0f);
        Double.isNaN(d4);
        imageView2.setY((float) (-(d3 - d4)));
        this.k0.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        m.O0(n(), this.d0);
        int i7 = this.q0;
        if (i7 == -1) {
            this.d0.setProgress(5);
            this.k0.setEnabled(false);
            return;
        }
        this.d0.setProgress(i7);
        X1();
        this.l0.setEnabled(true);
        this.l0.setText(R.string.next);
        this.l0.setContentDescription(Q(R.string.next));
        this.l0.setTrackingId("28344");
        this.k0.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (u() != null) {
            this.m0 = (b0) u().getSerializable("tool");
            this.n0 = (a0) u().getSerializable("symptom");
            this.o0 = u().getInt("old_distress");
            this.p0 = u().getString("last_tool_name");
            int i2 = this.o0;
            if (i2 != -1) {
                this.q0 = i2;
            }
        }
        C1(true);
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == this.l0.getId()) {
            if (this.l0.getText().toString().equals(Q(R.string.next))) {
                d.a("Distress value: " + this.q0);
                this.k0.callOnClick();
            } else {
                d.a("Distress value: " + this.q0);
                m.c0(true, this.c0, this.n0, this.m0, -1);
            }
        }
        if (view.getId() == this.k0.getId()) {
            int i2 = this.q0;
            if (i2 == -1) {
                Toast.makeText(n(), (int) R.string.set_your_distress_level_with_distress_meter, 1).show();
            } else if (this.o0 == -1) {
                this.c0.e0(i2);
                if (this.q0 >= 9) {
                    d.a("Distress value: " + this.q0);
                    j W1 = j.W1(this.m0, this.n0, this.q0, this.p0);
                    W1.V1(R1());
                    this.c0.W(W1, Q(R.string.crisis));
                } else {
                    d.a("Distress value: " + this.q0);
                    m.c0(true, this.c0, this.n0, this.m0, this.q0);
                }
            } else {
                this.c0.d0(i2);
                if (this.o0 == this.q0) {
                    str = Q(R.string.distress_unchanged);
                } else {
                    str = Q(R.string.distress_changed);
                }
                d.a("Distress value: " + this.q0);
                g W12 = g.W1(this.m0, this.n0, this.o0, this.q0, this.p0);
                W12.V1(R1());
                this.c0.W(W12, str);
            }
        }
        if (view.getId() == this.j0.getId()) {
            VerticalSeekBar verticalSeekBar = this.d0;
            verticalSeekBar.setProgress(verticalSeekBar.getProgress() - 1);
            this.d0.invalidate();
            this.q0 = this.d0.getProgress();
            X1();
        }
        if (view.getId() == this.i0.getId()) {
            VerticalSeekBar verticalSeekBar2 = this.d0;
            verticalSeekBar2.setProgress(verticalSeekBar2.getProgress() + 1);
            this.d0.invalidate();
            this.q0 = this.d0.getProgress();
            X1();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        this.q0 = i2;
        seekBar.invalidate();
        X1();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_distress_meter, (ViewGroup) null);
        this.d0 = (VerticalSeekBar) inflate.findViewById(R.id.distress_meter_seekbar);
        this.e0 = (ImageView) inflate.findViewById(R.id.distress_meter_img_bottom);
        this.k0 = (ButtonTracking) inflate.findViewById(R.id.distress_meter_btn_next);
        this.l0 = (ButtonTracking) inflate.findViewById(R.id.distress_meter_btn_skip);
        this.g0 = (AppCompatTextView) inflate.findViewById(R.id.distress_meter_txt_tap_up_down);
        this.h0 = (AppCompatTextView) inflate.findViewById(R.id.distress_meter_txt_label);
        this.i0 = (ImageButton) inflate.findViewById(R.id.distress_meter_btn_distress_up);
        this.j0 = (ImageButton) inflate.findViewById(R.id.distress_meter_btn_distress_down);
        this.f0 = (ImageView) inflate.findViewById(R.id.distress_meter_img_bottom_white);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.distress_meter_line_layout);
        if (this.o0 != -1 && bundle == null) {
            j.V(n(), Q(R.string.good_job_completing_tool_rate_in_distress));
        }
        if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(n()).equals("es")) {
            this.g0.setVisibility(4);
        } else {
            this.g0.setVisibility(0);
        }
        Z1();
        double q = (double) j.q(n());
        Double.isNaN(q);
        double k2 = (double) j.k(n());
        Double.isNaN(k2);
        Y1(inflate, (float) ((q / 2.75d) - k2));
        this.d0.setOnSeekBarChangeListener(this);
        X1();
        return inflate;
    }
}
