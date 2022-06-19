package k.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
public final /* synthetic */ class a implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f10712a;

    public /* synthetic */ a(boolean z) {
        this.f10712a = z;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return h.f(this.f10712a, str, sSLSession);
    }
}
