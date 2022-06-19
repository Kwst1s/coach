package g.a.a.a.b.c;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import g.a.a.a.a.b.a;
import g.a.a.a.a.b.b;
import g.a.a.a.a.b.c;
import g.a.a.a.a.b.d;
import g.a.a.a.a.e;
import g.a.a.a.a.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBAsyncTask_getSections.kt */
public final class a extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f9800a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Object> f9801b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9802c;

    /* renamed from: d  reason: collision with root package name */
    private long f9803d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f9804e = g.a.a.a.a.f.a.f9768b.a();

    /* renamed from: f  reason: collision with root package name */
    private g.a.a.a.b.b.a f9805f;

    /* renamed from: g  reason: collision with root package name */
    private int f9806g = c.u.g();

    /* renamed from: h  reason: collision with root package name */
    private String f9807h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Object> f9808i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<g.a.a.a.b.d.d.a> f9809j;

    /* renamed from: k  reason: collision with root package name */
    private g.a.a.a.b.d.c f9810k;

    public a(Context context, long j2, ArrayList<Object> arrayList, g.a.a.a.b.b.a aVar, boolean z) {
        f.f(context, "context");
        this.f9800a = new WeakReference<>(context);
        this.f9803d = j2;
        this.f9805f = aVar;
        this.f9802c = z;
        this.f9801b = arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        f.f(voidArr, "params");
        d();
        if (d.f9758a.g(this.f9808i, true)) {
            Map<String, Object> map = this.f9808i;
            if (map != null) {
                c.a aVar = c.u;
                Object obj = map.get(aVar.b());
                if (obj != null) {
                    b((String) obj);
                    this.f9806g = aVar.q();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                f.l();
                throw null;
            }
        } else {
            Map<String, Object> map2 = this.f9808i;
            if (map2 != null) {
                c.a aVar2 = c.u;
                if (map2.containsKey(aVar2.d())) {
                    Map<String, Object> map3 = this.f9808i;
                    if (map3 != null) {
                        Object obj2 = map3.get(aVar2.d());
                        if (obj2 != null) {
                            this.f9806g = ((Integer) obj2).intValue();
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                        }
                    } else {
                        f.l();
                        throw null;
                    }
                } else {
                    this.f9806g = aVar2.g();
                }
                Map<String, Object> map4 = this.f9808i;
                if (map4 == null) {
                    f.l();
                    throw null;
                } else if (map4.containsKey(aVar2.a())) {
                    Map<String, Object> map5 = this.f9808i;
                    if (map5 != null) {
                        Object obj3 = map5.get(aVar2.a());
                        if (obj3 != null) {
                            this.f9807h = (String) obj3;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        f.l();
                        throw null;
                    }
                } else {
                    e.a aVar3 = e.f9766a;
                    Context context = this.f9800a.get();
                    if (context != null) {
                        f.b(context, "weakContext.get()!!");
                        this.f9807h = aVar3.c(context, this.f9806g);
                    } else {
                        f.l();
                        throw null;
                    }
                }
            } else {
                f.l();
                throw null;
            }
        }
        return null;
    }

    public final void b(String str) {
        f.f(str, "sPayload");
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("body");
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta");
            e.a aVar = e.f9766a;
            f.b(jSONObject2, "jMeta");
            this.f9810k = new g.a.a.a.b.d.c(aVar.f(jSONObject2, "from") ? jSONObject2.getInt("from") : 0, aVar.f(jSONObject2, "to") ? jSONObject2.getInt("to") : 0, aVar.f(jSONObject2, "total") ? jSONObject2.getInt("total") : 0);
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            this.f9809j = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                ArrayList<g.a.a.a.b.d.d.a> arrayList = this.f9809j;
                if (arrayList != null) {
                    g.a aVar2 = g.f9786a;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    f.b(jSONObject3, "jSections.getJSONObject(i)");
                    arrayList.add(aVar2.b(jSONObject3, this.f9802c));
                } else {
                    f.l();
                    throw null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(Void r6) {
        g.a.a.a.b.b.a aVar = this.f9805f;
        if (aVar == null) {
            Intent intent = new Intent(this.f9804e);
            intent.putExtra("result", this.f9806g);
            intent.putExtra("error", this.f9807h);
            intent.putExtra("block_id", this.f9803d);
            intent.putExtra("sections", this.f9809j);
            intent.putExtra("paginationInfos", this.f9810k);
            a.C0221a aVar2 = g.a.a.a.a.b.a.f9741a;
            Context context = this.f9800a.get();
            if (context != null) {
                f.b(context, "weakContext.get()!!");
                aVar2.a(context, intent);
                return;
            }
            f.l();
            throw null;
        }
        String str = this.f9807h;
        if (str != null) {
            if (aVar == null) {
                f.l();
                throw null;
            } else if (str != null) {
                aVar.a(str);
            } else {
                f.l();
                throw null;
            }
        } else if (aVar != null) {
            ArrayList<g.a.a.a.b.d.d.a> arrayList = this.f9809j;
            if (arrayList != null) {
                long j2 = this.f9803d;
                g.a.a.a.b.d.c cVar = this.f9810k;
                if (cVar != null) {
                    aVar.b(arrayList, j2, cVar);
                } else {
                    f.l();
                    throw null;
                }
            } else {
                f.l();
                throw null;
            }
        } else {
            f.l();
            throw null;
        }
    }

    public final void d() {
        ContentValues contentValues = new ContentValues();
        if (this.f9802c) {
            contentValues.put("include", "elements");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/api");
        c.a aVar = c.u;
        sb.append(aVar.f());
        String sb2 = sb.toString();
        if (this.f9803d != -1) {
            sb2 = aVar.e() + "/" + String.valueOf(this.f9803d) + aVar.f();
        }
        e.f9766a.a(contentValues, this.f9801b);
        b.a aVar2 = b.f9742a;
        Context context = this.f9800a.get();
        if (context != null) {
            f.b(context, "weakContext.get()!!");
            this.f9808i = b.a.c(aVar2, context, sb2, contentValues, aVar.n(), true, false, null, null, false, null, null, 1984, null);
            return;
        }
        f.l();
        throw null;
    }
}
