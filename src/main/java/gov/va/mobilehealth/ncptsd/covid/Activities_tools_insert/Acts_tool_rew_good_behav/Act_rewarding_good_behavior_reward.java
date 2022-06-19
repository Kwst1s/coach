package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.s;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.y;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: Act_rewarding_good_behavior_reward.kt */
public final class Act_rewarding_good_behavior_reward extends f {
    private final int u = 443;
    public s v;
    private HashMap w;

    /* compiled from: Act_rewarding_good_behavior_reward.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_rewarding_good_behavior_reward f10045b;

        a(Act_rewarding_good_behavior_reward act_rewarding_good_behavior_reward) {
            this.f10045b = act_rewarding_good_behavior_reward;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f10045b.getApplicationContext(), Act_rewarding_good_behavior_add_reward.class);
            intent.putExtra("reward", this.f10045b.Y());
            Act_rewarding_good_behavior_reward act_rewarding_good_behavior_reward = this.f10045b;
            act_rewarding_good_behavior_reward.startActivityForResult(intent, act_rewarding_good_behavior_reward.X());
        }
    }

    /* compiled from: Act_rewarding_good_behavior_reward.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_rewarding_good_behavior_reward f10046b;

        /* compiled from: Act_rewarding_good_behavior_reward.kt */
        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f10047b;

            a(b bVar) {
                this.f10047b = bVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                Context applicationContext = this.f10047b.f10046b.getApplicationContext();
                kotlin.m.b.f.d(applicationContext, "applicationContext");
                new y(applicationContext).H(this.f10047b.f10046b.Y().a());
                dialogInterface.dismiss();
                this.f10047b.f10046b.finish();
            }
        }

        /* renamed from: gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_reward$b$b  reason: collision with other inner class name */
        /* compiled from: Act_rewarding_good_behavior_reward.kt */
        static final class DialogInterface$OnClickListenerC0228b implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public static final DialogInterface$OnClickListenerC0228b f10048b = new DialogInterface$OnClickListenerC0228b();

            DialogInterface$OnClickListenerC0228b() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        b(Act_rewarding_good_behavior_reward act_rewarding_good_behavior_reward) {
            this.f10046b = act_rewarding_good_behavior_reward;
        }

        public final void onClick(View view) {
            Act_rewarding_good_behavior_reward act_rewarding_good_behavior_reward = this.f10046b;
            b.a h2 = j.h(act_rewarding_good_behavior_reward, act_rewarding_good_behavior_reward.getString(R.string.really_delete_item));
            h2.k(R.string.yes, new a(this));
            h2.h(R.string.no, DialogInterface$OnClickListenerC0228b.f10048b);
            h2.a().show();
        }
    }

    public View W(int i2) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.w.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int X() {
        return this.u;
    }

    public final s Y() {
        s sVar = this.v;
        if (sVar != null) {
            return sVar;
        }
        kotlin.m.b.f.p("reward");
        throw null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.u && i3 == -1) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("reward");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.RewardGoodBehavior");
        this.v = (s) serializableExtra;
        setContentView(R.layout.act_rewarding_good_behavior_reward);
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(o.rewarding_good_behavior_reward_txt_thing_to_reward);
        kotlin.m.b.f.d(appCompatTextView, "rewarding_good_behavior_reward_txt_thing_to_reward");
        s sVar = this.v;
        if (sVar != null) {
            appCompatTextView.setText(sVar.d());
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(o.rewarding_good_behavior_reward_txt_reward_i_can_use);
            kotlin.m.b.f.d(appCompatTextView2, "rewarding_good_behavior_…ward_txt_reward_i_can_use");
            s sVar2 = this.v;
            if (sVar2 != null) {
                appCompatTextView2.setText(sVar2.c());
                ((AppCompatTextView) W(o.rewarding_good_behavior_reward_txt_edit)).setOnClickListener(new a(this));
                ((AppCompatButton) W(o.rewarding_good_behavior_reward_btn_delete_reward)).setOnClickListener(new b(this));
                T((Toolbar) W(o.rewarding_good_behavior_reward_toolbar));
                androidx.appcompat.app.a M = M();
                if (M != null) {
                    M.x(true);
                }
                androidx.appcompat.app.a M2 = M();
                if (M2 != null) {
                    M2.s(true);
                }
                androidx.appcompat.app.a M3 = M();
                if (M3 != null) {
                    M3.t(false);
                    return;
                }
                return;
            }
            kotlin.m.b.f.p("reward");
            throw null;
        }
        kotlin.m.b.f.p("reward");
        throw null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
