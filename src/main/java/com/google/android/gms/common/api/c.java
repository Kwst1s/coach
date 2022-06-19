package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.e0;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.g;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class c<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7140a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7141b;

    /* renamed from: c  reason: collision with root package name */
    private final a<O> f7142c;

    /* renamed from: d  reason: collision with root package name */
    private final O f7143d;

    /* renamed from: e  reason: collision with root package name */
    private final b<O> f7144e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7145f;

    /* renamed from: g  reason: collision with root package name */
    private final m f7146g;

    /* renamed from: h  reason: collision with root package name */
    private final e f7147h;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class a {
        @RecentlyNonNull

        /* renamed from: c  reason: collision with root package name */
        public static final a f7148c = new C0143a().a();
        @RecentlyNonNull

        /* renamed from: a  reason: collision with root package name */
        public final m f7149a;
        @RecentlyNonNull

        /* renamed from: b  reason: collision with root package name */
        public final Looper f7150b;

        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        public static class C0143a {

            /* renamed from: a  reason: collision with root package name */
            private m f7151a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f7152b;

            @RecentlyNonNull
            public a a() {
                if (this.f7151a == null) {
                    this.f7151a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f7152b == null) {
                    this.f7152b = Looper.getMainLooper();
                }
                return new a(this.f7151a, this.f7152b);
            }
        }

        private a(m mVar, Account account, Looper looper) {
            this.f7149a = mVar;
            this.f7150b = looper;
        }
    }

    public c(@RecentlyNonNull Context context, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull a aVar2) {
        n.g(context, "Null context is not permitted.");
        n.g(aVar, "Api must not be null.");
        n.g(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f7140a = applicationContext;
        String j2 = j(context);
        this.f7141b = j2;
        this.f7142c = aVar;
        this.f7143d = o;
        Looper looper = aVar2.f7150b;
        this.f7144e = b.a(aVar, o, j2);
        e d2 = e.d(applicationContext);
        this.f7147h = d2;
        this.f7145f = d2.k();
        this.f7146g = aVar2.f7149a;
        d2.e(this);
    }

    private final <TResult, A extends a.b> com.google.android.gms.tasks.b<TResult> i(int i2, com.google.android.gms.common.api.internal.n<A, TResult> nVar) {
        com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
        this.f7147h.f(this, i2, nVar, cVar, this.f7146g);
        return cVar.a();
    }

    private static String j(Object obj) {
        if (!g.h()) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public d.a a() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount b2;
        GoogleSignInAccount b3;
        d.a aVar = new d.a();
        O o = this.f7143d;
        if (!(o instanceof a.d.b) || (b3 = ((a.d.b) o).b()) == null) {
            O o2 = this.f7143d;
            account = o2 instanceof a.d.AbstractC0142a ? ((a.d.AbstractC0142a) o2).a() : null;
        } else {
            account = b3.k();
        }
        aVar.c(account);
        O o3 = this.f7143d;
        if (!(o3 instanceof a.d.b) || (b2 = ((a.d.b) o3).b()) == null) {
            set = Collections.emptySet();
        } else {
            set = b2.s();
        }
        aVar.e(set);
        aVar.d(this.f7140a.getClass().getName());
        aVar.b(this.f7140a.getPackageName());
        return aVar;
    }

    @RecentlyNonNull
    public <TResult, A extends a.b> com.google.android.gms.tasks.b<TResult> b(@RecentlyNonNull com.google.android.gms.common.api.internal.n<A, TResult> nVar) {
        return i(2, nVar);
    }

    @RecentlyNonNull
    public b<O> c() {
        return this.f7144e;
    }

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public String d() {
        return this.f7141b;
    }

    public final int e() {
        return this.f7145f;
    }

    public final a.f f(Looper looper, e.a<O> aVar) {
        com.google.android.gms.common.internal.d a2 = a().a();
        a.AbstractC0141a<?, O> a3 = this.f7142c.a();
        n.f(a3);
        a.f a4 = a3.a(this.f7140a, looper, a2, this.f7143d, aVar, aVar);
        String d2 = d();
        if (d2 != null && (a4 instanceof com.google.android.gms.common.internal.c)) {
            ((com.google.android.gms.common.internal.c) a4).L(d2);
        }
        if (d2 != null && (a4 instanceof i)) {
            ((i) a4).s(d2);
        }
        return a4;
    }

    public final e0 g(Context context, Handler handler) {
        return new e0(context, handler, a().a());
    }
}
