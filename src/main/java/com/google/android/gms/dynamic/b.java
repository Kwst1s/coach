package com.google.android.gms.dynamic;

import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamic.a;
import java.lang.reflect.Field;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class b<T> extends a.AbstractBinderC0146a {

    /* renamed from: a  reason: collision with root package name */
    private final T f7441a;

    private b(T t) {
        this.f7441a = t;
    }

    @RecentlyNonNull
    public static <T> a T(@RecentlyNonNull T t) {
        return new b(t);
    }

    @RecentlyNonNull
    public static <T> T k(@RecentlyNonNull a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f7441a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 == 1) {
            n.f(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T) field.get(asBinder);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
