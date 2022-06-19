package com.bumptech.glide.load.o.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import b.a.o.d;
import b.h.d.e.f;

/* compiled from: DrawableDecoderCompat */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f4101a = true;

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, int i2) {
        return c(context, context2, i2, null);
    }

    private static Drawable c(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (f4101a) {
                return e(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f4101a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return b.h.d.a.d(context2, i2);
            }
            throw e2;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i2, theme);
    }

    private static Drawable d(Context context, int i2, Resources.Theme theme) {
        return f.a(context.getResources(), i2, theme);
    }

    private static Drawable e(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return b.a.k.a.a.d(context, i2);
    }
}
