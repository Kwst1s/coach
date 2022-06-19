package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.m;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_fullscreen_slideshow;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_pictures;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import k.b.d;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_soothing_pictures_new */
public class e0 extends vainstrum.Components.b implements View.OnClickListener {
    private boolean A0 = false;
    private ArrayList<m> B0;
    private BroadcastReceiver C0;
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private FABTracking g0;
    private Button h0;
    private ViewSwitcher i0;
    private RelativeLayout j0;
    private ImageView k0;
    private ImageView l0;
    private AppCompatTextView m0;
    private b0 n0;
    private b0 o0;
    private a0 p0;
    private int q0;
    private String r0;
    private Boolean s0;
    private Boolean t0;
    private Handler u0;
    private Runnable v0;
    private int w0 = -1;
    private int x0 = -1;
    private String y0 = null;
    private boolean z0 = false;

    /* compiled from: Frag_tool_soothing_pictures_new */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            d.j(e0.this.n(), "38656");
            e0.this.z0 = false;
            e0.this.p2();
        }
    }

    /* compiled from: Frag_tool_soothing_pictures_new */
    class b extends c.d.a.a {
        b(Context context) {
            super(context);
        }

        @Override // c.d.a.a
        public void a() {
            d.j(e0.this.n(), "38656");
            e0.this.z0 = false;
            e0.this.p2();
        }

        @Override // c.d.a.a
        public void e() {
            d.j(e0.this.n(), "38656");
            e0.this.z0 = false;
            e0.this.p2();
        }

        @Override // c.d.a.a
        public void f() {
            d.j(e0.this.n(), "38656");
            e0.this.z0 = true;
            e0.this.p2();
        }
    }

    /* compiled from: Frag_tool_soothing_pictures_new */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (e0.this.q0 == -1) {
                e0.this.c0.finish();
                return;
            }
            h W1 = h.W1(e0.this.n0, e0.this.p0, e0.this.q0, e0.this.r0);
            W1.V1(e0.this.R1());
            e0.this.c0.W(W1, e0.this.Q(R.string.distress_meter));
        }
    }

    public e0() {
        Boolean bool = Boolean.FALSE;
        this.s0 = bool;
        this.t0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void e2() {
        this.z0 = false;
        p2();
        this.u0.postDelayed(this.v0, TimeUnit.SECONDS.toMillis((long) gov.va.mobilehealth.ncptsd.covid.CComp.m.B(n())));
    }

    /* access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ void g2() {
        n().runOnUiThread(new g(this));
    }

    public static e0 h2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        e0 e0Var = new e0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        e0Var.v1(bundle);
        return e0Var;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.C0);
        j2();
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.C0 = new c();
        try {
            n().registerReceiver(this.C0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        o2();
        super.J0();
    }

    public void c2() {
        if (this.w0 == this.k0.getId()) {
            this.w0 = this.l0.getId();
            this.i0.showNext();
            return;
        }
        this.w0 = this.k0.getId();
        this.i0.showPrevious();
    }

    public void i2() {
        m2(this.l0);
        this.i0.announceForAccessibility(Q(R.string.image_changed));
        ViewSwitcher viewSwitcher = this.i0;
        viewSwitcher.setContentDescription(this.y0 + ", " + Q(R.string.tap_to_load_the_next_image));
        c2();
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        super.j0(i2, i3, intent);
        if (i2 == 882) {
            this.A0 = true;
        }
    }

    public void j2() {
        Handler handler = this.u0;
        if (handler != null) {
            handler.removeCallbacks(this.v0);
        }
    }

    public void k2() {
        m2(this.k0);
        this.i0.announceForAccessibility(Q(R.string.image_changed));
        ViewSwitcher viewSwitcher = this.i0;
        viewSwitcher.setContentDescription(this.y0 + ", " + Q(R.string.tap_to_load_the_next_image));
        c2();
    }

    public void l2() {
        this.u0.removeCallbacks(this.v0);
        this.u0.postDelayed(this.v0, TimeUnit.SECONDS.toMillis((long) gov.va.mobilehealth.ncptsd.covid.CComp.m.B(n())));
    }

    public void m2(ImageView imageView) {
        if (!this.z0) {
            int i2 = this.x0 + 1;
            this.x0 = i2;
            if (i2 >= this.B0.size()) {
                this.x0 = 0;
            }
        } else {
            int i3 = this.x0 - 1;
            this.x0 = i3;
            if (i3 == -1) {
                this.x0 = this.B0.size() - 1;
            }
        }
        Uri c2 = this.B0.get(this.x0).c();
        this.y0 = gov.va.mobilehealth.ncptsd.covid.CComp.m.t(n(), this.B0.get(this.x0).a());
        if (gov.va.mobilehealth.ncptsd.covid.CComp.m.j0(c2)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageURI(c2);
    }

    public void n2() {
        Animation animation;
        Animation animation2;
        int A = gov.va.mobilehealth.ncptsd.covid.CComp.m.A(n());
        if (A == 2) {
            animation2 = AnimationUtils.loadAnimation(n(), R.anim.cross_fade_in);
            animation = AnimationUtils.loadAnimation(n(), R.anim.cross_fade_out);
            animation2.setDuration(1000);
            animation.setDuration(1000);
        } else if (A != 3) {
            if (this.z0) {
                animation2 = AnimationUtils.loadAnimation(n(), R.anim.slide_in_left_img);
                animation = AnimationUtils.loadAnimation(n(), R.anim.slide_out_right_img);
            } else {
                animation2 = AnimationUtils.loadAnimation(n(), R.anim.slide_in_right_img);
                animation = AnimationUtils.loadAnimation(n(), R.anim.slide_out_left_img);
            }
            animation2.setDuration(500);
            animation.setDuration(500);
        } else {
            animation2 = AnimationUtils.loadAnimation(n(), R.anim.fade_in);
            animation = AnimationUtils.loadAnimation(n(), R.anim.fade_out);
            animation2.setDuration(500);
            animation.setDuration(500);
            animation2.setStartOffset(500);
        }
        this.i0.setInAnimation(animation2);
        this.i0.setOutAnimation(animation);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.n0 = (b0) bundle.getSerializable("tool");
            this.o0 = (b0) bundle.getSerializable("selected_tool");
            this.p0 = (a0) bundle.getSerializable("symptom");
            this.q0 = bundle.getInt("old_distress");
            this.r0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.n0 = (b0) u().getSerializable("tool");
            this.o0 = (b0) u().getSerializable("selected_tool");
            this.p0 = (a0) u().getSerializable("symptom");
            this.q0 = u().getInt("old_distress");
            this.r0 = u().getString("last_tool_name");
            d.u(n(), this.o0.g());
        }
    }

    public void o2() {
        if (!this.A0) {
            this.B0 = new u(n()).r0(n(), true);
        }
        if (!this.B0.isEmpty()) {
            this.m0.setVisibility(8);
            this.i0.setVisibility(0);
            if (this.w0 == -1) {
                this.w0 = this.k0.getId();
                m2(this.k0);
                ViewSwitcher viewSwitcher = this.i0;
                viewSwitcher.setContentDescription(this.y0 + ", " + Q(R.string.tap_to_load_the_next_image));
            }
            this.u0 = new Handler();
            this.v0 = new h(this);
            l2();
        } else {
            this.m0.setVisibility(0);
            this.i0.setVisibility(8);
        }
        this.A0 = false;
    }

    public void onClick(View view) {
        ArrayList<m> arrayList;
        if (view.getId() == this.d0.getId()) {
            this.t0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.o(n(), this.o0, this.d0, this.e0, this.t0, this.s0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.s0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.n(n(), this.o0, this.d0, this.e0, this.t0, this.s0));
            this.t0 = Boolean.FALSE;
        }
        if (view.getId() == this.h0.getId()) {
            gov.va.mobilehealth.ncptsd.covid.CComp.m.c0(true, this.c0, this.p0, this.n0, this.q0);
        }
        if (view.getId() == this.f0.getId()) {
            Intent intent = new Intent(n(), Act_pictures.class);
            intent.putExtra("soothing", true);
            intent.putExtra("title", Q(R.string.add_photos));
            F1(intent);
        }
        if (view.getId() == this.g0.getId() && (arrayList = this.B0) != null && !arrayList.isEmpty()) {
            Intent intent2 = new Intent(n(), Act_fullscreen_slideshow.class);
            intent2.putExtra("curImgPos", this.x0);
            H1(intent2, 882);
        }
    }

    public void p2() {
        n2();
        if (this.w0 == this.k0.getId()) {
            i2();
        } else {
            k2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_soothing_pictures_new, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.h0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_add_image);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_fullscreen);
        this.j0 = (RelativeLayout) inflate.findViewById(R.id.soothing_pictures_new_viewswitcher_layout);
        this.i0 = (ViewSwitcher) inflate.findViewById(R.id.soothing_pictures_new_viewswitcher);
        this.m0 = (AppCompatTextView) inflate.findViewById(R.id.soothing_pictures_new_txt_no_imgs);
        this.k0 = (ImageView) inflate.findViewById(R.id.soothing_pictures_new_img_1);
        this.l0 = (ImageView) inflate.findViewById(R.id.soothing_pictures_new_img_2);
        if (this.p0 == null) {
            this.h0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        gov.va.mobilehealth.ncptsd.covid.CComp.m.f0(this.o0.d(), this.d0, this.e0);
        this.t0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.C0(n(), this.o0.d(), this.d0, false));
        this.s0 = Boolean.valueOf(gov.va.mobilehealth.ncptsd.covid.CComp.m.B0(n(), this.o0.d(), this.e0, false));
        this.j0.getLayoutParams().height = (j.r(n()) * 2) / 3;
        this.i0.setOnClickListener(new a());
        this.i0.setOnTouchListener(new b(n()));
        return inflate;
    }
}
