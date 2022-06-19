package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m.k;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.load.n.a;
import com.bumptech.glide.load.n.b;
import com.bumptech.glide.load.n.d;
import com.bumptech.glide.load.n.e;
import com.bumptech.glide.load.n.f;
import com.bumptech.glide.load.n.k;
import com.bumptech.glide.load.n.s;
import com.bumptech.glide.load.n.t;
import com.bumptech.glide.load.n.u;
import com.bumptech.glide.load.n.v;
import com.bumptech.glide.load.n.w;
import com.bumptech.glide.load.n.x;
import com.bumptech.glide.load.n.y.a;
import com.bumptech.glide.load.n.y.b;
import com.bumptech.glide.load.n.y.c;
import com.bumptech.glide.load.n.y.d;
import com.bumptech.glide.load.n.y.e;
import com.bumptech.glide.load.n.y.f;
import com.bumptech.glide.load.o.d.a;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.bumptech.glide.load.resource.bitmap.c;
import com.bumptech.glide.load.resource.bitmap.g;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.m.d;
import com.bumptech.glide.m.l;
import com.bumptech.glide.p.f;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide */
public class b implements ComponentCallbacks2 {

    /* renamed from: j  reason: collision with root package name */
    private static volatile b f3499j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f3500k;

    /* renamed from: b  reason: collision with root package name */
    private final e f3501b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3502c;

    /* renamed from: d  reason: collision with root package name */
    private final d f3503d;

    /* renamed from: e  reason: collision with root package name */
    private final Registry f3504e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f3505f;

    /* renamed from: g  reason: collision with root package name */
    private final l f3506g;

    /* renamed from: h  reason: collision with root package name */
    private final d f3507h;

    /* renamed from: i  reason: collision with root package name */
    private final List<i> f3508i = new ArrayList();

    /* compiled from: Glide */
    public interface a {
        f a();
    }

    b(Context context, k kVar, h hVar, e eVar, com.bumptech.glide.load.engine.z.b bVar, l lVar, d dVar, int i2, a aVar, Map<Class<?>, j<?, ?>> map, List<com.bumptech.glide.p.e<Object>> list, boolean z, boolean z2) {
        j jVar;
        j jVar2;
        com.bumptech.glide.load.o.e.d dVar2;
        e eVar2 = e.NORMAL;
        this.f3501b = eVar;
        this.f3505f = bVar;
        this.f3502c = hVar;
        this.f3506g = lVar;
        this.f3507h = dVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f3504e = registry;
        registry.o(new DefaultImageHeaderParser());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            registry.o(new o());
        }
        List<ImageHeaderParser> g2 = registry.g();
        com.bumptech.glide.load.o.g.a aVar2 = new com.bumptech.glide.load.o.g.a(context, g2, eVar, bVar);
        j<ParcelFileDescriptor, Bitmap> h2 = a0.h(eVar);
        com.bumptech.glide.load.resource.bitmap.l lVar2 = new com.bumptech.glide.load.resource.bitmap.l(registry.g(), resources.getDisplayMetrics(), eVar, bVar);
        if (!z2 || i3 < 28) {
            jVar = new g(lVar2);
            jVar2 = new x(lVar2, bVar);
        } else {
            jVar2 = new s();
            jVar = new com.bumptech.glide.load.resource.bitmap.h();
        }
        com.bumptech.glide.load.o.e.d dVar3 = new com.bumptech.glide.load.o.e.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar4 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        c cVar2 = new c(bVar);
        com.bumptech.glide.load.o.h.a aVar4 = new com.bumptech.glide.load.o.h.a();
        com.bumptech.glide.load.o.h.d dVar5 = new com.bumptech.glide.load.o.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new com.bumptech.glide.load.n.c());
        registry.a(InputStream.class, new t(bVar));
        registry.e("Bitmap", ByteBuffer.class, Bitmap.class, jVar);
        registry.e("Bitmap", InputStream.class, Bitmap.class, jVar2);
        if (m.c()) {
            dVar2 = dVar3;
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new u(lVar2));
        } else {
            dVar2 = dVar3;
        }
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h2);
        registry.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, a0.c(eVar));
        registry.d(Bitmap.class, Bitmap.class, v.a.a());
        registry.e("Bitmap", Bitmap.class, Bitmap.class, new z());
        registry.b(Bitmap.class, cVar2);
        registry.e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, jVar));
        registry.e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, jVar2));
        registry.e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, h2));
        registry.b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar, cVar2));
        registry.e("Gif", InputStream.class, com.bumptech.glide.load.o.g.c.class, new com.bumptech.glide.load.o.g.j(g2, aVar2, bVar));
        registry.e("Gif", ByteBuffer.class, com.bumptech.glide.load.o.g.c.class, aVar2);
        registry.b(com.bumptech.glide.load.o.g.c.class, new com.bumptech.glide.load.o.g.d());
        registry.d(com.bumptech.glide.l.a.class, com.bumptech.glide.l.a.class, v.a.a());
        registry.e("Bitmap", com.bumptech.glide.l.a.class, Bitmap.class, new com.bumptech.glide.load.o.g.h(eVar));
        registry.c(Uri.class, Drawable.class, dVar2);
        registry.c(Uri.class, Bitmap.class, new w(dVar2, eVar));
        registry.p(new a.C0103a());
        registry.d(File.class, ByteBuffer.class, new d.b());
        registry.d(File.class, InputStream.class, new f.e());
        registry.c(File.class, File.class, new com.bumptech.glide.load.o.f.a());
        registry.d(File.class, ParcelFileDescriptor.class, new f.b());
        registry.d(File.class, File.class, v.a.a());
        registry.p(new k.a(bVar));
        if (m.c()) {
            registry.p(new m.a());
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar);
        registry.d(cls, ParcelFileDescriptor.class, bVar2);
        registry.d(Integer.class, InputStream.class, cVar);
        registry.d(Integer.class, ParcelFileDescriptor.class, bVar2);
        registry.d(Integer.class, Uri.class, dVar4);
        registry.d(cls, AssetFileDescriptor.class, aVar3);
        registry.d(Integer.class, AssetFileDescriptor.class, aVar3);
        registry.d(cls, Uri.class, dVar4);
        registry.d(String.class, InputStream.class, new e.c());
        registry.d(Uri.class, InputStream.class, new e.c());
        registry.d(String.class, InputStream.class, new u.c());
        registry.d(String.class, ParcelFileDescriptor.class, new u.b());
        registry.d(String.class, AssetFileDescriptor.class, new u.a());
        registry.d(Uri.class, InputStream.class, new b.a());
        registry.d(Uri.class, InputStream.class, new a.c(context.getAssets()));
        registry.d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets()));
        registry.d(Uri.class, InputStream.class, new c.a(context));
        registry.d(Uri.class, InputStream.class, new d.a(context));
        if (i3 >= 29) {
            registry.d(Uri.class, InputStream.class, new e.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new e.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver));
        registry.d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver));
        registry.d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver));
        registry.d(Uri.class, InputStream.class, new x.a());
        registry.d(URL.class, InputStream.class, new f.a());
        registry.d(Uri.class, File.class, new k.a(context));
        registry.d(com.bumptech.glide.load.n.g.class, InputStream.class, new a.C0100a());
        registry.d(byte[].class, ByteBuffer.class, new b.a());
        registry.d(byte[].class, InputStream.class, new b.d());
        registry.d(Uri.class, Uri.class, v.a.a());
        registry.d(Drawable.class, Drawable.class, v.a.a());
        registry.c(Drawable.class, Drawable.class, new com.bumptech.glide.load.o.e.e());
        registry.q(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.o.h.b(resources));
        registry.q(Bitmap.class, byte[].class, aVar4);
        registry.q(Drawable.class, byte[].class, new com.bumptech.glide.load.o.h.c(eVar, aVar4, dVar5));
        registry.q(com.bumptech.glide.load.o.g.c.class, byte[].class, dVar5);
        if (i3 >= 23) {
            j<ByteBuffer, Bitmap> d2 = a0.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, d2);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, d2));
        }
        this.f3503d = new d(context, bVar, registry, new com.bumptech.glide.p.j.f(), aVar, map, list, kVar, z, i2);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f3500k) {
            f3500k = true;
            m(context, generatedAppGlideModule);
            f3500k = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static b c(Context context) {
        if (f3499j == null) {
            GeneratedAppGlideModule d2 = d(context.getApplicationContext());
            synchronized (b.class) {
                if (f3499j == null) {
                    a(context, d2);
                }
            }
        }
        return f3499j;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (InstantiationException e2) {
            q(e2);
            throw null;
        } catch (IllegalAccessException e3) {
            q(e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            q(e4);
            throw null;
        } catch (InvocationTargetException e5) {
            q(e5);
            throw null;
        }
    }

    private static l l(Context context) {
        com.bumptech.glide.r.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    private static void n(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.n.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new com.bumptech.glide.n.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d2 = generatedAppGlideModule.d();
            Iterator<com.bumptech.glide.n.b> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.n.b next = it.next();
                if (d2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.n.b> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        cVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (com.bumptech.glide.n.b bVar : emptyList) {
            bVar.a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b a2 = cVar.a(applicationContext);
        for (com.bumptech.glide.n.b bVar2 : emptyList) {
            try {
                bVar2.b(applicationContext, a2, a2.f3504e);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a2, a2.f3504e);
        }
        applicationContext.registerComponentCallbacks(a2);
        f3499j = a2;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static i t(Activity activity) {
        return l(activity).d(activity);
    }

    public static i u(Context context) {
        return l(context).e(context);
    }

    public static i v(androidx.fragment.app.d dVar) {
        return l(dVar).f(dVar);
    }

    public void b() {
        com.bumptech.glide.r.k.a();
        this.f3502c.b();
        this.f3501b.b();
        this.f3505f.b();
    }

    public com.bumptech.glide.load.engine.z.b e() {
        return this.f3505f;
    }

    public com.bumptech.glide.load.engine.z.e f() {
        return this.f3501b;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.m.d g() {
        return this.f3507h;
    }

    public Context h() {
        return this.f3503d.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    public d i() {
        return this.f3503d;
    }

    public Registry j() {
        return this.f3504e;
    }

    public l k() {
        return this.f3506g;
    }

    /* access modifiers changed from: package-private */
    public void o(i iVar) {
        synchronized (this.f3508i) {
            if (!this.f3508i.contains(iVar)) {
                this.f3508i.add(iVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i2) {
        r(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean p(com.bumptech.glide.p.j.h<?> hVar) {
        synchronized (this.f3508i) {
            for (i iVar : this.f3508i) {
                if (iVar.A(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i2) {
        com.bumptech.glide.r.k.a();
        for (i iVar : this.f3508i) {
            iVar.onTrimMemory(i2);
        }
        this.f3502c.a(i2);
        this.f3501b.a(i2);
        this.f3505f.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void s(i iVar) {
        synchronized (this.f3508i) {
            if (this.f3508i.contains(iVar)) {
                this.f3508i.remove(iVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
