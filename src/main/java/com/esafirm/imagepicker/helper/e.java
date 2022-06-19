package com.esafirm.imagepicker.helper;

import android.util.Log;

/* compiled from: IpLogger */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f4579b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f4580a = true;

    private e() {
    }

    public static e c() {
        if (f4579b == null) {
            f4579b = new e();
        }
        return f4579b;
    }

    public void a(String str) {
        if (this.f4580a) {
            Log.d("ImagePicker", str);
        }
    }

    public void b(String str) {
        if (this.f4580a) {
            Log.e("ImagePicker", str);
        }
    }

    public void d(String str) {
        if (this.f4580a) {
            Log.w("ImagePicker", str);
        }
    }
}
