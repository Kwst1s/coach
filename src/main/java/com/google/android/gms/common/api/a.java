package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.n;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0141a<?, O> f7137a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7138b;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static abstract class AbstractC0141a<T extends f, O> extends e<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull com.google.android.gms.common.internal.d dVar, @RecentlyNonNull O o, @RecentlyNonNull d dVar2, @RecentlyNonNull e eVar) {
            return b(context, looper, dVar, o, dVar2, eVar);
        }

        @RecentlyNonNull
        public T b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull com.google.android.gms.common.internal.d dVar, @RecentlyNonNull O o, @RecentlyNonNull com.google.android.gms.common.api.internal.d dVar2, @RecentlyNonNull j jVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface d {
        @RecentlyNonNull

        /* renamed from: a  reason: collision with root package name */
        public static final c f7139a = new c();

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        public interface AbstractC0142a extends d {
            @RecentlyNonNull
            Account a();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        public interface b extends d {
            @RecentlyNullable
            GoogleSignInAccount b();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        public static final class c implements d {
            private c() {
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface f extends b {
        void a(@RecentlyNonNull c.e eVar);

        boolean b();

        Set<Scope> c();

        void d(i iVar, Set<Scope> set);

        void e(@RecentlyNonNull String str);

        boolean f();

        int g();

        boolean h();

        @RecentlyNonNull
        com.google.android.gms.common.c[] i();

        @RecentlyNonNull
        String j();

        @RecentlyNullable
        String k();

        void m(@RecentlyNonNull c.AbstractC0144c cVar);

        void n();

        boolean o();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.common.api.a$a<C extends com.google.android.gms.common.api.a$f, O extends com.google.android.gms.common.api.a$d> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(@RecentlyNonNull String str, @RecentlyNonNull AbstractC0141a<C, O> aVar, @RecentlyNonNull g<C> gVar) {
        n.g(aVar, "Cannot construct an Api with a null ClientBuilder");
        n.g(gVar, "Cannot construct an Api with a null ClientKey");
        this.f7138b = str;
        this.f7137a = aVar;
    }

    @RecentlyNonNull
    public final AbstractC0141a<?, O> a() {
        return this.f7137a;
    }

    @RecentlyNonNull
    public final String b() {
        return this.f7138b;
    }
}
