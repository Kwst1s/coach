package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.m;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, i, w, androidx.savedstate.b {
    static final Object W = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E = true;
    private boolean F;
    ViewGroup G;
    View H;
    boolean I;
    boolean J = true;
    c K;
    boolean L;
    boolean M;
    float N;
    LayoutInflater O;
    boolean P;
    e.b Q = e.b.RESUMED;
    j R;
    y S;
    n<i> T = new n<>();
    androidx.savedstate.a U;
    private int V;

    /* renamed from: b  reason: collision with root package name */
    int f1210b = -1;

    /* renamed from: c  reason: collision with root package name */
    Bundle f1211c;

    /* renamed from: d  reason: collision with root package name */
    SparseArray<Parcelable> f1212d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f1213e;

    /* renamed from: f  reason: collision with root package name */
    String f1214f = UUID.randomUUID().toString();

    /* renamed from: g  reason: collision with root package name */
    Bundle f1215g;

    /* renamed from: h  reason: collision with root package name */
    Fragment f1216h;

    /* renamed from: i  reason: collision with root package name */
    String f1217i = null;

    /* renamed from: j  reason: collision with root package name */
    int f1218j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f1219k = null;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    m s;
    j<?> t;
    m u = new n();
    Fragment v;
    int w;
    int x;
    String y;
    boolean z;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public void run() {
            Fragment.this.d();
        }
    }

    class b extends f {
        b() {
        }

        @Override // androidx.fragment.app.f
        public View b(int i2) {
            View view = Fragment.this.H;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean d() {
            return Fragment.this.H != null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        View f1223a;

        /* renamed from: b  reason: collision with root package name */
        Animator f1224b;

        /* renamed from: c  reason: collision with root package name */
        int f1225c;

        /* renamed from: d  reason: collision with root package name */
        int f1226d;

        /* renamed from: e  reason: collision with root package name */
        int f1227e;

        /* renamed from: f  reason: collision with root package name */
        Object f1228f = null;

        /* renamed from: g  reason: collision with root package name */
        Object f1229g;

        /* renamed from: h  reason: collision with root package name */
        Object f1230h;

        /* renamed from: i  reason: collision with root package name */
        Object f1231i;

        /* renamed from: j  reason: collision with root package name */
        Object f1232j;

        /* renamed from: k  reason: collision with root package name */
        Object f1233k;
        Boolean l;
        Boolean m;
        m n;
        m o;
        boolean p;
        d q;
        boolean r;

        c() {
            Object obj = Fragment.W;
            this.f1229g = obj;
            this.f1230h = null;
            this.f1231i = obj;
            this.f1232j = null;
            this.f1233k = obj;
        }
    }

    /* access modifiers changed from: package-private */
    public interface d {
        void a();

        void b();
    }

    public Fragment() {
        U();
    }

    private void U() {
        this.R = new j(this);
        this.U = androidx.savedstate.a.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.R.a(new g() {
                /* class androidx.fragment.app.Fragment.AnonymousClass2 */

                @Override // androidx.lifecycle.g
                public void d(i iVar, e.a aVar) {
                    View view;
                    if (aVar == e.a.ON_STOP && (view = Fragment.this.H) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
        }
    }

    @Deprecated
    public static Fragment W(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) i.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.v1(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private c j() {
        if (this.K == null) {
            this.K = new c();
        }
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public m A() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.o;
    }

    public void A0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        j<?> jVar = this.t;
        Activity g2 = jVar == null ? null : jVar.g();
        if (g2 != null) {
            this.F = false;
            z0(g2, attributeSet, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void A1(int i2) {
        if (this.K != null || i2 != 0) {
            j();
            this.K.f1227e = i2;
        }
    }

    @Deprecated
    public final m B() {
        return this.s;
    }

    public void B0(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public void B1(d dVar) {
        j();
        c cVar = this.K;
        d dVar2 = cVar.q;
        if (dVar != dVar2) {
            if (dVar == null || dVar2 == null) {
                if (cVar.p) {
                    cVar.q = dVar;
                }
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public final Object C() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return jVar.l();
    }

    public boolean C0(MenuItem menuItem) {
        return false;
    }

    public void C1(boolean z2) {
        this.B = z2;
        m mVar = this.s;
        if (mVar == null) {
            this.C = true;
        } else if (z2) {
            mVar.f(this);
        } else {
            mVar.R0(this);
        }
    }

    public final LayoutInflater D() {
        LayoutInflater layoutInflater = this.O;
        return layoutInflater == null ? Z0(null) : layoutInflater;
    }

    public void D0(Menu menu) {
    }

    /* access modifiers changed from: package-private */
    public void D1(int i2) {
        j().f1225c = i2;
    }

    @Deprecated
    public LayoutInflater E(Bundle bundle) {
        j<?> jVar = this.t;
        if (jVar != null) {
            LayoutInflater m2 = jVar.m();
            b.h.k.g.b(m2, this.u.j0());
            return m2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void E0() {
        this.F = true;
    }

    @Deprecated
    public void E1(boolean z2) {
        if (!this.J && z2 && this.f1210b < 3 && this.s != null && X() && this.P) {
            this.s.G0(this);
        }
        this.J = z2;
        this.I = this.f1210b < 3 && !z2;
        if (this.f1211c != null) {
            this.f1213e = Boolean.valueOf(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public int F() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.f1226d;
    }

    public void F0(boolean z2) {
    }

    public void F1(@SuppressLint({"UnknownNullness"}) Intent intent) {
        G1(intent, null);
    }

    /* access modifiers changed from: package-private */
    public int G() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.f1227e;
    }

    public void G0(Menu menu) {
    }

    public void G1(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        j<?> jVar = this.t;
        if (jVar != null) {
            jVar.p(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final Fragment H() {
        return this.v;
    }

    public void H0(boolean z2) {
    }

    public void H1(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        I1(intent, i2, null);
    }

    public final m I() {
        m mVar = this.s;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void I0(int i2, String[] strArr, int[] iArr) {
    }

    public void I1(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        j<?> jVar = this.t;
        if (jVar != null) {
            jVar.p(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object J() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1231i;
        return obj == W ? z() : obj;
    }

    public void J0() {
        this.F = true;
    }

    public void J1() {
        m mVar = this.s;
        if (mVar == null || mVar.o == null) {
            j().p = false;
        } else if (Looper.myLooper() != this.s.o.i().getLooper()) {
            this.s.o.i().postAtFrontOfQueue(new a());
        } else {
            d();
        }
    }

    public final Resources K() {
        return p1().getResources();
    }

    public void K0(Bundle bundle) {
    }

    public final boolean L() {
        return this.B;
    }

    public void L0() {
        this.F = true;
    }

    public Object M() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1229g;
        return obj == W ? x() : obj;
    }

    public void M0() {
        this.F = true;
    }

    public Object N() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f1232j;
    }

    public void N0(View view, Bundle bundle) {
    }

    public Object O() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1233k;
        return obj == W ? N() : obj;
    }

    public void O0(Bundle bundle) {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public int P() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.f1225c;
    }

    /* access modifiers changed from: package-private */
    public void P0(Bundle bundle) {
        this.u.F0();
        this.f1210b = 2;
        this.F = false;
        i0(bundle);
        if (this.F) {
            this.u.s();
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final String Q(int i2) {
        return K().getString(i2);
    }

    /* access modifiers changed from: package-private */
    public void Q0() {
        this.u.h(this.t, new b(), this);
        this.f1210b = 0;
        this.F = false;
        l0(this.t.h());
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final String R() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public void R0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.u.t(configuration);
    }

    public final Fragment S() {
        String str;
        Fragment fragment = this.f1216h;
        if (fragment != null) {
            return fragment;
        }
        m mVar = this.s;
        if (mVar == null || (str = this.f1217i) == null) {
            return null;
        }
        return mVar.W(str);
    }

    /* access modifiers changed from: package-private */
    public boolean S0(MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        if (!n0(menuItem) && !this.u.u(menuItem)) {
            return false;
        }
        return true;
    }

    public View T() {
        return this.H;
    }

    /* access modifiers changed from: package-private */
    public void T0(Bundle bundle) {
        this.u.F0();
        this.f1210b = 1;
        this.F = false;
        this.U.c(bundle);
        o0(bundle);
        this.P = true;
        if (this.F) {
            this.R.i(e.a.ON_CREATE);
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public boolean U0(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z2 = true;
            r0(menu, menuInflater);
        }
        return z2 | this.u.w(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public void V() {
        U();
        this.f1214f = UUID.randomUUID().toString();
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = new n();
        this.t = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
    }

    /* access modifiers changed from: package-private */
    public void V0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.F0();
        this.q = true;
        this.S = new y();
        View s0 = s0(layoutInflater, viewGroup, bundle);
        this.H = s0;
        if (s0 != null) {
            this.S.b();
            this.T.h(this.S);
        } else if (!this.S.d()) {
            this.S = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void W0() {
        this.u.x();
        this.R.i(e.a.ON_DESTROY);
        this.f1210b = 0;
        this.F = false;
        this.P = false;
        t0();
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public final boolean X() {
        return this.t != null && this.l;
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        this.u.y();
        if (this.H != null) {
            this.S.a(e.a.ON_DESTROY);
        }
        this.f1210b = 1;
        this.F = false;
        v0();
        if (this.F) {
            b.n.a.a.b(this).c();
            this.q = false;
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public final boolean Y() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public void Y0() {
        this.f1210b = -1;
        this.F = false;
        w0();
        this.O = null;
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.u.r0()) {
            this.u.x();
            this.u = new n();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Z() {
        c cVar = this.K;
        if (cVar == null) {
            return false;
        }
        return cVar.r;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater Z0(Bundle bundle) {
        LayoutInflater x0 = x0(bundle);
        this.O = x0;
        return x0;
    }

    /* access modifiers changed from: package-private */
    public final boolean a0() {
        return this.r > 0;
    }

    /* access modifiers changed from: package-private */
    public void a1() {
        onLowMemory();
        this.u.z();
    }

    public final boolean b0() {
        m mVar;
        return this.E && ((mVar = this.s) == null || mVar.u0(this.v));
    }

    /* access modifiers changed from: package-private */
    public void b1(boolean z2) {
        B0(z2);
        this.u.A(z2);
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.e c() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public boolean c0() {
        c cVar = this.K;
        if (cVar == null) {
            return false;
        }
        return cVar.p;
    }

    /* access modifiers changed from: package-private */
    public boolean c1(MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        if ((!this.D || !this.E || !C0(menuItem)) && !this.u.B(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        c cVar = this.K;
        d dVar = null;
        if (cVar != null) {
            cVar.p = false;
            d dVar2 = cVar.q;
            cVar.q = null;
            dVar = dVar2;
        }
        if (dVar != null) {
            dVar.a();
        }
    }

    public final boolean d0() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public void d1(Menu menu) {
        if (!this.z) {
            if (this.D && this.E) {
                D0(menu);
            }
            this.u.C(menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e0() {
        Fragment H2 = H();
        return H2 != null && (H2.d0() || H2.e0());
    }

    /* access modifiers changed from: package-private */
    public void e1() {
        this.u.E();
        if (this.H != null) {
            this.S.a(e.a.ON_PAUSE);
        }
        this.R.i(e.a.ON_PAUSE);
        this.f1210b = 3;
        this.F = false;
        E0();
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry f() {
        return this.U.b();
    }

    public final boolean f0() {
        m mVar = this.s;
        if (mVar == null) {
            return false;
        }
        return mVar.x0();
    }

    /* access modifiers changed from: package-private */
    public void f1(boolean z2) {
        F0(z2);
        this.u.F(z2);
    }

    public final boolean g0() {
        View view;
        return X() && !Y() && (view = this.H) != null && view.getWindowToken() != null && this.H.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g1(Menu menu) {
        boolean z2 = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z2 = true;
            G0(menu);
        }
        return z2 | this.u.G(menu);
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        this.u.F0();
    }

    /* access modifiers changed from: package-private */
    public void h1() {
        boolean v0 = this.s.v0(this);
        Boolean bool = this.f1219k;
        if (bool == null || bool.booleanValue() != v0) {
            this.f1219k = Boolean.valueOf(v0);
            H0(v0);
            this.u.H();
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1210b);
        printWriter.print(" mWho=");
        printWriter.print(this.f1214f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.f1215g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1215g);
        }
        if (this.f1211c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1211c);
        }
        if (this.f1212d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1212d);
        }
        Fragment S2 = S();
        if (S2 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(S2);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1218j);
        }
        if (F() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(F());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (r() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(r());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(P());
        }
        if (w() != null) {
            b.n.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.u + ":");
        m mVar = this.u;
        mVar.N(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void i0(Bundle bundle) {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public void i1() {
        this.u.F0();
        this.u.R(true);
        this.f1210b = 4;
        this.F = false;
        J0();
        if (this.F) {
            j jVar = this.R;
            e.a aVar = e.a.ON_RESUME;
            jVar.i(aVar);
            if (this.H != null) {
                this.S.a(aVar);
            }
            this.u.I();
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onResume()");
    }

    public void j0(int i2, int i3, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public void j1(Bundle bundle) {
        K0(bundle);
        this.U.d(bundle);
        Parcelable V0 = this.u.V0();
        if (V0 != null) {
            bundle.putParcelable("android:support:fragments", V0);
        }
    }

    @Deprecated
    public void k0(Activity activity) {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public void k1() {
        this.u.F0();
        this.u.R(true);
        this.f1210b = 3;
        this.F = false;
        L0();
        if (this.F) {
            j jVar = this.R;
            e.a aVar = e.a.ON_START;
            jVar.i(aVar);
            if (this.H != null) {
                this.S.a(aVar);
            }
            this.u.J();
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public Fragment l(String str) {
        if (str.equals(this.f1214f)) {
            return this;
        }
        return this.u.Z(str);
    }

    public void l0(Context context) {
        this.F = true;
        j<?> jVar = this.t;
        Activity g2 = jVar == null ? null : jVar.g();
        if (g2 != null) {
            this.F = false;
            k0(g2);
        }
    }

    /* access modifiers changed from: package-private */
    public void l1() {
        this.u.L();
        if (this.H != null) {
            this.S.a(e.a.ON_STOP);
        }
        this.R.i(e.a.ON_STOP);
        this.f1210b = 2;
        this.F = false;
        M0();
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void m0(Fragment fragment) {
    }

    public final void m1(String[] strArr, int i2) {
        j<?> jVar = this.t;
        if (jVar != null) {
            jVar.n(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final d n() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return (d) jVar.g();
    }

    public boolean n0(MenuItem menuItem) {
        return false;
    }

    public final d n1() {
        d n2 = n();
        if (n2 != null) {
            return n2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean o() {
        Boolean bool;
        c cVar = this.K;
        if (cVar == null || (bool = cVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void o0(Bundle bundle) {
        this.F = true;
        r1(bundle);
        if (!this.u.w0(1)) {
            this.u.v();
        }
    }

    public final Bundle o1() {
        Bundle u2 = u();
        if (u2 != null) {
            return u2;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        n1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.F = true;
    }

    public Animation p0(int i2, boolean z2, int i3) {
        return null;
    }

    public final Context p1() {
        Context w2 = w();
        if (w2 != null) {
            return w2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public boolean q() {
        Boolean bool;
        c cVar = this.K;
        if (cVar == null || (bool = cVar.l) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public Animator q0(int i2, boolean z2, int i3) {
        return null;
    }

    public final View q1() {
        View T2 = T();
        if (T2 != null) {
            return T2;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    public View r() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f1223a;
    }

    public void r0(Menu menu, MenuInflater menuInflater) {
    }

    /* access modifiers changed from: package-private */
    public void r1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.u.T0(parcelable);
            this.u.v();
        }
    }

    /* access modifiers changed from: package-private */
    public Animator s() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f1224b;
    }

    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.V;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void s1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f1212d;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.f1212d = null;
        }
        this.F = false;
        O0(bundle);
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.H != null) {
            this.S.a(e.a.ON_CREATE);
        }
    }

    @Override // androidx.lifecycle.w
    public v t() {
        m mVar = this.s;
        if (mVar != null) {
            return mVar.o0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void t0() {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public void t1(View view) {
        j().f1223a = view;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1214f);
        sb.append(")");
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final Bundle u() {
        return this.f1215g;
    }

    public void u0() {
    }

    /* access modifiers changed from: package-private */
    public void u1(Animator animator) {
        j().f1224b = animator;
    }

    public final m v() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void v0() {
        this.F = true;
    }

    public void v1(Bundle bundle) {
        if (this.s == null || !f0()) {
            this.f1215g = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public Context w() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return jVar.h();
    }

    public void w0() {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public void w1(boolean z2) {
        j().r = z2;
    }

    public Object x() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f1228f;
    }

    public LayoutInflater x0(Bundle bundle) {
        return E(bundle);
    }

    public void x1(e eVar) {
        Bundle bundle;
        if (this.s == null) {
            if (eVar == null || (bundle = eVar.f1234b) == null) {
                bundle = null;
            }
            this.f1211c = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    /* access modifiers changed from: package-private */
    public m y() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.n;
    }

    public void y0(boolean z2) {
    }

    public void y1(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            if (this.D && X() && !Y()) {
                this.t.q();
            }
        }
    }

    public Object z() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f1230h;
    }

    @Deprecated
    public void z0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    /* access modifiers changed from: package-private */
    public void z1(int i2) {
        if (this.K != null || i2 != 0) {
            j().f1226d = i2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        final Bundle f1234b;

        static class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            /* renamed from: b */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            /* renamed from: c */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        e(Bundle bundle) {
            this.f1234b = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f1234b);
        }

        e(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f1234b = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }
    }
}
