package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* access modifiers changed from: package-private */
/* compiled from: TimeSource */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static final r f7736c = new r(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f7737a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f7738b;

    private r(Long l, TimeZone timeZone) {
        this.f7737a = l;
        this.f7738b = timeZone;
    }

    static r c() {
        return f7736c;
    }

    /* access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f7738b);
    }

    /* access modifiers changed from: package-private */
    public Calendar b(TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f7737a;
        if (l != null) {
            instance.setTimeInMillis(l.longValue());
        }
        return instance;
    }
}
