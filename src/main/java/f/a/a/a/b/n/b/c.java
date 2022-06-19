package f.a.a.a.b.n.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import b.a.j;
import com.github.mikephil.charting.R;
import com.github.pavlospt.CircleView;
import f.a.a.a.b.d.i;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_edit_goal;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_edit_goal_txt;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_edit_goal_progress */
public class c extends b implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Act_edit_goal c0;
    private TextView d0;
    private TextView e0;
    private RelativeLayout f0;
    private CircleView g0;
    private TextView h0;
    private TextView i0;
    private AppCompatSeekBar j0;
    private Button k0;
    private i l0;
    private int m0 = -1;
    private boolean n0 = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_edit_goal_progress */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.g0.setStrokeColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static c a2(i iVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("goal", iVar);
        cVar.v1(bundle);
        return cVar;
    }

    public void X1(int i2, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i2), Integer.valueOf(i3));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new a());
        ofObject.start();
    }

    public void Y1() {
        Intent intent = new Intent(n(), Act_edit_goal_txt.class);
        intent.putExtra("content", this.l0.a());
        H1(intent, 10);
    }

    public int Z1(int i2) {
        return (i2 < 0 || i2 >= 10) ? (i2 < 10 || i2 >= 20) ? (i2 < 20 || i2 >= 30) ? (i2 < 30 || i2 >= 40) ? (i2 < 40 || i2 >= 50) ? (i2 < 50 || i2 >= 60) ? (i2 < 60 || i2 >= 70) ? (i2 < 70 || i2 >= 80) ? (i2 < 80 || i2 >= 90) ? (i2 < 90 || i2 >= 100) ? R.string.completely_successful : R.string.highly_succesful : R.string.highly_succesful : R.string.very_succesful : R.string.successful : R.string.successful : R.string.some_success : R.string.some_success : R.string.a_little_success : R.string.tiny_success : R.string.completely_unsuccessful;
    }

    public void b2(int i2) {
        this.i0.setText(Z1(i2));
        if (i2 == -1) {
            X1(this.g0.getFillColor(), Color.rgb(226, 226, 226));
            return;
        }
        switch (i2 / 10) {
            case 1:
                X1(this.g0.getFillColor(), Color.rgb(212, 82, 82));
                return;
            case 2:
                X1(this.g0.getFillColor(), Color.rgb(255, (int) androidx.constraintlayout.widget.i.D0, (int) androidx.constraintlayout.widget.i.D0));
                return;
            case 3:
                X1(this.g0.getFillColor(), Color.rgb(255, 151, (int) androidx.constraintlayout.widget.i.D0));
                return;
            case 4:
                X1(this.g0.getFillColor(), Color.rgb(226, 220, 110));
                return;
            case 5:
                X1(this.g0.getFillColor(), Color.rgb(132, 202, 98));
                return;
            case 6:
                X1(this.g0.getFillColor(), Color.rgb(132, 224, 42));
                return;
            case 7:
                X1(this.g0.getFillColor(), Color.rgb(68, 202, 82));
                return;
            case 8:
                X1(this.g0.getFillColor(), Color.rgb(68, 176, 130));
                return;
            case 9:
                X1(this.g0.getFillColor(), Color.rgb(68, 160, 162));
                return;
            case 10:
                X1(this.g0.getFillColor(), Color.rgb(50, (int) j.I0, 166));
                return;
            default:
                this.g0.setStrokeColor(Color.rgb(212, 82, 82));
                return;
        }
    }

    public void c2() {
        TextView textView = this.h0;
        textView.setText(Integer.toString(this.m0) + "%");
        if (this.m0 == -1) {
            this.k0.setEnabled(false);
        } else {
            this.k0.setEnabled(true);
        }
        b2(this.m0);
    }

    public void d2() {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(this.l0.d());
        if (gov.va.mobilehealth.ncptsd.covid.CComp.j.Q(instance, instance2)) {
            int c2 = this.l0.f().get(this.l0.f().size() - 1).c();
            this.m0 = c2;
            this.j0.setProgress(c2);
            c2();
            this.n0 = true;
        } else {
            this.g0.setStrokeColor(-12303292);
        }
        if (DateUtils.isToday(this.l0.d())) {
            this.e0.setText(R.string.updated_today);
            return;
        }
        DateFormat dateInstance = DateFormat.getDateInstance(3, Locale.getDefault());
        TextView textView = this.e0;
        textView.setText(Q(R.string.last_updated) + ": " + dateInstance.format(Long.valueOf(this.l0.d())));
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        if (i2 == 10 && i3 == -1) {
            this.l0.g(intent.getStringExtra("content"));
            this.d0.setText(this.l0.a());
            new v(n()).H(this.l0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_edit_goal) n();
        if (u() != null) {
            this.l0 = (i) u().getSerializable("goal");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.k0.getId()) {
            if (this.n0) {
                this.l0.f().get(this.l0.f().size() - 1).e(this.m0);
                this.l0.f().get(this.l0.f().size() - 1).d(System.currentTimeMillis());
            } else {
                this.l0.f().add(new f.a.a.a.b.d.j(System.currentTimeMillis(), this.m0));
            }
            this.l0.h(System.currentTimeMillis());
            d.q(p1());
            new v(n()).H(this.l0);
            this.c0.finish();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        this.c0.Y(true);
        this.m0 = seekBar.getProgress();
        c2();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_edit_goal_progress, viewGroup, false);
        this.d0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_goal);
        this.e0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_last_update);
        this.j0 = (AppCompatSeekBar) inflate.findViewById(R.id.edit_goal_seekbar);
        this.f0 = (RelativeLayout) inflate.findViewById(R.id.edit_goal_cview_layout);
        this.g0 = (CircleView) inflate.findViewById(R.id.edit_goal_cview);
        this.h0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_perc);
        this.i0 = (TextView) inflate.findViewById(R.id.edit_goal_txt_result);
        this.k0 = (Button) inflate.findViewById(R.id.edit_goal_btn_submit);
        ViewGroup.LayoutParams layoutParams = this.f0.getLayoutParams();
        double r = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n());
        Double.isNaN(r);
        layoutParams.width = (int) (r / 1.5d);
        ViewGroup.LayoutParams layoutParams2 = this.f0.getLayoutParams();
        double r2 = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n());
        Double.isNaN(r2);
        layoutParams2.height = (int) (r2 / 1.5d);
        this.d0.setText(this.l0.a());
        d2();
        this.k0.setOnClickListener(this);
        this.j0.setOnSeekBarChangeListener(this);
        return inflate;
    }
}
