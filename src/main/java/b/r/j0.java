package b.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.r.a;
import b.r.m;

/* compiled from: Visibility */
public abstract class j0 extends m {
    private static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    private int K = 3;

    /* access modifiers changed from: package-private */
    /* compiled from: Visibility */
    public class a extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2885b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2886c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f2887d;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f2885b = viewGroup;
            this.f2886c = view;
            this.f2887d = view2;
        }

        @Override // b.r.m.f, b.r.n
        public void c(m mVar) {
            x.a(this.f2885b).c(this.f2886c);
        }

        @Override // b.r.m.f, b.r.n
        public void d(m mVar) {
            if (this.f2886c.getParent() == null) {
                x.a(this.f2885b).a(this.f2886c);
            } else {
                j0.this.f();
            }
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            this.f2887d.setTag(j.save_overlay_view, null);
            x.a(this.f2885b).c(this.f2886c);
            mVar.Q(this);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Visibility */
    public static class b extends AnimatorListenerAdapter implements m.f, a.AbstractC0060a {

        /* renamed from: b  reason: collision with root package name */
        private final View f2889b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2890c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f2891d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2892e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2893f;

        /* renamed from: g  reason: collision with root package name */
        boolean f2894g = false;

        b(View view, int i2, boolean z) {
            this.f2889b = view;
            this.f2890c = i2;
            this.f2891d = (ViewGroup) view.getParent();
            this.f2892e = z;
            g(true);
        }

        private void f() {
            if (!this.f2894g) {
                c0.h(this.f2889b, this.f2890c);
                ViewGroup viewGroup = this.f2891d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (this.f2892e && this.f2893f != z && (viewGroup = this.f2891d) != null) {
                this.f2893f = z;
                x.c(viewGroup, z);
            }
        }

        @Override // b.r.m.f
        public void a(m mVar) {
        }

        @Override // b.r.m.f
        public void b(m mVar) {
        }

        @Override // b.r.m.f
        public void c(m mVar) {
            g(false);
        }

        @Override // b.r.m.f
        public void d(m mVar) {
            g(true);
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            f();
            mVar.Q(this);
        }

        public void onAnimationCancel(Animator animator) {
            this.f2894g = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // b.r.a.AbstractC0060a
        public void onAnimationPause(Animator animator) {
            if (!this.f2894g) {
                c0.h(this.f2889b, this.f2890c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        @Override // b.r.a.AbstractC0060a
        public void onAnimationResume(Animator animator) {
            if (!this.f2894g) {
                c0.h(this.f2889b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Visibility */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f2895a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2896b;

        /* renamed from: c  reason: collision with root package name */
        int f2897c;

        /* renamed from: d  reason: collision with root package name */
        int f2898d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f2899e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f2900f;

        c() {
        }
    }

    private void d0(s sVar) {
        sVar.f2936a.put("android:visibility:visibility", Integer.valueOf(sVar.f2937b.getVisibility()));
        sVar.f2936a.put("android:visibility:parent", sVar.f2937b.getParent());
        int[] iArr = new int[2];
        sVar.f2937b.getLocationOnScreen(iArr);
        sVar.f2936a.put("android:visibility:screenLocation", iArr);
    }

    private c e0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f2895a = false;
        cVar.f2896b = false;
        if (sVar == null || !sVar.f2936a.containsKey("android:visibility:visibility")) {
            cVar.f2897c = -1;
            cVar.f2899e = null;
        } else {
            cVar.f2897c = ((Integer) sVar.f2936a.get("android:visibility:visibility")).intValue();
            cVar.f2899e = (ViewGroup) sVar.f2936a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f2936a.containsKey("android:visibility:visibility")) {
            cVar.f2898d = -1;
            cVar.f2900f = null;
        } else {
            cVar.f2898d = ((Integer) sVar2.f2936a.get("android:visibility:visibility")).intValue();
            cVar.f2900f = (ViewGroup) sVar2.f2936a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i2 = cVar.f2897c;
            int i3 = cVar.f2898d;
            if (i2 == i3 && cVar.f2899e == cVar.f2900f) {
                return cVar;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f2896b = false;
                    cVar.f2895a = true;
                } else if (i3 == 0) {
                    cVar.f2896b = true;
                    cVar.f2895a = true;
                }
            } else if (cVar.f2900f == null) {
                cVar.f2896b = false;
                cVar.f2895a = true;
            } else if (cVar.f2899e == null) {
                cVar.f2896b = true;
                cVar.f2895a = true;
            }
        } else if (sVar == null && cVar.f2898d == 0) {
            cVar.f2896b = true;
            cVar.f2895a = true;
        } else if (sVar2 == null && cVar.f2897c == 0) {
            cVar.f2896b = false;
            cVar.f2895a = true;
        }
        return cVar;
    }

    @Override // b.r.m
    public String[] E() {
        return L;
    }

    @Override // b.r.m
    public boolean G(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f2936a.containsKey("android:visibility:visibility") != sVar.f2936a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c e0 = e0(sVar, sVar2);
        if (!e0.f2895a) {
            return false;
        }
        if (e0.f2897c == 0 || e0.f2898d == 0) {
            return true;
        }
        return false;
    }

    public abstract Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // b.r.m
    public void g(s sVar) {
        d0(sVar);
    }

    public Animator g0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        if ((this.K & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f2937b.getParent();
            if (e0(u(view, false), F(view, false)).f2895a) {
                return null;
            }
        }
        return f0(viewGroup, sVar2.f2937b, sVar, sVar2);
    }

    public abstract Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r17.w != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator i0(android.view.ViewGroup r18, b.r.s r19, int r20, b.r.s r21, int r22) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.j0.i0(android.view.ViewGroup, b.r.s, int, b.r.s, int):android.animation.Animator");
    }

    @Override // b.r.m
    public void j(s sVar) {
        d0(sVar);
    }

    public void j0(int i2) {
        if ((i2 & -4) == 0) {
            this.K = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // b.r.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        c e0 = e0(sVar, sVar2);
        if (!e0.f2895a) {
            return null;
        }
        if (e0.f2899e == null && e0.f2900f == null) {
            return null;
        }
        if (e0.f2896b) {
            return g0(viewGroup, sVar, e0.f2897c, sVar2, e0.f2898d);
        }
        return i0(viewGroup, sVar, e0.f2897c, sVar2, e0.f2898d);
    }
}
