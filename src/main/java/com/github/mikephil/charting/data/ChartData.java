package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    public ChartData() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = new ArrayList();
    }

    private List<T> arrayToList(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public void addDataSet(T t) {
        if (t != null) {
            calcMinMax(t);
            this.mDataSets.add(t);
        }
    }

    public void addEntry(Entry entry, int i2) {
        if (this.mDataSets.size() <= i2 || i2 < 0) {
            Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
            return;
        }
        T t = this.mDataSets.get(i2);
        if (t.addEntry(entry)) {
            calcMinMax(entry, t.getAxisDependency());
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        List<T> list = this.mDataSets;
        if (list != null) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T t : list) {
                calcMinMax(t);
            }
            this.mLeftAxisMax = -3.4028235E38f;
            this.mLeftAxisMin = Float.MAX_VALUE;
            this.mRightAxisMax = -3.4028235E38f;
            this.mRightAxisMin = Float.MAX_VALUE;
            T firstLeft = getFirstLeft(this.mDataSets);
            if (firstLeft != null) {
                this.mLeftAxisMax = firstLeft.getYMax();
                this.mLeftAxisMin = firstLeft.getYMin();
                for (T t2 : this.mDataSets) {
                    if (t2.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        if (t2.getYMin() < this.mLeftAxisMin) {
                            this.mLeftAxisMin = t2.getYMin();
                        }
                        if (t2.getYMax() > this.mLeftAxisMax) {
                            this.mLeftAxisMax = t2.getYMax();
                        }
                    }
                }
            }
            T firstRight = getFirstRight(this.mDataSets);
            if (firstRight != null) {
                this.mRightAxisMax = firstRight.getYMax();
                this.mRightAxisMin = firstRight.getYMin();
                for (T t3 : this.mDataSets) {
                    if (t3.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                        if (t3.getYMin() < this.mRightAxisMin) {
                            this.mRightAxisMin = t3.getYMin();
                        }
                        if (t3.getYMax() > this.mRightAxisMax) {
                            this.mRightAxisMax = t3.getYMax();
                        }
                    }
                }
            }
        }
    }

    public void calcMinMaxY(float f2, float f3) {
        for (T t : this.mDataSets) {
            t.calcMinMaxY(f2, f3);
        }
        calcMinMax();
    }

    public void clearValues() {
        List<T> list = this.mDataSets;
        if (list != null) {
            list.clear();
        }
        notifyDataChanged();
    }

    public boolean contains(T t) {
        for (T t2 : this.mDataSets) {
            if (t2.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.mDataSets.size(); i3++) {
            i2 += this.mDataSets.get(i3).getColors().size();
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < this.mDataSets.size(); i5++) {
            for (Integer num : this.mDataSets.get(i5).getColors()) {
                iArr[i4] = num.intValue();
                i4++;
            }
        }
        return iArr;
    }

    public T getDataSetByIndex(int i2) {
        List<T> list = this.mDataSets;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.mDataSets.get(i2);
    }

    public T getDataSetByLabel(String str, boolean z) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(dataSetIndexByLabel);
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.mDataSets.size(); i2++) {
            T t = this.mDataSets.get(i2);
            for (int i3 = 0; i3 < t.getEntryCount(); i3++) {
                if (entry.equalTo(t.getEntryForXValue(entry.getX(), entry.getY()))) {
                    return t;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndexByLabel(List<T> list, String str, boolean z) {
        int i2 = 0;
        if (z) {
            while (i2 < list.size()) {
                if (str.equalsIgnoreCase(list.get(i2).getLabel())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < list.size()) {
            if (str.equals(list.get(i2).getLabel())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i2 = 0; i2 < this.mDataSets.size(); i2++) {
            strArr[i2] = this.mDataSets.get(i2).getLabel();
        }
        return strArr;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    public int getEntryCount() {
        int i2 = 0;
        for (T t : this.mDataSets) {
            i2 += t.getEntryCount();
        }
        return i2;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataSetIndex() >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(highlight.getDataSetIndex()).getEntryForXValue(highlight.getX(), highlight.getY());
    }

    /* access modifiers changed from: protected */
    public T getFirstLeft(List<T> list) {
        for (T t : list) {
            if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public T getFirstRight(List<T> list) {
        for (T t : list) {
            if (t.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public int getIndexOfDataSet(T t) {
        return this.mDataSets.indexOf(t);
    }

    public T getMaxEntryCountSet() {
        List<T> list = this.mDataSets;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t = this.mDataSets.get(0);
        for (T t2 : this.mDataSets) {
            if (t2.getEntryCount() > t.getEntryCount()) {
                t = t2;
            }
        }
        return t;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public boolean isHighlightEnabled() {
        for (T t : this.mDataSets) {
            if (!t.isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void notifyDataChanged() {
        calcMinMax();
    }

    public boolean removeDataSet(T t) {
        if (t == null) {
            return false;
        }
        boolean remove = this.mDataSets.remove(t);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public boolean removeEntry(Entry entry, int i2) {
        T t;
        if (entry == null || i2 >= this.mDataSets.size() || (t = this.mDataSets.get(i2)) == null) {
            return false;
        }
        boolean removeEntry = t.removeEntry(entry);
        if (removeEntry) {
            calcMinMax();
        }
        return removeEntry;
    }

    public void setDrawValues(boolean z) {
        for (T t : this.mDataSets) {
            t.setDrawValues(z);
        }
    }

    public void setHighlightEnabled(boolean z) {
        for (T t : this.mDataSets) {
            t.setHighlightEnabled(z);
        }
    }

    public void setValueFormatter(IValueFormatter iValueFormatter) {
        if (iValueFormatter != null) {
            for (T t : this.mDataSets) {
                t.setValueFormatter(iValueFormatter);
            }
        }
    }

    public void setValueTextColor(int i2) {
        for (T t : this.mDataSets) {
            t.setValueTextColor(i2);
        }
    }

    public void setValueTextColors(List<Integer> list) {
        for (T t : this.mDataSets) {
            t.setValueTextColors(list);
        }
    }

    public void setValueTextSize(float f2) {
        for (T t : this.mDataSets) {
            t.setValueTextSize(f2);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        for (T t : this.mDataSets) {
            t.setValueTypeface(typeface);
        }
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.mLeftAxisMax;
            return f2 == -3.4028235E38f ? this.mRightAxisMax : f2;
        }
        float f3 = this.mRightAxisMax;
        return f3 == -3.4028235E38f ? this.mLeftAxisMax : f3;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.mLeftAxisMin;
            return f2 == Float.MAX_VALUE ? this.mRightAxisMin : f2;
        }
        float f3 = this.mRightAxisMin;
        return f3 == Float.MAX_VALUE ? this.mLeftAxisMin : f3;
    }

    public boolean removeDataSet(int i2) {
        if (i2 >= this.mDataSets.size() || i2 < 0) {
            return false;
        }
        return removeDataSet(this.mDataSets.get(i2));
    }

    public boolean removeEntry(float f2, int i2) {
        Entry entryForXValue;
        if (i2 < this.mDataSets.size() && (entryForXValue = this.mDataSets.get(i2).getEntryForXValue(f2, Float.NaN)) != null) {
            return removeEntry(entryForXValue, i2);
        }
        return false;
    }

    public ChartData(T... tArr) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = arrayToList(tArr);
        notifyDataChanged();
    }

    public ChartData(List<T> list) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = list;
        notifyDataChanged();
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.mYMax < entry.getY()) {
            this.mYMax = entry.getY();
        }
        if (this.mYMin > entry.getY()) {
            this.mYMin = entry.getY();
        }
        if (this.mXMax < entry.getX()) {
            this.mXMax = entry.getX();
        }
        if (this.mXMin > entry.getX()) {
            this.mXMin = entry.getX();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < entry.getY()) {
                this.mLeftAxisMax = entry.getY();
            }
            if (this.mLeftAxisMin > entry.getY()) {
                this.mLeftAxisMin = entry.getY();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < entry.getY()) {
            this.mRightAxisMax = entry.getY();
        }
        if (this.mRightAxisMin > entry.getY()) {
            this.mRightAxisMin = entry.getY();
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(T t) {
        if (this.mYMax < t.getYMax()) {
            this.mYMax = t.getYMax();
        }
        if (this.mYMin > t.getYMin()) {
            this.mYMin = t.getYMin();
        }
        if (this.mXMax < t.getXMax()) {
            this.mXMax = t.getXMax();
        }
        if (this.mXMin > t.getXMin()) {
            this.mXMin = t.getXMin();
        }
        if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < t.getYMax()) {
                this.mLeftAxisMax = t.getYMax();
            }
            if (this.mLeftAxisMin > t.getYMin()) {
                this.mLeftAxisMin = t.getYMin();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < t.getYMax()) {
            this.mRightAxisMax = t.getYMax();
        }
        if (this.mRightAxisMin > t.getYMin()) {
            this.mRightAxisMin = t.getYMin();
        }
    }
}
