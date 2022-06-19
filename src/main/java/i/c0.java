package i;

import java.io.IOException;

/* compiled from: Protocol */
public enum c0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f10321b;

    private c0(String str) {
        this.f10321b = str;
    }

    public static c0 a(String str) {
        c0 c0Var = HTTP_1_0;
        if (str.equals(c0Var.f10321b)) {
            return c0Var;
        }
        c0 c0Var2 = HTTP_1_1;
        if (str.equals(c0Var2.f10321b)) {
            return c0Var2;
        }
        c0 c0Var3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(c0Var3.f10321b)) {
            return c0Var3;
        }
        c0 c0Var4 = HTTP_2;
        if (str.equals(c0Var4.f10321b)) {
            return c0Var4;
        }
        c0 c0Var5 = SPDY_3;
        if (str.equals(c0Var5.f10321b)) {
            return c0Var5;
        }
        c0 c0Var6 = QUIC;
        if (str.equals(c0Var6.f10321b)) {
            return c0Var6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f10321b;
    }
}
