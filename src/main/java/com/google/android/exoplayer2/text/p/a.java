package com.google.android.exoplayer2.text.p;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.m;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: TtmlDecoder */
public final class a extends com.google.android.exoplayer2.text.b {
    private static final Pattern o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern s = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b t = new b(30.0f, 1, 1);
    private static final C0140a u = new C0140a(32, 15);
    private final XmlPullParserFactory n;

    /* access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.p.a$a  reason: collision with other inner class name */
    /* compiled from: TtmlDecoder */
    public static final class C0140a {

        /* renamed from: a  reason: collision with root package name */
        final int f6776a;

        C0140a(int i2, int i3) {
            this.f6776a = i3;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: TtmlDecoder */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final float f6777a;

        /* renamed from: b  reason: collision with root package name */
        final int f6778b;

        /* renamed from: c  reason: collision with root package name */
        final int f6779c;

        b(float f2, int i2, int i3) {
            this.f6777a = f2;
            this.f6778b = i2;
            this.f6779c = i3;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.n = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private e C(e eVar) {
        return eVar == null ? new e() : eVar;
    }

    private static boolean E(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    private C0140a F(XmlPullParser xmlPullParser, C0140a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = s.matcher(attributeValue);
        if (!matcher.matches()) {
            m.f("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new C0140a(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            m.f("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void G(String str, e eVar) {
        Matcher matcher;
        String[] c0 = d0.c0(str, "\\s+");
        if (c0.length == 1) {
            matcher = q.matcher(str);
        } else if (c0.length == 2) {
            matcher = q.matcher(c0[1]);
            m.f("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + c0.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.hashCode();
            char c2 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    eVar.t(3);
                    break;
                case 1:
                    eVar.t(2);
                    break;
                case 2:
                    eVar.t(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            eVar.s(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private b H(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] c0 = d0.c0(attributeValue2, " ");
            if (c0.length == 2) {
                f2 = ((float) Integer.parseInt(c0[0])) / ((float) Integer.parseInt(c0[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        b bVar = t;
        int i2 = bVar.f6778b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = bVar.f6779c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new b(((float) parseInt) * f2, i2, i3);
    }

    private Map<String, e> I(XmlPullParser xmlPullParser, Map<String, e> map, Map<String, c> map2, C0140a aVar) {
        c K;
        do {
            xmlPullParser.next();
            if (e0.f(xmlPullParser, "style")) {
                String a2 = e0.a(xmlPullParser, "style");
                e L = L(xmlPullParser, new e());
                if (a2 != null) {
                    for (String str : M(a2)) {
                        L.a(map.get(str));
                    }
                }
                if (L.g() != null) {
                    map.put(L.g(), L);
                }
            } else if (e0.f(xmlPullParser, "region") && (K = K(xmlPullParser, aVar)) != null) {
                map2.put(K.f6791a, K);
            }
        } while (!e0.d(xmlPullParser, "head"));
        return map;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private b J(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, b bVar2) {
        long j2;
        long j3;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        e L = L(xmlPullParser, null);
        String[] strArr = null;
        String str = BuildConfig.FLAVOR;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        long j6 = -9223372036854775807L;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c2 = 4;
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
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                case 1:
                    j6 = N(attributeValue, bVar2);
                    break;
                case 2:
                    j5 = N(attributeValue, bVar2);
                    break;
                case 3:
                    j4 = N(attributeValue, bVar2);
                    break;
                case 4:
                    String[] M = M(attributeValue);
                    if (M.length > 0) {
                        strArr = M;
                        break;
                    }
                    break;
            }
        }
        if (bVar != null) {
            long j7 = bVar.f6783d;
            j2 = -9223372036854775807L;
            if (j7 != -9223372036854775807L) {
                if (j4 != -9223372036854775807L) {
                    j4 += j7;
                }
                if (j5 != -9223372036854775807L) {
                    j5 += j7;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (j5 == j2) {
            if (j6 != j2) {
                j3 = j4 + j6;
            } else if (bVar != null) {
                long j8 = bVar.f6784e;
                if (j8 != j2) {
                    j3 = j8;
                }
            }
            return b.c(xmlPullParser.getName(), j4, j3, L, strArr, str);
        }
        j3 = j5;
        return b.c(xmlPullParser.getName(), j4, j3, L, strArr, str);
    }

    private c K(XmlPullParser xmlPullParser, C0140a aVar) {
        float f2;
        String a2 = e0.a(xmlPullParser, "id");
        if (a2 == null) {
            return null;
        }
        String a3 = e0.a(xmlPullParser, "origin");
        if (a3 != null) {
            Pattern pattern = r;
            Matcher matcher = pattern.matcher(a3);
            if (matcher.matches()) {
                int i2 = 1;
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String a4 = e0.a(xmlPullParser, "extent");
                    if (a4 != null) {
                        Matcher matcher2 = pattern.matcher(a4);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String a5 = e0.a(xmlPullParser, "displayAlign");
                                if (a5 != null) {
                                    String h0 = d0.h0(a5);
                                    h0.hashCode();
                                    if (h0.equals("center")) {
                                        f2 = parseFloat2 + (parseFloat4 / 2.0f);
                                    } else if (h0.equals("after")) {
                                        f2 = parseFloat2 + parseFloat4;
                                        i2 = 2;
                                    }
                                    return new c(a2, parseFloat, f2, 0, i2, parseFloat3, 1, 1.0f / ((float) aVar.f6776a));
                                }
                                f2 = parseFloat2;
                                i2 = 0;
                                return new c(a2, parseFloat, f2, 0, i2, parseFloat3, 1, 1.0f / ((float) aVar.f6776a));
                            } catch (NumberFormatException unused) {
                                m.f("TtmlDecoder", "Ignoring region with malformed extent: " + a3);
                                return null;
                            }
                        } else {
                            m.f("TtmlDecoder", "Ignoring region with unsupported extent: " + a3);
                            return null;
                        }
                    } else {
                        m.f("TtmlDecoder", "Ignoring region without an extent");
                        return null;
                    }
                } catch (NumberFormatException unused2) {
                    m.f("TtmlDecoder", "Ignoring region with malformed origin: " + a3);
                    return null;
                }
            } else {
                m.f("TtmlDecoder", "Ignoring region with unsupported origin: " + a3);
                return null;
            }
        } else {
            m.f("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012c, code lost:
        if (r3.equals("linethrough") == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018e, code lost:
        if (r3.equals("start") == false) goto L_0x0186;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.text.p.e L(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.p.e r13) {
        /*
        // Method dump skipped, instructions count: 650
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.p.a.L(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.p.e):com.google.android.exoplayer2.text.p.e");
    }

    private String[] M(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : d0.c0(trim, "\\s+");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b3, code lost:
        if (r13.equals("ms") == false) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long N(java.lang.String r13, com.google.android.exoplayer2.text.p.a.b r14) {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.p.a.N(java.lang.String, com.google.android.exoplayer2.text.p.a$b):long");
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public f z(byte[] bArr, int i2, boolean z) {
        try {
            XmlPullParser newPullParser = this.n.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            f fVar = null;
            hashMap2.put(BuildConfig.FLAVOR, new c(null));
            int i3 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar = t;
            C0140a aVar = u;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                b bVar2 = (b) arrayDeque.peek();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar = H(newPullParser);
                            aVar = F(newPullParser, u);
                        }
                        if (!E(name)) {
                            m.e("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if ("head".equals(name)) {
                            I(newPullParser, hashMap, hashMap2, aVar);
                        } else {
                            try {
                                b J = J(newPullParser, bVar2, hashMap2, bVar);
                                arrayDeque.push(J);
                                if (bVar2 != null) {
                                    bVar2.a(J);
                                }
                            } catch (SubtitleDecoderException e2) {
                                m.g("TtmlDecoder", "Suppressing parser error", e2);
                            }
                        }
                    } else if (eventType == 4) {
                        bVar2.a(b.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            fVar = new f((b) arrayDeque.peek(), hashMap, hashMap2);
                        }
                        arrayDeque.pop();
                    }
                    newPullParser.next();
                } else if (eventType != 2) {
                    if (eventType == 3) {
                        i3--;
                    }
                    newPullParser.next();
                }
                i3++;
                newPullParser.next();
            }
            return fVar;
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }
}
