package gov.va.mobilehealth.ncptsd.covid.CComp;

import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.k;
import f.a.a.a.b.d.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: C_F_Parse_Json */
public class p {
    public static ArrayList<u> a(JSONArray jSONArray) {
        ArrayList<u> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int i3 = -1;
                ArrayList arrayList2 = new ArrayList();
                if (j.F(jSONObject, "id")) {
                    i3 = jSONObject.getInt("id");
                }
                String string = jSONObject.getString("displayName");
                if (jSONObject.has("related_tools")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("related_tools");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        arrayList2.add(Integer.valueOf(jSONArray2.getInt(i4)));
                    }
                }
                arrayList.add(new u(i3, string, jSONObject.getString("cdata"), arrayList2));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return arrayList;
    }

    public static ArrayList<k> b(JSONArray jSONArray) {
        try {
            ArrayList<k> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new k(jSONObject.getString("title"), jSONObject.getString("content")));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<u> c(JSONArray jSONArray) {
        try {
            ArrayList<u> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new u(jSONObject.getString("title"), null, jSONObject.getString("content")));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static a0 d(JSONObject jSONObject) {
        try {
            return new a0(jSONObject.getInt("id"), jSONObject.getString("title"));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static b0 e(JSONObject jSONObject) {
        try {
            int i2 = jSONObject.getInt("id");
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("display_title");
            boolean z = false;
            if (j.F(jSONObject, "symptoms_ids")) {
                String string3 = jSONObject.getString("filename");
                JSONArray jSONArray = jSONObject.getJSONArray("symptoms_ids");
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
                }
                return new b0(i2, string, string2, string3, arrayList);
            } else if (!j.F(jSONObject, "sub_tools")) {
                return null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = jSONObject.getJSONArray("sub_tools");
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    arrayList2.add(Integer.valueOf(jSONArray2.getInt(i4)));
                }
                b0 b0Var = new b0(i2, string, string2, arrayList2);
                if (j.F(jSONObject, "intro")) {
                    z = jSONObject.getBoolean("intro");
                }
                b0Var.k(z);
                return b0Var;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
