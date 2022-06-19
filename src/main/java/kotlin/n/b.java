package kotlin.n;

import java.util.NoSuchElementException;
import kotlin.j.u;

/* compiled from: ProgressionIterators.kt */
public final class b extends u {

    /* renamed from: b  reason: collision with root package name */
    private final int f10791b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10792c;

    /* renamed from: d  reason: collision with root package name */
    private int f10793d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10794e;

    public b(int i2, int i3, int i4) {
        this.f10794e = i4;
        this.f10791b = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f10792c = z;
        this.f10793d = !z ? i3 : i2;
    }

    @Override // kotlin.j.u
    public int b() {
        int i2 = this.f10793d;
        if (i2 != this.f10791b) {
            this.f10793d = this.f10794e + i2;
        } else if (this.f10792c) {
            this.f10792c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    public boolean hasNext() {
        return this.f10792c;
    }
}
