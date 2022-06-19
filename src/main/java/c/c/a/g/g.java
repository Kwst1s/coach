package c.c.a.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.c;
import c.c.a.d;
import com.esafirm.imagepicker.features.v.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FolderPickerAdapter */
public class g extends f<a> {

    /* renamed from: f  reason: collision with root package name */
    private final c.c.a.h.a f3201f;

    /* renamed from: g  reason: collision with root package name */
    private List<c.c.a.i.a> f3202g = new ArrayList();

    /* access modifiers changed from: package-private */
    /* compiled from: FolderPickerAdapter */
    public static class a extends RecyclerView.d0 {
        private ImageView t;
        private TextView u;
        private TextView v;

        a(View view) {
            super(view);
            this.t = (ImageView) view.findViewById(c.image);
            this.u = (TextView) view.findViewById(c.tv_name);
            this.v = (TextView) view.findViewById(c.tv_number);
        }
    }

    public g(Context context, com.esafirm.imagepicker.features.v.a aVar, c.c.a.h.a aVar2) {
        super(context, aVar);
        this.f3201f = aVar2;
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(c.c.a.i.a aVar, View view) {
        c.c.a.h.a aVar2 = this.f3201f;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    /* renamed from: C */
    public void m(a aVar, int i2) {
        c.c.a.i.a aVar2 = this.f3202g.get(i2);
        y().b(aVar2.b().get(0).g(), aVar.t, b.FOLDER);
        aVar.u.setText(this.f3202g.get(i2).a());
        aVar.v.setText(String.valueOf(this.f3202g.get(i2).b().size()));
        aVar.f1565a.setOnClickListener(new a(this, aVar2));
    }

    /* renamed from: D */
    public a o(ViewGroup viewGroup, int i2) {
        return new a(z().inflate(d.ef_imagepicker_item_folder, viewGroup, false));
    }

    public void E(List<c.c.a.i.a> list) {
        if (list != null) {
            this.f3202g.clear();
            this.f3202g.addAll(list);
        }
        h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f3202g.size();
    }
}
