package f.a.a.a.b.d;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.m.b.f;

/* compiled from: Goal.kt */
public final class i implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private int f9233b;

    /* renamed from: c  reason: collision with root package name */
    private String f9234c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<j> f9235d;

    /* renamed from: e  reason: collision with root package name */
    private long f9236e;

    /* renamed from: f  reason: collision with root package name */
    private int f9237f;

    public i(int i2, String str, ArrayList<j> arrayList, long j2, int i3) {
        f.e(str, "content");
        this.f9233b = i2;
        this.f9234c = str;
        this.f9235d = arrayList;
        this.f9236e = j2;
        this.f9237f = i3;
    }

    public final String a() {
        return this.f9234c;
    }

    public final int c() {
        return this.f9233b;
    }

    public final long d() {
        return this.f9236e;
    }

    public final int e() {
        return this.f9237f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f9233b == iVar.f9233b && f.a(this.f9234c, iVar.f9234c) && f.a(this.f9235d, iVar.f9235d) && this.f9236e == iVar.f9236e && this.f9237f == iVar.f9237f;
    }

    public final ArrayList<j> f() {
        return this.f9235d;
    }

    public final void g(String str) {
        f.e(str, "<set-?>");
        this.f9234c = str;
    }

    public final void h(long j2) {
        this.f9236e = j2;
    }

    public int hashCode() {
        int i2 = this.f9233b * 31;
        String str = this.f9234c;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        ArrayList<j> arrayList = this.f9235d;
        if (arrayList != null) {
            i3 = arrayList.hashCode();
        }
        long j2 = this.f9236e;
        return ((((hashCode + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f9237f;
    }

    public String toString() {
        return "Goal(id=" + this.f9233b + ", content=" + this.f9234c + ", successes=" + this.f9235d + ", lastEdit=" + this.f9236e + ", order=" + this.f9237f + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i(String str, ArrayList<j> arrayList) {
        this(-1, str, arrayList, -1, 0);
        f.e(str, "content");
    }
}
