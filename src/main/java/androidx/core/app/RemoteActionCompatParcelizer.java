package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1018a = (IconCompat) versionedParcel.v(remoteActionCompat.f1018a, 1);
        remoteActionCompat.f1019b = versionedParcel.l(remoteActionCompat.f1019b, 2);
        remoteActionCompat.f1020c = versionedParcel.l(remoteActionCompat.f1020c, 3);
        remoteActionCompat.f1021d = (PendingIntent) versionedParcel.r(remoteActionCompat.f1021d, 4);
        remoteActionCompat.f1022e = versionedParcel.h(remoteActionCompat.f1022e, 5);
        remoteActionCompat.f1023f = versionedParcel.h(remoteActionCompat.f1023f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f1018a, 1);
        versionedParcel.D(remoteActionCompat.f1019b, 2);
        versionedParcel.D(remoteActionCompat.f1020c, 3);
        versionedParcel.H(remoteActionCompat.f1021d, 4);
        versionedParcel.z(remoteActionCompat.f1022e, 5);
        versionedParcel.z(remoteActionCompat.f1023f, 6);
    }
}
