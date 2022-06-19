package c.c.a.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.d;
import c.c.a.f;
import c.c.a.h.c;
import c.c.a.i.b;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImagePickerAdapter */
public class h extends f<a> {

    /* renamed from: f  reason: collision with root package name */
    private List<b> f3203f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private List<b> f3204g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private c.c.a.h.b f3205h;

    /* renamed from: i  reason: collision with root package name */
    private c f3206i;

    /* access modifiers changed from: package-private */
    /* compiled from: ImagePickerAdapter */
    public static class a extends RecyclerView.d0 {
        private ImageView t;
        private View u;
        private TextView v;
        private FrameLayout w;

        a(View view) {
            super(view);
            this.w = (FrameLayout) view;
            this.t = (ImageView) view.findViewById(c.c.a.c.image_view);
            this.u = view.findViewById(c.c.a.c.p);
            this.v = (TextView) view.findViewById(c.c.a.c.ef_item_file_type_indicator);
        }
    }

    public h(Context context, com.esafirm.imagepicker.features.v.a aVar, List<b> list, c.c.a.h.b bVar) {
        super(context, aVar);
        this.f3205h = bVar;
        if (list != null && !list.isEmpty()) {
            this.f3204g.addAll(list);
        }
    }

    private void A(b bVar, int i2) {
        L(new e(this, bVar, i2));
    }

    private boolean C(b bVar) {
        for (b bVar2 : this.f3204g) {
            if (bVar2.g().equals(bVar.g())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(b bVar, int i2) {
        this.f3204g.add(bVar);
        i(i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(boolean z, b bVar, int i2, View view) {
        boolean a2 = this.f3205h.a(z);
        if (z) {
            P(bVar, i2);
        } else if (a2) {
            A(bVar, i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I() {
        this.f3204g.clear();
        h();
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(b bVar, int i2) {
        this.f3204g.remove(bVar);
        i(i2);
    }

    private void L(Runnable runnable) {
        runnable.run();
        c cVar = this.f3206i;
        if (cVar != null) {
            cVar.a(this.f3204g);
        }
    }

    private void P(b bVar, int i2) {
        L(new b(this, bVar, i2));
    }

    public List<b> B() {
        return this.f3204g;
    }

    /* renamed from: M */
    public void m(a aVar, int i2) {
        boolean z;
        String str;
        b bVar = this.f3203f.get(i2);
        boolean C = C(bVar);
        y().b(bVar.g(), aVar.t, com.esafirm.imagepicker.features.v.b.GALLERY);
        boolean z2 = true;
        int i3 = 0;
        if (com.esafirm.imagepicker.helper.c.e(bVar)) {
            str = x().getResources().getString(f.ef_gif);
            z = true;
        } else {
            str = BuildConfig.FLAVOR;
            z = false;
        }
        if (com.esafirm.imagepicker.helper.c.g(bVar)) {
            str = x().getResources().getString(f.ef_video);
        } else {
            z2 = z;
        }
        aVar.v.setText(str);
        TextView textView = aVar.v;
        if (!z2) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        aVar.u.setAlpha(C ? 0.5f : Utils.FLOAT_EPSILON);
        aVar.f1565a.setOnClickListener(new c(this, C, bVar, i2));
        aVar.w.setForeground(C ? b.h.d.a.d(x(), c.c.a.b.ef_ic_done_white) : null);
    }

    /* renamed from: N */
    public a o(ViewGroup viewGroup, int i2) {
        return new a(z().inflate(d.ef_imagepicker_item_image, viewGroup, false));
    }

    public void O() {
        L(new d(this));
    }

    public void Q(List<b> list) {
        this.f3203f.clear();
        this.f3203f.addAll(list);
    }

    public void R(c cVar) {
        this.f3206i = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f3203f.size();
    }
}
