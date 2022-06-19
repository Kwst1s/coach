package b.h.k.d0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2653a;

    /* compiled from: AccessibilityNodeProviderCompat */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final d f2654a;

        a(d dVar) {
            this.f2654a = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            c b2 = this.f2654a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.D0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<c> c2 = this.f2654a.c(str, i2);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(c2.get(i3).D0());
            }
            return arrayList;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f2654a.f(i2, i3, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            c d2 = this.f2654a.d(i2);
            if (d2 == null) {
                return null;
            }
            return d2.D0();
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class c extends b {
        c(d dVar) {
            super(dVar);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f2654a.a(i2, c.E0(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f2653a = new c(this);
        } else if (i2 >= 19) {
            this.f2653a = new b(this);
        } else if (i2 >= 16) {
            this.f2653a = new a(this);
        } else {
            this.f2653a = null;
        }
    }

    public void a(int i2, c cVar, String str, Bundle bundle) {
    }

    public c b(int i2) {
        return null;
    }

    public List<c> c(String str, int i2) {
        return null;
    }

    public c d(int i2) {
        return null;
    }

    public Object e() {
        return this.f2653a;
    }

    public boolean f(int i2, int i3, Bundle bundle) {
        return false;
    }

    public d(Object obj) {
        this.f2653a = obj;
    }
}
