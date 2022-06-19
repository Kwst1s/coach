package c.e.a.a.d.b;

import android.os.Parcel;
import c.e.a.a.b.a.a;
import c.e.a.a.b.a.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class e extends a implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // c.e.a.a.b.a.a
    public final boolean T(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 3:
                u((com.google.android.gms.common.a) c.a(parcel, com.google.android.gms.common.a.CREATOR), (b) c.a(parcel, b.CREATOR));
                break;
            case 4:
                w((Status) c.a(parcel, Status.CREATOR));
                break;
            case 5:
            default:
                return false;
            case 6:
                F((Status) c.a(parcel, Status.CREATOR));
                break;
            case 7:
                n((Status) c.a(parcel, Status.CREATOR), (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                q((l) c.a(parcel, l.CREATOR));
                break;
            case 9:
                G((j) c.a(parcel, j.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
