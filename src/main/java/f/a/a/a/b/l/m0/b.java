package f.a.a.a.b.l.m0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.b0;
import f.a.a.a.b.d.h;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_my_feeling;
import gov.va.mobilehealth.ncptsd.covid.CComp.e0;
import java.util.ArrayList;

/* compiled from: Frag_my_feelings_choose_parent */
public class b extends vainstrum.Components.b {
    private Act_new_my_feeling c0;
    private RecyclerView d0;
    private ArrayList<h> e0;
    private BroadcastReceiver f0;

    /* compiled from: Frag_my_feelings_choose_parent */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_NEXT")) {
                b.this.c0.a0(a.Z1(b.this.Y1()), b.this.Q(R.string.my_feelings));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.f0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        X1();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_NEXT");
        this.f0 = new a();
        try {
            n().registerReceiver(this.f0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void X1() {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.e0.size()) {
                z = false;
                break;
            } else if (this.e0.get(i2).d()) {
                z = true;
                break;
            } else {
                i2++;
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
        for (int i2 = 0; i2 < this.e0.size(); i2++) {
            if (this.e0.get(i2).d()) {
                arrayList.add(this.e0.get(i2));
            }
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_new_my_feeling) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_my_feelings_choose_parent, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.my_feelings_choose_parent_rview);
        this.d0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(n()));
        this.d0.setHasFixedSize(true);
        if (this.c0.b0() == null) {
            ArrayList<h> a2 = e0.a(n());
            this.e0 = a2;
            this.c0.e0(a2);
        } else {
            this.e0 = this.c0.b0();
        }
        this.d0.setAdapter(new b0(this, this.e0));
        this.c0.c0().setText(R.string.next);
        return inflate;
    }
}
