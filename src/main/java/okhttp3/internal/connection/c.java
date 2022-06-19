package okhttp3.internal.connection;

import i.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* access modifiers changed from: package-private */
/* compiled from: ConnectionSpecSelector */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<p> f10800a;

    /* renamed from: b  reason: collision with root package name */
    private int f10801b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10802c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10803d;

    c(List<p> list) {
        this.f10800a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i2 = this.f10801b; i2 < this.f10800a.size(); i2++) {
            if (this.f10800a.get(i2).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public p a(SSLSocket sSLSocket) {
        p pVar;
        int i2 = this.f10801b;
        int size = this.f10800a.size();
        while (true) {
            if (i2 >= size) {
                pVar = null;
                break;
            }
            pVar = this.f10800a.get(i2);
            if (pVar.c(sSLSocket)) {
                this.f10801b = i2 + 1;
                break;
            }
            i2++;
        }
        if (pVar != null) {
            this.f10802c = c(sSLSocket);
            i.k0.c.f10443a.c(pVar, sSLSocket, this.f10803d);
            return pVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f10803d + ", modes=" + this.f10800a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* access modifiers changed from: package-private */
    public boolean b(IOException iOException) {
        this.f10803d = true;
        if (!this.f10802c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return iOException instanceof SSLException;
        }
        return false;
    }
}
