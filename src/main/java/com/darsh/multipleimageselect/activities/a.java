package com.darsh.multipleimageselect.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.app.c;
import c.a.a.e;
import com.google.android.material.snackbar.Snackbar;

/* compiled from: HelperActivity */
public class a extends c {
    protected View t;
    private final String[] u = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* access modifiers changed from: package-private */
    /* renamed from: com.darsh.multipleimageselect.activities.a$a  reason: collision with other inner class name */
    /* compiled from: HelperActivity */
    public class View$OnClickListenerC0110a implements View.OnClickListener {
        View$OnClickListenerC0110a() {
        }

        public void onClick(View view) {
            a aVar = a.this;
            androidx.core.app.a.l(aVar, aVar.u, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: HelperActivity */
    public class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Uri fromParts = Uri.fromParts(a.this.getString(e.permission_package), a.this.getPackageName(), null);
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(1073741824);
            intent.setData(fromParts);
            a.this.startActivityForResult(intent, 1000);
        }
    }

    private void Z() {
        Y();
        b0();
    }

    private void b0() {
        if (androidx.core.app.a.m(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            e0();
        } else {
            d0();
        }
    }

    private void d0() {
        Snackbar W = Snackbar.W(this.t, getString(e.permission_force), -2);
        W.X(getString(e.permission_settings), new b());
        W.M();
    }

    private void e0() {
        Snackbar W = Snackbar.W(this.t, getString(e.permission_info), -2);
        W.X(getString(e.permission_ok), new View$OnClickListenerC0110a());
        W.M();
    }

    /* access modifiers changed from: protected */
    public void X() {
        if (b.h.d.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            a0();
        } else {
            androidx.core.app.a.l(this, this.u, 1000);
        }
    }

    /* access modifiers changed from: protected */
    public void Y() {
    }

    /* access modifiers changed from: protected */
    public void a0() {
    }

    /* access modifiers changed from: protected */
    public void c0(View view) {
        this.t = view;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 1000 || iArr.length == 0 || iArr[0] == -1) {
            Z();
        } else {
            a0();
        }
    }
}
