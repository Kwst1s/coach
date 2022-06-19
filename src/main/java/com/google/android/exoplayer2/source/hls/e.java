package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.x.d0;
import com.google.android.exoplayer2.e0.x.i;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.p;
import java.io.EOFException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultHlsExtractorFactory */
public final class e implements h {

    /* renamed from: b  reason: collision with root package name */
    private final int f6371b;

    public e() {
        this(0);
    }

    private static Pair<g, Boolean> b(g gVar) {
        return new Pair<>(gVar, Boolean.valueOf((gVar instanceof com.google.android.exoplayer2.e0.x.g) || (gVar instanceof com.google.android.exoplayer2.e0.x.e) || (gVar instanceof com.google.android.exoplayer2.e0.t.e)));
    }

    private g c(Uri uri, l lVar, List<l> list, com.google.android.exoplayer2.drm.l lVar2, a0 a0Var) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = BuildConfig.FLAVOR;
        }
        if ("text/vtt".equals(lVar.f5977h) || lastPathSegment.endsWith(".webvtt") || lastPathSegment.endsWith(".vtt")) {
            return new p(lVar.A, a0Var);
        }
        if (lastPathSegment.endsWith(".aac")) {
            return new com.google.android.exoplayer2.e0.x.g();
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return new com.google.android.exoplayer2.e0.x.e();
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return new com.google.android.exoplayer2.e0.t.e(0, 0);
        }
        if (!lastPathSegment.endsWith(".mp4") && !lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) && !lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) && !lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return d(this.f6371b, lVar, list, a0Var);
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return new com.google.android.exoplayer2.e0.u.g(0, a0Var, null, lVar2, list);
    }

    private static d0 d(int i2, l lVar, List<l> list, a0 a0Var) {
        int i3 = i2 | 16;
        if (list != null) {
            i3 |= 32;
        } else {
            list = Collections.singletonList(l.A(null, "application/cea-608", 0, null));
        }
        String str = lVar.f5974e;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(p.a(str))) {
                i3 |= 2;
            }
            if (!"video/avc".equals(p.j(str))) {
                i3 |= 4;
            }
        }
        return new d0(2, a0Var, new i(i3, list));
    }

    /* JADX INFO: finally extract failed */
    private static boolean e(g gVar, h hVar) {
        try {
            boolean f2 = gVar.f(hVar);
            hVar.e();
            return f2;
        } catch (EOFException unused) {
            hVar.e();
            return false;
        } catch (Throwable th) {
            hVar.e();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.h
    public Pair<g, Boolean> a(g gVar, Uri uri, l lVar, List<l> list, com.google.android.exoplayer2.drm.l lVar2, a0 a0Var, Map<String, List<String>> map, h hVar) {
        List<l> list2;
        if (gVar == null) {
            g c2 = c(uri, lVar, list, lVar2, a0Var);
            hVar.e();
            if (e(c2, hVar)) {
                return b(c2);
            }
            if (!(c2 instanceof p)) {
                p pVar = new p(lVar.A, a0Var);
                if (e(pVar, hVar)) {
                    return b(pVar);
                }
            }
            if (!(c2 instanceof com.google.android.exoplayer2.e0.x.g)) {
                com.google.android.exoplayer2.e0.x.g gVar2 = new com.google.android.exoplayer2.e0.x.g();
                if (e(gVar2, hVar)) {
                    return b(gVar2);
                }
            }
            if (!(c2 instanceof com.google.android.exoplayer2.e0.x.e)) {
                com.google.android.exoplayer2.e0.x.e eVar = new com.google.android.exoplayer2.e0.x.e();
                if (e(eVar, hVar)) {
                    return b(eVar);
                }
            }
            if (!(c2 instanceof com.google.android.exoplayer2.e0.t.e)) {
                com.google.android.exoplayer2.e0.t.e eVar2 = new com.google.android.exoplayer2.e0.t.e(0, 0);
                if (e(eVar2, hVar)) {
                    return b(eVar2);
                }
            }
            if (!(c2 instanceof com.google.android.exoplayer2.e0.u.g)) {
                if (list != null) {
                    list2 = list;
                } else {
                    list2 = Collections.emptyList();
                }
                com.google.android.exoplayer2.e0.u.g gVar3 = new com.google.android.exoplayer2.e0.u.g(0, a0Var, null, lVar2, list2);
                if (e(gVar3, hVar)) {
                    return b(gVar3);
                }
            }
            if (!(c2 instanceof d0)) {
                d0 d2 = d(this.f6371b, lVar, list, a0Var);
                if (e(d2, hVar)) {
                    return b(d2);
                }
            }
            return b(c2);
        } else if ((gVar instanceof d0) || (gVar instanceof com.google.android.exoplayer2.e0.u.g)) {
            return b(gVar);
        } else {
            if (gVar instanceof p) {
                return b(new p(lVar.A, a0Var));
            }
            if (gVar instanceof com.google.android.exoplayer2.e0.x.g) {
                return b(new com.google.android.exoplayer2.e0.x.g());
            }
            if (gVar instanceof com.google.android.exoplayer2.e0.x.e) {
                return b(new com.google.android.exoplayer2.e0.x.e());
            }
            if (gVar instanceof com.google.android.exoplayer2.e0.t.e) {
                return b(new com.google.android.exoplayer2.e0.t.e());
            }
            throw new IllegalArgumentException("Unexpected previousExtractor type: " + gVar.getClass().getSimpleName());
        }
    }

    public e(int i2) {
        this.f6371b = i2;
    }
}
