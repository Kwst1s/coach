package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.d;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class DynamiteModule {
    @GuardedBy("DynamiteModule.class")

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f7442b = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: c  reason: collision with root package name */
    private static f f7443c = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: d  reason: collision with root package name */
    private static h f7444d = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: e  reason: collision with root package name */
    private static String f7445e = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: f  reason: collision with root package name */
    private static int f7446f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal<b> f7447g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadLocal<Long> f7448h = new a();

    /* renamed from: i  reason: collision with root package name */
    private static final a.b f7449i = new b();
    @RecentlyNonNull

    /* renamed from: j  reason: collision with root package name */
    public static final a f7450j = new d();

    /* renamed from: a  reason: collision with root package name */
    private final Context f7451a;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, a aVar) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        public static class C0148a {

            /* renamed from: a  reason: collision with root package name */
            public int f7452a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f7453b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f7454c = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        public interface b {
            int a(Context context, String str, boolean z);

            int b(Context context, String str);
        }

        C0148a a(Context context, String str, b bVar);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Cursor f7455a;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    private static class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private final int f7456a;

        public c(int i2, int i3) {
            this.f7456a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int b(Context context, String str) {
            return this.f7456a;
        }
    }

    private DynamiteModule(Context context) {
        n.f(context);
        this.f7451a = context;
    }

    public static int a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (m.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @RecentlyNonNull
    public static DynamiteModule c(@RecentlyNonNull Context context, @RecentlyNonNull a aVar, @RecentlyNonNull String str) {
        ThreadLocal<b> threadLocal = f7447g;
        b bVar = threadLocal.get();
        b bVar2 = new b(null);
        threadLocal.set(bVar2);
        ThreadLocal<Long> threadLocal2 = f7448h;
        long longValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            a.C0148a a2 = aVar.a(context, str, f7449i);
            int i2 = a2.f7452a;
            int i3 = a2.f7453b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = a2.f7454c;
            if (i4 == 0 || ((i4 == -1 && a2.f7452a == 0) || (i4 == 1 && a2.f7453b == 0))) {
                int i5 = a2.f7452a;
                int i6 = a2.f7453b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (a) null);
            } else if (i4 == -1) {
                DynamiteModule e2 = e(context, str);
                if (longValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(longValue));
                }
                Cursor cursor = bVar2.f7455a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return e2;
            } else if (i4 == 1) {
                try {
                    DynamiteModule f2 = f(context, str, a2.f7453b);
                    if (longValue == 0) {
                        threadLocal2.remove();
                    } else {
                        threadLocal2.set(Long.valueOf(longValue));
                    }
                    Cursor cursor2 = bVar2.f7455a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return f2;
                } catch (LoadingException e3) {
                    String valueOf = String.valueOf(e3.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i7 = a2.f7452a;
                    if (i7 == 0 || aVar.a(context, str, new c(i7, 0)).f7454c != -1) {
                        throw new LoadingException("Remote load failed. No local fallback found.", e3, null);
                    }
                    DynamiteModule e4 = e(context, str);
                    if (r3 != 0) {
                        f7448h.set(Long.valueOf(longValue));
                    }
                    return e4;
                }
            } else {
                int i8 = a2.f7454c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i8);
                throw new LoadingException(sb3.toString(), (a) null);
            }
        } finally {
            if (longValue == 0) {
                f7448h.remove();
            } else {
                f7448h.set(Long.valueOf(longValue));
            }
            Cursor cursor3 = bVar2.f7455a;
            if (cursor3 != null) {
                cursor3.close();
            }
            f7447g.set(bVar);
        }
    }

    public static int d(@RecentlyNonNull Context context, @RecentlyNonNull String str, boolean z) {
        ClassLoader classLoader;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f7442b;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader2 = (ClassLoader) declaredField.get(null);
                            if (classLoader2 != null) {
                                if (classLoader2 == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        i(classLoader2);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                }
                            } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int m = m(context, str, z);
                                    String str2 = f7445e;
                                    if (str2 != null) {
                                        if (!str2.isEmpty()) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = f7445e;
                                                n.f(str3);
                                                classLoader = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str4 = f7445e;
                                                n.f(str4);
                                                classLoader = new c(str4, ClassLoader.getSystemClassLoader());
                                            }
                                            i(classLoader);
                                            declaredField.set(null, classLoader);
                                            f7442b = Boolean.TRUE;
                                            return m;
                                        }
                                    }
                                    return m;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                    f7442b = bool;
                                    if (!bool.booleanValue()) {
                                        return k(context, str, z);
                                    }
                                    try {
                                        return m(context, str, z);
                                    } catch (LoadingException e2) {
                                        String valueOf = String.valueOf(e2.getMessage());
                                        Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
                                        return 0;
                                    }
                                }
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                        String valueOf2 = String.valueOf(e3);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf2);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                }
            }
        } catch (Throwable th) {
            d.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule e(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule f(Context context, String str, int i2) {
        Boolean bool;
        com.google.android.gms.dynamic.a aVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f7442b;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (a) null);
            } else if (bool.booleanValue()) {
                return l(context, str, i2);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                f g2 = g(context);
                if (g2 != null) {
                    int j2 = g2.j();
                    if (j2 >= 3) {
                        b bVar = f7447g.get();
                        if (bVar != null) {
                            aVar = g2.d(com.google.android.gms.dynamic.b.T(context), str, i2, com.google.android.gms.dynamic.b.T(bVar.f7455a));
                        } else {
                            throw new LoadingException("No cached result cursor holder", (a) null);
                        }
                    } else if (j2 == 2) {
                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                        aVar = g2.v(com.google.android.gms.dynamic.b.T(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        aVar = g2.E(com.google.android.gms.dynamic.b.T(context), str, i2);
                    }
                    if (com.google.android.gms.dynamic.b.k(aVar) != null) {
                        return new DynamiteModule((Context) com.google.android.gms.dynamic.b.k(aVar));
                    }
                    throw new LoadingException("Failed to load remote module.", (a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (a) null);
            }
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            d.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    private static f g(Context context) {
        f fVar;
        synchronized (DynamiteModule.class) {
            f fVar2 = f7443c;
            if (fVar2 != null) {
                return fVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    fVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof f) {
                        fVar = (f) queryLocalInterface;
                    } else {
                        fVar = new e(iBinder);
                    }
                }
                if (fVar != null) {
                    f7443c = fVar;
                    return fVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    private static Boolean h() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f7446f >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    private static void i(ClassLoader classLoader) {
        h hVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                hVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof h) {
                    hVar = (h) queryLocalInterface;
                } else {
                    hVar = new g(iBinder);
                }
            }
            f7444d = hVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    private static boolean j(Cursor cursor) {
        b bVar = f7447g.get();
        if (bVar == null || bVar.f7455a != null) {
            return false;
        }
        bVar.f7455a = cursor;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093 A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int k(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.k(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule l(Context context, String str, int i2) {
        h hVar;
        com.google.android.gms.dynamic.a aVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            hVar = f7444d;
        }
        if (hVar != null) {
            b bVar = f7447g.get();
            if (bVar == null || bVar.f7455a == null) {
                throw new LoadingException("No result cursor", (a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = bVar.f7455a;
            com.google.android.gms.dynamic.b.T(null);
            if (h().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                aVar = hVar.r(com.google.android.gms.dynamic.b.T(applicationContext), str, i2, com.google.android.gms.dynamic.b.T(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                aVar = hVar.d(com.google.android.gms.dynamic.b.T(applicationContext), str, i2, com.google.android.gms.dynamic.b.T(cursor));
            }
            Context context2 = (Context) com.google.android.gms.dynamic.b.k(aVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (a) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (j(r10) != false) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m(android.content.Context, java.lang.String, boolean):int");
    }

    @RecentlyNonNull
    public final Context b() {
        return this.f7451a;
    }
}
