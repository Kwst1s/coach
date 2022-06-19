package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.v;
import java.io.IOException;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v.a f6316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f6317c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v.b f6318d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ v.c f6319e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f6320f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6321g;

    public /* synthetic */ e(v.a aVar, v vVar, v.b bVar, v.c cVar, IOException iOException, boolean z) {
        this.f6316b = aVar;
        this.f6317c = vVar;
        this.f6318d = bVar;
        this.f6319e = cVar;
        this.f6320f = iOException;
        this.f6321g = z;
    }

    public final void run() {
        this.f6316b.l(this.f6317c, this.f6318d, this.f6319e, this.f6320f, this.f6321g);
    }
}
