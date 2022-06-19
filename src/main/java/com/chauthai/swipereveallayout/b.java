package com.chauthai.swipereveallayout;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ViewBinderHelper */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f4408a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    private Map<String, SwipeRevealLayout> f4409b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f4410c = Collections.synchronizedSet(new HashSet());

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f4411d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4412e = new Object();

    /* compiled from: ViewBinderHelper */
    class a implements SwipeRevealLayout.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SwipeRevealLayout f4414b;

        a(String str, SwipeRevealLayout swipeRevealLayout) {
            this.f4413a = str;
            this.f4414b = swipeRevealLayout;
        }

        @Override // com.chauthai.swipereveallayout.SwipeRevealLayout.c
        public void a(int i2) {
            b.this.f4408a.put(this.f4413a, Integer.valueOf(i2));
            if (b.this.f4411d) {
                b.this.e(this.f4413a, this.f4414b);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(String str, SwipeRevealLayout swipeRevealLayout) {
        synchronized (this.f4412e) {
            if (f() > 1) {
                for (Map.Entry<String, Integer> entry : this.f4408a.entrySet()) {
                    if (!entry.getKey().equals(str)) {
                        entry.setValue(0);
                    }
                }
                for (SwipeRevealLayout swipeRevealLayout2 : this.f4409b.values()) {
                    if (swipeRevealLayout2 != swipeRevealLayout) {
                        swipeRevealLayout2.B(true);
                    }
                }
            }
        }
    }

    private int f() {
        int i2 = 0;
        for (Integer num : this.f4408a.values()) {
            int intValue = num.intValue();
            if (intValue == 2 || intValue == 3) {
                i2++;
            }
        }
        return i2;
    }

    public void d(SwipeRevealLayout swipeRevealLayout, String str) {
        if (swipeRevealLayout.L()) {
            swipeRevealLayout.requestLayout();
        }
        this.f4409b.values().remove(swipeRevealLayout);
        this.f4409b.put(str, swipeRevealLayout);
        swipeRevealLayout.a();
        swipeRevealLayout.setDragStateChangeListener(new a(str, swipeRevealLayout));
        if (!this.f4408a.containsKey(str)) {
            this.f4408a.put(str, 0);
            swipeRevealLayout.B(false);
        } else {
            int intValue = this.f4408a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeRevealLayout.B(false);
            } else {
                swipeRevealLayout.I(false);
            }
        }
        swipeRevealLayout.setLockDrag(this.f4410c.contains(str));
    }
}
