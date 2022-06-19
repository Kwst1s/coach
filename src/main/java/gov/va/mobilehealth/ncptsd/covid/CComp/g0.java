package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import b.a.j;
import b.h.d.e.f;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.n;
import f.a.a.a.b.d.u;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_crisis_resources;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_find_professional_care;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_find_resources;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_grow_support;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage_data;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage_stress;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_mood_check;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn_category;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_sublist;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_assessment_start;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_goals;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_env_safe;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import k.b.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: ScreensParser */
public class g0 {

    /* access modifiers changed from: package-private */
    /* compiled from: ScreensParser */
    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10092b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10093c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10094d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Activity f10095e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f10096f;

        a(String str, String str2, String str3, Activity activity, JSONObject jSONObject) {
            this.f10092b = str;
            this.f10093c = str2;
            this.f10094d = str3;
            this.f10095e = activity;
            this.f10096f = jSONObject;
        }

        public void onClick(View view) {
            if (this.f10092b.equals("link_phone")) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", j.g(this.f10093c).toString());
                hashMap.put("tel", this.f10094d.trim());
                d.b(hashMap);
                this.f10095e.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.f10094d, null)));
            } else if (this.f10092b.equals("link_email")) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{this.f10094d});
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("name", j.g(this.f10093c).toString());
                    hashMap2.put("email", this.f10094d.trim());
                    d.b(hashMap2);
                    this.f10095e.startActivity(Intent.createChooser(intent, "Send mail..."));
                } catch (ActivityNotFoundException unused) {
                    Activity activity = this.f10095e;
                    Toast.makeText(activity, activity.getString(R.string.no_app_to_handle_content), 1).show();
                }
            } else if (this.f10092b.equals("link_text")) {
                Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.f10094d));
                try {
                    if (j.F(this.f10096f, "fill")) {
                        intent2.putExtra("sms_body", this.f10096f.getString("fill"));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f10095e.startActivity(intent2);
            } else if (!this.f10092b.equals("link_internal")) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("name", j.g(this.f10093c).toString());
                hashMap3.put("link", this.f10094d.trim());
                d.b(hashMap3);
                m.Y0(this.f10095e, this.f10094d, this.f10093c);
            } else if (this.f10094d.equals("m_data")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_manage_data.class));
            } else if (this.f10094d.equals("get_support")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_find_resources.class));
            } else if (this.f10094d.contains("grow_support")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_grow_support.class));
            } else if (this.f10094d.contains("manage_stress")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_manage_stress.class));
            } else if (this.f10094d.contains("mood_check")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_goals.class));
            } else if (this.f10094d.contains("mood_check_section")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_mood_check.class));
            } else if (this.f10094d.contains("link_learn_category")) {
                try {
                    String string = this.f10096f.getString("learn_file");
                    n nVar = new n(this.f10096f.getString("learn_title"), g0.i(this.f10095e, string), this.f10096f.getString("learn_icon"));
                    Intent intent3 = new Intent(this.f10095e, Act_single_covid_learn_category.class);
                    intent3.putExtra("data", nVar);
                    this.f10095e.startActivity(intent3);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (this.f10094d.contains("find_resources")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_find_resources.class));
            } else if (this.f10094d.contains("relationship_tools")) {
                Intent intent4 = new Intent(this.f10095e, Act_tool_sublist.class);
                intent4.putExtra("tool", m.O(this.f10095e));
                this.f10095e.startActivity(intent4);
            } else if (this.f10094d.contains("link_learn")) {
                try {
                    String string2 = this.f10096f.getString("learn_file");
                    u P = m.P(this.f10095e, string2, this.f10096f.getInt("learn_id"));
                    if (P != null) {
                        Intent intent5 = new Intent(this.f10095e, Act_single_covid_learn.class);
                        intent5.putExtra("screen", P);
                        intent5.putExtra("noImage", string2.equals("find_resources.json"));
                        this.f10095e.startActivity(intent5);
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (this.f10094d.contains("track_ptsd_symptoms")) {
                Intent intent6 = new Intent(this.f10095e, Act_assessment_start.class);
                intent6.putExtra("type", j.I0);
                this.f10095e.startActivity(intent6);
            } else if (this.f10094d.contains("t")) {
                int parseInt = Integer.parseInt(this.f10094d.replace("t", BuildConfig.FLAVOR));
                Intent intent7 = new Intent(this.f10095e, Act_manage.class);
                intent7.putExtra("tool", m.Y(this.f10095e, parseInt));
                this.f10095e.startActivity(intent7);
            } else if (this.f10094d.contains("mindfulness")) {
                Intent intent8 = new Intent(this.f10095e, Act_tool_sublist.class);
                intent8.putExtra("tool", m.M(this.f10095e));
                this.f10095e.startActivity(intent8);
            } else if (this.f10094d.contains("find_care")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_find_professional_care.class));
            } else if (this.f10094d.contains("crisis_resources")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_crisis_resources.class));
            } else if (this.f10094d.contains("env_safe")) {
                this.f10095e.startActivity(new Intent(this.f10095e, Act_sp_step6_env_safe.class));
            }
        }
    }

    public static View a(Activity activity, String str, int i2, String str2, int i3, boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams;
        int m = j.m(activity, str);
        if (z2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(activity.getResources(), m, options);
            float f2 = ((float) options.outHeight) / ((float) options.outWidth);
            int r = j.r(activity) - (i2 * 2);
            layoutParams = new LinearLayout.LayoutParams(r, (int) (((float) r) * f2));
            layoutParams.gravity = 17;
        } else {
            int r2 = j.r(activity) / 2;
            layoutParams = new LinearLayout.LayoutParams(r2, r2);
            if (i3 == -1) {
                layoutParams.gravity = 3;
            } else if (i3 == 0) {
                layoutParams.gravity = 17;
            } else if (i3 == 1) {
                layoutParams.gravity = 5;
            }
        }
        AppCompatImageView appCompatImageView = new AppCompatImageView(activity);
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setPadding(i2, i2, i2, i2);
        appCompatImageView.setImageResource(m);
        if (str2.isEmpty()) {
            appCompatImageView.setFocusable(false);
            appCompatImageView.setImportantForAccessibility(2);
        } else {
            appCompatImageView.setContentDescription(str2);
            appCompatImageView.setFocusable(true);
            appCompatImageView.setImportantForAccessibility(1);
        }
        return appCompatImageView;
    }

    public static View b(Activity activity, LinearLayout.LayoutParams layoutParams, int i2, int i3, JSONObject jSONObject, String str, String str2, String str3, boolean z, boolean z2) {
        ButtonTracking buttonTracking;
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.padding_large);
        if (z2) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.button_link_with_image, (ViewGroup) null);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.button_link_with_image_txt);
            AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.button_link_with_image_img);
            inflate.setLayoutParams(layoutParams);
            int i4 = dimensionPixelSize / 2;
            inflate.setPadding(i2 * 2, i4, i2, i4);
            inflate.setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            inflate.setFocusable(true);
            inflate.setImportantForAccessibility(1);
            ((LinearLayoutTracking) inflate).setForceName(j.g(str3).toString());
            appCompatTextView.setTextColor(b.h.d.a.b(activity, R.color.grey_4a));
            appCompatTextView.setText(j.g(str3));
            appCompatTextView.setAllCaps(true);
            appCompatTextView.setTypeface(f.b(activity, R.font.font_semibold));
            inflate.setContentDescription(j.g(str3).toString() + " button");
            if (str.equals("link_web") || str.equals("link")) {
                appCompatImageView.setVisibility(0);
                appCompatImageView.setImageResource(R.drawable.icon_web);
                buttonTracking = inflate;
            } else if (str.equals("link_phone")) {
                appCompatImageView.setVisibility(0);
                appCompatImageView.setImageResource(R.drawable.icon_call);
                buttonTracking = inflate;
            } else {
                appCompatImageView.setVisibility(0);
                appCompatImageView.setImageResource(R.drawable.icon_text);
                buttonTracking = inflate;
            }
        } else {
            ButtonTracking buttonTracking2 = new ButtonTracking(activity);
            buttonTracking2.setLayoutParams(layoutParams);
            buttonTracking2.setPadding(i2, dimensionPixelSize, i2, dimensionPixelSize);
            buttonTracking2.setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            buttonTracking2.setFocusable(true);
            buttonTracking2.setImportantForAccessibility(1);
            buttonTracking2.setTextSize(0, (float) activity.getResources().getDimensionPixelSize(R.dimen.txt_mid_btn));
            buttonTracking2.setTextColor(b.h.d.a.b(activity, R.color.grey_4a));
            buttonTracking2.setText(j.g(str3));
            buttonTracking2.setAllCaps(true);
            buttonTracking2.setTypeface(f.b(activity, R.font.font_semibold));
            buttonTracking2.setForceName(j.g(str3).toString());
            if (str.equals("link_web")) {
                buttonTracking2.setContentDescription(str3 + " " + activity.getString(R.string.link));
                buttonTracking = buttonTracking2;
            } else {
                buttonTracking2.setContentDescription(str3);
                buttonTracking = buttonTracking2;
            }
        }
        if (z) {
            layoutParams.width = -1;
        } else if (j.F(jSONObject, "gravity")) {
            try {
                int i5 = jSONObject.getInt("gravity");
                if (i5 == -1) {
                    layoutParams.gravity = 3;
                } else if (i5 == 0) {
                    layoutParams.gravity = 1;
                } else if (i5 == 1) {
                    layoutParams.gravity = 5;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        buttonTracking.setOnClickListener(new a(str, str3, str2, activity, jSONObject));
        return buttonTracking;
    }

    public static View c(Activity activity, LayoutInflater layoutInflater, String str, int i2, String str2, TableLayout.LayoutParams layoutParams, int i3, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_row_screen, (ViewGroup) null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.item_row_screen_txt);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.item_row_screen_txt_round);
        float f2 = (float) i2;
        appCompatTextView.setTextSize(0, f2);
        appCompatTextView2.setTextSize(0, f2);
        appCompatTextView2.setTextColor(b.h.d.a.b(activity, i3));
        appCompatTextView.setTextColor(b.h.d.a.b(activity, i3));
        appCompatTextView.setText(j.g(str2));
        appCompatTextView.setFocusable(true);
        appCompatTextView.setImportantForAccessibility(1);
        appCompatTextView.setTypeface(f.b(activity, R.font.font_regular));
        appCompatTextView.setLineSpacing(TypedValue.applyDimension(1, 4.0f, activity.getResources().getDisplayMetrics()), 1.0f);
        if (str.equals("list_l2")) {
            appCompatTextView2.setText("○");
        } else if (str.equals("list_l3")) {
            appCompatTextView2.setText("◆");
        }
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    public static View d(Activity activity, LayoutInflater layoutInflater, int i2, int i3, String str, TableLayout.LayoutParams layoutParams, int i4, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_row_screen, (ViewGroup) null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.item_row_screen_txt);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.item_row_screen_txt_round);
        float f2 = (float) i3;
        appCompatTextView.setTextSize(0, f2);
        appCompatTextView2.setTextSize(0, f2);
        appCompatTextView.setTextColor(b.h.d.a.b(activity, i4));
        appCompatTextView2.setTextColor(b.h.d.a.b(activity, i4));
        appCompatTextView.setText(j.g(str));
        appCompatTextView.setFocusable(true);
        appCompatTextView.setImportantForAccessibility(1);
        appCompatTextView2.setText(Integer.toString(i2 + 1) + ")");
        appCompatTextView.setTypeface(f.b(activity, R.font.font_regular));
        appCompatTextView.setLineSpacing(TypedValue.applyDimension(1, 4.0f, activity.getResources().getDisplayMetrics()), 1.0f);
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    public static f0 e(Activity activity, int i2) {
        double r = (double) j.r(activity);
        Double.isNaN(r);
        int i3 = (int) (r / 1.4d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 1;
        layoutParams.setMargins(i2, i2, i2, 0);
        f0 f0Var = new f0(activity);
        f0Var.setLayoutParams(layoutParams);
        f0Var.a(activity);
        return f0Var;
    }

    public static AppCompatTextView f(Activity activity, LinearLayout.LayoutParams layoutParams, int i2, int i3, String str, JSONObject jSONObject, int i4, boolean z) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(activity);
        appCompatTextView.setLayoutParams(layoutParams);
        if (z) {
            appCompatTextView.setPadding(0, 0, 0, 0);
        } else {
            appCompatTextView.setPadding(i2, 0, i2, 0);
        }
        appCompatTextView.setTextSize(0, (float) i3);
        appCompatTextView.setTextColor(b.h.d.a.b(activity, i4));
        Spanned g2 = j.g(str);
        appCompatTextView.setText(g2);
        if (g2.length() != 0) {
            appCompatTextView.setFocusable(true);
            appCompatTextView.setImportantForAccessibility(1);
        } else {
            appCompatTextView.setFocusable(false);
            appCompatTextView.setImportantForAccessibility(2);
        }
        appCompatTextView.setTypeface(f.b(activity, R.font.font_regular));
        appCompatTextView.setLineSpacing(TypedValue.applyDimension(1, 4.0f, activity.getResources().getDisplayMetrics()), 1.0f);
        if (j.F(jSONObject, "gravity")) {
            try {
                int i5 = jSONObject.getInt("gravity");
                if (i5 == -1) {
                    appCompatTextView.setGravity(3);
                } else if (i5 == 0) {
                    appCompatTextView.setGravity(17);
                } else if (i5 == 1) {
                    appCompatTextView.setGravity(5);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (j.F(jSONObject, "heading")) {
            try {
                if (jSONObject.getBoolean("heading")) {
                    appCompatTextView.setContentDescription(((Object) j.g(str)) + " heading");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return appCompatTextView;
    }

    public static AppCompatTextView g(Activity activity, LinearLayout.LayoutParams layoutParams, int i2, int i3, String str, JSONObject jSONObject, int i4) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(activity);
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setPadding(i2, 0, i2, 0);
        double d2 = (double) i3;
        Double.isNaN(d2);
        appCompatTextView.setTextSize(0, (float) (d2 * 1.25d));
        appCompatTextView.setTextColor(b.h.d.a.b(activity, R.color.colorAccent));
        appCompatTextView.setText(j.g(str));
        appCompatTextView.setFocusable(true);
        appCompatTextView.setContentDescription(((Object) j.g(str)) + " " + activity.getString(R.string.heading));
        appCompatTextView.setImportantForAccessibility(1);
        appCompatTextView.setTypeface(f.b(activity, R.font.font_semibold));
        if (j.F(jSONObject, "gravity")) {
            try {
                int i5 = jSONObject.getInt("gravity");
                if (i5 == -1) {
                    appCompatTextView.setGravity(3);
                } else if (i5 == 0) {
                    appCompatTextView.setGravity(17);
                } else if (i5 == 1) {
                    appCompatTextView.setGravity(5);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return appCompatTextView;
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != 0) {
                    sb.append("\n");
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("content");
                if (string.equals("text")) {
                    sb.append(string2);
                } else if (string.contains("list")) {
                    if (string.equals("list_complex")) {
                        JSONArray jSONArray2 = new JSONArray(string2);
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            JSONArray jSONArray3 = jSONArray2.getJSONArray(i3);
                            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                                JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                                String string3 = jSONObject2.getString("content");
                                if (jSONObject2.getString("type").equals("text")) {
                                    sb.append(string3);
                                }
                                sb.append("   ");
                            }
                        }
                    } else {
                        JSONArray jSONArray4 = new JSONArray(string2);
                        if (string.equals("list_numeric")) {
                            int i5 = 0;
                            while (i5 < jSONArray4.length()) {
                                StringBuilder sb2 = new StringBuilder();
                                int i6 = i5 + 1;
                                sb2.append(Integer.toString(i6));
                                sb2.append("  ");
                                sb2.append(jSONArray4.getString(i5));
                                sb.append(sb2.toString());
                                sb.append("   ");
                                i5 = i6;
                            }
                        } else if (string.equals("list_numeric_specific")) {
                            for (int i7 = 0; i7 < jSONArray4.length(); i7++) {
                                int i8 = jSONArray4.getJSONObject(i7).getInt("number");
                                String string4 = jSONArray4.getJSONObject(i7).getString("string");
                                sb.append(Integer.toString(i8) + "     " + string4);
                                sb.append("     ");
                            }
                        } else {
                            for (int i9 = 0; i9 < jSONArray4.length(); i9++) {
                                sb.append(jSONArray4.getString(i9));
                                sb.append("     ");
                            }
                        }
                    }
                } else if (string.equals("title")) {
                    sb.append(string2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static ArrayList<u> i(Activity activity, String str) {
        String N = j.N(activity, g.f10082b + File.separator + str);
        ArrayList<u> arrayList = new ArrayList<>();
        try {
            return p.a(new JSONArray(N));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public static String j(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("content");
                if (i2 != 0) {
                    sb.append(" ");
                }
                if (string.equals("text")) {
                    sb.append((CharSequence) j.g(string2));
                } else if (string.contains("link")) {
                    sb.append((CharSequence) j.g(string2));
                } else if (string.equals("image")) {
                    if (jSONObject.getString("contentDescription") != null) {
                        sb.append((CharSequence) j.g(string2));
                    }
                } else if (string.equals("title")) {
                    sb.append((CharSequence) j.g(string2));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sb.toString().trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x038a A[LOOP:5: B:88:0x0384->B:90:0x038a, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void k(android.app.Activity r43, android.view.LayoutInflater r44, android.widget.LinearLayout r45, java.lang.String r46, int r47, int r48, int r49, boolean r50) {
        /*
        // Method dump skipped, instructions count: 1184
        */
        throw new UnsupportedOperationException("Method not decompiled: gov.va.mobilehealth.ncptsd.covid.CComp.g0.k(android.app.Activity, android.view.LayoutInflater, android.widget.LinearLayout, java.lang.String, int, int, int, boolean):void");
    }
}
