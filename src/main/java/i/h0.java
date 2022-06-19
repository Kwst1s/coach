package i;

import j.c;
import j.e;
import java.io.Closeable;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: ResponseBody */
public abstract class h0 implements Closeable {

    /* access modifiers changed from: package-private */
    /* compiled from: ResponseBody */
    public class a extends h0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f10409b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f10410c;

        a(a0 a0Var, long j2, e eVar) {
            this.f10409b = j2;
            this.f10410c = eVar;
        }

        @Override // i.h0
        public e G() {
            return this.f10410c;
        }

        @Override // i.h0
        public long l() {
            return this.f10409b;
        }
    }

    public static h0 E(@Nullable a0 a0Var, long j2, e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new a(a0Var, j2, eVar);
    }

    public static h0 F(@Nullable a0 a0Var, byte[] bArr) {
        c cVar = new c();
        cVar.X(bArr);
        return E(a0Var, (long) bArr.length, cVar);
    }

    public abstract e G();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i.k0.e.d(G());
    }

    public abstract long l();
}
