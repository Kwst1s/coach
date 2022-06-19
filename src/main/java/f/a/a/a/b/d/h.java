package f.a.a.a.b.d;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Feeling */
public class h implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private String f9230b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<x> f9231c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9232d = false;

    public h(String str, ArrayList<x> arrayList) {
        this.f9230b = str;
        this.f9231c = arrayList;
    }

    public String a() {
        return this.f9230b;
    }

    public ArrayList<x> c() {
        return this.f9231c;
    }

    public boolean d() {
        return this.f9232d;
    }

    public void e(boolean z) {
        this.f9232d = z;
    }
}
