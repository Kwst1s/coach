package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.t;
import java.util.List;

/* compiled from: Trigger */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final t.c f4675a = new t.c();

    public static t.a a(List<v> list) {
        if (list != null && !list.isEmpty()) {
            return new t.a(list);
        }
        throw new IllegalArgumentException("Uris must not be null or empty.");
    }

    public static t.b b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        } else if (i3 >= i2) {
            return new t.b(i2, i3);
        } else {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
    }
}
