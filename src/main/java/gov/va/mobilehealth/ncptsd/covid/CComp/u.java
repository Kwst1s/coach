package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import f.a.a.a.b.d.b;
import f.a.a.a.b.d.g;
import f.a.a.a.b.d.h;
import f.a.a.a.b.d.l;
import f.a.a.a.b.d.m;
import f.a.a.a.b.d.o;
import f.a.a.a.b.d.p;
import f.a.a.a.b.d.q;
import f.a.a.a.b.d.w;
import f.a.a.a.b.d.x;
import f.a.a.a.b.d.y;
import f.a.a.a.b.d.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DBHelper */
public class u extends SQLiteOpenHelper {
    public u(Context context) {
        super(context, "userdata.sqlite", (SQLiteDatabase.CursorFactory) null, 3);
    }

    private b B0(Cursor cursor) {
        b bVar = new b();
        bVar.e(cursor.getLong(0));
        bVar.g(b0(cursor.getString(1)));
        bVar.f(cursor.getInt(2));
        return bVar;
    }

    private y C0(Cursor cursor) {
        y yVar = new y();
        yVar.d(cursor.getString(0));
        yVar.e(cursor.getString(1));
        return yVar;
    }

    private g D0(Cursor cursor) {
        g gVar = new g();
        gVar.h(cursor.getInt(0) + g.W);
        gVar.k(cursor.getString(1));
        gVar.j(cursor.getString(2));
        gVar.g(cursor.getString(3));
        String string = cursor.getString(4);
        if (string != null) {
            gVar.i(Uri.parse(string));
        }
        return gVar;
    }

    private ArrayList<Integer> E0(Cursor cursor) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String string = cursor.getString(1);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(Integer.valueOf(jSONArray.getInt(i2)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private o F0(Cursor cursor) {
        o oVar = new o(c0(cursor.getString(1)), cursor.getInt(2), cursor.getLong(3));
        oVar.f(cursor.getInt(0));
        return oVar;
    }

    private m G0(Cursor cursor) {
        return new m(cursor.getString(0), cursor.getString(1));
    }

    private l H0(Cursor cursor) {
        return new l(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
    }

    private z I0(Cursor cursor) {
        z zVar = new z();
        zVar.h(cursor.getString(0));
        zVar.i(cursor.getString(1));
        zVar.f(cursor.getString(2));
        return zVar;
    }

    private q J0(Cursor cursor) {
        q qVar = new q();
        qVar.g(cursor.getLong(0));
        qVar.i(cursor.getString(1));
        qVar.f(cursor.getString(2));
        qVar.h(cursor.getString(3));
        return qVar;
    }

    private w K0(Cursor cursor) {
        return new w(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
    }

    private ContentValues Q(b bVar, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("millis", Long.valueOf(bVar.a()));
        contentValues.put("q_answers", a0(bVar.d()));
        contentValues.put("points", Integer.valueOf(bVar.c()));
        contentValues.put("type", Integer.valueOf(i2));
        return contentValues;
    }

    private ContentValues R(y yVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", yVar.a());
        contentValues.put("name", yVar.c());
        return contentValues;
    }

    private ContentValues S(Context context, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", gVar.f());
        contentValues.put("title", gVar.e());
        contentValues.put("caption", gVar.a());
        if (gVar.d() != null) {
            if (gVar.f().equals(g.a0)) {
                String f2 = s.f(context, gVar.d());
                if (f2 != null) {
                    contentValues.put("uri", f2);
                } else {
                    contentValues.put("uri", gVar.d().toString());
                }
            } else {
                contentValues.put("uri", gVar.d().toString());
            }
        }
        return contentValues;
    }

    private ContentValues T(Context context, Uri uri, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uri", uri.toString());
        contentValues.put("alt_text", str);
        return contentValues;
    }

    private ContentValues U(Uri uri, String str) {
        ContentValues contentValues = new ContentValues();
        String uri2 = uri.toString();
        if (uri2 != null) {
            contentValues.put("uri", uri2);
        } else {
            contentValues.put("uri", uri.toString());
        }
        contentValues.put("alt_text", str);
        return contentValues;
    }

    private ContentValues V(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("affect", str);
        contentValues.put("feel", str2);
        contentValues.put("because", str3);
        return contentValues;
    }

    private ContentValues W(z zVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uri", zVar.d().toString());
        contentValues.put("title", zVar.c());
        contentValues.put("artist", zVar.a());
        return contentValues;
    }

    private ContentValues X(ArrayList<h> arrayList, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("feelings", L0(arrayList));
        contentValues.put("intensity", Integer.valueOf(i2));
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    private ContentValues Y(q qVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("millis", Long.valueOf(qVar.c()));
        contentValues.put("what_triggered", qVar.e());
        contentValues.put("how_different", qVar.a());
        contentValues.put("what_to_do_now", qVar.d());
        return contentValues;
    }

    private ContentValues Z(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", str);
        contentValues.put("img", str2);
        return contentValues;
    }

    public b A0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        b bVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM assessment WHERE type = " + i2 + " ORDER BY " + "millis" + " DESC LIMIT 1", null);
        if (rawQuery.moveToFirst()) {
            do {
                bVar = B0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return bVar;
    }

    public void E(y yVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("contacts", null, R(yVar));
        writableDatabase.close();
    }

    public void F(Context context, g gVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("custom_tools", null, S(context, gVar));
        writableDatabase.close();
    }

    public void G(int i2, ArrayList<Integer> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tool_code", Integer.valueOf(i2));
        contentValues.put("favorites", m.K(arrayList));
        writableDatabase.insert("favs_stars", null, contentValues);
        writableDatabase.close();
    }

    public void H(Context context, Uri uri, boolean z, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues T = T(context, uri, str);
        if (z) {
            writableDatabase.insert("s_images", null, T);
        } else {
            writableDatabase.insert("m_images", null, T);
        }
        writableDatabase.close();
    }

    public void I(Uri uri, boolean z, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues U = U(uri, str);
        if (z) {
            writableDatabase.insert("s_images", null, U);
        } else {
            writableDatabase.insert("m_images", null, U);
        }
        writableDatabase.close();
    }

    public void J(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("i_messages", null, V(str, str2, str3));
        writableDatabase.close();
    }

    public void K(z zVar, boolean z) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues W = W(zVar);
        if (z) {
            writableDatabase.insert("s_music", null, W);
        } else {
            writableDatabase.insert("m_music", null, W);
        }
        writableDatabase.close();
    }

    public void L(ArrayList<h> arrayList, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("my_feelings", null, X(arrayList, i2));
        writableDatabase.close();
    }

    public String L0(ArrayList<h> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                h hVar = arrayList.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", hVar.a());
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < hVar.c().size(); i3++) {
                    jSONArray2.put(hVar.c().get(i3).a());
                }
                jSONObject.put("subfeelings", jSONArray2);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void M(q qVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("rid", null, Y(qVar));
        writableDatabase.close();
    }

    public void N(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("strenghts", null, Z(str, str2));
        writableDatabase.close();
    }

    public void O(Context context) {
        context.deleteDatabase("userdata.sqlite");
    }

    public void P(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("assessment", "type=" + i2, null);
        writableDatabase.close();
    }

    public String a0(ArrayList<p> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("question", arrayList.get(i2).c());
                jSONObject.put("points", arrayList.get(i2).a());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList<p> b0(String str) {
        try {
            ArrayList<p> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(new p(jSONArray.getJSONObject(i2).getInt("question"), jSONArray.getJSONObject(i2).getInt("points")));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList<h> c0(String str) {
        try {
            ArrayList<h> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = jSONObject.getJSONArray("subfeelings");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList2.add(new x(jSONArray2.getString(i3)));
                }
                arrayList.add(new h(jSONObject.getString("name"), arrayList2));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void d0(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("contacts", "_id=" + str, null);
        writableDatabase.close();
    }

    public void e0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("custom_tools", "id=" + i2, null);
        writableDatabase.close();
    }

    public void f0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("my_feelings", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void g0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("i_messages", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void h0(String str, boolean z) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (z) {
            writableDatabase.delete("s_images", "uri LIKE '" + str + "'", null);
        } else {
            writableDatabase.delete("m_images", "uri LIKE '" + str + "'", null);
        }
        writableDatabase.close();
    }

    public void i0(String str, boolean z) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (z) {
            writableDatabase.delete("s_music", "uri LIKE '" + str + "'", null);
        } else {
            writableDatabase.delete("m_music", "uri LIKE '" + str + "'", null);
        }
        writableDatabase.close();
    }

    public void j0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("strenghts", "_id = " + i2, null);
        writableDatabase.close();
    }

    public void k0(int i2, ArrayList<Integer> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tool_code", Integer.valueOf(i2));
        contentValues.put("favorites", m.K(arrayList));
        writableDatabase.update("favs_stars", contentValues, "tool_code = " + i2, null);
        writableDatabase.close();
    }

    public void l(b bVar, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.insert("assessment", null, Q(bVar, i2));
        writableDatabase.close();
    }

    public void l0(l lVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("affect", lVar.a());
        contentValues.put("feel", lVar.d());
        contentValues.put("because", lVar.c());
        writableDatabase.update("i_messages", contentValues, "_id = " + lVar.e(), null);
        writableDatabase.close();
    }

    public void m0(w wVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", wVar.d());
        contentValues.put("img", wVar.c());
        writableDatabase.update("strenghts", contentValues, "_id = " + wVar.a(), null);
        writableDatabase.close();
    }

    public ArrayList<b> n0(int i2) {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM assessment WHERE type = " + i2, null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(B0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> o0(int i2) {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM assessment WHERE type = " + i2 + " ORDER BY " + "millis" + " DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(B0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE contacts ( _id TEXT PRIMARY KEY, name TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE s_images ( uri TEXT PRIMARY KEY, alt_text TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE s_music ( uri TEXT PRIMARY KEY, title TEXT, artist TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE m_images ( uri TEXT PRIMARY KEY, alt_text TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE m_music ( uri TEXT PRIMARY KEY, title TEXT, artist TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE assessment ( millis LONG PRIMARY KEY, q_answers TEXT, points INTEGER, type INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE rid ( millis LONG PRIMARY KEY, what_triggered TEXT, how_different TEXT, what_to_do_now TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE custom_tools ( id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, title TEXT, caption TEXT, uri TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE i_messages ( _id INTEGER PRIMARY KEY AUTOINCREMENT, affect TEXT, feel TEXT, because TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE strenghts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT, img TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE my_feelings ( _id INTEGER PRIMARY KEY AUTOINCREMENT, feelings TEXT, intensity INTEGER, date LONG)");
        sQLiteDatabase.execSQL("CREATE TABLE favs_stars ( tool_code INTEGER PRIMARY KEY, favorites TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            sQLiteDatabase.execSQL("CREATE TABLE i_messages ( _id INTEGER PRIMARY KEY AUTOINCREMENT, affect TEXT, feel TEXT, because TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE strenghts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT, img TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE my_feelings ( _id INTEGER PRIMARY KEY AUTOINCREMENT, feelings TEXT, intensity INTEGER, date LONG)");
        } else if (i2 != 2) {
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE favs_stars ( tool_code INTEGER PRIMARY KEY, favorites TEXT)");
        sQLiteDatabase.execSQL("ALTER TABLE s_images ADD COLUMN alt_text TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE m_images ADD COLUMN alt_text TEXT");
    }

    public ArrayList<y> p0() {
        ArrayList<y> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM contacts", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(C0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<g> q0() {
        ArrayList<g> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM custom_tools", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(D0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<m> r0(Context context, boolean z) {
        ArrayList<m> arrayList = new ArrayList<>();
        String str = z ? "SELECT * FROM s_images" : "SELECT * FROM m_images";
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery(str, null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(G0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String d2 = arrayList.get(i2).d();
            if (m.c1(context, d2)) {
                arrayList.get(i2).e(Uri.parse(arrayList.get(i2).d()));
            } else {
                h0(d2, z);
            }
        }
        return arrayList;
    }

    public ArrayList<l> s0() {
        ArrayList<l> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM i_messages ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(H0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<z> t0(Context context, boolean z) {
        ArrayList arrayList = new ArrayList();
        String str = z ? "SELECT * FROM s_music" : "SELECT * FROM m_music";
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery(str, null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(I0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        ArrayList<z> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            z zVar = (z) arrayList.get(i2);
            String b2 = zVar.b();
            if (m.c1(context, b2)) {
                arrayList2.add(new z(Uri.parse(zVar.b()), zVar.c(), zVar.a()));
            } else {
                i0(b2, z);
            }
        }
        return arrayList2;
    }

    public ArrayList<o> u0() {
        ArrayList<o> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM my_feelings ORDER BY date DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(F0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<b> v0() {
        ArrayList<b> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM assessment WHERE type = 124", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(B0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<q> w0() {
        ArrayList<q> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM rid ORDER BY millis DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(J0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<w> x0() {
        ArrayList<w> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM strenghts ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(K0(rawQuery));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public g y0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        g gVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM custom_tools WHERE id = " + i2, null);
        if (rawQuery.moveToFirst()) {
            do {
                gVar = D0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return gVar;
    }

    public ArrayList<Integer> z0(int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList<Integer> arrayList = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM favs_stars WHERE tool_code = " + i2 + " ", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList = E0(rawQuery);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        writableDatabase.close();
        return arrayList;
    }
}
