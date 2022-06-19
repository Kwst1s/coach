package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.github.mikephil.charting.BuildConfig;

/* compiled from: Person */
public class k {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f1091a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f1092b;

    /* renamed from: c  reason: collision with root package name */
    String f1093c;

    /* renamed from: d  reason: collision with root package name */
    String f1094d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1095e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1096f;

    public IconCompat a() {
        return this.f1092b;
    }

    public String b() {
        return this.f1094d;
    }

    public CharSequence c() {
        return this.f1091a;
    }

    public String d() {
        return this.f1093c;
    }

    public boolean e() {
        return this.f1095e;
    }

    public boolean f() {
        return this.f1096f;
    }

    public String g() {
        String str = this.f1093c;
        if (str != null) {
            return str;
        }
        if (this.f1091a == null) {
            return BuildConfig.FLAVOR;
        }
        return "name:" + ((Object) this.f1091a);
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().n() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
