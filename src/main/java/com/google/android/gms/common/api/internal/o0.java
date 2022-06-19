package com.google.android.gms.common.api.internal;

import b.e.a;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.c;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private final a<b<?>, com.google.android.gms.common.a> f7246a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b<?>, String> f7247b;

    /* renamed from: c  reason: collision with root package name */
    private final c<Map<b<?>, String>> f7248c;

    /* renamed from: d  reason: collision with root package name */
    private int f7249d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7250e;

    public final Set<b<?>> a() {
        return this.f7246a.keySet();
    }

    public final void b(b<?> bVar, com.google.android.gms.common.a aVar, String str) {
        this.f7246a.put(bVar, aVar);
        this.f7247b.put(bVar, str);
        this.f7249d--;
        if (!aVar.o()) {
            this.f7250e = true;
        }
        if (this.f7249d != 0) {
            return;
        }
        if (this.f7250e) {
            this.f7248c.b(new AvailabilityException(this.f7246a));
            return;
        }
        this.f7248c.c(this.f7247b);
    }
}
