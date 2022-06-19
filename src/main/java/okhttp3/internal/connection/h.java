package okhttp3.internal.connection;

import i.i0;
import java.util.LinkedHashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: RouteDatabase */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i0> f10846a = new LinkedHashSet();

    h() {
    }

    public synchronized void a(i0 i0Var) {
        this.f10846a.remove(i0Var);
    }

    public synchronized void b(i0 i0Var) {
        this.f10846a.add(i0Var);
    }

    public synchronized boolean c(i0 i0Var) {
        return this.f10846a.contains(i0Var);
    }
}
