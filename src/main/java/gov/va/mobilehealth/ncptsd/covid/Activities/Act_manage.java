package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.g;
import f.a.a.a.b.i.h;
import f.a.a.a.b.i.j;
import f.a.a.a.b.i.k;
import f.a.a.a.b.l.n0.c;
import f.a.a.a.b.l.n0.d;
import f.a.a.a.b.l.n0.e;
import f.a.a.a.b.l.n0.f;
import f.a.a.a.b.l.n0.i;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.File;

public class Act_manage extends i0 {
    private MenuItem A;
    private boolean B = true;
    private boolean C = false;
    private boolean D = false;
    private int E = -1;
    private int F = -1;
    private String G;
    private AppCompatTextView u;
    private Toolbar v;
    private FrameLayout w;
    private b0 x;
    private a0 y;
    private MenuItem z;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a(Act_manage act_manage) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_manage.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y() {
        Fragment fragment;
        if (!isFinishing() && (fragment = C().i0().get(0)) != null) {
            if (!fragment.getClass().equals(h.class) && !fragment.getClass().equals(g.class) && !fragment.getClass().equals(j.class) && !fragment.getClass().equals(k.class) && !fragment.getClass().equals(f.a.a.a.b.l.n0.g.class) && !fragment.getClass().equals(c.class) && !fragment.getClass().equals(d.class) && !fragment.getClass().equals(f.a.a.a.b.l.j0.b.class) && !fragment.getClass().equals(f.a.a.a.b.l.l0.b.class) && !fragment.getClass().equals(f.a.a.a.b.l.i0.c.class) && this.z != null && !fragment.getClass().equals(f.class) && !fragment.getClass().equals(i.class) && !fragment.getClass().equals(e.class) && !fragment.getClass().equals(f.a.a.a.b.l.n0.h.class) && !fragment.getClass().equals(f.a.a.a.b.l.n0.b.class)) {
                if (fragment.getClass().equals(f.a.a.a.b.l.i0.b.class)) {
                    this.z.setTitle(R.string.next);
                    this.z.setVisible(true);
                } else {
                    this.z.setTitle(R.string.done);
                    this.z.setVisible(true);
                }
            }
            if (fragment.getClass().equals(c.class)) {
                this.C = true;
            } else {
                this.C = false;
            }
            String R = fragment.R();
            if (R != null) {
                this.u.setText(R);
                AppCompatTextView appCompatTextView = this.u;
                appCompatTextView.setContentDescription(R + " " + getString(R.string.heading));
                m.A0(this, R);
            }
            if (fragment.getClass().equals(h.class) || fragment.getClass().equals(f.a.a.a.b.l.h0.b.class)) {
                MenuItem menuItem = this.A;
                if (menuItem != null) {
                    menuItem.setVisible(true);
                }
                if (fragment.getClass().equals(h.class)) {
                    this.B = true;
                } else {
                    this.B = false;
                }
            } else {
                this.B = false;
                MenuItem menuItem2 = this.A;
                if (menuItem2 != null) {
                    menuItem2.setVisible(false);
                }
            }
            if (fragment.getClass().equals(f.class) || fragment.getClass().equals(i.class) || fragment.getClass().equals(e.class) || fragment.getClass().equals(f.a.a.a.b.l.n0.h.class) || fragment.getClass().equals(f.a.a.a.b.l.n0.b.class) || fragment.getClass().equals(f.a.a.a.b.l.n0.j.class)) {
                this.D = true;
            } else {
                this.D = false;
            }
            if (fragment.getClass().equals(f.a.a.a.b.l.l0.a.class)) {
                if (gov.va.mobilehealth.ncptsd.covid.CComp.k.f10124a.q(((f.a.a.a.b.l.l0.a) fragment).g2())) {
                    MenuItem menuItem3 = this.z;
                    if (menuItem3 != null) {
                        menuItem3.setVisible(true);
                    }
                } else {
                    MenuItem menuItem4 = this.z;
                    if (menuItem4 != null) {
                        menuItem4.setVisible(false);
                    }
                }
            } else if (this.z != null) {
                if (fragment.getClass().equals(f.a.a.a.b.l.i0.b.class) || fragment.getClass().equals(f.a.a.a.b.l.i0.d.class)) {
                    this.z.setVisible(true);
                } else {
                    this.z.setVisible(false);
                }
            }
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0() {
        if (C().d0() > 0) {
            new Handler().postDelayed(new p(this), 200);
        } else {
            finish();
        }
    }

    public void W(vainstrum.Components.b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.w.getId(), bVar, str);
        j2.h(null);
        j2.i();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(gov.va.mobilehealth.ncptsd.covid.CComp.b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    public void b0(vainstrum.Components.b bVar, String str) {
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.w.getId(), bVar, str);
        j2.i();
    }

    public void c0(String str) {
        this.G = str;
    }

    public void d0(int i2) {
        this.F = i2;
    }

    public void e0(int i2) {
        this.E = i2;
    }

    public void f0() {
        if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(getApplicationContext()).equals("es")) {
            Context applicationContext = getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(gov.va.mobilehealth.ncptsd.covid.CComp.g.f10081a);
            String str = File.separator;
            sb.append(str);
            sb.append(gov.va.mobilehealth.ncptsd.covid.CComp.g.f10085e);
            sb.append(str);
            sb.append(gov.va.mobilehealth.ncptsd.covid.CComp.g.C);
            gov.va.mobilehealth.ncptsd.covid.CComp.j.X(this, getString(R.string.distress_meter), gov.va.mobilehealth.ncptsd.covid.CComp.j.g(gov.va.mobilehealth.ncptsd.covid.CComp.j.N(applicationContext, sb.toString())).toString());
            return;
        }
        Context applicationContext2 = getApplicationContext();
        gov.va.mobilehealth.ncptsd.covid.CComp.j.X(this, getString(R.string.distress_meter), gov.va.mobilehealth.ncptsd.covid.CComp.j.g(gov.va.mobilehealth.ncptsd.covid.CComp.j.N(applicationContext2, gov.va.mobilehealth.ncptsd.covid.CComp.g.f10085e + File.separator + gov.va.mobilehealth.ncptsd.covid.CComp.g.C)).toString());
    }

    public void finish() {
        if (this.y != null) {
            m.Z0(getApplicationContext(), this.y.c(), this.E, this.F);
        } else {
            m.Z0(getApplicationContext(), this.G, this.E, this.F);
        }
        super.finish();
    }

    public void g0() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes_im_sure, new b());
        h2.h(R.string.cancel, new a(this));
        h2.a().show();
        this.v.announceForAccessibility(getString(R.string.lose_unsaved_really_exit));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.x = (b0) getIntent().getSerializableExtra("tool");
        this.y = (a0) getIntent().getSerializableExtra("symptom");
        setContentView(R.layout.act_manage);
        this.u = (AppCompatTextView) findViewById(R.id.manage_toolbar_txt);
        this.v = (Toolbar) findViewById(R.id.manage_toolbar);
        this.w = (FrameLayout) findViewById(R.id.manage_container);
        T(this.v);
        M().x(true);
        M().s(true);
        M().t(false);
        C().e(new o(this));
        if (m.h0(getApplicationContext())) {
            if (!m.U0(getApplicationContext())) {
                f0();
                m.K0(getApplicationContext(), true);
            }
            W(h.W1(this.x, this.y, -1, null), getString(R.string.distress_meter));
            this.u.setText(R.string.distress_meter);
            AppCompatTextView appCompatTextView = this.u;
            appCompatTextView.setContentDescription(getString(R.string.distress_meter) + " " + getString(R.string.heading));
            m.A0(this, getString(R.string.distress_meter));
            this.B = true;
            return;
        }
        m.c0(true, this, this.y, this.x, -1);
        this.B = false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_act_manage, menu);
        this.z = menu.findItem(R.id.action_manage_done);
        this.A = menu.findItem(R.id.action_manage_help);
        this.z.setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.C) {
                    onBackPressed();
                } else if (this.D) {
                    g0();
                } else {
                    k.b.d.i();
                    finish();
                }
                return true;
            case R.id.action_manage_done /*{ENCODED_INT: 2131296335}*/:
                MenuItem menuItem2 = this.z;
                if (menuItem2 != null) {
                    k.b.d.k(menuItem2.getTitle().toString());
                }
                sendBroadcast(new Intent("gov.va.mobilehealth.ACTION_DONE"));
                return true;
            case R.id.action_manage_help /*{ENCODED_INT: 2131296336}*/:
                if (this.B) {
                    Intent intent = new Intent(this, Act_show_text.class);
                    intent.putExtra("file", gov.va.mobilehealth.ncptsd.covid.CComp.g.f10085e + File.separator + gov.va.mobilehealth.ncptsd.covid.CComp.g.B);
                    intent.putExtra("title", getString(R.string.distress_meter_help));
                    startActivity(intent);
                } else {
                    sendBroadcast(new Intent("gov.va.mobilehealth.ACTION_HELP"));
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.i0
    public void onResume() {
        super.onResume();
        s.a(this.v);
    }
}
