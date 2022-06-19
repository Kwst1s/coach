package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.l;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_i_message;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_imessages_adapter */
public class g0 extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f8939c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<l> f8940d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_imessages_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8941b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f8942c;

        a(int i2, l lVar) {
            this.f8941b = i2;
            this.f8942c = lVar;
        }

        public void onClick(View view) {
            d.k("I Message  " + (this.f8941b + 1));
            Intent intent = new Intent(g0.this.f8939c, Act_new_i_message.class);
            intent.putExtra("imessage", this.f8942c);
            g0.this.f8939c.startActivity(intent);
        }
    }

    /* compiled from: Item_imessages_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected TextView v;
        protected TextView w;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_imessage_layout);
            this.u = (TextView) view.findViewById(R.id.item_imessage_txt_affect);
            this.v = (TextView) view.findViewById(R.id.item_imessage_txt_feel);
            this.w = (TextView) view.findViewById(R.id.item_imessage_txt_because);
        }
    }

    public g0(Activity activity, ArrayList<l> arrayList) {
        this.f8939c = activity;
        this.f8940d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8940d.size();
    }

    /* renamed from: y */
    public void m(b bVar, int i2) {
        l lVar = this.f8940d.get(i2);
        bVar.t.setContentDescription(this.f8939c.getString(R.string.when_my_loved_one) + " " + lVar.a() + "\n" + this.f8939c.getString(R.string.i_feel_np) + " " + lVar.d() + "\n" + this.f8939c.getString(R.string.because_np) + " " + lVar.c() + " " + this.f8939c.getString(R.string.button));
        bVar.u.setText(lVar.a());
        bVar.v.setText(lVar.d());
        bVar.w.setText(lVar.c());
        bVar.t.setOnClickListener(new a(i2, lVar));
    }

    /* renamed from: z */
    public b o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_imessages, viewGroup, false));
    }
}
