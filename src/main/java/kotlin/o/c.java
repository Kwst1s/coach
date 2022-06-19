package kotlin.o;

import java.nio.charset.Charset;
import kotlin.m.b.f;

/* compiled from: Charsets.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f10795a;

    static {
        Charset forName = Charset.forName("UTF-8");
        f.d(forName, "Charset.forName(\"UTF-8\")");
        f10795a = forName;
        f.d(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        f.d(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        f.d(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        f.d(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        f.d(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
