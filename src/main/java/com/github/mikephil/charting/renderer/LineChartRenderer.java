package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath = new Path();
    protected Path cubicPath = new Path();
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    protected LineDataProvider mChart;
    protected Paint mCirclePaintInner;
    private float[] mCirclesBuffer = new float[2];
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mGenerateFilledPathBuffer = new Path();
    private HashMap<IDataSet, DataSetImageCache> mImageCaches = new HashMap<>();
    private float[] mLineBuffer = new float[4];

    /* access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.data.LineDataSet$Mode[] r0 = com.github.mikephil.charting.data.LineDataSet.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = r0
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.LINEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.STEPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = lineDataProvider;
        Paint paint = new Paint(1);
        this.mCirclePaintInner = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    private void generateFilledPath(ILineDataSet iLineDataSet, int i2, int i3, Path path) {
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        float phaseY = this.mAnimator.getPhaseY();
        boolean z = iLineDataSet.getMode() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry entryForIndex = iLineDataSet.getEntryForIndex(i2);
        path.moveTo(entryForIndex.getX(), fillLinePosition);
        path.lineTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
        Entry entry = null;
        for (int i4 = i2 + 1; i4 <= i3; i4++) {
            entry = iLineDataSet.getEntryForIndex(i4);
            if (z && entry != null) {
                path.lineTo(entry.getX(), entry.getY() * phaseY);
            }
            path.lineTo(entry.getX(), entry.getY() * phaseY);
        }
        if (entry != null) {
            path.lineTo(entry.getX(), fillLinePosition);
        }
        path.close();
    }

    /* access modifiers changed from: protected */
    public void drawCircles(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        Bitmap bitmap;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseY = this.mAnimator.getPhaseY();
        float[] fArr = this.mCirclesBuffer;
        char c2 = 0;
        float f2 = Utils.FLOAT_EPSILON;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List dataSets = this.mChart.getLineData().getDataSets();
        int i2 = 0;
        while (i2 < dataSets.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i2);
            if (iLineDataSet.isVisible() && iLineDataSet.isDrawCirclesEnabled() && iLineDataSet.getEntryCount() != 0) {
                this.mCirclePaintInner.setColor(iLineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                this.mXBounds.set(this.mChart, iLineDataSet);
                float circleRadius = iLineDataSet.getCircleRadius();
                float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
                boolean z = iLineDataSet.isDrawCircleHoleEnabled() && circleHoleRadius < circleRadius && circleHoleRadius > f2;
                boolean z2 = z && iLineDataSet.getCircleHoleColor() == 1122867;
                if (this.mImageCaches.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.mImageCaches.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, null);
                    this.mImageCaches.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.init(iLineDataSet)) {
                    dataSetImageCache.fill(iLineDataSet, z, z2);
                }
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                int i3 = xBounds.range;
                int i4 = xBounds.min;
                int i5 = i3 + i4;
                while (i4 <= i5) {
                    Entry entryForIndex = iLineDataSet.getEntryForIndex(i4);
                    if (entryForIndex == null) {
                        break;
                    }
                    this.mCirclesBuffer[c2] = entryForIndex.getX();
                    this.mCirclesBuffer[1] = entryForIndex.getY() * phaseY;
                    transformer.pointValuesToPixel(this.mCirclesBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mCirclesBuffer[c2])) {
                        break;
                    }
                    if (this.mViewPortHandler.isInBoundsLeft(this.mCirclesBuffer[c2]) && this.mViewPortHandler.isInBoundsY(this.mCirclesBuffer[1]) && (bitmap = dataSetImageCache.getBitmap(i4)) != null) {
                        float[] fArr2 = this.mCirclesBuffer;
                        canvas.drawBitmap(bitmap, fArr2[c2] - circleRadius, fArr2[1] - circleRadius, (Paint) null);
                    }
                    i4++;
                    c2 = 0;
                }
            }
            i2++;
            c2 = 0;
            f2 = Utils.FLOAT_EPSILON;
        }
    }

    /* access modifiers changed from: protected */
    public void drawCubicBezier(ILineDataSet iLineDataSet) {
        Math.max((float) Utils.FLOAT_EPSILON, Math.min(1.0f, this.mAnimator.getPhaseX()));
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet);
        float cubicIntensity = iLineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
        if (xBounds.range >= 1) {
            int i2 = xBounds.min + 1;
            Entry entryForIndex = iLineDataSet.getEntryForIndex(Math.max(i2 - 2, 0));
            Entry entryForIndex2 = iLineDataSet.getEntryForIndex(Math.max(i2 - 1, 0));
            int i3 = -1;
            if (entryForIndex2 != null) {
                this.cubicPath.moveTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                int i4 = this.mXBounds.min + 1;
                Entry entry = entryForIndex2;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                    if (i4 > xBounds2.range + xBounds2.min) {
                        break;
                    }
                    if (i3 != i4) {
                        entryForIndex2 = iLineDataSet.getEntryForIndex(i4);
                    }
                    int i5 = i4 + 1;
                    if (i5 < iLineDataSet.getEntryCount()) {
                        i4 = i5;
                    }
                    Entry entryForIndex3 = iLineDataSet.getEntryForIndex(i4);
                    this.cubicPath.cubicTo(entry.getX() + ((entryForIndex2.getX() - entryForIndex.getX()) * cubicIntensity), (entry.getY() + ((entryForIndex2.getY() - entryForIndex.getY()) * cubicIntensity)) * phaseY, entryForIndex2.getX() - ((entryForIndex3.getX() - entry.getX()) * cubicIntensity), (entryForIndex2.getY() - ((entryForIndex3.getY() - entry.getY()) * cubicIntensity)) * phaseY, entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                    entryForIndex = entry;
                    entry = entryForIndex2;
                    entryForIndex2 = entryForIndex3;
                    i4 = i5;
                    i3 = i4;
                }
            } else {
                return;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

    /* access modifiers changed from: protected */
    public void drawCubicFill(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min + xBounds.range).getX(), fillLinePosition);
        path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min).getX(), fillLinePosition);
        path.close();
        transformer.pathValueToPixel(path);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, path, fillDrawable);
        } else {
            drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (!(weakReference != null && weakReference.get().getWidth() == chartWidth && this.mDrawBitmap.get().getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, this.mBitmapConfig));
                this.mBitmapCanvas = new Canvas(this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        this.mDrawBitmap.get().eraseColor(0);
        for (ILineDataSet iLineDataSet : this.mChart.getLineData().getDataSets()) {
            if (iLineDataSet.isVisible()) {
                drawDataSet(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap(this.mDrawBitmap.get(), Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, this.mRenderPaint);
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.getEntryCount() >= 1) {
            this.mRenderPaint.setStrokeWidth(iLineDataSet.getLineWidth());
            this.mRenderPaint.setPathEffect(iLineDataSet.getDashPathEffect());
            int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[iLineDataSet.getMode().ordinal()];
            if (i2 == 3) {
                drawCubicBezier(iLineDataSet);
            } else if (i2 != 4) {
                drawLinear(canvas, iLineDataSet);
            } else {
                drawHorizontalBezier(iLineDataSet);
            }
            this.mRenderPaint.setPathEffect(null);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.mChart.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ILineDataSet) lineData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.isHighlightEnabled()) {
                Entry entryForXValue = iLineScatterCandleRadarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iLineScatterCandleRadarDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineScatterCandleRadarDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawHorizontalBezier(ILineDataSet iLineDataSet) {
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet);
        this.cubicPath.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
        if (xBounds.range >= 1) {
            Entry entryForIndex = iLineDataSet.getEntryForIndex(xBounds.min);
            this.cubicPath.moveTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
            int i2 = this.mXBounds.min + 1;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                if (i2 > xBounds2.range + xBounds2.min) {
                    break;
                }
                Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i2);
                float x = entryForIndex.getX() + ((entryForIndex2.getX() - entryForIndex.getX()) / 2.0f);
                this.cubicPath.cubicTo(x, entryForIndex.getY() * phaseY, x, entryForIndex2.getY() * phaseY, entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                i2++;
                entryForIndex = entryForIndex2;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
    }

    /* access modifiers changed from: protected */
    public void drawLinear(Canvas canvas, ILineDataSet iLineDataSet) {
        int entryCount = iLineDataSet.getEntryCount();
        boolean isDrawSteppedEnabled = iLineDataSet.isDrawSteppedEnabled();
        int i2 = isDrawSteppedEnabled ? 4 : 2;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.isDashedLineEnabled() ? this.mBitmapCanvas : canvas;
        this.mXBounds.set(this.mChart, iLineDataSet);
        if (iLineDataSet.isDrawFilledEnabled() && entryCount > 0) {
            drawLinearFill(canvas, iLineDataSet, transformer, this.mXBounds);
        }
        if (iLineDataSet.getColors().size() > 1) {
            int i3 = i2 * 2;
            if (this.mLineBuffer.length <= i3) {
                this.mLineBuffer = new float[(i2 * 4)];
            }
            int i4 = this.mXBounds.min;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                if (i4 > xBounds.range + xBounds.min) {
                    break;
                }
                Entry entryForIndex = iLineDataSet.getEntryForIndex(i4);
                if (entryForIndex != null) {
                    this.mLineBuffer[0] = entryForIndex.getX();
                    this.mLineBuffer[1] = entryForIndex.getY() * phaseY;
                    if (i4 < this.mXBounds.max) {
                        Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i4 + 1);
                        if (entryForIndex2 == null) {
                            break;
                        } else if (isDrawSteppedEnabled) {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            float[] fArr = this.mLineBuffer;
                            fArr[3] = fArr[1];
                            fArr[4] = fArr[2];
                            fArr[5] = fArr[3];
                            fArr[6] = entryForIndex2.getX();
                            this.mLineBuffer[7] = entryForIndex2.getY() * phaseY;
                        } else {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            this.mLineBuffer[3] = entryForIndex2.getY() * phaseY;
                        }
                    } else {
                        float[] fArr2 = this.mLineBuffer;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mLineBuffer[0])) {
                        break;
                    } else if (this.mViewPortHandler.isInBoundsLeft(this.mLineBuffer[2]) && (this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1]) || this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3]))) {
                        this.mRenderPaint.setColor(iLineDataSet.getColor(i4));
                        canvas2.drawLines(this.mLineBuffer, 0, i3, this.mRenderPaint);
                    }
                }
                i4++;
            }
        } else {
            int i5 = entryCount * i2;
            if (this.mLineBuffer.length < Math.max(i5, i2) * 2) {
                this.mLineBuffer = new float[(Math.max(i5, i2) * 4)];
            }
            if (iLineDataSet.getEntryForIndex(this.mXBounds.min) != null) {
                int i6 = this.mXBounds.min;
                int i7 = 0;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.mXBounds;
                    if (i6 > xBounds2.range + xBounds2.min) {
                        break;
                    }
                    Entry entryForIndex3 = iLineDataSet.getEntryForIndex(i6 == 0 ? 0 : i6 - 1);
                    Entry entryForIndex4 = iLineDataSet.getEntryForIndex(i6);
                    if (!(entryForIndex3 == null || entryForIndex4 == null)) {
                        int i8 = i7 + 1;
                        this.mLineBuffer[i7] = entryForIndex3.getX();
                        int i9 = i8 + 1;
                        this.mLineBuffer[i8] = entryForIndex3.getY() * phaseY;
                        if (isDrawSteppedEnabled) {
                            int i10 = i9 + 1;
                            this.mLineBuffer[i9] = entryForIndex4.getX();
                            int i11 = i10 + 1;
                            this.mLineBuffer[i10] = entryForIndex3.getY() * phaseY;
                            int i12 = i11 + 1;
                            this.mLineBuffer[i11] = entryForIndex4.getX();
                            i9 = i12 + 1;
                            this.mLineBuffer[i12] = entryForIndex3.getY() * phaseY;
                        }
                        int i13 = i9 + 1;
                        this.mLineBuffer[i9] = entryForIndex4.getX();
                        this.mLineBuffer[i13] = entryForIndex4.getY() * phaseY;
                        i7 = i13 + 1;
                    }
                    i6++;
                }
                if (i7 > 0) {
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    this.mRenderPaint.setColor(iLineDataSet.getColor());
                    canvas2.drawLines(this.mLineBuffer, 0, Math.max((this.mXBounds.range + 1) * i2, i2) * 2, this.mRenderPaint);
                }
            }
        }
        this.mRenderPaint.setPathEffect(null);
    }

    /* access modifiers changed from: protected */
    public void drawLinearFill(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        int i2;
        int i3;
        Path path = this.mGenerateFilledPathBuffer;
        int i4 = xBounds.min;
        int i5 = xBounds.range + i4;
        int i6 = 0;
        do {
            i2 = (i6 * 128) + i4;
            i3 = i2 + 128;
            if (i3 > i5) {
                i3 = i5;
            }
            if (i2 <= i3) {
                generateFilledPath(iLineDataSet, i2, i3, path);
                transformer.pathValueToPixel(path);
                Drawable fillDrawable = iLineDataSet.getFillDrawable();
                if (fillDrawable != null) {
                    drawFilledPath(canvas, path, fillDrawable);
                } else {
                    drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
                }
            }
            i6++;
        } while (i2 <= i3);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i2;
        MPPointF mPPointF;
        float f2;
        float f3;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getLineData().getDataSets();
            for (int i3 = 0; i3 < dataSets.size(); i3++) {
                ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i3);
                if (shouldDrawValues(iLineDataSet)) {
                    applyValueTextStyle(iLineDataSet);
                    Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                    int circleRadius = (int) (iLineDataSet.getCircleRadius() * 1.75f);
                    if (!iLineDataSet.isDrawCirclesEnabled()) {
                        circleRadius /= 2;
                    }
                    this.mXBounds.set(this.mChart, iLineDataSet);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesLine = transformer.generateTransformedValuesLine(iLineDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    MPPointF instance = MPPointF.getInstance(iLineDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    int i4 = 0;
                    while (i4 < generateTransformedValuesLine.length) {
                        float f4 = generateTransformedValuesLine[i4];
                        float f5 = generateTransformedValuesLine[i4 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f4)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f4) || !this.mViewPortHandler.isInBoundsY(f5)) {
                            i2 = i4;
                            mPPointF = instance;
                        } else {
                            int i5 = i4 / 2;
                            Entry entryForIndex = iLineDataSet.getEntryForIndex(this.mXBounds.min + i5);
                            if (iLineDataSet.isDrawValuesEnabled()) {
                                f3 = f5;
                                f2 = f4;
                                i2 = i4;
                                mPPointF = instance;
                                drawValue(canvas, iLineDataSet.getValueFormatter(), entryForIndex.getY(), entryForIndex, i3, f4, f5 - ((float) circleRadius), iLineDataSet.getValueTextColor(i5));
                            } else {
                                f3 = f5;
                                f2 = f4;
                                i2 = i4;
                                mPPointF = instance;
                            }
                            if (entryForIndex.getIcon() != null && iLineDataSet.isDrawIconsEnabled()) {
                                Drawable icon = entryForIndex.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f2 + mPPointF.x), (int) (f3 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i4 = i2 + 2;
                        instance = mPPointF;
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            weakReference.get().recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        releaseBitmap();
    }

    /* access modifiers changed from: private */
    public class DataSetImageCache {
        private Bitmap[] circleBitmaps;
        private Path mCirclePathBuffer;

        private DataSetImageCache() {
            this.mCirclePathBuffer = new Path();
        }

        /* access modifiers changed from: protected */
        public void fill(ILineDataSet iLineDataSet, boolean z, boolean z2) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            float circleRadius = iLineDataSet.getCircleRadius();
            float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
            for (int i2 = 0; i2 < circleColorCount; i2++) {
                Bitmap.Config config = Bitmap.Config.ARGB_4444;
                double d2 = (double) circleRadius;
                Double.isNaN(d2);
                int i3 = (int) (d2 * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i3, config);
                Canvas canvas = new Canvas(createBitmap);
                this.circleBitmaps[i2] = createBitmap;
                LineChartRenderer.this.mRenderPaint.setColor(iLineDataSet.getCircleColor(i2));
                if (z2) {
                    this.mCirclePathBuffer.reset();
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleRadius, Path.Direction.CW);
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleHoleRadius, Path.Direction.CCW);
                    canvas.drawPath(this.mCirclePathBuffer, LineChartRenderer.this.mRenderPaint);
                } else {
                    canvas.drawCircle(circleRadius, circleRadius, circleRadius, LineChartRenderer.this.mRenderPaint);
                    if (z) {
                        canvas.drawCircle(circleRadius, circleRadius, circleHoleRadius, LineChartRenderer.this.mCirclePaintInner);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap getBitmap(int i2) {
            Bitmap[] bitmapArr = this.circleBitmaps;
            return bitmapArr[i2 % bitmapArr.length];
        }

        /* access modifiers changed from: protected */
        public boolean init(ILineDataSet iLineDataSet) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            Bitmap[] bitmapArr = this.circleBitmaps;
            if (bitmapArr == null) {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            } else if (bitmapArr.length == circleColorCount) {
                return false;
            } else {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            }
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 r2) {
            this();
        }
    }
}
