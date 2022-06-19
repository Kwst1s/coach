package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.e0.u.j;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class SsManifestParser implements v.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f6569a;

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
        }
    }

    /* access modifiers changed from: private */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f6570a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6571b;

        /* renamed from: c  reason: collision with root package name */
        private final a f6572c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<String, Object>> f6573d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.f6572c = aVar;
            this.f6570a = str;
            this.f6571b = str2;
        }

        private a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new c(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new b(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void a(Object obj) {
        }

        /* access modifiers changed from: protected */
        public abstract Object b();

        /* access modifiers changed from: protected */
        public final Object c(String str) {
            for (int i2 = 0; i2 < this.f6573d.size(); i2++) {
                Pair<String, Object> pair = this.f6573d.get(i2);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f6572c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        /* access modifiers changed from: protected */
        public boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f6571b.equals(name)) {
                        n(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i2 > 0) {
                            i2++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e2 = e(this, name, this.f6570a);
                            if (e2 == null) {
                                i2 = 1;
                            } else {
                                a(e2.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i2 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        /* access modifiers changed from: protected */
        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
        }

        /* access modifiers changed from: protected */
        public void h(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final int i(XmlPullParser xmlPullParser, String str, int i2) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i2;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw new ParserException(e2);
            }
        }

        /* access modifiers changed from: protected */
        public final long j(XmlPullParser xmlPullParser, String str, long j2) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j2;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw new ParserException(e2);
            }
        }

        /* access modifiers changed from: protected */
        public final int k(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new ParserException(e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final long l(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new ParserException(e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final String m(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        /* access modifiers changed from: protected */
        public abstract void n(XmlPullParser xmlPullParser);

        /* access modifiers changed from: protected */
        public void o(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final void p(String str, Object obj) {
            this.f6573d.add(Pair.create(str, obj));
        }
    }

    /* access modifiers changed from: private */
    public static class b extends a {

        /* renamed from: e  reason: collision with root package name */
        private boolean f6574e;

        /* renamed from: f  reason: collision with root package name */
        private UUID f6575f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f6576g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        private static String q(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f6575f;
            return new a.C0134a(uuid, j.a(uuid, this.f6576g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f6574e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f6574e = true;
                this.f6575f = UUID.fromString(q(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f6574e) {
                this.f6576g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static class c extends a {

        /* renamed from: e  reason: collision with root package name */
        private l f6577e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        private static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] w = d0.w(str);
                byte[][] l = g.l(w);
                if (l == null) {
                    arrayList.add(w);
                } else {
                    Collections.addAll(arrayList, l);
                }
            }
            return arrayList;
        }

        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.f6577e;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            int intValue = ((Integer) c("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            String str = (String) c("Name");
            int k2 = k(xmlPullParser, "Bitrate");
            String r = r(m(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.f6577e = l.E(attributeValue, str, "video/mp4", r, null, k2, k(xmlPullParser, "MaxWidth"), k(xmlPullParser, "MaxHeight"), -1.0f, q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (r == null) {
                    r = "audio/mp4a-latm";
                }
                int k3 = k(xmlPullParser, "Channels");
                int k4 = k(xmlPullParser, "SamplingRate");
                List<byte[]> q = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q.isEmpty() && "audio/mp4a-latm".equals(r)) {
                    q = Collections.singletonList(g.b(k4, k3));
                }
                this.f6577e = l.q(attributeValue, str, "audio/mp4", r, null, k2, k3, k4, q, 0, (String) c("Language"));
            } else if (intValue == 3) {
                this.f6577e = l.y(attributeValue, str, "application/mp4", r, null, k2, 0, (String) c("Language"));
            } else {
                this.f6577e = l.u(attributeValue, str, "application/mp4", r, null, k2, 0, null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static class d extends a {

        /* renamed from: e  reason: collision with root package name */
        private final List<a.b> f6578e = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private int f6579f;

        /* renamed from: g  reason: collision with root package name */
        private int f6580g;

        /* renamed from: h  reason: collision with root package name */
        private long f6581h;

        /* renamed from: i  reason: collision with root package name */
        private long f6582i;

        /* renamed from: j  reason: collision with root package name */
        private long f6583j;

        /* renamed from: k  reason: collision with root package name */
        private int f6584k = -1;
        private boolean l;
        private a.C0134a m = null;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f6578e.add((a.b) obj);
            } else if (obj instanceof a.C0134a) {
                com.google.android.exoplayer2.util.e.f(this.m == null);
                this.m = (a.C0134a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.f6578e.size();
            a.b[] bVarArr = new a.b[size];
            this.f6578e.toArray(bVarArr);
            if (this.m != null) {
                a.C0134a aVar = this.m;
                com.google.android.exoplayer2.drm.l lVar = new com.google.android.exoplayer2.drm.l(new l.b(aVar.f6600a, "video/mp4", aVar.f6601b));
                for (int i2 = 0; i2 < size; i2++) {
                    a.b bVar = bVarArr[i2];
                    int i3 = 0;
                    while (true) {
                        com.google.android.exoplayer2.l[] lVarArr = bVar.f6611j;
                        if (i3 >= lVarArr.length) {
                            break;
                        }
                        lVarArr[i3] = lVarArr[i3].k(lVar);
                        i3++;
                    }
                }
            }
            return new a(this.f6579f, this.f6580g, this.f6581h, this.f6582i, this.f6583j, this.f6584k, this.l, this.m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            this.f6579f = k(xmlPullParser, "MajorVersion");
            this.f6580g = k(xmlPullParser, "MinorVersion");
            this.f6581h = j(xmlPullParser, "TimeScale", 10000000);
            this.f6582i = l(xmlPullParser, "Duration");
            this.f6583j = j(xmlPullParser, "DVRWindowLength", 0);
            this.f6584k = i(xmlPullParser, "LookaheadCount", -1);
            this.l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f6581h));
        }
    }

    /* access modifiers changed from: private */
    public static class e extends a {

        /* renamed from: e  reason: collision with root package name */
        private final String f6585e;

        /* renamed from: f  reason: collision with root package name */
        private final List<com.google.android.exoplayer2.l> f6586f = new LinkedList();

        /* renamed from: g  reason: collision with root package name */
        private int f6587g;

        /* renamed from: h  reason: collision with root package name */
        private String f6588h;

        /* renamed from: i  reason: collision with root package name */
        private long f6589i;

        /* renamed from: j  reason: collision with root package name */
        private String f6590j;

        /* renamed from: k  reason: collision with root package name */
        private String f6591k;
        private int l;
        private int m;
        private int n;
        private int o;
        private String p;
        private ArrayList<Long> q;
        private long r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f6585e = str;
        }

        private void q(XmlPullParser xmlPullParser) {
            int s = s(xmlPullParser);
            this.f6587g = s;
            p("Type", Integer.valueOf(s));
            if (this.f6587g == 3) {
                this.f6588h = m(xmlPullParser, "Subtype");
            } else {
                this.f6588h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            this.f6590j = xmlPullParser.getAttributeValue(null, "Name");
            this.f6591k = m(xmlPullParser, "Url");
            this.l = i(xmlPullParser, "MaxWidth", -1);
            this.m = i(xmlPullParser, "MaxHeight", -1);
            this.n = i(xmlPullParser, "DisplayWidth", -1);
            this.o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
            this.p = attributeValue;
            p("Language", attributeValue);
            long i2 = (long) i(xmlPullParser, "TimeScale", -1);
            this.f6589i = i2;
            if (i2 == -1) {
                this.f6589i = ((Long) c("TimeScale")).longValue();
            }
            this.q = new ArrayList<>();
        }

        private void r(XmlPullParser xmlPullParser) {
            int size = this.q.size();
            long j2 = j(xmlPullParser, "t", -9223372036854775807L);
            int i2 = 1;
            if (j2 == -9223372036854775807L) {
                if (size == 0) {
                    j2 = 0;
                } else if (this.r != -1) {
                    j2 = this.q.get(size - 1).longValue() + this.r;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            this.q.add(Long.valueOf(j2));
            this.r = j(xmlPullParser, "d", -9223372036854775807L);
            long j3 = j(xmlPullParser, "r", 1);
            if (j3 <= 1 || this.r != -9223372036854775807L) {
                while (true) {
                    long j4 = (long) i2;
                    if (j4 < j3) {
                        this.q.add(Long.valueOf((this.r * j4) + j2));
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
        }

        private int s(XmlPullParser xmlPullParser) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            } else if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            } else {
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw new ParserException("Invalid key value[" + attributeValue + "]");
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof com.google.android.exoplayer2.l) {
                this.f6586f.add((com.google.android.exoplayer2.l) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            com.google.android.exoplayer2.l[] lVarArr = new com.google.android.exoplayer2.l[this.f6586f.size()];
            this.f6586f.toArray(lVarArr);
            return new a.b(this.f6585e, this.f6591k, this.f6587g, this.f6588h, this.f6589i, this.f6590j, this.l, this.m, this.n, this.o, this.p, lVarArr, this.q, this.r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f6569a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b */
    public a a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f6569a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (a) new d(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new ParserException(e2);
        }
    }
}
