package b.r;

import android.view.View;
import android.view.WindowId;

/* access modifiers changed from: package-private */
/* compiled from: WindowIdApi18 */
public class l0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f2905a;

    l0(View view) {
        this.f2905a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof l0) && ((l0) obj).f2905a.equals(this.f2905a);
    }

    public int hashCode() {
        return this.f2905a.hashCode();
    }
}
