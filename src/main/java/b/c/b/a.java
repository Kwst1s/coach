package b.c.b;

import android.os.Bundle;

/* compiled from: CustomTabColorSchemeParams */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f2127a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f2128b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f2129c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f2130d;

    /* renamed from: b.c.b.a$a  reason: collision with other inner class name */
    /* compiled from: CustomTabColorSchemeParams */
    public static final class C0034a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f2131a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f2132b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f2133c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f2134d;

        public a a() {
            return new a(this.f2131a, this.f2132b, this.f2133c, this.f2134d);
        }

        public C0034a b(int i2) {
            this.f2131a = Integer.valueOf(i2 | -16777216);
            return this;
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f2127a = num;
        this.f2128b = num2;
        this.f2129c = num3;
        this.f2130d = num4;
    }

    /* access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f2127a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f2128b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f2129c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f2130d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
