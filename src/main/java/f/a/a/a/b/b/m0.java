package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.h;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.w;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_strenght;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_strenghts_adapter */
public class m0 extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f8978c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<w> f8979d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_strenghts_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8980b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ w f8981c;

        a(int i2, w wVar) {
            this.f8980b = i2;
            this.f8981c = wVar;
        }

        public void onClick(View view) {
            d.k("Strenght " + (this.f8980b + 1));
            Intent intent = new Intent(m0.this.f8978c, Act_new_strenght.class);
            intent.putExtra("strenght", this.f8981c);
            m0.this.f8978c.startActivity(intent);
        }
    }

    /* compiled from: Item_strenghts_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected ImageView v;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_strenght_layout);
            this.u = (TextView) view.findViewById(R.id.item_strenght_txt);
            this.v = (ImageView) view.findViewById(R.id.item_strenght_img);
        }
    }

    public m0(Activity activity, ArrayList<w> arrayList) {
        this.f8978c = activity;
        this.f8979d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8979d.size();
    }

    /* renamed from: y */
    public void m(b bVar, int i2) {
        w wVar = this.f8979d.get(i2);
        if (!wVar.d().isEmpty()) {
            bVar.u.setText(wVar.d());
            LinearLayout linearLayout = bVar.t;
            linearLayout.setContentDescription(wVar.d() + " " + this.f8978c.getString(R.string.button));
        } else {
            bVar.u.setVisibility(8);
        }
        if (wVar.c() != null) {
            h<Drawable> s = com.bumptech.glide.b.u(this.f8978c.getApplicationContext()).s(Uri.parse(wVar.c()));
            s.v0(0.7f);
            s.o0(bVar.v);
            if (wVar.d().isEmpty()) {
                LinearLayout linearLayout2 = bVar.t;
                linearLayout2.setContentDescription(this.f8978c.getString(R.string.strenght_image) + " " + this.f8978c.getString(R.string.button));
            }
        } else {
            bVar.v.setVisibility(8);
        }
        bVar.t.setOnClickListener(new a(i2, wVar));
    }

    /* renamed from: z */
    public b o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_strenght, viewGroup, false));
    }
}
