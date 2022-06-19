package k.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: AMDb_helper */
public class d extends SQLiteOpenHelper {
    public d(Context context) {
        super(context, "requests.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private ContentValues F(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", Long.valueOf(eVar.c()));
        contentValues.put("api", eVar.a());
        contentValues.put("type", Integer.valueOf(eVar.d()));
        contentValues.put("params", eVar.b());
        return contentValues;
    }

    private ContentValues G(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("api_params", fVar.c());
        contentValues.put("time", Long.valueOf(fVar.e()));
        contentValues.put("api", fVar.a());
        contentValues.put("type", Integer.valueOf(fVar.f()));
        contentValues.put("payload", fVar.d());
        return contentValues;
    }

    private f I(Cursor cursor) {
        f fVar = new f();
        fVar.h(cursor.getString(0));
        fVar.j(cursor.getLong(1));
        fVar.g(cursor.getString(2));
        fVar.k(cursor.getInt(3));
        fVar.i(cursor.getString(4));
        return fVar;
    }

    public void E(f fVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues G = G(fVar);
        if (J(fVar.c())) {
            writableDatabase.update("RESULTS", G, "api_params =? ", new String[]{fVar.c()});
        } else {
            writableDatabase.insert("RESULTS", null, G);
        }
        writableDatabase.close();
    }

    public f H(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        f fVar = new f();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM RESULTS WHERE api_params = " + str, null);
        if (rawQuery.moveToFirst()) {
            do {
                fVar = I(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        if (System.currentTimeMillis() - fVar.e() > c.f10722i) {
            K(str);
            return null;
        }
        writableDatabase.close();
        return fVar;
    }

    public boolean J(String str) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT 1 FROM RESULTS WHERE api_params =? ", new String[]{str});
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        return moveToFirst;
    }

    public void K(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("RESULTS", "api_params = " + str, null);
        writableDatabase.close();
    }

    public void l(e eVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("REQUESTS", null, F(eVar));
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE REQUESTS(time LONG PRIMARY KEY,api TEXT,type INTEGER,params TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE RESULTS(api_params TEXT PRIMARY KEY,time LONG,api TEXT,type TEXT,payload TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS REQUESTS");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS RESULTS");
    }
}
