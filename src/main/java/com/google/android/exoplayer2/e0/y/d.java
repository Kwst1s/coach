package com.google.android.exoplayer2.e0.y;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.w;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;

/* compiled from: WavHeaderReader */
final class d {

    /* access modifiers changed from: private */
    /* compiled from: WavHeaderReader */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f5676a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5677b;

        private a(int i2, long j2) {
            this.f5676a = i2;
            this.f5677b = j2;
        }

        public static a a(h hVar, s sVar) {
            hVar.j(sVar.f7062a, 0, 8);
            sVar.K(0);
            return new a(sVar.j(), sVar.o());
        }
    }

    public static c a(h hVar) {
        e.e(hVar);
        s sVar = new s(16);
        if (a.a(hVar, sVar).f5676a != w.f4881a) {
            return null;
        }
        hVar.j(sVar.f7062a, 0, 4);
        sVar.K(0);
        int j2 = sVar.j();
        if (j2 != w.f4882b) {
            m.c("WavHeaderReader", "Unsupported RIFF format: " + j2);
            return null;
        }
        a a2 = a.a(hVar, sVar);
        while (a2.f5676a != w.f4883c) {
            hVar.k((int) a2.f5677b);
            a2 = a.a(hVar, sVar);
        }
        e.f(a2.f5677b >= 16);
        hVar.j(sVar.f7062a, 0, 16);
        sVar.K(0);
        int q = sVar.q();
        int q2 = sVar.q();
        int p = sVar.p();
        int p2 = sVar.p();
        int q3 = sVar.q();
        int q4 = sVar.q();
        int i2 = (q2 * q4) / 8;
        if (q3 == i2) {
            int a3 = w.a(q, q4);
            if (a3 == 0) {
                m.c("WavHeaderReader", "Unsupported WAV format: " + q4 + " bit/sample, type " + q);
                return null;
            }
            hVar.k(((int) a2.f5677b) - 16);
            return new c(q2, p, p2, q3, q4, a3);
        }
        throw new ParserException("Expected block alignment: " + i2 + "; got: " + q3);
    }

    public static void b(h hVar, c cVar) {
        e.e(hVar);
        e.e(cVar);
        hVar.e();
        s sVar = new s(8);
        a a2 = a.a(hVar, sVar);
        while (a2.f5676a != d0.B("data")) {
            m.f("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f5676a);
            long j2 = a2.f5677b + 8;
            if (a2.f5676a == d0.B("RIFF")) {
                j2 = 12;
            }
            if (j2 <= 2147483647L) {
                hVar.f((int) j2);
                a2 = a.a(hVar, sVar);
            } else {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a2.f5676a);
            }
        }
        hVar.f(8);
        cVar.m(hVar.l(), a2.f5677b);
    }
}
