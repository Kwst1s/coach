package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.b;
import b.c.b.b;
import com.github.mikephil.charting.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: C_F */
public class j {

    /* compiled from: C_F */
    static class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: C_F */
    static class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10113b;

        b(Activity activity) {
            this.f10113b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f10113b.finish();
        }
    }

    /* compiled from: C_F */
    static class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public static void A(Context context) {
        e.a.a.a.a.a(context.getString(R.string.app_name));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean B(android.content.Context r0, java.lang.String r1) {
        /*
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.AssetManager r0 = r0.getAssets()
            java.io.InputStream r0 = r0.open(r1)     // Catch:{ IOException -> 0x001a, all -> 0x0018 }
            r1 = 1
            if (r0 == 0) goto L_0x001b
            r0.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x001b
        L_0x0013:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            throw r0
        L_0x001a:
            r1 = 0
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gov.va.mobilehealth.ncptsd.covid.CComp.j.B(android.content.Context, java.lang.String):boolean");
    }

    public static boolean C(Context context) {
        return s(context).getBoolean("firsttime", true);
    }

    public static boolean D(Context context) {
        return context.getResources().getConfiguration().fontScale > 1.0f;
    }

    public static boolean E(Context context) {
        return context.getResources().getBoolean(R.bool.isHdpiTablet);
    }

    public static boolean F(JSONObject jSONObject, String str) {
        return jSONObject.has(str) && !jSONObject.isNull(str);
    }

    public static boolean G(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((double) (((float) displayMetrics.heightPixels) / ((float) displayMetrics.widthPixels))) > 1.8d;
    }

    public static boolean H(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean I(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 1;
    }

    public static boolean J(Context context) {
        return context.getResources().getBoolean(R.bool.isXHdpi);
    }

    public static boolean K(Context context) {
        return s(context).getBoolean("neverToReview", false);
    }

    public static void L(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    public static void M(Activity activity, String str) {
        b.a aVar = new b.a();
        aVar.f(b.h.d.a.b(activity, R.color.colorPrimary));
        aVar.a();
        aVar.e(true);
        aVar.b().a(activity, Uri.parse(str));
    }

    public static String N(Context context, String str) {
        InputStream inputStream;
        try {
            StringBuilder sb = new StringBuilder();
            if (b0.a(context).equals("es")) {
                String str2 = g.f10081a + File.separator + str;
                if (B(context, str2)) {
                    inputStream = context.getAssets().open(str2);
                } else {
                    inputStream = context.getAssets().open(str);
                }
            } else {
                inputStream = context.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String O(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void P(Activity activity, String[] strArr, int i2) {
        androidx.core.app.a.l(activity, strArr, i2);
    }

    public static boolean Q(Calendar calendar, Calendar calendar2) {
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    public static void R(Context context) {
        SharedPreferences.Editor edit = s(context).edit();
        edit.putBoolean("askedForReview", true);
        edit.commit();
    }

    public static void S(Context context) {
        SharedPreferences.Editor u = u(context);
        u.putBoolean("firsttime", false);
        u.commit();
    }

    public static void T(Context context) {
        SharedPreferences.Editor edit = s(context).edit();
        edit.putBoolean("neverToReview", true);
        edit.commit();
    }

    public static void U(Context context, View view, String str) {
        view.setContentDescription(str + " " + context.getString(R.string.button));
    }

    public static void V(Activity activity, CharSequence charSequence) {
        b.a aVar = new b.a(activity);
        aVar.g(charSequence);
        aVar.d(false);
        aVar.k(R.string.ok, new a());
        aVar.a().show();
    }

    public static void W(Activity activity, String str) {
        b.a aVar = new b.a(activity);
        aVar.g(str);
        aVar.d(false);
        aVar.k(R.string.ok, new b(activity));
        aVar.a().show();
    }

    public static void X(Activity activity, String str, String str2) {
        b.a aVar = new b.a(activity);
        aVar.n(str);
        aVar.g(str2);
        aVar.d(false);
        aVar.k(R.string.do_continue, new c());
        aVar.a().show();
    }

    public static void a(Context context, int i2) {
        SharedPreferences.Editor edit = s(context).edit();
        edit.putInt("n_access", i2 + 1);
        edit.commit();
    }

    public static boolean b(Context context) {
        return s(context).getBoolean("askedForReview", false);
    }

    public static String c(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void d(Activity activity, View view) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static float e(float f2, Context context) {
        return f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static String f(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        return simpleDateFormat.format(instance.getTime());
    }

    public static Spanned g(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public static b.a h(Activity activity, String str) {
        b.a aVar = new b.a(activity);
        aVar.g(str);
        aVar.d(false);
        return aVar;
    }

    public static String i(long j2) {
        return new SimpleDateFormat("hh:mm aa").format(Long.valueOf(j2));
    }

    public static int j(Context context) {
        return s(context).getInt("n_access", 0);
    }

    public static int k(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String l() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static int m(Activity activity, String str) {
        try {
            int identifier = activity.getResources().getIdentifier(str, "drawable", activity.getPackageName());
            return identifier <= 0 ? R.drawable.img_feelings : identifier;
        } catch (Exception unused) {
            return R.drawable.img_feelings;
        }
    }

    public static int n(Activity activity, String str) {
        try {
            return activity.getResources().getIdentifier(str, "drawable", activity.getPackageName());
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int o(Activity activity, String str) {
        try {
            return activity.getResources().getIdentifier(str, "raw", activity.getPackageName());
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int p(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int q(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHeight();
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int r(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getWidth();
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static SharedPreferences s(Context context) {
        if (context != null) {
            return context.getSharedPreferences("preferences", 0);
        }
        return null;
    }

    public static boolean t(Context context, String str, boolean z) {
        return context != null ? context.getSharedPreferences("preferences", 0).getBoolean(str, z) : z;
    }

    public static SharedPreferences.Editor u(Context context) {
        if (context != null) {
            return context.getSharedPreferences("preferences", 0).edit();
        }
        return null;
    }

    public static int v(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String w(Context context, String str) {
        return context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }

    public static String x() {
        return Resources.getSystem().getConfiguration().locale.getLanguage();
    }

    public static int y(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static Uri z(Context context, File file) {
        return b.h.d.b.e(context, context.getPackageName() + ".provider", file);
    }
}
