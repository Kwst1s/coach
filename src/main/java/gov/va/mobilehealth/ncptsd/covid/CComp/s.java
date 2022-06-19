package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.github.mikephil.charting.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: C_F_VERTICAL */
public class s {

    /* access modifiers changed from: package-private */
    /* compiled from: C_F_VERTICAL */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10142b;

        a(View view) {
            this.f10142b = view;
        }

        public void run() {
            this.f10142b.sendAccessibilityEvent(8);
            this.f10142b.sendAccessibilityEvent(32768);
            this.f10142b.requestFocus();
        }
    }

    /* compiled from: C_F_VERTICAL */
    static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10143b;

        b(View view) {
            this.f10143b = view;
        }

        public void run() {
            this.f10143b.sendAccessibilityEvent(8);
            this.f10143b.sendAccessibilityEvent(32768);
            this.f10143b.requestFocus();
        }
    }

    public static void a(View view) {
        Executors.newSingleThreadScheduledExecutor().schedule(new a(view), 450, TimeUnit.MILLISECONDS);
    }

    public static void b(View view) {
        Executors.newSingleThreadScheduledExecutor().schedule(new b(view), 1150, TimeUnit.MILLISECONDS);
    }

    public static AssetFileDescriptor c(Context context, String str) {
        try {
            return context.getAssets().openFd(str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Calendar d() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 1);
        instance.set(12, 1);
        instance.set(13, 1);
        instance.set(14, 1);
        return instance;
    }

    public static String e(long j2) {
        return new SimpleDateFormat("dd MMMM, yyyy").format(Long.valueOf(j2));
    }

    public static String f(Context context, Uri uri) {
        Throwable th;
        FileNotFoundException e2;
        InputStream inputStream;
        IOException e3;
        ExifInterface exifInterface;
        InputStream inputStream2 = null;
        if (uri.getAuthority() != null) {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (Build.VERSION.SDK_INT >= 24) {
                        exifInterface = new ExifInterface(inputStream);
                    } else {
                        exifInterface = new ExifInterface(uri.getPath());
                    }
                    String uri2 = r(context, o(decodeStream, exifInterface.getAttributeInt("Orientation", 0))).toString();
                    decodeStream.recycle();
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return uri2;
                } catch (FileNotFoundException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    inputStream.close();
                    return null;
                } catch (IOException e6) {
                    e3 = e6;
                    try {
                        e3.printStackTrace();
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        try {
                            inputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e9) {
                e2 = e9;
                inputStream = null;
                e2.printStackTrace();
                inputStream.close();
                return null;
            } catch (IOException e10) {
                e3 = e10;
                inputStream = null;
                e3.printStackTrace();
                inputStream.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream2.close();
                throw th;
            }
        }
        return null;
    }

    public static int g(int i2) {
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 4;
            case 7:
                return 5;
            default:
                return 6;
        }
    }

    public static String h(Context context, long j2, long j3) {
        long j4 = (j2 - j3) % 3600000;
        long j5 = j4 / 60000;
        long j6 = (j4 % 60000) / 1000;
        String format = String.format("%02d", Long.valueOf(j5));
        String format2 = String.format("%02d", Long.valueOf(j6));
        StringBuilder sb = new StringBuilder();
        if (j5 > 0) {
            if (j5 == 1) {
                sb.append(format + " " + context.getString(R.string.minute));
            } else {
                sb.append(format + " " + context.getString(R.string.minutes));
            }
        }
        sb.append(" ");
        if (j6 == 1) {
            sb.append(format2 + " " + context.getString(R.string.second));
        } else {
            sb.append(format2 + " " + context.getString(R.string.seconds));
        }
        sb.append(" ");
        sb.append(context.getString(R.string.remained));
        return sb.toString();
    }

    public static String i(long j2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format("%02d:%02d", Long.valueOf(timeUnit.toMinutes(j2)), Long.valueOf(timeUnit.toSeconds(j2) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j2))));
    }

    public static String j(long j2, long j3) {
        long j4 = j2 - j3;
        StringBuffer stringBuffer = new StringBuffer();
        long j5 = j4 % 3600000;
        stringBuffer.append(String.format("%02d", Long.valueOf(j5 / 60000)));
        stringBuffer.append(":");
        stringBuffer.append(String.format("%02d", Long.valueOf((j5 % 60000) / 1000)));
        return "-" + stringBuffer.toString();
    }

    public static String k(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 % 3600000;
        stringBuffer.append(String.format("%02d", Long.valueOf(j3 / 60000)));
        stringBuffer.append(":");
        stringBuffer.append(String.format("%02d", Long.valueOf((j3 % 60000) / 1000)));
        return stringBuffer.toString();
    }

    public static String l(Context context, long j2) {
        long j3 = j2 % 3600000;
        long j4 = j3 / 60000;
        long j5 = (j3 % 60000) / 1000;
        String format = String.format("%02d", Long.valueOf(j4));
        String format2 = String.format("%02d", Long.valueOf(j5));
        StringBuilder sb = new StringBuilder();
        if (j4 > 0) {
            if (j4 == 1) {
                sb.append(format + " " + context.getString(R.string.minute));
            } else {
                sb.append(format + " " + context.getString(R.string.minutes));
            }
        }
        sb.append(" ");
        if (j5 == 1) {
            sb.append(format2 + " " + context.getString(R.string.second));
        } else {
            sb.append(format2 + " " + context.getString(R.string.seconds));
        }
        return sb.toString();
    }

    public static boolean m(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public static boolean n(long j2) {
        return ((int) (j2 / 1000)) % 10 == 0;
    }

    public static Bitmap o(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void p(Activity activity, String str) {
        activity.setTitle(str + " " + activity.getString(R.string.heading));
    }

    public static void q(Context context, View view, String str, boolean z) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" ");
        sb.append(context.getString(R.string.button_switch));
        sb.append(" ");
        if (z) {
            sb.append(context.getString(R.string.on));
        } else {
            sb.append(context.getString(R.string.off));
        }
        view.setContentDescription(sb);
    }

    public static Uri r(Context context, Bitmap bitmap) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "PTSDImgs");
            if (!file.exists()) {
                file.mkdirs();
                new File(file, ".nomedia").createNewFile();
            }
            File file2 = new File(file, Long.toString(System.currentTimeMillis()) + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return Uri.fromFile(file2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
