package i.k0.h;

import i.b0;
import i.e0;
import i.f0;
import i.g0;
import i.i0;
import i.k0.e;
import i.y;
import i.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: RetryAndFollowUpInterceptor */
public final class j implements z {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f10518a;

    public j(b0 b0Var) {
        this.f10518a = b0Var;
    }

    private e0 b(g0 g0Var, @Nullable i0 i0Var) {
        String I;
        y A;
        Proxy proxy;
        if (g0Var != null) {
            int G = g0Var.G();
            String g2 = g0Var.S().g();
            f0 f0Var = null;
            if (G == 307 || G == 308) {
                if (!g2.equals("GET") && !g2.equals("HEAD")) {
                    return null;
                }
            } else if (G == 401) {
                return this.f10518a.b().a(i0Var, g0Var);
            } else {
                if (G != 503) {
                    if (G == 407) {
                        if (i0Var != null) {
                            proxy = i0Var.b();
                        } else {
                            proxy = this.f10518a.w();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f10518a.x().a(i0Var, g0Var);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (G != 408) {
                        switch (G) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f10518a.A()) {
                        return null;
                    } else {
                        f0 a2 = g0Var.S().a();
                        if (a2 != null && a2.f()) {
                            return null;
                        }
                        if ((g0Var.P() == null || g0Var.P().G() != 408) && f(g0Var, 0) <= 0) {
                            return g0Var.S();
                        }
                        return null;
                    }
                } else if ((g0Var.P() == null || g0Var.P().G() != 503) && f(g0Var, Integer.MAX_VALUE) == 0) {
                    return g0Var.S();
                } else {
                    return null;
                }
            }
            if (!this.f10518a.n() || (I = g0Var.I("Location")) == null || (A = g0Var.S().i().A(I)) == null) {
                return null;
            }
            if (!A.B().equals(g0Var.S().i().B()) && !this.f10518a.o()) {
                return null;
            }
            e0.a h2 = g0Var.S().h();
            if (f.b(g2)) {
                boolean d2 = f.d(g2);
                if (f.c(g2)) {
                    h2.e("GET", null);
                } else {
                    if (d2) {
                        f0Var = g0Var.S().a();
                    }
                    h2.e(g2, f0Var);
                }
                if (!d2) {
                    h2.f("Transfer-Encoding");
                    h2.f("Content-Length");
                    h2.f("Content-Type");
                }
            }
            if (!e.B(g0Var.S().i(), A)) {
                h2.f("Authorization");
            }
            h2.h(A);
            return h2.a();
        }
        throw new IllegalStateException();
    }

    private boolean c(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean d(IOException iOException, okhttp3.internal.connection.j jVar, boolean z, e0 e0Var) {
        if (!this.f10518a.A()) {
            return false;
        }
        if ((!z || !e(iOException, e0Var)) && c(iOException, z) && jVar.c()) {
            return true;
        }
        return false;
    }

    private boolean e(IOException iOException, e0 e0Var) {
        f0 a2 = e0Var.a();
        return (a2 != null && a2.f()) || (iOException instanceof FileNotFoundException);
    }

    private int f(g0 g0Var, int i2) {
        String I = g0Var.I("Retry-After");
        if (I == null) {
            return i2;
        }
        if (I.matches("\\d+")) {
            return Integer.valueOf(I).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b1, code lost:
        r1.f();
     */
    @Override // i.z
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i.g0 a(i.z.a r9) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: i.k0.h.j.a(i.z$a):i.g0");
    }
}
