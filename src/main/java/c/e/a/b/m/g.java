package c.e.a.b.m;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f3385a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f3386b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f3387c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f3385a);
        matrix2.getValues(this.f3386b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f3386b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f3385a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f3387c.setValues(this.f3386b);
        return this.f3387c;
    }
}
