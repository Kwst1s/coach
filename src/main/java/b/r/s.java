package b.r;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2936a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f2937b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<m> f2938c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f2937b == sVar.f2937b && this.f2936a.equals(sVar.f2936a);
    }

    public int hashCode() {
        return (this.f2937b.hashCode() * 31) + this.f2936a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2937b + "\n") + "    values:";
        for (String str2 : this.f2936a.keySet()) {
            str = str + "    " + str2 + ": " + this.f2936a.get(str2) + "\n";
        }
        return str;
    }

    public s(View view) {
        this.f2937b = view;
    }
}
