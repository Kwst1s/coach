package com.esafirm.imagepicker.helper;

import android.content.Context;
import c.c.a.f;
import com.esafirm.imagepicker.features.l;
import com.esafirm.imagepicker.features.r;

/* compiled from: ConfigUtils */
public class a {
    public static String a(Context context, l lVar) {
        String m = lVar.m();
        return c.f(m) ? context.getString(f.ef_done) : m;
    }

    public static String b(Context context, l lVar) {
        String o = lVar.o();
        return c.f(o) ? context.getString(f.ef_title_folder) : o;
    }

    public static String c(Context context, l lVar) {
        String q = lVar.q();
        return c.f(q) ? context.getString(f.ef_title_select_image) : q;
    }

    public static boolean d(com.esafirm.imagepicker.features.u.a aVar, boolean z) {
        r k2 = aVar.k();
        if (z) {
            if (k2 == r.ALL || k2 == r.CAMERA_ONLY) {
                return true;
            }
            return false;
        } else if (k2 == r.ALL || k2 == r.GALLERY_ONLY) {
            return true;
        } else {
            return false;
        }
    }
}
