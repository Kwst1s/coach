package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import f.a.a.a.b.d.i;
import f.a.a.a.b.d.j;
import java.util.ArrayList;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DBHelperGoals.kt */
public final class v extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final String f10144b = "GOALS";

    /* renamed from: c  reason: collision with root package name */
    private final String f10145c = "id";

    /* renamed from: d  reason: collision with root package name */
    private final String f10146d = "name";

    /* renamed from: e  reason: collision with root package name */
    private final String f10147e = "success_array";

    /* renamed from: f  reason: collision with root package name */
    private final String f10148f = "last_edit";

    /* renamed from: g  reason: collision with root package name */
    private final String f10149g = "goal_order";

    /* renamed from: h  reason: collision with root package name */
    private final String f10150h = ("CREATE TABLE " + "GOALS" + " ( " + "id" + " INTEGER PRIMARY KEY, " + "name" + " TEXT, " + "success_array" + " TEXT, " + "last_edit" + " LONG, " + "goal_order" + " INTEGER)");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Context context) {
        super(context, w.a(), (SQLiteDatabase.CursorFactory) null, w.b());
        f.e(context, "context");
    }

    private final i L(Cursor cursor) {
        int i2 = cursor.getInt(0);
        String string = cursor.getString(1);
        String string2 = cursor.getString(2);
        long j2 = cursor.getLong(3);
        int i3 = cursor.getInt(4);
        f.d(string, "content");
        return new i(i2, string, F(string2), j2, i3);
    }

    public final void E(Context context) {
        f.e(context, "context");
        context.deleteDatabase(w.a());
    }

    public final ArrayList<j> F(String str) {
        if (str == null) {
            return null;
        }
        try {
            ArrayList<j> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new j(jSONObject.getLong("date"), jSONObject.getInt("perc")));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void G(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str = this.f10144b;
        writableDatabase.delete(str, this.f10145c + " = " + i2, null);
        writableDatabase.close();
    }

    public final void H(i iVar) {
        f.e(iVar, "goal");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10146d, iVar.a());
        contentValues.put(this.f10148f, Long.valueOf(iVar.d()));
        contentValues.put(this.f10147e, N(iVar.f()));
        String str = this.f10144b;
        writableDatabase.update(str, contentValues, this.f10145c + " = " + String.valueOf(iVar.c()), null);
        writableDatabase.close();
    }

    public final void I(i iVar, int i2) {
        f.e(iVar, "goal");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10149g, Integer.valueOf(i2));
        String str = this.f10144b;
        writableDatabase.update(str, contentValues, this.f10145c + " = " + String.valueOf(iVar.c()), null);
        writableDatabase.close();
    }

    public final ArrayList<i> J() {
        ArrayList<i> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + this.f10144b, null);
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

    public final int K(SQLiteDatabase sQLiteDatabase) {
        f.e(sQLiteDatabase, "db");
        return (int) DatabaseUtils.queryNumEntries(sQLiteDatabase, this.f10144b);
    }

    public final boolean M() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long queryNumEntries = DatabaseUtils.queryNumEntries(writableDatabase, this.f10144b);
        writableDatabase.close();
        return queryNumEntries > 0;
    }

    public final String N(ArrayList<j> arrayList) {
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = arrayList.get(i2);
            f.d(jVar, "successes[i]");
            j jVar2 = jVar;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("perc", jVar2.c());
                jSONObject.put("date", jVar2.a());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public final void l(i iVar) {
        f.e(iVar, "goal");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f10146d, iVar.a());
        contentValues.put(this.f10147e, N(iVar.f()));
        contentValues.put(this.f10148f, Long.valueOf(System.currentTimeMillis()));
        String str = this.f10149g;
        f.d(writableDatabase, "db");
        contentValues.put(str, Integer.valueOf(K(writableDatabase)));
        writableDatabase.insert(this.f10144b, null, contentValues);
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(this.f10150h);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f10144b);
        }
    }
}
