package f.a.a.a.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.z;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_music;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;

/* compiled from: Item_music_adapter */
public class i0 extends RecyclerView.g<c> {

    /* renamed from: c  reason: collision with root package name */
    private Act_music f8951c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<z> f8952d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_music_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f8953b;

        a(z zVar) {
            this.f8953b = zVar;
        }

        public void onClick(View view) {
            i0.this.f8951c.k0(this.f8953b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_music_adapter */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f8955b;

        b(z zVar) {
            this.f8955b = zVar;
        }

        public void onClick(View view) {
            i0.this.f8951c.l0(this.f8955b.d());
        }
    }

    /* compiled from: Item_music_adapter */
    public static class c extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected TextView v;
        protected ImageView w;
        protected ImageView x;

        public c(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_music_layout);
            this.u = (TextView) view.findViewById(R.id.item_music_txt_title);
            this.v = (TextView) view.findViewById(R.id.item_music_txt_artist);
            this.w = (ImageView) view.findViewById(R.id.item_music_img_delete);
            this.x = (ImageView) view.findViewById(R.id.item_music_img_playing);
        }
    }

    public i0(Act_music act_music, ArrayList<z> arrayList) {
        this.f8951c = act_music;
        this.f8952d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f8952d.size();
    }

    /* renamed from: y */
    public void m(c cVar, int i2) {
        z zVar = this.f8952d.get(i2);
        if (zVar.c() != null) {
            cVar.u.setText(zVar.c());
        } else {
            cVar.u.setText(R.string.no_title);
        }
        if (zVar.a() != null) {
            cVar.v.setText(zVar.c());
        } else {
            cVar.v.setText(R.string.no_artist);
        }
        if (zVar.e()) {
            cVar.x.setVisibility(0);
        } else {
            cVar.x.setVisibility(8);
        }
        Act_music act_music = this.f8951c;
        LinearLayout linearLayout = cVar.t;
        m.E0(act_music, linearLayout, this.f8951c.getString(R.string.music) + " " + cVar.u.getText().toString());
        cVar.t.setOnClickListener(new a(zVar));
        if (zVar.c() != null) {
            ImageView imageView = cVar.w;
            imageView.setContentDescription(this.f8951c.getString(R.string.remove_music) + " " + zVar.c());
        } else {
            ImageView imageView2 = cVar.w;
            imageView2.setContentDescription(this.f8951c.getString(R.string.remove_music) + " " + this.f8951c.getString(R.string.no_title));
        }
        Act_music act_music2 = this.f8951c;
        ImageView imageView3 = cVar.w;
        m.E0(act_music2, imageView3, this.f8951c.getString(R.string.remove_music) + " " + cVar.u.getText().toString());
        cVar.w.setOnClickListener(new b(zVar));
    }

    /* renamed from: z */
    public c o(ViewGroup viewGroup, int i2) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_music, viewGroup, false));
    }
}
