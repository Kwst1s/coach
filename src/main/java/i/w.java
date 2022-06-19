package i;

import i.k0.e;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final j0 f10627a;

    /* renamed from: b  reason: collision with root package name */
    private final m f10628b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f10629c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f10630d;

    private w(j0 j0Var, m mVar, List<Certificate> list, List<Certificate> list2) {
        this.f10627a = j0Var;
        this.f10628b = mVar;
        this.f10629c = list;
        this.f10630d = list2;
    }

    public static w b(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            m a2 = m.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                j0 a3 = j0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = e.r(certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = e.r(localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new w(a3, a2, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public static w c(j0 j0Var, m mVar, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(j0Var, "tlsVersion == null");
        Objects.requireNonNull(mVar, "cipherSuite == null");
        return new w(j0Var, mVar, e.q(list), e.q(list2));
    }

    private List<String> e(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public m a() {
        return this.f10628b;
    }

    public List<Certificate> d() {
        return this.f10630d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (!this.f10627a.equals(wVar.f10627a) || !this.f10628b.equals(wVar.f10628b) || !this.f10629c.equals(wVar.f10629c) || !this.f10630d.equals(wVar.f10630d)) {
            return false;
        }
        return true;
    }

    public List<Certificate> f() {
        return this.f10629c;
    }

    public j0 g() {
        return this.f10627a;
    }

    public int hashCode() {
        return ((((((527 + this.f10627a.hashCode()) * 31) + this.f10628b.hashCode()) * 31) + this.f10629c.hashCode()) * 31) + this.f10630d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f10627a + " cipherSuite=" + this.f10628b + " peerCertificates=" + e(this.f10629c) + " localCertificates=" + e(this.f10630d) + '}';
    }
}
