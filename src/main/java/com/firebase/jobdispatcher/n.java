package com.firebase.jobdispatcher;

import android.os.Bundle;

/* compiled from: Job */
public final class n implements r {

    /* renamed from: a  reason: collision with root package name */
    private final String f4621a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4622b;

    /* renamed from: c  reason: collision with root package name */
    private final t f4623c;

    /* renamed from: d  reason: collision with root package name */
    private final w f4624d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4625e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4626f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f4627g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f4628h;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f4629i;

    /* compiled from: Job */
    public static final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        private final ValidationEnforcer f4630a;

        /* renamed from: b  reason: collision with root package name */
        private String f4631b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f4632c;

        /* renamed from: d  reason: collision with root package name */
        private String f4633d;

        /* renamed from: e  reason: collision with root package name */
        private t f4634e = x.f4675a;

        /* renamed from: f  reason: collision with root package name */
        private int f4635f = 1;

        /* renamed from: g  reason: collision with root package name */
        private int[] f4636g;

        /* renamed from: h  reason: collision with root package name */
        private w f4637h = w.f4671d;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4638i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f4639j = false;

        b(ValidationEnforcer validationEnforcer, r rVar) {
            this.f4630a = validationEnforcer;
            this.f4633d = rVar.a();
            this.f4631b = rVar.i();
            this.f4634e = rVar.b();
            this.f4639j = rVar.g();
            this.f4635f = rVar.e();
            this.f4636g = rVar.c();
            this.f4632c = rVar.d();
            this.f4637h = rVar.f();
        }

        @Override // com.firebase.jobdispatcher.r
        public String a() {
            return this.f4633d;
        }

        @Override // com.firebase.jobdispatcher.r
        public t b() {
            return this.f4634e;
        }

        @Override // com.firebase.jobdispatcher.r
        public int[] c() {
            int[] iArr = this.f4636g;
            return iArr == null ? new int[0] : iArr;
        }

        @Override // com.firebase.jobdispatcher.r
        public Bundle d() {
            return this.f4632c;
        }

        @Override // com.firebase.jobdispatcher.r
        public int e() {
            return this.f4635f;
        }

        @Override // com.firebase.jobdispatcher.r
        public w f() {
            return this.f4637h;
        }

        @Override // com.firebase.jobdispatcher.r
        public boolean g() {
            return this.f4639j;
        }

        @Override // com.firebase.jobdispatcher.r
        public boolean h() {
            return this.f4638i;
        }

        @Override // com.firebase.jobdispatcher.r
        public String i() {
            return this.f4631b;
        }

        public n s() {
            this.f4630a.c(this);
            return new n(this);
        }

        public b t(boolean z) {
            this.f4638i = z;
            return this;
        }
    }

    @Override // com.firebase.jobdispatcher.r
    public String a() {
        return this.f4622b;
    }

    @Override // com.firebase.jobdispatcher.r
    public t b() {
        return this.f4623c;
    }

    @Override // com.firebase.jobdispatcher.r
    public int[] c() {
        return this.f4627g;
    }

    @Override // com.firebase.jobdispatcher.r
    public Bundle d() {
        return this.f4629i;
    }

    @Override // com.firebase.jobdispatcher.r
    public int e() {
        return this.f4625e;
    }

    @Override // com.firebase.jobdispatcher.r
    public w f() {
        return this.f4624d;
    }

    @Override // com.firebase.jobdispatcher.r
    public boolean g() {
        return this.f4626f;
    }

    @Override // com.firebase.jobdispatcher.r
    public boolean h() {
        return this.f4628h;
    }

    @Override // com.firebase.jobdispatcher.r
    public String i() {
        return this.f4621a;
    }

    private n(b bVar) {
        this.f4621a = bVar.f4631b;
        this.f4629i = bVar.f4632c == null ? null : new Bundle(bVar.f4632c);
        this.f4622b = bVar.f4633d;
        this.f4623c = bVar.f4634e;
        this.f4624d = bVar.f4637h;
        this.f4625e = bVar.f4635f;
        this.f4626f = bVar.f4639j;
        this.f4627g = bVar.f4636g != null ? bVar.f4636g : new int[0];
        this.f4628h = bVar.f4638i;
    }
}
