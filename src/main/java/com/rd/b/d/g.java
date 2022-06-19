package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import com.rd.b.b.b;

/* compiled from: ScaleDownAnimation */
public class g extends f {
    public g(b.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.rd.b.d.f
    public PropertyValuesHolder n(boolean z) {
        int i2;
        String str;
        int i3;
        if (z) {
            i2 = this.f8545g;
            i3 = (int) (((float) i2) * this.f8546h);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i3 = this.f8545g;
            i2 = (int) (((float) i3) * this.f8546h);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i3, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
