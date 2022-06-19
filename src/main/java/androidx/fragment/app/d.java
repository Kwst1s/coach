package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import androidx.core.app.a;
import androidx.lifecycle.e;
import androidx.lifecycle.j;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import b.e.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity */
public class d extends ComponentActivity implements a.c, a.e {

    /* renamed from: h  reason: collision with root package name */
    final h f1248h = h.b(new a());

    /* renamed from: i  reason: collision with root package name */
    final j f1249i = new j(this);

    /* renamed from: j  reason: collision with root package name */
    boolean f1250j;

    /* renamed from: k  reason: collision with root package name */
    boolean f1251k;
    boolean l = true;
    boolean m;
    boolean n;
    boolean o;
    int p;
    h<String> q;

    /* compiled from: FragmentActivity */
    class a extends j<d> implements w, c {
        public a() {
            super(d.this);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public View b(int i2) {
            return d.this.findViewById(i2);
        }

        @Override // androidx.lifecycle.i
        public e c() {
            return d.this.f1249i;
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public boolean d() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher e() {
            return d.this.e();
        }

        @Override // androidx.fragment.app.j
        public void j(Fragment fragment) {
            d.this.F(fragment);
        }

        @Override // androidx.fragment.app.j
        public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.j
        public LayoutInflater m() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.j
        public void n(Fragment fragment, String[] strArr, int i2) {
            d.this.I(fragment, strArr, i2);
        }

        @Override // androidx.fragment.app.j
        public boolean o(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.j
        public void p(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            d.this.J(fragment, intent, i2, bundle);
        }

        @Override // androidx.fragment.app.j
        public void q() {
            d.this.K();
        }

        /* renamed from: r */
        public d l() {
            return d.this;
        }

        @Override // androidx.lifecycle.w
        public v t() {
            return d.this.t();
        }
    }

    static void A(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void D() {
        do {
        } while (E(C(), e.b.CREATED));
    }

    private static boolean E(m mVar, e.b bVar) {
        boolean z = false;
        for (Fragment fragment : mVar.i0()) {
            if (fragment != null) {
                if (fragment.C() != null) {
                    z |= E(fragment.v(), bVar);
                }
                y yVar = fragment.S;
                if (yVar != null && yVar.c().b().a(e.b.STARTED)) {
                    fragment.S.g(bVar);
                    z = true;
                }
                if (fragment.R.b().a(e.b.STARTED)) {
                    fragment.R.p(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    private int z(Fragment fragment) {
        if (this.q.m() < 65534) {
            while (this.q.g(this.p) >= 0) {
                this.p = (this.p + 1) % 65534;
            }
            int i2 = this.p;
            this.q.j(i2, fragment.f1214f);
            this.p = (this.p + 1) % 65534;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* access modifiers changed from: package-private */
    public final View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1248h.w(view, str, context, attributeSet);
    }

    public m C() {
        return this.f1248h.u();
    }

    public void F(Fragment fragment) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean G(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* access modifiers changed from: protected */
    public void H() {
        this.f1249i.i(e.a.ON_RESUME);
        this.f1248h.p();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void I(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            androidx.core.app.a.l(this, strArr, i2);
            return;
        }
        A(i2);
        try {
            this.m = true;
            androidx.core.app.a.l(this, strArr, ((z(fragment) + 1) << 16) + (i2 & 65535));
            this.m = false;
        } catch (Throwable th) {
            this.m = false;
            throw th;
        }
    }

    public void J(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        this.o = true;
        if (i2 == -1) {
            try {
                androidx.core.app.a.n(this, intent, -1, bundle);
            } finally {
                this.o = false;
            }
        } else {
            A(i2);
            androidx.core.app.a.n(this, intent, ((z(fragment) + 1) << 16) + (i2 & 65535), bundle);
            this.o = false;
        }
    }

    @Deprecated
    public void K() {
        invalidateOptionsMenu();
    }

    @Override // androidx.core.app.a.e
    public final void d(int i2) {
        if (!this.m && i2 != -1) {
            A(i2);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1250j);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1251k);
        printWriter.print(" mStopped=");
        printWriter.print(this.l);
        if (getApplication() != null) {
            b.n.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1248h.u().N(str, fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f1248h.v();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String e2 = this.q.e(i5);
            this.q.k(i5);
            if (e2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.f1248h.t(e2);
            if (t == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e2);
                return;
            }
            t.j0(i2 & 65535, i3, intent);
            return;
        }
        a.d j2 = androidx.core.app.a.j();
        if (j2 == null || !j2.a(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1248h.v();
        this.f1248h.d(configuration);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e
    public void onCreate(Bundle bundle) {
        this.f1248h.a(null);
        if (bundle != null) {
            this.f1248h.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.p = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.q = new h<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.q.j(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.q == null) {
            this.q = new h<>();
            this.p = 0;
        }
        super.onCreate(bundle);
        this.f1249i.i(e.a.ON_CREATE);
        this.f1248h.f();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.f1248h.g(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View B = B(view, str, context, attributeSet);
        return B == null ? super.onCreateView(view, str, context, attributeSet) : B;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1248h.h();
        this.f1249i.i(e.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f1248h.i();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1248h.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f1248h.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f1248h.j(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f1248h.v();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f1248h.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f1251k = false;
        this.f1248h.m();
        this.f1249i.i(e.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f1248h.n(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        H();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return G(view, menu) | this.f1248h.o(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f1248h.v();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String e2 = this.q.e(i4);
            this.q.k(i4);
            if (e2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.f1248h.t(e2);
            if (t == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e2);
                return;
            }
            t.I0(i2 & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f1251k = true;
        this.f1248h.v();
        this.f1248h.s();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        D();
        this.f1249i.i(e.a.ON_STOP);
        Parcelable y = this.f1248h.y();
        if (y != null) {
            bundle.putParcelable("android:support:fragments", y);
        }
        if (this.q.m() > 0) {
            bundle.putInt("android:support:next_request_index", this.p);
            int[] iArr = new int[this.q.m()];
            String[] strArr = new String[this.q.m()];
            for (int i2 = 0; i2 < this.q.m(); i2++) {
                iArr[i2] = this.q.i(i2);
                strArr[i2] = this.q.n(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.l = false;
        if (!this.f1250j) {
            this.f1250j = true;
            this.f1248h.c();
        }
        this.f1248h.v();
        this.f1248h.s();
        this.f1249i.i(e.a.ON_START);
        this.f1248h.q();
    }

    public void onStateNotSaved() {
        this.f1248h.v();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.l = true;
        D();
        this.f1248h.r();
        this.f1249i.i(e.a.ON_STOP);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.o && i2 != -1) {
            A(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        if (!this.n && i2 != -1) {
            A(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View B = B(null, str, context, attributeSet);
        return B == null ? super.onCreateView(str, context, attributeSet) : B;
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.o && i2 != -1) {
            A(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (!this.n && i2 != -1) {
            A(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
