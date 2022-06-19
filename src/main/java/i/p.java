package i;

import i.k0.e;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec */
public final class p {

    /* renamed from: e  reason: collision with root package name */
    private static final m[] f10594e;

    /* renamed from: f  reason: collision with root package name */
    private static final m[] f10595f;

    /* renamed from: g  reason: collision with root package name */
    public static final p f10596g;

    /* renamed from: h  reason: collision with root package name */
    public static final p f10597h = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f10598a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f10599b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final String[] f10600c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final String[] f10601d;

    static {
        m mVar = m.q;
        m mVar2 = m.r;
        m mVar3 = m.s;
        m mVar4 = m.f10591k;
        m mVar5 = m.m;
        m mVar6 = m.l;
        m mVar7 = m.n;
        m mVar8 = m.p;
        m mVar9 = m.o;
        m[] mVarArr = {mVar, mVar2, mVar3, mVar4, mVar5, mVar6, mVar7, mVar8, mVar9};
        f10594e = mVarArr;
        m[] mVarArr2 = {mVar, mVar2, mVar3, mVar4, mVar5, mVar6, mVar7, mVar8, mVar9, m.f10589i, m.f10590j, m.f10587g, m.f10588h, m.f10585e, m.f10586f, m.f10584d};
        f10595f = mVarArr2;
        a aVar = new a(true);
        aVar.c(mVarArr);
        j0 j0Var = j0.TLS_1_3;
        j0 j0Var2 = j0.TLS_1_2;
        aVar.f(j0Var, j0Var2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.c(mVarArr2);
        aVar2.f(j0Var, j0Var2);
        aVar2.d(true);
        f10596g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.c(mVarArr2);
        aVar3.f(j0Var, j0Var2, j0.TLS_1_1, j0.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
    }

    p(a aVar) {
        this.f10598a = aVar.f10602a;
        this.f10600c = aVar.f10603b;
        this.f10601d = aVar.f10604c;
        this.f10599b = aVar.f10605d;
    }

    private p e(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f10600c != null) {
            strArr = e.w(m.f10582b, sSLSocket.getEnabledCipherSuites(), this.f10600c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f10601d != null) {
            strArr2 = e.w(e.f10450f, sSLSocket.getEnabledProtocols(), this.f10601d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int t = e.t(m.f10582b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && t != -1) {
            strArr = e.f(strArr, supportedCipherSuites[t]);
        }
        a aVar = new a(this);
        aVar.b(strArr);
        aVar.e(strArr2);
        return aVar.a();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        p e2 = e(sSLSocket, z);
        String[] strArr = e2.f10601d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e2.f10600c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<m> b() {
        String[] strArr = this.f10600c;
        if (strArr != null) {
            return m.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f10598a) {
            return false;
        }
        String[] strArr = this.f10601d;
        if (strArr != null && !e.z(e.f10450f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f10600c;
        if (strArr2 == null || e.z(m.f10582b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return this.f10598a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        p pVar = (p) obj;
        boolean z = this.f10598a;
        if (z != pVar.f10598a) {
            return false;
        }
        return !z || (Arrays.equals(this.f10600c, pVar.f10600c) && Arrays.equals(this.f10601d, pVar.f10601d) && this.f10599b == pVar.f10599b);
    }

    public boolean f() {
        return this.f10599b;
    }

    @Nullable
    public List<j0> g() {
        String[] strArr = this.f10601d;
        if (strArr != null) {
            return j0.c(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f10598a) {
            return ((((527 + Arrays.hashCode(this.f10600c)) * 31) + Arrays.hashCode(this.f10601d)) * 31) + (!this.f10599b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f10598a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(g(), "[all enabled]") + ", supportsTlsExtensions=" + this.f10599b + ")";
    }

    /* compiled from: ConnectionSpec */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f10602a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String[] f10603b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String[] f10604c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10605d;

        a(boolean z) {
            this.f10602a = z;
        }

        public p a() {
            return new p(this);
        }

        public a b(String... strArr) {
            if (!this.f10602a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f10603b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a c(m... mVarArr) {
            if (this.f10602a) {
                String[] strArr = new String[mVarArr.length];
                for (int i2 = 0; i2 < mVarArr.length; i2++) {
                    strArr[i2] = mVarArr[i2].f10592a;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(boolean z) {
            if (this.f10602a) {
                this.f10605d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(String... strArr) {
            if (!this.f10602a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f10604c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a f(j0... j0VarArr) {
            if (this.f10602a) {
                String[] strArr = new String[j0VarArr.length];
                for (int i2 = 0; i2 < j0VarArr.length; i2++) {
                    strArr[i2] = j0VarArr[i2].f10439b;
                }
                e(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(p pVar) {
            this.f10602a = pVar.f10598a;
            this.f10603b = pVar.f10600c;
            this.f10604c = pVar.f10601d;
            this.f10605d = pVar.f10599b;
        }
    }
}
