package f.a.a.a.b.h;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.d;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.u;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.b;

/* compiled from: Frag_learn_screen_layouted */
public class c extends b {
    private ImageView c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private NestedScrollView g0;
    private u h0;
    private boolean i0;
    private boolean j0 = true;

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(b0 b0Var, View view) {
        if (b0Var.e() != null) {
            Intent intent = new Intent(n1(), Act_tool_sublist.class);
            intent.putExtra("tool", b0Var);
            n1().startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(n1(), Act_manage.class);
        intent2.putExtra("tool", b0Var);
        n1().startActivity(intent2);
    }

    public static c Y1(u uVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("screen", uVar);
        cVar.v1(bundle);
        return cVar;
    }

    public static c Z1(u uVar, boolean z) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("screen", uVar);
        bundle.putBoolean("noImage", z);
        cVar.v1(bundle);
        return cVar;
    }

    public void a2(boolean z) {
        this.j0 = z;
    }

    public void b2() {
        if (this.h0.f() == null) {
            this.e0.setVisibility(8);
        } else if (this.h0.f().isEmpty()) {
            this.e0.setVisibility(8);
        } else {
            int dimensionPixelSize = K().getDimensionPixelSize(R.dimen.padding_large);
            int dimensionPixelSize2 = K().getDimensionPixelSize(R.dimen.padding_medium);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize2);
            this.e0.setVisibility(0);
            this.f0.removeAllViews();
            for (int i2 = 0; i2 < this.h0.f().size(); i2++) {
                int intValue = this.h0.f().get(i2).intValue();
                View inflate = D().inflate(R.layout.item_tool, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_tool_layout_horizontal);
                AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.item_tool_txt);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.item_tool_img);
                AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.item_tool_audio_icon);
                if (Build.VERSION.SDK_INT >= 21) {
                    linearLayout.setElevation(2.0f);
                }
                linearLayout.setLayoutParams(layoutParams);
                b0 y = m.y(p1(), intValue);
                if (y == null) {
                    y = m.Y(p1(), intValue);
                }
                if (y != null) {
                    linearLayout.setContentDescription(y.g() + " button");
                    appCompatTextView.setText(y.g());
                    d n1 = n1();
                    imageView.setImageResource(j.m(n1, "t" + y.d()));
                    linearLayout.setOnClickListener(new a(this, y));
                    if (k.f10124a.p(intValue)) {
                        appCompatImageView.setVisibility(0);
                    } else {
                        appCompatImageView.setVisibility(8);
                    }
                    this.f0.addView(inflate);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.h0 = (u) u().getSerializable("screen");
            this.i0 = u().getBoolean("noImage", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_learn_screen_layouted, viewGroup, false);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.screen_layout);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.screen_layout_related_tools);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.screen_layout_related_tools_layout);
        this.c0 = (ImageView) inflate.findViewById(R.id.screen_img);
        this.g0 = (NestedScrollView) inflate.findViewById(R.id.screen_sview);
        String a2 = this.h0.a();
        if (this.i0) {
            this.c0.setVisibility(8);
        } else if (this.h0.d() != -1) {
            this.c0.getLayoutParams().height = m.H(n());
            d n = n();
            int n2 = j.n(n, "l" + this.h0.d() + "_big");
            if (n2 <= 0) {
                d n3 = n();
                n2 = j.m(n3, "l" + this.h0.d());
            }
            this.c0.setImageResource(n2);
        } else {
            this.c0.setVisibility(8);
        }
        g0.k(n(), D(), this.d0, a2, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        if (this.j0) {
            k.b.d.r(n(), this.h0.c());
        }
        b2();
        if (this.h0.d() == 5002) {
            this.g0.setBackgroundColor(-1);
        }
        return inflate;
    }
}
