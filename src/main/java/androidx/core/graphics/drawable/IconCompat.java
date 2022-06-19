package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.github.mikephil.charting.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f1099k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1100a = -1;

    /* renamed from: b  reason: collision with root package name */
    Object f1101b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1102c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1103d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1104e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1105f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1106g = null;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f1107h = f1099k;

    /* renamed from: i  reason: collision with root package name */
    public String f1108i = null;

    /* renamed from: j  reason: collision with root package name */
    public String f1109j;

    public IconCompat() {
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, Utils.FLOAT_EPSILON, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1104e = i2;
            if (resources != null) {
                try {
                    iconCompat.f1101b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1101b = str;
            }
            iconCompat.f1109j = str;
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    private static int d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static String f(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int h(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    private static Uri j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    private static String p(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int c() {
        int i2 = this.f1100a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.f1101b);
        }
        if (i2 == 2) {
            return this.f1104e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String e() {
        int i2 = this.f1100a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return f((Icon) this.f1101b);
        }
        if (i2 != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        } else if (TextUtils.isEmpty(this.f1109j)) {
            return ((String) this.f1101b).split(":", -1)[0];
        } else {
            return this.f1109j;
        }
    }

    public int g() {
        int i2 = this.f1100a;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : h((Icon) this.f1101b);
    }

    public Uri i() {
        int i2 = this.f1100a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return j((Icon) this.f1101b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f1101b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream k(Context context) {
        Uri i2 = i();
        String scheme = i2.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(i2);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + i2, e2);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f1101b));
            } catch (FileNotFoundException e3) {
                Log.w("IconCompat", "Unable to load image from path: " + i2, e3);
                return null;
            }
        }
    }

    public void l() {
        this.f1107h = PorterDuff.Mode.valueOf(this.f1108i);
        switch (this.f1100a) {
            case -1:
                Parcelable parcelable = this.f1103d;
                if (parcelable != null) {
                    this.f1101b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1103d;
                if (parcelable2 != null) {
                    this.f1101b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1102c;
                this.f1101b = bArr;
                this.f1100a = 3;
                this.f1104e = 0;
                this.f1105f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1102c, Charset.forName("UTF-16"));
                this.f1101b = str;
                if (this.f1100a == 2 && this.f1109j == null) {
                    this.f1109j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1101b = this.f1102c;
                return;
        }
    }

    public void m(boolean z) {
        this.f1108i = this.f1107h.name();
        switch (this.f1100a) {
            case -1:
                if (!z) {
                    this.f1103d = (Parcelable) this.f1101b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1101b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1102c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f1103d = (Parcelable) this.f1101b;
                return;
            case 2:
                this.f1102c = ((String) this.f1101b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1102c = (byte[]) this.f1101b;
                return;
            case 4:
            case 6:
                this.f1102c = this.f1101b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon n() {
        return o(null);
    }

    public Icon o(Context context) {
        Icon icon;
        switch (this.f1100a) {
            case -1:
                return (Icon) this.f1101b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.f1101b);
                break;
            case 2:
                icon = Icon.createWithResource(e(), this.f1104e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f1101b, this.f1104e, this.f1105f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f1101b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(a((Bitmap) this.f1101b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f1101b);
                    break;
                }
            case 6:
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    icon = Icon.createWithAdaptiveBitmapContentUri(i());
                    break;
                } else if (context != null) {
                    InputStream k2 = k(context);
                    if (k2 != null) {
                        if (i2 < 26) {
                            icon = Icon.createWithBitmap(a(BitmapFactory.decodeStream(k2), false));
                            break;
                        } else {
                            icon = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(k2));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + i());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + i());
                }
        }
        ColorStateList colorStateList = this.f1106g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f1107h;
        if (mode != f1099k) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    public String toString() {
        if (this.f1100a == -1) {
            return String.valueOf(this.f1101b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(p(this.f1100a));
        switch (this.f1100a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1101b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1101b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1109j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1104e);
                if (this.f1105f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1105f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1101b);
                break;
        }
        if (this.f1106g != null) {
            sb.append(" tint=");
            sb.append(this.f1106g);
        }
        if (this.f1107h != f1099k) {
            sb.append(" mode=");
            sb.append(this.f1107h);
        }
        sb.append(")");
        return sb.toString();
    }

    private IconCompat(int i2) {
        this.f1100a = i2;
    }
}
