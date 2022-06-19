package k.c;

import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: DataEvent */
public class a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private long f10747b;

    /* renamed from: c  reason: collision with root package name */
    private String f10748c;

    /* renamed from: d  reason: collision with root package name */
    private String f10749d;

    /* renamed from: e  reason: collision with root package name */
    private long f10750e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10751f = false;

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f10752g;

    public a(long j2, String str, String str2, long j3, JSONObject jSONObject) {
        this.f10747b = j2;
        this.f10748c = str;
        this.f10749d = str2;
        this.f10750e = j3;
        this.f10752g = jSONObject;
    }

    public JSONObject a() {
        return this.f10752g;
    }

    public long c() {
        return this.f10747b;
    }

    public String d() {
        return this.f10748c;
    }

    public long e() {
        return this.f10750e;
    }

    public String f() {
        return this.f10749d;
    }

    public boolean g() {
        return this.f10751f;
    }

    public a(String str, String str2, long j2, JSONObject jSONObject) {
        this.f10748c = str;
        this.f10749d = str2;
        this.f10750e = j2;
        this.f10752g = jSONObject;
    }
}
