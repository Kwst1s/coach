package b.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* compiled from: MultiDex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<File> f2806a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f2807b = n(System.getProperty("java.vm.version"));

    /* access modifiers changed from: private */
    /* renamed from: b.p.a$a  reason: collision with other inner class name */
    /* compiled from: MultiDex */
    public static final class C0058a {

        /* renamed from: b  reason: collision with root package name */
        private static final int f2808b = 4;

        /* renamed from: a  reason: collision with root package name */
        private final AbstractC0059a f2809a;

        /* access modifiers changed from: private */
        /* renamed from: b.p.a$a$a  reason: collision with other inner class name */
        /* compiled from: MultiDex */
        public interface AbstractC0059a {
            Object a(File file, DexFile dexFile);
        }

        /* renamed from: b.p.a$a$b */
        /* compiled from: MultiDex */
        private static class b implements AbstractC0059a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f2810a;

            b(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f2810a = constructor;
                constructor.setAccessible(true);
            }

            @Override // b.p.a.C0058a.AbstractC0059a
            public Object a(File file, DexFile dexFile) {
                return this.f2810a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* renamed from: b.p.a$a$c */
        /* compiled from: MultiDex */
        private static class c implements AbstractC0059a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f2811a;

            c(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f2811a = constructor;
                constructor.setAccessible(true);
            }

            @Override // b.p.a.C0058a.AbstractC0059a
            public Object a(File file, DexFile dexFile) {
                return this.f2811a.newInstance(file, file, dexFile);
            }
        }

        /* renamed from: b.p.a$a$d */
        /* compiled from: MultiDex */
        private static class d implements AbstractC0059a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f2812a;

            d(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f2812a = constructor;
                constructor.setAccessible(true);
            }

            @Override // b.p.a.C0058a.AbstractC0059a
            public Object a(File file, DexFile dexFile) {
                return this.f2812a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C0058a() {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                b.p.a$a$b r1 = new b.p.a$a$b     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                b.p.a$a$c r1 = new b.p.a$a$c     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                b.p.a$a$d r1 = new b.p.a$a$d
                r1.<init>(r0)
            L_0x001a:
                r2.f2809a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.p.a.C0058a.<init>():void");
        }

        static void a(ClassLoader classLoader, List<? extends File> list) {
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            Object[] b2 = new C0058a().b(list);
            try {
                a.f(obj, "dexElements", b2);
            } catch (NoSuchFieldException e2) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e2);
                a.f(obj, "pathElements", b2);
            }
        }

        private Object[] b(List<? extends File> list) {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < size; i2++) {
                File file = (File) list.get(i2);
                objArr[i2] = this.f2809a.a(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }

        private static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f2808b) + ".dex").getPath();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MultiDex */
    public static final class b {
        static void a(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field g2 = a.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) g2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                g2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) a.h(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MultiDex */
    public static final class c {
        static void a(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field g2 = a.g(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) g2.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            g2.set(classLoader, sb.toString());
            a.f(classLoader, "mPaths", strArr);
            a.f(classLoader, "mFiles", fileArr);
            a.f(classLoader, "mZips", zipFileArr);
            a.f(classLoader, "mDexs", dexFileArr);
        }
    }

    private static void d(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
        }
    }

    private static void e(Context context, File file, File file2, String str, String str2, boolean z) {
        Set<File> set = f2806a;
        synchronized (set) {
            if (!set.contains(file)) {
                set.add(file);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 > 20) {
                    Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + i2 + ": SDK version higher than " + 20 + " should be backed by " + "runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                }
                ClassLoader j2 = j(context);
                if (j2 != null) {
                    try {
                        d(context);
                    } catch (Throwable th) {
                        Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                    }
                    File k2 = k(context, file2, str);
                    c cVar = new c(file, k2);
                    IOException e2 = null;
                    try {
                        try {
                            m(j2, k2, cVar.K(context, str2, false));
                        } catch (IOException e3) {
                            if (z) {
                                Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e3);
                                m(j2, k2, cVar.K(context, str2, true));
                            } else {
                                throw e3;
                            }
                        }
                        try {
                        } catch (IOException e4) {
                            e2 = e4;
                        }
                        if (e2 != null) {
                            throw e2;
                        }
                    } finally {
                        try {
                            cVar.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void f(Object obj, String str, Object[] objArr) {
        Field g2 = g(obj, str);
        Object[] objArr2 = (Object[]) g2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g2.set(obj, objArr3);
    }

    /* access modifiers changed from: private */
    public static Field g(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    public static Method h(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static File k(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            o(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            o(file2);
        }
        File file3 = new File(file2, str);
        o(file3);
        return file3;
    }

    public static void l(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f2807b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 4) {
            try {
                ApplicationInfo i3 = i(context);
                if (i3 == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                e(context, new File(i3.sourceDir), new File(i3.dataDir), "secondary-dexes", BuildConfig.FLAVOR, true);
                Log.i("MultiDex", "install done");
            } catch (Exception e2) {
                Log.e("MultiDex", "MultiDex installation failure", e2);
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        } else {
            throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is " + 4 + ".");
        }
    }

    private static void m(ClassLoader classLoader, File file, List<? extends File> list) {
        if (!list.isEmpty()) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                b.a(classLoader, list, file);
            } else if (i2 >= 14) {
                C0058a.a(classLoader, list);
            } else {
                c.a(classLoader, list);
            }
        }
    }

    static boolean n(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str2 = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str2 = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str2 == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return z;
    }

    private static void o(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
