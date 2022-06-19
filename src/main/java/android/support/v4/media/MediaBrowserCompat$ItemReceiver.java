package android.support.v4.media;

import a.b.a.a.b;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

class MediaBrowserCompat$ItemReceiver extends b {

    /* renamed from: d  reason: collision with root package name */
    private final String f19d;

    /* renamed from: e  reason: collision with root package name */
    private final b f20e;

    /* access modifiers changed from: protected */
    @Override // a.b.a.a.b
    public void g(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.f20e.a(this.f19d);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.f20e.b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.f20e.a(this.f19d);
        }
    }
}
