package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final a f10870b;

    public StreamResetException(a aVar) {
        super("stream was reset: " + aVar);
        this.f10870b = aVar;
    }
}
