package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class ApiException extends Exception {
    @RecentlyNonNull
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    protected final Status f7123b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status r5) {
        /*
            r4 = this;
            int r0 = r5.l()
            java.lang.String r1 = r5.m()
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r5.m()
            goto L_0x0011
        L_0x000f:
            java.lang.String r1 = ""
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = ": "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r4.<init>(r0)
            r4.f7123b = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }

    public Status a() {
        return this.f7123b;
    }
}
