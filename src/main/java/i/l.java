package i;

import i.k0.m.c;
import j.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner */
public final class l {

    /* renamed from: c  reason: collision with root package name */
    public static final l f10574c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f10575a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final c f10576b;

    /* compiled from: CertificatePinner */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f10577a = new ArrayList();

        public l a() {
            return new l(new LinkedHashSet(this.f10577a), null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: CertificatePinner */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f10578a;

        /* renamed from: b  reason: collision with root package name */
        final String f10579b;

        /* renamed from: c  reason: collision with root package name */
        final String f10580c;

        /* renamed from: d  reason: collision with root package name */
        final f f10581d;

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f10578a.startsWith("*.")) {
                return str.equals(this.f10579b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f10579b.length()) {
                String str2 = this.f10579b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f10578a.equals(bVar.f10578a) && this.f10580c.equals(bVar.f10580c) && this.f10581d.equals(bVar.f10581d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f10578a.hashCode()) * 31) + this.f10580c.hashCode()) * 31) + this.f10581d.hashCode();
        }

        public String toString() {
            return this.f10580c + this.f10581d.a();
        }
    }

    l(Set<b> set, @Nullable c cVar) {
        this.f10575a = set;
        this.f10576b = cVar;
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + e((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static f d(X509Certificate x509Certificate) {
        return f.m(x509Certificate.getPublicKey().getEncoded()).p();
    }

    static f e(X509Certificate x509Certificate) {
        return f.m(x509Certificate.getPublicKey().getEncoded()).q();
    }

    public void a(String str, List<Certificate> list) {
        List<b> b2 = b(str);
        if (!b2.isEmpty()) {
            c cVar = this.f10576b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = b2.size();
                f fVar = null;
                f fVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = b2.get(i3);
                    if (bVar.f10580c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = e(x509Certificate);
                        }
                        if (bVar.f10581d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f10580c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = d(x509Certificate);
                        }
                        if (bVar.f10581d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f10580c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(c(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = b2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(b2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public List<b> b(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f10575a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (!Objects.equals(this.f10576b, lVar.f10576b) || !this.f10575a.equals(lVar.f10575a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public l f(@Nullable c cVar) {
        return Objects.equals(this.f10576b, cVar) ? this : new l(this.f10575a, cVar);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f10576b) * 31) + this.f10575a.hashCode();
    }
}
