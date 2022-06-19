package f.a.a.a.b.b;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.h;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.f;
import gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools.Act_get_video;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.io.File;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_videos_adapter */
public class v0 extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Act_get_video f9060c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<f> f9061d;

    /* access modifiers changed from: package-private */
    /* compiled from: Item_videos_adapter */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9062b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f9063c;

        a(int i2, f fVar) {
            this.f9062b = i2;
            this.f9063c = fVar;
        }

        public void onClick(View view) {
            d.k("Video " + (this.f9062b + 1));
            v0.this.f9060c.W(this.f9063c);
        }
    }

    /* compiled from: Item_videos_adapter */
    public static class b extends RecyclerView.d0 {
        protected CardView t;
        protected ImageView u;
        protected TextView v;

        public b(View view, Activity activity) {
            super(view);
            this.t = (CardView) view.findViewById(R.id.item_video_card);
            this.u = (ImageView) view.findViewById(R.id.item_video_img);
            this.v = (TextView) view.findViewById(R.id.item_video_txt);
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            double r = (double) j.r(activity);
            Double.isNaN(r);
            layoutParams.height = (int) (r / 1.5d);
        }
    }

    public v0(Act_get_video act_get_video, ArrayList<f> arrayList) {
        this.f9060c = act_get_video;
        this.f9061d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9061d.size();
    }

    /* renamed from: y */
    public void m(b bVar, int i2) {
        f fVar = this.f9061d.get(i2);
        h<Drawable> s = com.bumptech.glide.b.v(this.f9060c).s(Uri.fromFile(new File(Uri.parse(fVar.c()).getPath())));
        s.v0(0.6f);
        s.o0(bVar.u);
        bVar.v.setText(fVar.a());
        CardView cardView = bVar.t;
        cardView.setContentDescription(fVar.a() + " " + this.f9060c.getString(R.string.button));
        bVar.t.setOnClickListener(new a(i2, fVar));
    }

    /* renamed from: z */
    public b o(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false), this.f9060c);
    }
}
