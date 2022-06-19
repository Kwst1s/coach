package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.constraintlayout.widget.i;
import java.util.ArrayList;

/* compiled from: MimeTypes */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<a> f7036a = new ArrayList<>();

    /* access modifiers changed from: private */
    /* compiled from: MimeTypes */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f7037a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7038b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7039c;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : d0.e0(str)) {
            String d2 = d(str2);
            if (d2 != null && k(d2)) {
                return d2;
            }
        }
        return null;
    }

    private static String b(String str) {
        int size = f7036a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f7036a.get(i2);
            if (str.startsWith(aVar.f7038b)) {
                return aVar.f7037a;
            }
        }
        return null;
    }

    public static int c(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 1;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
                return 6;
            case 1:
                return 7;
            case 2:
                return 5;
            case 4:
                return 8;
            case 5:
                return 14;
            default:
                return 0;
        }
    }

    public static String d(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            if (trim.startsWith("mp4a.")) {
                String substring = trim.substring(5);
                if (substring.length() >= 2) {
                    try {
                        str2 = e(Integer.parseInt(d0.i0(substring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (trim.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (trim.startsWith("opus")) {
                return "audio/opus";
            }
            if (trim.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            return b(trim);
        }
    }

    public static String e(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case i.w0:
            case i.x0:
            case i.y0:
            case i.z0:
            case i.A0:
            case i.B0:
                return "video/mpeg2";
            case i.C0:
            case i.D0:
            case i.E0:
                return "audio/mp4a-latm";
            case i.F0:
            case i.G0:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    default:
                        return null;
                }
        }
    }

    private static String f(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (k(str)) {
            return 1;
        }
        if (m(str)) {
            return 2;
        }
        if (l(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return h(str);
    }

    private static int h(String str) {
        int size = f7036a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f7036a.get(i2);
            if (str.equals(aVar.f7037a)) {
                return aVar.f7039c;
            }
        }
        return -1;
    }

    public static int i(String str) {
        return g(d(str));
    }

    public static String j(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : d0.e0(str)) {
            String d2 = d(str2);
            if (d2 != null && m(d2)) {
                return d2;
            }
        }
        return null;
    }

    public static boolean k(String str) {
        return "audio".equals(f(str));
    }

    public static boolean l(String str) {
        return "text".equals(f(str));
    }

    public static boolean m(String str) {
        return "video".equals(f(str));
    }
}
