package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.e;
import androidx.lifecycle.w;
import b.h.k.u;
import b.l.b;

/* access modifiers changed from: package-private */
/* compiled from: FragmentStateManager */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private final l f1332a;

    /* renamed from: b  reason: collision with root package name */
    private final Fragment f1333b;

    /* renamed from: c  reason: collision with root package name */
    private int f1334c = -1;

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1335a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.lifecycle.e$b[] r0 = androidx.lifecycle.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.fragment.app.r.a.f1335a = r0
                androidx.lifecycle.e$b r1 = androidx.lifecycle.e.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.fragment.app.r.a.f1335a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.e$b r1 = androidx.lifecycle.e.b.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.fragment.app.r.a.f1335a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.e$b r1 = androidx.lifecycle.e.b.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.a.<clinit>():void");
        }
    }

    r(l lVar, Fragment fragment) {
        this.f1332a = lVar;
        this.f1333b = fragment;
    }

    private Bundle n() {
        Bundle bundle = new Bundle();
        this.f1333b.j1(bundle);
        this.f1332a.j(this.f1333b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1333b.H != null) {
            q();
        }
        if (this.f1333b.f1212d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1333b.f1212d);
        }
        if (!this.f1333b.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1333b.J);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1333b);
        }
        Fragment fragment = this.f1333b;
        fragment.P0(fragment.f1211c);
        l lVar = this.f1332a;
        Fragment fragment2 = this.f1333b;
        lVar.a(fragment2, fragment2.f1211c, false);
    }

    /* access modifiers changed from: package-private */
    public void b(j<?> jVar, m mVar, Fragment fragment) {
        Fragment fragment2 = this.f1333b;
        fragment2.t = jVar;
        fragment2.v = fragment;
        fragment2.s = mVar;
        this.f1332a.g(fragment2, jVar.h(), false);
        this.f1333b.Q0();
        Fragment fragment3 = this.f1333b;
        Fragment fragment4 = fragment3.v;
        if (fragment4 == null) {
            jVar.j(fragment3);
        } else {
            fragment4.m0(fragment3);
        }
        this.f1332a.b(this.f1333b, jVar.h(), false);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        int i2 = this.f1334c;
        Fragment fragment = this.f1333b;
        if (fragment.n) {
            if (fragment.o) {
                i2 = Math.max(i2, 1);
            } else if (i2 < 2) {
                i2 = Math.min(i2, fragment.f1210b);
            } else {
                i2 = Math.min(i2, 1);
            }
        }
        if (!this.f1333b.l) {
            i2 = Math.min(i2, 1);
        }
        Fragment fragment2 = this.f1333b;
        if (fragment2.m) {
            if (fragment2.a0()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, -1);
            }
        }
        Fragment fragment3 = this.f1333b;
        if (fragment3.I && fragment3.f1210b < 3) {
            i2 = Math.min(i2, 2);
        }
        int i3 = a.f1335a[this.f1333b.Q.ordinal()];
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return Math.min(i2, 3);
        }
        if (i3 != 3) {
            return Math.min(i2, -1);
        }
        return Math.min(i2, 1);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1333b);
        }
        Fragment fragment = this.f1333b;
        if (!fragment.P) {
            this.f1332a.h(fragment, fragment.f1211c, false);
            Fragment fragment2 = this.f1333b;
            fragment2.T0(fragment2.f1211c);
            l lVar = this.f1332a;
            Fragment fragment3 = this.f1333b;
            lVar.c(fragment3, fragment3.f1211c, false);
            return;
        }
        fragment.r1(fragment.f1211c);
        this.f1333b.f1210b = 1;
    }

    /* access modifiers changed from: package-private */
    public void e(f fVar) {
        String str;
        if (!this.f1333b.n) {
            if (m.s0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1333b);
            }
            ViewGroup viewGroup = null;
            Fragment fragment = this.f1333b;
            ViewGroup viewGroup2 = fragment.G;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i2 = fragment.x;
                if (i2 != 0) {
                    if (i2 != -1) {
                        viewGroup = (ViewGroup) fVar.b(i2);
                        if (viewGroup == null) {
                            Fragment fragment2 = this.f1333b;
                            if (!fragment2.p) {
                                try {
                                    str = fragment2.K().getResourceName(this.f1333b.x);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1333b.x) + " (" + str + ") for fragment " + this.f1333b);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f1333b + " for a container view with no id");
                    }
                }
            }
            Fragment fragment3 = this.f1333b;
            fragment3.G = viewGroup;
            fragment3.V0(fragment3.Z0(fragment3.f1211c), viewGroup, this.f1333b.f1211c);
            View view = this.f1333b.H;
            if (view != null) {
                boolean z = false;
                view.setSaveFromParentEnabled(false);
                Fragment fragment4 = this.f1333b;
                fragment4.H.setTag(b.fragment_container_view_tag, fragment4);
                if (viewGroup != null) {
                    viewGroup.addView(this.f1333b.H);
                }
                Fragment fragment5 = this.f1333b;
                if (fragment5.z) {
                    fragment5.H.setVisibility(8);
                }
                u.j0(this.f1333b.H);
                Fragment fragment6 = this.f1333b;
                fragment6.N0(fragment6.H, fragment6.f1211c);
                l lVar = this.f1332a;
                Fragment fragment7 = this.f1333b;
                lVar.m(fragment7, fragment7.H, fragment7.f1211c, false);
                Fragment fragment8 = this.f1333b;
                if (fragment8.H.getVisibility() == 0 && this.f1333b.G != null) {
                    z = true;
                }
                fragment8.L = z;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(j<?> jVar, p pVar) {
        if (m.s0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1333b);
        }
        Fragment fragment = this.f1333b;
        boolean z = true;
        boolean z2 = fragment.m && !fragment.a0();
        if (z2 || pVar.n(this.f1333b)) {
            if (jVar instanceof w) {
                z = pVar.l();
            } else if (jVar.h() instanceof Activity) {
                z = true ^ ((Activity) jVar.h()).isChangingConfigurations();
            }
            if (z2 || z) {
                pVar.f(this.f1333b);
            }
            this.f1333b.W0();
            this.f1332a.d(this.f1333b, false);
            return;
        }
        this.f1333b.f1210b = 0;
    }

    /* access modifiers changed from: package-private */
    public void g(p pVar) {
        if (m.s0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1333b);
        }
        this.f1333b.Y0();
        boolean z = false;
        this.f1332a.e(this.f1333b, false);
        Fragment fragment = this.f1333b;
        fragment.f1210b = -1;
        fragment.t = null;
        fragment.v = null;
        fragment.s = null;
        if (fragment.m && !fragment.a0()) {
            z = true;
        }
        if (z || pVar.n(this.f1333b)) {
            if (m.s0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1333b);
            }
            this.f1333b.V();
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Fragment fragment = this.f1333b;
        if (fragment.n && fragment.o && !fragment.q) {
            if (m.s0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1333b);
            }
            Fragment fragment2 = this.f1333b;
            fragment2.V0(fragment2.Z0(fragment2.f1211c), null, this.f1333b.f1211c);
            View view = this.f1333b.H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1333b;
                fragment3.H.setTag(b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f1333b;
                if (fragment4.z) {
                    fragment4.H.setVisibility(8);
                }
                Fragment fragment5 = this.f1333b;
                fragment5.N0(fragment5.H, fragment5.f1211c);
                l lVar = this.f1332a;
                Fragment fragment6 = this.f1333b;
                lVar.m(fragment6, fragment6.H, fragment6.f1211c, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment i() {
        return this.f1333b;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1333b);
        }
        this.f1333b.e1();
        this.f1332a.f(this.f1333b, false);
    }

    /* access modifiers changed from: package-private */
    public void k(ClassLoader classLoader) {
        Bundle bundle = this.f1333b.f1211c;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f1333b;
            fragment.f1212d = fragment.f1211c.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f1333b;
            fragment2.f1217i = fragment2.f1211c.getString("android:target_state");
            Fragment fragment3 = this.f1333b;
            if (fragment3.f1217i != null) {
                fragment3.f1218j = fragment3.f1211c.getInt("android:target_req_state", 0);
            }
            Fragment fragment4 = this.f1333b;
            Boolean bool = fragment4.f1213e;
            if (bool != null) {
                fragment4.J = bool.booleanValue();
                this.f1333b.f1213e = null;
            } else {
                fragment4.J = fragment4.f1211c.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment5 = this.f1333b;
            if (!fragment5.J) {
                fragment5.I = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.f1333b);
        }
        Fragment fragment = this.f1333b;
        if (fragment.H != null) {
            fragment.s1(fragment.f1211c);
        }
        this.f1333b.f1211c = null;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1333b);
        }
        this.f1333b.i1();
        this.f1332a.i(this.f1333b, false);
        Fragment fragment = this.f1333b;
        fragment.f1211c = null;
        fragment.f1212d = null;
    }

    /* access modifiers changed from: package-private */
    public Fragment.e o() {
        Bundle n;
        if (this.f1333b.f1210b <= -1 || (n = n()) == null) {
            return null;
        }
        return new Fragment.e(n);
    }

    /* access modifiers changed from: package-private */
    public q p() {
        q qVar = new q(this.f1333b);
        Fragment fragment = this.f1333b;
        if (fragment.f1210b <= -1 || qVar.n != null) {
            qVar.n = fragment.f1211c;
        } else {
            Bundle n = n();
            qVar.n = n;
            if (this.f1333b.f1217i != null) {
                if (n == null) {
                    qVar.n = new Bundle();
                }
                qVar.n.putString("android:target_state", this.f1333b.f1217i);
                int i2 = this.f1333b.f1218j;
                if (i2 != 0) {
                    qVar.n.putInt("android:target_req_state", i2);
                }
            }
        }
        return qVar;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (this.f1333b.H != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f1333b.H.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f1333b.f1212d = sparseArray;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i2) {
        this.f1334c = i2;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1333b);
        }
        this.f1333b.k1();
        this.f1332a.k(this.f1333b, false);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1333b);
        }
        this.f1333b.l1();
        this.f1332a.l(this.f1333b, false);
    }

    r(l lVar, ClassLoader classLoader, i iVar, q qVar) {
        this.f1332a = lVar;
        Fragment a2 = iVar.a(classLoader, qVar.f1322b);
        this.f1333b = a2;
        Bundle bundle = qVar.f1331k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.v1(qVar.f1331k);
        a2.f1214f = qVar.f1323c;
        a2.n = qVar.f1324d;
        a2.p = true;
        a2.w = qVar.f1325e;
        a2.x = qVar.f1326f;
        a2.y = qVar.f1327g;
        a2.B = qVar.f1328h;
        a2.m = qVar.f1329i;
        a2.A = qVar.f1330j;
        a2.z = qVar.l;
        a2.Q = e.b.values()[qVar.m];
        Bundle bundle2 = qVar.n;
        if (bundle2 != null) {
            a2.f1211c = bundle2;
        } else {
            a2.f1211c = new Bundle();
        }
        if (m.s0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    r(l lVar, Fragment fragment, q qVar) {
        this.f1332a = lVar;
        this.f1333b = fragment;
        fragment.f1212d = null;
        fragment.r = 0;
        fragment.o = false;
        fragment.l = false;
        Fragment fragment2 = fragment.f1216h;
        fragment.f1217i = fragment2 != null ? fragment2.f1214f : null;
        fragment.f1216h = null;
        Bundle bundle = qVar.n;
        if (bundle != null) {
            fragment.f1211c = bundle;
        } else {
            fragment.f1211c = new Bundle();
        }
    }
}
