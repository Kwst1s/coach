package b.h.i;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f2573a = new C0045e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f2574b = new C0045e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final d f2575c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f2576d;

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f2577b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f2578a;

        private a(boolean z) {
            this.f2578a = z;
        }

        @Override // b.h.i.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f2578a) {
                        return 1;
                    }
                } else if (this.f2578a) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f2578a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f2579a = new b();

        private b() {
        }

        @Override // b.h.i.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = e.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: TextDirectionHeuristicsCompat */
    public interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f2580a;

        d(c cVar) {
            this.f2580a = cVar;
        }

        private boolean c(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f2580a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return b();
            }
            return false;
        }

        @Override // b.h.i.d
        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            } else if (this.f2580a == null) {
                return b();
            } else {
                return c(charSequence, i2, i3);
            }
        }

        /* access modifiers changed from: protected */
        public abstract boolean b();
    }

    /* renamed from: b.h.i.e$e  reason: collision with other inner class name */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0045e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2581b;

        C0045e(c cVar, boolean z) {
            super(cVar);
            this.f2581b = z;
        }

        /* access modifiers changed from: protected */
        @Override // b.h.i.e.d
        public boolean b() {
            return this.f2581b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f2582b = new f();

        f() {
            super(null);
        }

        /* access modifiers changed from: protected */
        @Override // b.h.i.e.d
        public boolean b() {
            return f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f2579a;
        f2575c = new C0045e(bVar, false);
        f2576d = new C0045e(bVar, true);
        a aVar = a.f2577b;
        f fVar = f.f2582b;
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
