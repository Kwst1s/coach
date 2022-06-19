package f.a.a.a.b.l.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import h.a.a.a.i;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_seated_practice_timer */
public class d extends vainstrum.Components.b implements View.OnClickListener, TextureView.SurfaceTextureListener {
    private Act_manage c0;
    private b0 d0;
    private a0 e0;
    private int f0;
    private String g0;
    private LinearLayout h0;
    private TextView i0;
    private FABTracking j0;
    private FABTracking k0;
    private TextureView l0;
    private i m0;
    private boolean n0 = false;
    private boolean o0 = false;
    private boolean p0 = false;
    private long q0;
    private CountDownTimer r0;
    private boolean s0 = false;
    private int t0 = 0;
    private int u0;
    private String v0;
    private Surface w0;
    private boolean x0 = true;
    private BroadcastReceiver y0;

    /* compiled from: Frag_seated_practice_timer */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setEnabled(view.isEnabled());
        }

        public void sendAccessibilityEvent(View view, int i2) {
            if (i2 == 32768) {
                d.this.i0.setContentDescription(s.l(d.this.n(), d.this.q0));
                d.this.s0 = true;
            } else if (i2 == 65536) {
                d.this.s0 = false;
            }
            super.sendAccessibilityEvent(view, i2);
        }
    }

    /* compiled from: Frag_seated_practice_timer */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (d.this.f0 == -1) {
                d.this.c0.finish();
            } else {
                d.this.c0.W(h.W1(d.this.d0, d.this.e0, d.this.f0, d.this.g0), d.this.Q(R.string.distress_meter));
            }
        }
    }

    /* compiled from: Frag_seated_practice_timer */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f9504b;

        c(SurfaceTexture surfaceTexture) {
            this.f9504b = surfaceTexture;
        }

        public void onGlobalLayout() {
            d.this.w0 = new Surface(this.f9504b);
            d.this.w2();
            d.this.h0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.l.i0.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_seated_practice_timer */
    public class CountDownTimerC0201d extends CountDownTimer {
        CountDownTimerC0201d(long j2, long j3) {
            super(j2, j3);
        }

        public void onFinish() {
            if (d.this.p0) {
                m.W0(d.this.n(), d.this.v0);
                d dVar = d.this;
                dVar.q0 = TimeUnit.MINUTES.toMillis((long) dVar.u0);
                d.this.j0.setImageResource(R.drawable.icon_play);
                d.this.j0.setContentDescription(d.this.Q(R.string.play_timer));
                d.this.i0.setText(s.i(d.this.q0));
                d.this.i0.setContentDescription(s.l(d.this.n(), d.this.q0));
                d.this.p0 = false;
            }
        }

        public void onTick(long j2) {
            if (d.this.p0) {
                d.this.q0 = j2;
                d.this.i0.setText(s.i(d.this.q0));
                String l = s.l(d.this.n(), d.this.q0);
                if (d.this.s0 && s.n(d.this.q0)) {
                    d.this.i0.setContentDescription(l);
                    d.this.i0.announceForAccessibility(l);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_timer */
    public class e implements i.AbstractC0232i {

        /* compiled from: Frag_seated_practice_timer */
        class a implements Runnable {
            a() {
            }

            public void run() {
                d.this.j0.callOnClick();
            }
        }

        e() {
        }

        @Override // h.a.a.a.i.AbstractC0232i
        public void a(i iVar) {
            int J = iVar.J();
            int I = iVar.I();
            d dVar = d.this;
            dVar.y2(J, I, dVar.l0.getWidth(), d.this.l0.getHeight());
            iVar.Q(d.this.t0);
            if (d.this.o0) {
                iVar.d0();
            } else if (!s.m(d.this.n()) && d.this.x0) {
                new Handler().postDelayed(new a(), 200);
            }
            d.this.x0 = false;
            d.this.n0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_timer */
    public class f implements i.e {
        f() {
        }

        @Override // h.a.a.a.i.e
        public void a(i iVar) {
            d.this.o0 = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_seated_practice_timer */
    public class g implements i.g {
        g() {
        }

        @Override // h.a.a.a.i.g
        public boolean a(i iVar, int i2, int i3) {
            Toast.makeText(d.this.n(), d.this.Q(R.string.this_file_cant_be_played), 1).show();
            return false;
        }
    }

    public static d v2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, int i3, String str2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putInt("duration", i3);
        bundle.putString("tone", str2);
        dVar.v1(bundle);
        return dVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y2(int i2, int i3, int i4, int i5) {
        float f2;
        float f3 = 1.0f;
        if (i2 > i4 && i3 > i5) {
            f3 = ((float) i2) / ((float) i4);
            f2 = ((float) i3) / ((float) i5);
        } else if (i2 >= i4 || i3 >= i5) {
            float f4 = (float) i4;
            float f5 = (float) i2;
            if (f4 > f5) {
                f2 = (f4 / f5) / (((float) i5) / ((float) i3));
            } else {
                if (i5 > i3) {
                    f3 = ((float) ((int) (((float) i5) / ((float) i3)))) / (f4 / f5);
                }
                f2 = 1.0f;
            }
        } else {
            f3 = ((float) i5) / ((float) i3);
            f2 = ((float) i4) / ((float) i2);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f3, f2, (float) (i4 / 2), (float) (i5 / 2));
        this.l0.setTransform(matrix);
        this.l0.setLayoutParams(new RelativeLayout.LayoutParams(i4, i5));
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.y0);
        i iVar = this.m0;
        if (iVar != null) {
            this.t0 = iVar.F();
            if (this.m0.K()) {
                this.m0.f0();
            }
            this.m0.O();
            this.m0 = null;
            this.n0 = false;
            this.l0.setVisibility(8);
        }
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.y0 = new b();
        try {
            n().registerReceiver(this.y0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        this.l0.setVisibility(0);
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.d0 = (b0) bundle.getSerializable("tool");
            b0 b0Var = (b0) bundle.getSerializable("selected_tool");
            this.e0 = (a0) bundle.getSerializable("symptom");
            this.f0 = bundle.getInt("old_distress");
            this.g0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.d0 = (b0) u().getSerializable("tool");
            b0 b0Var2 = (b0) u().getSerializable("selected_tool");
            this.e0 = (a0) u().getSerializable("symptom");
            this.f0 = u().getInt("old_distress");
            this.g0 = u().getString("last_tool_name");
            this.u0 = u().getInt("duration");
            this.v0 = u().getString("tone");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.j0.getId()) {
            if (this.m0.K()) {
                this.j0.setTrackingId("32225");
                this.o0 = false;
                this.m0.L();
            } else {
                this.j0.setTrackingId("31808");
                this.o0 = true;
                if (!this.n0) {
                    w2();
                } else {
                    i iVar = this.m0;
                    if (iVar != null && !iVar.K()) {
                        this.m0.d0();
                    }
                }
            }
            if (this.p0) {
                this.j0.setImageResource(R.drawable.icon_play);
                this.j0.setContentDescription(Q(R.string.play_timer));
                this.j0.announceForAccessibility(Q(R.string.play_timer));
                this.p0 = false;
            } else {
                this.j0.setImageResource(R.drawable.icon_pause);
                this.j0.setContentDescription(Q(R.string.pause_timer));
                this.j0.announceForAccessibility(Q(R.string.pause_timer));
                this.p0 = true;
                x2();
            }
            this.k0.setImageResource(R.drawable.icon_stop_blue);
            this.k0.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(n(), 17170443)));
            this.k0.setEnabled(true);
        }
        if (view.getId() == this.k0.getId()) {
            this.o0 = false;
            if (this.m0.K()) {
                this.m0.f0();
                this.n0 = false;
            }
            if (this.p0) {
                this.p0 = false;
                this.r0.cancel();
                this.q0 = TimeUnit.MINUTES.toMillis((long) this.u0);
                this.j0.setImageResource(R.drawable.icon_play);
                this.j0.setContentDescription(Q(R.string.play_timer));
                this.i0.setText(s.i(this.q0));
                this.k0.announceForAccessibility(Q(R.string.timer_stopped));
                this.k0.setImageResource(R.drawable.icon_stop);
                this.k0.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(n(), 17170432)));
                this.k0.setEnabled(false);
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.h0.getViewTreeObserver().addOnGlobalLayoutListener(new c(surfaceTexture));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_seated_practice_timer, viewGroup, false);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.s_p_timer_layout);
        this.i0 = (TextView) inflate.findViewById(R.id.s_p_timer_txt_time_passed);
        this.j0 = (FABTracking) inflate.findViewById(R.id.s_p_timer_fab_play_pause);
        this.k0 = (FABTracking) inflate.findViewById(R.id.s_p_timer_fab_stop);
        this.l0 = (TextureView) inflate.findViewById(R.id.s_p_timer_video_sview);
        this.i0.setAccessibilityDelegate(new a());
        this.j0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        long millis = TimeUnit.MINUTES.toMillis((long) this.u0);
        this.q0 = millis;
        this.i0.setText(s.i(millis));
        this.i0.setContentDescription(s.l(n(), this.q0));
        this.k0.setImageResource(R.drawable.icon_stop);
        this.k0.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(n(), 17170432)));
        this.k0.setEnabled(false);
        this.l0.setSurfaceTextureListener(this);
        z2();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        CountDownTimer countDownTimer = this.r0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        i iVar = this.m0;
        if (iVar != null) {
            if (iVar.K()) {
                this.m0.f0();
                this.m0.O();
            }
            this.l0.destroyDrawingCache();
        }
        super.t0();
    }

    public void w2() {
        this.m0 = new i();
        try {
            this.m0.S(new h.a.a.a.d(m.x(n())));
            this.m0.Y(0.4f);
            this.m0.U(true);
            this.m0.X(new e());
            this.m0.V(new f());
            this.m0.W(new g());
            this.m0.Z(true);
            this.m0.a0(this.w0);
            this.m0.M();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void x2() {
        CountDownTimer countDownTimer = this.r0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.p0 = true;
        this.r0 = new CountDownTimerC0201d(this.q0, 1000).start();
        this.j0.setImageResource(R.drawable.icon_pause);
        this.j0.setContentDescription(Q(R.string.pause_timer));
        this.j0.announceForAccessibility(Q(R.string.pause_timer));
        this.p0 = true;
    }

    public void z2() {
        long millis = TimeUnit.MINUTES.toMillis((long) this.u0);
        this.q0 = millis;
        this.i0.setText(s.i(millis));
        this.i0.setContentDescription(s.l(n(), this.q0));
        CountDownTimer countDownTimer = this.r0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.j0.setContentDescription(Q(R.string.play_timer));
        this.j0.setImageResource(R.drawable.icon_play);
    }
}
