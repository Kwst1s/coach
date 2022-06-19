package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import android.util.Log;

/* compiled from: DownloadsDB */
public class g {

    /* renamed from: h  reason: collision with root package name */
    private static g f8200h;

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f8201i = {"FN", "URI", "ETAG", "TOTALBYTES", "CURRENTBYTES", "LASTMOD", "STATUS", "CONTROL", "FAILCOUNT", "RETRYAFTER", "REDIRECTCOUNT", "FILEIDX"};

    /* renamed from: a  reason: collision with root package name */
    final SQLiteOpenHelper f8202a;

    /* renamed from: b  reason: collision with root package name */
    SQLiteStatement f8203b;

    /* renamed from: c  reason: collision with root package name */
    SQLiteStatement f8204c;

    /* renamed from: d  reason: collision with root package name */
    long f8205d = -1;

    /* renamed from: e  reason: collision with root package name */
    int f8206e = -1;

    /* renamed from: f  reason: collision with root package name */
    int f8207f = -1;

    /* renamed from: g  reason: collision with root package name */
    int f8208g;

    /* compiled from: DownloadsDB */
    public static class a implements BaseColumns {

        /* renamed from: a  reason: collision with root package name */
        public static final String[][] f8209a = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"FILEIDX", "INTEGER UNIQUE"}, new String[]{"URI", "TEXT"}, new String[]{"FN", "TEXT UNIQUE"}, new String[]{"ETAG", "TEXT"}, new String[]{"TOTALBYTES", "INTEGER"}, new String[]{"CURRENTBYTES", "INTEGER"}, new String[]{"LASTMOD", "INTEGER"}, new String[]{"STATUS", "INTEGER"}, new String[]{"CONTROL", "INTEGER"}, new String[]{"FAILCOUNT", "INTEGER"}, new String[]{"RETRYAFTER", "INTEGER"}, new String[]{"REDIRECTCOUNT", "INTEGER"}};
    }

    /* compiled from: DownloadsDB */
    protected static class b extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        private static final String[][][] f8210b = {a.f8209a, c.f8212a};

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f8211c = {"DownloadColumns", "MetadataColumns"};

        b(Context context) {
            super(context, "DownloadsDB", (SQLiteDatabase.CursorFactory) null, 7);
        }

        private void E(SQLiteDatabase sQLiteDatabase) {
            String[] strArr = f8211c;
            for (String str : strArr) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        private String l(String str, String[][] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" (");
            for (String[] strArr2 : strArr) {
                sb.append(' ');
                sb.append(strArr2[0]);
                sb.append(' ');
                sb.append(strArr2[1]);
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(");");
            return sb.toString();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            int length = f8210b.length;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    sQLiteDatabase.execSQL(l(f8211c[i2], f8210b[i2]));
                } catch (Exception e2) {
                    while (true) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            String name = b.class.getName();
            Log.w(name, "Upgrading database from version " + i2 + " to " + i3 + ", which will destroy all old data");
            E(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* compiled from: DownloadsDB */
    public static class c implements BaseColumns {

        /* renamed from: a  reason: collision with root package name */
        public static final String[][] f8212a = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"APKVERSION", "INTEGER"}, new String[]{"DOWNLOADSTATUS", "INTEGER"}, new String[]{"DOWNLOADFLAGS", "INTEGER"}};
    }

    private g(Context context) {
        b bVar = new b(context);
        this.f8202a = bVar;
        Cursor rawQuery = bVar.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            this.f8206e = rawQuery.getInt(0);
            this.f8205d = rawQuery.getLong(1);
            this.f8207f = rawQuery.getInt(2);
            this.f8208g = rawQuery.getInt(3);
            rawQuery.close();
        }
        f8200h = this;
    }

    public static synchronized g a(Context context) {
        synchronized (g.class) {
            g gVar = f8200h;
            if (gVar != null) {
                return gVar;
            }
            return new g(context);
        }
    }

    private SQLiteStatement b() {
        if (this.f8203b == null) {
            this.f8203b = this.f8202a.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        return this.f8203b;
    }

    private SQLiteStatement h() {
        if (this.f8204c == null) {
            this.f8204c = this.f8202a.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
        }
        return this.f8204c;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.vending.expansion.downloader.impl.d c(java.lang.String r11) {
        /*
            r10 = this;
            android.database.sqlite.SQLiteOpenHelper r0 = r10.f8202a
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()
            r0 = 0
            java.lang.String r2 = "DownloadColumns"
            java.lang.String[] r3 = com.google.android.vending.expansion.downloader.impl.g.f8201i     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = "FN = ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0034 }
            r6 = 0
            r5[r6] = r11     // Catch:{ all -> 0x0034 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0034 }
            if (r11 == 0) goto L_0x002e
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002e
            com.google.android.vending.expansion.downloader.impl.d r0 = r10.d(r11)     // Catch:{ all -> 0x002c }
            if (r11 == 0) goto L_0x002b
            r11.close()
        L_0x002b:
            return r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0038
        L_0x002e:
            if (r11 == 0) goto L_0x0033
            r11.close()
        L_0x0033:
            return r0
        L_0x0034:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0038:
            if (r11 == 0) goto L_0x003d
            r11.close()
        L_0x003d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.g.c(java.lang.String):com.google.android.vending.expansion.downloader.impl.d");
    }

    public d d(Cursor cursor) {
        d dVar = new d(cursor.getInt(11), cursor.getString(0), g.class.getPackage().getName());
        i(dVar, cursor);
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.vending.expansion.downloader.impl.d[] e() {
        /*
            r10 = this;
            android.database.sqlite.SQLiteOpenHelper r0 = r10.f8202a
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()
            r0 = 0
            java.lang.String r2 = "DownloadColumns"
            java.lang.String[] r3 = com.google.android.vending.expansion.downloader.impl.g.f8201i     // Catch:{ all -> 0x0041 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x003b
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x003b
            int r0 = r1.getCount()     // Catch:{ all -> 0x0039 }
            com.google.android.vending.expansion.downloader.impl.d[] r0 = new com.google.android.vending.expansion.downloader.impl.d[r0]     // Catch:{ all -> 0x0039 }
            r2 = 0
        L_0x0023:
            com.google.android.vending.expansion.downloader.impl.d r3 = r10.d(r1)     // Catch:{ all -> 0x0039 }
            int r4 = r2 + 1
            r0[r2] = r3     // Catch:{ all -> 0x0039 }
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0037
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            r2 = r4
            goto L_0x0023
        L_0x0039:
            r0 = move-exception
            goto L_0x0045
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            return r0
        L_0x0041:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x0045:
            if (r1 == 0) goto L_0x004a
            r1.close()
        L_0x004a:
            goto L_0x004c
        L_0x004b:
            throw r0
        L_0x004c:
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.g.e():com.google.android.vending.expansion.downloader.impl.d[]");
    }

    public long f(int i2) {
        SQLiteStatement b2 = b();
        b2.clearBindings();
        b2.bindLong(1, (long) i2);
        try {
            return b2.simpleQueryForLong();
        } catch (SQLiteDoneException unused) {
            return -1;
        }
    }

    public long g(d dVar) {
        return f(dVar.f8156b);
    }

    public void i(d dVar, Cursor cursor) {
        dVar.f8155a = cursor.getString(1);
        dVar.f8158d = cursor.getString(2);
        dVar.f8159e = cursor.getLong(3);
        dVar.f8160f = cursor.getLong(4);
        dVar.f8161g = cursor.getLong(5);
        dVar.f8162h = cursor.getInt(6);
        dVar.f8163i = cursor.getInt(7);
        dVar.f8164j = cursor.getInt(8);
        dVar.f8165k = cursor.getInt(9);
        dVar.l = cursor.getInt(10);
    }

    public boolean j(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FILEIDX", Integer.valueOf(dVar.f8156b));
        contentValues.put("FN", dVar.f8157c);
        contentValues.put("URI", dVar.f8155a);
        contentValues.put("ETAG", dVar.f8158d);
        contentValues.put("TOTALBYTES", Long.valueOf(dVar.f8159e));
        contentValues.put("CURRENTBYTES", Long.valueOf(dVar.f8160f));
        contentValues.put("LASTMOD", Long.valueOf(dVar.f8161g));
        contentValues.put("STATUS", Integer.valueOf(dVar.f8162h));
        contentValues.put("CONTROL", Integer.valueOf(dVar.f8163i));
        contentValues.put("FAILCOUNT", Integer.valueOf(dVar.f8164j));
        contentValues.put("RETRYAFTER", Integer.valueOf(dVar.f8165k));
        contentValues.put("REDIRECTCOUNT", Integer.valueOf(dVar.l));
        return k(dVar, contentValues);
    }

    public boolean k(d dVar, ContentValues contentValues) {
        long g2 = dVar == null ? -1 : g(dVar);
        try {
            SQLiteDatabase writableDatabase = this.f8202a.getWritableDatabase();
            if (g2 != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("DownloadColumns._id = ");
                sb.append(g2);
                return 1 != writableDatabase.update("DownloadColumns", contentValues, sb.toString(), null) ? false : false;
            } else if (-1 != writableDatabase.insert("DownloadColumns", "URI", contentValues)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public void l(d dVar) {
        SQLiteStatement h2 = h();
        h2.clearBindings();
        h2.bindLong(1, dVar.f8160f);
        h2.bindLong(2, (long) dVar.f8156b);
        h2.execute();
    }

    public boolean m(int i2) {
        if (this.f8208g == i2) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADFLAGS", Integer.valueOf(i2));
        if (!p(contentValues)) {
            return false;
        }
        this.f8208g = i2;
        return true;
    }

    public boolean n(d dVar) {
        SQLiteDatabase readableDatabase = this.f8202a.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = readableDatabase.query("DownloadColumns", f8201i, "FN= ?", new String[]{dVar.f8157c}, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            i(dVar, cursor);
            return true;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public boolean o(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("APKVERSION", Integer.valueOf(i2));
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i3));
        if (!p(contentValues)) {
            return false;
        }
        this.f8206e = i2;
        this.f8207f = i3;
        return true;
    }

    public boolean p(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f8202a.getWritableDatabase();
        if (-1 == this.f8205d) {
            long insert = writableDatabase.insert("MetadataColumns", "APKVERSION", contentValues);
            if (-1 == insert) {
                return false;
            }
            this.f8205d = insert;
            return true;
        }
        if (writableDatabase.update("MetadataColumns", contentValues, "_id = " + this.f8205d, null) == 0) {
            return false;
        }
        return true;
    }

    public boolean q(int i2) {
        if (this.f8207f == i2) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i2));
        if (!p(contentValues)) {
            return false;
        }
        this.f8207f = i2;
        return true;
    }
}
