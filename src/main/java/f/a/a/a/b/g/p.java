package f.a.a.a.b.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import b.h.d.a;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import vainstrum.Components.b;

/* compiled from: Frag_how_to_use */
public class p extends b {
    private Act_home c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private AppCompatTextView f0;
    private ImageView g0;
    private ImageView h0;

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(View view) {
        this.c0.r0();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_how_to_use, viewGroup, false);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.f0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.g0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.h0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.how_to_use_layout_content);
        this.f0.setText(R.string.how_to_use_short);
        AppCompatTextView appCompatTextView = this.f0;
        appCompatTextView.setContentDescription(Q(R.string.how_to_use_short) + " " + Q(R.string.heading));
        this.d0.setBackgroundColor(a.b(n(), R.color.colorPrimary));
        this.g0.setOnClickListener(new c(this));
        try {
            g0.k(n(), D(), this.e0, j.N(n(), g.N), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.h0.setVisibility(4);
        return inflate;
    }
}
