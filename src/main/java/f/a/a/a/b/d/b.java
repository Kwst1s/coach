package f.a.a.a.b.d;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Assess_Data */
public class b implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private long f9200b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<p> f9201c;

    /* renamed from: d  reason: collision with root package name */
    private int f9202d;

    public b() {
    }

    public long a() {
        return this.f9200b;
    }

    public int c() {
        return this.f9202d;
    }

    public ArrayList<p> d() {
        return this.f9201c;
    }

    public void e(long j2) {
        this.f9200b = j2;
    }

    public void f(int i2) {
        this.f9202d = i2;
    }

    public void g(ArrayList<p> arrayList) {
        this.f9201c = arrayList;
    }

    public b(long j2, ArrayList<p> arrayList, int i2) {
        this.f9200b = j2;
        this.f9201c = arrayList;
        this.f9202d = i2;
    }
}
