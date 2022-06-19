package com.esafirm.imagepicker.features;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import c.c.a.i.b;
import com.esafirm.imagepicker.features.u.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageFileLoader */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Context f4526a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f4527b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f4528c = {"_id", "_display_name", "_data", "bucket_display_name"};

    /* access modifiers changed from: private */
    /* compiled from: ImageFileLoader */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f4529b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4530c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4531d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<File> f4532e;

        /* renamed from: f  reason: collision with root package name */
        private c f4533f;

        public a(boolean z, boolean z2, boolean z3, ArrayList<File> arrayList, c cVar) {
            this.f4529b = z;
            this.f4530c = z2;
            this.f4531d = z3;
            this.f4532e = arrayList;
            this.f4533f = cVar;
        }

        public void run() {
            Cursor cursor;
            ArrayList<File> arrayList;
            if (this.f4530c) {
                cursor = k.this.f4526a.getContentResolver().query(MediaStore.Files.getContentUri("external"), k.this.f4528c, "media_type=1 OR media_type=3", null, "date_added");
            } else {
                cursor = k.this.f4526a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, k.this.f4528c, null, null, "date_added");
            }
            if (cursor == null) {
                this.f4533f.a(new NullPointerException());
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = null;
            HashMap hashMap = this.f4529b ? new HashMap() : null;
            if (cursor.moveToLast()) {
                do {
                    long j2 = cursor.getLong(cursor.getColumnIndex(k.this.f4528c[0]));
                    String string = cursor.getString(cursor.getColumnIndex(k.this.f4528c[1]));
                    String string2 = cursor.getString(cursor.getColumnIndex(k.this.f4528c[2]));
                    String string3 = cursor.getString(cursor.getColumnIndex(k.this.f4528c[3]));
                    File g2 = k.g(string2);
                    if (g2 != null && ((arrayList = this.f4532e) == null || !arrayList.contains(g2))) {
                        b bVar = new b(j2, string, string2);
                        if (this.f4531d || !com.esafirm.imagepicker.helper.c.e(bVar)) {
                            arrayList2.add(bVar);
                            if (hashMap != null) {
                                c.c.a.i.a aVar = (c.c.a.i.a) hashMap.get(string3);
                                if (aVar == null) {
                                    aVar = new c.c.a.i.a(string3);
                                    hashMap.put(string3, aVar);
                                }
                                aVar.b().add(bVar);
                            }
                        }
                    }
                } while (cursor.moveToPrevious());
            }
            cursor.close();
            if (hashMap != null) {
                arrayList3 = new ArrayList(hashMap.values());
            }
            this.f4533f.b(arrayList2, arrayList3);
        }
    }

    public k(Context context) {
        this.f4526a = context;
    }

    private ExecutorService e() {
        if (this.f4527b == null) {
            this.f4527b = Executors.newSingleThreadExecutor();
        }
        return this.f4527b;
    }

    /* access modifiers changed from: private */
    public static File g(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return new File(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void a() {
        ExecutorService executorService = this.f4527b;
        if (executorService != null) {
            executorService.shutdown();
            this.f4527b = null;
        }
    }

    public void f(boolean z, boolean z2, boolean z3, ArrayList<File> arrayList, c cVar) {
        e().execute(new a(z, z2, z3, arrayList, cVar));
    }
}
