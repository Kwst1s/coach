package f.a.a.a.b.l.m0;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.i;
import b.a.j;
import com.github.mikephil.charting.R;
import com.github.pavlospt.CircleView;
import f.a.a.a.b.d.h;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_my_feeling;
import java.util.ArrayList;

/* compiled from: Frag_my_feelings_stress */
public class d extends vainstrum.Components.b implements SeekBar.OnSeekBarChangeListener {
    private Act_new_my_feeling c0;
    private AppCompatSeekBar d0;
    private CircleView e0;
    private RelativeLayout f0;
    private TextView g0;
    private TextView h0;
    private LinearLayout i0;
    private ArrayList<h> j0;
    private BroadcastReceiver k0;
    private int l0 = -1;

    /* compiled from: Frag_my_feelings_stress */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_NEXT")) {
                k.b.d.k("Stress level: " + d.this.l0);
                d.this.c0.a0(c.Z1(-1, d.this.j0, d.this.l0), d.this.Q(R.string.my_feelings));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_my_feelings_stress */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.e0.setStrokeColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static d d2(ArrayList<h> arrayList) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("feelings", arrayList);
        dVar.v1(bundle);
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.k0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_NEXT");
        this.k0 = new a();
        try {
            n().registerReceiver(this.k0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void a2(int i2, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i2), Integer.valueOf(i3));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new b());
        ofObject.start();
    }

    public void b2() {
        if (this.l0 != -1) {
            this.c0.c0().setEnabled(true);
            this.c0.c0().setTextColor(b.h.d.a.b(n(), 17170443));
            return;
        }
        this.c0.c0().setEnabled(false);
        this.c0.c0().setTextColor(b.h.d.a.b(n(), 17170432));
    }

    public int c2(int i2) {
        switch (i2 / 10) {
            case 0:
                return R.string.peace_serenity;
            case 1:
                return R.string.relaxed_no_stressed;
            case 2:
                return R.string.bit_upset;
            case 3:
                return R.string.slightly_upset;
            case 4:
                return R.string.mild_stress;
            case 5:
                return R.string.mild_to_moderate;
            case 6:
                return R.string.moderate_stress;
            case 7:
                return R.string.moderate_high;
            case 8:
                return R.string.high_stress;
            case 9:
                return R.string.high_to_extreme;
            case 10:
                return R.string.extreme_stress;
            default:
                return R.string.none;
        }
    }

    public String e2(int i2) {
        int c2 = c2(i2);
        this.h0.setText(c2);
        LinearLayout linearLayout = this.i0;
        linearLayout.setContentDescription(Integer.toString(this.l0) + "%\n" + Q(c2(i2)));
        if (i2 != -1) {
            switch (i2 / 10) {
                case 1:
                    a2(this.e0.getFillColor(), Color.rgb(68, 160, 162));
                    break;
                case 2:
                    a2(this.e0.getFillColor(), Color.rgb(68, 176, 130));
                    break;
                case 3:
                    a2(this.e0.getFillColor(), Color.rgb(68, 202, 82));
                    break;
                case 4:
                    a2(this.e0.getFillColor(), Color.rgb(132, 224, 42));
                    break;
                case 5:
                    a2(this.e0.getFillColor(), Color.rgb(132, 202, 98));
                    break;
                case 6:
                    a2(this.e0.getFillColor(), Color.rgb(226, 220, 110));
                    break;
                case 7:
                    a2(this.e0.getFillColor(), Color.rgb(255, 151, (int) i.D0));
                    break;
                case 8:
                    a2(this.e0.getFillColor(), Color.rgb(255, (int) i.D0, (int) i.D0));
                    break;
                case 9:
                    a2(this.e0.getFillColor(), Color.rgb(212, 82, 82));
                    break;
                case 10:
                    a2(this.e0.getFillColor(), Color.rgb(151, 19, 19));
                    break;
                default:
                    a2(this.e0.getFillColor(), Color.rgb(50, (int) j.I0, 166));
                    break;
            }
        } else {
            a2(this.e0.getFillColor(), Color.rgb(226, 226, 226));
        }
        return Q(c2);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_new_my_feeling) n();
        if (u() != null) {
            this.j0 = (ArrayList) u().getSerializable("feelings");
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        this.l0 = i2;
        this.g0.announceForAccessibility(Q(c2(i2)));
        TextView textView = this.g0;
        textView.setText(this.l0 + "%");
        e2(this.l0);
        b2();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.g0.announceForAccessibility(Q(c2(this.l0)));
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_my_feelings_stress, viewGroup, false);
        this.d0 = (AppCompatSeekBar) inflate.findViewById(R.id.my_feelings_stress_seekbar);
        this.e0 = (CircleView) inflate.findViewById(R.id.my_feelings_stress_cview);
        this.f0 = (RelativeLayout) inflate.findViewById(R.id.my_feelings_stress_cview_layout);
        this.g0 = (TextView) inflate.findViewById(R.id.my_feelings_stress_txt_perc);
        this.h0 = (TextView) inflate.findViewById(R.id.my_feelings_stress_txt_result);
        this.i0 = (LinearLayout) inflate.findViewById(R.id.my_feelings_stress_layout_perc);
        ViewGroup.LayoutParams layoutParams = this.f0.getLayoutParams();
        double r = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n());
        Double.isNaN(r);
        layoutParams.height = (int) (r / 1.4d);
        this.d0.setOnSeekBarChangeListener(this);
        b2();
        this.c0.c0().setText(R.string.next);
        return inflate;
    }
}
