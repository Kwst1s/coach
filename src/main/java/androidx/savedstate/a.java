package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;

/* compiled from: SavedStateRegistryController */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f1848a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f1849b = new SavedStateRegistry();

    private a(b bVar) {
        this.f1848a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f1849b;
    }

    public void c(Bundle bundle) {
        e c2 = this.f1848a.c();
        if (c2.b() == e.b.INITIALIZED) {
            c2.a(new Recreator(this.f1848a));
            this.f1849b.b(c2, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f1849b.c(bundle);
    }
}
