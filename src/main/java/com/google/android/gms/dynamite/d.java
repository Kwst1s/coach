package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
final class d implements DynamiteModule.a {
    d() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0148a a(Context context, String str, DynamiteModule.a.b bVar) {
        DynamiteModule.a.C0148a aVar = new DynamiteModule.a.C0148a();
        int b2 = bVar.b(context, str);
        aVar.f7452a = b2;
        if (b2 != 0) {
            aVar.f7453b = bVar.a(context, str, false);
        } else {
            aVar.f7453b = bVar.a(context, str, true);
        }
        int i2 = aVar.f7452a;
        if (i2 == 0 && aVar.f7453b == 0) {
            aVar.f7454c = 0;
        } else if (i2 >= aVar.f7453b) {
            aVar.f7454c = -1;
        } else {
            aVar.f7454c = 1;
        }
        return aVar;
    }
}
