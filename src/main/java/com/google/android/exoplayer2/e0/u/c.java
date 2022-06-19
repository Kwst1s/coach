package com.google.android.exoplayer2.e0.u;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Atom */
public abstract class c {
    public static final int A = d0.B("trun");
    public static final int A0 = d0.B("udta");
    public static final int B = d0.B("sidx");
    public static final int B0 = d0.B("meta");
    public static final int C = d0.B("moov");
    public static final int C0 = d0.B("ilst");
    public static final int D = d0.B("mvhd");
    public static final int D0 = d0.B("mean");
    public static final int E = d0.B("trak");
    public static final int E0 = d0.B("name");
    public static final int F = d0.B("mdia");
    public static final int F0 = d0.B("data");
    public static final int G = d0.B("minf");
    public static final int G0 = d0.B("emsg");
    public static final int H = d0.B("stbl");
    public static final int H0 = d0.B("st3d");
    public static final int I = d0.B("avcC");
    public static final int I0 = d0.B("sv3d");
    public static final int J = d0.B("hvcC");
    public static final int J0 = d0.B("proj");
    public static final int K = d0.B("esds");
    public static final int K0 = d0.B("vp08");
    public static final int L = d0.B("moof");
    public static final int L0 = d0.B("vp09");
    public static final int M = d0.B("traf");
    public static final int M0 = d0.B("vpcC");
    public static final int N = d0.B("mvex");
    public static final int N0 = d0.B("camm");
    public static final int O = d0.B("mehd");
    public static final int O0 = d0.B("alac");
    public static final int P = d0.B("tkhd");
    public static final int P0 = d0.B("alaw");
    public static final int Q = d0.B("edts");
    public static final int Q0 = d0.B("ulaw");
    public static final int R = d0.B("elst");
    public static final int S = d0.B("mdhd");
    public static final int T = d0.B("hdlr");
    public static final int U = d0.B("stsd");
    public static final int V = d0.B("pssh");
    public static final int W = d0.B("sinf");
    public static final int X = d0.B("schm");
    public static final int Y = d0.B("schi");
    public static final int Z = d0.B("tenc");
    public static final int a0 = d0.B("encv");

    /* renamed from: b  reason: collision with root package name */
    public static final int f5192b = d0.B("ftyp");
    public static final int b0 = d0.B("enca");

    /* renamed from: c  reason: collision with root package name */
    public static final int f5193c = d0.B("avc1");
    public static final int c0 = d0.B("frma");

    /* renamed from: d  reason: collision with root package name */
    public static final int f5194d = d0.B("avc3");
    public static final int d0 = d0.B("saiz");

    /* renamed from: e  reason: collision with root package name */
    public static final int f5195e = d0.B("hvc1");
    public static final int e0 = d0.B("saio");

    /* renamed from: f  reason: collision with root package name */
    public static final int f5196f = d0.B("hev1");
    public static final int f0 = d0.B("sbgp");

    /* renamed from: g  reason: collision with root package name */
    public static final int f5197g = d0.B("s263");
    public static final int g0 = d0.B("sgpd");

    /* renamed from: h  reason: collision with root package name */
    public static final int f5198h = d0.B("d263");
    public static final int h0 = d0.B("uuid");

    /* renamed from: i  reason: collision with root package name */
    public static final int f5199i = d0.B("mdat");
    public static final int i0 = d0.B("senc");

    /* renamed from: j  reason: collision with root package name */
    public static final int f5200j = d0.B("mp4a");
    public static final int j0 = d0.B("pasp");

    /* renamed from: k  reason: collision with root package name */
    public static final int f5201k = d0.B(".mp3");
    public static final int k0 = d0.B("TTML");
    public static final int l = d0.B("wave");
    public static final int l0 = d0.B("mp4v");
    public static final int m = d0.B("lpcm");
    public static final int m0 = d0.B("stts");
    public static final int n = d0.B("sowt");
    public static final int n0 = d0.B("stss");
    public static final int o = d0.B("ac-3");
    public static final int o0 = d0.B("ctts");
    public static final int p = d0.B("dac3");
    public static final int p0 = d0.B("stsc");
    public static final int q = d0.B("ec-3");
    public static final int q0 = d0.B("stsz");
    public static final int r = d0.B("dec3");
    public static final int r0 = d0.B("stz2");
    public static final int s = d0.B("dtsc");
    public static final int s0 = d0.B("stco");
    public static final int t = d0.B("dtsh");
    public static final int t0 = d0.B("co64");
    public static final int u = d0.B("dtsl");
    public static final int u0 = d0.B("tx3g");
    public static final int v = d0.B("dtse");
    public static final int v0 = d0.B("wvtt");
    public static final int w = d0.B("ddts");
    public static final int w0 = d0.B("stpp");
    public static final int x = d0.B("tfdt");
    public static final int x0 = d0.B("c608");
    public static final int y = d0.B("tfhd");
    public static final int y0 = d0.B("samr");
    public static final int z = d0.B("trex");
    public static final int z0 = d0.B("sawb");

    /* renamed from: a  reason: collision with root package name */
    public final int f5202a;

    /* access modifiers changed from: package-private */
    /* compiled from: Atom */
    public static final class a extends c {
        public final long R0;
        public final List<b> S0 = new ArrayList();
        public final List<a> T0 = new ArrayList();

        public a(int i2, long j2) {
            super(i2);
            this.R0 = j2;
        }

        public void d(a aVar) {
            this.T0.add(aVar);
        }

        public void e(b bVar) {
            this.S0.add(bVar);
        }

        public a f(int i2) {
            int size = this.T0.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.T0.get(i3);
                if (aVar.f5202a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        public b g(int i2) {
            int size = this.S0.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.S0.get(i3);
                if (bVar.f5202a == i2) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.e0.u.c
        public String toString() {
            return c.a(this.f5202a) + " leaves: " + Arrays.toString(this.S0.toArray()) + " containers: " + Arrays.toString(this.T0.toArray());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Atom */
    public static final class b extends c {
        public final s R0;

        public b(int i2, s sVar) {
            super(i2);
            this.R0 = sVar;
        }
    }

    static {
        d0.B("vmhd");
    }

    public c(int i2) {
        this.f5202a = i2;
    }

    public static String a(int i2) {
        return BuildConfig.FLAVOR + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static int c(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return a(this.f5202a);
    }
}
