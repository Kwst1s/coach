package i;

import i.k0.e;
import i.k0.h.f;
import i.x;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Request */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    final y f10342a;

    /* renamed from: b  reason: collision with root package name */
    final String f10343b;

    /* renamed from: c  reason: collision with root package name */
    final x f10344c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final f0 f10345d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f10346e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile i f10347f;

    e0(a aVar) {
        this.f10342a = aVar.f10348a;
        this.f10343b = aVar.f10349b;
        this.f10344c = aVar.f10350c.d();
        this.f10345d = aVar.f10351d;
        this.f10346e = e.s(aVar.f10352e);
    }

    @Nullable
    public f0 a() {
        return this.f10345d;
    }

    public i b() {
        i iVar = this.f10347f;
        if (iVar != null) {
            return iVar;
        }
        i k2 = i.k(this.f10344c);
        this.f10347f = k2;
        return k2;
    }

    @Nullable
    public String c(String str) {
        return this.f10344c.c(str);
    }

    public List<String> d(String str) {
        return this.f10344c.j(str);
    }

    public x e() {
        return this.f10344c;
    }

    public boolean f() {
        return this.f10342a.m();
    }

    public String g() {
        return this.f10343b;
    }

    public a h() {
        return new a(this);
    }

    public y i() {
        return this.f10342a;
    }

    public String toString() {
        return "Request{method=" + this.f10343b + ", url=" + this.f10342a + ", tags=" + this.f10346e + '}';
    }

    /* compiled from: Request */
    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        y f10348a;

        /* renamed from: b  reason: collision with root package name */
        String f10349b;

        /* renamed from: c  reason: collision with root package name */
        x.a f10350c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        f0 f10351d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f10352e;

        public a() {
            this.f10352e = Collections.emptyMap();
            this.f10349b = "GET";
            this.f10350c = new x.a();
        }

        public e0 a() {
            if (this.f10348a != null) {
                return new e0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(i iVar) {
            String iVar2 = iVar.toString();
            if (iVar2.isEmpty()) {
                f("Cache-Control");
                return this;
            }
            c("Cache-Control", iVar2);
            return this;
        }

        public a c(String str, String str2) {
            this.f10350c.g(str, str2);
            return this;
        }

        public a d(x xVar) {
            this.f10350c = xVar.f();
            return this;
        }

        public a e(String str, @Nullable f0 f0Var) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (f0Var != null && !f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (f0Var != null || !f.e(str)) {
                this.f10349b = str;
                this.f10351d = f0Var;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a f(String str) {
            this.f10350c.f(str);
            return this;
        }

        public a g(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            h(y.k(str));
            return this;
        }

        public a h(y yVar) {
            Objects.requireNonNull(yVar, "url == null");
            this.f10348a = yVar;
            return this;
        }

        a(e0 e0Var) {
            Map<Class<?>, Object> map;
            this.f10352e = Collections.emptyMap();
            this.f10348a = e0Var.f10342a;
            this.f10349b = e0Var.f10343b;
            this.f10351d = e0Var.f10345d;
            if (e0Var.f10346e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(e0Var.f10346e);
            }
            this.f10352e = map;
            this.f10350c = e0Var.f10344c.f();
        }
    }
}
