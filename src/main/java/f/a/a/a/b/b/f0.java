package f.a.a.a.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import f.a.a.a.b.d.m;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_pictures;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.ArrayList;
import k.b.d;

/* compiled from: Item_images_adapter */
public class f0 extends RecyclerView.g<RecyclerView.d0> {

    /* renamed from: c  reason: collision with root package name */
    private Act_pictures f8930c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<m> f8931d;

    /* renamed from: e  reason: collision with root package name */
    private int f8932e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8933f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f8934g = 0;

    /* compiled from: Item_images_adapter */
    public static class a extends RecyclerView.d0 {
        public a(View view) {
            super(view);
        }
    }

    /* compiled from: Item_images_adapter */
    public static class b extends RecyclerView.d0 {
        protected RelativeLayout t;
        protected AppCompatImageView u;
        protected ImageView v;
        protected View w;

        public b(int i2, View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.item_image_layout);
            this.u = (AppCompatImageView) view.findViewById(R.id.item_image_img_img);
            this.v = (ImageView) view.findViewById(R.id.item_image_img_check);
            this.w = view.findViewById(R.id.item_image_white_alpha);
            view.getLayoutParams().height = i2;
        }
    }

    public f0(Act_pictures act_pictures, ArrayList<m> arrayList, boolean z) {
        this.f8930c = act_pictures;
        this.f8931d = arrayList;
        double r = (double) j.r(act_pictures);
        Double.isNaN(r);
        this.f8932e = (int) (r / 3.3d);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(m mVar, RecyclerView.d0 d0Var, b bVar, View view) {
        if (this.f8930c.a0()) {
            if (this.f8930c.p0(mVar.c())) {
                d.k("Deselected image " + (d0Var.j() + 1));
                bVar.v.setImageResource(R.drawable.radio_checked);
                bVar.u.setScaleX(0.9f);
                bVar.u.setScaleY(0.9f);
                bVar.w.setVisibility(0);
                RelativeLayout relativeLayout = bVar.t;
                relativeLayout.setContentDescription(this.f8930c.getString(R.string.image) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.m.t(this.f8930c, mVar.a()) + " " + this.f8930c.getString(R.string.selected));
            } else {
                d.k("Selected image " + (d0Var.j() + 1));
                RelativeLayout relativeLayout2 = bVar.t;
                relativeLayout2.setContentDescription(this.f8930c.getString(R.string.image) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.m.t(this.f8930c, mVar.a()));
                bVar.v.setImageResource(R.drawable.radio_unckecked);
                bVar.u.setScaleX(1.0f);
                bVar.u.setScaleY(1.0f);
                bVar.w.setVisibility(8);
                bVar.t.announceForAccessibility(this.f8930c.getString(R.string.deselected));
            }
            int size = this.f8930c.Z().size();
            this.f8930c.r0(size);
            if (size == 0) {
                this.f8930c.n0(true);
            } else {
                this.f8930c.n0(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ boolean A(m mVar, b bVar, int i2, View view) {
        if (this.f8930c.a0()) {
            return false;
        }
        this.f8930c.o0(true);
        this.f8930c.p0(mVar.c());
        this.f8930c.r0(1);
        bVar.t.announceForAccessibility(this.f8930c.getString(R.string.entered_edit_mode));
        d.k("Enter edit mode");
        h();
        this.f8933f = true;
        this.f8934g = i2;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        if (this.f8931d.size() == 0) {
            return 0;
        }
        return this.f8931d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e(int i2) {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void m(RecyclerView.d0 d0Var, int i2) {
        if (d0Var instanceof b) {
            b bVar = (b) d0Var;
            m mVar = this.f8931d.get(i2);
            x i3 = t.g().i(mVar.c());
            int i4 = this.f8932e;
            i3.h(i4, i4);
            i3.g();
            i3.a();
            i3.e(bVar.u);
            Act_pictures act_pictures = this.f8930c;
            AppCompatImageView appCompatImageView = bVar.u;
            gov.va.mobilehealth.ncptsd.covid.CComp.m.E0(act_pictures, appCompatImageView, this.f8930c.getString(R.string.image_number) + " " + i2);
            if (this.f8930c.b0(mVar.c())) {
                RelativeLayout relativeLayout = bVar.t;
                relativeLayout.setContentDescription(this.f8930c.getString(R.string.image) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.m.t(this.f8930c, mVar.a()) + " " + this.f8930c.getString(R.string.selected));
                bVar.v.setImageResource(R.drawable.radio_checked);
                bVar.u.setScaleX(0.9f);
                bVar.u.setScaleY(0.9f);
                bVar.w.setVisibility(0);
            } else {
                RelativeLayout relativeLayout2 = bVar.t;
                relativeLayout2.setContentDescription(this.f8930c.getString(R.string.image) + " " + gov.va.mobilehealth.ncptsd.covid.CComp.m.t(this.f8930c, mVar.a()));
                bVar.v.setImageResource(R.drawable.radio_unckecked);
                bVar.u.setScaleX(1.0f);
                bVar.u.setScaleY(1.0f);
                bVar.w.setVisibility(8);
            }
            if (this.f8930c.a0()) {
                bVar.v.setVisibility(0);
            } else {
                bVar.v.setVisibility(8);
            }
            bVar.t.setOnClickListener(new f(this, mVar, d0Var, bVar));
            if (this.f8933f && i2 == this.f8934g) {
                s.a(bVar.t);
                this.f8933f = false;
            }
            bVar.t.setOnLongClickListener(new g(this, mVar, bVar, i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 o(ViewGroup viewGroup, int i2) {
        if (i2 != 2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image_header, viewGroup, false));
        }
        return new b(this.f8932e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false));
    }
}
