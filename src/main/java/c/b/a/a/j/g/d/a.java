package c.b.a.a.j.g.d;

import android.graphics.Point;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: MatrixManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Point f3138a = new Point(0, 0);

    /* renamed from: b  reason: collision with root package name */
    protected int f3139b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected b f3140c = b.FIT_CENTER;

    /* renamed from: d  reason: collision with root package name */
    protected Integer f3141d = null;

    /* renamed from: e  reason: collision with root package name */
    protected b f3142e = null;

    /* renamed from: f  reason: collision with root package name */
    protected WeakReference<View> f3143f = new WeakReference<>(null);

    /* access modifiers changed from: package-private */
    /* renamed from: c.b.a.a.j.g.d.a$a  reason: collision with other inner class name */
    /* compiled from: MatrixManager */
    public static /* synthetic */ class C0071a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3144a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                c.b.a.a.j.g.d.b[] r0 = c.b.a.a.j.g.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c.b.a.a.j.g.d.a.C0071a.f3144a = r0
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = c.b.a.a.j.g.d.a.C0071a.f3144a     // Catch:{ NoSuchFieldError -> 0x001d }
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = c.b.a.a.j.g.d.a.C0071a.f3144a     // Catch:{ NoSuchFieldError -> 0x0028 }
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = c.b.a.a.j.g.d.a.C0071a.f3144a     // Catch:{ NoSuchFieldError -> 0x0033 }
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = c.b.a.a.j.g.d.a.C0071a.f3144a     // Catch:{ NoSuchFieldError -> 0x003e }
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.FIT_XY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = c.b.a.a.j.g.d.a.C0071a.f3144a     // Catch:{ NoSuchFieldError -> 0x0049 }
                c.b.a.a.j.g.d.b r1 = c.b.a.a.j.g.d.b.NONE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.a.j.g.d.a.C0071a.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        l(view, ((float) this.f3138a.x) / ((float) view.getWidth()), ((float) this.f3138a.y) / ((float) view.getHeight()));
    }

    /* access modifiers changed from: protected */
    public void b(View view) {
        float width = ((float) view.getWidth()) / ((float) this.f3138a.x);
        float height = ((float) view.getHeight()) / ((float) this.f3138a.y);
        float max = Math.max(width, height);
        l(view, max / width, max / height);
    }

    /* access modifiers changed from: protected */
    public void c(View view) {
        if (this.f3138a.x > view.getWidth() || this.f3138a.y > view.getHeight()) {
            d(view);
        } else {
            a(view);
        }
    }

    /* access modifiers changed from: protected */
    public void d(View view) {
        float width = ((float) view.getWidth()) / ((float) this.f3138a.x);
        float height = ((float) view.getHeight()) / ((float) this.f3138a.y);
        float min = Math.min(width, height);
        l(view, min / width, min / height);
    }

    /* access modifiers changed from: protected */
    public void e(View view) {
        l(view, 1.0f, 1.0f);
    }

    /* access modifiers changed from: protected */
    public void f() {
        View view = this.f3143f.get();
        if (view != null) {
            Integer num = this.f3141d;
            if (num != null) {
                i(view, num.intValue());
                this.f3141d = null;
            }
            b bVar = this.f3142e;
            if (bVar != null) {
                j(view, bVar);
                this.f3142e = null;
            }
        }
        this.f3143f = new WeakReference<>(null);
    }

    public b g() {
        b bVar = this.f3142e;
        return bVar != null ? bVar : this.f3140c;
    }

    public boolean h() {
        Point point = this.f3138a;
        return point.x > 0 && point.y > 0;
    }

    public void i(View view, int i2) {
        if (!h()) {
            this.f3141d = Integer.valueOf(i2);
            this.f3143f = new WeakReference<>(view);
            return;
        }
        boolean z = false;
        boolean z2 = (i2 / 90) % 2 == 1;
        if ((this.f3139b / 90) % 2 == 1) {
            z = true;
        }
        if (z2 != z) {
            Point point = this.f3138a;
            int i3 = point.x;
            point.x = point.y;
            point.y = i3;
            j(view, this.f3140c);
        }
        this.f3139b = i2;
        view.setRotation((float) i2);
    }

    public boolean j(View view, b bVar) {
        if (!h()) {
            this.f3142e = bVar;
            this.f3143f = new WeakReference<>(view);
            return false;
        } else if (view.getHeight() == 0 || view.getWidth() == 0) {
            Log.d("MatrixManager", "Unable to apply scale with a view size of (" + view.getWidth() + ", " + view.getHeight() + ")");
            return false;
        } else {
            this.f3140c = bVar;
            switch (C0071a.f3144a[bVar.ordinal()]) {
                case 1:
                    a(view);
                    return true;
                case 2:
                    b(view);
                    return true;
                case 3:
                    c(view);
                    return true;
                case 4:
                    d(view);
                    return true;
                case 5:
                    e(view);
                    return true;
                case 6:
                    l(view, 1.0f, 1.0f);
                    return true;
                default:
                    return true;
            }
        }
    }

    public void k(int i2, int i3) {
        boolean z = true;
        if ((this.f3139b / 90) % 2 != 1) {
            z = false;
        }
        Point point = this.f3138a;
        point.x = z ? i3 : i2;
        if (!z) {
            i2 = i3;
        }
        point.y = i2;
        if (h()) {
            f();
        }
    }

    /* access modifiers changed from: protected */
    public void l(View view, float f2, float f3) {
        boolean z = true;
        if ((this.f3139b / 90) % 2 != 1) {
            z = false;
        }
        if (z) {
            float height = (f3 * ((float) view.getHeight())) / ((float) view.getWidth());
            f3 = (f2 * ((float) view.getWidth())) / ((float) view.getHeight());
            f2 = height;
        }
        view.setScaleX(f2);
        view.setScaleY(f3);
    }
}
