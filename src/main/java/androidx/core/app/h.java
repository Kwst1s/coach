package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public class h {

    /* compiled from: NotificationCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1053a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f1054b;

        /* renamed from: c  reason: collision with root package name */
        private final l[] f1055c;

        /* renamed from: d  reason: collision with root package name */
        private final l[] f1056d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1057e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1058f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1059g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f1060h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f1061i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f1062j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f1063k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.b(null, BuildConfig.FLAVOR, i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f1063k;
        }

        public boolean b() {
            return this.f1057e;
        }

        public l[] c() {
            return this.f1056d;
        }

        public Bundle d() {
            return this.f1053a;
        }

        public IconCompat e() {
            int i2;
            if (this.f1054b == null && (i2 = this.f1061i) != 0) {
                this.f1054b = IconCompat.b(null, BuildConfig.FLAVOR, i2);
            }
            return this.f1054b;
        }

        public l[] f() {
            return this.f1055c;
        }

        public int g() {
            return this.f1059g;
        }

        public boolean h() {
            return this.f1058f;
        }

        public CharSequence i() {
            return this.f1062j;
        }

        public boolean j() {
            return this.f1060h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f1058f = true;
            this.f1054b = iconCompat;
            if (iconCompat != null && iconCompat.g() == 2) {
                this.f1061i = iconCompat.c();
            }
            this.f1062j = d.d(charSequence);
            this.f1063k = pendingIntent;
            this.f1053a = bundle == null ? new Bundle() : bundle;
            this.f1055c = lVarArr;
            this.f1056d = lVarArr2;
            this.f1057e = z;
            this.f1059g = i2;
            this.f1058f = z2;
            this.f1060h = z3;
        }
    }

    /* compiled from: NotificationCompat */
    public static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f1064e;

        @Override // androidx.core.app.h.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f1064e);
            }
        }

        @Override // androidx.core.app.h.e
        public void b(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f1077b).bigText(this.f1064e);
                if (this.f1079d) {
                    bigText.setSummaryText(this.f1078c);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // androidx.core.app.h.e
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f1064e = d.d(charSequence);
            return this;
        }
    }

    /* compiled from: NotificationCompat */
    public static final class c {

        /* access modifiers changed from: private */
        /* compiled from: NotificationCompat */
        public static class a {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null) {
                    return null;
                }
                cVar.a();
                throw null;
            }
        }

        /* access modifiers changed from: private */
        /* compiled from: NotificationCompat */
        public static class b {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null) {
                    return null;
                }
                cVar.b();
                throw null;
            }
        }

        public static Notification.BubbleMetadata c(c cVar) {
            if (cVar == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return b.a(cVar);
            }
            if (i2 == 29) {
                return a.a(cVar);
            }
            return null;
        }

        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent a() {
            throw null;
        }

        public String b() {
            throw null;
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f1076a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f1077b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f1078c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1079d = false;

        public void a(Bundle bundle) {
            if (this.f1079d) {
                bundle.putCharSequence("android.summaryText", this.f1078c);
            }
            CharSequence charSequence = this.f1077b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c2 = c();
            if (c2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
            }
        }

        public abstract void b(g gVar);

        /* access modifiers changed from: protected */
        public abstract String c();

        public RemoteViews d(g gVar) {
            return null;
        }

        public RemoteViews e(g gVar) {
            return null;
        }

        public RemoteViews f(g gVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f1076a != dVar) {
                this.f1076a = dVar;
                if (dVar != null) {
                    dVar.s(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return j.c(notification);
        }
        return null;
    }

    /* compiled from: NotificationCompat */
    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        b.h.d.c N;
        long O;
        int P;
        boolean Q;
        c R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a  reason: collision with root package name */
        public Context f1065a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1066b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<k> f1067c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f1068d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1069e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f1070f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f1071g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f1072h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f1073i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f1074j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f1075k;
        int l;
        int m;
        boolean n;
        boolean o;
        e p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public d(Context context, String str) {
            this.f1066b = new ArrayList<>();
            this.f1067c = new ArrayList<>();
            this.f1068d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f1065a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void l(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.S;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.S;
            notification2.flags = (i2 ^ -1) & notification2.flags;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1066b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new i(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z2) {
            l(16, z2);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(int i2) {
            this.E = i2;
            return this;
        }

        public d h(boolean z2) {
            this.A = z2;
            this.B = true;
            return this;
        }

        public d i(PendingIntent pendingIntent) {
            this.f1071g = pendingIntent;
            return this;
        }

        public d j(CharSequence charSequence) {
            this.f1070f = d(charSequence);
            return this;
        }

        public d k(CharSequence charSequence) {
            this.f1069e = d(charSequence);
            return this;
        }

        public d m(int i2, int i3, int i4) {
            Notification notification = this.S;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public d n(boolean z2) {
            this.z = z2;
            return this;
        }

        public d o(boolean z2) {
            l(2, z2);
            return this;
        }

        public d p(int i2) {
            this.m = i2;
            return this;
        }

        public d q(int i2) {
            this.S.icon = i2;
            return this;
        }

        public d r(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public d s(e eVar) {
            if (this.p != eVar) {
                this.p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d t(CharSequence charSequence) {
            this.S.tickerText = d(charSequence);
            return this;
        }

        public d u(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public d v(long j2) {
            this.S.when = j2;
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, null);
        }
    }
}
