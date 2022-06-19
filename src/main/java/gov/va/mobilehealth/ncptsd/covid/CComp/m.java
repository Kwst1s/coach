package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import b.a.j;
import b.c.b.b;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.u;
import f.a.a.a.b.l.c0;
import f.a.a.a.b.l.d0;
import f.a.a.a.b.l.e0;
import f.a.a.a.b.l.f0;
import f.a.a.a.b.l.g0;
import f.a.a.a.b.l.n;
import f.a.a.a.b.l.o;
import f.a.a.a.b.l.p;
import f.a.a.a.b.l.q;
import f.a.a.a.b.l.r;
import f.a.a.a.b.l.s;
import f.a.a.a.b.l.t;
import f.a.a.a.b.l.v;
import f.a.a.a.b.l.w;
import f.a.a.a.b.l.x;
import f.a.a.a.b.l.y;
import f.a.a.a.b.l.z;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_webview;
import gov.va.mobilehealth.ncptsd.covid.CComp.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.FABTracking;

/* compiled from: C_F_PTSD */
public class m {

    /* compiled from: C_F_PTSD */
    static class a implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10129b;

        a(View view) {
            this.f10129b = view;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f10129b.setVisibility(0);
        }
    }

    /* compiled from: C_F_PTSD */
    static class b implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10130b;

        b(View view) {
            this.f10130b = view;
        }

        public void onAnimationEnd(Animation animation) {
            this.f10130b.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: C_F_PTSD */
    public static class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: C_F_PTSD */
    static class d implements MediaPlayer.OnCompletionListener {
        d() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    /* compiled from: C_F_PTSD */
    static class e implements MediaPlayer.OnPreparedListener {
        e() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }
    }

    /* compiled from: C_F_PTSD */
    static class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10131b;

        f(View view) {
            this.f10131b = view;
        }

        public void run() {
            this.f10131b.sendAccessibilityEvent(8);
            this.f10131b.sendAccessibilityEvent(32768);
            this.f10131b.requestFocus();
        }
    }

    /* compiled from: C_F_PTSD */
    static class g implements MediaPlayer.OnCompletionListener {
        g() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    /* compiled from: C_F_PTSD */
    static class h implements MediaPlayer.OnPreparedListener {
        h() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }
    }

    public static int A(Context context) {
        return j.s(context).getInt("anim_slideshow", 1);
    }

    public static void A0(Activity activity, String str) {
        activity.setTitle(str + " " + activity.getString(R.string.heading));
    }

    public static int B(Context context) {
        return j.s(context).getInt("anim_slideshow_time", 15);
    }

    public static boolean B0(Context context, int i2, FABTracking fABTracking, boolean z) {
        if (m0(context, i2, "thumbdown")) {
            if (fABTracking == null) {
                return true;
            }
            fABTracking.setTrackingId("30604");
            fABTracking.setImageResource(R.drawable.thumbs_down_on);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(context, R.color.colorPrimary)));
            fABTracking.setContentDescription(context.getString(R.string.thumb_down_selected));
            if (!z) {
                return true;
            }
            fABTracking.sendAccessibilityEvent(4);
            return true;
        } else if (fABTracking == null) {
            return false;
        } else {
            fABTracking.setTrackingId("30603");
            fABTracking.setImageResource(R.drawable.thumbs_down_off);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
            fABTracking.setContentDescription(context.getString(R.string.thumb_down));
            if (!z) {
                return false;
            }
            fABTracking.sendAccessibilityEvent(4);
            return false;
        }
    }

    public static int C(int i2) {
        return i2 - g.W;
    }

    public static boolean C0(Context context, int i2, FABTracking fABTracking, boolean z) {
        if (m0(context, i2, "thumbup")) {
            if (fABTracking == null) {
                return true;
            }
            fABTracking.setTrackingId("30602");
            fABTracking.setImageResource(R.drawable.thumbs_up_on);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(context, R.color.colorPrimary)));
            fABTracking.setContentDescription(context.getString(R.string.thumb_up_tool_selected));
            if (!z) {
                return true;
            }
            fABTracking.sendAccessibilityEvent(4);
            return true;
        } else if (fABTracking == null) {
            return false;
        } else {
            fABTracking.setTrackingId("30601");
            fABTracking.setImageResource(R.drawable.thumbs_up_off);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
            fABTracking.setContentDescription(context.getString(R.string.thumb_up_tool));
            if (!z) {
                return false;
            }
            fABTracking.sendAccessibilityEvent(4);
            return false;
        }
    }

    public static String D(Activity activity, int i2) {
        Configuration configuration = activity.getResources().getConfiguration();
        configuration.locale = new Locale("en");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new Resources(activity.getAssets(), displayMetrics, configuration).getString(i2);
    }

    public static boolean D0(Context context, FABTracking fABTracking, boolean z, boolean z2) {
        if (z) {
            if (fABTracking == null) {
                return true;
            }
            fABTracking.setImageResource(R.drawable.thumbs_up_on);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(context, R.color.colorPrimary)));
            fABTracking.setContentDescription(context.getString(R.string.thumb_up_selected));
            fABTracking.setTrackingId("30602");
            if (!z2) {
                return true;
            }
            fABTracking.sendAccessibilityEvent(4);
            return true;
        } else if (fABTracking == null) {
            return false;
        } else {
            fABTracking.setImageResource(R.drawable.thumbs_up_off);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
            fABTracking.setContentDescription(context.getString(R.string.thumb_up));
            fABTracking.setTrackingId("30601");
            if (!z2) {
                return false;
            }
            fABTracking.sendAccessibilityEvent(4);
            return false;
        }
    }

    public static String E(int i2) {
        if (i2 == 36) {
            return "find_apps.json";
        }
        if (i2 == 37) {
            return "ptsd_facts.json";
        }
        if (i2 == 39) {
            return "kids.json";
        }
        if (i2 == 41) {
            return "understanding_treatment.json";
        }
        if (i2 == 52) {
            return "daily_rituals.json";
        }
        if (i2 != 56) {
            return null;
        }
        return "find_meaning.json";
    }

    public static void E0(Context context, View view, String str) {
        view.setContentDescription(str + " " + context.getString(R.string.button));
    }

    public static boolean F(Application application) {
        return ((App) application).c();
    }

    public static void F0(Context context, View view, String str, int i2) {
        view.setContentDescription(str + " " + context.getString(R.string.on_position) + " " + i2 + " " + context.getString(R.string.button) + "\n" + context.getString(R.string.press_and_hold_reorder));
    }

    public static boolean G(Application application) {
        return ((App) application).d();
    }

    public static void G0(Context context, boolean z) {
        j.u(context).putBoolean("crisis_resources_thumb_up", z).apply();
    }

    public static int H(Activity activity) {
        return (int) (((float) j.r(activity)) * 0.6f);
    }

    public static void H0(Context context, int i2) {
        j.u(context).putInt("anim_slideshow", i2).commit();
    }

    public static String I(Context context, Uri uri) {
        Throwable th;
        FileNotFoundException e2;
        InputStream inputStream;
        IOException e3;
        b.k.a.a aVar;
        InputStream inputStream2 = null;
        if (uri.getAuthority() != null) {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (Build.VERSION.SDK_INT >= 24) {
                        aVar = new b.k.a.a(inputStream);
                    } else {
                        aVar = new b.k.a.a(uri.getPath());
                    }
                    String uri2 = e1(context, y0(decodeStream, aVar.e("Orientation", 0))).toString();
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

    public static void I0(Context context, int i2) {
        j.u(context).putInt("anim_slideshow_time", i2).commit();
    }

    public static int J(Context context, int i2) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.y));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (jSONArray.getJSONObject(i3).getInt("id") == 30) {
                    String string = jSONArray.getJSONObject(i3).getString("filename");
                    return i2 == -1 ? new Random().nextInt(new JSONArray(j.N(context, g.f10089i + File.separator + string)).length()) : i2;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public static void J0(Context context, boolean z) {
        j.u(context).putBoolean("distress_meter_enabled", z).apply();
    }

    public static String K(ArrayList<Integer> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        return jSONArray.toString();
    }

    public static void K0(Context context, boolean z) {
        j.u(context).putBoolean("distress_meter_popup_shown", z).apply();
    }

    public static vainstrum.Components.b L(int i2, String str) {
        switch (i2) {
            case 36:
                return f.a.a.a.b.m.a.X1(Math.abs(i2), str);
            case 37:
                return f.a.a.a.b.m.a.X1(Math.abs(i2), str);
            case 38:
            case 40:
            default:
                return null;
            case 39:
                return f.a.a.a.b.m.a.X1(Math.abs(i2), str);
            case 41:
                return f.a.a.a.b.m.a.X1(Math.abs(i2), str);
            case 42:
                return new f.a.a.a.b.m.c();
            case 43:
                return new f.a.a.a.b.m.b();
        }
    }

    public static void L0(Context context, boolean z) {
        j.u(context).putBoolean("quotes_enabled", z).apply();
    }

    public static b0 M(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.z));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b0 e2 = p.e(jSONArray.getJSONObject(i2));
                if (e2.d() == 105) {
                    return e2;
                }
            }
            return null;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void M0(Application application, boolean z) {
        ((App) application).f(z);
    }

    public static String N(Uri uri) {
        File file = new File(uri.getPath());
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        return name.substring(0, name.indexOf("."));
    }

    public static void N0(Application application, boolean z) {
        ((App) application).g(z);
    }

    public static b0 O(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.z));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b0 e2 = p.e(jSONArray.getJSONObject(i2));
                if (e2.d() == 101) {
                    return e2;
                }
            }
            return null;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void O0(Context context, VerticalSeekBar verticalSeekBar) {
        Drawable d2 = b.h.d.a.d(context, R.drawable.bg_thermometer_white);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{b.h.d.a.b(context, R.color.therm_c1), b.h.d.a.b(context, R.color.therm_c2), b.h.d.a.b(context, R.color.therm_c3), b.h.d.a.b(context, R.color.therm_c4), b.h.d.a.b(context, R.color.therm_c5), b.h.d.a.b(context, R.color.therm_c6), b.h.d.a.b(context, R.color.therm_c7), b.h.d.a.b(context, R.color.therm_c8), b.h.d.a.b(context, R.color.therm_c9), b.h.d.a.b(context, R.color.therm_c10), b.h.d.a.b(context, R.color.therm_c10)});
        gradientDrawable.setCornerRadius(j.e(10.0f, context));
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
        LayerDrawable layerDrawable = (LayerDrawable) verticalSeekBar.getProgressDrawable();
        layerDrawable.setDrawableByLayerId(16908288, d2);
        layerDrawable.setDrawableByLayerId(16908301, clipDrawable);
        verticalSeekBar.setProgressDrawable(layerDrawable);
    }

    public static u P(Activity activity, String str, int i2) {
        try {
            ArrayList<u> a2 = p.a(new JSONArray(j.N(activity, g.f10082b + File.separator + str)));
            for (int i3 = 0; i3 < a2.size(); i3++) {
                if (a2.get(i3).d() == i2) {
                    return a2.get(i3);
                }
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void P0(Context context, LinearLayout linearLayout, String str, int i2, int i3, boolean z) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            linearLayout.removeAllViews();
            int dimensionPixelSize = i3 != -1 ? context.getResources().getDimensionPixelSize(i3) : 0;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(i2);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                appCompatTextView.setLayoutParams(layoutParams);
                if (i4 == 0) {
                    appCompatTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0);
                } else if (i4 + 1 == jSONArray.length()) {
                    appCompatTextView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                } else {
                    appCompatTextView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                }
                appCompatTextView.setTextSize(0, (float) dimensionPixelSize2);
                appCompatTextView.setTextColor(b.h.d.a.b(context, 17170444));
                appCompatTextView.setText(Html.fromHtml(jSONArray.getString(i4)));
                appCompatTextView.setTypeface(b.h.d.e.f.b(context, R.font.font_regular));
                appCompatTextView.setLineSpacing(TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics()), 1.0f);
                if (i4 != jSONArray.length() - 1) {
                    appCompatTextView.setContentDescription(Html.fromHtml(jSONArray.getString(i4)));
                } else if (z) {
                    appCompatTextView.setContentDescription(((Object) Html.fromHtml(jSONArray.getString(i4))) + "\n" + context.getString(R.string.select_and_continue));
                } else {
                    appCompatTextView.setContentDescription(Html.fromHtml(jSONArray.getString(i4)));
                }
                linearLayout.addView(appCompatTextView);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String Q(Context context, int i2, boolean z, f.a.a.a.b.d.b bVar) {
        String str;
        String str2;
        u uVar = new u(context);
        if (!z && bVar == null) {
            bVar = uVar.A0(j.I0);
        }
        if (bVar == null) {
            str = g.h0;
        } else {
            int c2 = bVar.c();
            if (i2 == c2) {
                str = g.j0;
            } else if (i2 < c2) {
                str = g.i0;
            } else {
                str = g.k0;
            }
        }
        if (i2 == 0) {
            str2 = g.d0;
        } else if (i2 >= 1 && i2 <= 15) {
            str2 = g.e0;
        } else if (i2 < 16 || i2 > 32) {
            str2 = g.g0;
        } else {
            str2 = g.f0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(g.f10083c);
        sb.append(File.separator);
        sb.append(g.c0 + str2 + str);
        return j.N(context, sb.toString());
    }

    public static void Q0(Context context, LinearLayout linearLayout, String str, int i2, int i3) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            linearLayout.removeAllViews();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(i3);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, dimensionPixelOffset);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                TextView textView = new TextView(context);
                textView.setLayoutParams(layoutParams);
                if (i4 == 0) {
                    textView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0);
                } else if (i4 + 1 == jSONArray.length()) {
                    textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, dimensionPixelOffset);
                } else {
                    textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                }
                textView.setTextSize(0, (float) dimensionPixelSize);
                textView.setTextColor(b.h.d.a.b(context, 17170444));
                textView.setText(j.g(jSONArray.getString(i4)));
                textView.setTypeface(b.h.d.e.f.b(context, R.font.font_regular));
                linearLayout.addView(textView);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String R(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                sb.append((CharSequence) Html.fromHtml(jSONArray.getString(i2)));
                i2++;
                if (i2 != jSONArray.length()) {
                    sb.append("\n");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static void R0(Activity activity, View view) {
        if (view != null) {
            if (!(view instanceof AppCompatEditText)) {
                view.setOnTouchListener(new a(activity));
            }
            if (view instanceof ViewGroup) {
                int i2 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 < viewGroup.getChildCount()) {
                        R0(activity, viewGroup.getChildAt(i2));
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<Integer> S(Context context) {
        String string = j.s(context).getString("thumbup", null);
        if (string == null) {
            return new ArrayList<>();
        }
        return m(string);
    }

    public static void S0(Context context, View view, boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_in_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.slide_out_down);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        loadAnimation.setAnimationListener(new a(view));
        loadAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation2.setAnimationListener(new b(view));
        if (z) {
            view.startAnimation(loadAnimation);
        } else {
            view.startAnimation(loadAnimation2);
        }
    }

    public static String T(Context context, long j2) {
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
        sb.append(" ");
        sb.append(context.getString(R.string.remained));
        return sb.toString();
    }

    public static void T0(Activity activity) {
        b.a h2 = j.h(activity, activity.getString(R.string.no_tool));
        h2.k(R.string.ok, new c());
        h2.a().show();
    }

    public static String U(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 % 3600000;
        stringBuffer.append(String.format("%02d", Long.valueOf(j3 / 60000)));
        stringBuffer.append(":");
        stringBuffer.append(String.format("%02d", Long.valueOf((j3 % 60000) / 1000)));
        return stringBuffer.toString();
    }

    public static boolean U0(Context context) {
        return j.s(context).getBoolean("distress_meter_popup_shown", false);
    }

    public static String V(Context context, long j2) {
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

    public static void V0(Activity activity) {
        if (activity != null) {
            try {
                AssetFileDescriptor v = v(activity, g.D);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.setOnCompletionListener(new d());
                mediaPlayer.setOnPreparedListener(new e());
                mediaPlayer.reset();
                mediaPlayer.setDataSource(v.getFileDescriptor(), v.getStartOffset(), v.getLength());
                mediaPlayer.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String W(Context context, String str) {
        if (str.contains("ThreeBells")) {
            return context.getString(R.string.three_bells);
        }
        if (str.contains("Chimes1")) {
            return context.getString(R.string.chimes_1);
        }
        if (str.contains("Chimes2")) {
            return context.getString(R.string.chimes_2);
        }
        if (str.contains("Chimes3")) {
            return context.getString(R.string.chimes_3);
        }
        if (str.contains("LongBell")) {
            return context.getString(R.string.long_bell);
        }
        if (str.contains("LongBowl")) {
            return context.getString(R.string.long_bowl);
        }
        if (str.contains("ShortBell")) {
            return context.getString(R.string.short_bell);
        }
        if (str.contains("SingingBowl")) {
            return context.getString(R.string.singing_bowl);
        }
        if (str.contains(g.v0)) {
            return context.getString(R.string.no_tone);
        }
        return context.getString(R.string.uplifting);
    }

    public static void W0(Activity activity, String str) {
        if (activity != null) {
            try {
                if (!str.equals(g.v0)) {
                    AssetFileDescriptor c2 = s.c(activity, g.n + File.separator + str);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(3);
                    mediaPlayer.setOnCompletionListener(new g());
                    mediaPlayer.setOnPreparedListener(new h());
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(c2.getFileDescriptor(), c2.getStartOffset(), c2.getLength());
                    mediaPlayer.prepareAsync();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static b0 X(Context context, a0 a0Var) {
        ArrayList<b0> r0 = r0(context);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < r0.size(); i2++) {
            b0 b0Var = r0.get(i2);
            if (b0Var.f().contains(Integer.valueOf(a0Var.a())) && !m0(context, b0Var.d(), "thumbdown")) {
                arrayList.add(b0Var);
                if (m0(context, b0Var.d(), "thumbup")) {
                    arrayList.add(b0Var);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (b0) arrayList.get(new Random().nextInt(arrayList.size()));
    }

    public static void X0(boolean z, Act_manage act_manage, a0 a0Var, b0 b0Var, b0 b0Var2, int i2) {
        vainstrum.Components.b bVar;
        switch (b0Var.d()) {
            case 2:
                bVar = p.i2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 3:
                bVar = r.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 4:
                bVar = s.d2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 5:
                bVar = f.a.a.a.b.l.l0.c.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 6:
                bVar = f.a.a.a.b.l.u.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 7:
                bVar = v.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 8:
                bVar = y.b2(b0Var2, b0Var, a0Var, i2, g.T, b0Var.g());
                break;
            case 9:
                bVar = y.b2(b0Var2, b0Var, a0Var, i2, g.V, b0Var.g());
                break;
            case 10:
                bVar = y.b2(b0Var2, b0Var, a0Var, i2, g.U, b0Var.g());
                break;
            case 11:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 12:
            case 13:
            case 14:
            case 16:
            case 27:
            case 53:
            default:
                if (b0Var2.d() <= g.W) {
                    bVar = null;
                    break;
                } else {
                    bVar = n.w2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                    break;
                }
            case 15:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 17:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 18:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 19:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 20:
                bVar = f.a.a.a.b.l.l0.c.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 21:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 22:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 23:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 24:
                bVar = d0.e2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 25:
                bVar = e0.h2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 26:
                bVar = f.a.a.a.b.l.n0.g.W1(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 28:
                bVar = c0.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 29:
                bVar = f.a.a.a.b.l.k0.a.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 30:
                bVar = x.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 31:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 32:
                bVar = f.a.a.a.b.l.j0.b.W1(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 33:
                bVar = g0.h2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 34:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 35:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 36:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 37:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 38:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 39:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 40:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 41:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 42:
                bVar = f0.m2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 43:
                bVar = t.f2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 44:
                bVar = w.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 45:
                bVar = f.a.a.a.b.l.a0.d2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 46:
                bVar = z.d2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 47:
                bVar = f.a.a.a.b.l.h0.a.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 48:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 49:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 50:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 51:
                bVar = f.a.a.a.b.l.i0.c.i2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 52:
                bVar = o.c2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 54:
                bVar = f.a.a.a.b.l.b0.s0.a(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 55:
                bVar = q.s0.a(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 56:
                bVar = f.a.a.a.b.l.l0.e.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 57:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 58:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 59:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 60:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 61:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 62:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 63:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 64:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
            case 65:
                bVar = f.a.a.a.b.l.l0.b.b2(b0Var2, b0Var, a0Var, i2, b0Var.g());
                break;
        }
        if (bVar != null) {
            bVar.V1(act_manage.getTitle().toString());
            if (z) {
                act_manage.W(bVar, b0Var.a());
            } else {
                act_manage.b0(bVar, b0Var.a());
            }
        }
    }

    public static b0 Y(Context context, int i2) {
        ArrayList<b0> r0 = r0(context);
        for (int i3 = 0; i3 < r0.size(); i3++) {
            b0 b0Var = r0.get(i3);
            if (b0Var.d() == i2) {
                return b0Var;
            }
        }
        return null;
    }

    public static void Y0(Activity activity, String str, String str2) {
        try {
            b.a aVar = new b.a();
            aVar.f(b.h.d.a.b(activity, R.color.colorPrimary));
            aVar.a();
            aVar.e(true);
            aVar.b().a(activity, Uri.parse(str));
        } catch (ActivityNotFoundException unused) {
            Intent intent = new Intent(activity, Act_webview.class);
            intent.putExtra("title", str2);
            intent.putExtra("url", str);
            activity.startActivity(intent);
        }
    }

    public static int Z(Activity activity) {
        int i2 = j.s(activity).getInt("track_img_id", -1);
        return j.m(activity, "track_icon_" + i2);
    }

    public static void Z0(Context context, String str, int i2, int i3) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (i2 == -1 || i3 == -1) {
                    jSONObject.put("score_before", JSONObject.NULL);
                    jSONObject.put("score_after", JSONObject.NULL);
                } else {
                    jSONObject.put("score_before", i2);
                    jSONObject.put("score_after", i3);
                }
                k.b.d.l(context, str, "suds", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, int i2, String str) {
        ArrayList<Integer> arrayList;
        String string = j.s(context).getString(str, null);
        if (string == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = m(string);
        }
        if (!arrayList.contains(Integer.valueOf(i2))) {
            arrayList.add(Integer.valueOf(i2));
        }
        j.u(context).putString(str, n0(arrayList)).commit();
    }

    public static String a0(Context context, int i2) {
        if (i2 == 1) {
            return context.getString(R.string.slide);
        }
        if (i2 != 2) {
            return i2 != 3 ? BuildConfig.FLAVOR : context.getString(R.string.fade_to_white);
        }
        return context.getString(R.string.crossfade);
    }

    public static void a1(Context context, int i2) {
        try {
            String num = Integer.toString(i2);
            JSONObject jSONObject = new JSONObject(j.N(context, "data_tracking_constants.json")).getJSONObject("sympoms");
            if (j.F(jSONObject, num)) {
                k.b.d.l(context, jSONObject.getString(num), "symptom", null);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean b(Context context) {
        return j.t(context, "notificationson", false);
    }

    public static String b0() {
        return "Version: " + "1.6" + " (" + 70 + ")";
    }

    public static void b1(Context context) {
        int i2 = j.s(context).getInt("track_img_id", -1) + 1;
        if (i2 >= 35) {
            j.u(context).putInt("track_img_id", 0).apply();
        } else {
            j.u(context).putInt("track_img_id", i2).apply();
        }
    }

    public static boolean c(Context context) {
        return j.t(context, "quotes_enabled", true);
    }

    public static void c0(boolean z, Act_manage act_manage, a0 a0Var, b0 b0Var, int i2) {
        if (a0Var != null) {
            b0 X = X(act_manage, a0Var);
            if (X == null) {
                T0(act_manage);
                return;
            }
            act_manage.c0(X.g());
            X0(z, act_manage, a0Var, X, b0Var, i2);
            return;
        }
        if (!(b0Var == null || act_manage == null)) {
            act_manage.c0(b0Var.g());
        }
        X0(z, act_manage, a0Var, b0Var, b0Var, i2);
    }

    public static boolean c1(Context context, String str) {
        Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"_data"}, null, null, null);
        if (query == null) {
            return d1(str);
        }
        if (!query.moveToFirst()) {
            return d1(str);
        }
        if (query.getColumnCount() <= 0) {
            return d1(str);
        }
        String string = query.getString(0);
        query.close();
        if (new File(string).exists()) {
            return true;
        }
        return d1(str);
    }

    public static void d(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<b0> p0 = p0(context);
        if (p0 != null) {
            for (int i2 = 0; i2 < p0.size(); i2++) {
                b0 b0Var = p0.get(i2);
                if (b0Var.d() >= 100) {
                    int i3 = 0;
                    int i4 = 0;
                    for (int i5 = 0; i5 < b0Var.e().size(); i5++) {
                        int intValue = b0Var.e().get(i5).intValue();
                        if (m0(context, intValue, "thumbup")) {
                            i3++;
                        } else if (m0(context, intValue, "thumbdown")) {
                            i4++;
                        }
                    }
                    if (i3 > 0 && i4 == 0) {
                        arrayList.add(Integer.valueOf(b0Var.d()));
                    }
                } else if (m0(context, b0Var.d(), "thumbup")) {
                    arrayList.add(Integer.valueOf(b0Var.d()));
                } else if (m0(context, b0Var.d(), "thumbdown")) {
                    arrayList2.add(Integer.valueOf(b0Var.d()));
                }
            }
        }
        j.u(context).putString("thumbup", n0(arrayList)).apply();
        j.u(context).putString("thumbdown", n0(arrayList2)).apply();
    }

    public static boolean d0(Context context, int i2) {
        ArrayList<f.a.a.a.b.d.b> n0 = new u(context).n0(i2);
        if (n0 != null) {
            return !n0.isEmpty();
        }
        return false;
    }

    public static boolean d1(String str) {
        Uri parse = Uri.parse(str);
        if (!parse.toString().contains("default_si")) {
            return new File(parse.getPath()).exists();
        }
        return true;
    }

    public static boolean e(Context context) {
        boolean z;
        String string = j.s(context).getString("thumbup", null);
        if (string != null) {
            ArrayList<Integer> m = m(string);
            ArrayList<b0> r0 = r0(context);
            for (int i2 = 0; i2 < m.size(); i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= r0.size()) {
                        z = false;
                        break;
                    } else if (r0.get(i3).d() == m.get(i2).intValue()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e0(Context context) {
        ArrayList<f.a.a.a.b.d.b> v0 = new u(context).v0();
        if (v0 != null) {
            return !v0.isEmpty();
        }
        return false;
    }

    public static Uri e1(Context context, Bitmap bitmap) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MindfulnessImgs");
            if (!file.exists()) {
                file.mkdirs();
                new File(file, ".nomedia").createNewFile();
            }
            File file2 = new File(file, System.currentTimeMillis() + ".jpg");
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

    public static void f(Context context) {
        j.u(context).remove("thumbdown").commit();
        j.u(context).remove("thumbup").commit();
    }

    public static void f0(int i2, FloatingActionButton floatingActionButton, FloatingActionButton floatingActionButton2) {
        if (l0(i2)) {
            floatingActionButton.l();
            floatingActionButton2.l();
            return;
        }
        floatingActionButton.t();
        floatingActionButton2.t();
    }

    public static String g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        return "User’s uploaded image on " + simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + " at " + simpleDateFormat2.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean g0(Context context) {
        return j.s(context).getBoolean("crisis_resources_thumb_up", false);
    }

    public static Uri h(Activity activity, u uVar) {
        try {
            File externalFilesDir = activity.getExternalFilesDir(null);
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File file = new File(externalFilesDir, b0.a(activity).equals("es") ? "Seguimiento_TEPT_PCL5_COVIDCoach_" + j.l() + ".csv" : "TrackPTSD_PCL5_COVIDCoach_" + j.l() + ".csv");
            if (file.exists()) {
                file.delete();
            }
            ArrayList<f.a.a.a.b.d.b> o0 = uVar.o0(j.I0);
            au.com.bytecode.opencsv.a aVar = new au.com.bytecode.opencsv.a(new FileWriter(file));
            ArrayList arrayList = new ArrayList();
            String[] strArr = new String[(o0.get(0).d().size() + 2)];
            strArr[0] = activity.getString(R.string.date);
            int i2 = 0;
            while (i2 < o0.get(0).d().size()) {
                i2++;
                strArr[i2] = "PCL" + i2;
            }
            strArr[o0.get(0).d().size() + 1] = activity.getString(R.string.pct_total_score);
            arrayList.add(strArr);
            for (int i3 = 0; i3 < o0.size(); i3++) {
                arrayList.add(w(o0.get(i3)));
            }
            aVar.F(arrayList);
            aVar.close();
            return b.h.d.b.e(activity, activity.getPackageName() + ".provider", file);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean h0(Context context) {
        return false;
    }

    public static JSONArray i(Context context, ArrayList<f.a.a.a.b.d.p> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("question", R(z(context, arrayList.get(i2).a())).replaceAll("\n", " "));
                jSONObject.put("response_q" + i2, u(context, arrayList.get(i2).a()));
                jSONObject.put("value_q" + i2, arrayList.get(i2).a());
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static boolean i0(Context context) {
        f.a.a.a.b.d.b A0 = new u(context).A0(j.I0);
        if (A0 == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTimeInMillis(A0.a());
        instance2.setTimeInMillis(System.currentTimeMillis());
        if ((instance2.getTimeInMillis() - instance.getTimeInMillis()) / 86400000 < 7) {
            return true;
        }
        return false;
    }

    public static JSONArray j(Context context, ArrayList<f.a.a.a.b.d.p> arrayList, int i2) {
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                JSONObject jSONObject = new JSONObject();
                l.a aVar = l.f10128a;
                String e2 = aVar.e(context, arrayList.get(i3).c(), i2);
                String a2 = aVar.a(context, arrayList.get(i3).c(), arrayList.get(i3).a(), i2);
                jSONObject.put("question", g0.j(e2).replaceAll("\n", " "));
                jSONObject.put("response_q" + i3, a2);
                jSONObject.put("value_q" + i3, arrayList.get(i3).a());
                jSONArray.put(jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static boolean j0(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(uri.getPath()).getAbsolutePath(), options);
        if (options.outHeight > options.outWidth) {
            return true;
        }
        return false;
    }

    public static void k(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = context.getString(R.string.notif_player_channel_id_push);
            String string2 = context.getString(R.string.notif_player_channel_name_push);
            String string3 = context.getString(R.string.notif_player_channel_desc_push);
            NotificationChannel notificationChannel = new NotificationChannel(string, string2, 2);
            notificationChannel.setDescription(string3);
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(b.h.d.a.b(context, R.color.colorAccent));
            notificationChannel.setShowBadge(true);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(1);
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
    }

    public static boolean k0(Context context) {
        return j.s(context).getBoolean("sp_thumb_up", false);
    }

    public static void l(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = context.getString(R.string.notif_system_channel_id);
            String string2 = context.getString(R.string.notif_system_channel_name);
            String string3 = context.getString(R.string.notif_system_channel_desc);
            NotificationChannel notificationChannel = new NotificationChannel(string, string2, 4);
            notificationChannel.setDescription(string3);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(b.h.d.a.b(context, R.color.colorAccent));
            notificationChannel.setShowBadge(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[1000]);
            notificationChannel.setLockscreenVisibility(1);
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
    }

    private static boolean l0(int i2) {
        int i3 = 0;
        while (true) {
            Integer[] numArr = g.y0;
            if (i3 >= numArr.length) {
                return false;
            }
            if (numArr[i3].intValue() == i2) {
                return true;
            }
            i3++;
        }
    }

    public static ArrayList<Integer> m(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i2)));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static boolean m0(Context context, int i2, String str) {
        String string = j.s(context).getString(str, null);
        if (string == null) {
            return false;
        }
        return m(string).contains(Integer.valueOf(i2));
    }

    public static boolean n(Activity activity, b0 b0Var, FABTracking fABTracking, FloatingActionButton floatingActionButton, Boolean bool, Boolean bool2) {
        if (!bool2.booleanValue()) {
            if (bool.booleanValue()) {
                w0(activity, b0Var.d(), "thumbup");
            }
            a(activity, b0Var.d(), "thumbdown");
            fABTracking.setContentDescription(activity.getString(R.string.thumb_up_tool));
            floatingActionButton.setContentDescription(activity.getString(R.string.thumb_down_selected));
            floatingActionButton.announceForAccessibility(activity.getString(R.string.thumb_down_selected));
            fABTracking.setImageResource(R.drawable.thumbs_up_off);
            floatingActionButton.setImageResource(R.drawable.thumbs_down_on);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(activity, R.color.colorPrimary)));
            M0(activity.getApplication(), true);
            N0(activity.getApplication(), true);
            return true;
        }
        w0(activity, b0Var.d(), "thumbdown");
        fABTracking.setContentDescription(activity.getString(R.string.thumb_up_tool));
        floatingActionButton.setContentDescription(activity.getString(R.string.thumb_down));
        fABTracking.announceForAccessibility(activity.getString(R.string.thumb_down_deselected));
        fABTracking.setImageResource(R.drawable.thumbs_up_off);
        floatingActionButton.setImageResource(R.drawable.thumbs_down_off);
        fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-1));
        M0(activity.getApplication(), true);
        N0(activity.getApplication(), true);
        return false;
    }

    public static String n0(ArrayList<Integer> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        return jSONArray.toString();
    }

    public static boolean o(Activity activity, b0 b0Var, FABTracking fABTracking, FloatingActionButton floatingActionButton, Boolean bool, Boolean bool2) {
        if (!bool.booleanValue()) {
            if (bool2.booleanValue()) {
                w0(activity, b0Var.d(), "thumbdown");
            }
            a(activity, b0Var.d(), "thumbup");
            if (!(fABTracking == null || floatingActionButton == null)) {
                fABTracking.setContentDescription(activity.getString(R.string.thumb_up_tool_selected));
                floatingActionButton.setContentDescription(activity.getString(R.string.thumb_down));
                fABTracking.announceForAccessibility(activity.getString(R.string.thumb_up_tool_selected));
                fABTracking.setImageResource(R.drawable.thumbs_up_on);
                floatingActionButton.setImageResource(R.drawable.thumbs_down_off);
                fABTracking.setBackgroundTintList(ColorStateList.valueOf(b.h.d.a.b(activity, R.color.colorPrimary)));
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-1));
            }
            M0(activity.getApplication(), true);
            N0(activity.getApplication(), true);
            return true;
        }
        w0(activity, b0Var.d(), "thumbup");
        if (!(fABTracking == null || floatingActionButton == null)) {
            fABTracking.setContentDescription(activity.getString(R.string.thumb_up_tool));
            floatingActionButton.setContentDescription(activity.getString(R.string.thumb_down));
            fABTracking.announceForAccessibility(activity.getString(R.string.thumb_up_deselected));
            fABTracking.setImageResource(R.drawable.thumbs_up_off);
            floatingActionButton.setImageResource(R.drawable.thumbs_down_off);
            fABTracking.setBackgroundTintList(ColorStateList.valueOf(-1));
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-1));
        }
        M0(activity.getApplication(), true);
        N0(activity.getApplication(), true);
        return false;
    }

    static /* synthetic */ boolean o0(Activity activity, View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
        return false;
    }

    public static void p(View view) {
        Executors.newSingleThreadScheduledExecutor().schedule(new f(view), 450, TimeUnit.MILLISECONDS);
    }

    public static ArrayList<b0> p0(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.z));
            ArrayList<b0> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b0 e2 = p.e(jSONArray.getJSONObject(i2));
                if (e2.d() != 26) {
                    arrayList.add(e2);
                }
            }
            return arrayList;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static f.a.a.a.b.d.r q(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.y));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getJSONObject(i2).getInt("id") == 30) {
                    String string = jSONArray.getJSONObject(i2).getString("filename");
                    JSONArray jSONArray2 = new JSONArray(j.N(context, g.f10089i + File.separator + string));
                    int nextInt = new Random().nextInt(jSONArray2.length());
                    return new f.a.a.a.b.d.r(jSONArray2.getJSONObject(nextInt).getString("quote") + " - " + jSONArray2.getJSONObject(nextInt).getString("attribution"), nextInt);
                }
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<a0> q0(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.x));
            ArrayList<a0> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(p.d(jSONArray.getJSONObject(i2)));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String r(Context context, int i2) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.y));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (jSONArray.getJSONObject(i3).getInt("id") == 30) {
                    String string = jSONArray.getJSONObject(i3).getString("filename");
                    JSONArray jSONArray2 = new JSONArray(j.N(context, g.f10089i + File.separator + string));
                    if (i2 == -1) {
                        i2 = new Random().nextInt(jSONArray2.length());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONArray2.getJSONObject(i2).getString("quote"));
                    if (!jSONArray2.getJSONObject(i2).getString("attribution").isEmpty()) {
                        sb.append("\n\n--");
                        sb.append(jSONArray2.getJSONObject(i2).getString("attribution"));
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<b0> r0(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.y));
            ArrayList<b0> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b0 e2 = p.e(jSONArray.getJSONObject(i2));
                if (e2.d() != 26) {
                    arrayList.add(e2);
                }
            }
            return arrayList;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String s(Context context, f.a.a.a.b.d.q qVar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(qVar.c());
        int i2 = instance.get(5);
        String displayName = instance.getDisplayName(2, 2, Locale.getDefault());
        int i3 = instance.get(1);
        StringBuilder sb = new StringBuilder(Integer.toString(i2));
        sb.append(" ");
        sb.append(displayName);
        sb.append(" ");
        sb.append(i3);
        sb.append(" ");
        sb.append(context.getString(R.string.trigger) + " " + qVar.e());
        return sb.toString();
    }

    public static ArrayList<b0> s0(Context context, ArrayList<Integer> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10085e + File.separator + g.y));
            ArrayList<b0> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int intValue = arrayList.get(i2).intValue();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    b0 e2 = p.e(jSONArray.getJSONObject(i3));
                    if (e2 != null && e2.d() == intValue) {
                        arrayList2.add(e2);
                    }
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String t(Context context, String str) {
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = g.x0;
            if (i2 >= strArr.length) {
                return str;
            }
            if (strArr[i2].equals(str)) {
                return j.w(context, str);
            }
            i2++;
        }
    }

    public static boolean t0(long j2) {
        return ((int) (j2 / 1000)) % 10 == 0;
    }

    public static String u(Context context, int i2) {
        if (i2 == 0) {
            return context.getString(R.string.not_at_all);
        }
        if (i2 == 1) {
            return context.getString(R.string.a_little_bit);
        }
        if (i2 == 2) {
            return context.getString(R.string.moderately);
        }
        if (i2 != 3) {
            return context.getString(R.string.extremely);
        }
        return context.getString(R.string.quite_a_bit);
    }

    public static f.a.a.a.b.d.d u0(Activity activity, int i2) {
        try {
            JSONObject jSONObject = new JSONObject(j.N(activity, g.f10091k + File.separator + i2 + ".json"));
            return new f.a.a.a.b.d.d(jSONObject.getString("title"), jSONObject.getString("display_title"), jSONObject.getString("intro_text"), jSONObject.getString("filename"), jSONObject.getString("filename_es"), j.m(activity, jSONObject.getString("image")), j.o(activity, jSONObject.getString("subtitle")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static AssetFileDescriptor v(Context context, String str) {
        try {
            return context.getAssets().openFd(str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String v0(long j2) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        instance.setTimeInMillis(j2);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String[] w(f.a.a.a.b.d.b bVar) {
        String[] strArr = new String[(bVar.d().size() + 2)];
        int i2 = 0;
        strArr[0] = j.f(bVar.a());
        while (i2 < bVar.d().size()) {
            int i3 = i2 + 1;
            strArr[i3] = Integer.toString(bVar.d().get(i2).a());
            i2 = i3;
        }
        strArr[bVar.d().size() + 1] = Integer.toString(bVar.c());
        return strArr;
    }

    public static void w0(Context context, int i2, String str) {
        ArrayList<Integer> arrayList;
        String string = j.s(context).getString(str, null);
        if (string == null) {
            arrayList = new ArrayList<>();
        } else {
            ArrayList<Integer> m = m(string);
            int i3 = 0;
            while (true) {
                if (i3 >= m.size()) {
                    break;
                } else if (m.get(i3).intValue() == i2) {
                    m.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            arrayList = m;
        }
        j.u(context).putString(str, n0(arrayList)).commit();
    }

    public static File x(Context context) {
        try {
            InputStream open = context.getAssets().open("clouds.mp4");
            File file = new File(context.getCacheDir(), "tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return file;
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static void x0(Context context, ArrayList<Integer> arrayList) {
        j.u(context).putString("thumbup", n0(arrayList)).commit();
    }

    public static b0 y(Context context, int i2) {
        ArrayList<b0> p0 = p0(context);
        for (int i3 = 0; i3 < p0.size(); i3++) {
            b0 b0Var = p0.get(i3);
            if (b0Var.d() == i2) {
                return b0Var;
            }
        }
        return null;
    }

    public static Bitmap y0(Bitmap bitmap, int i2) {
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

    public static String z(Context context, int i2) {
        try {
            u uVar = new u(context);
            JSONArray jSONArray = new JSONArray(j.N(context, g.f10083c + File.separator + g.w));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.getInt("number") == i2) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("question");
                    JSONArray jSONArray3 = new JSONArray();
                    boolean z = true;
                    if (!(i2 == 0 || i2 == 1 || i2 == 7 || i2 == 11 || i2 == 13 || i2 == 14)) {
                        if (i2 != 19) {
                            z = false;
                        }
                    }
                    if (j.s(context).getString("reminder_ptsd_symptoms_frequency", "weekly").equals("weekly")) {
                        f.a.a.a.b.d.b A0 = uVar.A0(j.I0);
                        if (A0 != null) {
                            if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - A0.a()) < 14) {
                                if (!b0.a(context).equals("es")) {
                                    jSONArray3.put(context.getString(R.string.in_past_week_bothered_by));
                                } else if (z) {
                                    jSONArray3.put(context.getString(R.string.in_past_week_bothered_by_tener));
                                } else {
                                    jSONArray3.put(context.getString(R.string.in_past_week_bothered_by));
                                }
                            } else if (!b0.a(context).equals("es")) {
                                jSONArray3.put(context.getString(R.string.in_past_month_bothered_by));
                            } else if (z) {
                                jSONArray3.put(context.getString(R.string.in_past_month_bothered_by_tener));
                            } else {
                                jSONArray3.put(context.getString(R.string.in_past_month_bothered_by));
                            }
                        } else if (!b0.a(context).equals("es")) {
                            jSONArray3.put(context.getString(R.string.in_past_month_bothered_by));
                        } else if (z) {
                            jSONArray3.put(context.getString(R.string.in_past_month_bothered_by_tener));
                        } else {
                            jSONArray3.put(context.getString(R.string.in_past_month_bothered_by));
                        }
                    }
                    jSONArray3.put(jSONArray2.getString(0));
                    return jSONArray3.toString();
                }
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void z0(Context context) {
        u uVar = new u(context);
        int i2 = 0;
        while (true) {
            Integer[] numArr = g.w0;
            if (i2 < numArr.length) {
                Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), numArr[i2].intValue());
                File externalFilesDir = context.getExternalFilesDir(null);
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, String.format("default_si_%d.jpg", Integer.valueOf(i2)));
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    decodeResource.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    decodeResource.recycle();
                    System.gc();
                    uVar.I(b.h.d.b.e(context, context.getPackageName() + ".provider", file), true, g.x0[i2]);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
