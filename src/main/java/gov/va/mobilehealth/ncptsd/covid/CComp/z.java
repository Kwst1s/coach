package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import f.a.a.a.b.e.a;
import f.a.a.a.b.e.b;
import f.a.a.a.b.e.c;
import f.a.a.a.b.e.d;
import f.a.a.a.b.e.e;
import java.util.ArrayList;

/* compiled from: DBHelper_SP */
public class z extends SQLiteOpenHelper {
    public z(Context context) {
        super(context, "userdata_sp.sqlite", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private a b0(Cursor cursor) {
        a aVar = new a();
        boolean z = false;
        aVar.g(cursor.getInt(0));
        aVar.h(cursor.getString(1));
        aVar.j(cursor.getInt(2));
        if (cursor.getInt(3) == 1) {
            z = true;
        }
        aVar.k(z);
        return aVar;
    }

    private d c0(Cursor cursor) {
        d dVar = new d();
        dVar.h(cursor.getInt(0));
        dVar.i(cursor.getString(1));
        dVar.g(cursor.getString(2));
        dVar.j(cursor.getString(3));
        dVar.k(cursor.getString(4));
        return dVar;
    }

    private b d0(Cursor cursor) {
        b bVar = new b();
        boolean z = false;
        bVar.h(cursor.getInt(0));
        bVar.i(cursor.getString(1));
        bVar.g(cursor.getInt(3));
        if (cursor.getInt(4) == 1) {
            z = true;
        }
        bVar.k(z);
        return bVar;
    }

    private c e0(Cursor cursor) {
        c cVar = new c();
        boolean z = false;
        cVar.f(cursor.getInt(0));
        cVar.g(cursor.getString(1));
        if (cursor.getInt(2) == 1) {
            z = true;
        }
        cVar.i(z);
        return cVar;
    }

    private e f0(Cursor cursor) {
        e eVar = new e();
        boolean z = false;
        eVar.f(cursor.getInt(0));
        eVar.g(cursor.getString(1));
        if (cursor.getInt(2) == 1) {
            z = true;
        }
        eVar.i(z);
        return eVar;
    }

    public void E(String str, int i2, int i3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("tool_id", Integer.valueOf(i2));
        contentValues.put("userCreated", Integer.valueOf(i3));
        writableDatabase.insert("coping_strategies", null, contentValues);
        writableDatabase.close();
    }

    public void F(String str, String str2, String str3, int i2, String str4) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("step", Integer.valueOf(i2));
        contentValues.put("contact_id", str2);
        contentValues.put("number", str3);
        contentValues.put("street", str4);
        writableDatabase.insert("contacts", null, contentValues);
        writableDatabase.close();
    }

    public void G(String str, int i2, int i3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("userCreated", (Integer) 0);
        contentValues.put("extra", Integer.valueOf(i2));
        contentValues.put("helpID", Integer.valueOf(i3));
        writableDatabase.insert("env_safe_ideas", null, contentValues);
        writableDatabase.close();
    }

    public void H(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("userCreated", (Integer) 1);
        contentValues.put("extra", (Integer) -1);
        contentValues.put("helpID", (Integer) -1);
        writableDatabase.insert("env_safe_ideas", null, contentValues);
        writableDatabase.close();
    }

    public void I(String str, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("userCreated", Integer.valueOf(i2));
        writableDatabase.insert("places", null, contentValues);
        writableDatabase.close();
    }

    public void J(String str, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("userCreated", Integer.valueOf(i2));
        writableDatabase.insert("ws", null, contentValues);
        writableDatabase.close();
    }

    public void K(Context context) {
        context.deleteDatabase("userdata_sp.sqlite");
    }

    public void L(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("coping_strategies", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void M(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("env_safe_ideas", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void N(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("places", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void O(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("ws", "_id = " + i2, null);
        writableDatabase.close();
    }

    public ArrayList<a> P() {
        ArrayList<a> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM coping_strategies ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(b0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<d> Q(int i2) {
        ArrayList<d> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM contacts WHERE step = " + i2 + " ORDER BY " + "_id" + " DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(c0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> R() {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM env_safe_ideas ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(d0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> S(int i2) {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM env_safe_ideas WHERE extra = " + i2 + " AND " + "userCreated" + " = " + 0 + " ORDER BY " + "_id" + " DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(d0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<c> T() {
        ArrayList<c> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM places ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(e0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> U() {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM env_safe_ideas WHERE userCreated = 1 ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(d0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<e> V() {
        ArrayList<e> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM ws ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(f0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public d W(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        d dVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM contacts WHERE step = " + i2 + " ORDER BY " + "_id" + " DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                dVar = c0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return dVar;
    }

    public a X() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        a aVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM coping_strategies ORDER BY _id DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                aVar = b0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return aVar;
    }

    public b Y() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        b bVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM env_safe_ideas ORDER BY _id DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                bVar = d0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return bVar;
    }

    public c Z() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        c cVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM places ORDER BY _id DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                cVar = e0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return cVar;
    }

    public e a0() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        e eVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM ws ORDER BY _id DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                eVar = f0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return eVar;
    }

    public void l(String str, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("tool_id", (Integer) -1);
        contentValues.put("userCreated", Integer.valueOf(i2));
        writableDatabase.insert("coping_strategies", null, contentValues);
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ws ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, userCreated INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE coping_strategies ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tool_id INTEGER, userCreated INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE contacts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, contact_id TEXT, number TEXT, street TEXT, step INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE places ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, userCreated INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE env_safe_ideas ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, extra INTEGER, helpID INTEGER, userCreated INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
