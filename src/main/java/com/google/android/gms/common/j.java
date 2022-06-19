package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.c;
import androidx.fragment.app.m;
import com.google.android.gms.common.internal.n;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class j extends c {
    private Dialog l0;
    private DialogInterface.OnCancelListener m0;
    private Dialog n0;

    public static j V1(@RecentlyNonNull Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        j jVar = new j();
        n.g(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        jVar.l0 = dialog2;
        if (onCancelListener != null) {
            jVar.m0 = onCancelListener;
        }
        return jVar;
    }

    @Override // androidx.fragment.app.c
    public Dialog Q1(Bundle bundle) {
        Dialog dialog = this.l0;
        if (dialog != null) {
            return dialog;
        }
        S1(false);
        if (this.n0 == null) {
            this.n0 = new AlertDialog.Builder(n()).create();
        }
        return this.n0;
    }

    @Override // androidx.fragment.app.c
    public void U1(@RecentlyNonNull m mVar, String str) {
        super.U1(mVar, str);
    }

    @Override // androidx.fragment.app.c
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.m0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
