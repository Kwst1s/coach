package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import java.util.List;

public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FDEG2RAD = 0.017453292f;
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static Rect mCalcTextHeightRect = new Rect();
    private static Rect mCalcTextSizeRect = new Rect();
    private static IValueFormatter mDefaultValueFormatter = generateDefaultValueFormatter();
    private static Rect mDrawTextRectBuffer = new Rect();
    private static Rect mDrawableBoundsCache = new Rect();
    private static Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();
    private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize instance = FSize.getInstance(FLOAT_EPSILON, FLOAT_EPSILON);
        calcTextSize(paint, str, instance);
        return instance;
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float convertDpToPixel(float f2) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static float convertPixelsToDp(float f2) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics != null) {
            return f2 / displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2);
        }
        return strArr;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = list.get(i2);
        }
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        MPPointF instance = MPPointF.getInstance();
        instance.x = (float) (i2 - (i4 / 2));
        instance.y = (float) (i3 - (i5 / 2));
        drawable.copyBounds(mDrawableBoundsCache);
        Rect rect = mDrawableBoundsCache;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int save = canvas.save();
        canvas.translate(instance.x, instance.y);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f2, float f3, TextPaint textPaint, MPPointF mPPointF, float f4) {
        float fontMetrics = textPaint.getFontMetrics(mFontMetricsBuffer);
        float width = (float) staticLayout.getWidth();
        float lineCount = ((float) staticLayout.getLineCount()) * fontMetrics;
        float f5 = FLOAT_EPSILON - ((float) mDrawTextRectBuffer.left);
        float f6 = lineCount + FLOAT_EPSILON;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f4 != FLOAT_EPSILON) {
            float f7 = f5 - (width * 0.5f);
            float f8 = f6 - (lineCount * 0.5f);
            if (!(mPPointF.x == 0.5f && mPPointF.y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f4);
                f2 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.x - 0.5f);
                f3 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.translate(f7, f8);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f9 = mPPointF.x;
            if (!(f9 == FLOAT_EPSILON && mPPointF.y == FLOAT_EPSILON)) {
                f5 -= width * f9;
                f6 -= lineCount * mPPointF.y;
            }
            canvas.save();
            canvas.translate(f5 + f2, f6 + f3);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f2, float f3, Paint paint, MPPointF mPPointF, float f4) {
        float fontMetrics = paint.getFontMetrics(mFontMetricsBuffer);
        paint.getTextBounds(str, 0, str.length(), mDrawTextRectBuffer);
        float f5 = FLOAT_EPSILON - ((float) mDrawTextRectBuffer.left);
        float f6 = (-mFontMetricsBuffer.ascent) + FLOAT_EPSILON;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != FLOAT_EPSILON) {
            float width = f5 - (((float) mDrawTextRectBuffer.width()) * 0.5f);
            float f7 = f6 - (fontMetrics * 0.5f);
            if (!(mPPointF.x == 0.5f && mPPointF.y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees((float) mDrawTextRectBuffer.width(), fontMetrics, f4);
                f2 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.x - 0.5f);
                f3 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, width, f7, paint);
            canvas.restore();
        } else {
            if (!(mPPointF.x == FLOAT_EPSILON && mPPointF.y == FLOAT_EPSILON)) {
                f5 -= ((float) mDrawTextRectBuffer.width()) * mPPointF.x;
                f6 -= fontMetrics * mPPointF.y;
            }
            canvas.drawText(str, f5 + f2, f6 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f2, int i2, boolean z) {
        return formatNumber(f2, i2, z, '.');
    }

    private static IValueFormatter generateDefaultValueFormatter() {
        return new DefaultValueFormatter(1);
    }

    public static int getDecimals(float f2) {
        float roundToNextSignificant = roundToNextSignificant((double) f2);
        if (Float.isInfinite(roundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) roundToNextSignificant))) + 2;
    }

    public static IValueFormatter getDefaultValueFormatter() {
        return mDefaultValueFormatter;
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, mFontMetrics);
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, mFontMetrics);
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static float getNormalizedAngle(float f2) {
        while (f2 < FLOAT_EPSILON) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f2, float f3) {
        MPPointF instance = MPPointF.getInstance(FLOAT_EPSILON, FLOAT_EPSILON);
        getPosition(mPPointF, f2, f3, instance);
        return instance;
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f2) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f2 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f2) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f2);
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        mMetrics = context.getResources().getDisplayMetrics();
    }

    public static double nextUp(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + DOUBLE_EPSILON;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= DOUBLE_EPSILON ? 1 : -1));
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static float roundToNextSignificant(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == DOUBLE_EPSILON) {
            return FLOAT_EPSILON;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d2 < DOUBLE_EPSILON ? -d2 : d2)))))));
        double d3 = (double) pow;
        Double.isNaN(d3);
        return ((float) Math.round(d2 * d3)) / pow;
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) mMaximumFlingVelocity);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < FLOAT_EPSILON) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static String formatNumber(float f2, int i2, boolean z, char c2) {
        boolean z2;
        float f3 = f2;
        char[] cArr = new char[35];
        if (f3 == FLOAT_EPSILON) {
            return "0";
        }
        int i3 = 0;
        boolean z3 = f3 < 1.0f && f3 > -1.0f;
        if (f3 < FLOAT_EPSILON) {
            f3 = -f3;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr = POW_10;
        int length = i2 > iArr.length ? iArr.length - 1 : i2;
        long round = (long) Math.round(f3 * ((float) iArr[length]));
        int i4 = 34;
        boolean z4 = false;
        while (true) {
            if (round == 0 && i3 >= length + 1) {
                break;
            }
            int i5 = (int) (round % 10);
            round /= 10;
            int i6 = i4 - 1;
            cArr[i4] = (char) (i5 + 48);
            i3++;
            if (i3 == length) {
                i4 = i6 - 1;
                cArr[i6] = ',';
                i3++;
                z4 = true;
            } else {
                if (z && round != 0 && i3 > length) {
                    if (z4) {
                        if ((i3 - length) % 4 == 0) {
                            i4 = i6 - 1;
                            cArr[i6] = c2;
                        }
                    } else if ((i3 - length) % 4 == 3) {
                        i4 = i6 - 1;
                        cArr[i6] = c2;
                    }
                    i3++;
                    z4 = z4;
                }
                z4 = z4;
                i4 = i6;
            }
        }
        if (z3) {
            cArr[i4] = '0';
            i3++;
            i4--;
        }
        if (z2) {
            cArr[i4] = '-';
            i3++;
        }
        int i7 = 35 - i3;
        return String.valueOf(cArr, i7, 35 - i7);
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f2, float f3, float f4) {
        return getSizeOfRotatedRectangleByRadians(f2, f3, f4 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f2, float f3, float f4) {
        double d2 = (double) f4;
        return FSize.getInstance(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = (float) rect.width();
        fSize.height = (float) rect.height();
    }

    public static void getPosition(MPPointF mPPointF, float f2, float f3, MPPointF mPPointF2) {
        double d2 = (double) mPPointF.x;
        double d3 = (double) f2;
        double d4 = (double) f3;
        double cos = Math.cos(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d2);
        mPPointF2.x = (float) (d2 + (cos * d3));
        double d5 = (double) mPPointF.y;
        double sin = Math.sin(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d5);
        mPPointF2.y = (float) (d5 + (d3 * sin));
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f2, float f3, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f4) {
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil((double) fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, FLOAT_EPSILON, false), f2, f3, textPaint, mPPointF, f4);
    }
}
