package b.h.d.e;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat */
public class c {

    /* compiled from: FontResourcesParserCompat */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0038c[] f2452a;

        public b(C0038c[] cVarArr) {
            this.f2452a = cVarArr;
        }

        public C0038c[] a() {
            return this.f2452a;
        }
    }

    /* renamed from: b.h.d.e.c$c  reason: collision with other inner class name */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0038c {

        /* renamed from: a  reason: collision with root package name */
        private final String f2453a;

        /* renamed from: b  reason: collision with root package name */
        private int f2454b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2455c;

        /* renamed from: d  reason: collision with root package name */
        private String f2456d;

        /* renamed from: e  reason: collision with root package name */
        private int f2457e;

        /* renamed from: f  reason: collision with root package name */
        private int f2458f;

        public C0038c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.f2453a = str;
            this.f2454b = i2;
            this.f2455c = z;
            this.f2456d = str2;
            this.f2457e = i3;
            this.f2458f = i4;
        }

        public String a() {
            return this.f2453a;
        }

        public int b() {
            return this.f2458f;
        }

        public int c() {
            return this.f2457e;
        }

        public String d() {
            return this.f2456d;
        }

        public int e() {
            return this.f2454b;
        }

        public boolean f() {
            return this.f2455c;
        }
    }

    /* compiled from: FontResourcesParserCompat */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b.h.h.a f2459a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2460b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2461c;

        public d(b.h.h.a aVar, int i2, int i3) {
            this.f2459a = aVar;
            this.f2461c = i2;
            this.f2460b = i3;
        }

        public int a() {
            return this.f2461c;
        }

        public b.h.h.a b() {
            return this.f2459a;
        }

        public int c() {
            return this.f2460b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.h.c.f2434e);
        String string = obtainAttributes.getString(b.h.c.f2435f);
        String string2 = obtainAttributes.getString(b.h.c.f2439j);
        String string3 = obtainAttributes.getString(b.h.c.f2440k);
        int resourceId = obtainAttributes.getResourceId(b.h.c.f2436g, 0);
        int integer = obtainAttributes.getInteger(b.h.c.f2437h, 1);
        int integer2 = obtainAttributes.getInteger(b.h.c.f2438i, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0038c[]) arrayList.toArray(new C0038c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(new b.h.h.a(string, string2, string3, c(resources, resourceId)), integer, integer2);
    }

    private static C0038c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.h.c.l);
        int i2 = b.h.c.u;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = b.h.c.n;
        }
        int i3 = obtainAttributes.getInt(i2, 400);
        int i4 = b.h.c.s;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = b.h.c.o;
        }
        boolean z = 1 == obtainAttributes.getInt(i4, 0);
        int i5 = b.h.c.v;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = b.h.c.p;
        }
        int i6 = b.h.c.t;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = b.h.c.q;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = b.h.c.r;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = b.h.c.m;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0038c(string2, i3, z, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
