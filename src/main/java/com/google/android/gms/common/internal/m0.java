package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.h;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class m0 implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l0 f7385b;

    private m0(l0 l0Var) {
        this.f7385b = l0Var;
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f7385b.f7377d) {
                h.a aVar = (h.a) message.obj;
                n0 n0Var = (n0) this.f7385b.f7377d.get(aVar);
                if (n0Var != null && n0Var.h()) {
                    if (n0Var.d()) {
                        n0Var.g("GmsClientSupervisor");
                    }
                    this.f7385b.f7377d.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f7385b.f7377d) {
                h.a aVar2 = (h.a) message.obj;
                n0 n0Var2 = (n0) this.f7385b.f7377d.get(aVar2);
                if (n0Var2 != null && n0Var2.f() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName j2 = n0Var2.j();
                    if (j2 == null) {
                        j2 = aVar2.c();
                    }
                    if (j2 == null) {
                        String b2 = aVar2.b();
                        n.f(b2);
                        j2 = new ComponentName(b2, "unknown");
                    }
                    n0Var2.onServiceDisconnected(j2);
                }
            }
            return true;
        }
    }
}
