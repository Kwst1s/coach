package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.firebase.jobdispatcher.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: JobServiceConnection */
public class s implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Map<q, Boolean> f4661a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final l f4662b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f4663c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4664d = false;

    /* renamed from: e  reason: collision with root package name */
    private m f4665e;

    s(l lVar, Context context) {
        this.f4662b = lVar;
        this.f4663c = context;
    }

    private static Bundle a(r rVar) {
        p d2 = GooglePlayReceiver.d();
        Bundle bundle = new Bundle();
        d2.g(rVar, bundle);
        return bundle;
    }

    private void e(q qVar) {
        try {
            this.f4662b.M(a(qVar), 1);
        } catch (RemoteException e2) {
            Log.e("FJD.ExternalReceiver", "Error sending result for job " + qVar.a() + ": " + e2);
        }
    }

    private synchronized void g(boolean z, q qVar) {
        try {
            this.f4665e.H(a(qVar), z);
        } catch (RemoteException e2) {
            Log.e("FJD.ExternalReceiver", "Failed to stop a job", e2);
            h();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b() {
        return this.f4665e != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(q qVar) {
        this.f4661a.remove(qVar);
        if (this.f4661a.isEmpty()) {
            h();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(q qVar, boolean z) {
        if (!i()) {
            if (Boolean.TRUE.equals(this.f4661a.remove(qVar)) && b()) {
                g(z, qVar);
            }
            if (!z && this.f4661a.isEmpty()) {
                h();
            }
        } else {
            Log.w("FJD.ExternalReceiver", "Can't send stop request because service was unbound.");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean f(q qVar) {
        boolean b2;
        if (i()) {
            e(qVar);
        }
        b2 = b();
        if (b2) {
            if (Boolean.TRUE.equals(this.f4661a.get(qVar))) {
                Log.w("FJD.ExternalReceiver", "Received an execution request for already running job " + qVar);
                g(false, qVar);
            }
            try {
                this.f4665e.s(a(qVar), this.f4662b);
            } catch (RemoteException e2) {
                Log.e("FJD.ExternalReceiver", "Failed to start the job " + qVar, e2);
                h();
                return false;
            }
        }
        this.f4661a.put(qVar, Boolean.valueOf(b2));
        return b2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void h() {
        if (!i()) {
            this.f4665e = null;
            this.f4664d = true;
            try {
                this.f4663c.unbindService(this);
            } catch (IllegalArgumentException e2) {
                Log.w("FJD.ExternalReceiver", "Error unbinding service: " + e2.getMessage());
            }
            ArrayList<q> arrayList = new ArrayList(this.f4661a.size());
            Iterator<q> it = this.f4661a.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                it.remove();
            }
            for (q qVar : arrayList) {
                e(qVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i() {
        return this.f4664d;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (i()) {
            Log.w("FJD.ExternalReceiver", "Connection have been used already.");
            return;
        }
        this.f4665e = m.a.e(iBinder);
        HashSet<q> hashSet = new HashSet();
        for (Map.Entry<q, Boolean> entry : this.f4661a.entrySet()) {
            if (Boolean.FALSE.equals(entry.getValue())) {
                try {
                    this.f4665e.s(a(entry.getKey()), this.f4662b);
                    hashSet.add(entry.getKey());
                } catch (RemoteException e2) {
                    Log.e("FJD.ExternalReceiver", "Failed to start job " + entry.getKey(), e2);
                    h();
                    return;
                }
            }
        }
        for (q qVar : hashSet) {
            this.f4661a.put(qVar, Boolean.TRUE);
        }
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        h();
    }
}
