package f.a.a.a.b.k;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.z;
import f.a.a.a.b.d.y;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_support_crisis_resources */
public class d extends vainstrum.Components.b implements View.OnClickListener {
    private Activity c0;
    private BottomSheetLayout d0;
    private RecyclerView e0;
    private FABTracking f0;
    private FABTracking g0;
    private ArrayList<y> h0;
    private u i0;
    private BroadcastReceiver j0;

    /* compiled from: Frag_support_crisis_resources */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                d.this.c0.finish();
            }
        }
    }

    /* compiled from: Frag_support_crisis_resources */
    class b implements DialogInterface.OnClickListener {
        b(d dVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Frag_support_crisis_resources */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9449b;

        c(String str) {
            this.f9449b = str;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            d.this.i0.d0(this.f9449b);
            int i3 = 0;
            while (true) {
                if (i3 >= d.this.h0.size()) {
                    break;
                } else if (((y) d.this.h0.get(i3)).a().equals(this.f9449b)) {
                    d.this.h0.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            d.this.e0.announceForAccessibility(d.this.Q(R.string.contact_removed));
            d.this.e2();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.k.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_support_crisis_resources */
    public class View$OnClickListenerC0195d implements View.OnClickListener {
        View$OnClickListenerC0195d() {
        }

        public void onClick(View view) {
            d.this.H1(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 77);
            d.this.d0.q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_support_crisis_resources */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/raw_contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            d.this.H1(intent, 78);
            d.this.d0.q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_support_crisis_resources */
    public class f implements View.OnClickListener {

        /* compiled from: Frag_support_crisis_resources */
        class a implements Runnable {
            a() {
            }

            public void run() {
                s.a(d.this.f0);
            }
        }

        f() {
        }

        public void onClick(View view) {
            d.this.d0.q();
            new Handler().postDelayed(new a(), 250);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_support_crisis_resources */
    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f9455b;

        g(d dVar, TextView textView) {
            this.f9455b = textView;
        }

        public void run() {
            s.a(this.f9455b);
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.j0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(int i2, String[] strArr, int[] iArr) {
        if (i2 == 80 && iArr.length > 0 && iArr[0] == 0) {
            c2();
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.j0 = new a();
        try {
            n().registerReceiver(this.j0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        m.D0(n(), this.g0, m.g0(n()), false);
        super.J0();
    }

    public void c2() {
        View inflate = LayoutInflater.from(this.c0).inflate(R.layout.bs_contacts, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bs_contacts_txt_pick);
        textView.setOnClickListener(new View$OnClickListenerC0195d());
        ((TextView) inflate.findViewById(R.id.bs_contacts_txt_create)).setOnClickListener(new e());
        ((TextView) inflate.findViewById(R.id.bs_contacts_txt_cancel)).setOnClickListener(new f());
        this.d0.C(inflate);
        new Handler().postDelayed(new g(this, textView), 250);
    }

    public void d2(String str) {
        b.a h2 = j.h(this.c0, Q(R.string.really_delete_contact));
        h2.k(R.string.yes, new c(str));
        h2.h(R.string.no, new b(this));
        h2.a().show();
    }

    public void e2() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(j.N(n(), gov.va.mobilehealth.ncptsd.covid.CComp.g.t));
            if (b0.a(n()).equals("es")) {
                ArrayList<y> arrayList = this.h0;
                if (arrayList == null) {
                    sb.append("{\"type\":\"text\",\"content\":\"Añada los contactos personales de quienes pueda comunicarse para recibir apoyo.\"}]");
                } else if (arrayList.size() == 0) {
                    sb.append("{\"type\":\"text\",\"content\":\"Añada los contactos personales de quienes pueda comunicarse para recibir apoyo.\"}]");
                } else {
                    sb.append("]");
                }
            } else {
                ArrayList<y> arrayList2 = this.h0;
                if (arrayList2 == null) {
                    sb.append("{\"type\":\"text\",\"content\":\"Add personal contacts that you can contact for support.\"}]");
                } else if (arrayList2.size() == 0) {
                    sb.append("{\"type\":\"text\",\"content\":\"Add personal contacts that you can contact for support.\"}]");
                } else {
                    sb.append("]");
                }
            }
            this.e0.setAdapter(new z(this, this.c0, this.h0, sb.toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        super.j0(i2, i3, intent);
        if ((i2 == 77 || i2 == 78) && i3 == -1) {
            Cursor query = this.c0.getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.i0.E(new y(query.getString(query.getColumnIndexOrThrow("_id")), query.getString(query.getColumnIndex("display_name"))));
                this.h0 = this.i0.p0();
                this.e0.announceForAccessibility(Q(R.string.added_new_contact));
                e2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = n();
    }

    public void onClick(View view) {
        if (view.getId() == this.f0.getId()) {
            if (b.h.d.a.a(n(), "android.permission.READ_CONTACTS") != 0) {
                m1(new String[]{"android.permission.READ_CONTACTS"}, 80);
            } else {
                c2();
            }
        }
        if (view.getId() == this.g0.getId()) {
            m.G0(n(), !m.g0(n()));
            m.D0(n(), this.g0, m.g0(n()), true);
            m.M0(n().getApplication(), true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_support_crisis_resources, (ViewGroup) null);
        this.d0 = (BottomSheetLayout) inflate.findViewById(R.id.support_crisis_resources_bs_layout);
        this.e0 = (RecyclerView) inflate.findViewById(R.id.support_crisis_resources_rview);
        this.f0 = (FABTracking) inflate.findViewById(R.id.support_crisis_resources_fab_add);
        this.g0 = (FABTracking) inflate.findViewById(R.id.support_crisis_resources_fab_thumb_up);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.c0);
        linearLayoutManager.E2(1);
        this.e0.setLayoutManager(linearLayoutManager);
        this.e0.setHasFixedSize(true);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        u uVar = new u(this.c0);
        this.i0 = uVar;
        this.h0 = uVar.p0();
        e2();
        return inflate;
    }
}
