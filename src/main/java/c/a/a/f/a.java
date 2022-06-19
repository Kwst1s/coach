package c.a.a.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.a.c;
import java.util.ArrayList;

/* compiled from: CustomAlbumSelectAdapter */
public class a extends b<c.a.a.h.a> {

    /* compiled from: CustomAlbumSelectAdapter */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f3037a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3038b;

        private b() {
        }
    }

    public a(Context context, ArrayList<c.a.a.h.a> arrayList) {
        super(context, arrayList);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f3041d.inflate(c.grid_view_item_album_select, (ViewGroup) null);
            bVar = new b();
            bVar.f3037a = (ImageView) view.findViewById(c.a.a.b.image_view_album_image);
            bVar.f3038b = (TextView) view.findViewById(c.a.a.b.text_view_album_name);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f3037a.getLayoutParams().width = this.f3042e;
        bVar.f3037a.getLayoutParams().height = this.f3042e;
        bVar.f3038b.setText(this.f3039b.get(i2).f3046a);
        com.bumptech.glide.b.u(this.f3040c).t(this.f3039b.get(i2).f3047b).o0(bVar.f3037a);
        return view;
    }
}
