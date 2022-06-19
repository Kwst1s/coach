package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.x;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.c;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.Services.AudioService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import k.b.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_ambient_sounds */
public class p extends vainstrum.Components.b implements View.OnClickListener, x.c {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private RecyclerView g0;
    private TextView h0;
    private FABTracking i0;
    private b0 j0;
    private b0 k0;
    private a0 l0;
    private int m0;
    private String n0;
    private ArrayList<c> o0;
    private c p0;
    private Boolean q0;
    private Boolean r0;
    private BroadcastReceiver s0;
    private AudioService t0;
    private boolean u0 = false;
    private ServiceConnection v0 = new b();

    /* compiled from: Frag_tool_ambient_sounds */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (p.this.m0 == -1) {
                p.this.c0.finish();
                return;
            }
            h W1 = h.W1(p.this.j0, p.this.l0, p.this.m0, p.this.n0);
            W1.V1(p.this.R1());
            p.this.c0.W(W1, p.this.Q(R.string.distress_meter));
            p.this.k2();
        }
    }

    /* compiled from: Frag_tool_ambient_sounds */
    class b implements ServiceConnection {
        b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            p.this.t0 = ((AudioService.a) iBinder).a();
            p.this.t0.a(p.this.p0.a(), p.this.k0.g(), true);
            p.this.i0.setImageResource(R.drawable.icon_pause_white);
            p.this.i0.setContentDescription(p.this.Q(R.string.only_pause_audio));
            p.this.i0.sendAccessibilityEvent(4);
            p.this.i0.setEnabled(true);
            p.this.i0.setBackgroundTintList(b.h.d.a.c(p.this.n(), R.color.colorPrimary));
            p.this.u0 = true;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            p.this.u0 = false;
        }
    }

    public p() {
        Boolean bool = Boolean.FALSE;
        this.q0 = bool;
        this.r0 = bool;
    }

    public static p i2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        p pVar = new p();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        pVar.v1(bundle);
        return pVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.s0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.s0 = new a();
        try {
            n().registerReceiver(this.s0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.j0);
        bundle.putSerializable("selected_tool", this.k0);
        bundle.putSerializable("symptom", this.l0);
        bundle.putInt("old_distress", this.m0);
        bundle.putString("last_tool_name", this.n0);
        super.K0(bundle);
    }

    @Override // f.a.a.a.b.b.x.c
    public void a(c cVar) {
        this.p0 = cVar;
        for (int i2 = 0; i2 < this.o0.size(); i2++) {
            if (this.o0.get(i2).a().equals(this.p0.a())) {
                this.o0.get(i2).e(true);
            } else {
                this.o0.get(i2).e(false);
            }
        }
        if (this.g0.getAdapter() != null) {
            this.g0.getAdapter().h();
        }
        d.k(this.p0.c());
        j2();
    }

    public void j2() {
        TextView textView = this.h0;
        textView.setText(Q(R.string.playing) + ": " + this.p0.c());
        AudioService audioService = this.t0;
        if (audioService == null) {
            Intent intent = new Intent(n(), AudioService.class);
            n().bindService(intent, this.v0, 1);
            n().startService(intent);
            return;
        }
        audioService.a(this.p0.a(), this.k0.g(), true);
        this.i0.setImageResource(R.drawable.icon_pause_white);
        this.i0.setContentDescription(Q(R.string.only_pause_audio));
    }

    public void k2() {
        if (this.t0 != null) {
            if (this.u0) {
                n().unbindService(this.v0);
                this.u0 = false;
            }
            this.t0.f();
        }
        this.t0 = null;
    }

    public void l2() {
        try {
            androidx.fragment.app.d n = n();
            JSONArray jSONArray = new JSONArray(j.N(n, g.f10089i + File.separator + this.k0.c()));
            this.o0 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                this.o0.add(new c(jSONObject.getString("title"), jSONObject.getString("audio")));
            }
            Collections.sort(this.o0, a.f9456b);
            this.g0.setAdapter(new x(n(), this.o0, this));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.j0 = (b0) bundle.getSerializable("tool");
            this.k0 = (b0) bundle.getSerializable("selected_tool");
            this.l0 = (a0) bundle.getSerializable("symptom");
            this.m0 = bundle.getInt("old_distress");
            this.n0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.j0 = (b0) u().getSerializable("tool");
            this.k0 = (b0) u().getSerializable("selected_tool");
            this.l0 = (a0) u().getSerializable("symptom");
            this.m0 = u().getInt("old_distress");
            this.n0 = u().getString("last_tool_name");
            d.u(n(), this.k0.g());
        }
    }

    public void onClick(View view) {
        AudioService audioService;
        if (view.getId() == this.i0.getId() && (audioService = this.t0) != null) {
            if (audioService.b()) {
                this.t0.c();
                this.i0.setImageResource(R.drawable.icon_play_white);
                this.i0.setContentDescription(Q(R.string.only_play_audio));
                this.i0.announceForAccessibility(Q(R.string.only_pause_audio));
            } else {
                this.t0.e();
                this.i0.setImageResource(R.drawable.icon_pause_white);
                this.i0.setContentDescription(Q(R.string.only_pause_audio));
                this.i0.announceForAccessibility(Q(R.string.only_play_audio));
            }
        }
        if (view.getId() == this.d0.getId()) {
            this.r0 = Boolean.valueOf(m.o(n(), this.k0, this.d0, this.e0, this.r0, this.q0));
            this.q0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.q0 = Boolean.valueOf(m.n(n(), this.k0, this.d0, this.e0, this.r0, this.q0));
            this.r0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.l0, this.j0, this.m0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_ambient_sounds, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (RecyclerView) inflate.findViewById(R.id.ambient_sounds_rview);
        this.h0 = (TextView) inflate.findViewById(R.id.ambient_sounds_title);
        this.i0 = (FABTracking) inflate.findViewById(R.id.ambient_sounds_play_pause);
        if (this.l0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n());
        linearLayoutManager.E2(1);
        this.g0.setLayoutManager(linearLayoutManager);
        this.g0.setHasFixedSize(true);
        m.f0(this.k0.d(), this.d0, this.e0);
        this.r0 = Boolean.valueOf(m.C0(n(), this.k0.d(), this.d0, false));
        this.q0 = Boolean.valueOf(m.B0(n(), this.k0.d(), this.e0, false));
        this.i0.setEnabled(false);
        this.i0.setBackgroundTintList(b.h.d.a.c(n(), R.color.grey_dark));
        l2();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        k2();
        super.t0();
    }
}
