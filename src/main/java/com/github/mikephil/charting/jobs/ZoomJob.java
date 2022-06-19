package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> pool;
    protected YAxis.AxisDependency axisDependency;
    protected Matrix mRunMatrixBuffer = new Matrix();
    protected float scaleX;
    protected float scaleY;

    static {
        ObjectPool<ZoomJob> create = ObjectPool.create(1, new ZoomJob(null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, null, null, null));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public ZoomJob(ViewPortHandler viewPortHandler, float f2, float f3, float f4, float f5, Transformer transformer, YAxis.AxisDependency axisDependency2, View view) {
        super(viewPortHandler, f4, f5, transformer, view);
        this.scaleX = f2;
        this.scaleY = f3;
        this.axisDependency = axisDependency2;
    }

    public static ZoomJob getInstance(ViewPortHandler viewPortHandler, float f2, float f3, float f4, float f5, Transformer transformer, YAxis.AxisDependency axisDependency2, View view) {
        ZoomJob zoomJob = pool.get();
        zoomJob.xValue = f4;
        zoomJob.yValue = f5;
        zoomJob.scaleX = f2;
        zoomJob.scaleY = f3;
        zoomJob.mViewPortHandler = viewPortHandler;
        zoomJob.mTrans = transformer;
        zoomJob.axisDependency = axisDependency2;
        zoomJob.view = view;
        return zoomJob;
    }

    public static void recycleInstance(ZoomJob zoomJob) {
        pool.recycle(zoomJob);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable instantiate() {
        return new ZoomJob(null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, null, null, null);
    }

    public void run() {
        Matrix matrix = this.mRunMatrixBuffer;
        this.mViewPortHandler.zoom(this.scaleX, this.scaleY, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        float scaleY2 = ((BarLineChartBase) this.view).getAxis(this.axisDependency).mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX2 = ((BarLineChartBase) this.view).getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        fArr[0] = this.xValue - (scaleX2 / 2.0f);
        fArr[1] = this.yValue + (scaleY2 / 2.0f);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.translate(this.pts, matrix);
        this.mViewPortHandler.refresh(matrix, this.view, false);
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
        recycleInstance(this);
    }
}
