package android.support.v4.media;

import a.b.a.a.b;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

class MediaBrowserCompat$SearchResultReceiver extends b {

    /* renamed from: d  reason: collision with root package name */
    private final String f23d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f24e;

    /* renamed from: f  reason: collision with root package name */
    private final c f25f;

    /* access modifiers changed from: protected */
    @Override // a.b.a.a.b
    public void g(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.f25f.a(this.f23d, this.f24e);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        ArrayList arrayList = null;
        if (parcelableArray != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
            }
        }
        this.f25f.b(this.f23d, this.f24e, arrayList);
    }
}
