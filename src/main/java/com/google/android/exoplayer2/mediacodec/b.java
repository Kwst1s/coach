package com.google.android.exoplayer2.mediacodec;

import java.util.Collections;
import java.util.List;

/* compiled from: MediaCodecSelector */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6007a = new a();

    /* compiled from: MediaCodecSelector */
    static class a implements b {
        a() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.b
        public a a() {
            return MediaCodecUtil.k();
        }

        @Override // com.google.android.exoplayer2.mediacodec.b
        public List<a> b(String str, boolean z) {
            List<a> h2 = MediaCodecUtil.h(str, z);
            if (h2.isEmpty()) {
                return Collections.emptyList();
            }
            return Collections.singletonList(h2.get(0));
        }
    }

    a a();

    List<a> b(String str, boolean z);
}
