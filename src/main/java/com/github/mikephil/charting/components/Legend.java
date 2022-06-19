package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00ab */
        static {
            /*
            // Method dump skipped, instructions count: 184
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    @Deprecated
    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = Utils.FLOAT_EPSILON;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = Utils.FLOAT_EPSILON;
        this.mNeededHeight = Utils.FLOAT_EPSILON;
        this.mTextHeightMax = Utils.FLOAT_EPSILON;
        this.mTextWidthMax = Utils.FLOAT_EPSILON;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormSize);
        float convertDpToPixel2 = Utils.convertDpToPixel(this.mStackSpace);
        float convertDpToPixel3 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mXEntrySpace);
        float convertDpToPixel5 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean z = this.mWordWrapEnabled;
        LegendEntry[] legendEntryArr = this.mEntries;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (i2 == 1) {
            float lineHeight = Utils.getLineHeight(paint);
            float f7 = Utils.FLOAT_EPSILON;
            float f8 = Utils.FLOAT_EPSILON;
            float f9 = Utils.FLOAT_EPSILON;
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                LegendEntry legendEntry = legendEntryArr[i3];
                boolean z3 = legendEntry.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry.formSize)) {
                    f2 = convertDpToPixel;
                } else {
                    f2 = Utils.convertDpToPixel(legendEntry.formSize);
                }
                String str = legendEntry.label;
                if (!z2) {
                    f9 = Utils.FLOAT_EPSILON;
                }
                if (z3) {
                    if (z2) {
                        f9 += convertDpToPixel2;
                    }
                    f9 += f2;
                }
                if (str != null) {
                    if (z3 && !z2) {
                        f9 += convertDpToPixel3;
                    } else if (z2) {
                        f7 = Math.max(f7, f9);
                        f8 += lineHeight + convertDpToPixel5;
                        f9 = Utils.FLOAT_EPSILON;
                        z2 = false;
                    }
                    f9 += (float) Utils.calcTextWidth(paint, str);
                    if (i3 < length - 1) {
                        f8 += lineHeight + convertDpToPixel5;
                    }
                } else {
                    f9 += f2;
                    if (i3 < length - 1) {
                        f9 += convertDpToPixel2;
                    }
                    z2 = true;
                }
                f7 = Math.max(f7, f9);
            }
            this.mNeededWidth = f7;
            this.mNeededHeight = f8;
        } else if (i2 == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + convertDpToPixel5;
            float contentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
            this.mCalculatedLabelBreakPoints.clear();
            this.mCalculatedLabelSizes.clear();
            this.mCalculatedLineSizes.clear();
            int i4 = 0;
            float f10 = Utils.FLOAT_EPSILON;
            int i5 = -1;
            float f11 = Utils.FLOAT_EPSILON;
            float f12 = Utils.FLOAT_EPSILON;
            while (i4 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i4];
                boolean z4 = legendEntry2.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry2.formSize)) {
                    f3 = convertDpToPixel;
                } else {
                    f3 = Utils.convertDpToPixel(legendEntry2.formSize);
                }
                String str2 = legendEntry2.label;
                this.mCalculatedLabelBreakPoints.add(Boolean.FALSE);
                float f13 = i5 == -1 ? Utils.FLOAT_EPSILON : f11 + convertDpToPixel2;
                if (str2 != null) {
                    f4 = convertDpToPixel2;
                    this.mCalculatedLabelSizes.add(Utils.calcTextSize(paint, str2));
                    f5 = f13 + (z4 ? convertDpToPixel3 + f3 : Utils.FLOAT_EPSILON) + this.mCalculatedLabelSizes.get(i4).width;
                } else {
                    f4 = convertDpToPixel2;
                    this.mCalculatedLabelSizes.add(FSize.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON));
                    f5 = f13 + (z4 ? f3 : Utils.FLOAT_EPSILON);
                    if (i5 == -1) {
                        i5 = i4;
                    }
                }
                if (str2 != null || i4 == length - 1) {
                    float f14 = f12 == Utils.FLOAT_EPSILON ? Utils.FLOAT_EPSILON : convertDpToPixel4;
                    if (!z || f12 == Utils.FLOAT_EPSILON || contentWidth - f12 >= f14 + f5) {
                        f6 = f12 + f14 + f5;
                    } else {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f12, lineHeight2));
                        float max = Math.max(f10, f12);
                        this.mCalculatedLabelBreakPoints.set(i5 > -1 ? i5 : i4, Boolean.TRUE);
                        f10 = max;
                        f6 = f5;
                    }
                    if (i4 == length - 1) {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f6, lineHeight2));
                        f10 = Math.max(f10, f6);
                    }
                    f12 = f6;
                }
                if (str2 != null) {
                    i5 = -1;
                }
                i4++;
                convertDpToPixel2 = f4;
                convertDpToPixel = convertDpToPixel;
                convertDpToPixel4 = convertDpToPixel4;
                lineSpacing = lineSpacing;
                f11 = f5;
                legendEntryArr = legendEntryArr;
            }
            this.mNeededWidth = f10;
            this.mNeededHeight = (lineHeight2 * ((float) this.mCalculatedLineSizes.size())) + (lineSpacing * ((float) (this.mCalculatedLineSizes.size() == 0 ? 0 : this.mCalculatedLineSizes.size() - 1)));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    @Deprecated
    public int[] getColors() {
        int[] iArr = new int[this.mEntries.length];
        int i2 = 0;
        while (true) {
            LegendEntry[] legendEntryArr = this.mEntries;
            if (i2 >= legendEntryArr.length) {
                return iArr;
            }
            iArr[i2] = legendEntryArr[i2].form == LegendForm.NONE ? ColorTemplate.COLOR_SKIP : legendEntryArr[i2].form == LegendForm.EMPTY ? ColorTemplate.COLOR_NONE : legendEntryArr[i2].formColor;
            i2++;
        }
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    @Deprecated
    public int[] getExtraColors() {
        int[] iArr = new int[this.mExtraEntries.length];
        int i2 = 0;
        while (true) {
            LegendEntry[] legendEntryArr = this.mExtraEntries;
            if (i2 >= legendEntryArr.length) {
                return iArr;
            }
            iArr[i2] = legendEntryArr[i2].form == LegendForm.NONE ? ColorTemplate.COLOR_SKIP : legendEntryArr[i2].form == LegendForm.EMPTY ? ColorTemplate.COLOR_NONE : legendEntryArr[i2].formColor;
            i2++;
        }
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    @Deprecated
    public String[] getExtraLabels() {
        String[] strArr = new String[this.mExtraEntries.length];
        int i2 = 0;
        while (true) {
            LegendEntry[] legendEntryArr = this.mExtraEntries;
            if (i2 >= legendEntryArr.length) {
                return strArr;
            }
            strArr[i2] = legendEntryArr[i2].label;
            i2++;
        }
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    @Deprecated
    public String[] getLabels() {
        String[] strArr = new String[this.mEntries.length];
        int i2 = 0;
        while (true) {
            LegendEntry[] legendEntryArr = this.mEntries;
            if (i2 >= legendEntryArr.length) {
                return strArr;
            }
            strArr[i2] = legendEntryArr[i2].label;
            i2++;
        }
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public float getMaximumEntryHeight(Paint paint) {
        LegendEntry[] legendEntryArr = this.mEntries;
        float f2 = Utils.FLOAT_EPSILON;
        for (LegendEntry legendEntry : legendEntryArr) {
            String str = legendEntry.label;
            if (str != null) {
                float calcTextHeight = (float) Utils.calcTextHeight(paint, str);
                if (calcTextHeight > f2) {
                    f2 = calcTextHeight;
                }
            }
        }
        return f2;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormToTextSpace);
        LegendEntry[] legendEntryArr = this.mEntries;
        float f2 = Utils.FLOAT_EPSILON;
        float f3 = Utils.FLOAT_EPSILON;
        for (LegendEntry legendEntry : legendEntryArr) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.mFormSize : legendEntry.formSize);
            if (convertDpToPixel2 > f3) {
                f3 = convertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float calcTextWidth = (float) Utils.calcTextWidth(paint, str);
                if (calcTextWidth > f2) {
                    f2 = calcTextWidth;
                }
            }
        }
        return f2 + f3 + convertDpToPixel;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    @Deprecated
    public LegendPosition getPosition() {
        LegendOrientation legendOrientation = this.mOrientation;
        if (legendOrientation == LegendOrientation.VERTICAL && this.mHorizontalAlignment == LegendHorizontalAlignment.CENTER && this.mVerticalAlignment == LegendVerticalAlignment.CENTER) {
            return LegendPosition.PIECHART_CENTER;
        }
        if (legendOrientation == LegendOrientation.HORIZONTAL) {
            if (this.mVerticalAlignment == LegendVerticalAlignment.TOP) {
                LegendHorizontalAlignment legendHorizontalAlignment = this.mHorizontalAlignment;
                if (legendHorizontalAlignment == LegendHorizontalAlignment.LEFT) {
                    return LegendPosition.ABOVE_CHART_LEFT;
                }
                return legendHorizontalAlignment == LegendHorizontalAlignment.RIGHT ? LegendPosition.ABOVE_CHART_RIGHT : LegendPosition.ABOVE_CHART_CENTER;
            }
            LegendHorizontalAlignment legendHorizontalAlignment2 = this.mHorizontalAlignment;
            if (legendHorizontalAlignment2 == LegendHorizontalAlignment.LEFT) {
                return LegendPosition.BELOW_CHART_LEFT;
            }
            return legendHorizontalAlignment2 == LegendHorizontalAlignment.RIGHT ? LegendPosition.BELOW_CHART_RIGHT : LegendPosition.BELOW_CHART_CENTER;
        } else if (this.mHorizontalAlignment == LegendHorizontalAlignment.LEFT) {
            LegendVerticalAlignment legendVerticalAlignment = this.mVerticalAlignment;
            if (legendVerticalAlignment != LegendVerticalAlignment.TOP || !this.mDrawInside) {
                return legendVerticalAlignment == LegendVerticalAlignment.CENTER ? LegendPosition.LEFT_OF_CHART_CENTER : LegendPosition.LEFT_OF_CHART;
            }
            return LegendPosition.LEFT_OF_CHART_INSIDE;
        } else {
            LegendVerticalAlignment legendVerticalAlignment2 = this.mVerticalAlignment;
            if (legendVerticalAlignment2 != LegendVerticalAlignment.TOP || !this.mDrawInside) {
                return legendVerticalAlignment2 == LegendVerticalAlignment.CENTER ? LegendPosition.RIGHT_OF_CHART_CENTER : LegendPosition.RIGHT_OF_CHART;
            }
            return LegendPosition.RIGHT_OF_CHART_INSIDE;
        }
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.mEntries = legendEntryArr;
        this.mIsLegendCustom = true;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public void setDrawInside(boolean z) {
        this.mDrawInside = z;
    }

    public void setEntries(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(List<LegendEntry> list) {
        this.mExtraEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f2) {
        this.mFormLineWidth = f2;
    }

    public void setFormSize(float f2) {
        this.mFormSize = f2;
    }

    public void setFormToTextSpace(float f2) {
        this.mFormToTextSpace = f2;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.mHorizontalAlignment = legendHorizontalAlignment;
    }

    public void setMaxSizePercent(float f2) {
        this.mMaxSizePercent = f2;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.mOrientation = legendOrientation;
    }

    @Deprecated
    public void setPosition(LegendPosition legendPosition) {
        switch (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition[legendPosition.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
                this.mVerticalAlignment = legendPosition == LegendPosition.LEFT_OF_CHART_CENTER ? LegendVerticalAlignment.CENTER : LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
            case 4:
            case 5:
            case 6:
                this.mHorizontalAlignment = LegendHorizontalAlignment.RIGHT;
                this.mVerticalAlignment = legendPosition == LegendPosition.RIGHT_OF_CHART_CENTER ? LegendVerticalAlignment.CENTER : LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
            case 7:
            case 8:
            case 9:
                this.mHorizontalAlignment = legendPosition == LegendPosition.ABOVE_CHART_LEFT ? LegendHorizontalAlignment.LEFT : legendPosition == LegendPosition.ABOVE_CHART_RIGHT ? LegendHorizontalAlignment.RIGHT : LegendHorizontalAlignment.CENTER;
                this.mVerticalAlignment = LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.HORIZONTAL;
                break;
            case 10:
            case 11:
            case 12:
                this.mHorizontalAlignment = legendPosition == LegendPosition.BELOW_CHART_LEFT ? LegendHorizontalAlignment.LEFT : legendPosition == LegendPosition.BELOW_CHART_RIGHT ? LegendHorizontalAlignment.RIGHT : LegendHorizontalAlignment.CENTER;
                this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
                this.mOrientation = LegendOrientation.HORIZONTAL;
                break;
            case 13:
                this.mHorizontalAlignment = LegendHorizontalAlignment.CENTER;
                this.mVerticalAlignment = LegendVerticalAlignment.CENTER;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
        }
        this.mDrawInside = legendPosition == LegendPosition.LEFT_OF_CHART_INSIDE || legendPosition == LegendPosition.RIGHT_OF_CHART_INSIDE;
    }

    public void setStackSpace(float f2) {
        this.mStackSpace = f2;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.mVerticalAlignment = legendVerticalAlignment;
    }

    public void setWordWrapEnabled(boolean z) {
        this.mWordWrapEnabled = z;
    }

    public void setXEntrySpace(float f2) {
        this.mXEntrySpace = f2;
    }

    public void setYEntrySpace(float f2) {
        this.mYEntrySpace = f2;
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.mExtraEntries = legendEntryArr;
    }

    public void setCustom(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.mIsLegendCustom = true;
    }

    @Deprecated
    public void setExtra(List<Integer> list, List<String> list2) {
        setExtra(Utils.convertIntegers(list), Utils.convertStrings(list2));
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < Math.min(iArr.length, strArr.length); i2++) {
            LegendEntry legendEntry = new LegendEntry();
            int i3 = iArr[i2];
            legendEntry.formColor = i3;
            legendEntry.label = strArr[i2];
            if (i3 == 1122868 || i3 == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (i3 == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.mExtraEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.mEntries = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }

    @Deprecated
    public Legend(int[] iArr, String[] strArr) {
        this();
        if (iArr == null || strArr == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (iArr.length == strArr.length) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < Math.min(iArr.length, strArr.length); i2++) {
                LegendEntry legendEntry = new LegendEntry();
                int i3 = iArr[i2];
                legendEntry.formColor = i3;
                legendEntry.label = strArr[i2];
                if (i3 == 1122868) {
                    legendEntry.form = LegendForm.NONE;
                } else if (i3 == 1122867 || i3 == 0) {
                    legendEntry.form = LegendForm.EMPTY;
                }
                arrayList.add(legendEntry);
            }
            this.mEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
        } else {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
    }

    @Deprecated
    public Legend(List<Integer> list, List<String> list2) {
        this(Utils.convertIntegers(list), Utils.convertStrings(list2));
    }
}
