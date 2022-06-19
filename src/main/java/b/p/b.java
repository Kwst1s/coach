package b.p;

import android.app.Application;
import android.content.Context;

/* compiled from: MultiDexApplication */
public class b extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.l(this);
    }
}
