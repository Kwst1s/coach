package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import b.h.j.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
public abstract class j<E> extends f {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f1276b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1277c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f1278d;

    /* renamed from: e  reason: collision with root package name */
    final m f1279e;

    j(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View b(int i2) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity g() {
        return this.f1276b;
    }

    /* access modifiers changed from: package-private */
    public Context h() {
        return this.f1277c;
    }

    /* access modifiers changed from: package-private */
    public Handler i() {
        return this.f1278d;
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
    }

    public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E l();

    public LayoutInflater m() {
        return LayoutInflater.from(this.f1277c);
    }

    public void n(Fragment fragment, String[] strArr, int i2) {
    }

    public boolean o(Fragment fragment) {
        return true;
    }

    public void p(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            this.f1277c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void q() {
    }

    j(Activity activity, Context context, Handler handler, int i2) {
        this.f1279e = new n();
        this.f1276b = activity;
        h.d(context, "context == null");
        this.f1277c = context;
        h.d(handler, "handler == null");
        this.f1278d = handler;
    }
}
