package i.k0;

import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10441a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10442b;

    public /* synthetic */ b(String str, boolean z) {
        this.f10441a = str;
        this.f10442b = z;
    }

    public final Thread newThread(Runnable runnable) {
        return e.y(this.f10441a, this.f10442b, runnable);
    }
}
