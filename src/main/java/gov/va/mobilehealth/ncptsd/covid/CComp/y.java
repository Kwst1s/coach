package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import f.a.a.a.b.d.a;
import f.a.a.a.b.d.s;
import java.util.ArrayList;
import kotlin.m.b.f;

/* compiled from: DBHelperKT.kt */
public final class y extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final String f10155b = "REWARDING_GOOD_BEHAVIOR";

    /* renamed from: c  reason: collision with root package name */
    private final String f10156c = "id";

    /* renamed from: d  reason: collision with root package name */
    private final String f10157d = "reward";

    /* renamed from: e  reason: collision with root package name */
    private final String f10158e = "can_use";

    /* renamed from: f  reason: collision with root package name */
    private final String f10159f = "date";

    /* renamed from: g  reason: collision with root package name */
    private final String f10160g = "appreciation";

    /* renamed from: h  reason: collision with root package name */
    private final String f10161h = "_id";

    /* renamed from: i  reason: collision with root package name */
    private final String f10162i = "content";

    /* renamed from: j  reason: collision with root package name */
    private final String f10163j = "img";

    /* renamed from: k  reason: collision with root package name */
    private final String f10164k = ("CREATE TABLE " + "REWARDING_GOOD_BEHAVIOR" + " ( " + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "reward" + " TEXT, " + "can_use" + " TEXT, " + "date" + " LONG)");
    private final String l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(Context context) {
        super(context, x.a(), (SQLiteDatabase.CursorFactory) null, x.b());
        f.e(context, "context");
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append("appreciation");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("content");
        sb.append(" TEXT, ");
        sb.append("img");
        sb.append(" TEXT)");
        this.l = sb.toString();
    }

    private final ContentValues F(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10162i, str);
        if (str2 != null) {
            contentValues.put(this.f10163j, str2);
        }
        return contentValues;
    }

    private final a L(Cursor cursor) {
        int i2 = cursor.getInt(0);
        String string = cursor.getString(1);
        f.d(string, "cursor.getString(1)");
        return new a(i2, string, cursor.getString(2));
    }

    public final void E(String str, String str2) {
        f.e(str, "content");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert(this.f10160g, null, F(str, str2));
        writableDatabase.close();
    }

    public final void G(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str = this.f10160g;
        writableDatabase.delete(str, this.f10161h + " = " + i2, null);
        writableDatabase.close();
    }

    public final void H(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str = this.f10155b;
        writableDatabase.delete(str, this.f10156c + " = " + i2, null);
        writableDatabase.close();
    }

    public final void I(a aVar) {
        f.e(aVar, "appreciation");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10162i, aVar.a());
        contentValues.put(this.f10163j, aVar.d());
        String str = this.f10160g;
        writableDatabase.update(str, contentValues, this.f10161h + " = " + String.valueOf(aVar.c()), null);
        writableDatabase.close();
    }

    public final ArrayList<a> J() {
        ArrayList<a> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + this.f10160g + " ORDER BY " + this.f10161h + " DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                f.d(rawQuery, "cursor");
                arrayList.add(L(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public final ArrayList<s> K() {
        ArrayList<s> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + this.f10155b + ' ' + "ORDER BY " + this.f10159f + " DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                f.d(rawQuery, "cursor");
                arrayList.add(M(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public final s M(Cursor cursor) {
        f.e(cursor, "cursor");
        return new s(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getLong(3));
    }

    public final void N(int i2, String str, String str2) {
        f.e(str, "things_to_reward");
        f.e(str2, "reward_can_use");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10157d, str);
        contentValues.put(this.f10158e, str2);
        contentValues.put(this.f10159f, Long.valueOf(System.currentTimeMillis()));
        String str3 = this.f10155b;
        writableDatabase.update(str3, contentValues, this.f10156c + " = " + i2, null);
        writableDatabase.close();
    }

    public final void l(String str, String str2) {
        f.e(str, "things_to_reward");
        f.e(str2, "reward_can_use");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10157d, str);
        contentValues.put(this.f10158e, str2);
        contentValues.put(this.f10159f, Long.valueOf(System.currentTimeMillis()));
        writableDatabase.insert(this.f10155b, null, contentValues);
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(this.f10164k);
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(this.l);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f10155b);
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f10160g);
        }
    }
}
