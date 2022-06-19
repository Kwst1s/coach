package c.b.a.a.m;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DeviceUtil */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected static final List<C0074a> f3158a;

    /* renamed from: c.b.a.a.m.a$a  reason: collision with other inner class name */
    /* compiled from: DeviceUtil */
    public static class C0074a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3159a = true;

        /* renamed from: b  reason: collision with root package name */
        private final String f3160b = null;

        /* renamed from: c  reason: collision with root package name */
        private final String f3161c;

        public C0074a(String str) {
            this.f3161c = str;
        }

        public String a() {
            return this.f3161c;
        }

        public String b() {
            return this.f3160b;
        }

        public boolean c() {
            return this.f3159a;
        }
    }

    static {
        LinkedList linkedList = new LinkedList();
        f3158a = linkedList;
        linkedList.add(new C0074a("Amazon"));
    }

    public boolean a(Context context) {
        UiModeManager uiModeManager;
        if (Build.VERSION.SDK_INT < 21 || (uiModeManager = (UiModeManager) context.getSystemService("uimode")) == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    public boolean b(List<C0074a> list) {
        for (C0074a aVar : list) {
            if (Build.MANUFACTURER.equalsIgnoreCase(aVar.a()) && (aVar.c() || Build.DEVICE.equalsIgnoreCase(aVar.b()))) {
                return true;
            }
        }
        return false;
    }

    public boolean c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && !b(f3158a)) {
            return true;
        }
        if (!Build.MANUFACTURER.equalsIgnoreCase("Amazon") || (!a(context) && i2 < 21)) {
            return false;
        }
        return true;
    }
}
