package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* compiled from: MediaControllerCompatApi21 */
class e {

    /* compiled from: MediaControllerCompatApi21 */
    public interface a {
        void a(CharSequence charSequence);

        void b();

        void c(Object obj);

        void d(int i2, int i3, int i4, int i5, int i6);

        void e(Object obj);

        void f(Bundle bundle);

        void g(List<?> list);

        void h(String str, Bundle bundle);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MediaControllerCompatApi21 */
    public static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f85a;

        public b(T t) {
            this.f85a = t;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f85a.d(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f85a.f(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f85a.c(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f85a.e(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f85a.g(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f85a.a(charSequence);
        }

        public void onSessionDestroyed() {
            this.f85a.b();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f85a.h(str, bundle);
        }
    }

    /* compiled from: MediaControllerCompatApi21 */
    public static class c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return c(a(obj));
        }

        private static int c(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
