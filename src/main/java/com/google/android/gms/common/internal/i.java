package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import c.e.a.a.b.b.b;
import c.e.a.a.b.b.c;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public interface i extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static abstract class a extends c.e.a.a.b.b.a implements i {

        /* renamed from: com.google.android.gms.common.internal.i$a$a  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        public static class C0145a extends b implements i {
            C0145a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.i
            public final Account B() {
                Parcel i2 = i(2, e());
                Account account = (Account) c.a(i2, Account.CREATOR);
                i2.recycle();
                return account;
            }
        }

        @RecentlyNonNull
        public static i i(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof i) {
                return (i) queryLocalInterface;
            }
            return new C0145a(iBinder);
        }
    }

    @RecentlyNonNull
    Account B();
}
