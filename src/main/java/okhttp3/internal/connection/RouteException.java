package okhttp3.internal.connection;

import i.k0.e;
import java.io.IOException;

public final class RouteException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private IOException f10797b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f10798c;

    RouteException(IOException iOException) {
        super(iOException);
        this.f10797b = iOException;
        this.f10798c = iOException;
    }

    /* access modifiers changed from: package-private */
    public void a(IOException iOException) {
        e.a(this.f10797b, iOException);
        this.f10798c = iOException;
    }

    public IOException c() {
        return this.f10797b;
    }

    public IOException d() {
        return this.f10798c;
    }
}
