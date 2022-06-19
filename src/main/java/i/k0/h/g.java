package i.k0.h;

import i.e0;
import i.g0;
import i.z;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.j;

/* compiled from: RealInterceptorChain */
public final class g implements z.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<z> f10506a;

    /* renamed from: b  reason: collision with root package name */
    private final j f10507b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final d f10508c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10509d;

    /* renamed from: e  reason: collision with root package name */
    private final e0 f10510e;

    /* renamed from: f  reason: collision with root package name */
    private final i.j f10511f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10512g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10513h;

    /* renamed from: i  reason: collision with root package name */
    private final int f10514i;

    /* renamed from: j  reason: collision with root package name */
    private int f10515j;

    public g(List<z> list, j jVar, @Nullable d dVar, int i2, e0 e0Var, i.j jVar2, int i3, int i4, int i5) {
        this.f10506a = list;
        this.f10507b = jVar;
        this.f10508c = dVar;
        this.f10509d = i2;
        this.f10510e = e0Var;
        this.f10511f = jVar2;
        this.f10512g = i3;
        this.f10513h = i4;
        this.f10514i = i5;
    }

    @Override // i.z.a
    public int a() {
        return this.f10512g;
    }

    @Override // i.z.a
    public int b() {
        return this.f10513h;
    }

    @Override // i.z.a
    public int c() {
        return this.f10514i;
    }

    @Override // i.z.a
    public g0 d(e0 e0Var) {
        return g(e0Var, this.f10507b, this.f10508c);
    }

    @Override // i.z.a
    public e0 e() {
        return this.f10510e;
    }

    public d f() {
        d dVar = this.f10508c;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException();
    }

    public g0 g(e0 e0Var, j jVar, @Nullable d dVar) {
        if (this.f10509d < this.f10506a.size()) {
            this.f10515j++;
            d dVar2 = this.f10508c;
            if (dVar2 != null && !dVar2.c().u(e0Var.i())) {
                throw new IllegalStateException("network interceptor " + this.f10506a.get(this.f10509d - 1) + " must retain the same host and port");
            } else if (this.f10508c == null || this.f10515j <= 1) {
                List<z> list = this.f10506a;
                int i2 = this.f10509d;
                g gVar = new g(list, jVar, dVar, i2 + 1, e0Var, this.f10511f, this.f10512g, this.f10513h, this.f10514i);
                z zVar = list.get(i2);
                g0 a2 = zVar.a(gVar);
                if (dVar != null && this.f10509d + 1 < this.f10506a.size() && gVar.f10515j != 1) {
                    throw new IllegalStateException("network interceptor " + zVar + " must call proceed() exactly once");
                } else if (a2 == null) {
                    throw new NullPointerException("interceptor " + zVar + " returned null");
                } else if (a2.l() != null) {
                    return a2;
                } else {
                    throw new IllegalStateException("interceptor " + zVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f10506a.get(this.f10509d - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public j h() {
        return this.f10507b;
    }
}
