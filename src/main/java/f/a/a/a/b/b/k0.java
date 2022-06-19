package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.s;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav.Act_rewarding_good_behavior_reward;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.ArrayList;
import kotlin.m.b.f;

/* compiled from: Item_rgbs_adapter.kt */
public final class k0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private final int f8967c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f8968d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<s> f8969e;

    /* compiled from: Item_rgbs_adapter.kt */
    public final class a extends RecyclerView.d0 {
        private CardView t;
        private AppCompatTextView u;
        private AppCompatTextView v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k0 k0Var, View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_rewards_card);
            f.d(findViewById, "itemView.findViewById(R.id.item_rewards_card)");
            this.t = (CardView) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_rewards_txt_thing_to_reward);
            f.d(findViewById2, "itemView.findViewById(R.…ards_txt_thing_to_reward)");
            this.u = (AppCompatTextView) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_rewards_txt_reward_i_can_use);
            f.d(findViewById3, "itemView.findViewById(R.…rds_txt_reward_i_can_use)");
            this.v = (AppCompatTextView) findViewById3;
        }

        public final CardView M() {
            return this.t;
        }

        public final AppCompatTextView N() {
            return this.v;
        }

        public final AppCompatTextView O() {
            return this.u;
        }
    }

    /* compiled from: Item_rgbs_adapter.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k0 f8970b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f8971c;

        b(k0 k0Var, s sVar) {
            this.f8970b = k0Var;
            this.f8971c = sVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f8970b.x(), Act_rewarding_good_behavior_reward.class);
            intent.putExtra("reward", this.f8971c);
            this.f8970b.x().startActivity(intent);
        }
    }

    public k0(Activity activity, ArrayList<s> arrayList) {
        f.e(activity, "act");
        this.f8968d = activity;
        this.f8969e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        ArrayList<s> arrayList = this.f8969e;
        f.c(arrayList);
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return this.f8967c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        f.e(d0Var, "holder");
        ArrayList<s> arrayList = this.f8969e;
        f.c(arrayList);
        s sVar = arrayList.get(i2);
        f.d(sVar, "items!!.get(position)");
        s sVar2 = sVar;
        if (d0Var instanceof a) {
            Activity activity = this.f8968d;
            a aVar = (a) d0Var;
            CardView M = aVar.M();
            j.U(activity, M, sVar2.d() + "\n" + sVar2.c());
            aVar.O().setText(sVar2.d());
            aVar.N().setText(sVar2.c());
            aVar.M().setOnClickListener(new b(this, sVar2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f8968d).inflate(R.layout.item_rewards, viewGroup, false);
        f.d(inflate, "LayoutInflater.from(act)…m_rewards, parent, false)");
        return new a(this, inflate);
    }

    public final Activity x() {
        return this.f8968d;
    }
}
