package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.c;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: b  reason: collision with root package name */
    private final c f7136b;

    public UnsupportedApiCallException(@RecentlyNonNull c cVar) {
        this.f7136b = cVar;
    }

    @RecentlyNonNull
    public final String getMessage() {
        String valueOf = String.valueOf(this.f7136b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
