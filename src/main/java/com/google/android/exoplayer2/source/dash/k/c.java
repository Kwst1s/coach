package com.google.android.exoplayer2.source.dash.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.dash.k.j;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.p;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DashManifestParser */
public class c extends DefaultHandler implements v.a<b> {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f6254c = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f6255d = Pattern.compile("CC([1-4])=.*");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f6256e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: a  reason: collision with root package name */
    private final String f6257a;

    /* renamed from: b  reason: collision with root package name */
    private final XmlPullParserFactory f6258b;

    /* access modifiers changed from: protected */
    /* compiled from: DashManifestParser */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final l f6259a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6260b;

        /* renamed from: c  reason: collision with root package name */
        public final j f6261c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6262d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<l.b> f6263e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<d> f6264f;

        /* renamed from: g  reason: collision with root package name */
        public final long f6265g;

        public a(com.google.android.exoplayer2.l lVar, String str, j jVar, String str2, ArrayList<l.b> arrayList, ArrayList<d> arrayList2, long j2) {
            this.f6259a = lVar;
            this.f6260b = str;
            this.f6261c = jVar;
            this.f6262d = str2;
            this.f6263e = arrayList;
            this.f6264f = arrayList2;
            this.f6265g = j2;
        }
    }

    public c() {
        this(null);
    }

    protected static int A(List<d> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f6266a) && (str = dVar.f6267b) != null) {
                Matcher matcher = f6255d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                m.f("MpdParser", "Unable to parse CEA-608 channel number from: " + dVar.f6267b);
            }
        }
        return -1;
    }

    protected static int B(List<d> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f6266a) && (str = dVar.f6267b) != null) {
                Matcher matcher = f6256e.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                m.f("MpdParser", "Unable to parse CEA-708 service block number from: " + dVar.f6267b);
            }
        }
        return -1;
    }

    protected static long E(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        return d0.U(attributeValue);
    }

    protected static d F(XmlPullParser xmlPullParser, String str) {
        String b0 = b0(xmlPullParser, "schemeIdUri", BuildConfig.FLAVOR);
        String b02 = b0(xmlPullParser, "value", null);
        String b03 = b0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!e0.d(xmlPullParser, str));
        return new d(b0, b02, b03);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int G(XmlPullParser xmlPullParser) {
        char c2;
        String h0 = d0.h0(xmlPullParser.getAttributeValue(null, "value"));
        if (h0 == null) {
            return -1;
        }
        h0.hashCode();
        switch (h0.hashCode()) {
            case 1596796:
                if (h0.equals("4000")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2937391:
                if (h0.equals("a000")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3094035:
                if (h0.equals("f801")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3133436:
                if (h0.equals("fa01")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    protected static long H(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        return d0.V(attributeValue);
    }

    protected static String I(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(dVar.f6266a) && "ec+3".equals(dVar.f6267b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float M(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f6254c.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    protected static int O(XmlPullParser xmlPullParser, String str, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i2 : Integer.parseInt(attributeValue);
    }

    protected static long P(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j2 : Long.parseLong(attributeValue);
    }

    protected static String b0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static int o(int i2, int i3) {
        if (i2 == -1) {
            return i3;
        }
        if (i3 == -1) {
            return i2;
        }
        e.f(i2 == i3);
        return i2;
    }

    private static String p(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        e.f(str.equals(str2));
        return str;
    }

    private static void q(ArrayList<l.b> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l.b bVar = arrayList.get(size);
            if (!bVar.m()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i2).k(bVar)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    private static String s(String str, String str2) {
        if (p.k(str)) {
            return p.a(str2);
        }
        if (p.m(str)) {
            return p.j(str2);
        }
        if (u(str)) {
            return str;
        }
        if ("application/mp4".equals(str)) {
            if (str2 != null) {
                if (str2.startsWith("stpp")) {
                    return "application/ttml+xml";
                }
                if (str2.startsWith("wvtt")) {
                    return "application/x-mp4-vtt";
                }
            }
        } else if ("application/x-rawcc".equals(str) && str2 != null) {
            if (str2.contains("cea708")) {
                return "application/cea-708";
            }
            if (str2.contains("eia608") || str2.contains("cea608")) {
                return "application/cea-608";
            }
        }
        return null;
    }

    public static void t(XmlPullParser xmlPullParser) {
        if (e0.e(xmlPullParser)) {
            int i2 = 1;
            while (i2 != 0) {
                xmlPullParser.next();
                if (e0.e(xmlPullParser)) {
                    i2++;
                } else if (e0.c(xmlPullParser)) {
                    i2--;
                }
            }
        }
    }

    private static boolean u(String str) {
        return p.l(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    protected static String z(XmlPullParser xmlPullParser, String str) {
        xmlPullParser.next();
        return c0.c(str, xmlPullParser.getText());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v5, resolved type: java.util.UUID */
    /* JADX DEBUG: Multi-variable search result rejected for r9v6, resolved type: java.util.UUID */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0126 A[LOOP:1: B:31:0x0088->B:70:0x0126, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.l.b> C(org.xmlpull.v1.XmlPullParser r15) {
        /*
        // Method dump skipped, instructions count: 324
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.k.c.C(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public int D(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.f0.g.a J(XmlPullParser xmlPullParser, String str, String str2, long j2, ByteArrayOutputStream byteArrayOutputStream) {
        long P = P(xmlPullParser, "id", 0);
        long P2 = P(xmlPullParser, "duration", -9223372036854775807L);
        long P3 = P(xmlPullParser, "presentationTime", 0);
        long Z = d0.Z(P2, 1000, j2);
        long Z2 = d0.Z(P3, 1000000, j2);
        String b0 = b0(xmlPullParser, "messageData", null);
        byte[] K = K(xmlPullParser, byteArrayOutputStream);
        if (b0 != null) {
            K = d0.K(b0);
        }
        return c(str, str2, P, Z, K, Z2);
    }

    /* access modifiers changed from: protected */
    public byte[] K(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, "UTF-8");
        xmlPullParser.nextToken();
        while (!e0.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    public e L(XmlPullParser xmlPullParser) {
        String b0 = b0(xmlPullParser, "schemeIdUri", BuildConfig.FLAVOR);
        String b02 = b0(xmlPullParser, "value", BuildConfig.FLAVOR);
        long P = P(xmlPullParser, "timescale", 1);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "Event")) {
                arrayList.add(J(xmlPullParser, b0, b02, P, byteArrayOutputStream));
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        com.google.android.exoplayer2.f0.g.a[] aVarArr = new com.google.android.exoplayer2.f0.g.a[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.google.android.exoplayer2.f0.g.a aVar = (com.google.android.exoplayer2.f0.g.a) arrayList.get(i2);
            jArr[i2] = aVar.f5712e;
            aVarArr[i2] = aVar;
        }
        return d(b0, b02, P, jArr, aVarArr);
    }

    /* access modifiers changed from: protected */
    public h N(XmlPullParser xmlPullParser) {
        return T(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017b A[LOOP:0: B:20:0x006e->B:68:0x017b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0140 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.k.b Q(org.xmlpull.v1.XmlPullParser r33, java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 385
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.k.c.Q(org.xmlpull.v1.XmlPullParser, java.lang.String):com.google.android.exoplayer2.source.dash.k.b");
    }

    /* access modifiers changed from: protected */
    public Pair<f, Long> R(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long H = H(xmlPullParser, "start", j2);
        long H2 = H(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        j jVar = null;
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = z(xmlPullParser, str);
                    z = true;
                }
            } else if (e0.f(xmlPullParser, "AdaptationSet")) {
                arrayList.add(w(xmlPullParser, str, jVar));
            } else if (e0.f(xmlPullParser, "EventStream")) {
                arrayList2.add(L(xmlPullParser));
            } else if (e0.f(xmlPullParser, "SegmentBase")) {
                jVar = W(xmlPullParser, null);
            } else if (e0.f(xmlPullParser, "SegmentList")) {
                jVar = X(xmlPullParser, null);
            } else if (e0.f(xmlPullParser, "SegmentTemplate")) {
                jVar = Y(xmlPullParser, null);
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "Period"));
        return Pair.create(g(attributeValue, H, arrayList, arrayList2), Long.valueOf(H2));
    }

    /* access modifiers changed from: protected */
    public g S(XmlPullParser xmlPullParser) {
        String str = null;
        String b0 = b0(xmlPullParser, "moreInformationURL", null);
        String b02 = b0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (e0.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (e0.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                t(xmlPullParser);
            }
            if (e0.d(xmlPullParser, "ProgramInformation")) {
                return new g(str, str2, str3, b0, b02);
            }
            str3 = str3;
        }
    }

    /* access modifiers changed from: protected */
    public h T(XmlPullParser xmlPullParser, String str, String str2) {
        long j2;
        long j3;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j3 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j3) + 1;
                return h(attributeValue, j3, j2);
            }
        } else {
            j3 = 0;
        }
        j2 = -1;
        return h(attributeValue, j3, j2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0157 A[LOOP:0: B:1:0x005a->B:44:0x0157, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011e A[EDGE_INSN: B:45:0x011e->B:38:0x011e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.k.c.a U(org.xmlpull.v1.XmlPullParser r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, int r29, float r30, int r31, int r32, java.lang.String r33, int r34, java.util.List<com.google.android.exoplayer2.source.dash.k.d> r35, com.google.android.exoplayer2.source.dash.k.j r36) {
        /*
        // Method dump skipped, instructions count: 353
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.k.c.U(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, int, java.util.List, com.google.android.exoplayer2.source.dash.k.j):com.google.android.exoplayer2.source.dash.k.c$a");
    }

    /* access modifiers changed from: protected */
    public int V(XmlPullParser xmlPullParser) {
        String b0 = b0(xmlPullParser, "schemeIdUri", null);
        String b02 = b0(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!e0.d(xmlPullParser, "Role"));
        return (!"urn:mpeg:dash:role:2011".equals(b0) || !"main".equals(b02)) ? 0 : 1;
    }

    /* access modifiers changed from: protected */
    public j.e W(XmlPullParser xmlPullParser, j.e eVar) {
        long j2;
        long j3;
        long P = P(xmlPullParser, "timescale", eVar != null ? eVar.f6297b : 1);
        long j4 = 0;
        long P2 = P(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f6298c : 0);
        long j5 = eVar != null ? eVar.f6307d : 0;
        if (eVar != null) {
            j4 = eVar.f6308e;
        }
        h hVar = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j2 = (Long.parseLong(split[1]) - parseLong) + 1;
            j3 = parseLong;
        } else {
            j2 = j4;
            j3 = j5;
        }
        if (eVar != null) {
            hVar = eVar.f6296a;
        }
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "SegmentBase"));
        return m(hVar, P, P2, j3, j2);
    }

    /* access modifiers changed from: protected */
    public j.b X(XmlPullParser xmlPullParser, j.b bVar) {
        long j2 = 1;
        long P = P(xmlPullParser, "timescale", bVar != null ? bVar.f6297b : 1);
        long P2 = P(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f6298c : 0);
        long P3 = P(xmlPullParser, "duration", bVar != null ? bVar.f6300e : -9223372036854775807L);
        if (bVar != null) {
            j2 = bVar.f6299d;
        }
        long P4 = P(xmlPullParser, "startNumber", j2);
        List<h> list = null;
        h hVar = null;
        List<j.d> list2 = null;
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else if (e0.f(xmlPullParser, "SegmentTimeline")) {
                list2 = Z(xmlPullParser);
            } else if (e0.f(xmlPullParser, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(a0(xmlPullParser));
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (hVar == null) {
                hVar = bVar.f6296a;
            }
            if (list2 == null) {
                list2 = bVar.f6301f;
            }
            if (list == null) {
                list = bVar.f6302g;
            }
        }
        return j(hVar, P, P2, P4, P3, list2, list);
    }

    /* access modifiers changed from: protected */
    public j.c Y(XmlPullParser xmlPullParser, j.c cVar) {
        long j2 = 1;
        long P = P(xmlPullParser, "timescale", cVar != null ? cVar.f6297b : 1);
        long P2 = P(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f6298c : 0);
        long P3 = P(xmlPullParser, "duration", cVar != null ? cVar.f6300e : -9223372036854775807L);
        if (cVar != null) {
            j2 = cVar.f6299d;
        }
        long P4 = P(xmlPullParser, "startNumber", j2);
        h hVar = null;
        l c0 = c0(xmlPullParser, "media", cVar != null ? cVar.f6304h : null);
        l c02 = c0(xmlPullParser, "initialization", cVar != null ? cVar.f6303g : null);
        List<j.d> list = null;
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else if (e0.f(xmlPullParser, "SegmentTimeline")) {
                list = Z(xmlPullParser);
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (hVar == null) {
                hVar = cVar.f6296a;
            }
            if (list == null) {
                list = cVar.f6301f;
            }
        }
        return k(hVar, P, P2, P4, P3, list, c02, c0);
    }

    /* access modifiers changed from: protected */
    public List<j.d> Z(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "S")) {
                j2 = P(xmlPullParser, "t", j2);
                long P = P(xmlPullParser, "d", -9223372036854775807L);
                int O = O(xmlPullParser, "r", 0) + 1;
                for (int i2 = 0; i2 < O; i2++) {
                    arrayList.add(l(j2, P));
                    j2 += P;
                }
            } else {
                t(xmlPullParser);
            }
        } while (!e0.d(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public h a0(XmlPullParser xmlPullParser) {
        return T(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public a b(int i2, int i3, List<i> list, List<d> list2, List<d> list3) {
        return new a(i2, i3, list, list2, list3);
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.f0.g.a c(String str, String str2, long j2, long j3, byte[] bArr, long j4) {
        return new com.google.android.exoplayer2.f0.g.a(str, str2, j3, j2, bArr, j4);
    }

    /* access modifiers changed from: protected */
    public l c0(XmlPullParser xmlPullParser, String str, l lVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? l.b(attributeValue) : lVar;
    }

    /* access modifiers changed from: protected */
    public e d(String str, String str2, long j2, long[] jArr, com.google.android.exoplayer2.f0.g.a[] aVarArr) {
        return new e(str, str2, j2, jArr, aVarArr);
    }

    /* access modifiers changed from: protected */
    public m d0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.l e(String str, String str2, String str3, int i2, int i3, float f2, int i4, int i5, int i6, String str4, int i7, List<d> list, String str5, List<d> list2) {
        String str6;
        int i8;
        int B;
        String s = s(str3, str5);
        if (s != null) {
            if ("audio/eac3".equals(s)) {
                s = I(list2);
            }
            str6 = s;
            if (p.m(str6)) {
                return com.google.android.exoplayer2.l.E(str, str2, str3, str6, str5, i6, i2, i3, f2, null, i7);
            }
            if (p.k(str6)) {
                return com.google.android.exoplayer2.l.q(str, str2, str3, str6, str5, i6, i4, i5, null, i7, str4);
            }
            if (u(str6)) {
                if ("application/cea-608".equals(str6)) {
                    B = A(list);
                } else if ("application/cea-708".equals(str6)) {
                    B = B(list);
                } else {
                    i8 = -1;
                    return com.google.android.exoplayer2.l.z(str, str2, str3, str6, str5, i6, i7, str4, i8);
                }
                i8 = B;
                return com.google.android.exoplayer2.l.z(str, str2, str3, str6, str5, i6, i7, str4, i8);
            }
        } else {
            str6 = s;
        }
        return com.google.android.exoplayer2.l.u(str, str2, str3, str6, str5, i6, i7, str4);
    }

    /* access modifiers changed from: protected */
    public b f(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, g gVar, m mVar, Uri uri, List<f> list) {
        return new b(j2, j3, j4, z, j5, j6, j7, j8, gVar, mVar, uri, list);
    }

    /* access modifiers changed from: protected */
    public f g(String str, long j2, List<a> list, List<e> list2) {
        return new f(str, j2, list, list2);
    }

    /* access modifiers changed from: protected */
    public h h(String str, long j2, long j3) {
        return new h(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public i i(a aVar, String str, String str2, ArrayList<l.b> arrayList, ArrayList<d> arrayList2) {
        com.google.android.exoplayer2.l lVar = aVar.f6259a;
        String str3 = aVar.f6262d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<l.b> arrayList3 = aVar.f6263e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            lVar = lVar.k(new com.google.android.exoplayer2.drm.l(str2, arrayList3));
        }
        ArrayList<d> arrayList4 = aVar.f6264f;
        arrayList4.addAll(arrayList2);
        return i.l(str, aVar.f6265g, lVar, aVar.f6260b, aVar.f6261c, arrayList4);
    }

    /* access modifiers changed from: protected */
    public j.b j(h hVar, long j2, long j3, long j4, long j5, List<j.d> list, List<h> list2) {
        return new j.b(hVar, j2, j3, j4, j5, list, list2);
    }

    /* access modifiers changed from: protected */
    public j.c k(h hVar, long j2, long j3, long j4, long j5, List<j.d> list, l lVar, l lVar2) {
        return new j.c(hVar, j2, j3, j4, j5, list, lVar, lVar2);
    }

    /* access modifiers changed from: protected */
    public j.d l(long j2, long j3) {
        return new j.d(j2, j3);
    }

    /* access modifiers changed from: protected */
    public j.e m(h hVar, long j2, long j3, long j4, long j5) {
        return new j.e(hVar, j2, j3, j4, j5);
    }

    /* access modifiers changed from: protected */
    public m n(String str, String str2) {
        return new m(str, str2);
    }

    /* access modifiers changed from: protected */
    public int r(com.google.android.exoplayer2.l lVar) {
        String str = lVar.f5977h;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p.m(str)) {
            return 2;
        }
        if (p.k(str)) {
            return 1;
        }
        if (u(str)) {
            return 3;
        }
        return -1;
    }

    /* renamed from: v */
    public b a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f6258b.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return Q(newPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e2) {
            throw new ParserException(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v53, types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0231 A[LOOP:0: B:1:0x0069->B:59:0x0231, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f8 A[EDGE_INSN: B:60:0x01f8->B:53:0x01f8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.k.a w(org.xmlpull.v1.XmlPullParser r41, java.lang.String r42, com.google.android.exoplayer2.source.dash.k.j r43) {
        /*
        // Method dump skipped, instructions count: 579
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.k.c.w(org.xmlpull.v1.XmlPullParser, java.lang.String, com.google.android.exoplayer2.source.dash.k.j):com.google.android.exoplayer2.source.dash.k.a");
    }

    /* access modifiers changed from: protected */
    public void x(XmlPullParser xmlPullParser) {
        t(xmlPullParser);
    }

    /* access modifiers changed from: protected */
    public int y(XmlPullParser xmlPullParser) {
        String b0 = b0(xmlPullParser, "schemeIdUri", null);
        int i2 = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b0)) {
            i2 = O(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(b0)) {
            i2 = G(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!e0.d(xmlPullParser, "AudioChannelConfiguration"));
        return i2;
    }

    public c(String str) {
        this.f6257a = str;
        try {
            this.f6258b = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }
}
