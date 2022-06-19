package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.utils.Utils;

public class VerticalTextView extends AppCompatTextView {

    /* renamed from: f  reason: collision with root package name */
    final boolean f10061f;

    public VerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int gravity = getGravity();
        if (!Gravity.isVertical(gravity) || (gravity & 112) != 80) {
            this.f10061f = true;
            return;
        }
        setGravity((gravity & 7) | 48);
        this.f10061f = false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        canvas.save();
        if (this.f10061f) {
            canvas.translate((float) getWidth(), Utils.FLOAT_EPSILON);
            canvas.rotate(90.0f);
        } else {
            canvas.translate(Utils.FLOAT_EPSILON, (float) getHeight());
            canvas.rotate(-90.0f);
        }
        canvas.translate((float) getCompoundPaddingLeft(), (float) getExtendedPaddingTop());
        getLayout().draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i3, i2);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }
}
