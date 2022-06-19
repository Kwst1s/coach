package f.a.a.a.b.b;

import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.i;
import f.a.a.a.b.d.j;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_edit_goal;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_goals;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_goals_adapter.kt */
public final class d0 extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f8910c = new SimpleDateFormat("MM/dd/yy");

    /* renamed from: d  reason: collision with root package name */
    private boolean f8911d;

    /* renamed from: e  reason: collision with root package name */
    private final Act_goals f8912e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<i> f8913f;

    /* renamed from: g  reason: collision with root package name */
    private final gov.va.mobilehealth.ncptsd.covid.CComp.d0 f8914g;

    /* compiled from: Item_goals_adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatTextView u;
        private AppCompatTextView v;
        private ImageView w;
        private ImageView x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d0 d0Var, View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_goal_layout);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.t = (LinearLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_goal_txt);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.u = (AppCompatTextView) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_goal_txt_last_update);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.v = (AppCompatTextView) findViewById3;
            View findViewById4 = this.f1565a.findViewById(R.id.item_goal_img_last_updated);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.w = (ImageView) findViewById4;
            View findViewById5 = this.f1565a.findViewById(R.id.item_goal_img_order_handler);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
            this.x = (ImageView) findViewById5;
        }

        public final ImageView M() {
            return this.x;
        }

        public final ImageView N() {
            return this.w;
        }

        public final LinearLayout O() {
            return this.t;
        }

        public final AppCompatTextView P() {
            return this.v;
        }

        public final AppCompatTextView Q() {
            return this.u;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_goals_adapter.kt */
    public static final class b implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f8915b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8916c;

        b(d0 d0Var, int i2) {
            this.f8915b = d0Var;
            this.f8916c = i2;
        }

        public final boolean onLongClick(View view) {
            this.f8915b.x().a0(this.f8916c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_goals_adapter.kt */
    public static final class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f8917b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f8918c;

        c(d0 d0Var, a aVar) {
            this.f8917b = d0Var;
            this.f8918c = aVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f8917b.y() || motionEvent.getAction() != 0) {
                return false;
            }
            this.f8917b.D(true);
            this.f8917b.z().a(this.f8918c);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_goals_adapter.kt */
    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f8919b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f8920c;

        d(d0 d0Var, i iVar) {
            this.f8919b = d0Var;
            this.f8920c = iVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f8919b.x(), Act_edit_goal.class);
            intent.putExtra("goal", this.f8920c);
            this.f8919b.x().startActivity(intent);
        }
    }

    public d0(Act_goals act_goals, ArrayList<i> arrayList, gov.va.mobilehealth.ncptsd.covid.CComp.d0 d0Var) {
        f.e(act_goals, "act");
        f.e(d0Var, "listener");
        this.f8912e = act_goals;
        this.f8913f = arrayList;
        this.f8914g = d0Var;
    }

    /* renamed from: A */
    public void m(a aVar, int i2) {
        f.e(aVar, "holder");
        ArrayList<i> arrayList = this.f8913f;
        f.c(arrayList);
        i iVar = arrayList.get(i2);
        f.d(iVar, "items!!.get(i)");
        i iVar2 = iVar;
        aVar.Q().setText(iVar2.a());
        ArrayList<j> f2 = iVar2.f();
        f.c(f2);
        ArrayList<j> f3 = iVar2.f();
        f.c(f3);
        if (f2.get(f3.size() - 1).c() == 100) {
            aVar.N().setVisibility(0);
            aVar.P().setTextColor(b.h.d.a.b(this.f8912e, R.color.green));
            AppCompatTextView P = aVar.P();
            P.setText(this.f8912e.getString(R.string.completed_on) + ": " + this.f8910c.format(Long.valueOf(iVar2.d())));
            Act_goals act_goals = this.f8912e;
            LinearLayout O = aVar.O();
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(act_goals, O, iVar2.a() + " " + this.f8912e.getString(R.string.completed_on) + ": " + this.f8910c.format(Long.valueOf(iVar2.d())));
        } else if (DateUtils.isToday(iVar2.d())) {
            aVar.N().setVisibility(0);
            aVar.P().setTextColor(b.h.d.a.b(this.f8912e, R.color.updated_today_color));
            aVar.P().setText(this.f8912e.getString(R.string.updated_today));
            Act_goals act_goals2 = this.f8912e;
            LinearLayout O2 = aVar.O();
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(act_goals2, O2, iVar2.a() + " " + this.f8912e.getString(R.string.updated_today));
        } else {
            aVar.N().setVisibility(8);
            aVar.P().setTextColor(b.h.d.a.b(this.f8912e, R.color.blue));
            aVar.P().setText(R.string.update_now);
            Act_goals act_goals3 = this.f8912e;
            LinearLayout O3 = aVar.O();
            gov.va.mobilehealth.ncptsd.covid.CComp.j.U(act_goals3, O3, iVar2.a() + " " + this.f8912e.getString(R.string.update_now));
        }
        aVar.O().setOnLongClickListener(new b(this, i2));
        aVar.M().setOnTouchListener(new c(this, aVar));
        aVar.O().setOnClickListener(new d(this, iVar2));
    }

    /* renamed from: B */
    public a o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_goal, viewGroup, false);
        f.d(inflate, "itemView");
        return new a(this, inflate);
    }

    public final void C(int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(this.f8913f, i4, i5);
                i4 = i5;
            }
        } else {
            int i6 = i3 + 1;
            if (i2 >= i6) {
                int i7 = i2;
                while (true) {
                    Collections.swap(this.f8913f, i7, i7 - 1);
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
        }
        j(i2, i3);
    }

    public final void D(boolean z) {
        this.f8911d = z;
    }

    public final void E() {
        this.f8911d = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        ArrayList<i> arrayList = this.f8913f;
        f.c(arrayList);
        return arrayList.size();
    }

    public final Act_goals x() {
        return this.f8912e;
    }

    public final boolean y() {
        return this.f8911d;
    }

    public final gov.va.mobilehealth.ncptsd.covid.CComp.d0 z() {
        return this.f8914g;
    }
}
