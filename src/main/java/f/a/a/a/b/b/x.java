package f.a.a.a.b.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_audio_file_adapter */
public class x extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Activity f9074c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<f.a.a.a.b.d.c> f9075d;

    /* renamed from: e  reason: collision with root package name */
    private c f9076e;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_audio_file_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9077b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.d.c f9078c;

        a(int i2, f.a.a.a.b.d.c cVar) {
            this.f9077b = i2;
            this.f9078c = cVar;
        }

        public void onClick(View view) {
            if (x.this.f9076e == null) {
                d.k("Sound " + (this.f9077b + 1));
                return;
            }
            x.this.f9076e.a(this.f9078c);
        }
    }

    /* compiled from: Item_audio_file_adapter */
    public static class b extends RecyclerView.d0 {
        protected LinearLayout t;
        protected TextView u;
        protected AppCompatImageView v;

        public b(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.item_audio_file_layout);
            this.u = (TextView) view.findViewById(R.id.item_audio_file_txt_title);
            this.v = (AppCompatImageView) view.findViewById(R.id.item_audio_file_img_check);
        }
    }

    /* compiled from: Item_audio_file_adapter */
    public interface c {
        void a(f.a.a.a.b.d.c cVar);
    }

    public x(Activity activity, ArrayList<f.a.a.a.b.d.c> arrayList, c cVar) {
        this.f9074c = activity;
        this.f9075d = arrayList;
        this.f9076e = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9075d.size();
    }

    /* renamed from: y */
    public void m(b bVar, int i2) {
        f.a.a.a.b.d.c cVar = this.f9075d.get(i2);
        bVar.u.setText(cVar.c());
        if (cVar.d()) {
            bVar.v.setVisibility(0);
            Activity activity = this.f9074c;
            LinearLayout linearLayout = bVar.t;
            m.E0(activity, linearLayout, cVar.c() + " " + this.f9074c.getString(R.string.playing));
        } else {
            bVar.v.setVisibility(8);
            m.E0(this.f9074c, bVar.t, cVar.c());
        }
        bVar.t.setOnClickListener(new a(i2, cVar));
    }

    /* renamed from: z */
    public b o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_audio_file, viewGroup, false));
    }
}
