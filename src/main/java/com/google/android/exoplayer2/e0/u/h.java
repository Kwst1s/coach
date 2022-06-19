package com.google.android.exoplayer2.e0.u;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.h.b;
import com.google.android.exoplayer2.f0.h.f;
import com.google.android.exoplayer2.f0.h.i;
import com.google.android.exoplayer2.f0.h.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;

/* compiled from: MetadataUtil */
final class h {
    private static final int A = d0.B("sosn");
    private static final int B = d0.B("tvsh");
    private static final int C = d0.B("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* renamed from: a  reason: collision with root package name */
    private static final int f5267a = d0.B("nam");

    /* renamed from: b  reason: collision with root package name */
    private static final int f5268b = d0.B("trk");

    /* renamed from: c  reason: collision with root package name */
    private static final int f5269c = d0.B("cmt");

    /* renamed from: d  reason: collision with root package name */
    private static final int f5270d = d0.B("day");

    /* renamed from: e  reason: collision with root package name */
    private static final int f5271e = d0.B("ART");

    /* renamed from: f  reason: collision with root package name */
    private static final int f5272f = d0.B("too");

    /* renamed from: g  reason: collision with root package name */
    private static final int f5273g = d0.B("alb");

    /* renamed from: h  reason: collision with root package name */
    private static final int f5274h = d0.B("com");

    /* renamed from: i  reason: collision with root package name */
    private static final int f5275i = d0.B("wrt");

    /* renamed from: j  reason: collision with root package name */
    private static final int f5276j = d0.B("lyr");

    /* renamed from: k  reason: collision with root package name */
    private static final int f5277k = d0.B("gen");
    private static final int l = d0.B("covr");
    private static final int m = d0.B("gnre");
    private static final int n = d0.B("grp");
    private static final int o = d0.B("disk");
    private static final int p = d0.B("trkn");
    private static final int q = d0.B("tmpo");
    private static final int r = d0.B("cpil");
    private static final int s = d0.B("aART");
    private static final int t = d0.B("sonm");
    private static final int u = d0.B("soal");
    private static final int v = d0.B("soar");
    private static final int w = d0.B("soaa");
    private static final int x = d0.B("soco");
    private static final int y = d0.B("rtng");
    private static final int z = d0.B("pgap");

    private static f a(int i2, s sVar) {
        int j2 = sVar.j();
        if (sVar.j() == c.F0) {
            sVar.L(8);
            String t2 = sVar.t(j2 - 16);
            return new f("und", t2, t2);
        }
        m.f("MetadataUtil", "Failed to parse comment attribute: " + c.a(i2));
        return null;
    }

    private static b b(s sVar) {
        int j2 = sVar.j();
        if (sVar.j() == c.F0) {
            int b2 = c.b(sVar.j());
            String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str == null) {
                m.f("MetadataUtil", "Unrecognized cover art flags: " + b2);
                return null;
            }
            sVar.L(4);
            int i2 = j2 - 16;
            byte[] bArr = new byte[i2];
            sVar.h(bArr, 0, i2);
            return new b(str, null, 3, bArr);
        }
        m.f("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    public static a.b c(s sVar) {
        int c2 = sVar.c() + sVar.j();
        int j2 = sVar.j();
        int i2 = (j2 >> 24) & 255;
        if (i2 == 169 || i2 == 65533) {
            int i3 = 16777215 & j2;
            if (i3 == f5269c) {
                f a2 = a(j2, sVar);
                sVar.K(c2);
                return a2;
            } else if (i3 == f5267a || i3 == f5268b) {
                com.google.android.exoplayer2.f0.h.m g2 = g(j2, "TIT2", sVar);
                sVar.K(c2);
                return g2;
            } else if (i3 == f5274h || i3 == f5275i) {
                com.google.android.exoplayer2.f0.h.m g3 = g(j2, "TCOM", sVar);
                sVar.K(c2);
                return g3;
            } else if (i3 == f5270d) {
                com.google.android.exoplayer2.f0.h.m g4 = g(j2, "TDRC", sVar);
                sVar.K(c2);
                return g4;
            } else if (i3 == f5271e) {
                com.google.android.exoplayer2.f0.h.m g5 = g(j2, "TPE1", sVar);
                sVar.K(c2);
                return g5;
            } else if (i3 == f5272f) {
                com.google.android.exoplayer2.f0.h.m g6 = g(j2, "TSSE", sVar);
                sVar.K(c2);
                return g6;
            } else if (i3 == f5273g) {
                com.google.android.exoplayer2.f0.h.m g7 = g(j2, "TALB", sVar);
                sVar.K(c2);
                return g7;
            } else if (i3 == f5276j) {
                com.google.android.exoplayer2.f0.h.m g8 = g(j2, "USLT", sVar);
                sVar.K(c2);
                return g8;
            } else if (i3 == f5277k) {
                com.google.android.exoplayer2.f0.h.m g9 = g(j2, "TCON", sVar);
                sVar.K(c2);
                return g9;
            } else if (i3 == n) {
                com.google.android.exoplayer2.f0.h.m g10 = g(j2, "TIT1", sVar);
                sVar.K(c2);
                return g10;
            }
        } else {
            try {
                if (j2 == m) {
                    return f(sVar);
                }
                if (j2 == o) {
                    com.google.android.exoplayer2.f0.h.m d2 = d(j2, "TPOS", sVar);
                    sVar.K(c2);
                    return d2;
                } else if (j2 == p) {
                    com.google.android.exoplayer2.f0.h.m d3 = d(j2, "TRCK", sVar);
                    sVar.K(c2);
                    return d3;
                } else if (j2 == q) {
                    i h2 = h(j2, "TBPM", sVar, true, false);
                    sVar.K(c2);
                    return h2;
                } else if (j2 == r) {
                    i h3 = h(j2, "TCMP", sVar, true, true);
                    sVar.K(c2);
                    return h3;
                } else if (j2 == l) {
                    b b2 = b(sVar);
                    sVar.K(c2);
                    return b2;
                } else if (j2 == s) {
                    com.google.android.exoplayer2.f0.h.m g11 = g(j2, "TPE2", sVar);
                    sVar.K(c2);
                    return g11;
                } else if (j2 == t) {
                    com.google.android.exoplayer2.f0.h.m g12 = g(j2, "TSOT", sVar);
                    sVar.K(c2);
                    return g12;
                } else if (j2 == u) {
                    com.google.android.exoplayer2.f0.h.m g13 = g(j2, "TSO2", sVar);
                    sVar.K(c2);
                    return g13;
                } else if (j2 == v) {
                    com.google.android.exoplayer2.f0.h.m g14 = g(j2, "TSOA", sVar);
                    sVar.K(c2);
                    return g14;
                } else if (j2 == w) {
                    com.google.android.exoplayer2.f0.h.m g15 = g(j2, "TSOP", sVar);
                    sVar.K(c2);
                    return g15;
                } else if (j2 == x) {
                    com.google.android.exoplayer2.f0.h.m g16 = g(j2, "TSOC", sVar);
                    sVar.K(c2);
                    return g16;
                } else if (j2 == y) {
                    i h4 = h(j2, "ITUNESADVISORY", sVar, false, false);
                    sVar.K(c2);
                    return h4;
                } else if (j2 == z) {
                    i h5 = h(j2, "ITUNESGAPLESS", sVar, false, true);
                    sVar.K(c2);
                    return h5;
                } else if (j2 == A) {
                    com.google.android.exoplayer2.f0.h.m g17 = g(j2, "TVSHOWSORT", sVar);
                    sVar.K(c2);
                    return g17;
                } else if (j2 == B) {
                    com.google.android.exoplayer2.f0.h.m g18 = g(j2, "TVSHOW", sVar);
                    sVar.K(c2);
                    return g18;
                } else if (j2 == C) {
                    i e2 = e(sVar, c2);
                    sVar.K(c2);
                    return e2;
                }
            } finally {
                sVar.K(c2);
            }
        }
        m.b("MetadataUtil", "Skipped unknown metadata entry: " + c.a(j2));
        sVar.K(c2);
        return null;
    }

    private static com.google.android.exoplayer2.f0.h.m d(int i2, String str, s sVar) {
        int j2 = sVar.j();
        if (sVar.j() == c.F0 && j2 >= 22) {
            sVar.L(10);
            int E = sVar.E();
            if (E > 0) {
                String str2 = BuildConfig.FLAVOR + E;
                int E2 = sVar.E();
                if (E2 > 0) {
                    str2 = str2 + "/" + E2;
                }
                return new com.google.android.exoplayer2.f0.h.m(str, null, str2);
            }
        }
        m.f("MetadataUtil", "Failed to parse index/count attribute: " + c.a(i2));
        return null;
    }

    private static i e(s sVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int j2 = sVar.j();
            int j3 = sVar.j();
            sVar.L(4);
            if (j3 == c.D0) {
                str = sVar.t(j2 - 12);
            } else if (j3 == c.E0) {
                str2 = sVar.t(j2 - 12);
            } else {
                if (j3 == c.F0) {
                    i3 = c2;
                    i4 = j2;
                }
                sVar.L(j2 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        sVar.K(i3);
        sVar.L(16);
        return new j(str, str2, sVar.t(i4 - 16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.f0.h.m f(com.google.android.exoplayer2.util.s r3) {
        /*
            int r3 = i(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = com.google.android.exoplayer2.e0.u.h.D
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.google.android.exoplayer2.f0.h.m r1 = new com.google.android.exoplayer2.f0.h.m
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.m.f(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.u.h.f(com.google.android.exoplayer2.util.s):com.google.android.exoplayer2.f0.h.m");
    }

    private static com.google.android.exoplayer2.f0.h.m g(int i2, String str, s sVar) {
        int j2 = sVar.j();
        if (sVar.j() == c.F0) {
            sVar.L(8);
            return new com.google.android.exoplayer2.f0.h.m(str, null, sVar.t(j2 - 16));
        }
        m.f("MetadataUtil", "Failed to parse text attribute: " + c.a(i2));
        return null;
    }

    private static i h(int i2, String str, s sVar, boolean z2, boolean z3) {
        int i3 = i(sVar);
        if (z3) {
            i3 = Math.min(1, i3);
        }
        if (i3 < 0) {
            m.f("MetadataUtil", "Failed to parse uint8 attribute: " + c.a(i2));
            return null;
        } else if (z2) {
            return new com.google.android.exoplayer2.f0.h.m(str, null, Integer.toString(i3));
        } else {
            return new f("und", str, Integer.toString(i3));
        }
    }

    private static int i(s sVar) {
        sVar.L(4);
        if (sVar.j() == c.F0) {
            sVar.L(8);
            return sVar.y();
        }
        m.f("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
