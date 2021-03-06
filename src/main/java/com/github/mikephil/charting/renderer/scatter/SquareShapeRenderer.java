package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class SquareShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float scatterShapeSize = iScatterDataSet.getScatterShapeSize();
        float f4 = scatterShapeSize / 2.0f;
        float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius());
        float f5 = (scatterShapeSize - (convertDpToPixel * 2.0f)) / 2.0f;
        float f6 = f5 / 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        if (((double) scatterShapeSize) > Utils.DOUBLE_EPSILON) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f5);
            float f7 = f2 - convertDpToPixel;
            float f8 = f3 - convertDpToPixel;
            float f9 = f2 + convertDpToPixel;
            float f10 = f3 + convertDpToPixel;
            canvas.drawRect(f7 - f6, f8 - f6, f9 + f6, f10 + f6, paint);
            if (scatterShapeHoleColor != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(scatterShapeHoleColor);
                canvas.drawRect(f7, f8, f9, f10, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f2 - f4, f3 - f4, f2 + f4, f3 + f4, paint);
    }
}
