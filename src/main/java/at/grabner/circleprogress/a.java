package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;

/* compiled from: AnimationHandler */
public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CircleProgressView> f1934a;

    /* renamed from: b  reason: collision with root package name */
    private float f1935b;

    /* renamed from: c  reason: collision with root package name */
    private long f1936c;

    /* renamed from: d  reason: collision with root package name */
    private long f1937d;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f1938e = new DecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private TimeInterpolator f1939f = new AccelerateDecelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private double f1940g;

    /* renamed from: h  reason: collision with root package name */
    private long f1941h = 0;

    /* renamed from: at.grabner.circleprogress.a$a  reason: collision with other inner class name */
    /* compiled from: AnimationHandler */
    static /* synthetic */ class C0029a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1942a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1943b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0061 */
        static {
            /*
            // Method dump skipped, instructions count: 105
            */
            throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.a.C0029a.<clinit>():void");
        }
    }

    a(CircleProgressView circleProgressView) {
        super(circleProgressView.getContext().getMainLooper());
        this.f1934a = new WeakReference<>(circleProgressView);
    }

    private boolean a(CircleProgressView circleProgressView) {
        double currentTimeMillis = (double) (System.currentTimeMillis() - this.f1936c);
        double d2 = circleProgressView.x;
        Double.isNaN(currentTimeMillis);
        float f2 = (float) (currentTimeMillis / d2);
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float interpolation = this.f1939f.getInterpolation(f2);
        float f3 = circleProgressView.o;
        circleProgressView.m = f3 + ((circleProgressView.n - f3) * interpolation);
        return f2 >= 1.0f;
    }

    private void b(CircleProgressView circleProgressView, Message message) {
        c cVar = c.END_SPINNING_START_ANIMATING;
        circleProgressView.B = cVar;
        d dVar = circleProgressView.C;
        if (dVar != null) {
            dVar.a(cVar);
        }
        circleProgressView.o = Utils.FLOAT_EPSILON;
        circleProgressView.n = ((float[]) message.obj)[1];
        this.f1937d = System.currentTimeMillis();
        this.f1935b = circleProgressView.s;
        sendEmptyMessageDelayed(b.f1948f - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
    }

    private void c(CircleProgressView circleProgressView) {
        c cVar = c.SPINNING;
        circleProgressView.B = cVar;
        d dVar = circleProgressView.C;
        if (dVar != null) {
            dVar.a(cVar);
        }
        float f2 = circleProgressView.p;
        float f3 = circleProgressView.m;
        circleProgressView.s = (360.0f / f2) * f3;
        circleProgressView.u = (360.0f / f2) * f3;
        this.f1937d = System.currentTimeMillis();
        this.f1935b = circleProgressView.s;
        int i2 = circleProgressView.y;
        this.f1940g = (double) ((circleProgressView.t / circleProgressView.v) * ((float) i2) * 2.0f);
        sendEmptyMessageDelayed(b.f1948f - 1, ((long) i2) - (SystemClock.uptimeMillis() - this.f1941h));
    }

    private void d(CircleProgressView circleProgressView) {
        this.f1940g = (double) ((circleProgressView.s / circleProgressView.v) * ((float) circleProgressView.y) * 2.0f);
        this.f1937d = System.currentTimeMillis();
        this.f1935b = circleProgressView.s;
    }

    private static void f(Message message, CircleProgressView circleProgressView) {
        circleProgressView.o = circleProgressView.n;
        float f2 = ((float[]) message.obj)[0];
        circleProgressView.n = f2;
        circleProgressView.m = f2;
        c cVar = c.IDLE;
        circleProgressView.B = cVar;
        d dVar = circleProgressView.C;
        if (dVar != null) {
            dVar.a(cVar);
        }
        circleProgressView.invalidate();
    }

    public void e(TimeInterpolator timeInterpolator) {
        this.f1938e = timeInterpolator;
    }

    public void g(TimeInterpolator timeInterpolator) {
        this.f1939f = timeInterpolator;
    }

    public void handleMessage(Message message) {
        CircleProgressView circleProgressView = this.f1934a.get();
        if (circleProgressView != null) {
            int i2 = b.a()[message.what];
            int i3 = b.f1948f;
            if (i2 == i3) {
                removeMessages(i3 - 1);
            }
            this.f1941h = SystemClock.uptimeMillis();
            int i4 = C0029a.f1943b[circleProgressView.B.ordinal()];
            if (i4 == 1) {
                int i5 = C0029a.f1942a[i2 - 1];
                if (i5 == 1) {
                    c(circleProgressView);
                } else if (i5 == 3) {
                    f(message, circleProgressView);
                } else if (i5 == 4) {
                    Object obj = message.obj;
                    circleProgressView.o = ((float[]) obj)[0];
                    circleProgressView.n = ((float[]) obj)[1];
                    this.f1936c = System.currentTimeMillis();
                    c cVar = c.ANIMATING;
                    circleProgressView.B = cVar;
                    d dVar = circleProgressView.C;
                    if (dVar != null) {
                        dVar.a(cVar);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                } else if (i5 == 5) {
                    removeMessages(i3 - 1);
                }
            } else if (i4 == 2) {
                int i6 = C0029a.f1942a[i2 - 1];
                if (i6 == 2) {
                    circleProgressView.B = c.END_SPINNING;
                    d(circleProgressView);
                    d dVar2 = circleProgressView.C;
                    if (dVar2 != null) {
                        dVar2.a(circleProgressView.B);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                } else if (i6 == 3) {
                    f(message, circleProgressView);
                } else if (i6 == 4) {
                    b(circleProgressView, message);
                } else if (i6 == 5) {
                    float f2 = circleProgressView.s - circleProgressView.t;
                    double currentTimeMillis = (double) (System.currentTimeMillis() - this.f1937d);
                    double d2 = this.f1940g;
                    Double.isNaN(currentTimeMillis);
                    float f3 = (float) (currentTimeMillis / d2);
                    if (f3 > 1.0f) {
                        f3 = 1.0f;
                    }
                    float interpolation = this.f1938e.getInterpolation(f3);
                    if (Math.abs(f2) < 1.0f) {
                        circleProgressView.s = circleProgressView.t;
                    } else {
                        float f4 = circleProgressView.s;
                        float f5 = circleProgressView.t;
                        if (f4 < f5) {
                            float f6 = this.f1935b;
                            circleProgressView.s = f6 + ((f5 - f6) * interpolation);
                        } else {
                            float f7 = this.f1935b;
                            circleProgressView.s = f7 - ((f7 - f5) * interpolation);
                        }
                    }
                    float f8 = circleProgressView.u + circleProgressView.v;
                    circleProgressView.u = f8;
                    if (f8 > 360.0f) {
                        circleProgressView.u = Utils.FLOAT_EPSILON;
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                    circleProgressView.invalidate();
                }
            } else if (i4 == 3) {
                int i7 = C0029a.f1942a[i2 - 1];
                if (i7 == 1) {
                    c cVar2 = c.SPINNING;
                    circleProgressView.B = cVar2;
                    d dVar3 = circleProgressView.C;
                    if (dVar3 != null) {
                        dVar3.a(cVar2);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                } else if (i7 == 3) {
                    f(message, circleProgressView);
                } else if (i7 == 4) {
                    b(circleProgressView, message);
                } else if (i7 == 5) {
                    double currentTimeMillis2 = (double) (System.currentTimeMillis() - this.f1937d);
                    double d3 = this.f1940g;
                    Double.isNaN(currentTimeMillis2);
                    float f9 = (float) (currentTimeMillis2 / d3);
                    if (f9 > 1.0f) {
                        f9 = 1.0f;
                    }
                    float interpolation2 = this.f1935b * (1.0f - this.f1938e.getInterpolation(f9));
                    circleProgressView.s = interpolation2;
                    circleProgressView.u += circleProgressView.v;
                    if (interpolation2 < 0.01f) {
                        c cVar3 = c.IDLE;
                        circleProgressView.B = cVar3;
                        d dVar4 = circleProgressView.C;
                        if (dVar4 != null) {
                            dVar4.a(cVar3);
                        }
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                    circleProgressView.invalidate();
                }
            } else if (i4 == 4) {
                int i8 = C0029a.f1942a[i2 - 1];
                if (i8 == 1) {
                    circleProgressView.z = false;
                    c(circleProgressView);
                } else if (i8 == 3) {
                    circleProgressView.z = false;
                    f(message, circleProgressView);
                } else if (i8 == 4) {
                    circleProgressView.o = Utils.FLOAT_EPSILON;
                    circleProgressView.n = ((float[]) message.obj)[1];
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                } else if (i8 == 5) {
                    if (circleProgressView.s > circleProgressView.t && !circleProgressView.z) {
                        double currentTimeMillis3 = (double) (System.currentTimeMillis() - this.f1937d);
                        double d4 = this.f1940g;
                        Double.isNaN(currentTimeMillis3);
                        float f10 = (float) (currentTimeMillis3 / d4);
                        if (f10 > 1.0f) {
                            f10 = 1.0f;
                        }
                        circleProgressView.s = this.f1935b * (1.0f - this.f1938e.getInterpolation(f10));
                    }
                    float f11 = circleProgressView.u + circleProgressView.v;
                    circleProgressView.u = f11;
                    if (f11 > 360.0f && !circleProgressView.z) {
                        this.f1936c = System.currentTimeMillis();
                        circleProgressView.z = true;
                        d(circleProgressView);
                        d dVar5 = circleProgressView.C;
                        if (dVar5 != null) {
                            dVar5.a(c.START_ANIMATING_AFTER_SPINNING);
                        }
                    }
                    if (circleProgressView.z) {
                        circleProgressView.u = 360.0f;
                        circleProgressView.s -= circleProgressView.v;
                        a(circleProgressView);
                        double currentTimeMillis4 = (double) (System.currentTimeMillis() - this.f1937d);
                        double d5 = this.f1940g;
                        Double.isNaN(currentTimeMillis4);
                        float f12 = (float) (currentTimeMillis4 / d5);
                        if (f12 > 1.0f) {
                            f12 = 1.0f;
                        }
                        circleProgressView.s = this.f1935b * (1.0f - this.f1938e.getInterpolation(f12));
                    }
                    if (((double) circleProgressView.s) < 0.1d) {
                        c cVar4 = c.ANIMATING;
                        circleProgressView.B = cVar4;
                        d dVar6 = circleProgressView.C;
                        if (dVar6 != null) {
                            dVar6.a(cVar4);
                        }
                        circleProgressView.invalidate();
                        circleProgressView.z = false;
                        circleProgressView.s = circleProgressView.t;
                    } else {
                        circleProgressView.invalidate();
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                }
            } else if (i4 == 5) {
                int i9 = C0029a.f1942a[i2 - 1];
                if (i9 == 1) {
                    c(circleProgressView);
                } else if (i9 == 3) {
                    f(message, circleProgressView);
                } else if (i9 == 4) {
                    this.f1936c = System.currentTimeMillis();
                    circleProgressView.o = circleProgressView.m;
                    circleProgressView.n = ((float[]) message.obj)[1];
                } else if (i9 == 5) {
                    if (a(circleProgressView)) {
                        c cVar5 = c.IDLE;
                        circleProgressView.B = cVar5;
                        d dVar7 = circleProgressView.C;
                        if (dVar7 != null) {
                            dVar7.a(cVar5);
                        }
                        circleProgressView.m = circleProgressView.n;
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.y) - (SystemClock.uptimeMillis() - this.f1941h));
                    circleProgressView.invalidate();
                }
            }
        }
    }
}
