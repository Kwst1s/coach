package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.firebase.jobdispatcher.q;

@TargetApi(21)
/* compiled from: GooglePlayMessageHandler */
class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final GooglePlayReceiver f4617a;

    public j(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f4617a = googlePlayReceiver;
    }

    private void a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger != null && string != null) {
            this.f4617a.b().b(this.f4617a.j(new k(messenger, string), data));
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
        }
    }

    private void b(Message message) {
        q.b c2 = GooglePlayReceiver.d().c(message.getData());
        if (c2 != null) {
            e.d(c2.l(), true);
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
        }
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f4617a.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i2 = message.what;
                if (i2 == 1) {
                    a(message);
                } else if (i2 == 2) {
                    b(message);
                } else if (i2 != 4) {
                    Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + message);
                }
            } catch (SecurityException unused) {
                Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            }
        }
    }
}
