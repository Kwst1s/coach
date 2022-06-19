package b.r;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: PropertyValuesHolderUtils */
class i {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
        return PropertyValuesHolder.ofFloat(new h(property, path), Utils.FLOAT_EPSILON, 1.0f);
    }
}
