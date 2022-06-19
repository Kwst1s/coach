package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer = new float[2];

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.mChart.getScatterData().getDataSets()) {
            if (iScatterDataSet.isVisible()) {
                drawDataSet(canvas, iScatterDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        IShapeRenderer shapeRenderer = iScatterDataSet.getShapeRenderer();
        if (shapeRenderer == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int min = (int) Math.min(Math.ceil((double) (((float) iScatterDataSet.getEntryCount()) * this.mAnimator.getPhaseX())), (double) ((float) iScatterDataSet.getEntryCount()));
        for (int i2 = 0; i2 < min; i2++) {
            Entry entryForIndex = iScatterDataSet.getEntryForIndex(i2);
            this.mPixelBuffer[0] = entryForIndex.getX();
            this.mPixelBuffer[1] = entryForIndex.getY() * phaseY;
            transformer.pointValuesToPixel(this.mPixelBuffer);
            if (viewPortHandler.isInBoundsRight(this.mPixelBuffer[0])) {
                if (viewPortHandler.isInBoundsLeft(this.mPixelBuffer[0]) && viewPortHandler.isInBoundsY(this.mPixelBuffer[1])) {
                    this.mRenderPaint.setColor(iScatterDataSet.getColor(i2 / 2));
                    ViewPortHandler viewPortHandler2 = this.mViewPortHandler;
                    float[] fArr = this.mPixelBuffer;
                    shapeRenderer.renderShape(canvas, iScatterDataSet, viewPortHandler2, fArr[0], fArr[1], this.mRenderPaint);
                }
            } else {
                return;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.mChart.getScatterData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (IScatterDataSet) scatterData.getDataSetByIndex(highlight.getDataSetIndex());
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

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i2;
        MPPointF mPPointF;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getScatterData().getDataSets();
            for (int i3 = 0; i3 < this.mChart.getScatterData().getDataSetCount(); i3++) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i3);
                if (shouldDrawValues(iScatterDataSet)) {
                    applyValueTextStyle(iScatterDataSet);
                    this.mXBounds.set(this.mChart, iScatterDataSet);
                    Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesScatter = transformer.generateTransformedValuesScatter(iScatterDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    MPPointF instance = MPPointF.getInstance(iScatterDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    int i4 = 0;
                    while (i4 < generateTransformedValuesScatter.length && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i4])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i4])) {
                            int i5 = i4 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i5])) {
                                int i6 = i4 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(this.mXBounds.min + i6);
                                if (iScatterDataSet.isDrawValuesEnabled()) {
                                    i2 = i4;
                                    mPPointF = instance;
                                    drawValue(canvas, iScatterDataSet.getValueFormatter(), entryForIndex.getY(), entryForIndex, i3, generateTransformedValuesScatter[i4], generateTransformedValuesScatter[i5] - convertDpToPixel, iScatterDataSet.getValueTextColor(i6 + this.mXBounds.min));
                                } else {
                                    i2 = i4;
                                    mPPointF = instance;
                                }
                                if (entryForIndex.getIcon() != null && iScatterDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = entryForIndex.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (generateTransformedValuesScatter[i2] + mPPointF.x), (int) (generateTransformedValuesScatter[i5] + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                                i4 = i2 + 2;
                                instance = mPPointF;
                            }
                        }
                        i2 = i4;
                        mPPointF = instance;
                        i4 = i2 + 2;
                        instance = mPPointF;
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
