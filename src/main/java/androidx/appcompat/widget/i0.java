package androidx.appcompat.widget;

/* access modifiers changed from: package-private */
/* compiled from: RtlSpacingHelper */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private int f641a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f642b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f643c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f644d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f645e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f646f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f647g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f648h = false;

    i0() {
    }

    public int a() {
        return this.f647g ? this.f641a : this.f642b;
    }

    public int b() {
        return this.f641a;
    }

    public int c() {
        return this.f642b;
    }

    public int d() {
        return this.f647g ? this.f642b : this.f641a;
    }

    public void e(int i2, int i3) {
        this.f648h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f645e = i2;
            this.f641a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f646f = i3;
            this.f642b = i3;
        }
    }

    public void f(boolean z) {
        if (z != this.f647g) {
            this.f647g = z;
            if (!this.f648h) {
                this.f641a = this.f645e;
                this.f642b = this.f646f;
            } else if (z) {
                int i2 = this.f644d;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f645e;
                }
                this.f641a = i2;
                int i3 = this.f643c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f646f;
                }
                this.f642b = i3;
            } else {
                int i4 = this.f643c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f645e;
                }
                this.f641a = i4;
                int i5 = this.f644d;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.f646f;
                }
                this.f642b = i5;
            }
        }
    }

    public void g(int i2, int i3) {
        this.f643c = i2;
        this.f644d = i3;
        this.f648h = true;
        if (this.f647g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f641a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f642b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f641a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f642b = i3;
        }
    }
}
