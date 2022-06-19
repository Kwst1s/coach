package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class n implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Intent> f1097b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Context f1098c;

    /* compiled from: TaskStackBuilder */
    public interface a {
        Intent r();
    }

    private n(Context context) {
        this.f1098c = context;
    }

    public static n d(Context context) {
        return new n(context);
    }

    public n a(Intent intent) {
        this.f1097b.add(intent);
        return this;
    }

    public n b(Activity activity) {
        Intent r = activity instanceof a ? ((a) activity).r() : null;
        if (r == null) {
            r = f.a(activity);
        }
        if (r != null) {
            ComponentName component = r.getComponent();
            if (component == null) {
                component = r.resolveActivity(this.f1098c.getPackageManager());
            }
            c(component);
            a(r);
        }
        return this;
    }

    public n c(ComponentName componentName) {
        int size = this.f1097b.size();
        try {
            Intent b2 = f.b(this.f1098c, componentName);
            while (b2 != null) {
                this.f1097b.add(size, b2);
                b2 = f.b(this.f1098c, b2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (!this.f1097b.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1097b;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!b.h.d.a.g(this.f1098c, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f1098c.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1097b.iterator();
    }
}
