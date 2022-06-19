package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.y;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;

/* compiled from: Item_contacts_crisis_resources */
public class z extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f9084c;

    /* renamed from: d  reason: collision with root package name */
    private f.a.a.a.b.k.d f9085d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<y> f9086e;

    /* renamed from: f  reason: collision with root package name */
    private String f9087f = null;

    /* compiled from: Item_contacts_crisis_resources */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9088b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f9089c;

        a(int i2, y yVar) {
            this.f9088b = i2;
            this.f9089c = yVar;
        }

        public void onClick(View view) {
            k.b.d.k("Open contact " + this.f9088b);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(this.f9089c.a())));
            z.this.f9084c.startActivity(intent);
        }
    }

    /* compiled from: Item_contacts_crisis_resources */
    class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9091b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f9092c;

        b(int i2, y yVar) {
            this.f9091b = i2;
            this.f9092c = yVar;
        }

        public void onClick(View view) {
            k.b.d.k("Delete contact " + this.f9091b);
            z.this.f9085d.d2(this.f9092c.a());
        }
    }

    /* compiled from: Item_contacts_crisis_resources */
    public static class c extends RecyclerView.d0 {
        protected LinearLayout t;

        public c(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_contact_header_layout);
        }
    }

    /* compiled from: Item_contacts_crisis_resources */
    public static class d extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected ImageView v;

        public d(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_contact_layout);
            this.u = (TextView) view.findViewById(R.id.item_contact_txt_name);
            this.v = (ImageView) view.findViewById(R.id.item_contact_img_delete);
        }
    }

    public z(f.a.a.a.b.k.d dVar, Activity activity, ArrayList<y> arrayList, String str) {
        this.f9085d = dVar;
        this.f9084c = activity;
        this.f9086e = arrayList;
        this.f9087f = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9086e.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof d) {
            d dVar = (d) d0Var;
            y yVar = this.f9086e.get(i2 - 1);
            dVar.u.setText(yVar.c());
            m.E0(this.f9084c, dVar.t, yVar.c());
            dVar.t.setOnClickListener(new a(i2, yVar));
            ImageView imageView = dVar.v;
            imageView.setContentDescription(this.f9084c.getString(R.string.remove_contact) + " " + yVar.c());
            dVar.v.setOnClickListener(new b(i2, yVar));
        } else if (d0Var instanceof c) {
            Activity activity = this.f9084c;
            g0.k(activity, activity.getLayoutInflater(), ((c) d0Var).t, this.f9087f, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false));
        }
        if (i2 == 0) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact_header, viewGroup, false));
        }
        return null;
    }
}
