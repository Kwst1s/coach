package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f1891a = new DataSetObservable();

    public abstract void a(ViewGroup viewGroup, int i2, Object obj);

    @Deprecated
    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object obj) {
        return -1;
    }

    public CharSequence f(int i2) {
        return null;
    }

    public float g(int i2) {
        return 1.0f;
    }

    public abstract Object h(ViewGroup viewGroup, int i2);

    public abstract boolean i(View view, Object obj);

    public void j(DataSetObserver dataSetObserver) {
        this.f1891a.registerObserver(dataSetObserver);
    }

    public void k(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable l() {
        return null;
    }

    @Deprecated
    public void m(View view, int i2, Object obj) {
    }

    public void n(ViewGroup viewGroup, int i2, Object obj) {
        m(viewGroup, i2, obj);
    }

    /* access modifiers changed from: package-private */
    public void o(DataSetObserver dataSetObserver) {
        synchronized (this) {
        }
    }

    @Deprecated
    public void p(View view) {
    }

    public void q(ViewGroup viewGroup) {
        p(viewGroup);
    }

    public void r(DataSetObserver dataSetObserver) {
        this.f1891a.unregisterObserver(dataSetObserver);
    }
}
