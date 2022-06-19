package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import b.e.b;
import b.h.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder */
class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f1080a;

    /* renamed from: b  reason: collision with root package name */
    private final h.d f1081b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f1082c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1083d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f1084e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f1085f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    private int f1086g;

    /* renamed from: h  reason: collision with root package name */
    private RemoteViews f1087h;

    i(h.d dVar) {
        Icon icon;
        List<String> list;
        List<String> e2;
        this.f1081b = dVar;
        Context context = dVar.f1065a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1080a = new Notification.Builder(dVar.f1065a, dVar.K);
        } else {
            this.f1080a = new Notification.Builder(dVar.f1065a);
        }
        Notification notification = dVar.S;
        this.f1080a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f1073i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f1069e).setContentText(dVar.f1070f).setContentInfo(dVar.f1075k).setContentIntent(dVar.f1071g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f1072h, (notification.flags & 128) != 0).setLargeIcon(dVar.f1074j).setNumber(dVar.l).setProgress(dVar.t, dVar.u, dVar.v);
        if (i2 < 21) {
            this.f1080a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i2 >= 16) {
            this.f1080a.setSubText(dVar.q).setUsesChronometer(dVar.o).setPriority(dVar.m);
            Iterator<h.a> it = dVar.f1066b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle = dVar.D;
            if (bundle != null) {
                this.f1085f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.z) {
                    this.f1085f.putBoolean("android.support.localOnly", true);
                }
                String str = dVar.w;
                if (str != null) {
                    this.f1085f.putString("android.support.groupKey", str);
                    if (dVar.x) {
                        this.f1085f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1085f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = dVar.y;
                if (str2 != null) {
                    this.f1085f.putString("android.support.sortKey", str2);
                }
            }
            this.f1082c = dVar.H;
            this.f1083d = dVar.I;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            this.f1080a.setShowWhen(dVar.n);
        }
        if (i3 >= 19 && i3 < 21 && (e2 = e(f(dVar.f1067c), dVar.V)) != null && !e2.isEmpty()) {
            this.f1085f.putStringArray("android.people", (String[]) e2.toArray(new String[e2.size()]));
        }
        if (i3 >= 20) {
            this.f1080a.setLocalOnly(dVar.z).setGroup(dVar.w).setGroupSummary(dVar.x).setSortKey(dVar.y);
            this.f1086g = dVar.P;
        }
        if (i3 >= 21) {
            this.f1080a.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            if (i3 < 28) {
                list = e(f(dVar.f1067c), dVar.V);
            } else {
                list = dVar.V;
            }
            if (list != null && !list.isEmpty()) {
                for (String str3 : list) {
                    this.f1080a.addPerson(str3);
                }
            }
            this.f1087h = dVar.J;
            if (dVar.f1068d.size() > 0) {
                Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i4 = 0; i4 < dVar.f1068d.size(); i4++) {
                    bundle4.putBundle(Integer.toString(i4), j.b(dVar.f1068d.get(i4)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
                this.f1085f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23 && (icon = dVar.U) != null) {
            this.f1080a.setSmallIcon(icon);
        }
        if (i5 >= 24) {
            this.f1080a.setExtras(dVar.D).setRemoteInputHistory(dVar.s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                this.f1080a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                this.f1080a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                this.f1080a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i5 >= 26) {
            this.f1080a.setBadgeIconType(dVar.L).setSettingsText(dVar.r).setShortcutId(dVar.M).setTimeoutAfter(dVar.O).setGroupAlertBehavior(dVar.P);
            if (dVar.B) {
                this.f1080a.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f1080a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i5 >= 28) {
            Iterator<k> it2 = dVar.f1067c.iterator();
            while (it2.hasNext()) {
                this.f1080a.addPerson(it2.next().h());
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            this.f1080a.setAllowSystemGeneratedContextualActions(dVar.Q);
            this.f1080a.setBubbleMetadata(h.c.c(dVar.R));
            c cVar = dVar.N;
            if (cVar != null) {
                cVar.a();
                throw null;
            }
        }
        if (dVar.T) {
            if (this.f1081b.x) {
                this.f1086g = 2;
            } else {
                this.f1086g = 1;
            }
            this.f1080a.setVibrate(null);
            this.f1080a.setSound(null);
            int i7 = notification.defaults & -2;
            notification.defaults = i7;
            int i8 = i7 & -3;
            notification.defaults = i8;
            this.f1080a.setDefaults(i8);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f1081b.w)) {
                    this.f1080a.setGroup("silent");
                }
                this.f1080a.setGroupAlertBehavior(this.f1086g);
            }
        }
    }

    private void b(h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            IconCompat e2 = aVar.e();
            if (i2 >= 23) {
                builder = new Notification.Action.Builder(e2 != null ? e2.n() : null, aVar.i(), aVar.a());
            } else {
                builder = new Notification.Action.Builder(e2 != null ? e2.c() : 0, aVar.i(), aVar.a());
            }
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : l.b(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (i3 >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (i3 >= 29) {
                builder.setContextual(aVar.j());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f1080a.addAction(builder.build());
        } else if (i2 >= 16) {
            this.f1084e.add(j.f(this.f1080a, aVar));
        }
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<k> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (k kVar : list) {
            arrayList.add(kVar.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & -2;
        notification.defaults = i2;
        notification.defaults = i2 & -3;
    }

    @Override // androidx.core.app.g
    public Notification.Builder a() {
        return this.f1080a;
    }

    public Notification c() {
        Bundle a2;
        RemoteViews f2;
        RemoteViews d2;
        h.e eVar = this.f1081b.p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews e2 = eVar != null ? eVar.e(this) : null;
        Notification d3 = d();
        if (e2 != null) {
            d3.contentView = e2;
        } else {
            RemoteViews remoteViews = this.f1081b.H;
            if (remoteViews != null) {
                d3.contentView = remoteViews;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (!(i2 < 16 || eVar == null || (d2 = eVar.d(this)) == null)) {
            d3.bigContentView = d2;
        }
        if (!(i2 < 21 || eVar == null || (f2 = this.f1081b.p.f(this)) == null)) {
            d3.headsUpContentView = f2;
        }
        if (!(i2 < 16 || eVar == null || (a2 = h.a(d3)) == null)) {
            eVar.a(a2);
        }
        return d3;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f1080a.build();
        }
        if (i2 >= 24) {
            Notification build = this.f1080a.build();
            if (this.f1086g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f1086g != 2)) {
                    g(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1086g == 1) {
                    g(build);
                }
            }
            return build;
        } else if (i2 >= 21) {
            this.f1080a.setExtras(this.f1085f);
            Notification build2 = this.f1080a.build();
            RemoteViews remoteViews = this.f1082c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1083d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1087h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1086g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f1086g != 2)) {
                    g(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1086g == 1) {
                    g(build2);
                }
            }
            return build2;
        } else if (i2 >= 20) {
            this.f1080a.setExtras(this.f1085f);
            Notification build3 = this.f1080a.build();
            RemoteViews remoteViews4 = this.f1082c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1083d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1086g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f1086g != 2)) {
                    g(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1086g == 1) {
                    g(build3);
                }
            }
            return build3;
        } else if (i2 >= 19) {
            SparseArray<Bundle> a2 = j.a(this.f1084e);
            if (a2 != null) {
                this.f1085f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f1080a.setExtras(this.f1085f);
            Notification build4 = this.f1080a.build();
            RemoteViews remoteViews6 = this.f1082c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1083d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i2 < 16) {
            return this.f1080a.getNotification();
        } else {
            Notification build5 = this.f1080a.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f1085f);
            for (String str : this.f1085f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.f1084e);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f1082c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1083d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
