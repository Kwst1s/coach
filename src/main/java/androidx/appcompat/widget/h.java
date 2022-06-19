package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.g0;
import b.a.c;
import b.a.e;

/* compiled from: AppCompatDrawableManager */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private static final PorterDuff.Mode f631b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static h f632c;

    /* renamed from: a  reason: collision with root package name */
    private g0 f633a;

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDrawableManager */
    public class a implements g0.e {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f634a = {e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f635b = {e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f636c = {e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl_dark, e.abc_text_select_handle_middle_mtrl_dark, e.abc_text_select_handle_right_mtrl_dark, e.abc_text_select_handle_left_mtrl_light, e.abc_text_select_handle_middle_mtrl_light, e.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f637d = {e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f638e = {e.abc_tab_indicator_material, e.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f639f = {e.abc_btn_check_material, e.abc_btn_radio_material, e.abc_btn_check_material_anim, e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int c2 = l0.c(context, b.a.a.v);
            int b2 = l0.b(context, b.a.a.colorButtonNormal);
            return new ColorStateList(new int[][]{l0.f683b, l0.f685d, l0.f684c, l0.f687f}, new int[]{b2, b.h.e.a.b(c2, i2), b.h.e.a.b(c2, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, l0.c(context, b.a.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, l0.c(context, b.a.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i2 = b.a.a.colorSwitchThumbNormal;
            ColorStateList e2 = l0.e(context, i2);
            if (e2 == null || !e2.isStateful()) {
                iArr[0] = l0.f683b;
                iArr2[0] = l0.b(context, i2);
                iArr[1] = l0.f686e;
                iArr2[1] = l0.c(context, b.a.a.u);
                iArr[2] = l0.f687f;
                iArr2[2] = l0.c(context, i2);
            } else {
                iArr[0] = l0.f683b;
                iArr2[0] = e2.getColorForState(iArr[0], 0);
                iArr[1] = l0.f686e;
                iArr2[1] = l0.c(context, b.a.a.u);
                iArr[2] = l0.f687f;
                iArr2[2] = e2.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (x.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = h.f631b;
            }
            drawable.setColorFilter(h.e(i2, mode));
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.g0.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.h.a()
                int[] r1 = r6.f634a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = b.a.a.colorControlNormal
            L_0x0014:
                r8 = -1
            L_0x0015:
                r1 = 1
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f636c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = b.a.a.u
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f637d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = b.a.e.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = b.a.e.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = -1
                r1 = 0
                r2 = 0
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.x.a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.l0.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.h.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.g0.e
        public PorterDuff.Mode b(int i2) {
            if (i2 == e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public Drawable c(g0 g0Var, Context context, int i2) {
            if (i2 != e.abc_cab_background_top_material) {
                return null;
            }
            return new LayerDrawable(new Drawable[]{g0Var.j(context, e.abc_cab_background_internal_bg), g0Var.j(context, e.abc_cab_background_top_mtrl_alpha)});
        }

        @Override // androidx.appcompat.widget.g0.e
        public ColorStateList d(Context context, int i2) {
            if (i2 == e.abc_edit_text_material) {
                return b.a.k.a.a.c(context, c.abc_tint_edittext);
            }
            if (i2 == e.abc_switch_track_mtrl_alpha) {
                return b.a.k.a.a.c(context, c.abc_tint_switch_track);
            }
            if (i2 == e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i2 == e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i2 == e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i2 == e.abc_btn_colored_material) {
                return i(context);
            }
            if (i2 == e.abc_spinner_mtrl_am_alpha || i2 == e.abc_spinner_textfield_background_material) {
                return b.a.k.a.a.c(context, c.abc_tint_spinner);
            }
            if (f(this.f635b, i2)) {
                return l0.e(context, b.a.a.colorControlNormal);
            }
            if (f(this.f638e, i2)) {
                return b.a.k.a.a.c(context, c.abc_tint_default);
            }
            if (f(this.f639f, i2)) {
                return b.a.k.a.a.c(context, c.abc_tint_btn_checkable);
            }
            if (i2 == e.abc_seekbar_thumb_material) {
                return b.a.k.a.a.c(context, c.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public boolean e(Context context, int i2, Drawable drawable) {
            if (i2 == e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i3 = b.a.a.colorControlNormal;
                l(findDrawableByLayerId, l0.c(context, i3), h.f631b);
                l(layerDrawable.findDrawableByLayerId(16908303), l0.c(context, i3), h.f631b);
                l(layerDrawable.findDrawableByLayerId(16908301), l0.c(context, b.a.a.u), h.f631b);
                return true;
            } else if (i2 != e.abc_ratingbar_material && i2 != e.abc_ratingbar_indicator_material && i2 != e.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                l(layerDrawable2.findDrawableByLayerId(16908288), l0.b(context, b.a.a.colorControlNormal), h.f631b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i4 = b.a.a.u;
                l(findDrawableByLayerId2, l0.c(context, i4), h.f631b);
                l(layerDrawable2.findDrawableByLayerId(16908301), l0.c(context, i4), h.f631b);
                return true;
            }
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f632c == null) {
                h();
            }
            hVar = f632c;
        }
        return hVar;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (h.class) {
            l = g0.l(i2, mode);
        }
        return l;
    }

    public static synchronized void h() {
        synchronized (h.class) {
            if (f632c == null) {
                h hVar = new h();
                f632c = hVar;
                hVar.f633a = g0.h();
                f632c.f633a.u(new a());
            }
        }
    }

    static void i(Drawable drawable, o0 o0Var, int[] iArr) {
        g0.w(drawable, o0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f633a.j(context, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i2, boolean z) {
        return this.f633a.k(context, i2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i2) {
        return this.f633a.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f633a.s(context);
    }
}
