package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: MediaControllerCompat */
public abstract class c implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    final Object f80a;

    /* renamed from: b  reason: collision with root package name */
    a f81b;

    /* renamed from: c  reason: collision with root package name */
    a f82c;

    /* access modifiers changed from: private */
    /* compiled from: MediaControllerCompat */
    public class a extends Handler {
    }

    /* compiled from: MediaControllerCompat */
    private static class b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f83a;

        b(c cVar) {
            this.f83a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.e.a
        public void a(CharSequence charSequence) {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void b() {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.g();
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void c(Object obj) {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.g(obj));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void d(int i2, int i3, int i4, int i5, int i6) {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.a(new d(i2, i3, i4, i5, i6));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void e(Object obj) {
            c cVar = this.f83a.get();
            if (cVar != null && cVar.f82c == null) {
                cVar.d(PlaybackStateCompat.g(obj));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void f(Bundle bundle) {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void g(List<?> list) {
            c cVar = this.f83a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.k(list));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void h(String str, Bundle bundle) {
            c cVar = this.f83a.get();
            if (cVar == null) {
                return;
            }
            if (cVar.f82c == null || Build.VERSION.SDK_INT >= 23) {
                cVar.h(str, bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    /* compiled from: MediaControllerCompat */
    public static class BinderC0007c extends a.AbstractBinderC0005a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f84a;

        BinderC0007c(c cVar) {
            this.f84a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.a
        public void I(boolean z) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void N(PlaybackStateCompat playbackStateCompat) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void O(String str, Bundle bundle) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.a
        public void S(ParcelableVolumeInfo parcelableVolumeInfo) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.f59b, parcelableVolumeInfo.f60c, parcelableVolumeInfo.f61d, parcelableVolumeInfo.f62e, parcelableVolumeInfo.f63f) : null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void a(CharSequence charSequence) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(6, charSequence, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void b() {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void c(int i2) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i2), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void f(Bundle bundle) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(7, bundle, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void g(List<MediaSessionCompat.QueueItem> list) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(5, list, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void m(boolean z) {
        }

        @Override // android.support.v4.media.session.a
        public void p(MediaMetadataCompat mediaMetadataCompat) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(3, mediaMetadataCompat, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void y(int i2) {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i2), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void z() {
            c cVar = this.f84a.get();
            if (cVar != null) {
                cVar.i(13, null, null);
            }
        }
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f80a = e.a(new b(this));
        } else {
            this.f82c = new BinderC0007c(this);
        }
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    public void binderDied() {
        i(8, null, null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void i(int i2, Object obj, Bundle bundle) {
        a aVar = this.f81b;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i2, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }
}
