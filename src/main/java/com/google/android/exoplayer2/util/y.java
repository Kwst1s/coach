package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: SystemHandlerWrapper */
final class y implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f7086a;

    public y(Handler handler) {
        this.f7086a = handler;
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message a(int i2, int i3, int i4) {
        return this.f7086a.obtainMessage(i2, i3, i4);
    }

    @Override // com.google.android.exoplayer2.util.l
    public boolean b(int i2) {
        return this.f7086a.sendEmptyMessage(i2);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message c(int i2, int i3, int i4, Object obj) {
        return this.f7086a.obtainMessage(i2, i3, i4, obj);
    }

    @Override // com.google.android.exoplayer2.util.l
    public boolean d(int i2, long j2) {
        return this.f7086a.sendEmptyMessageAtTime(i2, j2);
    }

    @Override // com.google.android.exoplayer2.util.l
    public void e(int i2) {
        this.f7086a.removeMessages(i2);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message f(int i2, Object obj) {
        return this.f7086a.obtainMessage(i2, obj);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Looper g() {
        return this.f7086a.getLooper();
    }
}
