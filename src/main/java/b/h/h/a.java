package b.h.h;

import android.util.Base64;
import b.h.j.h;
import java.util.List;

/* compiled from: FontRequest */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2497a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2498b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2499c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f2500d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2501e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f2502f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        h.c(str);
        String str4 = str;
        this.f2497a = str4;
        h.c(str2);
        String str5 = str2;
        this.f2498b = str5;
        h.c(str3);
        String str6 = str3;
        this.f2499c = str6;
        h.c(list);
        this.f2500d = list;
        this.f2502f = str4 + "-" + str5 + "-" + str6;
    }

    public List<List<byte[]>> a() {
        return this.f2500d;
    }

    public int b() {
        return this.f2501e;
    }

    public String c() {
        return this.f2502f;
    }

    public String d() {
        return this.f2497a;
    }

    public String e() {
        return this.f2498b;
    }

    public String f() {
        return this.f2499c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2497a + ", mProviderPackage: " + this.f2498b + ", mQuery: " + this.f2499c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f2500d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f2500d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2501e);
        return sb.toString();
    }
}
