package f.a.a.a.b.n.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.i;
import b.a.j;
import com.github.mikephil.charting.R;
import com.github.pavlospt.CircleView;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_new_goal;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_create_goal_progress */
public class a extends b implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Act_new_goal c0;
    private RelativeLayout d0;
    private CircleView e0;
    private TextView f0;
    private TextView g0;
    private TextView h0;
    private AppCompatSeekBar i0;
    private Button j0;

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.n.b.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_create_goal_progress */
    public class C0214a implements ValueAnimator.AnimatorUpdateListener {
        C0214a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.e0.setStrokeColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public void X1(int i2, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i2), Integer.valueOf(i3));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new C0214a());
        ofObject.start();
    }

    public int Y1(int i2) {
        return (i2 < 0 || i2 >= 10) ? (i2 < 10 || i2 >= 20) ? (i2 < 20 || i2 >= 30) ? (i2 < 30 || i2 >= 40) ? (i2 < 40 || i2 >= 50) ? (i2 < 50 || i2 >= 60) ? (i2 < 60 || i2 >= 70) ? (i2 < 70 || i2 >= 80) ? (i2 < 80 || i2 >= 90) ? (i2 < 90 || i2 >= 100) ? R.string.completely_successful : R.string.highly_succesful : R.string.highly_succesful : R.string.very_succesful : R.string.successful : R.string.successful : R.string.some_success : R.string.some_success : R.string.a_little_success : R.string.tiny_success : R.string.completely_unsuccessful;
    }

    public void Z1(int i2) {
        this.g0.setText(Y1(i2));
        if (i2 == -1) {
            X1(this.e0.getFillColor(), -3355444);
            return;
        }
        switch (i2 / 10) {
            case 1:
                X1(this.e0.getFillColor(), Color.rgb(212, 82, 82));
                return;
            case 2:
                X1(this.e0.getFillColor(), Color.rgb(255, (int) i.D0, (int) i.D0));
                return;
            case 3:
                X1(this.e0.getFillColor(), Color.rgb(255, 151, (int) i.D0));
                return;
            case 4:
                X1(this.e0.getFillColor(), Color.rgb(226, 220, 110));
                return;
            case 5:
                X1(this.e0.getFillColor(), Color.rgb(132, 202, 98));
                return;
            case 6:
                X1(this.e0.getFillColor(), Color.rgb(132, 224, 42));
                return;
            case 7:
                X1(this.e0.getFillColor(), Color.rgb(68, 202, 82));
                return;
            case 8:
                X1(this.e0.getFillColor(), Color.rgb(68, 176, 130));
                return;
            case 9:
                X1(this.e0.getFillColor(), Color.rgb(68, 160, 162));
                return;
            case 10:
                X1(this.e0.getFillColor(), Color.rgb(50, (int) j.I0, 166));
                return;
            default:
                this.e0.setStrokeColor(Color.rgb(212, 82, 82));
                return;
        }
    }

    public void a2() {
        TextView textView = this.f0;
        textView.setText(Integer.toString(this.c0.X()) + "%");
        if (this.c0.X() == -1) {
            this.j0.setEnabled(false);
        } else {
            this.j0.setEnabled(true);
            this.j0.setTextColor(b.h.d.a.b(n(), 17170443));
        }
        Z1(this.c0.X());
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_new_goal) n1();
    }

    public void onClick(View view) {
        if (view.getId() == this.j0.getId() && this.c0 != null) {
            d.o(p1());
            v vVar = new v(n());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f.a.a.a.b.d.j(System.currentTimeMillis(), this.c0.X()));
            vVar.l(new f.a.a.a.b.d.i(this.c0.Y(), arrayList));
            this.c0.finish();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        this.c0.f0(i2);
        this.c0.e0(true);
        a2();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_create_goal_progress, viewGroup, false);
        this.h0 = (TextView) inflate.findViewById(R.id.create_goal_txt_goal);
        this.i0 = (AppCompatSeekBar) inflate.findViewById(R.id.edit_goal_seekbar);
        this.j0 = (Button) inflate.findViewById(R.id.create_goal_btn_submit);
        this.d0 = (RelativeLayout) inflate.findViewById(R.id.edit_goal_cview_layout);
        this.e0 = (CircleView) inflate.findViewById(R.id.edit_goal_cview);
        this.f0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_perc);
        this.g0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_result);
        ViewGroup.LayoutParams layoutParams = this.d0.getLayoutParams();
        double r = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n());
        Double.isNaN(r);
        layoutParams.width = (int) (r / 1.5d);
        ViewGroup.LayoutParams layoutParams2 = this.d0.getLayoutParams();
        double r2 = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n());
        Double.isNaN(r2);
        layoutParams2.height = (int) (r2 / 1.5d);
        this.e0.setStrokeColor(-3355444);
        this.j0.setOnClickListener(this);
        this.i0.setOnSeekBarChangeListener(this);
        this.h0.setText(this.c0.Y());
        return inflate;
    }
}
