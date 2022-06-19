package c.d.a;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: OnGestureListener */
public class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector f3212b;

    /* compiled from: OnGestureListener */
    private final class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            a.this.b();
            return super.onDoubleTap(motionEvent);
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            try {
                float y = motionEvent2.getY() - motionEvent.getY();
                float x = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x) > Math.abs(y)) {
                    if (Math.abs(x) <= 100.0f || Math.abs(f2) <= 100.0f) {
                        return false;
                    }
                    if (x > Utils.FLOAT_EPSILON) {
                        a.this.f();
                    } else {
                        a.this.e();
                    }
                } else if (Math.abs(y) <= 100.0f || Math.abs(f3) <= 100.0f) {
                    return false;
                } else {
                    if (y > Utils.FLOAT_EPSILON) {
                        a.this.d();
                    } else {
                        a.this.g();
                    }
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            a.this.c();
            super.onLongPress(motionEvent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            a.this.a();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public a(Context context) {
        this.f3212b = new GestureDetector(context, new b());
    }

    public void a() {
        throw null;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        throw null;
    }

    public void f() {
        throw null;
    }

    public void g() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f3212b.onTouchEvent(motionEvent);
    }
}
