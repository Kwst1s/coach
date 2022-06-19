package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(VersionedParcel versionedParcel) {
        c cVar = new c();
        cVar.f1501a = versionedParcel.p(cVar.f1501a, 1);
        cVar.f1502b = versionedParcel.p(cVar.f1502b, 2);
        cVar.f1503c = versionedParcel.p(cVar.f1503c, 3);
        cVar.f1504d = versionedParcel.p(cVar.f1504d, 4);
        return cVar;
    }

    public static void write(c cVar, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(cVar.f1501a, 1);
        versionedParcel.F(cVar.f1502b, 2);
        versionedParcel.F(cVar.f1503c, 3);
        versionedParcel.F(cVar.f1504d, 4);
    }
}
