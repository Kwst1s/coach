package b.c.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.core.app.d;
import b.c.b.a;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f2135a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f2136b;

    /* compiled from: CustomTabsIntent */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f2137a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final a.C0034a f2138b = new a.C0034a();

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f2139c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f2140d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f2141e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f2142f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f2143g;

        /* renamed from: h  reason: collision with root package name */
        private int f2144h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2145i = true;

        private void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            d.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f2137a.putExtras(bundle);
        }

        @Deprecated
        public a a() {
            d(1);
            return this;
        }

        public b b() {
            if (!this.f2137a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<Bundle> arrayList = this.f2139c;
            if (arrayList != null) {
                this.f2137a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f2141e;
            if (arrayList2 != null) {
                this.f2137a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f2137a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2145i);
            this.f2137a.putExtras(this.f2138b.a().a());
            Bundle bundle = this.f2143g;
            if (bundle != null) {
                this.f2137a.putExtras(bundle);
            }
            if (this.f2142f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f2142f);
                this.f2137a.putExtras(bundle2);
            }
            this.f2137a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f2144h);
            return new b(this.f2137a, this.f2140d);
        }

        public a d(int i2) {
            if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.f2144h = i2;
            if (i2 == 1) {
                this.f2137a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            } else if (i2 == 2) {
                this.f2137a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
            } else {
                this.f2137a.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            }
            return this;
        }

        public a e(boolean z) {
            this.f2137a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        @Deprecated
        public a f(int i2) {
            this.f2138b.b(i2);
            return this;
        }
    }

    b(Intent intent, Bundle bundle) {
        this.f2135a = intent;
        this.f2136b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f2135a.setData(uri);
        b.h.d.a.h(context, this.f2135a, this.f2136b);
    }
}
