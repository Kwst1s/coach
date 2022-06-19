package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction */
public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<a> f1345a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f1346b;

    /* renamed from: c  reason: collision with root package name */
    int f1347c;

    /* renamed from: d  reason: collision with root package name */
    int f1348d;

    /* renamed from: e  reason: collision with root package name */
    int f1349e;

    /* renamed from: f  reason: collision with root package name */
    int f1350f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1351g;

    /* renamed from: h  reason: collision with root package name */
    boolean f1352h = true;

    /* renamed from: i  reason: collision with root package name */
    String f1353i;

    /* renamed from: j  reason: collision with root package name */
    int f1354j;

    /* renamed from: k  reason: collision with root package name */
    CharSequence f1355k;
    int l;
    CharSequence m;
    ArrayList<String> n;
    ArrayList<String> o;
    boolean p = false;
    ArrayList<Runnable> q;

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentTransaction */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f1356a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f1357b;

        /* renamed from: c  reason: collision with root package name */
        int f1358c;

        /* renamed from: d  reason: collision with root package name */
        int f1359d;

        /* renamed from: e  reason: collision with root package name */
        int f1360e;

        /* renamed from: f  reason: collision with root package name */
        int f1361f;

        /* renamed from: g  reason: collision with root package name */
        e.b f1362g;

        /* renamed from: h  reason: collision with root package name */
        e.b f1363h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f1356a = i2;
            this.f1357b = fragment;
            e.b bVar = e.b.RESUMED;
            this.f1362g = bVar;
            this.f1363h = bVar;
        }

        a(int i2, Fragment fragment, e.b bVar) {
            this.f1356a = i2;
            this.f1357b = fragment;
            this.f1362g = fragment.Q;
            this.f1363h = bVar;
        }
    }

    u(i iVar, ClassLoader classLoader) {
    }

    public u c(int i2, Fragment fragment) {
        n(i2, fragment, null, 1);
        return this;
    }

    public u d(int i2, Fragment fragment, String str) {
        n(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public u e(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.G = viewGroup;
        d(viewGroup.getId(), fragment, str);
        return this;
    }

    public u f(Fragment fragment, String str) {
        n(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void g(a aVar) {
        this.f1345a.add(aVar);
        aVar.f1358c = this.f1346b;
        aVar.f1359d = this.f1347c;
        aVar.f1360e = this.f1348d;
        aVar.f1361f = this.f1349e;
    }

    public u h(String str) {
        if (this.f1352h) {
            this.f1351g = true;
            this.f1353i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public u m() {
        if (!this.f1351g) {
            this.f1352h = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void n(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.y;
            if (str2 == null || str.equals(str2)) {
                fragment.y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.w;
                if (i4 == 0 || i4 == i2) {
                    fragment.w = i2;
                    fragment.x = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        g(new a(i3, fragment));
    }

    public u o(Fragment fragment) {
        g(new a(3, fragment));
        return this;
    }

    public u p(int i2, Fragment fragment) {
        q(i2, fragment, null);
        return this;
    }

    public u q(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            n(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public u r(int i2, int i3, int i4, int i5) {
        this.f1346b = i2;
        this.f1347c = i3;
        this.f1348d = i4;
        this.f1349e = i5;
        return this;
    }

    public u s(Fragment fragment, e.b bVar) {
        g(new a(10, fragment, bVar));
        return this;
    }

    public u t(boolean z) {
        this.p = z;
        return this;
    }
}
