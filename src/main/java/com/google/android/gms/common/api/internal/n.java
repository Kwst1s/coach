package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.c;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class n<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f7236a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7237b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7238c;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        private l<A, com.google.android.gms.tasks.c<ResultT>> f7239a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7240b;

        /* renamed from: c  reason: collision with root package name */
        private c[] f7241c;

        /* renamed from: d  reason: collision with root package name */
        private int f7242d;

        private a() {
            this.f7240b = true;
            this.f7242d = 0;
        }

        @RecentlyNonNull
        public n<A, ResultT> a() {
            com.google.android.gms.common.internal.n.b(this.f7239a != null, "execute parameter required");
            return new j0(this, this.f7241c, this.f7240b, this.f7242d);
        }

        @RecentlyNonNull
        public a<A, ResultT> b(@RecentlyNonNull l<A, com.google.android.gms.tasks.c<ResultT>> lVar) {
            this.f7239a = lVar;
            return this;
        }

        @RecentlyNonNull
        public a<A, ResultT> c(boolean z) {
            this.f7240b = z;
            return this;
        }

        @RecentlyNonNull
        public a<A, ResultT> d(@RecentlyNonNull c... cVarArr) {
            this.f7241c = cVarArr;
            return this;
        }
    }

    protected n(@RecentlyNonNull c[] cVarArr, boolean z, int i2) {
        this.f7236a = cVarArr;
        this.f7237b = cVarArr != null && z;
        this.f7238c = i2;
    }

    @RecentlyNonNull
    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>();
    }

    /* access modifiers changed from: protected */
    public abstract void b(@RecentlyNonNull A a2, @RecentlyNonNull com.google.android.gms.tasks.c<ResultT> cVar);

    public boolean c() {
        return this.f7237b;
    }

    @RecentlyNullable
    public final c[] d() {
        return this.f7236a;
    }

    public final int e() {
        return this.f7238c;
    }
}
