package okhttp3.internal.connection;

import i.e;
import i.i0;
import i.j;
import i.v;
import i.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: RouteSelector */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final e f10847a;

    /* renamed from: b  reason: collision with root package name */
    private final h f10848b;

    /* renamed from: c  reason: collision with root package name */
    private final j f10849c;

    /* renamed from: d  reason: collision with root package name */
    private final v f10850d;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f10851e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private int f10852f;

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f10853g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<i0> f10854h = new ArrayList();

    /* compiled from: RouteSelector */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<i0> f10855a;

        /* renamed from: b  reason: collision with root package name */
        private int f10856b = 0;

        a(List<i0> list) {
            this.f10855a = list;
        }

        public List<i0> a() {
            return new ArrayList(this.f10855a);
        }

        public boolean b() {
            return this.f10856b < this.f10855a.size();
        }

        public i0 c() {
            if (b()) {
                List<i0> list = this.f10855a;
                int i2 = this.f10856b;
                this.f10856b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    i(e eVar, h hVar, j jVar, v vVar) {
        this.f10847a = eVar;
        this.f10848b = hVar;
        this.f10849c = jVar;
        this.f10850d = vVar;
        g(eVar.l(), eVar.g());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean c() {
        return this.f10852f < this.f10851e.size();
    }

    private Proxy e() {
        if (c()) {
            List<Proxy> list = this.f10851e;
            int i2 = this.f10852f;
            this.f10852f = i2 + 1;
            Proxy proxy = list.get(i2);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f10847a.l().l() + "; exhausted proxy configurations: " + this.f10851e);
    }

    private void f(Proxy proxy) {
        String str;
        int i2;
        this.f10853g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f10847a.l().l();
            i2 = this.f10847a.l().w();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f10853g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            this.f10850d.j(this.f10849c, str);
            List<InetAddress> a2 = this.f10847a.c().a(str);
            if (!a2.isEmpty()) {
                this.f10850d.i(this.f10849c, str, a2);
                int size = a2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f10853g.add(new InetSocketAddress(a2.get(i3), i2));
                }
                return;
            }
            throw new UnknownHostException(this.f10847a.c() + " returned no addresses for " + str);
        }
    }

    private void g(y yVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f10851e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f10847a.i().select(yVar.C());
            if (select == null || select.isEmpty()) {
                list = i.k0.e.r(Proxy.NO_PROXY);
            } else {
                list = i.k0.e.q(select);
            }
            this.f10851e = list;
        }
        this.f10852f = 0;
    }

    public boolean b() {
        return c() || !this.f10854h.isEmpty();
    }

    public a d() {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy e2 = e();
                int size = this.f10853g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i0 i0Var = new i0(this.f10847a, e2, this.f10853g.get(i2));
                    if (this.f10848b.c(i0Var)) {
                        this.f10854h.add(i0Var);
                    } else {
                        arrayList.add(i0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f10854h);
                this.f10854h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
