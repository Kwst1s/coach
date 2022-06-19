package b.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import b.h.d.e.c;
import b.h.h.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* compiled from: TypefaceCompatBaseImpl */
public class j {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f2496a = new ConcurrentHashMap<>();

    /* access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl */
    public class a implements c<b.f> {
        a(j jVar) {
        }

        /* renamed from: c */
        public int a(b.f fVar) {
            return fVar.d();
        }

        /* renamed from: d */
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl */
    public class b implements c<c.C0038c> {
        b(j jVar) {
        }

        /* renamed from: c */
        public int a(c.C0038c cVar) {
            return cVar.e();
        }

        /* renamed from: d */
        public boolean b(c.C0038c cVar) {
            return cVar.f();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: TypefaceCompatBaseImpl */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    j() {
    }

    private void a(Typeface typeface, c.b bVar) {
        long j2 = j(typeface);
        if (j2 != 0) {
            this.f2496a.put(Long.valueOf(j2), bVar);
        }
    }

    private c.C0038c f(c.b bVar, int i2) {
        return (c.C0038c) g(bVar.a(), i2, new b(this));
    }

    private static <T> T g(T[] tArr, int i2, c<T> cVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i3) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0;
        }
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        c.C0038c f2 = f(bVar, i2);
        if (f2 == null) {
            return null;
        }
        Typeface d2 = d.d(context, resources, f2.b(), f2.a(), i2);
        a(d2, bVar);
        return d2;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(fVarArr, i2).c());
            try {
                Typeface d2 = d(context, inputStream);
                k.a(inputStream);
                return d2;
            } catch (IOException unused) {
                k.a(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                k.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            k.a(inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e2 = k.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!k.d(e2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File e2 = k.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!k.c(e2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    /* access modifiers changed from: protected */
    public b.f h(b.f[] fVarArr, int i2) {
        return (b.f) g(fVarArr, i2, new a(this));
    }

    /* access modifiers changed from: package-private */
    public c.b i(Typeface typeface) {
        long j2 = j(typeface);
        if (j2 == 0) {
            return null;
        }
        return this.f2496a.get(Long.valueOf(j2));
    }
}
