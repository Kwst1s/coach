package f.a.a.a.b.g;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;

/* compiled from: Frag_share_app */
public class t extends vainstrum.Components.b {
    private Act_home c0;
    private ImageView d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private AppCompatTextView g0;
    private ImageView h0;
    private ImageView i0;

    /* compiled from: Frag_share_app */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            t.this.c0.r0();
        }
    }

    /* compiled from: Frag_share_app */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            if (b0.a(t.this.c0).equals("es")) {
                intent.putExtra("android.intent.extra.TEXT", "¡Conozca COVID Coach, gratis en App Store y Google Play!\nAndroid: https://play.google.com/store/apps/details?id=gov.va.mobilehealth.ncptsd.covid  \niOS: https://itunes.apple.com/us/app/covid-coach/id1504705038");
            } else {
                intent.putExtra("android.intent.extra.TEXT", "Check out this app, COVID Coach, free on the App Store and Google Play!\nAndroid: https://play.google.com/store/apps/details?id=gov.va.mobilehealth.ncptsd.covid  \niOS: https://itunes.apple.com/us/app/covid-coach/id1504705038");
            }
            intent.setType("text/plain");
            t tVar = t.this;
            tVar.F1(Intent.createChooser(intent, tVar.Q(R.string.share_this_app)));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_share_app, viewGroup, false);
        this.d0 = (ImageView) inflate.findViewById(R.id.share_app_img);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.g0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.h0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.i0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.g0.setText(R.string.share_this_app);
        AppCompatTextView appCompatTextView = this.g0;
        appCompatTextView.setContentDescription(Q(R.string.share_this_app) + " " + Q(R.string.heading));
        int r = j.r(n()) / 4;
        this.d0.getLayoutParams().width = r;
        this.d0.getLayoutParams().height = r;
        this.e0.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
        this.h0.setOnClickListener(new a());
        this.i0.setVisibility(4);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.share_app_container);
        g0.k(n(), n().getLayoutInflater(), this.f0, j.N(n(), g.G), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        ((Button) inflate.findViewById(R.id.share_app_btn)).setOnClickListener(new b());
        return inflate;
    }
}
