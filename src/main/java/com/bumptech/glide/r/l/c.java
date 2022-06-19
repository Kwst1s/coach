package com.bumptech.glide.r.l;

/* compiled from: StateVerifier */
public abstract class c {

    /* access modifiers changed from: private */
    /* compiled from: StateVerifier */
    public static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f4389a;

        b() {
            super();
        }

        @Override // com.bumptech.glide.r.l.c
        public void b(boolean z) {
            this.f4389a = z;
        }

        @Override // com.bumptech.glide.r.l.c
        public void c() {
            if (this.f4389a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(boolean z);

    public abstract void c();

    private c() {
    }
}
