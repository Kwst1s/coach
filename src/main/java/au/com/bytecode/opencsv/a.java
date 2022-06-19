package au.com.bytecode.opencsv;

import java.io.Closeable;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private Writer f1992b;

    /* renamed from: c  reason: collision with root package name */
    private PrintWriter f1993c;

    /* renamed from: d  reason: collision with root package name */
    private char f1994d;

    /* renamed from: e  reason: collision with root package name */
    private char f1995e;

    /* renamed from: f  reason: collision with root package name */
    private char f1996f;

    /* renamed from: g  reason: collision with root package name */
    private String f1997g;

    public a(Writer writer) {
        this(writer, ',');
    }

    public a(Writer writer, char c2) {
        this(writer, c2, '\"');
    }

    public a(Writer writer, char c2, char c3) {
        this(writer, c2, c3, '\"');
    }

    public a(Writer writer, char c2, char c3, char c4) {
        this(writer, c2, c3, c4, "\n");
    }

    public a(Writer writer, char c2, char c3, char c4, String str) {
        this.f1992b = writer;
        this.f1993c = new PrintWriter(writer);
        this.f1994d = c2;
        this.f1995e = c3;
        this.f1996f = c4;
        this.f1997g = str;
    }

    private boolean E(String str) {
        return (str.indexOf(this.f1995e) == -1 && str.indexOf(this.f1996f) == -1) ? false : true;
    }

    public void F(List<String[]> list) {
        for (String[] strArr : list) {
            G(strArr);
        }
    }

    public void G(String... strArr) {
        if (strArr != null) {
            StringBuilder sb = new StringBuilder(128);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 != 0) {
                    sb.append(this.f1994d);
                }
                String str = strArr[i2];
                if (str != null) {
                    char c2 = this.f1995e;
                    if (c2 != 0) {
                        sb.append(c2);
                    }
                    boolean E = E(str);
                    String str2 = str;
                    if (E) {
                        str2 = l(str);
                    }
                    sb.append((CharSequence) str2);
                    char c3 = this.f1995e;
                    if (c3 != 0) {
                        sb.append(c3);
                    }
                }
            }
            sb.append(this.f1997g);
            this.f1993c.write(sb.toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();
        this.f1993c.close();
        this.f1992b.close();
    }

    public void flush() {
        this.f1993c.flush();
    }

    /* access modifiers changed from: protected */
    public StringBuilder l(String str) {
        StringBuilder sb = new StringBuilder(128);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            char c2 = this.f1996f;
            if ((c2 != 0 && charAt == this.f1995e) || (c2 != 0 && charAt == c2)) {
                sb.append(c2);
            }
            sb.append(charAt);
        }
        return sb;
    }
}
