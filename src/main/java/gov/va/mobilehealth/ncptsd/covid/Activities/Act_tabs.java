package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.i.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;
import vainstrum.Components.b;

public class Act_tabs extends i0 implements View.OnClickListener {
    public static Act_tabs P;
    private LinearLayout A;
    private LinearLayout B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private AppCompatTextView G;
    private AppCompatTextView H;
    private AppCompatTextView I;
    private AppCompatTextView J;
    private MenuItem K;
    private MenuItem L;
    private MenuItem M;
    private int N = 2;
    private boolean O = false;
    private Toolbar u;
    private AppCompatTextView v;
    private View w;
    private FrameLayout x;
    private LinearLayout y;
    private LinearLayout z;

    class a implements m.h {
        a() {
        }

        @Override // androidx.fragment.app.m.h
        public void a() {
            int d0 = Act_tabs.this.C().d0();
            if (d0 == 0) {
                int i2 = Act_tabs.this.N;
                if (i2 == 0) {
                    Act_tabs.this.v.setText(R.string.learn);
                    Act_tabs act_tabs = Act_tabs.this;
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_tabs, act_tabs.getString(R.string.learn));
                    Act_tabs.this.f0(false);
                    Act_tabs.this.g0(true);
                } else if (i2 == 1) {
                    Act_tabs.this.v.setText(R.string.mood_check);
                    Act_tabs act_tabs2 = Act_tabs.this;
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_tabs2, act_tabs2.getString(R.string.mood_check));
                    if (Act_tabs.this.K != null) {
                        Act_tabs.this.K.setVisible(false);
                    }
                    Act_tabs.this.f0(true);
                    Act_tabs.this.g0(false);
                } else if (i2 == 2) {
                    Act_tabs.this.v.setText(R.string.manage_stress);
                    Act_tabs act_tabs3 = Act_tabs.this;
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_tabs3, act_tabs3.getString(R.string.manage_stress));
                    if (Act_tabs.this.K != null) {
                        Act_tabs.this.K.setVisible(true);
                    }
                    Act_tabs.this.f0(false);
                    Act_tabs.this.g0(true);
                } else if (i2 == 3) {
                    Act_tabs.this.v.setText(R.string.find_resources);
                    Act_tabs act_tabs4 = Act_tabs.this;
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_tabs4, act_tabs4.getString(R.string.find_resources));
                    Act_tabs.this.f0(false);
                    Act_tabs.this.g0(true);
                }
                Act_tabs.this.M().v(R.drawable.icon_home);
                Act_tabs.this.M().u(R.string.home);
                Act_tabs.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                return;
            }
            m.f c0 = Act_tabs.this.C().c0(d0 - 1);
            if (c0 != null) {
                Act_tabs.this.C().i0().get(0);
                String a2 = c0.a();
                if (a2 != null) {
                    Act_tabs.this.v.setText(a2);
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(Act_tabs.this, a2);
                    Act_tabs.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                }
                if (Act_tabs.this.K != null) {
                    Act_tabs.this.K.setVisible(false);
                }
                Act_tabs.this.f0(false);
                Act_tabs.this.g0(false);
                Act_tabs.this.M().v(R.drawable.ef_ic_arrow_back);
                Act_tabs.this.M().u(R.string.navigate_up);
            }
        }
    }

    public void Z(Fragment fragment, String str) {
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.x.getId(), fragment, str);
        j2.h(str);
        j2.j();
    }

    public void a0(b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.x.getId(), bVar, str);
        j2.h(str);
        j2.j();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void b0() {
        c0();
        this.G.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light_dark));
        this.H.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light_dark));
        this.I.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light_dark));
        this.J.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light_dark));
        this.C.setImageResource(R.drawable.icon_learn);
        this.D.setImageResource(R.drawable.icon_track);
        this.E.setImageResource(R.drawable.icon_manage);
        this.F.setImageResource(R.drawable.icon_support);
        this.y.setContentDescription(getString(R.string.learn_tab));
        this.z.setContentDescription(getString(R.string.mood_check_tab));
        this.A.setContentDescription(getString(R.string.manage_stress_tab));
        this.B.setContentDescription(getString(R.string.support_tab));
    }

    public void c0() {
        C().I0(null, 1);
    }

    public void d0(String str) {
        this.v.setText(str);
        gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(this, str);
    }

    public void e0(boolean z2) {
        b0();
        int i2 = this.N;
        if (i2 == 0) {
            this.v.setText(R.string.learn);
            this.C.setImageResource(R.drawable.icon_learn_on);
            this.G.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            this.y.setContentDescription(getString(R.string.learn_tab_selected));
            setTitle(R.string.learn_tab);
            f0(false);
            g0(true);
            MenuItem menuItem = this.K;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
            f.a.a.a.b.h.b bVar = new f.a.a.a.b.h.b();
            bVar.V1(getTitle().toString());
            u j2 = C().j();
            j2.q(this.x.getId(), bVar, getString(R.string.learn));
            j2.j();
            if (z2) {
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(this, getString(R.string.learn));
            }
            s.a(this.u);
        } else if (i2 == 1) {
            this.v.setText(R.string.mood_check);
            this.D.setImageResource(R.drawable.icon_track_on);
            this.H.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            this.z.setContentDescription(getString(R.string.mood_check_tab_selected));
            setTitle(R.string.mood_check_tab);
            f0(true);
            g0(false);
            MenuItem menuItem2 = this.K;
            if (menuItem2 != null) {
                menuItem2.setVisible(false);
            }
            f.a.a.a.b.n.a aVar = new f.a.a.a.b.n.a();
            aVar.V1(getTitle().toString());
            u j3 = C().j();
            j3.q(this.x.getId(), aVar, getString(R.string.mood_check));
            j3.i();
            if (z2) {
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(this, getString(R.string.mood_check));
            }
            s.a(this.u);
        } else if (i2 == 2) {
            this.v.setText(R.string.manage_stress);
            this.E.setImageResource(R.drawable.icon_manage_on);
            this.I.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            this.A.setContentDescription(getString(R.string.manage_stress_tab_selected));
            setTitle(R.string.manage_stress_tab);
            f0(false);
            g0(true);
            MenuItem menuItem3 = this.K;
            if (menuItem3 != null) {
                menuItem3.setTitle(R.string.manage_stress_help);
                this.K.setVisible(true);
            }
            if (this.O) {
                k o2 = k.o2(1);
                o2.V1(getTitle().toString());
                u j4 = C().j();
                j4.q(this.x.getId(), o2, getString(R.string.manage_stress));
                j4.j();
            } else {
                k kVar = new k();
                kVar.V1(getTitle().toString());
                u j5 = C().j();
                j5.q(this.x.getId(), kVar, getString(R.string.manage_stress));
                j5.j();
            }
            s.a(this.u);
        } else if (i2 == 3) {
            this.v.setText(R.string.find_resources);
            this.F.setImageResource(R.drawable.icon_support_on);
            this.J.setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            this.B.setContentDescription(getString(R.string.resources_tab_selected));
            setTitle(R.string.resources_tab);
            f0(false);
            g0(true);
            MenuItem menuItem4 = this.K;
            if (menuItem4 != null) {
                menuItem4.setVisible(false);
            }
            f.a.a.a.b.k.a aVar2 = new f.a.a.a.b.k.a();
            aVar2.V1(getTitle().toString());
            u j6 = C().j();
            j6.q(this.x.getId(), aVar2, getString(R.string.find_resources));
            j6.j();
            if (z2) {
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(this, getString(R.string.find_resources));
            }
            s.a(this.u);
        }
        this.O = false;
    }

    public void f0(boolean z2) {
        MenuItem menuItem = this.L;
        if (menuItem != null) {
            menuItem.setVisible(z2);
        }
    }

    public void g0(boolean z2) {
        MenuItem menuItem = this.M;
        if (menuItem != null) {
            menuItem.setVisible(z2);
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.y.getId()) {
            this.N = 0;
            e0(false);
        }
        if (view.getId() == this.z.getId()) {
            this.N = 1;
            e0(false);
        }
        if (view.getId() == this.A.getId()) {
            this.N = 2;
            e0(false);
        }
        if (view.getId() == this.B.getId()) {
            this.N = 3;
            e0(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.N = getIntent().getIntExtra("cur_tab", 2);
        setContentView(R.layout.act_tabs);
        this.u = (Toolbar) findViewById(R.id.tabs_toolbar);
        this.w = findViewById(R.id.tabs_top_padding);
        this.x = (FrameLayout) findViewById(R.id.tabs_container);
        this.v = (AppCompatTextView) findViewById(R.id.tabs_txt_title);
        this.y = (LinearLayout) findViewById(R.id.tabbar_tab_learn);
        this.z = (LinearLayout) findViewById(R.id.tabbar_tab_track);
        this.A = (LinearLayout) findViewById(R.id.tabbar_tab_manage);
        this.B = (LinearLayout) findViewById(R.id.tabbar_tab_support);
        this.C = (ImageView) findViewById(R.id.tabbar_tab_img_learn);
        this.D = (ImageView) findViewById(R.id.tabbar_tab_img_track);
        this.E = (ImageView) findViewById(R.id.tabbar_tab_img_manage);
        this.F = (ImageView) findViewById(R.id.tabbar_tab_img_support);
        this.G = (AppCompatTextView) findViewById(R.id.tabbar_tab_txt_learn);
        this.H = (AppCompatTextView) findViewById(R.id.tabbar_tab_txt_track);
        this.I = (AppCompatTextView) findViewById(R.id.tabbar_tab_txt_manage);
        this.J = (AppCompatTextView) findViewById(R.id.tabbar_tab_txt_support);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.w.getLayoutParams().height = j.v(getApplicationContext());
        e0(true);
        C().e(new a());
        P = this;
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        M().v(R.drawable.icon_home);
        M().u(R.string.home);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_act_tabs, menu);
        this.K = menu.findItem(R.id.action_tabs_help);
        this.L = menu.findItem(R.id.action_tabs_export);
        this.M = menu.findItem(R.id.action_tabs_search);
        menu.findItem(R.id.action_tabs_reminders).setVisible(false);
        int i2 = this.N;
        if (i2 == 2) {
            this.K.setTitle(R.string.manage_stress_help);
            this.K.setVisible(true);
        } else if (i2 == 1) {
            this.K.setVisible(false);
            f0(true);
            g0(false);
        }
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                d.j(getApplicationContext(), "18916");
                onBackPressed();
                return true;
            case R.id.action_tabs_export /*{ENCODED_INT: 2131296345}*/:
                startActivity(new Intent(getApplicationContext(), Act_export_mood_check.class));
                break;
            case R.id.action_tabs_help /*{ENCODED_INT: 2131296346}*/:
                d.j(getApplicationContext(), "18932");
                if (this.N == 1) {
                    startActivity(new Intent(getApplicationContext(), Act_track_help.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), Act_manage_help.class));
                }
                return true;
            case R.id.action_tabs_search /*{ENCODED_INT: 2131296348}*/:
                String string = getString(R.string.search);
                Intent intent = new Intent(this, Act_search.class);
                int i2 = this.N;
                if (i2 == 0) {
                    string = "Learn " + string;
                    intent.putExtra("searchType", 2);
                } else if (i2 == 2) {
                    string = "Tools " + string;
                    intent.putExtra("searchType", 1);
                } else if (i2 == 3) {
                    string = "Find Resources " + string;
                    intent.putExtra("searchType", 3);
                }
                d.k(string);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
