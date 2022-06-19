package g.a.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import com.github.mikephil.charting.BuildConfig;
import g.a.a.a.a.b.c;
import g.a.a.a.b.a.b;
import g.a.a.a.b.a.c;
import g.a.a.a.b.a.d;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.m.b.f;
import kotlin.m.b.j;
import org.json.JSONObject;

/* compiled from: MBCommonMethods.kt */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9766a = new a(null);

    /* compiled from: MBCommonMethods.kt */
    public static final class a {
        private a() {
        }

        public final void a(ContentValues contentValues, ArrayList<Object> arrayList) {
            f.f(contentValues, "values");
            if (arrayList != null) {
                Iterator<Object> it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c) {
                        c cVar = (c) next;
                        contentValues.put("filter[elements.geofence]", String.valueOf(cVar.a()) + "," + String.valueOf(cVar.c()) + "," + String.valueOf(cVar.d()) + "," + String.valueOf(cVar.e()));
                    }
                    if (next instanceof g.a.a.a.b.a.a) {
                        g.a.a.a.b.a.a aVar = (g.a.a.a.b.a.a) next;
                        contentValues.put("filter[elements.value]", aVar.a() + "|" + aVar.c());
                    }
                    if (next instanceof g.a.a.a.b.a.f) {
                        g.a.a.a.b.a.f fVar = (g.a.a.a.b.a.f) next;
                        if (fVar.c()) {
                            contentValues.put("sort", "-" + fVar.a());
                        } else {
                            contentValues.put("sort", fVar.a());
                        }
                    }
                    if (next instanceof g.a.a.a.b.a.e) {
                        g.a.a.a.b.a.e eVar = (g.a.a.a.b.a.e) next;
                        contentValues.put("skip", String.valueOf(eVar.a()));
                        contentValues.put("take", String.valueOf(eVar.c()));
                    }
                    if (next instanceof d) {
                        contentValues.put("locale", ((d) next).a());
                    }
                    if (next instanceof b) {
                        b bVar = (b) next;
                        contentValues.put(bVar.a(), bVar.c());
                    }
                }
            }
        }

        public final String b(Context context) {
            f.f(context, "context");
            SharedPreferences d2 = d(context);
            if (d2 != null) {
                String string = d2.getString(g.a.a.a.a.f.b.t.a(), "dummy");
                try {
                    if (!f.a(string, "dummy")) {
                        String g2 = g(context.getPackageName() + "MBurger");
                        Charset charset = kotlin.o.c.f10795a;
                        if (g2 != null) {
                            byte[] bytes = g2.getBytes(charset);
                            f.b(bytes, "(this as java.lang.String).getBytes(charset)");
                            String a2 = a.a(bytes, string);
                            f.b(a2, "AESUtils.decrypt(encrypt…eArray(), encryptedToken)");
                            return a2;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } catch (GeneralSecurityException unused) {
                }
                return "dummy";
            }
            f.l();
            throw null;
        }

        public final String c(Context context, int i2) {
            f.f(context, "context");
            c.a aVar = g.a.a.a.a.b.c.u;
            if (i2 == aVar.g()) {
                String string = context.getString(g.a.a.a.e.internal_error);
                f.b(string, "context.getString(R.string.internal_error)");
                return string;
            } else if (i2 == aVar.h()) {
                String string2 = context.getString(g.a.a.a.e.internal_error);
                f.b(string2, "context.getString(R.string.internal_error)");
                return string2;
            } else if (i2 == aVar.i()) {
                String string3 = context.getString(g.a.a.a.e.no_internet_error);
                f.b(string3, "context.getString(R.string.no_internet_error)");
                return string3;
            } else if (i2 == aVar.j()) {
                String string4 = context.getString(g.a.a.a.e.timeout_operation_error);
                f.b(string4, "context.getString(R.stri….timeout_operation_error)");
                return string4;
            } else {
                String string5 = context.getString(g.a.a.a.e.internal_error);
                f.b(string5, "context.getString(R.string.internal_error)");
                return string5;
            }
        }

        public final SharedPreferences d(Context context) {
            if (context != null) {
                return context.getSharedPreferences(g.a.a.a.a.f.b.t.b(), 0);
            }
            return null;
        }

        public final boolean e(Context context) {
            f.f(context, "context");
            return !f.a(b(context), "dummy");
        }

        public final boolean f(JSONObject jSONObject, String str) {
            f.f(jSONObject, "json");
            f.f(str, "key");
            return jSONObject.has(str) && !jSONObject.isNull(str);
        }

        public final String g(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("md5");
                if (str != null) {
                    Charset charset = kotlin.o.c.f10795a;
                    if (str != null) {
                        byte[] bytes = str.getBytes(charset);
                        f.b(bytes, "(this as java.lang.String).getBytes(charset)");
                        instance.update(bytes);
                        byte[] digest = instance.digest();
                        StringBuilder sb = new StringBuilder();
                        f.b(digest, "bytes");
                        int length = digest.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            j jVar = j.f10786a;
                            String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(digest[i2])}, 1));
                            f.b(format, "java.lang.String.format(format, *args)");
                            sb.append(format);
                        }
                        String sb2 = sb.toString();
                        f.b(sb2, "sb.toString()");
                        if (sb2 != null) {
                            String lowerCase = sb2.toLowerCase();
                            f.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                            return lowerCase;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                f.l();
                throw null;
            } catch (Exception unused) {
                return BuildConfig.FLAVOR;
            }
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }
}
