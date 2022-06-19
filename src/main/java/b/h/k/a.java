package b.h.k;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.h.b;
import b.h.k.d0.c;
import b.h.k.d0.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f2591c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f2592a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f2593b;

    /* access modifiers changed from: package-private */
    /* renamed from: b.h.k.a$a  reason: collision with other inner class name */
    /* compiled from: AccessibilityDelegateCompat */
    public static final class C0046a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f2594a;

        C0046a(a aVar) {
            this.f2594a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2594a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d b2 = this.f2594a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2594a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c E0 = c.E0(accessibilityNodeInfo);
            E0.t0(u.V(view));
            E0.k0(u.Q(view));
            E0.p0(u.p(view));
            E0.z0(u.J(view));
            this.f2594a.g(view, E0);
            E0.f(accessibilityNodeInfo.getText(), view);
            List<c.a> c2 = a.c(view);
            for (int i2 = 0; i2 < c2.size(); i2++) {
                E0.b(c2.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2594a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2594a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f2594a.j(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.f2594a.l(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2594a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f2591c);
    }

    static List<c.a> c(View view) {
        List<c.a> list = (List) view.getTag(b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] q = c.q(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (q != null && i2 < q.length) {
                if (clickableSpan.equals(q[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2592a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f2592a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f2593b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f2592a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, c cVar) {
        this.f2592a.onInitializeAccessibilityNodeInfo(view, cVar.D0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f2592a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2592a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i2, Bundle bundle) {
        List<c.a> c2 = c(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= c2.size()) {
                break;
            }
            c.a aVar = c2.get(i3);
            if (aVar.b() == i2) {
                z = aVar.d(view, bundle);
                break;
            }
            i3++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f2592a.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != b.accessibility_action_clickable_span) ? z : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i2) {
        this.f2592a.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f2592a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2592a = accessibilityDelegate;
        this.f2593b = new C0046a(this);
    }
}
