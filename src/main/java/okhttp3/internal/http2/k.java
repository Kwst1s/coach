package okhttp3.internal.http2;

import j.e;
import java.util.List;

/* compiled from: PushObserver */
public interface k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f11021a = new a();

    /* compiled from: PushObserver */
    class a implements k {
        a() {
        }

        @Override // okhttp3.internal.http2.k
        public boolean a(int i2, List<b> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.k
        public boolean b(int i2, List<b> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.k
        public void c(int i2, a aVar) {
        }

        @Override // okhttp3.internal.http2.k
        public boolean d(int i2, e eVar, int i3, boolean z) {
            eVar.b((long) i3);
            return true;
        }
    }

    boolean a(int i2, List<b> list);

    boolean b(int i2, List<b> list, boolean z);

    void c(int i2, a aVar);

    boolean d(int i2, e eVar, int i3, boolean z);
}
