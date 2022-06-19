package c.e.a.c.a.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: DownloaderServiceMarshaller */
public class d {

    /* compiled from: DownloaderServiceMarshaller */
    private static class a implements g {

        /* renamed from: b  reason: collision with root package name */
        private Messenger f3484b;

        public a(Messenger messenger) {
            this.f3484b = messenger;
        }

        private void g(int i2, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.setData(bundle);
            try {
                this.f3484b.send(obtain);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // c.e.a.c.a.a.g
        public void a() {
            g(5, new Bundle());
        }

        @Override // c.e.a.c.a.a.g
        public void b(Messenger messenger) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("EMH", messenger);
            g(6, bundle);
        }

        @Override // c.e.a.c.a.a.g
        public void c(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("flags", i2);
            g(3, bundle);
        }

        @Override // c.e.a.c.a.a.g
        public void d() {
            g(1, new Bundle());
        }

        @Override // c.e.a.c.a.a.g
        public void e() {
            g(2, new Bundle());
        }

        @Override // c.e.a.c.a.a.g
        public void f() {
            g(4, new Bundle());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DownloaderServiceMarshaller */
    public static class b implements h {

        /* renamed from: a  reason: collision with root package name */
        private g f3485a = null;

        /* renamed from: b  reason: collision with root package name */
        final Messenger f3486b = new Messenger(new a());

        /* compiled from: DownloaderServiceMarshaller */
        class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.f3485a.d();
                        return;
                    case 2:
                        b.this.f3485a.e();
                        return;
                    case 3:
                        b.this.f3485a.c(message.getData().getInt("flags"));
                        return;
                    case 4:
                        b.this.f3485a.f();
                        return;
                    case 5:
                        b.this.f3485a.a();
                        return;
                    case 6:
                        b.this.f3485a.b((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        }

        public b(g gVar) {
            this.f3485a = gVar;
        }

        @Override // c.e.a.c.a.a.h
        public void a(Context context) {
        }

        @Override // c.e.a.c.a.a.h
        public Messenger b() {
            return this.f3486b;
        }

        @Override // c.e.a.c.a.a.h
        public void c(Context context) {
        }
    }

    public static g a(Messenger messenger) {
        return new a(messenger);
    }

    public static h b(g gVar) {
        return new b(gVar);
    }
}
