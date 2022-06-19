package com.bumptech.glide.m;

import com.bumptech.glide.r.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
/* compiled from: ActivityFragmentLifecycle */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f4246a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f4247b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4248c;

    a() {
    }

    @Override // com.bumptech.glide.m.h
    public void a(i iVar) {
        this.f4246a.add(iVar);
        if (this.f4248c) {
            iVar.k();
        } else if (this.f4247b) {
            iVar.a();
        } else {
            iVar.e();
        }
    }

    @Override // com.bumptech.glide.m.h
    public void b(i iVar) {
        this.f4246a.remove(iVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f4248c = true;
        for (i iVar : k.i(this.f4246a)) {
            iVar.k();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f4247b = true;
        for (i iVar : k.i(this.f4246a)) {
            iVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f4247b = false;
        for (i iVar : k.i(this.f4246a)) {
            iVar.e();
        }
    }
}
