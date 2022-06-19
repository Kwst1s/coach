package f.a.a.a.b.l.m0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.a0;
import f.a.a.a.b.d.h;
import f.a.a.a.b.d.x;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_my_feeling;
import java.util.ArrayList;
import vainstrum.Components.b;

/* compiled from: Frag_my_feelings_choose_children */
public class a extends b {
    private Act_new_my_feeling c0;
    private AppCompatTextView d0;
    private RecyclerView e0;
    private ArrayList<h> f0;
    private BroadcastReceiver g0;

    /* renamed from: f.a.a.a.b.l.m0.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_my_feelings_choose_children */
    class C0209a extends BroadcastReceiver {
        C0209a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_NEXT")) {
                a.this.c0.a0(d.d2(a.this.Y1()), a.this.Q(R.string.my_feelings));
            }
        }
    }

    public static a Z1(ArrayList<h> arrayList) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("feelings", arrayList);
        aVar.v1(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.g0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_NEXT");
        this.g0 = new C0209a();
        try {
            n().registerReceiver(this.g0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void X1() {
        boolean z = false;
        for (int i2 = 0; i2 < this.f0.size(); i2++) {
            ArrayList<x> c2 = this.f0.get(i2).c();
            int i3 = 0;
            while (true) {
                if (i3 >= c2.size()) {
                    break;
                } else if (c2.get(i3).c()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (z) {
            this.c0.c0().setEnabled(true);
            this.c0.c0().setTextColor(b.h.d.a.b(n(), 17170443));
            return;
        }
        this.c0.c0().setEnabled(false);
        this.c0.c0().setTextColor(b.h.d.a.b(n(), 17170432));
    }

    public ArrayList<h> Y1() {
        ArrayList<h> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.f0.size(); i2++) {
            h hVar = this.f0.get(i2);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < hVar.c().size(); i3++) {
                x xVar = hVar.c().get(i3);
                if (xVar.c()) {
                    arrayList2.add(xVar);
                }
            }
            arrayList.add(new h(hVar.a(), arrayList2));
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_new_my_feeling) n();
        this.f0 = (ArrayList) u().getSerializable("feelings");
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_my_feelings_choose_parent, viewGroup, false);
        this.d0 = (AppCompatTextView) inflate.findViewById(R.id.my_feelings_choose_parent_txt);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.my_feelings_choose_parent_rview);
        this.e0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(n()));
        this.e0.setHasFixedSize(true);
        this.d0.setText(R.string.select_any_additional_feelings_2);
        this.e0.setAdapter(new a0(this, this.f0));
        X1();
        this.c0.c0().setText(R.string.next);
        return inflate;
    }
}
