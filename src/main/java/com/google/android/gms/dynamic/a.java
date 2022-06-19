package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import c.e.a.a.b.b.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public interface a extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.a$a  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static abstract class AbstractBinderC0146a extends c.e.a.a.b.b.a implements a {

        /* renamed from: com.google.android.gms.dynamic.a$a$a  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        public static class C0147a extends b implements a {
            C0147a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0146a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static a i(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0147a(iBinder);
        }
    }
}
