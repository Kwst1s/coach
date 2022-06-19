package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class Transformer {
    private Matrix mMBuffer1 = new Matrix();
    private Matrix mMBuffer2 = new Matrix();
    protected Matrix mMatrixOffset = new Matrix();
    protected Matrix mMatrixValueToPx = new Matrix();
    protected Matrix mPixelToValueMatrixBuffer = new Matrix();
    protected ViewPortHandler mViewPortHandler;
    float[] ptsBuffer = new float[2];
    protected float[] valuePointsForGenerateTransformedValuesBubble = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesCandle = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesLine = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesScatter = new float[1];

    public Transformer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public float[] generateTransformedValuesBubble(IBubbleDataSet iBubbleDataSet, float f2, int i2, int i3) {
        int i4 = ((i3 - i2) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesBubble.length != i4) {
            this.valuePointsForGenerateTransformedValuesBubble = new float[i4];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesBubble;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry entryForIndex = iBubbleDataSet.getEntryForIndex((i5 / 2) + i2);
            if (entryForIndex != null) {
                fArr[i5] = entryForIndex.getX();
                fArr[i5 + 1] = entryForIndex.getY() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesCandle(ICandleDataSet iCandleDataSet, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesCandle.length != i4) {
            this.valuePointsForGenerateTransformedValuesCandle = new float[i4];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesCandle;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex((i5 / 2) + i2);
            if (candleEntry != null) {
                fArr[i5] = candleEntry.getX();
                fArr[i5 + 1] = candleEntry.getHigh() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesLine(ILineDataSet iLineDataSet, float f2, float f3, int i2, int i3) {
        int i4 = (((int) (((float) (i3 - i2)) * f2)) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesLine.length != i4) {
            this.valuePointsForGenerateTransformedValuesLine = new float[i4];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesLine;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry entryForIndex = iLineDataSet.getEntryForIndex((i5 / 2) + i2);
            if (entryForIndex != null) {
                fArr[i5] = entryForIndex.getX();
                fArr[i5 + 1] = entryForIndex.getY() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesScatter(IScatterDataSet iScatterDataSet, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesScatter.length != i4) {
            this.valuePointsForGenerateTransformedValuesScatter = new float[i4];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesScatter;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry entryForIndex = iScatterDataSet.getEntryForIndex((i5 / 2) + i2);
            if (entryForIndex != null) {
                fArr[i5] = entryForIndex.getX();
                fArr[i5 + 1] = entryForIndex.getY() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }

    public MPPointD getPixelForValues(float f2, float f3) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f2;
        fArr[1] = f3;
        pointValuesToPixel(fArr);
        float[] fArr2 = this.ptsBuffer;
        return MPPointD.getInstance((double) fArr2[0], (double) fArr2[1]);
    }

    public Matrix getPixelToValueMatrix() {
        getValueToPixelMatrix().invert(this.mMBuffer2);
        return this.mMBuffer2;
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getValueToPixelMatrix() {
        this.mMBuffer1.set(this.mMatrixValueToPx);
        this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
        this.mMBuffer1.postConcat(this.mMatrixOffset);
        return this.mMBuffer1;
    }

    public MPPointD getValuesByTouchPoint(float f2, float f3) {
        MPPointD instance = MPPointD.getInstance(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
        getValuesByTouchPoint(f2, f3, instance);
        return instance;
    }

    public void pathValueToPixel(Path path) {
        path.transform(this.mMatrixValueToPx);
        path.transform(this.mViewPortHandler.getMatrixTouch());
        path.transform(this.mMatrixOffset);
    }

    public void pathValuesToPixel(List<Path> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            pathValueToPixel(list.get(i2));
        }
    }

    public void pixelsToValue(float[] fArr) {
        Matrix matrix = this.mPixelToValueMatrixBuffer;
        matrix.reset();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().invert(matrix);
        matrix.mapPoints(fArr);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void pointValuesToPixel(float[] fArr) {
        this.mMatrixValueToPx.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().mapPoints(fArr);
        this.mMatrixOffset.mapPoints(fArr);
    }

    public void prepareMatrixOffset(boolean z) {
        this.mMatrixOffset.reset();
        if (!z) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
            return;
        }
        this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
        this.mMatrixOffset.postScale(1.0f, -1.0f);
    }

    public void prepareMatrixValuePx(float f2, float f3, float f4, float f5) {
        float contentWidth = this.mViewPortHandler.contentWidth() / f3;
        float contentHeight = this.mViewPortHandler.contentHeight() / f4;
        if (Float.isInfinite(contentWidth)) {
            contentWidth = Utils.FLOAT_EPSILON;
        }
        if (Float.isInfinite(contentHeight)) {
            contentHeight = Utils.FLOAT_EPSILON;
        }
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f2, -f5);
        this.mMatrixValueToPx.postScale(contentWidth, -contentHeight);
    }

    public void rectToPixelPhase(RectF rectF, float f2) {
        rectF.top *= f2;
        rectF.bottom *= f2;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectToPixelPhaseHorizontal(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixel(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixelHorizontal(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValuesToPixel(List<RectF> list) {
        Matrix valueToPixelMatrix = getValueToPixelMatrix();
        for (int i2 = 0; i2 < list.size(); i2++) {
            valueToPixelMatrix.mapRect(list.get(i2));
        }
    }

    public void getValuesByTouchPoint(float f2, float f3, MPPointD mPPointD) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f2;
        fArr[1] = f3;
        pixelsToValue(fArr);
        float[] fArr2 = this.ptsBuffer;
        mPPointD.x = (double) fArr2[0];
        mPPointD.y = (double) fArr2[1];
    }

    public void rectValueToPixelHorizontal(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }
}
