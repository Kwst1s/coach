package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f7363a = 4225;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7364b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static h f7365c;

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static final class a {

        /* renamed from: f  reason: collision with root package name */
        private static final Uri f7366f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a  reason: collision with root package name */
        private final String f7367a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7368b;

        /* renamed from: c  reason: collision with root package name */
        private final ComponentName f7369c = null;

        /* renamed from: d  reason: collision with root package name */
        private final int f7370d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f7371e;

        public a(String str, String str2, int i2, boolean z) {
            n.d(str);
            this.f7367a = str;
            n.d(str2);
            this.f7368b = str2;
            this.f7370d = i2;
            this.f7371e = z;
        }

        private final Intent d(Context context) {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f7367a);
            Intent intent = null;
            try {
                bundle = context.getContentResolver().call(f7366f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                sb.append("Dynamic intent resolution failed: ");
                sb.append(valueOf);
                Log.w("ConnectionStatusConfig", sb.toString());
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                String valueOf2 = String.valueOf(this.f7367a);
                Log.w("ConnectionStatusConfig", valueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf2) : new String("Dynamic lookup for intent failed for action: "));
            }
            return intent;
        }

        public final Intent a(Context context) {
            if (this.f7367a == null) {
                return new Intent().setComponent(this.f7369c);
            }
            Intent d2 = this.f7371e ? d(context) : null;
            if (d2 == null) {
                return new Intent(this.f7367a).setPackage(this.f7368b);
            }
            return d2;
        }

        public final String b() {
            return this.f7368b;
        }

        public final ComponentName c() {
            return this.f7369c;
        }

        public final int e() {
            return this.f7370d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f7367a, aVar.f7367a) && m.a(this.f7368b, aVar.f7368b) && m.a(this.f7369c, aVar.f7369c) && this.f7370d == aVar.f7370d && this.f7371e == aVar.f7371e;
        }

        public final int hashCode() {
            return m.b(this.f7367a, this.f7368b, this.f7369c, Integer.valueOf(this.f7370d), Boolean.valueOf(this.f7371e));
        }

        public final String toString() {
            String str = this.f7367a;
            if (str != null) {
                return str;
            }
            n.f(this.f7369c);
            return this.f7369c.flattenToString();
        }
    }

    public static int a() {
        return f7363a;
    }

    @RecentlyNonNull
    public static h b(@RecentlyNonNull Context context) {
        synchronized (f7364b) {
            if (f7365c == null) {
                f7365c = new l0(context.getApplicationContext());
            }
        }
        return f7365c;
    }

    public final void c(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i2, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, boolean z) {
        e(new a(str, str2, i2, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean d(a aVar, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void e(a aVar, ServiceConnection serviceConnection, String str);
}
