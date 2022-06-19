package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.u;
import c.e.a.c.a.a.d;
import c.e.a.c.a.a.e;
import c.e.a.c.a.a.f;
import c.e.a.c.a.a.g;
import c.e.a.c.a.a.h;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.f.i;
import f.a.a.a.b.g.n;
import f.a.a.a.b.g.p;
import f.a.a.a.b.g.q;
import f.a.a.a.b.g.t;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_goals;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.r;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.DownloaderExpService;
import k.e.a;

public class Act_home extends i0 implements f, View.OnClickListener {
    public static Act_home U;
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private ImageView I;
    private View J;
    private View K;
    private int L = 0;
    private k.e.a M;
    private boolean N = false;
    private h O;
    private g P;
    private i Q;
    private ProgressDialog R;
    private int S = -1;
    private ServiceConnection T = new c();
    private DrawerLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private FrameLayout x;
    private AppCompatTextView y;
    private LinearLayout z;

    class a implements DrawerLayout.d {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void a(int i2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void b(View view, float f2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void c(View view) {
            m.p(Act_home.this.w);
            Act_home.this.v.setImportantForAccessibility(2);
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void d(View view) {
            m.p(Act_home.this.v);
            Act_home.this.v.setImportantForAccessibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + Act_home.this.getApplicationContext().getPackageName()));
            try {
                Act_home.this.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Act_home act_home = Act_home.this;
                j.V(act_home, act_home.getString(R.string.no_app_to_handle_content));
            }
            j.T(Act_home.this.getApplicationContext());
            dialogInterface.dismiss();
        }
    }

    class c implements ServiceConnection {
        c() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Act_home.this.M = ((a.BinderC0239a) iBinder).a();
            Act_home.this.N = true;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Act_home.this.N = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        new f.a.a.a.b.p.a(this, C(), new i()).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i2) {
        j.T(getApplicationContext());
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(DialogInterface dialogInterface, int i2) {
        v0();
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0(DialogInterface dialogInterface, int i2) {
        i0();
        dialogInterface.dismiss();
    }

    public void a0() {
        if (!e.a(this, e.g(getApplicationContext(), true, 12), 147280629, false)) {
            v0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void b0() {
        b.a h2 = j.h(this, getString(R.string.may_take_some_time_to_connect));
        h2.k(R.string.go_on, new i(this));
        h2.h(R.string.cancel, n.f9933b);
        h2.a().show();
    }

    /* renamed from: c0 */
    public void i0() {
        Intent intent = new Intent(this, Act_splash.class);
        intent.setFlags(335544320);
        try {
            if (c.e.a.c.a.a.c.c(this, PendingIntent.getActivity(this, 0, intent, 134217728), DownloaderExpService.class) == 0) {
                return;
            }
            if (b.h.d.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 128);
            } else if (j.H(getApplicationContext())) {
                h b2 = c.e.a.c.a.a.c.b(this, DownloaderExpService.class);
                this.O = b2;
                b2.a(this);
                this.Q = new i();
                this.R.show();
            } else {
                u0();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public String d0() {
        this.S = m.J(getApplicationContext(), this.S);
        return m.r(getApplicationContext(), this.S);
    }

    public void e0() {
        if (o.a(getApplicationContext())) {
            this.L = 9;
            s0(false);
        }
    }

    public void finish() {
        k.e.a aVar = this.M;
        if (aVar != null && this.N) {
            aVar.stopSelf();
        }
        super.finish();
    }

    @Override // c.e.a.c.a.a.f
    public void n(Messenger messenger) {
        g a2 = d.a(messenger);
        this.P = a2;
        a2.c(1);
        this.P.b(this.O.b());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, gov.va.mobilehealth.ncptsd.covid.CComp.i0
    public void onBackPressed() {
        if (this.u.A(this.w)) {
            this.u.d(this.w);
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.I.getId() && this.u.A(this.w)) {
            this.u.d(this.w);
        }
        if (view.getId() == this.z.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 0) {
                this.L = 0;
                s0(false);
            }
        }
        if (view.getId() == this.A.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 1) {
                this.L = 1;
                s0(false);
            }
        }
        if (view.getId() == this.B.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 5) {
                this.L = 5;
                s0(false);
            }
        }
        if (view.getId() == this.C.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 6) {
                this.L = 6;
                s0(false);
            }
        }
        if (view.getId() == this.D.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 7) {
                this.L = 7;
                s0(false);
            }
        }
        if (view.getId() == this.E.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 3) {
                this.L = 3;
                s0(false);
            }
        }
        if (view.getId() == this.F.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 4) {
                this.L = 4;
                s0(false);
            }
        }
        if (view.getId() == this.G.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 8) {
                this.L = 8;
                s0(false);
            }
        }
        if (view.getId() == this.H.getId()) {
            if (this.u.A(this.w)) {
                this.u.d(this.w);
            }
            if (this.L != 9 && o.a(getApplicationContext())) {
                this.L = 9;
                s0(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("go_setup", false)) {
            startActivity(new Intent(getApplicationContext(), Act_setup.class));
        }
        setContentView(R.layout.act_home);
        this.v = (LinearLayout) findViewById(R.id.home_layout);
        this.u = (DrawerLayout) findViewById(R.id.home_drawer_layout);
        this.J = findViewById(R.id.home_top_padding);
        this.K = findViewById(R.id.home_drawer_top_padding);
        this.z = (LinearLayout) findViewById(R.id.home_drawer_layout_home);
        this.A = (LinearLayout) findViewById(R.id.home_drawer_layout_how_to_use);
        this.B = (LinearLayout) findViewById(R.id.home_drawer_layout_personalize);
        this.C = (LinearLayout) findViewById(R.id.home_drawer_layout_manage_data);
        this.D = (LinearLayout) findViewById(R.id.home_drawer_layout_privacy_policy);
        this.E = (LinearLayout) findViewById(R.id.home_drawer_layout_about);
        this.F = (LinearLayout) findViewById(R.id.home_drawer_layout_feedback);
        this.G = (LinearLayout) findViewById(R.id.home_drawer_layout_share);
        this.H = (LinearLayout) findViewById(R.id.home_drawer_layout_safety_plan);
        this.y = (AppCompatTextView) findViewById(R.id.lateral_menu_txt_version);
        this.I = (ImageView) findViewById(R.id.home_drawer_img_close);
        this.w = (LinearLayout) findViewById(R.id.home_layout_drawer);
        this.x = (FrameLayout) findViewById(R.id.home_container);
        this.u.a(new a());
        this.I.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.J.getLayoutParams().height = j.v(getApplicationContext());
        this.K.getLayoutParams().height = j.v(getApplicationContext());
        if (getIntent().getExtras() != null && getIntent().getBooleanExtra("onNotificationStart", false)) {
            if (getIntent().getBooleanExtra("assessment", false)) {
                Intent intent = new Intent(getApplicationContext(), Act_tabs.class);
                intent.putExtra("cur_tab", 1);
                startActivity(intent);
            } else if (getIntent().getBooleanExtra("goal", false)) {
                startActivity(new Intent(getApplicationContext(), Act_goals.class));
            } else if (getIntent().getBooleanExtra("manage", false)) {
                Intent intent2 = new Intent(getApplicationContext(), Act_tabs.class);
                intent2.putExtra("cur_tab", 2);
                startActivity(intent2);
            } else {
                this.S = getIntent().getIntExtra("index", -1);
                if (getIntent().getBooleanExtra("worry_time", false)) {
                    Intent intent3 = new Intent(U, Act_manage.class);
                    intent3.putExtra("tool", m.Y(getApplicationContext(), 33));
                    U.startActivity(intent3);
                }
            }
        }
        j.a(getApplicationContext(), j.j(getApplicationContext()));
        if (j.b(getApplicationContext())) {
            if (!j.K(getApplicationContext()) && (j.j(getApplicationContext()) - 3) % 5 == 0) {
                t0();
            }
        } else if (j.j(getApplicationContext()) == 3) {
            t0();
        }
        s0(true);
        U = this;
        if (b0.a(this).equals("es") && !r.a(getApplicationContext())) {
            b0();
        }
        this.y.setText(m.b0());
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.R = progressDialog;
        progressDialog.setMessage(getString(R.string.please_wait));
        this.R.setIndeterminate(true);
        a0();
        k.f10124a.o(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_act_tabs, menu);
        menu.findItem(R.id.action_tabs_help).setVisible(false);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        if (this.N) {
            unbindService(this.T);
            this.N = false;
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            k.b.d.i();
            finish();
            return true;
        } else if (menuItem.getItemId() != R.id.action_tabs_reminders) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            startActivity(new Intent(this, Act_new_reminders.class));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        super.onPause();
        i iVar = this.Q;
        if (iVar != null && iVar.g0()) {
            this.Q.M1();
        }
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 128) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            j.W(this, getString(R.string.need_permission_read_storage_to_download_files_use_application));
        } else {
            new Handler().postDelayed(new h(this), 400);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.i0
    public void onResume() {
        if (this.u.A(this.w)) {
            m.p(this.w);
        }
        String g2 = e.g(getApplicationContext(), true, 12);
        if (this.O != null && !e.a(this, g2, 147280629, false)) {
            this.O.a(this);
        }
        i iVar = this.Q;
        if (iVar != null && iVar.g0() && e.a(this, g2, 147280629, false)) {
            this.Q.M1();
            j.V(this, getString(R.string.download_completed));
            this.Q = null;
        }
        if (o.a(getApplicationContext())) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.i0, androidx.appcompat.app.c
    public void onStart() {
        super.onStart();
        try {
            Intent intent = new Intent(this, k.e.a.class);
            startService(intent);
            bindService(intent, this.T, 1);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStop() {
        h hVar = this.O;
        if (hVar != null) {
            hVar.c(this);
        }
        super.onStop();
        if (this.N) {
            unbindService(this.T);
            this.N = false;
        }
    }

    public void r0() {
        if (!this.u.A(this.w)) {
            this.u.G(this.w);
        }
    }

    public void s0(boolean z2) {
        switch (this.L) {
            case 0:
                f.a.a.a.b.g.o oVar = new f.a.a.a.b.g.o();
                if (z2) {
                    oVar.U1(true);
                    oVar.V1(null);
                } else {
                    oVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j2 = C().j();
                j2.q(this.x.getId(), oVar, getString(R.string.home));
                j2.j();
                s.p(this, getString(R.string.home));
                return;
            case 1:
                p pVar = new p();
                if (z2) {
                    pVar.U1(true);
                    pVar.V1(null);
                } else {
                    pVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j3 = C().j();
                j3.q(this.x.getId(), pVar, getString(R.string.how_to_use));
                j3.j();
                s.p(this, getString(R.string.how_to_use));
                return;
            case 2:
            default:
                return;
            case 3:
                f.a.a.a.b.g.m mVar = new f.a.a.a.b.g.m();
                if (z2) {
                    mVar.U1(true);
                    mVar.V1(null);
                } else {
                    mVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j4 = C().j();
                j4.q(this.x.getId(), mVar, getString(R.string.about));
                j4.j();
                s.p(this, getString(R.string.about));
                return;
            case 4:
                n nVar = new n();
                if (z2) {
                    nVar.U1(true);
                    nVar.V1(null);
                } else {
                    nVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j5 = C().j();
                j5.q(this.x.getId(), nVar, getString(R.string.send_feedback));
                j5.j();
                s.p(this, getString(R.string.send_feedback));
                return;
            case 5:
                f.a.a.a.b.g.r rVar = new f.a.a.a.b.g.r();
                if (z2) {
                    rVar.U1(true);
                    rVar.V1(null);
                } else {
                    rVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j6 = C().j();
                j6.q(this.x.getId(), rVar, getString(R.string.personalize));
                j6.j();
                s.p(this, getString(R.string.personalize));
                return;
            case 6:
                q qVar = new q();
                if (z2) {
                    qVar.U1(true);
                    qVar.V1(null);
                } else {
                    qVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j7 = C().j();
                j7.q(this.x.getId(), qVar, getString(R.string.manage_data));
                j7.j();
                s.p(this, getString(R.string.manage_data));
                return;
            case 7:
                f.a.a.a.b.g.s sVar = new f.a.a.a.b.g.s();
                if (z2) {
                    sVar.U1(true);
                    sVar.V1(null);
                } else {
                    sVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j8 = C().j();
                j8.q(this.x.getId(), sVar, getString(R.string.privacy_policy));
                j8.j();
                s.p(this, getString(R.string.privacy_policy));
                return;
            case 8:
                t tVar = new t();
                if (z2) {
                    tVar.U1(true);
                    tVar.V1(null);
                } else {
                    tVar.V1(getTitle().toString().replace("heading", BuildConfig.FLAVOR));
                }
                this.J.setBackgroundColor(b.h.d.a.b(getApplicationContext(), R.color.colorPrimary));
                u j9 = C().j();
                j9.q(this.x.getId(), tVar, getString(R.string.share_this_app));
                j9.j();
                s.p(this, getString(R.string.share_this_app));
                return;
        }
    }

    public void t0() {
        b.a h2 = j.h(this, getString(R.string.like_app_rate_it));
        h2.k(R.string.rate_now, new b());
        h2.i(R.string.never, new j(this));
        h2.h(R.string.later, k.f9930b);
        h2.a().show();
        j.R(getApplicationContext());
    }

    @Override // c.e.a.c.a.a.f
    public void u(c.e.a.c.a.a.b bVar) {
        i iVar = this.Q;
        if (iVar != null) {
            iVar.V1((float) bVar.f3470b);
            this.Q.W1((float) bVar.f3471c);
        }
    }

    public void u0() {
        b.a h2 = j.h(this, getString(R.string.failed_downloading_additional_file_try_again));
        h2.k(R.string.ok, new l(this));
        h2.a().show();
    }

    public void v0() {
        b.a h2 = j.h(this, getString(R.string.to_use_app_need_to_download_additional_files_want_to_do_now));
        h2.k(R.string.do_continue, new m(this));
        h2.a().show();
    }

    @Override // c.e.a.c.a.a.f
    public void w(int i2) {
        switch (i2) {
            case 4:
                i iVar = this.Q;
                if (iVar != null && !iVar.g0()) {
                    this.Q.U1(C(), null);
                    this.R.dismiss();
                    return;
                }
                return;
            case 5:
                i iVar2 = this.Q;
                if (iVar2 != null && iVar2.g0()) {
                    this.Q.M1();
                    this.Q = null;
                    j.V(this, getString(R.string.download_completed));
                    return;
                }
                return;
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 17:
            default:
                return;
            case 7:
                i iVar3 = this.Q;
                if (iVar3 != null && iVar3.g0()) {
                    this.Q.M1();
                    return;
                }
                return;
            case 8:
                i iVar4 = this.Q;
                if (iVar4 != null) {
                    iVar4.M1();
                    return;
                }
                return;
            case 9:
                i iVar5 = this.Q;
                if (iVar5 != null && iVar5.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                u0();
                return;
            case 14:
                i iVar6 = this.Q;
                if (iVar6 != null && iVar6.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                j.W(this, getString(R.string.need_permission_read_storage_to_download_files_use_application));
                return;
            case 15:
                i iVar7 = this.Q;
                if (iVar7 != null && iVar7.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                j.W(this, getString(R.string.licensing_issue_contact_support));
                return;
            case 16:
                i iVar8 = this.Q;
                if (iVar8 != null && iVar8.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                u0();
                return;
            case 18:
                i iVar9 = this.Q;
                if (iVar9 != null && iVar9.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                u0();
                return;
            case 19:
                i iVar10 = this.Q;
                if (iVar10 != null && iVar10.g0()) {
                    this.Q.M1();
                    this.Q = null;
                }
                u0();
                return;
        }
    }
}
