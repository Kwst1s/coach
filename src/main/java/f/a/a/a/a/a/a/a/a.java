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
import f.a.a.a.b.d.s;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_add_reward;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.y;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* compiled from: Frag_tool_rgb_reward.kt */
public final class a extends vainstrum.Components.b implements TextWatcher {
    public static final C0179a h0 = new C0179a(null);
    public Act_rewarding_good_behavior_add_reward c0;
    private s d0;
    public String e0;
    public BroadcastReceiver f0;
    private HashMap g0;

    /* renamed from: f.a.a.a.a.a.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_tool_rgb_reward.kt */
    public static final class C0179a {
        private C0179a() {
        }

        public final a a(String str, s sVar) {
            f.e(str, "things_to_reward");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("things_to_reward", str);
            bundle.putSerializable("rgb", sVar);
            aVar.v1(bundle);
            return aVar;
        }

        public /* synthetic */ C0179a(d dVar) {
            this();
        }
    }

    /* compiled from: Frag_tool_rgb_reward.kt */
    public static final class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f8849a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.f8849a = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            f.e(context, "context");
            f.e(intent, "intent");
            if (f.a(intent.getAction(), "gov.va.mobilehealth.ACTION_NEXT")) {
                this.f8849a.Y1();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
        b.o.a.a b2 = b.o.a.a.b(n1());
        BroadcastReceiver broadcastReceiver = this.f0;
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
        this.f0 = new b(this);
        b.o.a.a b2 = b.o.a.a.b(n1());
        BroadcastReceiver broadcastReceiver = this.f0;
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
        int i2 = o.tool_rgb_reward_edt;
        ((AppCompatEditText) X1(i2)).addTextChangedListener(this);
        androidx.fragment.app.d n1 = n1();
        String N = j.N(n1, g.f10090j + File.separator + "54_3.json");
        f.c(N);
        g0.k(n1(), D(), (LinearLayout) X1(o.tool_rgb_reward_layout_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward = this.c0;
        if (act_rewarding_good_behavior_add_reward != null) {
            act_rewarding_good_behavior_add_reward.Y(false);
            if (this.d0 != null) {
                s sVar = this.d0;
                f.c(sVar);
                ((AppCompatEditText) X1(i2)).setText(sVar.c());
                return;
            }
            return;
        }
        f.p("act");
        throw null;
    }

    public void W1() {
        HashMap hashMap = this.g0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.g0 == null) {
            this.g0 = new HashMap();
        }
        View view = (View) this.g0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.g0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Y1() {
        androidx.fragment.app.d n1 = n1();
        f.d(n1, "requireActivity()");
        y yVar = new y(n1);
        AppCompatEditText appCompatEditText = (AppCompatEditText) X1(o.tool_rgb_reward_edt);
        f.d(appCompatEditText, "tool_rgb_reward_edt");
        String valueOf = String.valueOf(appCompatEditText.getText());
        s sVar = this.d0;
        if (sVar != null) {
            f.c(sVar);
            int a2 = sVar.a();
            String str = this.e0;
            if (str != null) {
                yVar.N(a2, str, valueOf);
            } else {
                f.p("things_to_reward");
                throw null;
            }
        } else {
            String str2 = this.e0;
            if (str2 != null) {
                yVar.l(str2, valueOf);
            } else {
                f.p("things_to_reward");
                throw null;
            }
        }
        k.b.d.u(n(), Q(R.string.rewarding_good_behavior));
        Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward = this.c0;
        if (act_rewarding_good_behavior_add_reward != null) {
            act_rewarding_good_behavior_add_reward.setResult(-1);
            Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward2 = this.c0;
            if (act_rewarding_good_behavior_add_reward2 != null) {
                act_rewarding_good_behavior_add_reward2.finish();
            } else {
                f.p("act");
                throw null;
            }
        } else {
            f.p("act");
            throw null;
        }
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
        if (u() != null) {
            Bundle u = u();
            Serializable serializable = null;
            String string = u != null ? u.getString("things_to_reward") : null;
            f.c(string);
            this.e0 = string;
            if (o1().containsKey("rgb") && o1().get("rgb") != null) {
                Bundle u2 = u();
                if (u2 != null) {
                    serializable = u2.getSerializable("rgb");
                }
                s sVar = (s) serializable;
                f.c(sVar);
                this.d0 = sVar;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_tool_rgb_reward, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
