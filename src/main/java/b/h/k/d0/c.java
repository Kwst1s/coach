package b.h.k.d0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import b.h.k.d0.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static int f2636d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f2637a;

    /* renamed from: b  reason: collision with root package name */
    public int f2638b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f2639c = -1;

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final a f2640e = new a(1, null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f2641f = new a(2, null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f2642g = new a(16, null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f2643h = new a(4096, null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f2644i = new a(8192, null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f2645j = new a(262144, null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f2646k = new a(524288, null);
        public static final a l = new a(1048576, null);
        public static final a m;
        public static final a n;

        /* renamed from: a  reason: collision with root package name */
        final Object f2647a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2648b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends f.a> f2649c;

        /* renamed from: d  reason: collision with root package name */
        protected final f f2650d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            new a(4, null);
            new a(8, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, (CharSequence) null, f.b.class);
            new a(512, (CharSequence) null, f.b.class);
            new a(1024, (CharSequence) null, f.c.class);
            new a(2048, (CharSequence) null, f.c.class);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, (CharSequence) null, f.g.class);
            new a(2097152, (CharSequence) null, f.h.class);
            int i2 = Build.VERSION.SDK_INT;
            new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, f.e.class);
            m = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            n = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            new a(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, f.C0049f.class);
            new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, f.d.class);
            new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            if (i2 >= 30) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            new a(accessibilityAction, 16908372, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a(null, this.f2648b, charSequence, fVar, this.f2649c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2647a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2647a).getLabel();
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                b.h.k.d0.f r0 = r4.f2650d
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends b.h.k.d0.f$a> r2 = r4.f2649c
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                b.h.k.d0.f$a r1 = (b.h.k.d0.f.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends b.h.k.d0.f$a> r1 = r4.f2649c
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                b.h.k.d0.f r6 = r4.f2650d
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.h.k.d0.c.a.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f2647a;
            if (obj2 == null) {
                if (aVar.f2647a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f2647a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f2647a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i2, CharSequence charSequence, f fVar) {
            this(null, i2, charSequence, fVar, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.f2648b = i2;
            this.f2650d = fVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.f2647a = obj;
            } else {
                this.f2647a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.f2649c = cls;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f2651a;

        b(Object obj) {
            this.f2651a = obj;
        }

        public static b a(int i2, int i3, boolean z, int i4) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
            }
            if (i5 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new b(null);
        }
    }

    /* renamed from: b.h.k.d0.c$c  reason: collision with other inner class name */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0048c {

        /* renamed from: a  reason: collision with root package name */
        final Object f2652a;

        C0048c(Object obj) {
            this.f2652a = obj;
        }

        public static C0048c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 21) {
                return new C0048c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
            }
            if (i6 >= 19) {
                return new C0048c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new C0048c(null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2637a = accessibilityNodeInfo;
    }

    public static c E0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c N() {
        return E0(AccessibilityNodeInfo.obtain());
    }

    public static c O(View view) {
        return E0(AccessibilityNodeInfo.obtain(view));
    }

    public static c P(c cVar) {
        return E0(AccessibilityNodeInfo.obtain(cVar.f2637a));
    }

    private void T(View view) {
        SparseArray<WeakReference<ClickableSpan>> v = v(view);
        if (v != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < v.size(); i2++) {
                if (v.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                v.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void V(int i2, boolean z) {
        Bundle s = s();
        if (s != null) {
            int i3 = s.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i2 ^ -1);
            if (!z) {
                i2 = 0;
            }
            s.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2637a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2637a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2637a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2637a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> h(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2637a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f2637a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String j(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean l(int i2) {
        Bundle s = s();
        if (s != null && (s.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2) {
            return true;
        }
        return false;
    }

    public static ClickableSpan[] q(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> t(View view) {
        SparseArray<WeakReference<ClickableSpan>> v = v(view);
        if (v != null) {
            return v;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(b.h.b.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> v(View view) {
        return (SparseArray) view.getTag(b.h.b.tag_accessibility_clickable_spans);
    }

    private boolean y() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f2636d;
        f2636d = i3 + 1;
        return i3;
    }

    public boolean A() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2637a.isAccessibilityFocused();
        }
        return false;
    }

    public void A0(CharSequence charSequence) {
        this.f2637a.setText(charSequence);
    }

    public boolean B() {
        return this.f2637a.isCheckable();
    }

    public void B0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f2637a.setTraversalAfter(view);
        }
    }

    public boolean C() {
        return this.f2637a.isChecked();
    }

    public void C0(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2637a.setVisibleToUser(z);
        }
    }

    public boolean D() {
        return this.f2637a.isClickable();
    }

    public AccessibilityNodeInfo D0() {
        return this.f2637a;
    }

    public boolean E() {
        return this.f2637a.isEnabled();
    }

    public boolean F() {
        return this.f2637a.isFocusable();
    }

    public boolean G() {
        return this.f2637a.isFocused();
    }

    public boolean H() {
        return this.f2637a.isLongClickable();
    }

    public boolean I() {
        return this.f2637a.isPassword();
    }

    public boolean J() {
        return this.f2637a.isScrollable();
    }

    public boolean K() {
        return this.f2637a.isSelected();
    }

    public boolean L() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2637a.isShowingHintText();
        }
        return l(4);
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2637a.isVisibleToUser();
        }
        return false;
    }

    public boolean Q(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2637a.performAction(i2, bundle);
        }
        return false;
    }

    public void R() {
        this.f2637a.recycle();
    }

    public boolean S(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2637a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2647a);
        }
        return false;
    }

    public void U(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2637a.setAccessibilityFocused(z);
        }
    }

    @Deprecated
    public void W(Rect rect) {
        this.f2637a.setBoundsInParent(rect);
    }

    public void X(Rect rect) {
        this.f2637a.setBoundsInScreen(rect);
    }

    public void Y(boolean z) {
        this.f2637a.setCheckable(z);
    }

    public void Z(boolean z) {
        this.f2637a.setChecked(z);
    }

    public void a(int i2) {
        this.f2637a.addAction(i2);
    }

    public void a0(CharSequence charSequence) {
        this.f2637a.setClassName(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2637a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2647a);
        }
    }

    public void b0(boolean z) {
        this.f2637a.setClickable(z);
    }

    public void c(View view) {
        this.f2637a.addChild(view);
    }

    public void c0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f2637a;
            if (obj == null) {
                collectionInfo = null;
            } else {
                collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f2651a;
            }
            accessibilityNodeInfo.setCollectionInfo(collectionInfo);
        }
    }

    public void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2637a.addChild(view, i2);
        }
    }

    public void d0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f2637a;
            if (obj == null) {
                collectionItemInfo = null;
            } else {
                collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((C0048c) obj).f2652a;
            }
            accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
        }
    }

    public void e0(CharSequence charSequence) {
        this.f2637a.setContentDescription(charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2637a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f2637a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f2637a)) {
            return false;
        }
        return this.f2639c == cVar.f2639c && this.f2638b == cVar.f2638b;
    }

    public void f(CharSequence charSequence, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19 && i2 < 26) {
            g();
            T(view);
            ClickableSpan[] q = q(charSequence);
            if (q != null && q.length > 0) {
                s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", b.h.b.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> t = t(view);
                int i3 = 0;
                while (q != null && i3 < q.length) {
                    int z = z(q[i3], t);
                    t.put(z, new WeakReference<>(q[i3]));
                    e(q[i3], (Spanned) charSequence, z);
                    i3++;
                }
            }
        }
    }

    public void f0(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2637a.setDismissable(z);
        }
    }

    public void g0(boolean z) {
        this.f2637a.setEnabled(z);
    }

    public void h0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2637a.setError(charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2637a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<a> i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f2637a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    public void i0(boolean z) {
        this.f2637a.setFocusable(z);
    }

    public void j0(boolean z) {
        this.f2637a.setFocused(z);
    }

    public int k() {
        return this.f2637a.getActions();
    }

    public void k0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2637a.setHeading(z);
        } else {
            V(2, z);
        }
    }

    public void l0(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f2637a.setHintText(charSequence);
        } else if (i2 >= 19) {
            this.f2637a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    @Deprecated
    public void m(Rect rect) {
        this.f2637a.getBoundsInParent(rect);
    }

    public void m0(boolean z) {
        this.f2637a.setLongClickable(z);
    }

    public void n(Rect rect) {
        this.f2637a.getBoundsInScreen(rect);
    }

    public void n0(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2637a.setMaxTextLength(i2);
        }
    }

    public int o() {
        return this.f2637a.getChildCount();
    }

    public void o0(CharSequence charSequence) {
        this.f2637a.setPackageName(charSequence);
    }

    public CharSequence p() {
        return this.f2637a.getClassName();
    }

    public void p0(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f2637a.setPaneTitle(charSequence);
        } else if (i2 >= 19) {
            this.f2637a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void q0(View view) {
        this.f2638b = -1;
        this.f2637a.setParent(view);
    }

    public CharSequence r() {
        return this.f2637a.getContentDescription();
    }

    public void r0(View view, int i2) {
        this.f2638b = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2637a.setParent(view, i2);
        }
    }

    public Bundle s() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f2637a.getExtras();
        }
        return new Bundle();
    }

    public void s0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2637a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public void t0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2637a.setScreenReaderFocusable(z);
        } else {
            V(1, z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb.append("; boundsInParent: " + rect);
        n(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(w());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(x());
        sb.append("; checkable: ");
        sb.append(B());
        sb.append("; checked: ");
        sb.append(C());
        sb.append("; focusable: ");
        sb.append(F());
        sb.append("; focused: ");
        sb.append(G());
        sb.append("; selected: ");
        sb.append(K());
        sb.append("; clickable: ");
        sb.append(D());
        sb.append("; longClickable: ");
        sb.append(H());
        sb.append("; enabled: ");
        sb.append(E());
        sb.append("; password: ");
        sb.append(I());
        sb.append("; scrollable: " + J());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> i2 = i();
            for (int i3 = 0; i3 < i2.size(); i3++) {
                a aVar = i2.get(i3);
                String j2 = j(aVar.b());
                if (j2.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    j2 = aVar.c().toString();
                }
                sb.append(j2);
                if (i3 != i2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int k2 = k();
            while (k2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(k2);
                k2 &= numberOfTrailingZeros ^ -1;
                sb.append(j(numberOfTrailingZeros));
                if (k2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f2637a.getPackageName();
    }

    public void u0(boolean z) {
        this.f2637a.setScrollable(z);
    }

    public void v0(boolean z) {
        this.f2637a.setSelected(z);
    }

    public CharSequence w() {
        if (!y()) {
            return this.f2637a.getText();
        }
        List<Integer> h2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> h3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> h4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> h5 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2637a.getText(), 0, this.f2637a.getText().length()));
        for (int i2 = 0; i2 < h2.size(); i2++) {
            spannableString.setSpan(new a(h5.get(i2).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), h2.get(i2).intValue(), h3.get(i2).intValue(), h4.get(i2).intValue());
        }
        return spannableString;
    }

    public void w0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2637a.setShowingHintText(z);
        } else {
            V(4, z);
        }
    }

    public String x() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2637a.getViewIdResourceName();
        }
        return null;
    }

    public void x0(View view) {
        this.f2639c = -1;
        this.f2637a.setSource(view);
    }

    public void y0(View view, int i2) {
        this.f2639c = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2637a.setSource(view, i2);
        }
    }

    public void z0(CharSequence charSequence) {
        if (androidx.core.os.a.a()) {
            this.f2637a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2637a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }
}
