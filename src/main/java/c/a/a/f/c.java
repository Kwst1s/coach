package c.a.a.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: CustomImageSelectAdapter */
public class c extends b<c.a.a.h.b> {

    /* compiled from: CustomImageSelectAdapter */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f3043a;

        /* renamed from: b  reason: collision with root package name */
        public View f3044b;

        private b() {
        }
    }

    public c(Context context, ArrayList<c.a.a.h.b> arrayList) {
        super(context, arrayList);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f3041d.inflate(c.a.a.c.grid_view_item_image_select, (ViewGroup) null);
            bVar = new b();
            bVar.f3043a = (ImageView) view.findViewById(c.a.a.b.image_view_image_select);
            bVar.f3044b = view.findViewById(c.a.a.b.m);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f3043a.getLayoutParams().width = this.f3042e;
        bVar.f3043a.getLayoutParams().height = this.f3042e;
        bVar.f3044b.getLayoutParams().width = this.f3042e;
        bVar.f3044b.getLayoutParams().height = this.f3042e;
        if (this.f3039b.get(i2).f3051e) {
            bVar.f3044b.setAlpha(0.5f);
            FrameLayout frameLayout = (FrameLayout) view;
            frameLayout.setContentDescription("Image " + Integer.toString(i2) + "selected");
            frameLayout.setForeground(b.h.d.a.d(this.f3040c, c.a.a.a.ic_done_white));
        } else {
            bVar.f3044b.setAlpha(Utils.FLOAT_EPSILON);
            FrameLayout frameLayout2 = (FrameLayout) view;
            frameLayout2.setContentDescription("Image " + Integer.toString(i2));
            frameLayout2.setForeground(null);
        }
        com.bumptech.glide.b.u(this.f3040c).t(this.f3039b.get(i2).f3050d).o0(bVar.f3043a);
        return view;
    }
}
