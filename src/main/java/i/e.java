package i;

import i.y;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    final y f10331a;

    /* renamed from: b  reason: collision with root package name */
    final u f10332b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f10333c;

    /* renamed from: d  reason: collision with root package name */
    final g f10334d;

    /* renamed from: e  reason: collision with root package name */
    final List<c0> f10335e;

    /* renamed from: f  reason: collision with root package name */
    final List<p> f10336f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f10337g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    final Proxy f10338h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f10339i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f10340j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final l f10341k;

    public e(String str, int i2, u uVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable l lVar, g gVar, @Nullable Proxy proxy, List<c0> list, List<p> list2, ProxySelector proxySelector) {
        y.a aVar = new y.a();
        aVar.q(sSLSocketFactory != null ? "https" : "http");
        aVar.e(str);
        aVar.l(i2);
        this.f10331a = aVar.a();
        Objects.requireNonNull(uVar, "dns == null");
        this.f10332b = uVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f10333c = socketFactory;
        Objects.requireNonNull(gVar, "proxyAuthenticator == null");
        this.f10334d = gVar;
        Objects.requireNonNull(list, "protocols == null");
        this.f10335e = i.k0.e.q(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f10336f = i.k0.e.q(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f10337g = proxySelector;
        this.f10338h = proxy;
        this.f10339i = sSLSocketFactory;
        this.f10340j = hostnameVerifier;
        this.f10341k = lVar;
    }

    @Nullable
    public l a() {
        return this.f10341k;
    }

    public List<p> b() {
        return this.f10336f;
    }

    public u c() {
        return this.f10332b;
    }

    /* access modifiers changed from: package-private */
    public boolean d(e eVar) {
        return this.f10332b.equals(eVar.f10332b) && this.f10334d.equals(eVar.f10334d) && this.f10335e.equals(eVar.f10335e) && this.f10336f.equals(eVar.f10336f) && this.f10337g.equals(eVar.f10337g) && Objects.equals(this.f10338h, eVar.f10338h) && Objects.equals(this.f10339i, eVar.f10339i) && Objects.equals(this.f10340j, eVar.f10340j) && Objects.equals(this.f10341k, eVar.f10341k) && l().w() == eVar.l().w();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.f10340j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f10331a.equals(eVar.f10331a) && d(eVar);
        }
    }

    public List<c0> f() {
        return this.f10335e;
    }

    @Nullable
    public Proxy g() {
        return this.f10338h;
    }

    public g h() {
        return this.f10334d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f10331a.hashCode()) * 31) + this.f10332b.hashCode()) * 31) + this.f10334d.hashCode()) * 31) + this.f10335e.hashCode()) * 31) + this.f10336f.hashCode()) * 31) + this.f10337g.hashCode()) * 31) + Objects.hashCode(this.f10338h)) * 31) + Objects.hashCode(this.f10339i)) * 31) + Objects.hashCode(this.f10340j)) * 31) + Objects.hashCode(this.f10341k);
    }

    public ProxySelector i() {
        return this.f10337g;
    }

    public SocketFactory j() {
        return this.f10333c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.f10339i;
    }

    public y l() {
        return this.f10331a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f10331a.l());
        sb.append(":");
        sb.append(this.f10331a.w());
        if (this.f10338h != null) {
            sb.append(", proxy=");
            sb.append(this.f10338h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f10337g);
        }
        sb.append("}");
        return sb.toString();
    }
}
