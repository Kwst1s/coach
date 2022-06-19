package f.a.a.a.b.d;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Screen */
public class u implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private int f9269b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f9270c;

    /* renamed from: d  reason: collision with root package name */
    private String f9271d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9272e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f9273f = -1;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Integer> f9274g;

    public u(int i2, String str, String str2, ArrayList<Integer> arrayList) {
        this.f9269b = i2;
        this.f9270c = str;
        this.f9274g = arrayList;
        this.f9271d = str2;
    }

    public String a() {
        return this.f9271d;
    }

    public String c() {
        return this.f9270c;
    }

    public int d() {
        return this.f9269b;
    }

    public int e() {
        return this.f9273f;
    }

    public ArrayList<Integer> f() {
        return this.f9274g;
    }

    public boolean g() {
        return this.f9272e;
    }

    public u(String str, String str2, String str3) {
        this.f9270c = str;
        this.f9271d = str3;
    }
}
