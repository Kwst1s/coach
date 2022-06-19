package com.esafirm.imagepicker.features.s;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

/* compiled from: lambda */
public final /* synthetic */ class a implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f4555a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f4557c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Uri f4558d;

    public /* synthetic */ a(c cVar, d dVar, Context context, Uri uri) {
        this.f4555a = cVar;
        this.f4556b = dVar;
        this.f4557c = context;
        this.f4558d = uri;
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f4555a.e(this.f4556b, this.f4557c, this.f4558d, str, uri);
    }
}
