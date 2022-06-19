package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class h<L> {

    /* renamed from: a  reason: collision with root package name */
    private final L f7222a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7223b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f7222a == hVar.f7222a && this.f7223b.equals(hVar.f7223b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f7222a) * 31) + this.f7223b.hashCode();
    }
}
