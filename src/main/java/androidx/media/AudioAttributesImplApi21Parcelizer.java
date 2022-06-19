package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static b read(VersionedParcel versionedParcel) {
        b bVar = new b();
        bVar.f1499a = (AudioAttributes) versionedParcel.r(bVar.f1499a, 1);
        bVar.f1500b = versionedParcel.p(bVar.f1500b, 2);
        return bVar;
    }

    public static void write(b bVar, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.H(bVar.f1499a, 1);
        versionedParcel.F(bVar.f1500b, 2);
    }
}
