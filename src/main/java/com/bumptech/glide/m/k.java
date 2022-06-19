package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* compiled from: RequestManagerFragment */
public class k extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private final a f4255b;

    /* renamed from: c  reason: collision with root package name */
    private final m f4256c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<k> f4257d;

    /* renamed from: e  reason: collision with root package name */
    private i f4258e;

    /* renamed from: f  reason: collision with root package name */
    private k f4259f;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f4260g;

    /* compiled from: RequestManagerFragment */
    private class a implements m {
        a() {
        }

        @Override // com.bumptech.glide.m.m
        public Set<i> a() {
            Set<k> b2 = k.this.b();
            HashSet hashSet = new HashSet(b2.size());
            for (k kVar : b2) {
                if (kVar.e() != null) {
                    hashSet.add(kVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new a());
    }

    private void a(k kVar) {
        this.f4257d.add(kVar);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f4260g;
    }

    @TargetApi(17)
    private boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(Activity activity) {
        l();
        k h2 = b.c(activity).k().h(activity);
        this.f4259f = h2;
        if (!equals(h2)) {
            this.f4259f.a(this);
        }
    }

    private void i(k kVar) {
        this.f4257d.remove(kVar);
    }

    private void l() {
        k kVar = this.f4259f;
        if (kVar != null) {
            kVar.i(this);
            this.f4259f = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    public Set<k> b() {
        if (equals(this.f4259f)) {
            return Collections.unmodifiableSet(this.f4257d);
        }
        if (this.f4259f == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (k kVar : this.f4259f.b()) {
            if (g(kVar.getParentFragment())) {
                hashSet.add(kVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public a c() {
        return this.f4255b;
    }

    public i e() {
        return this.f4258e;
    }

    public m f() {
        return this.f4256c;
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.f4260g = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(i iVar) {
        this.f4258e = iVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4255b.c();
        l();
    }

    public void onDetach() {
        super.onDetach();
        l();
    }

    public void onStart() {
        super.onStart();
        this.f4255b.d();
    }

    public void onStop() {
        super.onStop();
        this.f4255b.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    k(a aVar) {
        this.f4256c = new a();
        this.f4257d = new HashSet();
        this.f4255b = aVar;
    }
}
