package com.google.android.exoplayer2.f0;

import com.google.android.exoplayer2.f0.g.b;
import com.google.android.exoplayer2.f0.h.h;
import com.google.android.exoplayer2.l;

/* compiled from: MetadataDecoderFactory */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5706a = new a();

    /* compiled from: MetadataDecoderFactory */
    static class a implements c {
        a() {
        }

        @Override // com.google.android.exoplayer2.f0.c
        public boolean a(l lVar) {
            String str = lVar.f5977h;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.google.android.exoplayer2.f0.c
        public b b(l lVar) {
            String str = lVar.f5977h;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new h();
                case 1:
                    return new b();
                case 2:
                    return new com.google.android.exoplayer2.f0.i.c();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(l lVar);

    b b(l lVar);
}
