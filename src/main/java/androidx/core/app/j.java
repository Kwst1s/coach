package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: NotificationCompatJellybean */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1088a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f1089b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1090c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    static Bundle b(h.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat e2 = aVar.e();
        bundle2.putInt("icon", e2 != null ? e2.c() : 0);
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle c(Notification notification) {
        synchronized (f1088a) {
            if (f1090c) {
                return null;
            }
            try {
                if (f1089b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1090c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1089b = declaredField;
                }
                Bundle bundle = (Bundle) f1089b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1089b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1090c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f1090c = true;
                return null;
            }
        }
    }

    private static Bundle d(l lVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", lVar.i());
        bundle.putCharSequence("label", lVar.h());
        bundle.putCharSequenceArray("choices", lVar.e());
        bundle.putBoolean("allowFreeFormInput", lVar.c());
        bundle.putBundle("extras", lVar.g());
        Set<String> d2 = lVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d2.size());
            for (String str : d2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] e(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        for (int i2 = 0; i2 < lVarArr.length; i2++) {
            bundleArr[i2] = d(lVarArr[i2]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, h.a aVar) {
        IconCompat e2 = aVar.e();
        builder.addAction(e2 != null ? e2.c() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
