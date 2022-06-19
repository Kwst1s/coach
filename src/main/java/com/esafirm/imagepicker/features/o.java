package com.esafirm.imagepicker.features;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import c.c.a.f;
import com.esafirm.imagepicker.features.s.c;
import com.esafirm.imagepicker.features.u.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: ImagePickerPresenter */
public class o extends b<q> {

    /* renamed from: b  reason: collision with root package name */
    private k f4544b;

    /* renamed from: c  reason: collision with root package name */
    private c f4545c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f4546d = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: package-private */
    /* compiled from: ImagePickerPresenter */
    public class a implements com.esafirm.imagepicker.features.u.c {
        a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(Throwable th) {
            ((q) o.this.c()).k(th);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(List list, List list2) {
            boolean z;
            ((q) o.this.c()).p(list, list2);
            if (list2 != null) {
                z = list2.isEmpty();
            } else {
                z = list.isEmpty();
            }
            if (z) {
                ((q) o.this.c()).m();
            } else {
                ((q) o.this.c()).b(false);
            }
        }

        @Override // com.esafirm.imagepicker.features.u.c
        public void a(Throwable th) {
            o.this.s(new g(this, th));
        }

        @Override // com.esafirm.imagepicker.features.u.c
        public void b(List<c.c.a.i.b> list, List<c.c.a.i.a> list2) {
            o.this.s(new f(this, list, list2));
        }
    }

    o(k kVar) {
        this.f4544b = kVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(com.esafirm.imagepicker.features.u.a aVar, List list) {
        if (com.esafirm.imagepicker.helper.a.d(aVar, true)) {
            ((q) c()).g(list);
        } else {
            ((q) c()).h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n() {
        ((q) c()).b(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(Runnable runnable) {
        if (d()) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(Runnable runnable) {
        this.f4546d.post(new j(this, runnable));
    }

    /* access modifiers changed from: package-private */
    public void e() {
        j().f();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4544b.a();
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, com.esafirm.imagepicker.features.u.a aVar, int i2) {
        Context applicationContext = fragment.n().getApplicationContext();
        Intent a2 = j().a(fragment.n(), aVar);
        if (a2 == null) {
            Toast.makeText(applicationContext, applicationContext.getString(f.ef_error_create_image_file), 1).show();
        } else {
            fragment.H1(a2, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Context context, Intent intent, com.esafirm.imagepicker.features.u.a aVar) {
        j().c(context, intent, new i(this, aVar));
    }

    /* access modifiers changed from: package-private */
    public c j() {
        if (this.f4545c == null) {
            this.f4545c = new c();
        }
        return this.f4545c;
    }

    /* access modifiers changed from: package-private */
    public void q(l lVar) {
        if (d()) {
            boolean v = lVar.v();
            boolean x = lVar.x();
            boolean w = lVar.w();
            ArrayList<File> n = lVar.n();
            s(new h(this));
            this.f4544b.f(v, x, w, n, new a());
        }
    }

    /* access modifiers changed from: package-private */
    public void r(List<c.c.a.i.b> list) {
        if (list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                if (!new File(list.get(i2).g()).exists()) {
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            ((q) c()).g(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(c cVar) {
        this.f4545c = cVar;
    }
}
