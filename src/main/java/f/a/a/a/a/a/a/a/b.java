package f.a.a.a.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import com.github.mikephil.charting.R;
import f.a.a.a.a.a.a.a.a;
import f.a.a.a.b.d.s;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_add_reward;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* compiled from: Frag_tool_rgb_what.kt */
public final class b extends vainstrum.Components.b implements TextWatcher {
    public static final a g0 = new a(null);
    public Act_rewarding_good_behavior_add_reward c0;
    private s d0;
    public BroadcastReceiver e0;
    private HashMap f0;

    /* compiled from: Frag_tool_rgb_what.kt */
    public static final class a {
        private a() {
        }

        public final b a(s sVar) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putSerializable("rgb", sVar);
            bVar.v1(bundle);
            return bVar;
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* renamed from: f.a.a.a.a.a.a.a.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_tool_rgb_what.kt */
    public static final class C0180b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f8850a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0180b(b bVar) {
            this.f8850a = bVar;
        }

        public void onReceive(Context context, Intent intent) {
            f.e(context, "context");
            f.e(intent, "intent");
            if (f.a(intent.getAction(), "gov.va.mobilehealth.ACTION_NEXT")) {
                a.C0179a aVar = a.h0;
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f8850a.X1(o.tool_rgb_what_edt);
                f.d(appCompatEditText, "tool_rgb_what_edt");
                a a2 = aVar.a(String.valueOf(appCompatEditText.getText()), this.f8850a.Z1());
                Act_rewarding_good_behavior_add_reward Y1 = this.f8850a.Y1();
                String Q = this.f8850a.Q(R.string.tags);
                f.d(Q, "getString(R.string.tags)");
                Y1.X(a2, Q);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
        b.o.a.a b2 = b.o.a.a.b(n1());
        BroadcastReceiver broadcastReceiver = this.e0;
        if (broadcastReceiver != null) {
            b2.e(broadcastReceiver);
        } else {
            f.p("bRec");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_NEXT");
        this.e0 = new C0180b(this);
        b.o.a.a b2 = b.o.a.a.b(n1());
        BroadcastReceiver broadcastReceiver = this.e0;
        if (broadcastReceiver != null) {
            b2.c(broadcastReceiver, intentFilter);
        } else {
            f.p("bRec");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        int i2 = o.tool_rgb_what_edt;
        ((AppCompatEditText) X1(i2)).addTextChangedListener(this);
        androidx.fragment.app.d n1 = n1();
        String N = j.N(n1, g.f10090j + File.separator + "54_2.json");
        f.c(N);
        g0.k(n1(), D(), (LinearLayout) X1(o.tool_rgb_what_layout_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward = this.c0;
        if (act_rewarding_good_behavior_add_reward != null) {
            act_rewarding_good_behavior_add_reward.Y(false);
            if (this.d0 != null) {
                s sVar = this.d0;
                f.c(sVar);
                ((AppCompatEditText) X1(i2)).setText(sVar.d());
                return;
            }
            return;
        }
        f.p("act");
        throw null;
    }

    public void W1() {
        HashMap hashMap = this.f0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.f0 == null) {
            this.f0 = new HashMap();
        }
        View view = (View) this.f0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.f0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Act_rewarding_good_behavior_add_reward Y1() {
        Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward = this.c0;
        if (act_rewarding_good_behavior_add_reward != null) {
            return act_rewarding_good_behavior_add_reward;
        }
        f.p("act");
        throw null;
    }

    public final s Z1() {
        return this.d0;
    }

    public void afterTextChanged(Editable editable) {
        f.c(editable);
        if (editable.length() == 0) {
            Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward = this.c0;
            if (act_rewarding_good_behavior_add_reward != null) {
                act_rewarding_good_behavior_add_reward.Y(false);
            } else {
                f.p("act");
                throw null;
            }
        } else {
            Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward2 = this.c0;
            if (act_rewarding_good_behavior_add_reward2 != null) {
                act_rewarding_good_behavior_add_reward2.Y(true);
            } else {
                f.p("act");
                throw null;
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        androidx.fragment.app.d n = n();
        Objects.requireNonNull(n, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_add_reward");
        this.c0 = (Act_rewarding_good_behavior_add_reward) n;
        if (u() != null && o1().containsKey("rgb") && o1().get("rgb") != null) {
            s sVar = (s) o1().getSerializable("rgb");
            f.c(sVar);
            this.d0 = sVar;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_tool_rgb_what, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
