package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public class c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final i<TResult> f7457a = new i<>();

    public b<TResult> a() {
        return this.f7457a;
    }

    public void b(Exception exc) {
        this.f7457a.h(exc);
    }

    public void c(TResult tresult) {
        this.f7457a.i(tresult);
    }

    public boolean d(Exception exc) {
        return this.f7457a.k(exc);
    }

    public boolean e(TResult tresult) {
        return this.f7457a.l(tresult);
    }
}
