package com.github.mikephil.charting.data;

import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues = null;
    protected float mXMax = -3.4028235E38f;
    protected float mXMin = Float.MAX_VALUE;
    protected float mYMax = -3.4028235E38f;
    protected float mYMin = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean addEntry(T t) {
        if (t == null) {
            return false;
        }
        List<T> values = getValues();
        if (values == null) {
            values = new ArrayList<>();
        }
        calcMinMax(t);
        return values.add(t);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void addEntryOrdered(T t) {
        if (t != null) {
            if (this.mValues == null) {
                this.mValues = new ArrayList();
            }
            calcMinMax(t);
            if (this.mValues.size() > 0) {
                List<T> list = this.mValues;
                if (list.get(list.size() - 1).getX() > t.getX()) {
                    this.mValues.add(getEntryIndex(t.getX(), t.getY(), Rounding.UP), t);
                    return;
                }
            }
            this.mValues.add(t);
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMax() {
        List<T> list = this.mValues;
        if (!(list == null || list.isEmpty())) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T t : this.mValues) {
                calcMinMax(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxX(T t) {
        if (t.getX() < this.mXMin) {
            this.mXMin = t.getX();
        }
        if (t.getX() > this.mXMax) {
            this.mXMax = t.getX();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMaxY(float f2, float f3) {
        List<T> list = this.mValues;
        if (!(list == null || list.isEmpty())) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            int entryIndex = getEntryIndex(f3, Float.NaN, Rounding.UP);
            for (int entryIndex2 = getEntryIndex(f2, Float.NaN, Rounding.DOWN); entryIndex2 <= entryIndex; entryIndex2++) {
                calcMinMaxY(this.mValues.get(entryIndex2));
            }
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public abstract DataSet<T> copy();

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<T> getEntriesForXValue(float f2) {
        ArrayList arrayList = new ArrayList();
        int size = this.mValues.size() - 1;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            }
            int i3 = (size + i2) / 2;
            T t = this.mValues.get(i3);
            if (f2 == t.getX()) {
                while (i3 > 0 && this.mValues.get(i3 - 1).getX() == f2) {
                    i3--;
                }
                int size2 = this.mValues.size();
                while (i3 < size2) {
                    T t2 = this.mValues.get(i3);
                    if (t2.getX() != f2) {
                        break;
                    }
                    arrayList.add(t2);
                    i3++;
                }
            } else if (f2 > t.getX()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryCount() {
        return this.mValues.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForIndex(int i2) {
        return this.mValues.get(i2);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f2, float f3, Rounding rounding) {
        int entryIndex = getEntryIndex(f2, f3, rounding);
        if (entryIndex > -1) {
            return this.mValues.get(entryIndex);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf(entry);
    }

    public List<T> getValues() {
        return this.mValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMax() {
        return this.mXMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMin() {
        return this.mXMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMax() {
        return this.mYMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMin() {
        return this.mYMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(T t) {
        List<T> list;
        if (t == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(t);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public void setValues(List<T> list) {
        this.mValues = list;
        notifyDataSetChanged();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? BuildConfig.FLAVOR : getLabel());
        sb.append(", entries: ");
        sb.append(this.mValues.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i2 = 0; i2 < this.mValues.size(); i2++) {
            stringBuffer.append(this.mValues.get(i2).toString() + " ");
        }
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(float f2, float f3, Rounding rounding) {
        T t;
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i2 = 0;
        int size = this.mValues.size() - 1;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float x = this.mValues.get(i3).getX() - f2;
            int i4 = i3 + 1;
            float abs = Math.abs(x);
            float abs2 = Math.abs(this.mValues.get(i4).getX() - f2);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d2 = (double) x;
                    if (d2 < Utils.DOUBLE_EPSILON) {
                        if (d2 >= Utils.DOUBLE_EPSILON) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size == -1) {
            return size;
        }
        float x2 = this.mValues.get(size).getX();
        if (rounding == Rounding.UP) {
            if (x2 < f2 && size < this.mValues.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x2 > f2 && size > 0) {
            size--;
        }
        if (Float.isNaN(f3)) {
            return size;
        }
        while (size > 0 && this.mValues.get(size - 1).getX() == x2) {
            size--;
        }
        float y = this.mValues.get(size).getY();
        loop2:
        while (true) {
            do {
                size++;
                if (size >= this.mValues.size()) {
                    break loop2;
                }
                t = this.mValues.get(size);
                if (t.getX() != x2) {
                    break loop2;
                }
            } while (Math.abs(t.getY() - f3) >= Math.abs(y - f3));
            y = f3;
        }
        return size;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f2, float f3) {
        return getEntryForXValue(f2, f3, Rounding.CLOSEST);
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxY(T t) {
        if (t.getY() < this.mYMin) {
            this.mYMin = t.getY();
        }
        if (t.getY() > this.mYMax) {
            this.mYMax = t.getY();
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(T t) {
        if (t != null) {
            calcMinMaxX(t);
            calcMinMaxY(t);
        }
    }
}
