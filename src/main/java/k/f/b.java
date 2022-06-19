package k.f;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;
import java.util.Map;
import k.a.g;
import k.a.h;
import k.b.e;

/* compiled from: Task_sendLogs */
public class b extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private Context f10767a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<k.c.b> f10768b;

    /* renamed from: c  reason: collision with root package name */
    private int f10769c = -1003;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f10770d;

    public b(Context context, ArrayList<k.c.b> arrayList) {
        this.f10767a = context;
        this.f10768b = arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        c();
        if (g.g(this.f10770d, false)) {
            this.f10769c = 200;
            return null;
        }
        if (this.f10770d.containsKey("result")) {
            this.f10769c = ((Integer) this.f10770d.get("result")).intValue();
        } else {
            this.f10769c = -1003;
        }
        if (this.f10770d.containsKey("error")) {
            String str = (String) this.f10770d.get("error");
            return null;
        }
        this.f10769c = -1003;
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        e eVar = new e(this.f10767a);
        if (this.f10769c == 200) {
            eVar.H(this.f10768b);
        } else {
            eVar.M(this.f10768b);
        }
    }

    public void c() {
        String e2 = k.b.b.e(this.f10767a, this.f10768b);
        ContentValues contentValues = new ContentValues();
        contentValues.put("project_id", k.b.b.f10733a);
        contentValues.put("platform", "android");
        contentValues.put(BuildConfig.BUILD_TYPE, k.b.b.f10740h);
        contentValues.put("events", e2);
        contentValues.put("version", k.b.b.l(this.f10767a));
        contentValues.put("session_id", k.b.b.g(this.f10767a));
        k.b.b.b("sendLogs", e2);
        this.f10770d = h.a(this.f10767a, "send-data", contentValues, -1, false, false, false, false, null);
    }
}
