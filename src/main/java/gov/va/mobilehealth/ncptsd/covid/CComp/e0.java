package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import f.a.a.a.b.d.h;
import f.a.a.a.b.d.v;
import f.a.a.a.b.d.x;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Parser */
public class e0 {
    public static ArrayList<h> a(Context context) {
        ArrayList<h> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + "content_feelings.json"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("name");
                JSONArray jSONArray2 = jSONObject.getJSONArray("children");
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList2.add(new x(jSONArray2.getString(i3)));
                }
                arrayList.add(new h(string, arrayList2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<v> b(String str) {
        ArrayList<v> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new v(jSONObject.getInt("id"), jSONObject.getString("text")));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
