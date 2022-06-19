package f.a.a.a.b.b;

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
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_contacts;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_contacts_adapter */
public class y extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Act_contacts f9081c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<f.a.a.a.b.d.y> f9082d;

    /* compiled from: Item_contacts_adapter */
    public static class a extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected ImageView v;

        public a(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_contact_layout);
            this.u = (TextView) view.findViewById(R.id.item_contact_txt_name);
            this.v = (ImageView) view.findViewById(R.id.item_contact_img_delete);
        }
    }

    public y(Act_contacts act_contacts, ArrayList<f.a.a.a.b.d.y> arrayList) {
        this.f9081c = act_contacts;
        this.f9082d = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(int i2, f.a.a.a.b.d.y yVar, View view) {
        d.k("Open contact " + (i2 + 1));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(yVar.a())));
        this.f9081c.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(f.a.a.a.b.d.y yVar, View view) {
        this.f9081c.c0(yVar.a());
    }

    /* renamed from: B */
    public void m(a aVar, int i2) {
        f.a.a.a.b.d.y yVar = this.f9082d.get(i2);
        aVar.u.setText(yVar.c());
        Act_contacts act_contacts = this.f9081c;
        LinearLayout linearLayout = aVar.t;
        m.E0(act_contacts, linearLayout, yVar.c() + " " + this.f9081c.getString(R.string.contact));
        aVar.t.setOnClickListener(new c(this, i2, yVar));
        Act_contacts act_contacts2 = this.f9081c;
        ImageView imageView = aVar.v;
        m.E0(act_contacts2, imageView, this.f9081c.getString(R.string.remove_contact) + " " + yVar.c());
        aVar.v.setOnClickListener(new b(this, yVar));
    }

    /* renamed from: C */
    public a o(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9082d.size();
    }
}
