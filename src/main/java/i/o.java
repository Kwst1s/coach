package i;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.g;

/* compiled from: ConnectionPool */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final g f10593a;

    public o() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public o(int i2, long j2, TimeUnit timeUnit) {
        this.f10593a = new g(i2, j2, timeUnit);
    }
}
