package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.github.mikephil.charting.utils.Utils;

public class VerticalSeekBar extends AppCompatSeekBar {

    /* renamed from: c  reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f10059c;

    /* renamed from: d  reason: collision with root package name */
    private int f10060d = 0;

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public synchronized int getMaximum() {
        return getMax();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatSeekBar
    public synchronized void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), Utils.FLOAT_EPSILON);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i3, i2);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i3, i2, i5, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10059c.onStartTrackingTouch(this);
            setPressed(true);
            setSelected(true);
        } else if (action == 1) {
            this.f10059c.onStopTrackingTouch(this);
            setPressed(false);
            setSelected(false);
        } else if (action == 2) {
            super.onTouchEvent(motionEvent);
            int max = getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight())));
            if (max < 0) {
                max = 0;
            }
            if (max > getMax()) {
                max = getMax();
            }
            setProgress(max);
            if (max != this.f10060d) {
                this.f10060d = max;
                this.f10059c.onProgressChanged(this, max, true);
            }
            onSizeChanged(getWidth(), getHeight(), 0, 0);
            setPressed(true);
            setSelected(true);
        } else if (action == 3) {
            super.onTouchEvent(motionEvent);
            setPressed(false);
            setSelected(false);
        }
        return true;
    }

    public synchronized void setMaximum(int i2) {
        setMax(i2);
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.f10059c = onSeekBarChangeListener;
    }

    public synchronized void setProgressAndThumb(int i2) {
        setProgress(i2);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        if (i2 != this.f10060d) {
            this.f10060d = i2;
            this.f10059c.onProgressChanged(this, i2, true);
        }
    }
}
