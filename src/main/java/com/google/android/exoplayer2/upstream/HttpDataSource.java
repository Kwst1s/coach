package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends i {

    public static class HttpDataSourceException extends IOException {
        public HttpDataSourceException(String str, k kVar, int i2) {
            super(str);
        }

        public HttpDataSourceException(IOException iOException, k kVar, int i2) {
            super(iOException);
        }

        public HttpDataSourceException(String str, IOException iOException, k kVar, int i2) {
            super(str, iOException);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public InvalidContentTypeException(String str, k kVar) {
            super("Invalid content type: " + str, kVar, 1);
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        /* renamed from: b  reason: collision with root package name */
        public final int f6874b;

        public InvalidResponseCodeException(int i2, String str, Map<String, List<String>> map, k kVar) {
            super("Response code: " + i2, kVar, 1);
            this.f6874b = i2;
        }
    }

    public static abstract class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f6875a = new b();

        /* renamed from: b */
        public final HttpDataSource a() {
            return c(this.f6875a);
        }

        /* access modifiers changed from: protected */
        public abstract HttpDataSource c(b bVar);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f6876a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f6877b;

        public synchronized Map<String, String> a() {
            if (this.f6877b == null) {
                this.f6877b = Collections.unmodifiableMap(new HashMap(this.f6876a));
            }
            return this.f6877b;
        }
    }

    static {
        b bVar = b.f6906a;
    }
}
