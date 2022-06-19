package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: FragmentStore */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f1343a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, r> f1344b = new HashMap<>();

    t() {
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f1343a.contains(fragment)) {
            synchronized (this.f1343a) {
                this.f1343a.add(fragment);
            }
            fragment.l = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f1344b.values().removeAll(Collections.singleton(null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f1344b.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        Iterator<Fragment> it = this.f1343a.iterator();
        while (it.hasNext()) {
            r rVar = this.f1344b.get(it.next().f1214f);
            if (rVar != null) {
                rVar.r(i2);
            }
        }
        for (r rVar2 : this.f1344b.values()) {
            if (rVar2 != null) {
                rVar2.r(i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1344b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (r rVar : this.f1344b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment i2 = rVar.i();
                    printWriter.println(i2);
                    i2.i(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f1343a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1343a.get(i3).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(String str) {
        r rVar = this.f1344b.get(str);
        if (rVar != null) {
            return rVar.i();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i2) {
        for (int size = this.f1343a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1343a.get(size);
            if (fragment != null && fragment.w == i2) {
                return fragment;
            }
        }
        for (r rVar : this.f1344b.values()) {
            if (rVar != null) {
                Fragment i3 = rVar.i();
                if (i3.w == i2) {
                    return i3;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f1343a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1343a.get(size);
                if (fragment != null && str.equals(fragment.y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (r rVar : this.f1344b.values()) {
            if (rVar != null) {
                Fragment i2 = rVar.i();
                if (str.equals(i2.y)) {
                    return i2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment l;
        for (r rVar : this.f1344b.values()) {
            if (!(rVar == null || (l = rVar.i().l(str)) == null)) {
                return l;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment j(Fragment fragment) {
        ViewGroup viewGroup = fragment.G;
        View view = fragment.H;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f1343a.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f1343a.get(indexOf);
                if (fragment2.G == viewGroup && fragment2.H != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> k() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f1344b.values()) {
            if (rVar != null) {
                arrayList.add(rVar.i());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public r l(String str) {
        return this.f1344b.get(str);
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> m() {
        ArrayList arrayList;
        if (this.f1343a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1343a) {
            arrayList = new ArrayList(this.f1343a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void n(r rVar) {
        this.f1344b.put(rVar.i().f1214f, rVar);
    }

    /* access modifiers changed from: package-private */
    public void o(r rVar) {
        Fragment i2 = rVar.i();
        for (r rVar2 : this.f1344b.values()) {
            if (rVar2 != null) {
                Fragment i3 = rVar2.i();
                if (i2.f1214f.equals(i3.f1217i)) {
                    i3.f1216h = i2;
                    i3.f1217i = null;
                }
            }
        }
        this.f1344b.put(i2.f1214f, null);
        String str = i2.f1217i;
        if (str != null) {
            i2.f1216h = f(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        synchronized (this.f1343a) {
            this.f1343a.remove(fragment);
        }
        fragment.l = false;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f1344b.clear();
    }

    /* access modifiers changed from: package-private */
    public void r(List<String> list) {
        this.f1343a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f2 = f(str);
                if (f2 != null) {
                    if (m.s0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f2);
                    }
                    a(f2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<q> s() {
        ArrayList<q> arrayList = new ArrayList<>(this.f1344b.size());
        for (r rVar : this.f1344b.values()) {
            if (rVar != null) {
                Fragment i2 = rVar.i();
                q p = rVar.p();
                arrayList.add(p);
                if (m.s0(2)) {
                    Log.v("FragmentManager", "Saved state of " + i2 + ": " + p.n);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> t() {
        synchronized (this.f1343a) {
            if (this.f1343a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f1343a.size());
            Iterator<Fragment> it = this.f1343a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f1214f);
                if (m.s0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f1214f + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
