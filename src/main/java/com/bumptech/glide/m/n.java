package com.bumptech.glide.m;

import android.util.Log;
import com.bumptech.glide.p.c;
import com.bumptech.glide.r.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c> f4268a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f4269b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f4270c;

    public boolean a(c cVar) {
        boolean z = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f4268a.remove(cVar);
        if (!this.f4269b.remove(cVar) && !remove) {
            z = false;
        }
        if (z) {
            cVar.clear();
        }
        return z;
    }

    public void b() {
        for (c cVar : k.i(this.f4268a)) {
            a(cVar);
        }
        this.f4269b.clear();
    }

    public void c() {
        this.f4270c = true;
        for (c cVar : k.i(this.f4268a)) {
            if (cVar.isRunning() || cVar.k()) {
                cVar.clear();
                this.f4269b.add(cVar);
            }
        }
    }

    public void d() {
        this.f4270c = true;
        for (c cVar : k.i(this.f4268a)) {
            if (cVar.isRunning()) {
                cVar.c();
                this.f4269b.add(cVar);
            }
        }
    }

    public void e() {
        for (c cVar : k.i(this.f4268a)) {
            if (!cVar.k() && !cVar.f()) {
                cVar.clear();
                if (!this.f4270c) {
                    cVar.i();
                } else {
                    this.f4269b.add(cVar);
                }
            }
        }
    }

    public void f() {
        this.f4270c = false;
        for (c cVar : k.i(this.f4268a)) {
            if (!cVar.k() && !cVar.isRunning()) {
                cVar.i();
            }
        }
        this.f4269b.clear();
    }

    public void g(c cVar) {
        this.f4268a.add(cVar);
        if (!this.f4270c) {
            cVar.i();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f4269b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f4268a.size() + ", isPaused=" + this.f4270c + "}";
    }
}
