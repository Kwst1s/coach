package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.e0.u.j;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HlsPlaylistParser */
public final class g implements v.a<f> {
    private static final Pattern A = c("AUTOSELECT");
    private static final Pattern B = c("DEFAULT");
    private static final Pattern C = c("FORCED");
    private static final Pattern D = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern E = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern F = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f6488b = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f6489c = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f6490d = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f6491e = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f6492f = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f6493g = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f6494h = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f6495i = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f6496j = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f6497k = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern l = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern m = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern n = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern o = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern p = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern q = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern r = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern s = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern t = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern u = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern v = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern w = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern x = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern y = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern z = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: a  reason: collision with root package name */
    private final d f6498a;

    /* access modifiers changed from: private */
    /* compiled from: HlsPlaylistParser */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f6499a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f6500b;

        /* renamed from: c  reason: collision with root package name */
        private String f6501c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f6500b = queue;
            this.f6499a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.f6501c != null) {
                return true;
            }
            if (!this.f6500b.isEmpty()) {
                this.f6501c = this.f6500b.poll();
                return true;
            }
            do {
                String readLine = this.f6499a.readLine();
                this.f6501c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f6501c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                return null;
            }
            String str = this.f6501c;
            this.f6501c = null;
            return str;
        }
    }

    public g() {
        this(d.f6458j);
    }

    private static boolean b(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (!(bufferedReader.read() == 187 && bufferedReader.read() == 191)) {
                return false;
            }
            read = bufferedReader.read();
        }
        int r2 = r(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (r2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            r2 = bufferedReader.read();
        }
        return d0.O(r(bufferedReader, false, r2));
    }

    private static Pattern c(String str) {
        return Pattern.compile(str + "=(" + "NO" + "|" + "YES" + ")");
    }

    private static double e(String str, Pattern pattern) {
        return Double.parseDouble(o(str, pattern, Collections.emptyMap()));
    }

    private static int f(String str, Pattern pattern) {
        return Integer.parseInt(o(str, pattern, Collections.emptyMap()));
    }

    private static long g(String str, Pattern pattern) {
        return Long.parseLong(o(str, pattern, Collections.emptyMap()));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static d h(a aVar, String str) {
        char c2;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (aVar.a()) {
            String b2 = aVar.b();
            if (b2.startsWith("#EXT")) {
                arrayList5.add(b2);
            }
            if (b2.startsWith("#EXT-X-DEFINE")) {
                hashMap2.put(o(b2, x, hashMap2), o(b2, D, hashMap2));
            } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z3 = true;
            } else if (b2.startsWith("#EXT-X-MEDIA")) {
                arrayList4.add(b2);
            } else if (b2.startsWith("#EXT-X-STREAM-INF")) {
                z2 |= b2.contains("CLOSED-CAPTIONS=NONE");
                int f2 = f(b2, f6490d);
                String l2 = l(b2, f6488b, hashMap2);
                if (l2 != null) {
                    f2 = Integer.parseInt(l2);
                }
                String l3 = l(b2, f6491e, hashMap2);
                String l4 = l(b2, f6492f, hashMap2);
                if (l4 != null) {
                    String[] split = l4.split("x");
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt <= 0 || parseInt2 <= 0) {
                        i6 = -1;
                        i5 = -1;
                    } else {
                        i5 = parseInt2;
                        i6 = parseInt;
                    }
                    i4 = i6;
                    i3 = i5;
                } else {
                    i4 = -1;
                    i3 = -1;
                }
                String l5 = l(b2, f6493g, hashMap2);
                float parseFloat = l5 != null ? Float.parseFloat(l5) : -1.0f;
                String l6 = l(b2, f6489c, hashMap2);
                if (!(l6 == null || l3 == null)) {
                    hashMap.put(l6, d0.x(l3, 1));
                }
                String q2 = q(aVar.b(), hashMap2);
                if (hashSet.add(q2)) {
                    arrayList.add(new d.a(q2, l.E(Integer.toString(arrayList.size()), null, "application/x-mpegURL", null, l3, f2, i4, i3, parseFloat, null, 0)));
                }
            }
        }
        l lVar = null;
        int i7 = 0;
        ArrayList arrayList6 = null;
        while (i7 < arrayList4.size()) {
            String str3 = (String) arrayList4.get(i7);
            int n2 = n(str3);
            String l7 = l(str3, t, hashMap2);
            String o2 = o(str3, x, hashMap2);
            String l8 = l(str3, w, hashMap2);
            String l9 = l(str3, y, hashMap2);
            String str4 = l9 + ":" + o2;
            String o3 = o(str3, v, hashMap2);
            o3.hashCode();
            switch (o3.hashCode()) {
                case -959297733:
                    if (o3.equals("SUBTITLES")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -333210994:
                    if (o3.equals("CLOSED-CAPTIONS")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62628790:
                    if (o3.equals("AUDIO")) {
                        c2 = 2;
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
                    arrayList3.add(new d.a(l7, l.y(str4, o2, "application/x-mpegURL", "text/vtt", null, -1, n2, l8)));
                    break;
                case 1:
                    String o4 = o(str3, z, hashMap2);
                    if (o4.startsWith("CC")) {
                        i2 = Integer.parseInt(o4.substring(2));
                        str2 = "application/cea-608";
                    } else {
                        i2 = Integer.parseInt(o4.substring(7));
                        str2 = "application/cea-708";
                    }
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList6.add(l.z(str4, o2, null, str2, null, -1, n2, l8, i2));
                    break;
                case 2:
                    String str5 = (String) hashMap.get(l9);
                    l q3 = l.q(str4, o2, "application/x-mpegURL", str5 != null ? p.d(str5) : null, str5, -1, -1, -1, null, n2, l8);
                    if (l7 != null) {
                        arrayList2.add(new d.a(l7, q3));
                        break;
                    } else {
                        lVar = q3;
                        continue;
                        i7++;
                        arrayList4 = arrayList4;
                        z3 = z3;
                        arrayList = arrayList;
                    }
            }
            lVar = lVar;
            i7++;
            arrayList4 = arrayList4;
            z3 = z3;
            arrayList = arrayList;
        }
        return new d(str, arrayList5, arrayList, arrayList2, arrayList3, lVar, z2 ? Collections.emptyList() : arrayList6, z3, hashMap2);
    }

    private static e i(d dVar, a aVar, String str) {
        TreeMap treeMap;
        com.google.android.exoplayer2.drm.l lVar;
        l.b bVar;
        d dVar2 = dVar;
        boolean z2 = dVar2.f6487c;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap2 = new TreeMap();
        int i2 = 0;
        int i3 = 1;
        boolean z3 = z2;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        String str2 = BuildConfig.FLAVOR;
        boolean z4 = false;
        int i4 = 0;
        String str3 = null;
        long j4 = 0;
        int i5 = 0;
        long j5 = 0;
        int i6 = 1;
        boolean z5 = false;
        com.google.android.exoplayer2.drm.l lVar2 = null;
        long j6 = 0;
        long j7 = 0;
        com.google.android.exoplayer2.drm.l lVar3 = null;
        boolean z6 = false;
        long j8 = -1;
        int i7 = 0;
        long j9 = 0;
        String str4 = null;
        String str5 = null;
        e.a aVar2 = null;
        loop0:
        while (true) {
            long j10 = 0;
            while (aVar.a()) {
                String b2 = aVar.b();
                if (b2.startsWith("#EXT")) {
                    arrayList2.add(b2);
                }
                if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String o2 = o(b2, f6496j, hashMap);
                    if ("VOD".equals(o2)) {
                        i4 = 1;
                    } else if ("EVENT".equals(o2)) {
                        i4 = 2;
                    }
                } else if (b2.startsWith("#EXT-X-START")) {
                    j2 = (long) (e(b2, n) * 1000000.0d);
                } else if (b2.startsWith("#EXT-X-MAP")) {
                    String o3 = o(b2, t, hashMap);
                    String l2 = l(b2, p, hashMap);
                    if (l2 != null) {
                        String[] split = l2.split("@");
                        j8 = Long.parseLong(split[i2]);
                        if (split.length > i3) {
                            j6 = Long.parseLong(split[i3]);
                        }
                    }
                    aVar2 = new e.a(o3, j6, j8);
                    j6 = 0;
                    j8 = -1;
                } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                    j3 = 1000000 * ((long) f(b2, f6494h));
                } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j7 = g(b2, f6497k);
                    j5 = j7;
                } else if (b2.startsWith("#EXT-X-VERSION")) {
                    i6 = f(b2, f6495i);
                } else {
                    if (b2.startsWith("#EXT-X-DEFINE")) {
                        String l3 = l(b2, E, hashMap);
                        if (l3 != null) {
                            String str6 = dVar2.f6464i.get(l3);
                            if (str6 != null) {
                                hashMap.put(l3, str6);
                            }
                        } else {
                            hashMap.put(o(b2, x, hashMap), o(b2, D, hashMap));
                        }
                    } else if (b2.startsWith("#EXTINF")) {
                        str2 = k(b2, m, BuildConfig.FLAVOR, hashMap);
                        j10 = (long) (e(b2, l) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-KEY")) {
                        String o4 = o(b2, q, hashMap);
                        String k2 = k(b2, r, "identity", hashMap);
                        if ("NONE".equals(o4)) {
                            treeMap2.clear();
                            lVar3 = null;
                            str4 = null;
                            str5 = null;
                        } else {
                            String l4 = l(b2, u, hashMap);
                            if (!"identity".equals(k2)) {
                                if (str3 == null) {
                                    str3 = ("SAMPLE-AES-CENC".equals(o4) || "SAMPLE-AES-CTR".equals(o4)) ? "cenc" : "cbcs";
                                }
                                if ("com.microsoft.playready".equals(k2)) {
                                    bVar = m(b2, hashMap);
                                } else {
                                    bVar = p(b2, k2, hashMap);
                                }
                                if (bVar != null) {
                                    treeMap2.put(k2, bVar);
                                    str5 = l4;
                                    lVar3 = null;
                                    str4 = null;
                                }
                            } else if ("AES-128".equals(o4)) {
                                str4 = o(b2, t, hashMap);
                                str5 = l4;
                            }
                            str5 = l4;
                            str4 = null;
                        }
                    } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = o(b2, o, hashMap).split("@");
                        j8 = Long.parseLong(split2[i2]);
                        if (split2.length > i3) {
                            j6 = Long.parseLong(split2[i3]);
                        }
                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i5 = Integer.parseInt(b2.substring(b2.indexOf(58) + i3));
                        z4 = true;
                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                        i7++;
                    } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j4 == 0) {
                            j4 = com.google.android.exoplayer2.d.a(d0.U(b2.substring(b2.indexOf(58) + i3))) - j9;
                        }
                    } else if (b2.equals("#EXT-X-GAP")) {
                        z6 = true;
                    } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        z3 = true;
                    } else if (b2.equals("#EXT-X-ENDLIST")) {
                        z5 = true;
                    } else if (!b2.startsWith("#")) {
                        String hexString = str4 == null ? null : str5 != null ? str5 : Long.toHexString(j7);
                        long j11 = j7 + 1;
                        if (j8 == -1) {
                            j6 = 0;
                        }
                        if (lVar3 != null || treeMap2.isEmpty()) {
                            treeMap = treeMap2;
                            lVar = lVar3;
                        } else {
                            l.b[] bVarArr = (l.b[]) treeMap2.values().toArray(new l.b[i2]);
                            lVar = new com.google.android.exoplayer2.drm.l(str3, bVarArr);
                            if (lVar2 == null) {
                                l.b[] bVarArr2 = new l.b[bVarArr.length];
                                int i8 = 0;
                                while (i8 < bVarArr.length) {
                                    bVarArr2[i8] = bVarArr[i8].l(null);
                                    i8++;
                                    treeMap2 = treeMap2;
                                }
                                treeMap = treeMap2;
                                lVar2 = new com.google.android.exoplayer2.drm.l(str3, bVarArr2);
                            } else {
                                treeMap = treeMap2;
                            }
                        }
                        arrayList.add(new e.a(q(b2, hashMap), aVar2, str2, j10, i7, j9, lVar, str4, hexString, j6, j8, z6));
                        j9 += j10;
                        if (j8 != -1) {
                            j6 += j8;
                        }
                        dVar2 = dVar;
                        str2 = BuildConfig.FLAVOR;
                        j7 = j11;
                        lVar3 = lVar;
                        j8 = -1;
                        treeMap2 = treeMap;
                        i2 = 0;
                        i3 = 1;
                        z6 = false;
                    }
                    dVar2 = dVar;
                    treeMap2 = treeMap2;
                    i2 = 0;
                    i3 = 1;
                }
            }
            break loop0;
        }
        return new e(i4, str, arrayList2, j2, j4, z4, i5, j5, i6, j3, z3, z5, j4 != 0, lVar2, arrayList);
    }

    private static boolean j(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z2;
    }

    private static String k(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : q(str2, map);
    }

    private static String l(String str, Pattern pattern, Map<String, String> map) {
        return k(str, pattern, null, map);
    }

    private static l.b m(String str, Map<String, String> map) {
        if (!"1".equals(k(str, s, "1", map))) {
            return null;
        }
        String o2 = o(str, t, map);
        byte[] decode = Base64.decode(o2.substring(o2.indexOf(44)), 0);
        UUID uuid = com.google.android.exoplayer2.d.f4927e;
        return new l.b(uuid, "video/mp4", j.a(uuid, decode));
    }

    private static int n(String str) {
        int i2 = j(str, B, false) ? 1 : 0;
        if (j(str, C, false)) {
            i2 |= 2;
        }
        return j(str, A, false) ? i2 | 4 : i2;
    }

    private static String o(String str, Pattern pattern, Map<String, String> map) {
        String l2 = l(str, pattern, map);
        if (l2 != null) {
            return l2;
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static l.b p(String str, String str2, Map<String, String> map) {
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String o2 = o(str, t, map);
            return new l.b(com.google.android.exoplayer2.d.f4926d, "video/mp4", Base64.decode(o2.substring(o2.indexOf(44)), 0));
        } else if (!"com.widevine".equals(str2)) {
            return null;
        } else {
            try {
                return new l.b(com.google.android.exoplayer2.d.f4926d, "hls", str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                throw new ParserException(e2);
            }
        }
    }

    private static String q(String str, Map<String, String> map) {
        Matcher matcher = F.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int r(BufferedReader bufferedReader, boolean z2, int i2) {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !d0.O(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    /* renamed from: d */
    public f a(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                arrayDeque.add(trim);
                                d h2 = h(new a(arrayDeque, bufferedReader), uri.toString());
                                d0.k(bufferedReader);
                                return h2;
                            } else if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                arrayDeque.add(trim);
                            } else {
                                arrayDeque.add(trim);
                            }
                        }
                    } else {
                        d0.k(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return i(this.f6498a, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            d0.k(bufferedReader);
        }
    }

    public g(d dVar) {
        this.f6498a = dVar;
    }
}
