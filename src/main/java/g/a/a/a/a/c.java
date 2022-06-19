package g.a.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.m.b.f;

/* compiled from: MBCachingHelper.kt */
public final class c extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final String f9759b = "requests";

    /* renamed from: c  reason: collision with root package name */
    private final String f9760c = "api";

    /* renamed from: d  reason: collision with root package name */
    private final String f9761d = "response";

    /* renamed from: e  reason: collision with root package name */
    private final String f9762e = "time";

    /* renamed from: f  reason: collision with root package name */
    private final String f9763f = ("CREATE TABLE " + "requests" + " ( " + "api" + " TEXT PRIMARY KEY, " + "response" + " TEXT, " + "time" + " TEXT)");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, d.a(), (SQLiteDatabase.CursorFactory) null, d.b());
        f.f(context, "context");
    }

    private final ContentValues E(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f9760c, str);
        contentValues.put(this.f9761d, str2);
        contentValues.put(this.f9762e, Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    private final int F(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str2 = this.f9759b;
        return writableDatabase.delete(str2, this.f9760c + " = '" + str + '\'', null);
    }

    private final boolean I(long j2) {
        return System.currentTimeMillis() - j2 <= g.a.a.a.a.f.c.f9785f.c();
    }

    public final String G(String str) {
        String string;
        f.f(str, "api");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str2 = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + this.f9759b + " WHERE " + this.f9760c + " = '" + str + '\'', null);
        if (rawQuery.moveToFirst()) {
            do {
                string = rawQuery.getString(1);
                if (!I(rawQuery.getLong(2))) {
                    F(str);
                    string = null;
                }
            } while (rawQuery.moveToNext());
            str2 = string;
        }
        rawQuery.close();
        writableDatabase.close();
        return str2;
    }

    public final boolean H(String str) {
        f.f(str, "api");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("Select * from " + this.f9759b + " where " + this.f9760c + " = '" + str + '\'', null);
        f.b(rawQuery, "cursor");
        if (rawQuery.getCount() <= 0) {
            rawQuery.close();
            return false;
        }
        rawQuery.close();
        return true;
    }

    public final void l(String str, String str2) {
        f.f(str, "api");
        f.f(str2, "result");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues E = E(str, str2);
        if (!H(str)) {
            writableDatabase.insert(this.f9759b, null, E);
        } else {
            String str3 = this.f9759b;
            writableDatabase.update(str3, E, this.f9760c + " = '" + str + '\'', null);
        }
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.f(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL(this.f9763f);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        f.f(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f9759b);
    }
}
