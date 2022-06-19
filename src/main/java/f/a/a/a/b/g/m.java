package f.a.a.a.b.g;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import java.io.File;

/* compiled from: Frag_about */
public class m extends vainstrum.Components.b {
    private Act_home c0;
    private AppCompatTextView d0;
    private AppCompatTextView e0;
    private AppCompatTextView f0;
    private AppCompatTextView g0;
    private AppCompatTextView h0;
    private AppCompatTextView i0;
    private ImageView j0;
    private ImageView k0;

    /* compiled from: Frag_about */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            m.this.c0.r0();
        }
    }

    /* compiled from: Frag_about */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(m.this.n(), Act_jtext.class);
            intent.putExtra("title", m.this.Q(R.string.about));
            intent.putExtra("file", g.f10088h + File.separator + "about_about.json");
            m.this.F1(intent);
        }
    }

    /* compiled from: Frag_about */
    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(m.this.n(), Act_jtext.class);
            intent.putExtra("title", m.this.Q(R.string.project_team));
            intent.putExtra("file", g.f10088h + File.separator + "about_team.json");
            m.this.F1(intent);
        }
    }

    /* compiled from: Frag_about */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(m.this.n(), Act_jtext.class);
            intent.putExtra("title", m.this.Q(R.string.partners));
            intent.putExtra("file", g.f10088h + File.separator + "about_partners.json");
            m.this.F1(intent);
        }
    }

    /* compiled from: Frag_about */
    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(m.this.n(), Act_jtext.class);
            intent.putExtra("title", m.this.Q(R.string.credits));
            intent.putExtra("file", g.f10088h + File.separator + "about_credits.json");
            m.this.F1(intent);
        }
    }

    /* compiled from: Frag_about */
    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(m.this.n(), Act_jtext.class);
            intent.putExtra("title", m.this.Q(R.string.references));
            intent.putExtra("file", g.f10088h + File.separator + "about_references.json");
            m.this.F1(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_about, viewGroup, false);
        this.d0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.j0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.k0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.e0 = (AppCompatTextView) inflate.findViewById(R.id.about_txt_about);
        this.g0 = (AppCompatTextView) inflate.findViewById(R.id.about_txt_references);
        this.f0 = (AppCompatTextView) inflate.findViewById(R.id.about_txt_team);
        this.h0 = (AppCompatTextView) inflate.findViewById(R.id.about_txt_partners);
        this.i0 = (AppCompatTextView) inflate.findViewById(R.id.about_txt_credits);
        this.j0.setOnClickListener(new a());
        this.k0.setVisibility(4);
        this.d0.setText(R.string.about);
        AppCompatTextView appCompatTextView = this.d0;
        appCompatTextView.setContentDescription(Q(R.string.about) + " " + Q(R.string.heading));
        this.e0.setOnClickListener(new b());
        this.f0.setOnClickListener(new c());
        this.h0.setOnClickListener(new d());
        this.i0.setOnClickListener(new e());
        this.g0.setOnClickListener(new f());
        return inflate;
    }
}
