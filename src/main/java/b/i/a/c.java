package b.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f2718j;

    /* renamed from: k  reason: collision with root package name */
    private int f2719k;
    private LayoutInflater l;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2719k = i2;
        this.f2718j = i2;
        this.l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // b.i.a.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.f2719k, viewGroup, false);
    }

    @Override // b.i.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.f2718j, viewGroup, false);
    }
}
