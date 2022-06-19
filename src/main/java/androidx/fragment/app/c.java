package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/* compiled from: DialogFragment */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler X;
    private Runnable Y = new a();
    private DialogInterface.OnCancelListener Z = new b();
    private DialogInterface.OnDismissListener a0 = new DialogInterface$OnDismissListenerC0019c();
    private int b0 = 0;
    private int c0 = 0;
    private boolean d0 = true;
    private boolean e0 = true;
    private int f0 = -1;
    private boolean g0;
    private Dialog h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;

    /* compiled from: DialogFragment */
    class a implements Runnable {
        a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.a0.onDismiss(c.this.h0);
        }
    }

    /* compiled from: DialogFragment */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.h0 != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.h0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    /* compiled from: DialogFragment */
    class DialogInterface$OnDismissListenerC0019c implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0019c() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.h0 != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.h0);
            }
        }
    }

    private void N1(boolean z, boolean z2) {
        if (!this.j0) {
            this.j0 = true;
            this.k0 = false;
            Dialog dialog = this.h0;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.h0.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.X.getLooper()) {
                        onDismiss(this.h0);
                    } else {
                        this.X.post(this.Y);
                    }
                }
            }
            this.i0 = true;
            if (this.f0 >= 0) {
                I().H0(this.f0, 1);
                this.f0 = -1;
                return;
            }
            u j2 = I().j();
            j2.o(this);
            if (z) {
                j2.j();
            } else {
                j2.i();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        super.K0(bundle);
        Dialog dialog = this.h0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i2 = this.b0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.c0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.d0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.e0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.f0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M0() {
        super.M0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void M1() {
        N1(false, false);
    }

    public Dialog O1() {
        return this.h0;
    }

    public int P1() {
        return this.c0;
    }

    public Dialog Q1(Bundle bundle) {
        return new Dialog(p1(), P1());
    }

    public final Dialog R1() {
        Dialog O1 = O1();
        if (O1 != null) {
            return O1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void S1(boolean z) {
        this.e0 = z;
    }

    public void T1(Dialog dialog, int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void U1(m mVar, String str) {
        this.j0 = false;
        this.k0 = true;
        u j2 = mVar.j();
        j2.f(this, str);
        j2.i();
    }

    @Override // androidx.fragment.app.Fragment
    public void i0(Bundle bundle) {
        Bundle bundle2;
        super.i0(bundle);
        if (this.e0) {
            View T = T();
            if (this.h0 != null) {
                if (T != null) {
                    if (T.getParent() == null) {
                        this.h0.setContentView(T);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                d n = n();
                if (n != null) {
                    this.h0.setOwnerActivity(n);
                }
                this.h0.setCancelable(this.d0);
                this.h0.setOnCancelListener(this.Z);
                this.h0.setOnDismissListener(this.a0);
                if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                    this.h0.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l0(Context context) {
        super.l0(context);
        if (!this.k0) {
            this.j0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.X = new Handler();
        this.e0 = this.x == 0;
        if (bundle != null) {
            this.b0 = bundle.getInt("android:style", 0);
            this.c0 = bundle.getInt("android:theme", 0);
            this.d0 = bundle.getBoolean("android:cancelable", true);
            this.e0 = bundle.getBoolean("android:showsDialog", this.e0);
            this.f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.i0) {
            N1(true, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void v0() {
        super.v0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = true;
            dialog.setOnDismissListener(null);
            this.h0.dismiss();
            if (!this.j0) {
                onDismiss(this.h0);
            }
            this.h0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w0() {
        super.w0();
        if (!this.k0 && !this.j0) {
            this.j0 = true;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.fragment.app.Fragment
    public LayoutInflater x0(Bundle bundle) {
        LayoutInflater x0 = super.x0(bundle);
        if (!this.e0 || this.g0) {
            return x0;
        }
        try {
            this.g0 = true;
            Dialog Q1 = Q1(bundle);
            this.h0 = Q1;
            T1(Q1, this.b0);
            this.g0 = false;
            return x0.cloneInContext(R1().getContext());
        } catch (Throwable th) {
            this.g0 = false;
            throw th;
        }
    }
}
