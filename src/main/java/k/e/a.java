package k.e;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.concurrent.TimeUnit;
import k.b.c;
import k.b.d;

/* compiled from: TotalTimeOnAppService */
public class a extends Service {

    /* renamed from: b  reason: collision with root package name */
    private IBinder f10764b = new BinderC0239a();

    /* renamed from: c  reason: collision with root package name */
    private long f10765c;

    /* renamed from: k.e.a$a  reason: collision with other inner class name */
    /* compiled from: TotalTimeOnAppService */
    public class BinderC0239a extends Binder {
        public BinderC0239a() {
        }

        public a a() {
            return a.this;
        }
    }

    public void a() {
        if (getApplicationContext() != null) {
            d.v(getApplicationContext(), TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f10765c));
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f10764b;
    }

    public void onCreate() {
        super.onCreate();
        this.f10765c = System.currentTimeMillis();
    }

    public void onDestroy() {
        a();
        c.s(getApplicationContext());
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public void onTaskRemoved(Intent intent) {
        stopSelf();
        super.onTaskRemoved(intent);
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
