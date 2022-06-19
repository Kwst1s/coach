package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.c0;

/* compiled from: CircleTransform */
public class t implements c0 {
    @Override // com.squareup.picasso.c0
    public Bitmap a(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f2 = ((float) min) / 2.0f;
        canvas.drawCircle(f2, f2, f2, paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    @Override // com.squareup.picasso.c0
    public String b() {
        return "circle";
    }
}
