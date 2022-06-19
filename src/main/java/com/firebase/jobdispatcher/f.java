package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

/* compiled from: GooglePlayCallbackExtractor */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f4610a;

    f() {
    }

    private static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @SuppressLint({"ParcelClassLoader"})
    private static Pair<o, Bundle> c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Parcel f2 = f(bundle);
        try {
            if (f2.readInt() <= 0) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                return null;
            } else if (f2.readInt() != 1279544898) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                f2.recycle();
                return null;
            } else {
                int readInt = f2.readInt();
                h hVar = null;
                for (int i2 = 0; i2 < readInt; i2++) {
                    String d2 = d(f2);
                    if (d2 != null) {
                        if (hVar != null || !"callback".equals(d2)) {
                            Object readValue = f2.readValue(null);
                            if (readValue instanceof String) {
                                bundle2.putString(d2, (String) readValue);
                            } else if (readValue instanceof Boolean) {
                                bundle2.putBoolean(d2, ((Boolean) readValue).booleanValue());
                            } else if (readValue instanceof Integer) {
                                bundle2.putInt(d2, ((Integer) readValue).intValue());
                            } else if (readValue instanceof ArrayList) {
                                bundle2.putParcelableArrayList(d2, (ArrayList) readValue);
                            } else if (readValue instanceof Bundle) {
                                bundle2.putBundle(d2, (Bundle) readValue);
                            } else if (readValue instanceof Parcelable) {
                                bundle2.putParcelable(d2, (Parcelable) readValue);
                            }
                        } else if (f2.readInt() != 4) {
                            Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                            f2.recycle();
                            return null;
                        } else if (!"com.google.android.gms.gcm.PendingCallback".equals(f2.readString())) {
                            Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                            f2.recycle();
                            return null;
                        } else {
                            hVar = new h(f2.readStrongBinder());
                        }
                    }
                }
                if (hVar == null) {
                    Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                    f2.recycle();
                    return null;
                }
                Pair<o, Bundle> create = Pair.create(hVar, bundle2);
                f2.recycle();
                return create;
            }
        } finally {
            f2.recycle();
        }
    }

    private static String d(Parcel parcel) {
        if (e()) {
            return parcel.readString();
        }
        Object readValue = parcel.readValue(null);
        if (readValue instanceof String) {
            return (String) readValue;
        }
        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.firebase.jobdispatcher.f.f4610a = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean e() {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.f.e():boolean");
    }

    private static Parcel f(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    public Pair<o, Bundle> b(Bundle bundle) {
        if (bundle != null) {
            return c(bundle);
        }
        Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
        return null;
    }
}
