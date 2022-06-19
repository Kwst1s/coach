package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public float getGreatestShapeSize() {
        float f2 = Utils.FLOAT_EPSILON;
        for (T t : this.mDataSets) {
            float scatterShapeSize = t.getScatterShapeSize();
            if (scatterShapeSize > f2) {
                f2 = scatterShapeSize;
            }
        }
        return f2;
    }

    public ScatterData(List<IScatterDataSet> list) {
        super(list);
    }

    public ScatterData(IScatterDataSet... iScatterDataSetArr) {
        super(iScatterDataSetArr);
    }
}
