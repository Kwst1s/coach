package fr.castorflex.android.circularprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: PowerSaveModeDelegate */
public class g implements f {

    /* renamed from: d  reason: collision with root package name */
    private static final long f9726d = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final a f9727a;

    /* renamed from: b  reason: collision with root package name */
    private int f9728b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f9729c = new a();

    /* compiled from: PowerSaveModeDelegate */
    class a implements Runnable {
        a() {
        }

        public void run() {
            g.this.f9728b += 50;
            g.this.f9728b %= 360;
            if (g.this.f9727a.isRunning()) {
                g.this.f9727a.scheduleSelf(this, SystemClock.uptimeMillis() + g.f9726d);
            }
            g.this.f9727a.d();
        }
    }

    g(a aVar) {
        this.f9727a = aVar;
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void a(Canvas canvas, Paint paint) {
        canvas.drawArc(this.f9727a.b(), (float) this.f9728b, 300.0f, false, paint);
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void start() {
        this.f9727a.d();
        this.f9727a.scheduleSelf(this.f9729c, SystemClock.uptimeMillis() + f9726d);
    }

    @Override // fr.castorflex.android.circularprogressbar.f
    public void stop() {
        this.f9727a.unscheduleSelf(this.f9729c);
    }
}
