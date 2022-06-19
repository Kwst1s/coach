package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ b f7463b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ e f7464c;

    f(e eVar, b bVar) {
        this.f7464c = eVar;
        this.f7463b = bVar;
    }

    public final void run() {
        synchronized (e.b(this.f7464c)) {
            if (e.c(this.f7464c) != null) {
                e.c(this.f7464c).a(this.f7463b);
            }
        }
    }
}
