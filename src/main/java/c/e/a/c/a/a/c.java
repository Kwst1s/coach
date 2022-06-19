package c.e.a.c.a.a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/* compiled from: DownloaderClientMarshaller */
public class c {

    /* compiled from: DownloaderClientMarshaller */
    private static class a implements f {

        /* renamed from: b  reason: collision with root package name */
        private Messenger f3474b;

        public a(Messenger messenger) {
            this.f3474b = messenger;
        }

        private void a(int i2, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.setData(bundle);
            try {
                this.f3474b.send(obtain);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // c.e.a.c.a.a.f
        public void n(Messenger messenger) {
        }

        @Override // c.e.a.c.a.a.f
        public void u(b bVar) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("progress", bVar);
            a(11, bundle);
        }

        @Override // c.e.a.c.a.a.f
        public void w(int i2) {
            Bundle bundle = new Bundle(1);
            bundle.putInt("newState", i2);
            a(10, bundle);
        }
    }

    /* compiled from: DownloaderClientMarshaller */
    private static class b implements h {

        /* renamed from: a  reason: collision with root package name */
        private f f3475a = null;

        /* renamed from: b  reason: collision with root package name */
        private Class<?> f3476b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3477c;

        /* renamed from: d  reason: collision with root package name */
        private Messenger f3478d;

        /* renamed from: e  reason: collision with root package name */
        private Context f3479e;

        /* renamed from: f  reason: collision with root package name */
        final Messenger f3480f = new Messenger(new a());

        /* renamed from: g  reason: collision with root package name */
        private ServiceConnection f3481g = new ServiceConnectionC0084b();

        /* compiled from: DownloaderClientMarshaller */
        class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10:
                        b.this.f3475a.w(message.getData().getInt("newState"));
                        return;
                    case 11:
                        Bundle data = message.getData();
                        if (b.this.f3479e != null) {
                            data.setClassLoader(b.this.f3479e.getClassLoader());
                            b.this.f3475a.u((b) message.getData().getParcelable("progress"));
                            return;
                        }
                        return;
                    case 12:
                        b.this.f3475a.n((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        }

        /* renamed from: c.e.a.c.a.a.c$b$b  reason: collision with other inner class name */
        /* compiled from: DownloaderClientMarshaller */
        class ServiceConnectionC0084b implements ServiceConnection {
            ServiceConnectionC0084b() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                b.this.f3478d = new Messenger(iBinder);
                b.this.f3475a.n(b.this.f3478d);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                b.this.f3478d = null;
            }
        }

        public b(f fVar, Class<?> cls) {
            this.f3475a = fVar;
            this.f3476b = cls;
        }

        @Override // c.e.a.c.a.a.h
        public void a(Context context) {
            this.f3479e = context;
            Intent intent = new Intent(context, this.f3476b);
            intent.putExtra("EMH", this.f3480f);
            if (context.bindService(intent, this.f3481g, 2)) {
                this.f3477c = true;
            }
        }

        @Override // c.e.a.c.a.a.h
        public Messenger b() {
            return this.f3480f;
        }

        @Override // c.e.a.c.a.a.h
        public void c(Context context) {
            if (this.f3477c) {
                context.unbindService(this.f3481g);
                this.f3477c = false;
            }
            this.f3479e = null;
        }
    }

    public static f a(Messenger messenger) {
        return new a(messenger);
    }

    public static h b(f fVar, Class<?> cls) {
        return new b(fVar, cls);
    }

    public static int c(Context context, PendingIntent pendingIntent, Class<?> cls) {
        return DownloaderService.H(context, pendingIntent, cls);
    }

    public static int d(Context context, Intent intent, Class<?> cls) {
        return DownloaderService.J(context, intent, cls);
    }
}
