package b.r;

import android.os.IBinder;

/* access modifiers changed from: package-private */
/* compiled from: WindowIdApi14 */
public class k0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f2902a;

    k0(IBinder iBinder) {
        this.f2902a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).f2902a.equals(this.f2902a);
    }

    public int hashCode() {
        return this.f2902a.hashCode();
    }
}
