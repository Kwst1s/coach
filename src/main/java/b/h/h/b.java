package b.h.h;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import b.h.d.e.f;
import b.h.e.k;
import b.h.h.c;
import b.h.j.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final b.e.e<String, Typeface> f2503a = new b.e.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final c f2504b = new c("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f2505c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final b.e.g<String, ArrayList<c.d<g>>> f2506d = new b.e.g<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f2507e = new d();

    /* access modifiers changed from: package-private */
    /* compiled from: FontsContractCompat */
    public class a implements Callable<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2508a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f2509b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2510c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2511d;

        a(Context context, a aVar, int i2, String str) {
            this.f2508a = context;
            this.f2509b = aVar;
            this.f2510c = i2;
            this.f2511d = str;
        }

        /* renamed from: a */
        public g call() {
            g f2 = b.f(this.f2508a, this.f2509b, this.f2510c);
            Typeface typeface = f2.f2522a;
            if (typeface != null) {
                b.f2503a.d(this.f2511d, typeface);
            }
            return f2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b.h.h.b$b  reason: collision with other inner class name */
    /* compiled from: FontsContractCompat */
    public class C0041b implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f2512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f2513b;

        C0041b(f.a aVar, Handler handler) {
            this.f2512a = aVar;
            this.f2513b = handler;
        }

        /* renamed from: b */
        public void a(g gVar) {
            if (gVar == null) {
                this.f2512a.a(1, this.f2513b);
                return;
            }
            int i2 = gVar.f2523b;
            if (i2 == 0) {
                this.f2512a.b(gVar.f2522a, this.f2513b);
            } else {
                this.f2512a.a(i2, this.f2513b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FontsContractCompat */
    public class c implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2514a;

        c(String str) {
            this.f2514a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            r2.get(r0).a(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(b.h.h.b.g r5) {
            /*
                r4 = this;
                java.lang.Object r0 = b.h.h.b.f2505c
                monitor-enter(r0)
                b.e.g<java.lang.String, java.util.ArrayList<b.h.h.c$d<b.h.h.b$g>>> r1 = b.h.h.b.f2506d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f2514a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f2514a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                b.h.h.c$d r1 = (b.h.h.c.d) r1
                r1.a(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)
                goto L_0x002f
            L_0x002e:
                throw r5
            L_0x002f:
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: b.h.h.b.c.a(b.h.h.b$g):void");
        }
    }

    /* compiled from: FontsContractCompat */
    class d implements Comparator<byte[]> {
        d() {
        }

        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            if (bArr.length != bArr2.length) {
                i3 = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (bArr[i4] != bArr2[i4]) {
                        i3 = bArr[i4];
                        i2 = bArr2[i4];
                    }
                }
                return 0;
            }
            return (i3 == 1 ? 1 : 0) - (i2 == 1 ? 1 : 0);
        }
    }

    /* compiled from: FontsContractCompat */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f2515a;

        /* renamed from: b  reason: collision with root package name */
        private final f[] f2516b;

        public e(int i2, f[] fVarArr) {
            this.f2515a = i2;
            this.f2516b = fVarArr;
        }

        public f[] a() {
            return this.f2516b;
        }

        public int b() {
            return this.f2515a;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2517a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2518b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2519c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2520d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2521e;

        public f(Uri uri, int i2, int i3, boolean z, int i4) {
            h.c(uri);
            this.f2517a = uri;
            this.f2518b = i2;
            this.f2519c = i3;
            this.f2520d = z;
            this.f2521e = i4;
        }

        public int a() {
            return this.f2521e;
        }

        public int b() {
            return this.f2518b;
        }

        public Uri c() {
            return this.f2517a;
        }

        public int d() {
            return this.f2519c;
        }

        public boolean e() {
            return this.f2520d;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: FontsContractCompat */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f2522a;

        /* renamed from: b  reason: collision with root package name */
        final int f2523b;

        g(Typeface typeface, int i2) {
            this.f2522a = typeface;
            this.f2523b = i2;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, a aVar) {
        ProviderInfo h2 = h(context.getPackageManager(), aVar, context.getResources());
        if (h2 == null) {
            return new e(1, null);
        }
        return new e(0, e(context, aVar, h2.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return b.h.d.e.c.c(resources, aVar.b());
    }

    static f[] e(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        Uri uri;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new f(uri, i3, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i2));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, a aVar, int i2) {
        try {
            e c2 = c(context, null, aVar);
            int i3 = -3;
            if (c2.b() == 0) {
                Typeface b2 = b.h.e.d.b(context, null, c2.a(), i2);
                if (b2 != null) {
                    i3 = 0;
                }
                return new g(b2, i3);
            }
            if (c2.b() == 1) {
                i3 = -2;
            }
            return new g(null, i3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, a aVar, f.a aVar2, Handler handler, boolean z, int i2, int i3) {
        C0041b bVar;
        String str = aVar.c() + "-" + i3;
        Typeface c2 = f2503a.c(str);
        if (c2 != null) {
            if (aVar2 != null) {
                aVar2.d(c2);
            }
            return c2;
        } else if (!z || i2 != -1) {
            a aVar3 = new a(context, aVar, i3, str);
            if (z) {
                try {
                    return ((g) f2504b.e(aVar3, i2)).f2522a;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                if (aVar2 == null) {
                    bVar = null;
                } else {
                    bVar = new C0041b(aVar2, handler);
                }
                synchronized (f2505c) {
                    b.e.g<String, ArrayList<c.d<g>>> gVar = f2506d;
                    ArrayList<c.d<g>> arrayList = gVar.get(str);
                    if (arrayList != null) {
                        if (bVar != null) {
                            arrayList.add(bVar);
                        }
                        return null;
                    }
                    if (bVar != null) {
                        ArrayList<c.d<g>> arrayList2 = new ArrayList<>();
                        arrayList2.add(bVar);
                        gVar.put(str, arrayList2);
                    }
                    f2504b.d(aVar3, new c(str));
                    return null;
                }
            }
        } else {
            g f2 = f(context, aVar, i3);
            if (aVar2 != null) {
                int i4 = f2.f2523b;
                if (i4 == 0) {
                    aVar2.b(f2.f2522a, handler);
                } else {
                    aVar2.a(i4, handler);
                }
            }
            return f2.f2522a;
        }
    }

    public static ProviderInfo h(PackageManager packageManager, a aVar, Resources resources) {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
        } else if (resolveContentProvider.packageName.equals(aVar.e())) {
            List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f2507e);
            List<List<byte[]>> d3 = d(aVar, resources);
            for (int i2 = 0; i2 < d3.size(); i2++) {
                ArrayList arrayList = new ArrayList(d3.get(i2));
                Collections.sort(arrayList, f2507e);
                if (b(a2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, k.f(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
