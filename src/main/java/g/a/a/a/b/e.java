package g.a.a.a.b;

import android.content.Context;
import g.a.a.a.a.f.c;
import java.util.ArrayList;
import kotlin.m.b.d;
import kotlin.m.b.f;
import mumble.mburger.sdk.kt.Common.MBExceptions.MBSDKInitializeException;

/* compiled from: MBurgerTasks.kt */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9814a = new a(null);

    /* compiled from: MBurgerTasks.kt */
    public static final class a {
        private a() {
        }

        public final void a(Context context, long j2, ArrayList<Object> arrayList, boolean z, g.a.a.a.b.b.a aVar) {
            f.f(context, "context");
            if (c.f9785f.a() != null) {
                new g.a.a.a.b.c.a(context, j2, arrayList, aVar, z).execute(new Void[0]);
                return;
            }
            String string = context.getString(g.a.a.a.e.exception_sdk_not_initialized);
            f.b(string, "context.getString(R.stri…tion_sdk_not_initialized)");
            throw new MBSDKInitializeException(string);
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }
}
