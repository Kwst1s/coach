package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.p;

@TargetApi(16)
/* compiled from: MediaCodecInfo */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f5999a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6000b;

    /* renamed from: c  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f6001c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6002d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f6003e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6004f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6005g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6006h;

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        e.e(str);
        this.f5999a = str;
        this.f6000b = str2;
        this.f6001c = codecCapabilities;
        this.f6005g = z;
        boolean z4 = true;
        this.f6002d = !z2 && codecCapabilities != null && e(codecCapabilities);
        this.f6003e = codecCapabilities != null && o(codecCapabilities);
        if (!z3 && (codecCapabilities == null || !m(codecCapabilities))) {
            z4 = false;
        }
        this.f6004f = z4;
        this.f6006h = p.m(str2);
    }

    private static int a(String str, String str2, int i2) {
        int i3;
        if (i2 > 1 || ((d0.f7006a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i2;
        }
        if ("audio/ac3".equals(str2)) {
            i3 = 6;
        } else {
            i3 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        m.f("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]");
        return i3;
    }

    @TargetApi(21)
    private static boolean c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (d2 == -1.0d || d2 <= Utils.DOUBLE_EPSILON) {
            return videoCapabilities.isSizeSupported(i2, i3);
        }
        return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return d0.f7006a >= 19 && f(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean m(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return d0.f7006a >= 21 && n(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean n(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean o(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return d0.f7006a >= 21 && p(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean p(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void r(String str) {
        m.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f5999a + ", " + this.f6000b + "] [" + d0.f7010e + "]");
    }

    private void s(String str) {
        m.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f5999a + ", " + this.f6000b + "] [" + d0.f7010e + "]");
    }

    public static a t(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, false, z, z2);
    }

    public static a u(String str) {
        return new a(str, null, null, true, false, false);
    }

    @TargetApi(21)
    public Point b(int i2, int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6001c;
        if (codecCapabilities == null) {
            s("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            s("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(d0.h(i2, widthAlignment) * widthAlignment, d0.h(i3, heightAlignment) * heightAlignment);
    }

    public MediaCodecInfo.CodecProfileLevel[] d() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6001c;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public boolean g(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6001c;
        if (codecCapabilities == null) {
            s("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            s("channelCount.aCaps");
            return false;
        } else if (a(this.f5999a, this.f6000b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
            return true;
        } else {
            s("channelCount.support, " + i2);
            return false;
        }
    }

    @TargetApi(21)
    public boolean h(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6001c;
        if (codecCapabilities == null) {
            s("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            s("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        } else {
            s("sampleRate.support, " + i2);
            return false;
        }
    }

    public boolean i(String str) {
        String d2;
        if (str == null || this.f6000b == null || (d2 = p.d(str)) == null) {
            return true;
        }
        if (!this.f6000b.equals(d2)) {
            s("codec.mime " + str + ", " + d2);
            return false;
        }
        Pair<Integer, Integer> f2 = MediaCodecUtil.f(str);
        if (f2 == null) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] d3 = d();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : d3) {
            if (codecProfileLevel.profile == ((Integer) f2.first).intValue() && codecProfileLevel.level >= ((Integer) f2.second).intValue()) {
                return true;
            }
        }
        s("codec.profileLevel, " + str + ", " + d2);
        return false;
    }

    public boolean j(l lVar) {
        int i2;
        boolean z = false;
        if (!i(lVar.f5974e)) {
            return false;
        }
        if (this.f6006h) {
            int i3 = lVar.m;
            if (i3 <= 0 || (i2 = lVar.n) <= 0) {
                return true;
            }
            if (d0.f7006a >= 21) {
                return q(i3, i2, (double) lVar.o);
            }
            if (i3 * i2 <= MediaCodecUtil.m()) {
                z = true;
            }
            if (!z) {
                s("legacyFrameSize, " + lVar.m + "x" + lVar.n);
            }
            return z;
        }
        if (d0.f7006a >= 21) {
            int i4 = lVar.v;
            if (i4 != -1 && !h(i4)) {
                return false;
            }
            int i5 = lVar.u;
            if (i5 == -1 || g(i5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean k(l lVar) {
        if (this.f6006h) {
            return this.f6002d;
        }
        Pair<Integer, Integer> f2 = MediaCodecUtil.f(lVar.f5974e);
        return f2 != null && ((Integer) f2.first).intValue() == 42;
    }

    public boolean l(l lVar, l lVar2, boolean z) {
        if (!this.f6006h) {
            if ("audio/mp4a-latm".equals(this.f6000b) && lVar.f5977h.equals(lVar2.f5977h) && lVar.u == lVar2.u && lVar.v == lVar2.v) {
                Pair<Integer, Integer> f2 = MediaCodecUtil.f(lVar.f5974e);
                Pair<Integer, Integer> f3 = MediaCodecUtil.f(lVar2.f5974e);
                if (!(f2 == null || f3 == null)) {
                    int intValue = ((Integer) f2.first).intValue();
                    int intValue2 = ((Integer) f3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } else if (!lVar.f5977h.equals(lVar2.f5977h) || lVar.p != lVar2.p || ((!this.f6002d && (lVar.m != lVar2.m || lVar.n != lVar2.n)) || ((z || lVar2.t != null) && !d0.b(lVar.t, lVar2.t)))) {
            return false;
        } else {
            return true;
        }
    }

    @TargetApi(21)
    public boolean q(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6001c;
        if (codecCapabilities == null) {
            s("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            s("sizeAndRate.vCaps");
            return false;
        } else if (c(videoCapabilities, i2, i3, d2)) {
            return true;
        } else {
            if (i2 >= i3 || !c(videoCapabilities, i3, i2, d2)) {
                s("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
                return false;
            }
            r("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2);
            return true;
        }
    }

    public String toString() {
        return this.f5999a;
    }
}
