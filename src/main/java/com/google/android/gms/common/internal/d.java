package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Account f7329a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f7330b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f7331c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f7332d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7333e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7334f;

    /* renamed from: g  reason: collision with root package name */
    private final c.e.a.a.d.a f7335g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f7336h;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f7337a;

        /* renamed from: b  reason: collision with root package name */
        private b.e.b<Scope> f7338b;

        /* renamed from: c  reason: collision with root package name */
        private String f7339c;

        /* renamed from: d  reason: collision with root package name */
        private String f7340d;

        /* renamed from: e  reason: collision with root package name */
        private c.e.a.a.d.a f7341e = c.e.a.a.d.a.f3224b;

        @RecentlyNonNull
        public final d a() {
            return new d(this.f7337a, this.f7338b, null, 0, null, this.f7339c, this.f7340d, this.f7341e, false);
        }

        @RecentlyNonNull
        public final a b(@RecentlyNonNull String str) {
            this.f7339c = str;
            return this;
        }

        @RecentlyNonNull
        public final a c(@Nullable Account account) {
            this.f7337a = account;
            return this;
        }

        @RecentlyNonNull
        public final a d(@RecentlyNonNull String str) {
            this.f7340d = str;
            return this;
        }

        @RecentlyNonNull
        public final a e(@RecentlyNonNull Collection<Scope> collection) {
            if (this.f7338b == null) {
                this.f7338b = new b.e.b<>();
            }
            this.f7338b.addAll(collection);
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f7342a;
    }

    public d(@Nullable Account account, @RecentlyNonNull Set<Scope> set, @RecentlyNonNull Map<com.google.android.gms.common.api.a<?>, b> map, int i2, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull c.e.a.a.d.a aVar, boolean z) {
        this.f7329a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f7330b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f7332d = map;
        this.f7333e = str;
        this.f7334f = str2;
        this.f7335g = aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (b bVar : map.values()) {
            hashSet.addAll(bVar.f7342a);
        }
        this.f7331c = Collections.unmodifiableSet(hashSet);
    }

    @RecentlyNullable
    public final Account a() {
        return this.f7329a;
    }

    @RecentlyNonNull
    public final Account b() {
        Account account = this.f7329a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    @RecentlyNonNull
    public final Set<Scope> c() {
        return this.f7331c;
    }

    @RecentlyNullable
    public final String d() {
        return this.f7333e;
    }

    @RecentlyNonNull
    public final Set<Scope> e() {
        return this.f7330b;
    }

    public final void f(@RecentlyNonNull Integer num) {
        this.f7336h = num;
    }

    @RecentlyNullable
    public final String g() {
        return this.f7334f;
    }

    @RecentlyNonNull
    public final c.e.a.a.d.a h() {
        return this.f7335g;
    }

    @RecentlyNullable
    public final Integer i() {
        return this.f7336h;
    }
}
