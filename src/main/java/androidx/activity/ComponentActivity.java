package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.e;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.j;
import androidx.lifecycle.r;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;

public class ComponentActivity extends e implements i, w, androidx.savedstate.b, c {

    /* renamed from: c  reason: collision with root package name */
    private final j f86c = new j(this);

    /* renamed from: d  reason: collision with root package name */
    private final androidx.savedstate.a f87d = androidx.savedstate.a.a(this);

    /* renamed from: e  reason: collision with root package name */
    private v f88e;

    /* renamed from: f  reason: collision with root package name */
    private final OnBackPressedDispatcher f89f = new OnBackPressedDispatcher(new a());

    /* renamed from: g  reason: collision with root package name */
    private int f90g;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Object f94a;

        /* renamed from: b  reason: collision with root package name */
        v f95b;

        b() {
        }
    }

    public ComponentActivity() {
        if (c() != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                c().a(new g() {
                    /* class androidx.activity.ComponentActivity.AnonymousClass2 */

                    @Override // androidx.lifecycle.g
                    public void d(i iVar, e.a aVar) {
                        if (aVar == e.a.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            c().a(new g() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // androidx.lifecycle.g
                public void d(i iVar, e.a aVar) {
                    if (aVar == e.a.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.t().a();
                    }
                }
            });
            if (19 <= i2 && i2 <= 23) {
                c().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.e c() {
        return this.f86c;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher e() {
        return this.f89f;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry f() {
        return this.f87d.b();
    }

    public void onBackPressed() {
        this.f89f.c();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.core.app.e
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f87d.c(bundle);
        r.g(this);
        int i2 = this.f90g;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object y = y();
        v vVar = this.f88e;
        if (vVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            vVar = bVar.f95b;
        }
        if (vVar == null && y == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f94a = y;
        bVar2.f95b = vVar;
        return bVar2;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.core.app.e
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.e c2 = c();
        if (c2 instanceof j) {
            ((j) c2).p(e.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f87d.d(bundle);
    }

    @Override // androidx.lifecycle.w
    public v t() {
        if (getApplication() != null) {
            if (this.f88e == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.f88e = bVar.f95b;
                }
                if (this.f88e == null) {
                    this.f88e = new v();
                }
            }
            return this.f88e;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object y() {
        return null;
    }
}
