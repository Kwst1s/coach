package b.o.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2792f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static a f2793g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2794a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f2795b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f2796c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f2797d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f2798e;

    /* renamed from: b.o.a.a$a  reason: collision with other inner class name */
    /* compiled from: LocalBroadcastManager */
    class HandlerC0057a extends Handler {
        HandlerC0057a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2800a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f2801b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f2800a = intent;
            this.f2801b = arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f2802a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f2803b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2804c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2805d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f2802a = intentFilter;
            this.f2803b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f2803b);
            sb.append(" filter=");
            sb.append(this.f2802a);
            if (this.f2805d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f2794a = context;
        this.f2798e = new HandlerC0057a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f2792f) {
            if (f2793g == null) {
                f2793g = new a(context.getApplicationContext());
            }
            aVar = f2793g;
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = r4.f2801b.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r6 >= r5) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = r4.f2801b.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r7.f2805d != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r7.f2803b.onReceive(r10.f2794a, r4.f2800a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<b.o.a.a$c>> r0 = r10.f2795b
            monitor-enter(r0)
            java.util.ArrayList<b.o.a.a$b> r1 = r10.f2797d     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            b.o.a.a$b[] r2 = new b.o.a.a.b[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<b.o.a.a$b> r3 = r10.f2797d     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<b.o.a.a$b> r3 = r10.f2797d     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
            r3 = 0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<b.o.a.a$c> r5 = r4.f2801b
            int r5 = r5.size()
            r6 = 0
        L_0x0027:
            if (r6 >= r5) goto L_0x0041
            java.util.ArrayList<b.o.a.a$c> r7 = r4.f2801b
            java.lang.Object r7 = r7.get(r6)
            b.o.a.a$c r7 = (b.o.a.a.c) r7
            boolean r8 = r7.f2805d
            if (r8 != 0) goto L_0x003e
            android.content.BroadcastReceiver r7 = r7.f2803b
            android.content.Context r8 = r10.f2794a
            android.content.Intent r9 = r4.f2800a
            r7.onReceive(r8, r9)
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0048
        L_0x0047:
            throw r1
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: b.o.a.a.a():void");
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f2795b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f2795b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f2795b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<c> arrayList2 = this.f2796c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f2796c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        ArrayList<c> arrayList;
        String str2;
        int i2;
        ArrayList arrayList2;
        synchronized (this.f2795b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f2794a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f2796c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    c cVar = arrayList3.get(i3);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f2802a);
                    }
                    if (cVar.f2804c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        i2 = i3;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = cVar.f2802a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(cVar);
                            cVar.f2804c = true;
                            i3 = i2 + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList2;
                    i3 = i2 + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                if (arrayList4 != null) {
                    for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                        ((c) arrayList4.get(i4)).f2804c = false;
                    }
                    this.f2797d.add(new b(intent, arrayList4));
                    if (!this.f2798e.hasMessages(1)) {
                        this.f2798e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f2795b) {
            ArrayList<c> remove = this.f2795b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.f2805d = true;
                    for (int i2 = 0; i2 < cVar.f2802a.countActions(); i2++) {
                        String action = cVar.f2802a.getAction(i2);
                        ArrayList<c> arrayList = this.f2796c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f2803b == broadcastReceiver) {
                                    cVar2.f2805d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f2796c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
