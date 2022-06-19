package c.c.a.g;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.esafirm.imagepicker.features.v.a;

/* compiled from: BaseListAdapter */
public abstract class f<T extends RecyclerView.d0> extends RecyclerView.g<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f3198c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f3199d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3200e;

    public f(Context context, a aVar) {
        this.f3198c = context;
        this.f3199d = LayoutInflater.from(context);
        this.f3200e = aVar;
    }

    public Context x() {
        return this.f3198c;
    }

    public a y() {
        return this.f3200e;
    }

    public LayoutInflater z() {
        return this.f3199d;
    }
}
