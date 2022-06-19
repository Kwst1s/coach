package com.bumptech.glide.p;

/* compiled from: RequestCoordinator */
public interface d {

    /* compiled from: RequestCoordinator */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4313b;

        private a(boolean z) {
            this.f4313b = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f4313b;
        }
    }

    void a(c cVar);

    boolean b(c cVar);

    boolean d();

    boolean g(c cVar);

    d h();

    void j(c cVar);

    boolean l(c cVar);
}
