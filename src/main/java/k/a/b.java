package k.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
public final /* synthetic */ class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f10713a;

    public /* synthetic */ b(boolean z) {
        this.f10713a = z;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return h.g(this.f10713a, str, sSLSession);
    }
}
