package c.a.a.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: CustomGenericAdapter */
public abstract class b<T> extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<T> f3039b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f3040c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f3041d;

    /* renamed from: e  reason: collision with root package name */
    protected int f3042e;

    public b(Context context, ArrayList<T> arrayList) {
        this.f3039b = arrayList;
        this.f3040c = context;
        this.f3041d = LayoutInflater.from(context);
    }

    public void a() {
        this.f3039b = null;
        this.f3040c = null;
    }

    public void b(int i2) {
        this.f3042e = i2;
    }

    public int getCount() {
        return this.f3039b.size();
    }

    public T getItem(int i2) {
        return this.f3039b.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
