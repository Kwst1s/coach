package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: GooglePlayMessengerCallback */
public class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f4618a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4619b;

    k(Messenger messenger, String str) {
        this.f4618a = messenger;
        this.f4619b = str;
    }

    private Message b(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i2;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f4619b);
        obtain.setData(bundle);
        return obtain;
    }

    @Override // com.firebase.jobdispatcher.o
    public void a(int i2) {
        try {
            this.f4618a.send(b(i2));
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }
}
