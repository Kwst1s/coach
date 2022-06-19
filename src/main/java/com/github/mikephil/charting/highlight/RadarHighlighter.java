package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    public Highlight getClosestHighlight(int i2, float f2, float f3) {
        List<Highlight> highlightsAtIndex = getHighlightsAtIndex(i2);
        float distanceToCenter = ((RadarChart) this.mChart).distanceToCenter(f2, f3) / ((RadarChart) this.mChart).getFactor();
        Highlight highlight = null;
        float f4 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < highlightsAtIndex.size(); i3++) {
            Highlight highlight2 = highlightsAtIndex.get(i3);
            float abs = Math.abs(highlight2.getY() - distanceToCenter);
            if (abs < f4) {
                highlight = highlight2;
                f4 = abs;
            }
        }
        return highlight;
    }

    /* access modifiers changed from: protected */
    public List<Highlight> getHighlightsAtIndex(int i2) {
        int i3 = i2;
        this.mHighlightBuffer.clear();
        float phaseX = ((RadarChart) this.mChart).getAnimator().getPhaseX();
        float phaseY = ((RadarChart) this.mChart).getAnimator().getPhaseY();
        float sliceAngle = ((RadarChart) this.mChart).getSliceAngle();
        float factor = ((RadarChart) this.mChart).getFactor();
        MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        int i4 = 0;
        while (i4 < ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetCount()) {
            IDataSet dataSetByIndex = ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetByIndex(i4);
            Entry entryForIndex = dataSetByIndex.getEntryForIndex(i3);
            float f2 = (float) i3;
            Utils.getPosition(((RadarChart) this.mChart).getCenterOffsets(), (entryForIndex.getY() - ((RadarChart) this.mChart).getYChartMin()) * factor * phaseY, (sliceAngle * f2 * phaseX) + ((RadarChart) this.mChart).getRotationAngle(), instance);
            this.mHighlightBuffer.add(new Highlight(f2, entryForIndex.getY(), instance.x, instance.y, i4, dataSetByIndex.getAxisDependency()));
            i4++;
            i3 = i2;
        }
        return this.mHighlightBuffer;
    }
}
