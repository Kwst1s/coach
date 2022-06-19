package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.ArrayList;

public class Act_new_my_feeling extends f {
    private ArrayList<h> A;
    private Toolbar u;
    private TextView v;
    private TextView w;
    private FrameLayout x;
    private boolean y = false;
    private boolean z = false;

    class a implements m.h {
        a() {
        }

        @Override // androidx.fragment.app.m.h
        public void a() {
            if (Act_new_my_feeling.this.C().d0() - 1 >= 0) {
                Fragment fragment = Act_new_my_feeling.this.C().i0().get(0);
                if (fragment != null) {
                    if (fragment.getClass().equals(f.a.a.a.b.l.m0.b.class)) {
                        Act_new_my_feeling.this.z = false;
                        Act_new_my_feeling.this.y = false;
                    } else if (fragment.getClass().equals(f.a.a.a.b.l.m0.a.class)) {
                        Act_new_my_feeling.this.z = false;
                        Act_new_my_feeling.this.y = true;
                    } else if (fragment.getClass().equals(f.a.a.a.b.l.m0.d.class)) {
                        Act_new_my_feeling.this.z = true;
                        Act_new_my_feeling.this.y = true;
                    } else {
                        Act_new_my_feeling.this.z = true;
                        Act_new_my_feeling.this.y = true;
                    }
                    String R = fragment.R();
                    if (R != null) {
                        Act_new_my_feeling.this.v.setText(R);
                        gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(Act_new_my_feeling.this, R);
                    }
                }
            } else {
                Act_new_my_feeling.this.y = false;
                Act_new_my_feeling.this.z = false;
            }
            Act_new_my_feeling.this.getWindow().getDecorView().sendAccessibilityEvent(32);
            s.a(Act_new_my_feeling.this.u);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Act_new_my_feeling.this.sendBroadcast(new Intent("gov.va.mobilehealth.ACTION_NEXT"));
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements DialogInterface.OnClickListener {
        c(Act_new_my_feeling act_new_my_feeling) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            Act_new_my_feeling.this.finish();
        }
    }

    public void a0(vainstrum.Components.b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.x.getId(), bVar, str);
        j2.h(str);
        j2.i();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public ArrayList<h> b0() {
        return this.A;
    }

    public TextView c0() {
        return this.w;
    }

    public void d0() {
        b.a h2 = j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes, new d());
        h2.h(R.string.cancel, new c(this));
        h2.a().show();
    }

    public void e0(ArrayList<h> arrayList) {
        this.A = arrayList;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.y || this.z) {
            super.onBackPressed();
        } else {
            d0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_new_my_feeling);
        this.u = (Toolbar) findViewById(R.id.new_my_feeling_toolbar);
        this.v = (TextView) findViewById(R.id.new_my_feeling_txt_title);
        this.w = (TextView) findViewById(R.id.new_my_feeling_txt_next);
        this.x = (FrameLayout) findViewById(R.id.new_my_feeling_container);
        C().e(new a());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.x.getId(), new f.a.a.a.b.l.m0.b(), getString(R.string.my_feelings));
        j2.h(getString(R.string.my_feelings));
        j2.i();
        this.w.setOnClickListener(new b());
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        d0();
        return true;
    }
}
