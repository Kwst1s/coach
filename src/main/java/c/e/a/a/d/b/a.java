package c.e.a.a.d.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.c0;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.n;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class a extends g<h> implements c.e.a.a.d.g {
    private final d A;
    private final Bundle B;
    private final Integer C;
    private final boolean z;

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, boolean z2, @RecentlyNonNull d dVar, @RecentlyNonNull Bundle bundle, @RecentlyNonNull com.google.android.gms.common.api.d dVar2, @RecentlyNonNull e eVar) {
        super(context, looper, 44, dVar, dVar2, eVar);
        this.z = z2;
        this.A = dVar;
        this.B = bundle;
        this.C = dVar.i();
    }

    @RecentlyNonNull
    public static Bundle n0(@RecentlyNonNull d dVar) {
        c.e.a.a.d.a h2 = dVar.h();
        Integer i2 = dVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (i2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i2.intValue());
        }
        if (h2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    @RecentlyNonNull
    public String B() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    @RecentlyNonNull
    public String C() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.api.a.f, com.google.android.gms.common.internal.c
    public int g() {
        return com.google.android.gms.common.g.f7290a;
    }

    @Override // c.e.a.a.d.g
    public final void l(f fVar) {
        n.g(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.A.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b2.name)) {
                googleSignInAccount = com.google.android.gms.auth.api.signin.a.a.a(w()).b();
            }
            Integer num = this.C;
            n.f(num);
            ((h) A()).D(new k(new c0(b2, num.intValue(), googleSignInAccount)), fVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.q(new l(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.a.f, com.google.android.gms.common.internal.c
    public boolean o() {
        return this.z;
    }

    @Override // c.e.a.a.d.g
    public final void p() {
        m(new c.d());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    @RecentlyNonNull
    public /* synthetic */ IInterface r(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof h) {
            return (h) queryLocalInterface;
        }
        return new g(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    @RecentlyNonNull
    public Bundle x() {
        if (!w().getPackageName().equals(this.A.d())) {
            this.B.putString("com.google.android.gms.signin.internal.realClientPackageName", this.A.d());
        }
        return this.B;
    }

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, boolean z2, @RecentlyNonNull d dVar, @RecentlyNonNull c.e.a.a.d.a aVar, @RecentlyNonNull com.google.android.gms.common.api.d dVar2, @RecentlyNonNull e eVar) {
        this(context, looper, true, dVar, n0(dVar), dVar2, eVar);
    }
}
