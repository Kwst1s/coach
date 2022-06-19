package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: JobInvocation */
public final class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final String f4641a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4642b;

    /* renamed from: c  reason: collision with root package name */
    private final t f4643c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4644d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4645e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f4646f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f4647g;

    /* renamed from: h  reason: collision with root package name */
    private final w f4648h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f4649i;

    /* renamed from: j  reason: collision with root package name */
    private final y f4650j;

    /* access modifiers changed from: package-private */
    /* compiled from: JobInvocation */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f4651a;

        /* renamed from: b  reason: collision with root package name */
        private String f4652b;

        /* renamed from: c  reason: collision with root package name */
        private t f4653c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4654d;

        /* renamed from: e  reason: collision with root package name */
        private int f4655e;

        /* renamed from: f  reason: collision with root package name */
        private int[] f4656f;

        /* renamed from: g  reason: collision with root package name */
        private final Bundle f4657g = new Bundle();

        /* renamed from: h  reason: collision with root package name */
        private w f4658h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4659i;

        /* renamed from: j  reason: collision with root package name */
        private y f4660j;

        b() {
        }

        /* access modifiers changed from: package-private */
        public b k(Bundle bundle) {
            if (bundle != null) {
                this.f4657g.putAll(bundle);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public q l() {
            if (this.f4651a != null && this.f4652b != null && this.f4653c != null) {
                return new q(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        /* access modifiers changed from: package-private */
        public b m(int... iArr) {
            this.f4656f = iArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b n(int i2) {
            this.f4655e = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b o(boolean z) {
            this.f4654d = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b p(boolean z) {
            this.f4659i = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b q(w wVar) {
            this.f4658h = wVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b r(String str) {
            this.f4652b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b s(String str) {
            this.f4651a = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b t(t tVar) {
            this.f4653c = tVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b u(y yVar) {
            this.f4660j = yVar;
            return this;
        }
    }

    @Override // com.firebase.jobdispatcher.r
    public String a() {
        return this.f4641a;
    }

    @Override // com.firebase.jobdispatcher.r
    public t b() {
        return this.f4643c;
    }

    @Override // com.firebase.jobdispatcher.r
    public int[] c() {
        return this.f4646f;
    }

    @Override // com.firebase.jobdispatcher.r
    public Bundle d() {
        return this.f4647g;
    }

    @Override // com.firebase.jobdispatcher.r
    public int e() {
        return this.f4645e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !q.class.equals(obj.getClass())) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.f4641a.equals(qVar.f4641a) || !this.f4642b.equals(qVar.f4642b)) {
            return false;
        }
        return true;
    }

    @Override // com.firebase.jobdispatcher.r
    public w f() {
        return this.f4648h;
    }

    @Override // com.firebase.jobdispatcher.r
    public boolean g() {
        return this.f4644d;
    }

    @Override // com.firebase.jobdispatcher.r
    public boolean h() {
        return this.f4649i;
    }

    public int hashCode() {
        return (this.f4641a.hashCode() * 31) + this.f4642b.hashCode();
    }

    @Override // com.firebase.jobdispatcher.r
    public String i() {
        return this.f4642b;
    }

    public String toString() {
        return "JobInvocation{tag='" + JSONObject.quote(this.f4641a) + '\'' + ", service='" + this.f4642b + '\'' + ", trigger=" + this.f4643c + ", recurring=" + this.f4644d + ", lifetime=" + this.f4645e + ", constraints=" + Arrays.toString(this.f4646f) + ", extras=" + this.f4647g + ", retryStrategy=" + this.f4648h + ", replaceCurrent=" + this.f4649i + ", triggerReason=" + this.f4650j + '}';
    }

    private q(b bVar) {
        this.f4641a = bVar.f4651a;
        this.f4642b = bVar.f4652b;
        this.f4643c = bVar.f4653c;
        this.f4648h = bVar.f4658h;
        this.f4644d = bVar.f4654d;
        this.f4645e = bVar.f4655e;
        this.f4646f = bVar.f4656f;
        this.f4647g = bVar.f4657g;
        this.f4649i = bVar.f4659i;
        this.f4650j = bVar.f4660j;
    }
}
