package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import b.a.a;

/* compiled from: AppCompatRatingBar */
public class o extends RatingBar {

    /* renamed from: b  reason: collision with root package name */
    private final n f698b;

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap b2 = this.f698b.b();
        if (b2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public o(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l0.a(this, getContext());
        n nVar = new n(this);
        this.f698b = nVar;
        nVar.c(attributeSet, i2);
    }
}
