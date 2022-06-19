package i;

import i.k0.e;
import j.d;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: RequestBody */
public abstract class f0 {

    /* access modifiers changed from: package-private */
    /* compiled from: RequestBody */
    public class a extends f0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a0 f10353a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10354b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f10355c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10356d;

        a(a0 a0Var, int i2, byte[] bArr, int i3) {
            this.f10354b = i2;
            this.f10355c = bArr;
            this.f10356d = i3;
        }

        @Override // i.f0
        public long a() {
            return (long) this.f10354b;
        }

        @Override // i.f0
        @Nullable
        public a0 b() {
            return this.f10353a;
        }

        @Override // i.f0
        public void g(d dVar) {
            dVar.d(this.f10355c, this.f10356d, this.f10354b);
        }
    }

    public static f0 c(@Nullable a0 a0Var, byte[] bArr) {
        return d(a0Var, bArr, 0, bArr.length);
    }

    public static f0 d(@Nullable a0 a0Var, byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "content == null");
        e.c((long) bArr.length, (long) i2, (long) i3);
        return new a(a0Var, i3, bArr, i2);
    }

    public abstract long a();

    @Nullable
    public abstract a0 b();

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract void g(d dVar);
}
