package b.h.k;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: GestureDetectorCompat */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f2619a;

    /* access modifiers changed from: package-private */
    /* compiled from: GestureDetectorCompat */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* compiled from: GestureDetectorCompat */
    static class b implements a {
        private static final int v = ViewConfiguration.getLongPressTimeout();
        private static final int w = ViewConfiguration.getTapTimeout();
        private static final int x = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        private int f2620a;

        /* renamed from: b  reason: collision with root package name */
        private int f2621b;

        /* renamed from: c  reason: collision with root package name */
        private int f2622c;

        /* renamed from: d  reason: collision with root package name */
        private int f2623d;

        /* renamed from: e  reason: collision with root package name */
        private final Handler f2624e;

        /* renamed from: f  reason: collision with root package name */
        final GestureDetector.OnGestureListener f2625f;

        /* renamed from: g  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f2626g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2627h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2628i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f2629j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2630k;
        private boolean l;
        MotionEvent m;
        private MotionEvent n;
        private boolean o;
        private float p;
        private float q;
        private float r;
        private float s;
        private boolean t;
        private VelocityTracker u;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2624e = new a(handler);
            } else {
                this.f2624e = new a();
            }
            this.f2625f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        private void b() {
            this.f2624e.removeMessages(1);
            this.f2624e.removeMessages(2);
            this.f2624e.removeMessages(3);
            this.u.recycle();
            this.u = null;
            this.o = false;
            this.f2627h = false;
            this.f2630k = false;
            this.l = false;
            this.f2628i = false;
            if (this.f2629j) {
                this.f2629j = false;
            }
        }

        private void c() {
            this.f2624e.removeMessages(1);
            this.f2624e.removeMessages(2);
            this.f2624e.removeMessages(3);
            this.o = false;
            this.f2630k = false;
            this.l = false;
            this.f2628i = false;
            if (this.f2629j) {
                this.f2629j = false;
            }
        }

        private void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f2625f != null) {
                this.t = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f2622c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f2623d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f2620a = scaledTouchSlop * scaledTouchSlop;
                this.f2621b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) x)) {
                return false;
            }
            int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x2 * x2) + (y * y) < this.f2621b) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021f  */
        @Override // b.h.k.d.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.MotionEvent r13) {
            /*
            // Method dump skipped, instructions count: 591
            */
            throw new UnsupportedOperationException("Method not decompiled: b.h.k.d.b.a(android.view.MotionEvent):boolean");
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f2624e.removeMessages(3);
            this.f2628i = false;
            this.f2629j = true;
            this.f2625f.onLongPress(this.m);
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2626g = onDoubleTapListener;
        }

        /* compiled from: GestureDetectorCompat */
        private class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b bVar = b.this;
                    bVar.f2625f.onShowPress(bVar.m);
                } else if (i2 == 2) {
                    b.this.d();
                } else if (i2 == 3) {
                    b bVar2 = b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f2626g;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f2627h) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.m);
                    } else {
                        bVar2.f2628i = true;
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* compiled from: GestureDetectorCompat */
    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f2632a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2632a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // b.h.k.d.a
        public boolean a(MotionEvent motionEvent) {
            return this.f2632a.onTouchEvent(motionEvent);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f2619a.a(motionEvent);
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2619a = new c(context, onGestureListener, handler);
        } else {
            this.f2619a = new b(context, onGestureListener, handler);
        }
    }
}
