package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.a;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.n;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    private int f7125b = 0;

    @RecentlyNonNull
    public static PendingIntent a(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, int i2) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i2, true), 134217728);
    }

    @RecentlyNonNull
    public static Intent b(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f7125b = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                e d2 = e.d(this);
                if (i3 == -1) {
                    d2.q();
                } else if (i3 == 0) {
                    d2.n(new a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f7125b = 0;
            setResult(i3, intent);
        }
        finish();
    }

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        this.f7125b = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7125b = bundle.getInt("resolution");
        }
        if (this.f7125b != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f7125b = 1;
                } catch (ActivityNotFoundException e2) {
                    if (extras.getBoolean("notify_manager", true)) {
                        e.d(this).n(new a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String valueOf = String.valueOf(pendingIntent);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                        sb.append("Activity not found while launching ");
                        sb.append(valueOf);
                        sb.append(".");
                        String sb2 = sb.toString();
                        if (Build.FINGERPRINT.contains("generic")) {
                            sb2 = String.valueOf(sb2).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                        Log.e("GoogleApiActivity", sb2, e2);
                    }
                    this.f7125b = 1;
                    finish();
                } catch (IntentSender.SendIntentException e3) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e3);
                    finish();
                }
            } else {
                n.f(num);
                d.m().n(this, num.intValue(), 2, this);
                this.f7125b = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putInt("resolution", this.f7125b);
        super.onSaveInstanceState(bundle);
    }
}
