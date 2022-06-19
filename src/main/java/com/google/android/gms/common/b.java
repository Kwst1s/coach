package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.n;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class b extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private Dialog f7277b;

    /* renamed from: c  reason: collision with root package name */
    private DialogInterface.OnCancelListener f7278c;

    /* renamed from: d  reason: collision with root package name */
    private Dialog f7279d;

    public static b a(@RecentlyNonNull Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        n.g(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.f7277b = dialog2;
        if (onCancelListener != null) {
            bVar.f7278c = onCancelListener;
        }
        return bVar;
    }

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7278c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f7277b;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f7279d == null) {
            this.f7279d = new AlertDialog.Builder(getActivity()).create();
        }
        return this.f7279d;
    }

    @Override // android.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
