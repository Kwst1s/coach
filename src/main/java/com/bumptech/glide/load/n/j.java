package com.bumptech.glide.load.n;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders */
public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<i>> f4004b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Map<String, String> f4005c;

    /* compiled from: LazyHeaders */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        private static final String f4006b;

        /* renamed from: c  reason: collision with root package name */
        private static final Map<String, List<i>> f4007c;

        /* renamed from: a  reason: collision with root package name */
        private Map<String, List<i>> f4008a = f4007c;

        static {
            String b2 = b();
            f4006b = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b2)));
            }
            f4007c = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public j a() {
            return new j(this.f4008a);
        }
    }

    /* compiled from: LazyHeaders */
    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f4009a;

        b(String str) {
            this.f4009a = str;
        }

        @Override // com.bumptech.glide.load.n.i
        public String a() {
            return this.f4009a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4009a.equals(((b) obj).f4009a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4009a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f4009a + '\'' + '}';
        }
    }

    j(Map<String, List<i>> map) {
        this.f4004b = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f4004b.entrySet()) {
            String b2 = b(entry.getValue());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(entry.getKey(), b2);
            }
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.n.h
    public Map<String, String> a() {
        if (this.f4005c == null) {
            synchronized (this) {
                if (this.f4005c == null) {
                    this.f4005c = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f4005c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f4004b.equals(((j) obj).f4004b);
        }
        return false;
    }

    public int hashCode() {
        return this.f4004b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4004b + '}';
    }
}
