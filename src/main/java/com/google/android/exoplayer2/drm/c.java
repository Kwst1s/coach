package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.j;

/* compiled from: lambda */
public final /* synthetic */ class c implements j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.MissingSchemeDataException f4983a;

    public /* synthetic */ c(DefaultDrmSessionManager.MissingSchemeDataException missingSchemeDataException) {
        this.f4983a = missingSchemeDataException;
    }

    @Override // com.google.android.exoplayer2.util.j.a
    public final void a(Object obj) {
        ((k) obj).b(this.f4983a);
    }
}
