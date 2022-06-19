package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: GooglePlayDriver */
public final class g implements d {

    /* renamed from: a  reason: collision with root package name */
    private final u f4611a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4612b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f4613c;

    /* renamed from: d  reason: collision with root package name */
    private final i f4614d = new i();

    public g(Context context) {
        this.f4612b = context;
        this.f4613c = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f4611a = new c(context);
    }

    private Intent c(r rVar) {
        Intent d2 = d("SCHEDULE_TASK");
        i iVar = this.f4614d;
        Bundle extras = d2.getExtras();
        iVar.h(rVar, extras);
        d2.putExtras(extras);
        return d2;
    }

    private Intent d(String str) {
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", str);
        intent.putExtra("app", this.f4613c);
        intent.putExtra("source", 8);
        intent.putExtra("source_version", 1);
        return intent;
    }

    @Override // com.firebase.jobdispatcher.d
    public u a() {
        return this.f4611a;
    }

    @Override // com.firebase.jobdispatcher.d
    public int b(n nVar) {
        GooglePlayReceiver.h(nVar);
        this.f4612b.sendBroadcast(c(nVar));
        return 0;
    }
}
