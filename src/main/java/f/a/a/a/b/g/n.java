package f.a.a.a.b.g;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.f.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_feedback */
public class n extends b {
    private Act_home c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private AppCompatTextView g0;
    private ImageView h0;
    private ImageView i0;

    /* compiled from: Frag_feedback */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            d.k(n.this.Q(R.string.mobileeux));
            if (j.t(n.this.n(), "feedback_disclaimer2", true)) {
                h hVar = new h();
                hVar.X1(1);
                hVar.U1(n.this.v(), BuildConfig.FLAVOR);
                return;
            }
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{"mobileux@va.gov"});
            intent2.putExtra("android.intent.extra.SUBJECT", n.this.Q(R.string.email_subj));
            intent2.setSelector(intent);
            n.this.c0.startActivity(Intent.createChooser(intent2, "Send email..."));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void Y1(View view) {
        this.c0.r0();
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2(View view) {
        if (j.t(n(), "feedback_disclaimer", true)) {
            h hVar = new h();
            hVar.X1(0);
            hVar.U1(v(), BuildConfig.FLAVOR);
        } else if (b0.a(p1()).equals("es")) {
            j.M(n1(), "https://redcap.stanford.edu/surveys/?s=M3WJT33M4D");
        } else {
            j.M(n1(), "https://redcap.stanford.edu/surveys/?s=NPH4YWATPM");
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_feedback, viewGroup, false);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.g0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.h0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.i0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.g0.setText(R.string.send_us_feedback_short);
        AppCompatTextView appCompatTextView = this.g0;
        appCompatTextView.setContentDescription(Q(R.string.send_us_feedback_short) + " " + Q(R.string.heading));
        this.d0.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
        this.h0.setOnClickListener(new a(this));
        this.i0.setVisibility(4);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.send_feedback_container);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.send_feedback_container2);
        g0.k(n(), n().getLayoutInflater(), this.e0, j.N(n(), g.E), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        g0.k(n(), n().getLayoutInflater(), this.f0, j.N(n(), g.F), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        ((Button) inflate.findViewById(R.id.send_feedback_btn)).setOnClickListener(new b(this));
        ((Button) inflate.findViewById(R.id.send_feedback_btn_email)).setOnClickListener(new a());
        return inflate;
    }
}
