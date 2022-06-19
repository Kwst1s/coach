package i.k0.h;

import i.e0;
import i.y;
import java.net.Proxy;

/* compiled from: RequestLine */
public final class i {
    public static String a(e0 e0Var, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(e0Var.g());
        sb.append(' ');
        if (b(e0Var, type)) {
            sb.append(e0Var.i());
        } else {
            sb.append(c(e0Var.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(e0 e0Var, Proxy.Type type) {
        return !e0Var.f() && type == Proxy.Type.HTTP;
    }

    public static String c(y yVar) {
        String g2 = yVar.g();
        String i2 = yVar.i();
        if (i2 == null) {
            return g2;
        }
        return g2 + '?' + i2;
    }
}
