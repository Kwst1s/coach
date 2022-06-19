package kotlin.l;

import java.lang.reflect.Method;
import kotlin.m.b.f;

/* compiled from: PlatformImplementations.kt */
public class a {

    /* access modifiers changed from: private */
    /* renamed from: kotlin.l.a$a  reason: collision with other inner class name */
    /* compiled from: PlatformImplementations.kt */
    public static final class C0240a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f10780a;

        /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[LOOP:0: B:1:0x000e->B:10:0x003e, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[EDGE_INSN: B:18:0x0042->B:12:0x0042 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.m.b.f.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x000e:
                java.lang.String r5 = "it"
                if (r4 >= r2) goto L_0x0041
                r6 = r1[r4]
                kotlin.m.b.f.d(r6, r5)
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.m.b.f.a(r7, r8)
                if (r7 == 0) goto L_0x003a
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.m.b.f.d(r7, r8)
                java.lang.Object r7 = kotlin.j.b.f(r7)
                java.lang.Class r7 = (java.lang.Class) r7
                boolean r7 = kotlin.m.b.f.a(r7, r0)
                if (r7 == 0) goto L_0x003a
                r7 = 1
                goto L_0x003b
            L_0x003a:
                r7 = 0
            L_0x003b:
                if (r7 == 0) goto L_0x003e
                goto L_0x0042
            L_0x003e:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x0041:
                r6 = 0
            L_0x0042:
                kotlin.l.a.C0240a.f10780a = r6
                int r0 = r1.length
            L_0x0045:
                if (r3 >= r0) goto L_0x005c
                r2 = r1[r3]
                kotlin.m.b.f.d(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = kotlin.m.b.f.a(r2, r4)
                if (r2 == 0) goto L_0x0059
                goto L_0x005c
            L_0x0059:
                int r3 = r3 + 1
                goto L_0x0045
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.a.C0240a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        f.e(th, "cause");
        f.e(th2, "exception");
        Method method = C0240a.f10780a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
