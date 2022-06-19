package kotlin.m.b;

/* compiled from: Reflection */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final i f10785a;

    static {
        i iVar = null;
        try {
            iVar = (i) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (iVar == null) {
            iVar = new i();
        }
        f10785a = iVar;
    }

    public static String a(g gVar) {
        return f10785a.b(gVar);
    }
}
