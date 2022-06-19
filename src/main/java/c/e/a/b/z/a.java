package c.e.a.b.z;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback */
public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f3449a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0083a f3450b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3451c;

    /* renamed from: c.e.a.b.z.a$a  reason: collision with other inner class name */
    /* compiled from: CancelableFontCallback */
    public interface AbstractC0083a {
        void a(Typeface typeface);
    }

    public a(AbstractC0083a aVar, Typeface typeface) {
        this.f3449a = typeface;
        this.f3450b = aVar;
    }

    private void d(Typeface typeface) {
        if (!this.f3451c) {
            this.f3450b.a(typeface);
        }
    }

    @Override // c.e.a.b.z.f
    public void a(int i2) {
        d(this.f3449a);
    }

    @Override // c.e.a.b.z.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f3451c = true;
    }
}
