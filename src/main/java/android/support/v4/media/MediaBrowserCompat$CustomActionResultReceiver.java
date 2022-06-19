package android.support.v4.media;

import a.b.a.a.b;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

class MediaBrowserCompat$CustomActionResultReceiver extends b {

    /* renamed from: d  reason: collision with root package name */
    private final String f16d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f17e;

    /* renamed from: f  reason: collision with root package name */
    private final a f18f;

    /* access modifiers changed from: protected */
    @Override // a.b.a.a.b
    public void g(int i2, Bundle bundle) {
        if (this.f18f != null) {
            MediaSessionCompat.a(bundle);
            if (i2 == -1) {
                this.f18f.a(this.f16d, this.f17e, bundle);
            } else if (i2 == 0) {
                this.f18f.c(this.f16d, this.f17e, bundle);
            } else if (i2 != 1) {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f17e + ", resultData=" + bundle + ")");
            } else {
                this.f18f.b(this.f16d, this.f17e, bundle);
            }
        }
    }
}
