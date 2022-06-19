package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import androidx.core.app.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a  reason: collision with root package name */
    final Object f48a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f49b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<c, a> f50c;

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionCompat.Token f51d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f52b;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f52b.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.f48a) {
                    mediaControllerCompat$MediaControllerImplApi21.f51d.k(b.a.e(d.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerCompat$MediaControllerImplApi21.f51d.l(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerCompat$MediaControllerImplApi21.a();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static class a extends c.BinderC0007c {
        a(c cVar) {
            super(cVar);
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void S(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void a(CharSequence charSequence) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void b() {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void f(Bundle bundle) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void g(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.a, android.support.v4.media.session.c.BinderC0007c
        public void p(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f51d.g() != null) {
            for (c cVar : this.f49b) {
                a aVar = new a(cVar);
                this.f50c.put(cVar, aVar);
                cVar.f82c = aVar;
                try {
                    this.f51d.g().o(aVar);
                    cVar.i(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f49b.clear();
        }
    }
}
