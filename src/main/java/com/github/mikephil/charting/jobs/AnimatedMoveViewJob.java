package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> pool;

    static {
        ObjectPool<AnimatedMoveViewJob> create = ObjectPool.create(4, new AnimatedMoveViewJob(null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, null, null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view, float f4, float f5, long j2) {
        super(viewPortHandler, f2, f3, transformer, view, f4, f5, j2);
    }

    public static AnimatedMoveViewJob getInstance(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view, float f4, float f5, long j2) {
        AnimatedMoveViewJob animatedMoveViewJob = pool.get();
        animatedMoveViewJob.mViewPortHandler = viewPortHandler;
        animatedMoveViewJob.xValue = f2;
        animatedMoveViewJob.yValue = f3;
        animatedMoveViewJob.mTrans = transformer;
        animatedMoveViewJob.view = view;
        animatedMoveViewJob.xOrigin = f4;
        animatedMoveViewJob.yOrigin = f5;
        animatedMoveViewJob.animator.setDuration(j2);
        return animatedMoveViewJob;
    }

    public static void recycleInstance(AnimatedMoveViewJob animatedMoveViewJob) {
        pool.recycle(animatedMoveViewJob);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable instantiate() {
        return new AnimatedMoveViewJob(null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, null, null, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.pts;
        float f2 = this.xOrigin;
        float f3 = this.phase;
        fArr[0] = f2 + ((this.xValue - f2) * f3);
        float f4 = this.yOrigin;
        fArr[1] = f4 + ((this.yValue - f4) * f3);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
        recycleInstance(this);
    }
}
