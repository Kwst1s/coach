package j;

import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: SegmentPool */
public final class q {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    static p f10703a;

    /* renamed from: b  reason: collision with root package name */
    static long f10704b;

    private q() {
    }

    static void a(p pVar) {
        if (pVar.f10701f != null || pVar.f10702g != null) {
            throw new IllegalArgumentException();
        } else if (!pVar.f10699d) {
            synchronized (q.class) {
                long j2 = f10704b;
                if (j2 + 8192 <= 65536) {
                    f10704b = j2 + 8192;
                    pVar.f10701f = f10703a;
                    pVar.f10698c = 0;
                    pVar.f10697b = 0;
                    f10703a = pVar;
                }
            }
        }
    }

    static p b() {
        synchronized (q.class) {
            p pVar = f10703a;
            if (pVar == null) {
                return new p();
            }
            f10703a = pVar.f10701f;
            pVar.f10701f = null;
            f10704b -= 8192;
            return pVar;
        }
    }
}
