package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* compiled from: AudioAttributesImplApi21 */
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f1499a;

    /* renamed from: b  reason: collision with root package name */
    int f1500b = -1;

    b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f1499a.equals(((b) obj).f1499a);
    }

    public int hashCode() {
        return this.f1499a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1499a;
    }
}
