package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
public abstract class TagPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    protected final q f5678a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    protected TagPayloadReader(q qVar) {
        this.f5678a = qVar;
    }

    public final void a(s sVar, long j2) {
        if (b(sVar)) {
            c(sVar, j2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(s sVar);

    /* access modifiers changed from: protected */
    public abstract void c(s sVar, long j2);
}
