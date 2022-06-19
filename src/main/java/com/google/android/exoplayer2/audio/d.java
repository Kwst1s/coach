package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.j;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.a f4759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f4760c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f4761d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f4762e;

    public /* synthetic */ d(j.a aVar, String str, long j2, long j3) {
        this.f4759b = aVar;
        this.f4760c = str;
        this.f4761d = j2;
        this.f4762e = j3;
    }

    public final void run() {
        this.f4759b.l(this.f4760c, this.f4761d, this.f4762e);
    }
}
