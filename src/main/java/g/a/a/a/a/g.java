package g.a.a.a.a;

import g.a.a.a.a.e;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.b.d;
import kotlin.m.b.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBParser.kt */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9786a = new a(null);

    /* compiled from: MBParser.kt */
    public static final class a {
        private a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:107:0x02aa  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x02bb  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x02df  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x02ff  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x0344  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x03b6  */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x03ba  */
        /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0209 A[Catch:{ JSONException -> 0x03c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0227 A[Catch:{ JSONException -> 0x03c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0252  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final g.a.a.a.b.d.a.a a(java.lang.Object r45, long r46, java.lang.String r48, java.lang.String r49) {
            /*
            // Method dump skipped, instructions count: 988
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.a.a.a.g.a.a(java.lang.Object, long, java.lang.String, java.lang.String):g.a.a.a.b.d.a.a");
        }

        public final g.a.a.a.b.d.d.a b(JSONObject jSONObject, boolean z) {
            long j2;
            int i2;
            long j3;
            JSONException jSONException;
            long j4;
            f.f(jSONObject, "jSection");
            HashMap hashMap = new HashMap();
            long j5 = -1;
            int i3 = 0;
            try {
                e.a aVar = e.f9766a;
                long j6 = aVar.f(jSONObject, "id") ? jSONObject.getLong("id") : -1;
                try {
                    if (aVar.f(jSONObject, "order")) {
                        i3 = jSONObject.getInt("order");
                    }
                    if (aVar.f(jSONObject, "available_at")) {
                        j5 = jSONObject.getLong("available_at");
                    }
                    if (z && aVar.f(jSONObject, "elements")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("elements");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            try {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                                g.a.a.a.b.d.a.a aVar2 = null;
                                e.a aVar3 = e.f9766a;
                                f.b(jSONObject3, "jElem");
                                if (aVar3.f(jSONObject3, "type")) {
                                    Object obj = jSONObject3.get("value");
                                    f.b(obj, "jElem.get(\"value\")");
                                    long j7 = jSONObject3.getLong("id");
                                    f.b(next, "key");
                                    String string = jSONObject3.getString("type");
                                    f.b(string, "jElem.getString(\"type\")");
                                    aVar2 = a(obj, j7, next, string);
                                }
                                if (aVar2 != null) {
                                    hashMap.put(next, aVar2);
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    i2 = i3;
                    j3 = j6;
                    j2 = j5;
                } catch (JSONException e3) {
                    jSONException = e3;
                    j4 = -1;
                    j5 = j6;
                    jSONException.printStackTrace();
                    j2 = j4;
                    i2 = 0;
                    j3 = j5;
                    return new g.a.a.a.b.d.d.a(j3, i2, hashMap, j2);
                }
            } catch (JSONException e4) {
                jSONException = e4;
                j4 = -1;
                jSONException.printStackTrace();
                j2 = j4;
                i2 = 0;
                j3 = j5;
                return new g.a.a.a.b.d.d.a(j3, i2, hashMap, j2);
            }
            return new g.a.a.a.b.d.d.a(j3, i2, hashMap, j2);
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }
}
