package com.firebase.jobdispatcher;

import android.net.Uri;

/* compiled from: ObservedUri */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f4669a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4670b;

    public v(Uri uri, int i2) {
        if (uri != null) {
            this.f4669a = uri;
            this.f4670b = i2;
            return;
        }
        throw new IllegalArgumentException("URI must not be null.");
    }

    public int a() {
        return this.f4670b;
    }

    public Uri b() {
        return this.f4669a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f4670b != vVar.f4670b || !this.f4669a.equals(vVar.f4669a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f4669a.hashCode() ^ this.f4670b;
    }
}
