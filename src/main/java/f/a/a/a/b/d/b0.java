package f.a.a.a.b.d;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Tool */
public class b0 implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private int f9203b;

    /* renamed from: c  reason: collision with root package name */
    private String f9204c;

    /* renamed from: d  reason: collision with root package name */
    private String f9205d;

    /* renamed from: e  reason: collision with root package name */
    private String f9206e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Integer> f9207f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9208g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9209h = false;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Integer> f9210i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9211j = false;

    public b0(int i2, String str, String str2, String str3, ArrayList<Integer> arrayList) {
        this.f9203b = i2;
        this.f9204c = str;
        this.f9205d = str2;
        this.f9206e = str3;
        this.f9207f = arrayList;
    }

    public String a() {
        return this.f9205d;
    }

    public String c() {
        return this.f9206e;
    }

    public int d() {
        return this.f9203b;
    }

    public ArrayList<Integer> e() {
        return this.f9210i;
    }

    public ArrayList<Integer> f() {
        return this.f9207f;
    }

    public String g() {
        return this.f9204c;
    }

    public boolean h() {
        return this.f9208g;
    }

    public boolean i() {
        return this.f9211j;
    }

    public boolean j() {
        return this.f9209h;
    }

    public void k(boolean z) {
        this.f9211j = z;
    }

    public void l(boolean z) {
        this.f9209h = z;
    }

    public b0(int i2, String str, String str2, ArrayList<Integer> arrayList) {
        this.f9203b = i2;
        this.f9204c = str;
        this.f9205d = str2;
        this.f9210i = arrayList;
    }

    public b0(String str) {
        this.f9204c = str;
        this.f9208g = true;
    }
}
