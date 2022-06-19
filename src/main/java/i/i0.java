package i;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Route */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    final e f10430a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f10431b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f10432c;

    public i0(e eVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(eVar, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f10430a = eVar;
        this.f10431b = proxy;
        this.f10432c = inetSocketAddress;
    }

    public e a() {
        return this.f10430a;
    }

    public Proxy b() {
        return this.f10431b;
    }

    public boolean c() {
        return this.f10430a.f10339i != null && this.f10431b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f10432c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            return i0Var.f10430a.equals(this.f10430a) && i0Var.f10431b.equals(this.f10431b) && i0Var.f10432c.equals(this.f10432c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f10430a.hashCode()) * 31) + this.f10431b.hashCode()) * 31) + this.f10432c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f10432c + "}";
    }
}
