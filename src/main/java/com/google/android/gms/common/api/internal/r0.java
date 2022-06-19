package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f7254a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map<c<?>, Boolean> f7255b = Collections.synchronizedMap(new WeakHashMap());

    private final void c(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f7254a) {
            hashMap = new HashMap(this.f7254a);
        }
        synchronized (this.f7255b) {
            hashMap2 = new HashMap(this.f7255b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i2 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i2 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        c(true, new Status(20, sb.toString()));
    }

    /* access modifiers changed from: package-private */
    public final <TResult> void b(c<TResult> cVar, boolean z) {
        this.f7255b.put(cVar, Boolean.valueOf(z));
        cVar.a().a(new s0(this, cVar));
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return !this.f7254a.isEmpty() || !this.f7255b.isEmpty();
    }

    public final void f() {
        c(false, e.s);
    }
}
