package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import androidx.lifecycle.e;
import b.h.j.b;
import java.io.PrintWriter;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: BackStackRecord */
public final class a extends u implements m.f, m.i {
    final m r;
    boolean s;
    int t;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(androidx.fragment.app.m r3) {
        /*
            r2 = this;
            androidx.fragment.app.i r0 = r3.h0()
            androidx.fragment.app.j<?> r1 = r3.o
            if (r1 == 0) goto L_0x0011
            android.content.Context r1 = r1.h()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            r2.<init>(r0, r1)
            r0 = -1
            r2.t = r0
            r2.r = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.m):void");
    }

    private static boolean D(u.a aVar) {
        Fragment fragment = aVar.f1357b;
        return fragment != null && fragment.l && fragment.H != null && !fragment.A && !fragment.z && fragment.c0();
    }

    /* access modifiers changed from: package-private */
    public Fragment A(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f1345a.size()) {
            u.a aVar = this.f1345a.get(i2);
            int i3 = aVar.f1356a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f1357b;
                    int i4 = fragment3.x;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.x == i4) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1345a.add(i2, new u.a(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                u.a aVar2 = new u.a(3, fragment4);
                                aVar2.f1358c = aVar.f1358c;
                                aVar2.f1360e = aVar.f1360e;
                                aVar2.f1359d = aVar.f1359d;
                                aVar2.f1361f = aVar.f1361f;
                                this.f1345a.add(i2, aVar2);
                                arrayList.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.f1345a.remove(i2);
                        i2--;
                    } else {
                        aVar.f1356a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList.remove(aVar.f1357b);
                    Fragment fragment5 = aVar.f1357b;
                    if (fragment5 == fragment2) {
                        this.f1345a.add(i2, new u.a(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f1345a.add(i2, new u.a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f1357b;
                    }
                }
                i2++;
            }
            arrayList.add(aVar.f1357b);
            i2++;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    public boolean B(int i2) {
        int size = this.f1345a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f1345a.get(i3).f1357b;
            int i4 = fragment != null ? fragment.x : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean C(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f1345a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1345a.get(i5).f1357b;
            int i6 = fragment != null ? fragment.x : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f1345a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f1345a.get(i8).f1357b;
                        if ((fragment2 != null ? fragment2.x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        for (int i2 = 0; i2 < this.f1345a.size(); i2++) {
            if (D(this.f1345a.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void F() {
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                this.q.get(i2).run();
            }
            this.q = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void G(Fragment.d dVar) {
        for (int i2 = 0; i2 < this.f1345a.size(); i2++) {
            u.a aVar = this.f1345a.get(i2);
            if (D(aVar)) {
                aVar.f1357b.B1(dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment H(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1345a.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1345a.get(size);
            int i2 = aVar.f1356a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1357b;
                            break;
                        case 10:
                            aVar.f1363h = aVar.f1362g;
                            break;
                    }
                }
                arrayList.add(aVar.f1357b);
            }
            arrayList.remove(aVar.f1357b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.m.f
    public String a() {
        return this.f1353i;
    }

    @Override // androidx.fragment.app.m.i
    public boolean b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.s0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1351g) {
            return true;
        }
        this.r.b(this);
        return true;
    }

    @Override // androidx.fragment.app.u
    public int i() {
        return v(false);
    }

    @Override // androidx.fragment.app.u
    public int j() {
        return v(true);
    }

    @Override // androidx.fragment.app.u
    public void k() {
        m();
        this.r.S(this, false);
    }

    @Override // androidx.fragment.app.u
    public void l() {
        m();
        this.r.S(this, true);
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.fragment.app.u
    public void n(int i2, Fragment fragment, String str, int i3) {
        super.n(i2, fragment, str, i3);
        fragment.s = this.r;
    }

    @Override // androidx.fragment.app.u
    public u o(Fragment fragment) {
        m mVar = fragment.s;
        if (mVar == null || mVar == this.r) {
            super.o(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.u
    public u s(Fragment fragment, e.b bVar) {
        if (fragment.s == this.r) {
            e.b bVar2 = e.b.CREATED;
            if (bVar.a(bVar2)) {
                super.s(fragment, bVar);
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + bVar2);
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.r);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.f1353i != null) {
            sb.append(" ");
            sb.append(this.f1353i);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        if (this.f1351g) {
            if (m.s0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f1345a.size();
            for (int i3 = 0; i3 < size; i3++) {
                u.a aVar = this.f1345a.get(i3);
                Fragment fragment = aVar.f1357b;
                if (fragment != null) {
                    fragment.r += i2;
                    if (m.s0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1357b + " to " + aVar.f1357b.r);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int v(boolean z) {
        if (!this.s) {
            if (m.s0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                w("  ", printWriter);
                printWriter.close();
            }
            this.s = true;
            if (this.f1351g) {
                this.t = this.r.g();
            } else {
                this.t = -1;
            }
            this.r.P(this, z);
            return this.t;
        }
        throw new IllegalStateException("commit already called");
    }

    public void w(String str, PrintWriter printWriter) {
        x(str, printWriter, true);
    }

    public void x(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1353i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f1350f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1350f));
            }
            if (!(this.f1346b == 0 && this.f1347c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1346b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1347c));
            }
            if (!(this.f1348d == 0 && this.f1349e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1348d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1349e));
            }
            if (!(this.f1354j == 0 && this.f1355k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1354j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1355k);
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.f1345a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f1345a.size();
            for (int i2 = 0; i2 < size; i2++) {
                u.a aVar = this.f1345a.get(i2);
                switch (aVar.f1356a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f1356a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f1357b);
                if (z) {
                    if (!(aVar.f1358c == 0 && aVar.f1359d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1358c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1359d));
                    }
                    if (aVar.f1360e != 0 || aVar.f1361f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1360e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1361f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y() {
        int size = this.f1345a.size();
        for (int i2 = 0; i2 < size; i2++) {
            u.a aVar = this.f1345a.get(i2);
            Fragment fragment = aVar.f1357b;
            if (fragment != null) {
                fragment.A1(this.f1350f);
            }
            switch (aVar.f1356a) {
                case 1:
                    fragment.z1(aVar.f1358c);
                    this.r.Y0(fragment, false);
                    this.r.d(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1356a);
                case 3:
                    fragment.z1(aVar.f1359d);
                    this.r.P0(fragment);
                    break;
                case 4:
                    fragment.z1(aVar.f1359d);
                    this.r.q0(fragment);
                    break;
                case 5:
                    fragment.z1(aVar.f1358c);
                    this.r.Y0(fragment, false);
                    this.r.c1(fragment);
                    break;
                case 6:
                    fragment.z1(aVar.f1359d);
                    this.r.r(fragment);
                    break;
                case 7:
                    fragment.z1(aVar.f1358c);
                    this.r.Y0(fragment, false);
                    this.r.i(fragment);
                    break;
                case 8:
                    this.r.a1(fragment);
                    break;
                case 9:
                    this.r.a1(null);
                    break;
                case 10:
                    this.r.Z0(fragment, aVar.f1363h);
                    break;
            }
            if (!(this.p || aVar.f1356a == 1 || fragment == null)) {
                this.r.B0(fragment);
            }
        }
        if (!this.p) {
            m mVar = this.r;
            mVar.C0(mVar.n, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z) {
        for (int size = this.f1345a.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1345a.get(size);
            Fragment fragment = aVar.f1357b;
            if (fragment != null) {
                fragment.A1(m.U0(this.f1350f));
            }
            switch (aVar.f1356a) {
                case 1:
                    fragment.z1(aVar.f1361f);
                    this.r.Y0(fragment, true);
                    this.r.P0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1356a);
                case 3:
                    fragment.z1(aVar.f1360e);
                    this.r.d(fragment);
                    break;
                case 4:
                    fragment.z1(aVar.f1360e);
                    this.r.c1(fragment);
                    break;
                case 5:
                    fragment.z1(aVar.f1361f);
                    this.r.Y0(fragment, true);
                    this.r.q0(fragment);
                    break;
                case 6:
                    fragment.z1(aVar.f1360e);
                    this.r.i(fragment);
                    break;
                case 7:
                    fragment.z1(aVar.f1361f);
                    this.r.Y0(fragment, true);
                    this.r.r(fragment);
                    break;
                case 8:
                    this.r.a1(null);
                    break;
                case 9:
                    this.r.a1(fragment);
                    break;
                case 10:
                    this.r.Z0(fragment, aVar.f1362g);
                    break;
            }
            if (!(this.p || aVar.f1356a == 3 || fragment == null)) {
                this.r.B0(fragment);
            }
        }
        if (!this.p && z) {
            m mVar = this.r;
            mVar.C0(mVar.n, true);
        }
    }
}
