package okhttp3.internal.connection;

import i.b0;
import i.e0;
import i.g0;
import i.k0.h.g;
import i.z;

/* compiled from: ConnectInterceptor */
public final class b implements z {
    public b(b0 b0Var) {
    }

    @Override // i.z
    public g0 a(z.a aVar) {
        g gVar = (g) aVar;
        e0 e2 = gVar.e();
        j h2 = gVar.h();
        return gVar.g(e2, h2, h2.k(aVar, !e2.g().equals("GET")));
    }
}
