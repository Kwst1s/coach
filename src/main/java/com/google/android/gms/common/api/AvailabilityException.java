package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import b.e.a;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class AvailabilityException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private final a<b<?>, com.google.android.gms.common.a> f7124b;

    public AvailabilityException(@RecentlyNonNull a<b<?>, com.google.android.gms.common.a> aVar) {
        this.f7124b = aVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (b<?> bVar : this.f7124b.keySet()) {
            com.google.android.gms.common.a aVar = this.f7124b.get(bVar);
            n.f(aVar);
            com.google.android.gms.common.a aVar2 = aVar;
            if (aVar2.o()) {
                z = false;
            }
            String b2 = bVar.b();
            String valueOf = String.valueOf(aVar2);
            StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(b2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
