package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.IOException;

/* compiled from: DefaultLoadErrorHandlingPolicy */
public class r implements t {

    /* renamed from: a  reason: collision with root package name */
    private final int f6980a;

    public r() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.t
    public long a(int i2, long j2, IOException iOException, int i3) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i4 = ((HttpDataSource.InvalidResponseCodeException) iOException).f6874b;
        if (i4 == 404 || i4 == 410) {
            return 60000;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.upstream.t
    public int b(int i2) {
        int i3 = this.f6980a;
        if (i3 == -1) {
            return i2 == 7 ? 6 : 3;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.t
    public long c(int i2, long j2, IOException iOException, int i3) {
        if (iOException instanceof ParserException) {
            return -9223372036854775807L;
        }
        return (long) Math.min((i3 - 1) * 1000, 5000);
    }

    public r(int i2) {
        this.f6980a = i2;
    }
}
