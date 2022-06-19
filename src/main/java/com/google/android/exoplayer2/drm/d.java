package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.p;

/* compiled from: lambda */
public final /* synthetic */ class d implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f4984a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f4985b;

    public /* synthetic */ d(r rVar, p.b bVar) {
        this.f4984a = rVar;
        this.f4985b = bVar;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        this.f4984a.t(this.f4985b, mediaDrm, bArr, i2, i3, bArr2);
    }
}
