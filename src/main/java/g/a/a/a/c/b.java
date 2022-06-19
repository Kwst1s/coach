package g.a.a.a.c;

import java.util.ArrayList;
import kotlin.e;
import kotlin.m.b.d;
import kotlin.m.b.g;

/* compiled from: PluginsSingleton.kt */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.c f9816b = e.a(a.f9819b);

    /* renamed from: c  reason: collision with root package name */
    public static final C0225b f9817c = new C0225b(null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f9818a;

    /* compiled from: PluginsSingleton.kt */
    static final class a extends g implements kotlin.m.a.a<b> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f9819b = new a();

        a() {
            super(0);
        }

        /* renamed from: c */
        public final b a() {
            return c.f9821b.a();
        }
    }

    /* renamed from: g.a.a.a.c.b$b  reason: collision with other inner class name */
    /* compiled from: PluginsSingleton.kt */
    public static final class C0225b {
        private C0225b() {
        }

        public final b a() {
            kotlin.c cVar = b.f9816b;
            C0225b bVar = b.f9817c;
            return (b) cVar.getValue();
        }

        public /* synthetic */ C0225b(d dVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: PluginsSingleton.kt */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private static final b f9820a = new b(null);

        /* renamed from: b  reason: collision with root package name */
        public static final c f9821b = new c();

        private c() {
        }

        public final b a() {
            return f9820a;
        }
    }

    private b() {
    }

    public final ArrayList<a> b() {
        return this.f9818a;
    }

    public final void c(ArrayList<a> arrayList) {
        this.f9818a = arrayList;
    }

    public /* synthetic */ b(d dVar) {
        this();
    }
}
