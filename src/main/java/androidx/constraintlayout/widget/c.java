package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintLayoutStates */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<a> f912a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<d> f913b = new SparseArray<>();

    /* access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f914a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f915b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f916c = -1;

        /* renamed from: d  reason: collision with root package name */
        d f917d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.K3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.L3) {
                    this.f914a = obtainStyledAttributes.getResourceId(index, this.f914a);
                } else if (index == i.M3) {
                    this.f916c = obtainStyledAttributes.getResourceId(index, this.f916c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f916c);
                    context.getResources().getResourceName(this.f916c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f917d = dVar;
                        dVar.f(context, this.f916c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f915b.add(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        float f918a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f919b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f920c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f921d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f922e = -1;

        /* renamed from: f  reason: collision with root package name */
        d f923f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.Z3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.a4) {
                    this.f922e = obtainStyledAttributes.getResourceId(index, this.f922e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f922e);
                    context.getResources().getResourceName(this.f922e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f923f = dVar;
                        dVar.f(context, this.f922e);
                    }
                } else if (index == i.b4) {
                    this.f921d = obtainStyledAttributes.getDimension(index, this.f921d);
                } else if (index == i.c4) {
                    this.f919b = obtainStyledAttributes.getDimension(index, this.f919b);
                } else if (index == i.d4) {
                    this.f920c = obtainStyledAttributes.getDimension(index, this.f920c);
                } else if (index == i.e4) {
                    this.f918a = obtainStyledAttributes.getDimension(index, this.f918a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    c(Context context, ConstraintLayout constraintLayout, int i2) {
        a(context, i2);
    }

    private void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            aVar = new a(context, xml);
                            this.f912a.put(aVar.f914a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (c2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b(context, xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("id".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    } else {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                dVar.n(context, xmlPullParser);
                this.f913b.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f fVar) {
    }
}
