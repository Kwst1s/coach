package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.text.k.c;
import com.google.android.exoplayer2.text.r.b;
import com.google.android.exoplayer2.text.r.g;

/* compiled from: SubtitleDecoderFactory */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f6659a = new a();

    /* compiled from: SubtitleDecoderFactory */
    static class a implements f {
        a() {
        }

        @Override // com.google.android.exoplayer2.text.f
        public boolean a(l lVar) {
            String str = lVar.f5977h;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // com.google.android.exoplayer2.text.f
        public e b(l lVar) {
            String str = lVar.f5977h;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals("application/pgs")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new com.google.android.exoplayer2.text.l.a(lVar.f5979j);
                case 1:
                    return new com.google.android.exoplayer2.text.m.a();
                case 2:
                    return new b();
                case 3:
                    return new g();
                case 4:
                    return new com.google.android.exoplayer2.text.q.a(lVar.f5979j);
                case 5:
                    return new com.google.android.exoplayer2.text.n.a(lVar.f5979j);
                case 6:
                case 7:
                    return new com.google.android.exoplayer2.text.k.a(lVar.f5977h, lVar.B);
                case '\b':
                    return new c(lVar.B, lVar.f5979j);
                case '\t':
                    return new com.google.android.exoplayer2.text.o.a();
                case '\n':
                    return new com.google.android.exoplayer2.text.p.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(l lVar);

    e b(l lVar);
}
