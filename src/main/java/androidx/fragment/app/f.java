package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: FragmentContainer */
public abstract class f {
    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.W(context, str, bundle);
    }

    public abstract View b(int i2);

    public abstract boolean d();
}
