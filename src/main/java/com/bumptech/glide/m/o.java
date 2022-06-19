package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment */
public class o extends Fragment {
    private final a X;
    private final m Y;
    private final Set<o> Z;
    private o a0;
    private i b0;
    private Fragment c0;

    /* compiled from: SupportRequestManagerFragment */
    private class a implements m {
        a() {
        }

        @Override // com.bumptech.glide.m.m
        public Set<i> a() {
            Set<o> L1 = o.this.L1();
            HashSet hashSet = new HashSet(L1.size());
            for (o oVar : L1) {
                if (oVar.O1() != null) {
                    hashSet.add(oVar.O1());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new a());
    }

    private void K1(o oVar) {
        this.Z.add(oVar);
    }

    private Fragment N1() {
        Fragment H = H();
        return H != null ? H : this.c0;
    }

    private static m Q1(Fragment fragment) {
        while (fragment.H() != null) {
            fragment = fragment.H();
        }
        return fragment.B();
    }

    private boolean R1(Fragment fragment) {
        Fragment N1 = N1();
        while (true) {
            Fragment H = fragment.H();
            if (H == null) {
                return false;
            }
            if (H.equals(N1)) {
                return true;
            }
            fragment = fragment.H();
        }
    }

    private void S1(Context context, m mVar) {
        W1();
        o j2 = b.c(context).k().j(context, mVar);
        this.a0 = j2;
        if (!equals(j2)) {
            this.a0.K1(this);
        }
    }

    private void T1(o oVar) {
        this.Z.remove(oVar);
    }

    private void W1() {
        o oVar = this.a0;
        if (oVar != null) {
            oVar.T1(this);
            this.a0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        this.X.d();
    }

    /* access modifiers changed from: package-private */
    public Set<o> L1() {
        o oVar = this.a0;
        if (oVar == null) {
            return Collections.emptySet();
        }
        if (equals(oVar)) {
            return Collections.unmodifiableSet(this.Z);
        }
        HashSet hashSet = new HashSet();
        for (o oVar2 : this.a0.L1()) {
            if (R1(oVar2.N1())) {
                hashSet.add(oVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // androidx.fragment.app.Fragment
    public void M0() {
        super.M0();
        this.X.e();
    }

    /* access modifiers changed from: package-private */
    public a M1() {
        return this.X;
    }

    public i O1() {
        return this.b0;
    }

    public m P1() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public void U1(Fragment fragment) {
        m Q1;
        this.c0 = fragment;
        if (fragment != null && fragment.w() != null && (Q1 = Q1(fragment)) != null) {
            S1(fragment.w(), Q1);
        }
    }

    public void V1(i iVar) {
        this.b0 = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void l0(Context context) {
        super.l0(context);
        m Q1 = Q1(this);
        if (Q1 != null) {
            try {
                S1(w(), Q1);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
        this.X.c();
        W1();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + N1() + "}";
    }

    @Override // androidx.fragment.app.Fragment
    public void w0() {
        super.w0();
        this.c0 = null;
        W1();
    }

    @SuppressLint({"ValidFragment"})
    public o(a aVar) {
        this.Y = new a();
        this.Z = new HashSet();
        this.X = aVar;
    }
}
