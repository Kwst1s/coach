package com.google.android.exoplayer2.e0.s;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.h0.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: MatroskaExtractor */
public final class e implements g {
    private static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] b0 = d0.K("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] c0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] d0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID e0 = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private n B;
    private n C;
    private boolean D;
    private int E;
    private long F;
    private long G;
    private int H;
    private int I;
    private int[] J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private byte S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private boolean X;
    private i Y;

    /* renamed from: a  reason: collision with root package name */
    private final c f5129a;

    /* renamed from: b  reason: collision with root package name */
    private final g f5130b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<c> f5131c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5132d;

    /* renamed from: e  reason: collision with root package name */
    private final s f5133e;

    /* renamed from: f  reason: collision with root package name */
    private final s f5134f;

    /* renamed from: g  reason: collision with root package name */
    private final s f5135g;

    /* renamed from: h  reason: collision with root package name */
    private final s f5136h;

    /* renamed from: i  reason: collision with root package name */
    private final s f5137i;

    /* renamed from: j  reason: collision with root package name */
    private final s f5138j;

    /* renamed from: k  reason: collision with root package name */
    private final s f5139k;
    private final s l;
    private final s m;
    private ByteBuffer n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private c t;
    private boolean u;
    private int v;
    private long w;
    private boolean x;
    private long y;
    private long z;

    /* compiled from: MatroskaExtractor */
    private final class b implements d {
        private b() {
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void a(int i2) {
            e.this.l(i2);
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public int b(int i2) {
            switch (i2) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 241:
                case 251:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 22186:
                case 22203:
                case 25188:
                case 2352003:
                case 2807729:
                    return 2;
                case 134:
                case 17026:
                case 21358:
                case 2274716:
                    return 3;
                case 160:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    return 1;
                case 161:
                case 163:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    return 4;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                    return 5;
                default:
                    return 0;
            }
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void c(int i2, double d2) {
            e.this.n(i2, d2);
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public boolean d(int i2) {
            return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void e(int i2, int i3, h hVar) {
            e.this.g(i2, i3, hVar);
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void f(int i2, String str) {
            e.this.z(i2, str);
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void g(int i2, long j2, long j3) {
            e.this.y(i2, j2, j3);
        }

        @Override // com.google.android.exoplayer2.e0.s.d
        public void h(int i2, long j2) {
            e.this.o(i2, j2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MatroskaExtractor */
    public static final class c {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public int H;
        public int I;
        public int J;
        public long K;
        public long L;
        public d M;
        public boolean N;
        public boolean O;
        private String P;
        public q Q;
        public int R;

        /* renamed from: a  reason: collision with root package name */
        public String f5141a;

        /* renamed from: b  reason: collision with root package name */
        public String f5142b;

        /* renamed from: c  reason: collision with root package name */
        public int f5143c;

        /* renamed from: d  reason: collision with root package name */
        public int f5144d;

        /* renamed from: e  reason: collision with root package name */
        public int f5145e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5146f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f5147g;

        /* renamed from: h  reason: collision with root package name */
        public q.a f5148h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f5149i;

        /* renamed from: j  reason: collision with root package name */
        public l f5150j;

        /* renamed from: k  reason: collision with root package name */
        public int f5151k;
        public int l;
        public int m;
        public int n;
        public int o;
        public byte[] p;
        public int q;
        public boolean r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public float x;
        public float y;
        public float z;

        private c() {
            this.f5151k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = 0;
            this.p = null;
            this.q = -1;
            this.r = false;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = 1000;
            this.w = 200;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = 1;
            this.I = -1;
            this.J = 8000;
            this.K = 0;
            this.L = 0;
            this.O = true;
            this.P = "eng";
        }

        private byte[] b() {
            if (this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((int) ((this.x * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.y * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.z * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.A * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.B * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.C * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.D * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.E * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) (this.F + 0.5f)));
            wrap.putShort((short) ((int) (this.G + 0.5f)));
            wrap.putShort((short) this.v);
            wrap.putShort((short) this.w);
            return bArr;
        }

        private static Pair<String, List<byte[]>> e(s sVar) {
            try {
                sVar.L(16);
                long o2 = sVar.o();
                if (o2 == 1482049860) {
                    return new Pair<>("video/3gpp", null);
                }
                if (o2 == 826496599) {
                    byte[] bArr = sVar.f7062a;
                    for (int c2 = sVar.c() + 20; c2 < bArr.length - 4; c2++) {
                        if (bArr[c2] == 0 && bArr[c2 + 1] == 0 && bArr[c2 + 2] == 1 && bArr[c2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, c2, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                m.f("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean f(s sVar) {
            try {
                int q2 = sVar.q();
                if (q2 == 1) {
                    return true;
                }
                if (q2 != 65534) {
                    return false;
                }
                sVar.K(24);
                if (sVar.r() == e.e0.getMostSignificantBits() && sVar.r() == e.e0.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> g(byte[] bArr) {
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (bArr[i2] == -1) {
                        i3 += 255;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + bArr[i2];
                    int i6 = 0;
                    while (bArr[i4] == -1) {
                        i6 += 255;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + bArr[i4];
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public void c(i iVar, int i2) {
            char c2;
            int i3;
            int i4;
            List<byte[]> list;
            com.google.android.exoplayer2.l lVar;
            int i5;
            int i6;
            int i7;
            String str;
            int G2;
            String str2;
            String str3;
            List<byte[]> list2;
            String str4 = this.f5142b;
            str4.hashCode();
            int i8 = 1;
            switch (str4.hashCode()) {
                case -2095576542:
                    if (str4.equals("V_MPEG4/ISO/AP")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2095575984:
                    if (str4.equals("V_MPEG4/ISO/SP")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1985379776:
                    if (str4.equals("A_MS/ACM")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1784763192:
                    if (str4.equals("A_TRUEHD")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1730367663:
                    if (str4.equals("A_VORBIS")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1482641358:
                    if (str4.equals("A_MPEG/L2")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1482641357:
                    if (str4.equals("A_MPEG/L3")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1373388978:
                    if (str4.equals("V_MS/VFW/FOURCC")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -933872740:
                    if (str4.equals("S_DVBSUB")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -538363189:
                    if (str4.equals("V_MPEG4/ISO/ASP")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -538363109:
                    if (str4.equals("V_MPEG4/ISO/AVC")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -425012669:
                    if (str4.equals("S_VOBSUB")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -356037306:
                    if (str4.equals("A_DTS/LOSSLESS")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62923557:
                    if (str4.equals("A_AAC")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62923603:
                    if (str4.equals("A_AC3")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62927045:
                    if (str4.equals("A_DTS")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82338133:
                    if (str4.equals("V_VP8")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82338134:
                    if (str4.equals("V_VP9")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99146302:
                    if (str4.equals("S_HDMV/PGS")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 444813526:
                    if (str4.equals("V_THEORA")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 542569478:
                    if (str4.equals("A_DTS/EXPRESS")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 725957860:
                    if (str4.equals("A_PCM/INT/LIT")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 738597099:
                    if (str4.equals("S_TEXT/ASS")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 855502857:
                    if (str4.equals("V_MPEGH/ISO/HEVC")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1422270023:
                    if (str4.equals("S_TEXT/UTF8")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1809237540:
                    if (str4.equals("V_MPEG2")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1950749482:
                    if (str4.equals("A_EAC3")) {
                        c2 = 26;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1950789798:
                    if (str4.equals("A_FLAC")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1951062397:
                    if (str4.equals("A_OPUS")) {
                        c2 = 28;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            String str5 = "audio/x-unknown";
            switch (c2) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr = this.f5149i;
                    if (bArr == null) {
                        list = null;
                    } else {
                        list = Collections.singletonList(bArr);
                    }
                    str = "video/mp4v-es";
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 2:
                    if (f(new s(this.f5149i))) {
                        G2 = d0.G(this.I);
                        if (G2 == 0) {
                            m.f("MatroskaExtractor", "Unsupported PCM bit depth: " + this.I + ". Setting mimeType to " + str5);
                        }
                        i4 = G2;
                        str5 = "audio/raw";
                        list = null;
                        i3 = -1;
                        break;
                    } else {
                        m.f("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + str5);
                    }
                    list = null;
                    i4 = -1;
                    i3 = -1;
                case 3:
                    this.M = new d();
                    str2 = "audio/true-hd";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 4:
                    list = g(this.f5149i);
                    str5 = "audio/vorbis";
                    i4 = -1;
                    i3 = 8192;
                    break;
                case 5:
                    str3 = "audio/mpeg-L2";
                    str5 = str3;
                    list = null;
                    i4 = -1;
                    i3 = 4096;
                    break;
                case 6:
                    str3 = "audio/mpeg";
                    str5 = str3;
                    list = null;
                    i4 = -1;
                    i3 = 4096;
                    break;
                case 7:
                    Pair<String, List<byte[]>> e2 = e(new s(this.f5149i));
                    str = (String) e2.first;
                    list = (List) e2.second;
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case '\b':
                    byte[] bArr2 = this.f5149i;
                    list = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str5 = "application/dvbsubs";
                    i4 = -1;
                    i3 = -1;
                    break;
                case '\n':
                    com.google.android.exoplayer2.h0.h b2 = com.google.android.exoplayer2.h0.h.b(new s(this.f5149i));
                    list2 = b2.f5877a;
                    this.R = b2.f5878b;
                    str = "video/avc";
                    list = list2;
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 11:
                    list = Collections.singletonList(this.f5149i);
                    str5 = "application/vobsub";
                    i4 = -1;
                    i3 = -1;
                    break;
                case '\f':
                    str2 = "audio/vnd.dts.hd";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case '\r':
                    list = Collections.singletonList(this.f5149i);
                    str = "audio/mp4a-latm";
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 14:
                    str2 = "audio/ac3";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 15:
                case 20:
                    str2 = "audio/vnd.dts";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 16:
                    str2 = "video/x-vnd.on2.vp8";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 17:
                    str2 = "video/x-vnd.on2.vp9";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 18:
                    str5 = "application/pgs";
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 19:
                    str2 = "video/x-unknown";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 21:
                    G2 = d0.G(this.I);
                    if (G2 == 0) {
                        m.f("MatroskaExtractor", "Unsupported PCM bit depth: " + this.I + ". Setting mimeType to " + str5);
                        list = null;
                        i4 = -1;
                        i3 = -1;
                        break;
                    }
                    i4 = G2;
                    str5 = "audio/raw";
                    list = null;
                    i3 = -1;
                case 22:
                    str5 = "text/x-ssa";
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 23:
                    k a2 = k.a(new s(this.f5149i));
                    list2 = a2.f5896a;
                    this.R = a2.f5897b;
                    str = "video/hevc";
                    list = list2;
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 24:
                    str5 = "application/x-subrip";
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 25:
                    str2 = "video/mpeg2";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 26:
                    str2 = "audio/eac3";
                    str5 = str2;
                    list = null;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 27:
                    list = Collections.singletonList(this.f5149i);
                    str = "audio/flac";
                    str5 = str;
                    i4 = -1;
                    i3 = -1;
                    break;
                case 28:
                    list = new ArrayList<>(3);
                    list.add(this.f5149i);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.L).array());
                    str5 = "audio/opus";
                    i4 = -1;
                    i3 = 5760;
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i9 = (this.O ? 1 : 0) | 0 | (this.N ? 2 : 0);
            if (p.k(str5)) {
                lVar = com.google.android.exoplayer2.l.s(Integer.toString(i2), str5, null, -1, i3, this.H, this.J, i4, list, this.f5150j, i9, this.P);
            } else if (p.m(str5)) {
                if (this.o == 0) {
                    int i10 = this.m;
                    i5 = -1;
                    if (i10 == -1) {
                        i10 = this.f5151k;
                    }
                    this.m = i10;
                    int i11 = this.n;
                    if (i11 == -1) {
                        i11 = this.l;
                    }
                    this.n = i11;
                } else {
                    i5 = -1;
                }
                int i12 = this.m;
                float f2 = (i12 == i5 || (i7 = this.n) == i5) ? -1.0f : ((float) (this.l * i12)) / ((float) (this.f5151k * i7));
                com.google.android.exoplayer2.h0.i iVar2 = this.r ? new com.google.android.exoplayer2.h0.i(this.s, this.u, this.t, b()) : null;
                if ("htc_video_rotA-000".equals(this.f5141a)) {
                    i6 = 0;
                } else if ("htc_video_rotA-090".equals(this.f5141a)) {
                    i6 = 90;
                } else if ("htc_video_rotA-180".equals(this.f5141a)) {
                    i6 = 180;
                } else {
                    i6 = "htc_video_rotA-270".equals(this.f5141a) ? 270 : -1;
                }
                lVar = com.google.android.exoplayer2.l.G(Integer.toString(i2), str5, null, -1, i3, this.f5151k, this.l, -1.0f, list, i6, f2, this.p, this.q, iVar2, this.f5150j);
                i8 = 2;
            } else {
                if ("application/x-subrip".equals(str5)) {
                    lVar = com.google.android.exoplayer2.l.B(Integer.toString(i2), str5, i9, this.P, this.f5150j);
                } else if ("text/x-ssa".equals(str5)) {
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(e.b0);
                    arrayList.add(this.f5149i);
                    lVar = com.google.android.exoplayer2.l.C(Integer.toString(i2), str5, null, -1, i9, this.P, -1, this.f5150j, Long.MAX_VALUE, arrayList);
                } else if ("application/vobsub".equals(str5) || "application/pgs".equals(str5) || "application/dvbsubs".equals(str5)) {
                    lVar = com.google.android.exoplayer2.l.v(Integer.toString(i2), str5, null, -1, i9, list, this.P, this.f5150j);
                } else {
                    throw new ParserException("Unexpected MIME type.");
                }
                i8 = 3;
            }
            q a3 = iVar.a(this.f5143c, i8);
            this.Q = a3;
            a3.d(lVar);
        }

        public void d() {
            d dVar = this.M;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        public void h() {
            d dVar = this.M;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MatroskaExtractor */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f5152a = new byte[10];

        /* renamed from: b  reason: collision with root package name */
        private boolean f5153b;

        /* renamed from: c  reason: collision with root package name */
        private int f5154c;

        /* renamed from: d  reason: collision with root package name */
        private int f5155d;

        /* renamed from: e  reason: collision with root package name */
        private long f5156e;

        /* renamed from: f  reason: collision with root package name */
        private int f5157f;

        public void a(c cVar) {
            if (this.f5153b && this.f5154c > 0) {
                cVar.Q.c(this.f5156e, this.f5157f, this.f5155d, 0, cVar.f5148h);
                this.f5154c = 0;
            }
        }

        public void b() {
            this.f5153b = false;
        }

        public void c(c cVar, long j2) {
            if (this.f5153b) {
                int i2 = this.f5154c;
                int i3 = i2 + 1;
                this.f5154c = i3;
                if (i2 == 0) {
                    this.f5156e = j2;
                }
                if (i3 >= 16) {
                    cVar.Q.c(this.f5156e, this.f5157f, this.f5155d, 0, cVar.f5148h);
                    this.f5154c = 0;
                }
            }
        }

        public void d(h hVar, int i2, int i3) {
            if (!this.f5153b) {
                hVar.j(this.f5152a, 0, 10);
                hVar.e();
                if (com.google.android.exoplayer2.audio.g.j(this.f5152a) != 0) {
                    this.f5153b = true;
                    this.f5154c = 0;
                } else {
                    return;
                }
            }
            if (this.f5154c == 0) {
                this.f5157f = i2;
                this.f5155d = 0;
            }
            this.f5155d += i3;
        }
    }

    static {
        a aVar = a.f5119a;
    }

    public e() {
        this(0);
    }

    private void A(h hVar, c cVar, int i2) {
        int i3;
        if ("S_TEXT/UTF8".equals(cVar.f5142b)) {
            B(hVar, Z, i2);
        } else if ("S_TEXT/ASS".equals(cVar.f5142b)) {
            B(hVar, c0, i2);
        } else {
            q qVar = cVar.Q;
            boolean z2 = true;
            if (!this.O) {
                if (cVar.f5146f) {
                    this.M &= -1073741825;
                    int i4 = 128;
                    if (!this.P) {
                        hVar.readFully(this.f5135g.f7062a, 0, 1);
                        this.N++;
                        byte[] bArr = this.f5135g.f7062a;
                        if ((bArr[0] & 128) != 128) {
                            this.S = bArr[0];
                            this.P = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b2 = this.S;
                    if ((b2 & 1) == 1) {
                        boolean z3 = (b2 & 2) == 2;
                        this.M |= 1073741824;
                        if (!this.Q) {
                            hVar.readFully(this.l.f7062a, 0, 8);
                            this.N += 8;
                            this.Q = true;
                            s sVar = this.f5135g;
                            byte[] bArr2 = sVar.f7062a;
                            if (!z3) {
                                i4 = 0;
                            }
                            bArr2[0] = (byte) (i4 | 8);
                            sVar.K(0);
                            qVar.a(this.f5135g, 1);
                            this.V++;
                            this.l.K(0);
                            qVar.a(this.l, 8);
                            this.V += 8;
                        }
                        if (z3) {
                            if (!this.R) {
                                hVar.readFully(this.f5135g.f7062a, 0, 1);
                                this.N++;
                                this.f5135g.K(0);
                                this.T = this.f5135g.y();
                                this.R = true;
                            }
                            int i5 = this.T * 4;
                            this.f5135g.H(i5);
                            hVar.readFully(this.f5135g.f7062a, 0, i5);
                            this.N += i5;
                            short s2 = (short) ((this.T / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.n;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.n = ByteBuffer.allocate(i6);
                            }
                            this.n.position(0);
                            this.n.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.T;
                                if (i7 >= i3) {
                                    break;
                                }
                                int C2 = this.f5135g.C();
                                if (i7 % 2 == 0) {
                                    this.n.putShort((short) (C2 - i8));
                                } else {
                                    this.n.putInt(C2 - i8);
                                }
                                i7++;
                                i8 = C2;
                            }
                            int i9 = (i2 - this.N) - i8;
                            if (i3 % 2 == 1) {
                                this.n.putInt(i9);
                            } else {
                                this.n.putShort((short) i9);
                                this.n.putInt(0);
                            }
                            this.m.I(this.n.array(), i6);
                            qVar.a(this.m, i6);
                            this.V += i6;
                        }
                    }
                } else {
                    byte[] bArr3 = cVar.f5147g;
                    if (bArr3 != null) {
                        this.f5138j.I(bArr3, bArr3.length);
                    }
                }
                this.O = true;
            }
            int d2 = i2 + this.f5138j.d();
            if (!"V_MPEG4/ISO/AVC".equals(cVar.f5142b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f5142b)) {
                if (cVar.M != null) {
                    if (this.f5138j.d() != 0) {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.util.e.f(z2);
                    cVar.M.d(hVar, this.M, d2);
                }
                while (true) {
                    int i10 = this.N;
                    if (i10 >= d2) {
                        break;
                    }
                    t(hVar, qVar, d2 - i10);
                }
            } else {
                byte[] bArr4 = this.f5134f.f7062a;
                bArr4[0] = 0;
                bArr4[1] = 0;
                bArr4[2] = 0;
                int i11 = cVar.R;
                int i12 = 4 - i11;
                while (this.N < d2) {
                    int i13 = this.U;
                    if (i13 == 0) {
                        u(hVar, bArr4, i12, i11);
                        this.f5134f.K(0);
                        this.U = this.f5134f.C();
                        this.f5133e.K(0);
                        qVar.a(this.f5133e, 4);
                        this.V += 4;
                    } else {
                        this.U = i13 - t(hVar, qVar, i13);
                    }
                }
            }
            if ("A_VORBIS".equals(cVar.f5142b)) {
                this.f5136h.K(0);
                qVar.a(this.f5136h, 4);
                this.V += 4;
            }
        }
    }

    private void B(h hVar, byte[] bArr, int i2) {
        int length = bArr.length + i2;
        if (this.f5139k.b() < length) {
            this.f5139k.f7062a = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.f5139k.f7062a, 0, bArr.length);
        }
        hVar.readFully(this.f5139k.f7062a, bArr.length, i2);
        this.f5139k.H(length);
    }

    private o h() {
        n nVar;
        n nVar2;
        if (this.p == -1 || this.s == -9223372036854775807L || (nVar = this.B) == null || nVar.c() == 0 || (nVar2 = this.C) == null || nVar2.c() != this.B.c()) {
            this.B = null;
            this.C = null;
            return new o.b(this.s);
        }
        int c2 = this.B.c();
        int[] iArr = new int[c2];
        long[] jArr = new long[c2];
        long[] jArr2 = new long[c2];
        long[] jArr3 = new long[c2];
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            jArr3[i3] = this.B.b(i3);
            jArr[i3] = this.p + this.C.b(i3);
        }
        while (true) {
            int i4 = c2 - 1;
            if (i2 < i4) {
                int i5 = i2 + 1;
                iArr[i2] = (int) (jArr[i5] - jArr[i2]);
                jArr2[i2] = jArr3[i5] - jArr3[i2];
                i2 = i5;
            } else {
                iArr[i4] = (int) ((this.p + this.o) - jArr[i4]);
                jArr2[i4] = this.s - jArr3[i4];
                this.B = null;
                this.C = null;
                return new com.google.android.exoplayer2.e0.b(iArr, jArr, jArr2, jArr3);
            }
        }
    }

    private void j(c cVar, long j2) {
        d dVar = cVar.M;
        if (dVar != null) {
            dVar.c(cVar, j2);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f5142b)) {
                k(cVar, "%02d:%02d:%02d,%03d", 19, 1000, a0);
            } else if ("S_TEXT/ASS".equals(cVar.f5142b)) {
                k(cVar, "%01d:%02d:%02d:%02d", 21, 10000, d0);
            }
            cVar.Q.c(j2, this.M, this.V, 0, cVar.f5148h);
        }
        this.W = true;
        v();
    }

    private void k(c cVar, String str, int i2, long j2, byte[] bArr) {
        x(this.f5139k.f7062a, this.G, str, i2, j2, bArr);
        q qVar = cVar.Q;
        s sVar = this.f5139k;
        qVar.a(sVar, sVar.d());
        this.V += this.f5139k.d();
    }

    private static int[] m(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    private static boolean p(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    static /* synthetic */ g[] q() {
        return new g[]{new e()};
    }

    private boolean r(com.google.android.exoplayer2.e0.n nVar, long j2) {
        if (this.x) {
            this.z = j2;
            nVar.f5095a = this.y;
            this.x = false;
            return true;
        }
        if (this.u) {
            long j3 = this.z;
            if (j3 != -1) {
                nVar.f5095a = j3;
                this.z = -1;
                return true;
            }
        }
        return false;
    }

    private void s(h hVar, int i2) {
        if (this.f5135g.d() < i2) {
            if (this.f5135g.b() < i2) {
                s sVar = this.f5135g;
                byte[] bArr = sVar.f7062a;
                sVar.I(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i2)), this.f5135g.d());
            }
            s sVar2 = this.f5135g;
            hVar.readFully(sVar2.f7062a, sVar2.d(), i2 - this.f5135g.d());
            this.f5135g.J(i2);
        }
    }

    private int t(h hVar, q qVar, int i2) {
        int i3;
        int a2 = this.f5138j.a();
        if (a2 > 0) {
            i3 = Math.min(i2, a2);
            qVar.a(this.f5138j, i3);
        } else {
            i3 = qVar.b(hVar, i2, false);
        }
        this.N += i3;
        this.V += i3;
        return i3;
    }

    private void u(h hVar, byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, this.f5138j.a());
        hVar.readFully(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.f5138j.h(bArr, i2, min);
        }
        this.N += i3;
    }

    private void v() {
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = 0;
        this.Q = false;
        this.f5138j.G();
    }

    private long w(long j2) {
        long j3 = this.q;
        if (j3 != -9223372036854775807L) {
            return d0.Z(j2, j3, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void x(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        if (j2 == -9223372036854775807L) {
            bArr4 = bArr2;
            bArr3 = bArr4;
        } else {
            int i3 = (int) (j2 / 3600000000L);
            long j4 = j2 - (((long) (i3 * 3600)) * 1000000);
            int i4 = (int) (j4 / 60000000);
            long j5 = j4 - (((long) (i4 * 60)) * 1000000);
            int i5 = (int) (j5 / 1000000);
            int i6 = (int) ((j5 - (((long) i5) * 1000000)) / j3);
            bArr4 = d0.K(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
            bArr3 = bArr2;
        }
        System.arraycopy(bArr4, 0, bArr, i2, bArr3.length);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.Y = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.A = -9223372036854775807L;
        this.E = 0;
        this.f5129a.e();
        this.f5130b.e();
        v();
        for (int i2 = 0; i2 < this.f5131c.size(); i2++) {
            this.f5131c.valueAt(i2).h();
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        return new f().b(hVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f1, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0243  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(int r20, int r21, com.google.android.exoplayer2.e0.h r22) {
        /*
        // Method dump skipped, instructions count: 673
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.s.e.g(int, int, com.google.android.exoplayer2.e0.h):void");
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, com.google.android.exoplayer2.e0.n nVar) {
        this.W = false;
        boolean z2 = true;
        while (z2 && !this.W) {
            z2 = this.f5129a.a(hVar);
            if (z2 && r(nVar, hVar.l())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f5131c.size(); i2++) {
            this.f5131c.valueAt(i2).d();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void l(int i2) {
        if (i2 != 160) {
            if (i2 == 174) {
                if (p(this.t.f5142b)) {
                    c cVar = this.t;
                    cVar.c(this.Y, cVar.f5143c);
                    SparseArray<c> sparseArray = this.f5131c;
                    c cVar2 = this.t;
                    sparseArray.put(cVar2.f5143c, cVar2);
                }
                this.t = null;
            } else if (i2 == 19899) {
                int i3 = this.v;
                if (i3 != -1) {
                    long j2 = this.w;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.y = j2;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i2 == 25152) {
                c cVar3 = this.t;
                if (!cVar3.f5146f) {
                    return;
                }
                if (cVar3.f5148h != null) {
                    cVar3.f5150j = new l(new l.b(com.google.android.exoplayer2.d.f4923a, "video/webm", this.t.f5148h.f5104b));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i2 == 28032) {
                c cVar4 = this.t;
                if (cVar4.f5146f && cVar4.f5147g != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i2 == 357149030) {
                if (this.q == -9223372036854775807L) {
                    this.q = 1000000;
                }
                long j3 = this.r;
                if (j3 != -9223372036854775807L) {
                    this.s = w(j3);
                }
            } else if (i2 != 374648427) {
                if (i2 == 475249515 && !this.u) {
                    this.Y.e(h());
                    this.u = true;
                }
            } else if (this.f5131c.size() != 0) {
                this.Y.h();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        } else if (this.E == 2) {
            if (!this.X) {
                this.M |= 1;
            }
            j(this.f5131c.get(this.K), this.F);
            this.E = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int i2, double d2) {
        if (i2 == 181) {
            this.t.J = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.t.x = (float) d2;
                    return;
                case 21970:
                    this.t.y = (float) d2;
                    return;
                case 21971:
                    this.t.z = (float) d2;
                    return;
                case 21972:
                    this.t.A = (float) d2;
                    return;
                case 21973:
                    this.t.B = (float) d2;
                    return;
                case 21974:
                    this.t.C = (float) d2;
                    return;
                case 21975:
                    this.t.D = (float) d2;
                    return;
                case 21976:
                    this.t.E = (float) d2;
                    return;
                case 21977:
                    this.t.F = (float) d2;
                    return;
                case 21978:
                    this.t.G = (float) d2;
                    return;
                default:
                    return;
            }
        } else {
            this.r = (long) d2;
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, long j2) {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case 131:
                        this.t.f5144d = (int) j2;
                        return;
                    case 136:
                        c cVar = this.t;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        cVar.O = z2;
                        return;
                    case 155:
                        this.G = w(j2);
                        return;
                    case 159:
                        this.t.H = (int) j2;
                        return;
                    case 176:
                        this.t.f5151k = (int) j2;
                        return;
                    case 179:
                        this.B.a(w(j2));
                        return;
                    case 186:
                        this.t.l = (int) j2;
                        return;
                    case 215:
                        this.t.f5143c = (int) j2;
                        return;
                    case 231:
                        this.A = w(j2);
                        return;
                    case 241:
                        if (!this.D) {
                            this.C.a(j2);
                            this.D = true;
                            return;
                        }
                        return;
                    case 251:
                        this.X = true;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw new ParserException("ContentCompAlgo " + j2 + " not supported");
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw new ParserException("DocTypeReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw new ParserException("EBMLReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw new ParserException("ContentEncAlgo " + j2 + " not supported");
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw new ParserException("AESSettingsCipherMode " + j2 + " not supported");
                        }
                        return;
                    case 21420:
                        this.w = j2 + this.p;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            this.t.q = 0;
                            return;
                        } else if (i3 == 1) {
                            this.t.q = 2;
                            return;
                        } else if (i3 == 3) {
                            this.t.q = 1;
                            return;
                        } else if (i3 == 15) {
                            this.t.q = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.t.m = (int) j2;
                        return;
                    case 21682:
                        this.t.o = (int) j2;
                        return;
                    case 21690:
                        this.t.n = (int) j2;
                        return;
                    case 21930:
                        c cVar2 = this.t;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        cVar2.N = z2;
                        return;
                    case 22186:
                        this.t.K = j2;
                        return;
                    case 22203:
                        this.t.L = j2;
                        return;
                    case 25188:
                        this.t.I = (int) j2;
                        return;
                    case 2352003:
                        this.t.f5145e = (int) j2;
                        return;
                    case 2807729:
                        this.q = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i4 = (int) j2;
                                if (i4 == 1) {
                                    this.t.u = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.t.u = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i5 = (int) j2;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.t.t = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.t.t = 7;
                                        return;
                                    } else if (!(i5 == 6 || i5 == 7)) {
                                        return;
                                    }
                                }
                                this.t.t = 3;
                                return;
                            case 21947:
                                c cVar3 = this.t;
                                cVar3.r = true;
                                int i6 = (int) j2;
                                if (i6 == 1) {
                                    cVar3.s = 1;
                                    return;
                                } else if (i6 == 9) {
                                    cVar3.s = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    cVar3.s = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.t.v = (int) j2;
                                return;
                            case 21949:
                                this.t.w = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw new ParserException("ContentEncodingScope " + j2 + " not supported");
            }
        } else if (j2 != 0) {
            throw new ParserException("ContentEncodingOrder " + j2 + " not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public void y(int i2, long j2, long j3) {
        if (i2 == 160) {
            this.X = false;
        } else if (i2 == 174) {
            this.t = new c();
        } else if (i2 == 187) {
            this.D = false;
        } else if (i2 == 19899) {
            this.v = -1;
            this.w = -1;
        } else if (i2 == 20533) {
            this.t.f5146f = true;
        } else if (i2 == 21968) {
            this.t.r = true;
        } else if (i2 == 408125543) {
            long j4 = this.p;
            if (j4 == -1 || j4 == j2) {
                this.p = j2;
                this.o = j3;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i2 == 475249515) {
            this.B = new n();
            this.C = new n();
        } else if (i2 != 524531317 || this.u) {
        } else {
            if (!this.f5132d || this.y == -1) {
                this.Y.e(new o.b(this.s));
                this.u = true;
                return;
            }
            this.x = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void z(int i2, String str) {
        if (i2 == 134) {
            this.t.f5142b = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                this.t.f5141a = str;
            } else if (i2 == 2274716) {
                this.t.P = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new ParserException("DocType " + str + " not supported");
        }
    }

    public e(int i2) {
        this(new b(), i2);
    }

    e(c cVar, int i2) {
        this.p = -1;
        this.q = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.y = -1;
        this.z = -1;
        this.A = -9223372036854775807L;
        this.f5129a = cVar;
        cVar.b(new b());
        this.f5132d = (i2 & 1) != 0 ? false : true;
        this.f5130b = new g();
        this.f5131c = new SparseArray<>();
        this.f5135g = new s(4);
        this.f5136h = new s(ByteBuffer.allocate(4).putInt(-1).array());
        this.f5137i = new s(4);
        this.f5133e = new s(com.google.android.exoplayer2.util.q.f7040a);
        this.f5134f = new s(4);
        this.f5138j = new s();
        this.f5139k = new s();
        this.l = new s(8);
        this.m = new s();
    }
}
