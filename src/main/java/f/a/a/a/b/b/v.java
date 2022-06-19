package f.a.a.a.b.b;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.h;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_appreciation;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Item_appreciations_adapter.kt */
public final class v extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private final Activity f9056c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<f.a.a.a.b.d.a> f9057d;

    /* compiled from: Item_appreciations_adapter.kt */
    public final class a extends RecyclerView.d0 {
        private LinearLayout t;
        private AppCompatImageView u;
        private AppCompatTextView v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(v vVar, View view) {
            super(view);
            f.e(view, "view");
            View findViewById = this.f1565a.findViewById(R.id.item_appreciation_layout);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.t = (LinearLayout) findViewById;
            View findViewById2 = this.f1565a.findViewById(R.id.item_appreciation_img);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.u = (AppCompatImageView) findViewById2;
            View findViewById3 = this.f1565a.findViewById(R.id.item_appreciation_txt);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.v = (AppCompatTextView) findViewById3;
        }

        public final AppCompatImageView M() {
            return this.u;
        }

        public final LinearLayout N() {
            return this.t;
        }

        public final AppCompatTextView O() {
            return this.v;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Item_appreciations_adapter.kt */
    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f9058b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a.a.a.b.d.a f9059c;

        b(v vVar, f.a.a.a.b.d.a aVar) {
            this.f9058b = vVar;
            this.f9059c = aVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9058b.x(), Act_new_appreciation.class);
            intent.putExtra("appreciation", this.f9059c);
            this.f9058b.x().startActivity(intent);
        }
    }

    public v(Activity activity, ArrayList<f.a.a.a.b.d.a> arrayList) {
        f.e(activity, "act");
        f.e(arrayList, "items");
        this.f9056c = activity;
        this.f9057d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f9057d.size();
    }

    public final Activity x() {
        return this.f9056c;
    }

    /* renamed from: y */
    public void m(a aVar, int i2) {
        f.e(aVar, "holder");
        f.a.a.a.b.d.a aVar2 = this.f9057d.get(i2);
        f.d(aVar2, "items[i]");
        f.a.a.a.b.d.a aVar3 = aVar2;
        StringBuilder sb = new StringBuilder();
        if (aVar3.d() != null) {
            h<Drawable> s = com.bumptech.glide.b.t(this.f9056c).s(Uri.parse(aVar3.d()));
            s.v0(0.7f);
            s.o0(aVar.M());
            sb.append(this.f9056c.getString(R.string.image));
            sb.append("\n");
            f.d(sb, "builder.append(\"\\n\")");
        } else {
            aVar.M().setVisibility(8);
        }
        if (!(aVar3.a().length() == 0)) {
            aVar.O().setText(aVar3.a());
            sb.append(aVar3.a());
            sb.append("\n");
            f.d(sb, "builder.append(\"\\n\")");
        } else {
            aVar.O().setVisibility(8);
        }
        sb.append(this.f9056c.getString(R.string.button));
        aVar.N().setContentDescription(sb);
        aVar.N().setOnClickListener(new b(this, aVar3));
    }

    /* renamed from: z */
    public a o(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_appreciation, viewGroup, false);
        f.d(inflate, "itemView");
        return new a(this, inflate);
    }
}
