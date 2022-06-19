package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class m {

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f7383a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f7384b;

        private a(Object obj) {
            n.f(obj);
            this.f7384b = obj;
            this.f7383a = new ArrayList();
        }

        @RecentlyNonNull
        public final a a(@RecentlyNonNull String str, Object obj) {
            List<String> list = this.f7383a;
            n.f(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @RecentlyNonNull
        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f7384b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f7383a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.f7383a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(@RecentlyNonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @RecentlyNonNull
    public static a c(@RecentlyNonNull Object obj) {
        return new a(obj);
    }
}
