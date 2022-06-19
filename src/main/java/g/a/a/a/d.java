package g.a.a.a;

import android.content.Context;
import g.a.a.a.a.f.c;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.j.r;
import kotlin.k.b;
import kotlin.m.b.f;

/* compiled from: MBurger.kt */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9822a = new a(null);

    /* compiled from: MBurger.kt */
    public static final class a {

        /* renamed from: g.a.a.a.d$a$a  reason: collision with other inner class name */
        /* compiled from: Comparisons.kt */
        public static final class C0226a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return b.a(Integer.valueOf(t.a()), Integer.valueOf(t2.a()));
            }
        }

        private a() {
        }

        public final void a(Context context) {
            f.f(context, "context");
            ArrayList<g.a.a.a.c.a> b2 = g.a.a.a.c.b.f9817c.a().b();
            if (b2 != null) {
                for (g.a.a.a.c.a aVar : r.k(b2, new C0226a())) {
                    aVar.b(context);
                }
            }
        }

        public final void b(Context context, String str, boolean z, ArrayList<g.a.a.a.c.a> arrayList, boolean z2) {
            f.f(context, "context");
            f.f(str, "api_key");
            c.a aVar = c.f9785f;
            aVar.e(str);
            aVar.g(z);
            aVar.f(z2);
            g.a.a.a.c.b.f9817c.a().c(arrayList);
            if (z2) {
                a(context);
            }
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }
}
