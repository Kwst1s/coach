package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries = new ArrayList(16);
    protected Paint.FontMetrics legendFontMetrics = new Paint.FontMetrics();
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath = new Path();

    /* access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|(2:21|22)|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a4 */
        static {
            /*
            // Method dump skipped, instructions count: 175
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public void computeLegend(ChartData<?> chartData) {
        ChartData<?> chartData2;
        String str;
        ChartData<?> chartData3 = chartData;
        if (!this.mLegend.isLegendCustom()) {
            this.computedEntries.clear();
            int i2 = 0;
            while (i2 < chartData.getDataSetCount()) {
                IDataSet dataSetByIndex = chartData3.getDataSetByIndex(i2);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        int i3 = 0;
                        while (i3 < colors.size() && i3 < iBarDataSet.getStackSize()) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i3 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i3).intValue()));
                            i3++;
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                        chartData2 = chartData3;
                        i2++;
                        chartData3 = chartData2;
                    }
                }
                if (dataSetByIndex instanceof IPieDataSet) {
                    IPieDataSet iPieDataSet = (IPieDataSet) dataSetByIndex;
                    int i4 = 0;
                    while (i4 < colors.size() && i4 < entryCount) {
                        this.computedEntries.add(new LegendEntry(((PieEntry) iPieDataSet.getEntryForIndex(i4)).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i4).intValue()));
                        i4++;
                    }
                    if (iPieDataSet.getLabel() != null) {
                        this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                    }
                } else {
                    if (dataSetByIndex instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                        if (iCandleDataSet.getDecreasingColor() != 1122867) {
                            int decreasingColor = iCandleDataSet.getDecreasingColor();
                            int increasingColor = iCandleDataSet.getIncreasingColor();
                            this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor));
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor));
                        }
                    }
                    int i5 = 0;
                    while (i5 < colors.size() && i5 < entryCount) {
                        if (i5 >= colors.size() - 1 || i5 >= entryCount - 1) {
                            str = chartData.getDataSetByIndex(i2).getLabel();
                        } else {
                            str = null;
                        }
                        this.computedEntries.add(new LegendEntry(str, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i5).intValue()));
                        i5++;
                    }
                }
                chartData2 = chartData;
                i2++;
                chartData3 = chartData2;
            }
            if (this.mLegend.getExtraEntries() != null) {
                Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
            }
            this.mLegend.setEntries(this.computedEntries);
        }
        Typeface typeface = this.mLegend.getTypeface();
        if (typeface != null) {
            this.mLegendLabelPaint.setTypeface(typeface);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    /* access modifiers changed from: protected */
    public void drawForm(Canvas canvas, float f2, float f3, LegendEntry legendEntry, Legend legend) {
        int i2 = legendEntry.formColor;
        if (i2 != 1122868 && i2 != 1122867 && i2 != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = legendEntry.form;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.getForm();
            }
            this.mLegendFormPaint.setColor(legendEntry.formColor);
            float convertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
            float f4 = convertDpToPixel / 2.0f;
            int i3 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[legendForm.ordinal()];
            if (i3 == 3 || i3 == 4) {
                this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f2 + f4, f3, f4, this.mLegendFormPaint);
            } else if (i3 == 5) {
                this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                canvas.drawRect(f2, f3 - f4, f2 + convertDpToPixel, f3 + f4, this.mLegendFormPaint);
            } else if (i3 == 6) {
                float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
                DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
                if (dashPathEffect == null) {
                    dashPathEffect = legend.getFormLineDashEffect();
                }
                this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                this.mLegendFormPaint.setStrokeWidth(convertDpToPixel2);
                this.mLegendFormPaint.setPathEffect(dashPathEffect);
                this.mLineFormPath.reset();
                this.mLineFormPath.moveTo(f2, f3);
                this.mLineFormPath.lineTo(f2 + convertDpToPixel, f3);
                canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        List<Boolean> list;
        List<FSize> list2;
        int i2;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f17;
        float f18;
        float f19;
        float f20;
        double d2;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float calcTextHeight = lineHeight - (((float) Utils.calcTextHeight(this.mLegendLabelPaint, "ABC")) / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float convertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float convertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float convertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float convertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i3 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            float f21 = convertDpToPixel4;
            float f22 = convertDpToPixel2;
            if (i3 == 1) {
                f3 = lineHeight;
                f2 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                f4 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i3 == 2) {
                f3 = lineHeight;
                f2 = lineSpacing;
                if (orientation == Legend.LegendOrientation.VERTICAL) {
                    f19 = this.mViewPortHandler.getChartWidth();
                } else {
                    f19 = this.mViewPortHandler.contentRight();
                }
                f4 = f19 - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f4 -= this.mLegend.mNeededWidth;
                }
            } else if (i3 != 3) {
                f3 = lineHeight;
                f2 = lineSpacing;
                f4 = Utils.FLOAT_EPSILON;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                if (orientation == legendOrientation) {
                    f20 = this.mViewPortHandler.getChartWidth() / 2.0f;
                } else {
                    f20 = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                }
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f2 = lineSpacing;
                f4 = f20 + (direction == legendDirection2 ? xOffset : -xOffset);
                if (orientation == legendOrientation) {
                    double d3 = (double) f4;
                    if (direction == legendDirection2) {
                        f3 = lineHeight;
                        double d4 = (double) (-this.mLegend.mNeededWidth);
                        Double.isNaN(d4);
                        double d5 = (double) xOffset;
                        Double.isNaN(d5);
                        d2 = (d4 / 2.0d) + d5;
                    } else {
                        f3 = lineHeight;
                        double d6 = (double) this.mLegend.mNeededWidth;
                        Double.isNaN(d6);
                        double d7 = (double) xOffset;
                        Double.isNaN(d7);
                        d2 = (d6 / 2.0d) - d7;
                    }
                    Double.isNaN(d3);
                    f4 = (float) (d3 + d2);
                } else {
                    f3 = lineHeight;
                }
            }
            int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i4 == 1) {
                float f23 = f21;
                List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                int i5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i5 != 1) {
                    if (i5 == 2) {
                        yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                    } else if (i5 != 3) {
                        yOffset = Utils.FLOAT_EPSILON;
                    } else {
                        yOffset += (this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f;
                    }
                }
                int length = entries.length;
                float f24 = f4;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    LegendEntry legendEntry2 = entries[i6];
                    boolean z = legendEntry2.form != Legend.LegendForm.NONE;
                    float convertDpToPixel5 = Float.isNaN(legendEntry2.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                    if (i6 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i6).booleanValue()) {
                        f6 = f24;
                        f5 = yOffset;
                    } else {
                        f5 = yOffset + f3 + f2;
                        f6 = f4;
                    }
                    if (f6 == f4 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i7 < calculatedLineSizes.size()) {
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f11 = calculatedLineSizes.get(i7).width;
                        } else {
                            f11 = -calculatedLineSizes.get(i7).width;
                        }
                        f6 += f11 / 2.0f;
                        i7++;
                    }
                    boolean z2 = legendEntry2.label == null;
                    if (z) {
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f6 -= convertDpToPixel5;
                        }
                        list2 = calculatedLineSizes;
                        i2 = i6;
                        list = calculatedLabelBreakPoints;
                        drawForm(canvas, f6, f5 + calcTextHeight, legendEntry2, this.mLegend);
                        f6 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f6 + convertDpToPixel5 : f6;
                    } else {
                        list = calculatedLabelBreakPoints;
                        list2 = calculatedLineSizes;
                        i2 = i6;
                    }
                    if (!z2) {
                        if (z) {
                            f6 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -convertDpToPixel : convertDpToPixel;
                        }
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.RIGHT_TO_LEFT;
                        if (direction == legendDirection3) {
                            f6 -= calculatedLabelSizes.get(i2).width;
                        }
                        drawLabel(canvas, f6, f5 + f3, legendEntry2.label);
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f6 += calculatedLabelSizes.get(i2).width;
                        }
                        if (direction == legendDirection3) {
                            f8 = f22;
                            f10 = -f8;
                        } else {
                            f8 = f22;
                            f10 = f8;
                        }
                        f24 = f6 + f10;
                        f7 = f23;
                    } else {
                        f8 = f22;
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f7 = f23;
                            f9 = -f7;
                        } else {
                            f7 = f23;
                            f9 = f7;
                        }
                        f24 = f6 + f9;
                    }
                    f22 = f8;
                    f23 = f7;
                    i6 = i2 + 1;
                    yOffset = f5;
                    length = length;
                    i7 = i7;
                    calculatedLineSizes = list2;
                    calculatedLabelBreakPoints = list;
                }
            } else if (i4 == 2) {
                int i8 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i8 == 1) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        f17 = Utils.FLOAT_EPSILON;
                    } else {
                        f17 = this.mViewPortHandler.contentTop();
                    }
                    f12 = f17 + yOffset;
                } else if (i8 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        f18 = this.mViewPortHandler.getChartHeight();
                    } else {
                        f18 = this.mViewPortHandler.contentBottom();
                    }
                    f12 = f18 - (this.mLegend.mNeededHeight + yOffset);
                } else if (i8 != 3) {
                    f12 = Utils.FLOAT_EPSILON;
                } else {
                    Legend legend = this.mLegend;
                    f12 = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f25 = f12;
                boolean z3 = false;
                int i9 = 0;
                float f26 = Utils.FLOAT_EPSILON;
                while (i9 < entries.length) {
                    LegendEntry legendEntry3 = entries[i9];
                    boolean z4 = legendEntry3.form != Legend.LegendForm.NONE;
                    float convertDpToPixel6 = Float.isNaN(legendEntry3.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry3.formSize);
                    if (z4) {
                        Legend.LegendDirection legendDirection4 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f15 = direction == legendDirection4 ? f4 + f26 : f4 - (convertDpToPixel6 - f26);
                        f14 = calcTextHeight;
                        f16 = f21;
                        f13 = f4;
                        legendDirection = direction;
                        drawForm(canvas, f15, f25 + calcTextHeight, legendEntry3, this.mLegend);
                        if (legendDirection == legendDirection4) {
                            f15 += convertDpToPixel6;
                        }
                        legendEntry = legendEntry3;
                    } else {
                        f13 = f4;
                        f14 = calcTextHeight;
                        f16 = f21;
                        legendDirection = direction;
                        legendEntry = legendEntry3;
                        f15 = f13;
                    }
                    String str = legendEntry.label;
                    if (str != null) {
                        if (z4 && !z3) {
                            f15 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? convertDpToPixel : -convertDpToPixel;
                        } else if (z3) {
                            f15 = f13;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f15 -= (float) Utils.calcTextWidth(this.mLegendLabelPaint, str);
                        }
                        if (!z3) {
                            drawLabel(canvas, f15, f25 + f3, legendEntry.label);
                        } else {
                            f25 += f3 + f2;
                            drawLabel(canvas, f15, f25 + f3, legendEntry.label);
                        }
                        f25 += f3 + f2;
                        f26 = Utils.FLOAT_EPSILON;
                    } else {
                        f26 += convertDpToPixel6 + f16;
                        z3 = true;
                    }
                    i9++;
                    direction = legendDirection;
                    f21 = f16;
                    calcTextHeight = f14;
                    f4 = f13;
                }
            }
        }
    }
}
