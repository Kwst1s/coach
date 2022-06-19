package b.h.k;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class j {
    public static boolean a(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
