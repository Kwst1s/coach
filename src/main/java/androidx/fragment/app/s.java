package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.e;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

/* compiled from: FragmentStatePagerAdapter */
public abstract class s extends a {

    /* renamed from: b  reason: collision with root package name */
    private final m f1336b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1337c;

    /* renamed from: d  reason: collision with root package name */
    private u f1338d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment.e> f1339e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Fragment> f1340f;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f1341g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1342h;

    @Deprecated
    public s(m mVar) {
        this(mVar, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1338d == null) {
            this.f1338d = this.f1336b.j();
        }
        while (this.f1339e.size() <= i2) {
            this.f1339e.add(null);
        }
        this.f1339e.set(i2, fragment.X() ? this.f1336b.W0(fragment) : null);
        this.f1340f.set(i2, null);
        this.f1338d.o(fragment);
        if (fragment.equals(this.f1341g)) {
            this.f1341g = null;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.viewpager.widget.a
    public void c(ViewGroup viewGroup) {
        u uVar = this.f1338d;
        if (uVar != null) {
            if (!this.f1342h) {
                try {
                    this.f1342h = true;
                    uVar.l();
                    this.f1342h = false;
                } catch (Throwable th) {
                    this.f1342h = false;
                    throw th;
                }
            }
            this.f1338d = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        Fragment.e eVar;
        Fragment fragment;
        if (this.f1340f.size() > i2 && (fragment = this.f1340f.get(i2)) != null) {
            return fragment;
        }
        if (this.f1338d == null) {
            this.f1338d = this.f1336b.j();
        }
        Fragment s = s(i2);
        if (this.f1339e.size() > i2 && (eVar = this.f1339e.get(i2)) != null) {
            s.x1(eVar);
        }
        while (this.f1340f.size() <= i2) {
            this.f1340f.add(null);
        }
        s.y1(false);
        if (this.f1337c == 0) {
            s.E1(false);
        }
        this.f1340f.set(i2, s);
        this.f1338d.c(viewGroup.getId(), s);
        if (this.f1337c == 1) {
            this.f1338d.s(s, e.b.STARTED);
        }
        return s;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return ((Fragment) obj).T() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void k(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1339e.clear();
            this.f1340f.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1339e.add((Fragment.e) parcelable2);
                }
            }
            for (T t : bundle.keySet()) {
                if (t.startsWith("f")) {
                    int parseInt = Integer.parseInt(t.substring(1));
                    Fragment f0 = this.f1336b.f0(bundle, t);
                    if (f0 != null) {
                        while (this.f1340f.size() <= parseInt) {
                            this.f1340f.add(null);
                        }
                        f0.y1(false);
                        this.f1340f.set(parseInt, f0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + ((String) t));
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable l() {
        Bundle bundle;
        if (this.f1339e.size() > 0) {
            bundle = new Bundle();
            Fragment.e[] eVarArr = new Fragment.e[this.f1339e.size()];
            this.f1339e.toArray(eVarArr);
            bundle.putParcelableArray("states", eVarArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f1340f.size(); i2++) {
            Fragment fragment = this.f1340f.get(i2);
            if (fragment != null && fragment.X()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f1336b.N0(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void n(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f1341g;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.y1(false);
                if (this.f1337c == 1) {
                    if (this.f1338d == null) {
                        this.f1338d = this.f1336b.j();
                    }
                    this.f1338d.s(this.f1341g, e.b.STARTED);
                } else {
                    this.f1341g.E1(false);
                }
            }
            fragment.y1(true);
            if (this.f1337c == 1) {
                if (this.f1338d == null) {
                    this.f1338d = this.f1336b.j();
                }
                this.f1338d.s(fragment, e.b.RESUMED);
            } else {
                fragment.E1(true);
            }
            this.f1341g = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void q(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public abstract Fragment s(int i2);

    public s(m mVar, int i2) {
        this.f1338d = null;
        this.f1339e = new ArrayList<>();
        this.f1340f = new ArrayList<>();
        this.f1341g = null;
        this.f1336b = mVar;
        this.f1337c = i2;
    }
}
