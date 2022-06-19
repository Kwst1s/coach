package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.i;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class a extends i.a {
    @RecentlyNullable
    public static Account k(@RecentlyNonNull i iVar) {
        if (iVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return iVar.B();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
