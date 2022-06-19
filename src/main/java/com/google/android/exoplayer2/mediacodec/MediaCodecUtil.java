package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import b.a.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5987a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final f f5988b = new f();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<b, List<a>> f5989c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f5990d;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f5991e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f5992f;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f5993g;

    /* renamed from: h  reason: collision with root package name */
    private static int f5994h = -1;

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* access modifiers changed from: private */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f5995a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5996b;

        public b(String str, boolean z) {
            this.f5995a = str;
            this.f5996b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            if (!TextUtils.equals(this.f5995a, bVar.f5995a) || this.f5996b != bVar.f5996b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.f5995a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f5996b ? 1231 : 1237);
        }
    }

    /* access modifiers changed from: private */
    public interface c {
        MediaCodecInfo a(int i2);

        int b();

        boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean d();
    }

    /* access modifiers changed from: private */
    public static final class d implements c {
        private d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int b() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean d() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    public static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final int f5997a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f5998b;

        public e(boolean z) {
            this.f5997a = z ? 1 : 0;
        }

        private void e() {
            if (this.f5998b == null) {
                this.f5998b = new MediaCodecList(this.f5997a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i2) {
            e();
            return this.f5998b[i2];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int b() {
            e();
            return this.f5998b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean d() {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static final class f implements Comparator<a> {
        private f() {
        }

        private static int b(a aVar) {
            String str = aVar.f5999a;
            if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                return -1;
            }
            return (d0.f7006a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : 1;
        }

        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return b(aVar) - b(aVar2);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5990d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        sparseIntArray.put(110, 16);
        sparseIntArray.put(j.G0, 32);
        sparseIntArray.put(244, 64);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f5991e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f5992f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f5993g = sparseIntArray3;
        sparseIntArray3.put(1, 1);
        sparseIntArray3.put(2, 2);
        sparseIntArray3.put(3, 3);
        sparseIntArray3.put(4, 4);
        sparseIntArray3.put(5, 5);
        sparseIntArray3.put(6, 6);
        sparseIntArray3.put(17, 17);
        sparseIntArray3.put(20, 20);
        sparseIntArray3.put(23, 23);
        sparseIntArray3.put(29, 29);
        sparseIntArray3.put(39, 39);
        sparseIntArray3.put(42, 42);
    }

    private static void a(String str, List<a> list) {
        if ("audio/raw".equals(str)) {
            Collections.sort(list, f5988b);
        }
    }

    private static int b(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    private static boolean c(String str) {
        if (d0.f7006a <= 22) {
            String str2 = d0.f7009d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Integer, Integer> d(String str, String[] strArr) {
        int i2;
        if (strArr.length != 3) {
            m.f("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(p.e(Integer.parseInt(strArr[1], 16))) && (i2 = f5993g.get(Integer.parseInt(strArr[2]), -1)) != -1) {
                return new Pair<>(Integer.valueOf(i2), 0);
            }
        } catch (NumberFormatException unused) {
            m.f("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static Pair<Integer, Integer> e(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            m.f("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
                num2 = valueOf;
            } else {
                m.f("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int i2 = f5990d.get(num2.intValue(), -1);
            if (i2 == -1) {
                m.f("MediaCodecUtil", "Unknown AVC profile: " + num2);
                return null;
            }
            int i3 = f5991e.get(num.intValue(), -1);
            if (i3 != -1) {
                return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
            }
            m.f("MediaCodecUtil", "Unknown AVC level: " + num);
            return null;
        } catch (NumberFormatException unused) {
            m.f("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r3.equals("avc1") == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> f(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f(java.lang.String):android.util.Pair");
    }

    public static a g(String str, boolean z) {
        List<a> h2 = h(str, z);
        if (h2.isEmpty()) {
            return null;
        }
        return h2.get(0);
    }

    public static synchronized List<a> h(String str, boolean z) {
        synchronized (MediaCodecUtil.class) {
            b bVar = new b(str, z);
            HashMap<b, List<a>> hashMap = f5989c;
            List<a> list = hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i2 = d0.f7006a;
            c eVar = i2 >= 21 ? new e(z) : new d();
            ArrayList<a> i3 = i(bVar, eVar, str);
            if (z && i3.isEmpty() && 21 <= i2 && i2 <= 23) {
                eVar = new d();
                i3 = i(bVar, eVar, str);
                if (!i3.isEmpty()) {
                    m.f("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + i3.get(0).f5999a);
                }
            }
            if ("audio/eac3-joc".equals(str)) {
                i3.addAll(i(new b("audio/eac3", bVar.f5996b), eVar, str));
            }
            a(str, i3);
            List<a> unmodifiableList = Collections.unmodifiableList(i3);
            hashMap.put(bVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    private static ArrayList<a> i(b bVar, c cVar, String str) {
        int i2;
        Exception e2;
        c cVar2 = cVar;
        try {
            ArrayList<a> arrayList = new ArrayList<>();
            String str2 = bVar.f5995a;
            int b2 = cVar.b();
            boolean d2 = cVar.d();
            int i3 = 0;
            while (i3 < b2) {
                MediaCodecInfo a2 = cVar2.a(i3);
                String name = a2.getName();
                if (l(a2, name, d2, str)) {
                    String[] supportedTypes = a2.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i4 = 0;
                    while (i4 < length) {
                        String str3 = supportedTypes[i4];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str3);
                                boolean c2 = cVar2.c(str2, capabilitiesForType);
                                boolean c3 = c(name);
                                if (d2) {
                                    i2 = b2;
                                    try {
                                        if (bVar.f5996b != c2) {
                                            if (!d2 || bVar.f5996b) {
                                                if (!d2 && c2) {
                                                    arrayList.add(a.t(name + ".secure", str2, capabilitiesForType, c3, true));
                                                    return arrayList;
                                                }
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        if (d0.f7006a <= 23) {
                                        }
                                        m.c("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                        throw e2;
                                    }
                                } else {
                                    i2 = b2;
                                    if (!d2) {
                                    }
                                    arrayList.add(a.t(name + ".secure", str2, capabilitiesForType, c3, true));
                                    return arrayList;
                                }
                                arrayList.add(a.t(name, str2, capabilitiesForType, c3, false));
                            } catch (Exception e4) {
                                e2 = e4;
                                i2 = b2;
                                if (d0.f7006a <= 23 || arrayList.isEmpty()) {
                                    m.c("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                    throw e2;
                                }
                                m.c("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                i4++;
                                cVar2 = cVar;
                                b2 = i2;
                            }
                        } else {
                            i2 = b2;
                        }
                        i4++;
                        cVar2 = cVar;
                        b2 = i2;
                    }
                    continue;
                }
                i3++;
                cVar2 = cVar;
                b2 = b2;
            }
            return arrayList;
        } catch (Exception e5) {
            throw new DecoderQueryException(e5);
        }
    }

    private static Pair<Integer, Integer> j(String str, String[] strArr) {
        int i2;
        if (strArr.length < 4) {
            m.f("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f5987a.matcher(strArr[1]);
        if (!matcher.matches()) {
            m.f("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i2 = 1;
        } else if ("2".equals(group)) {
            i2 = 2;
        } else {
            m.f("MediaCodecUtil", "Unknown HEVC profile string: " + group);
            return null;
        }
        Integer num = f5992f.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i2), num);
        }
        m.f("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
        return null;
    }

    public static a k() {
        a g2 = g("audio/raw", false);
        if (g2 == null) {
            return null;
        }
        return a.u(g2.f5999a);
    }

    private static boolean l(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = d0.f7006a;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if ("OMX.SEC.mp3.dec".equals(str) && "SM-T530".equals(d0.f7009d)) {
            return false;
        }
        if (i2 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = d0.f7007b;
            if ("a70".equals(str3) || ("Xiaomi".equals(d0.f7008c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = d0.f7007b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = d0.f7007b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i2 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(d0.f7008c))) {
            String str6 = d0.f7007b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i2 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(d0.f7008c)) {
            String str7 = d0.f7007b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i2 <= 19 && d0.f7007b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    public static int m() {
        if (f5994h == -1) {
            int i2 = 0;
            a g2 = g("video/avc", false);
            if (g2 != null) {
                MediaCodecInfo.CodecProfileLevel[] d2 = g2.d();
                int length = d2.length;
                int i3 = 0;
                while (i2 < length) {
                    i3 = Math.max(b(d2[i2].level), i3);
                    i2++;
                }
                i2 = Math.max(i3, d0.f7006a >= 21 ? 345600 : 172800);
            }
            f5994h = i2;
        }
        return f5994h;
    }
}
