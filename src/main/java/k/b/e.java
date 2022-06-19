package k.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import k.c.a;
import k.c.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TrackingDBHelper */
public class e extends SQLiteOpenHelper {
    public e(Context context) {
        super(context, "trackingData.sqlite", (SQLiteDatabase.CursorFactory) null, 3);
    }

    private ContentValues F(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.d());
        contentValues.put("type", aVar.f());
        contentValues.put("timestamp", Long.valueOf(aVar.e()));
        if (aVar.g()) {
            contentValues.put("sending", (Integer) 1);
        } else {
            contentValues.put("sending", (Integer) 0);
        }
        if (aVar.a() != null) {
            contentValues.put("additional_data", aVar.a().toString());
        }
        return contentValues;
    }

    private ContentValues G(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event", bVar.a());
        contentValues.put("metadata", bVar.e());
        contentValues.put("platform", bVar.f());
        contentValues.put("timestamp", Long.valueOf(bVar.h()));
        contentValues.put("invite_code", bVar.i());
        contentValues.put("subject_id", bVar.g());
        if (bVar.j()) {
            contentValues.put("sending", (Integer) 1);
        } else {
            contentValues.put("sending", (Integer) 0);
        }
        contentValues.put("filter_event", bVar.c());
        return contentValues;
    }

    public void E(b bVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("events", null, G(bVar));
        writableDatabase.close();
    }

    public void H(ArrayList<b> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuilder sb = new StringBuilder("(");
        int i2 = 0;
        while (i2 < arrayList.size()) {
            sb.append(arrayList.get(i2).d());
            i2++;
            if (i2 != arrayList.size()) {
                sb.append(",");
            }
        }
        sb.append(")");
        writableDatabase.delete("events", "_id IN " + sb.toString(), null);
        writableDatabase.close();
    }

    public ArrayList<a> I() {
        ArrayList<a> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM data_events WHERE sending = 0 ORDER BY timestamp", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(K(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> J() {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM events WHERE sending = 0 ORDER BY timestamp", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(L(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public a K(Cursor cursor) {
        long j2 = cursor.getLong(0);
        String string = cursor.getString(1);
        long j3 = cursor.getLong(2);
        String string2 = cursor.getString(3);
        String string3 = cursor.getString(4);
        if (string3 == null) {
            return new a(j2, string, string2, j3, null);
        }
        try {
            return new a(j2, string, string2, j3, new JSONObject(string3));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new a(j2, string, string2, j3, null);
        }
    }

    public b L(Cursor cursor) {
        return new b(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(5), cursor.getString(6), cursor.getLong(4), cursor.getInt(7) == 1, cursor.getString(8));
    }

    public void M(ArrayList<b> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sending", (Integer) 0);
            writableDatabase.update("events", contentValues, "_id = " + arrayList.get(i2).d(), null);
        }
        writableDatabase.close();
    }

    public void N(ArrayList<a> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sending", (Integer) 1);
            writableDatabase.update("data_events", contentValues, "_id = " + arrayList.get(i2).c(), null);
        }
        writableDatabase.close();
    }

    public void O(ArrayList<b> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sending", (Integer) 1);
            writableDatabase.update("events", contentValues, "_id = " + arrayList.get(i2).d(), null);
        }
        writableDatabase.close();
    }

    public void l(a aVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("data_events", null, F(aVar));
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT, metadata TEXT, platform TEXT, timestamp LONG, invite_code TEXT, subject_id TEXT, sending INTEGER, filter_event TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE data_events ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, timestamp LONG, type TEXT, additional_data TEXT, sending INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS data_events");
        onCreate(sQLiteDatabase);
    }
}
