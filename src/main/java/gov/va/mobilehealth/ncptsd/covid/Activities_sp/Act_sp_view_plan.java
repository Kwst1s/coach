package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.o.n;
import org.json.JSONArray;
import vainstrum.Components.ImageViewTracking;
import vainstrum.Components.LinearLayoutTracking;

/* compiled from: Act_sp_view_plan.kt */
public final class Act_sp_view_plan extends vainstrum.Components.a {
    private final int w = 324;
    private long x = -1;
    private HashMap y;

    /* compiled from: Act_sp_view_plan.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f9997b;

        a(Act_sp_view_plan act_sp_view_plan) {
            this.f9997b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9997b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 0);
            this.f9997b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f9998b;

        b(Act_sp_view_plan act_sp_view_plan) {
            this.f9998b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9998b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 1);
            this.f9998b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f9999b;

        c(Act_sp_view_plan act_sp_view_plan) {
            this.f9999b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9999b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 2);
            this.f9999b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10000b;

        d(Act_sp_view_plan act_sp_view_plan) {
            this.f10000b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f10000b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 3);
            this.f10000b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10001b;

        e(Act_sp_view_plan act_sp_view_plan) {
            this.f10001b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f10001b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 4);
            this.f10001b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10002b;

        f(Act_sp_view_plan act_sp_view_plan) {
            this.f10002b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f10002b.getApplicationContext(), Act_sp_steps.class);
            intent.putExtra("step", 5);
            this.f10002b.startActivity(intent);
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10003b;

        g(Act_sp_view_plan act_sp_view_plan) {
            this.f10003b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f10003b, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                Act_sp_view_plan act_sp_view_plan = this.f10003b;
                androidx.core.app.a.l(act_sp_view_plan, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, act_sp_view_plan.Y());
                return;
            }
            this.f10003b.Z();
        }
    }

    /* compiled from: Act_sp_view_plan.kt */
    static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10004b;

        h(Act_sp_view_plan act_sp_view_plan) {
            this.f10004b = act_sp_view_plan;
        }

        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:1-800-273-8255"));
            this.f10004b.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_sp_view_plan.kt */
    public static final class i implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_view_plan f10005b;

        i(Act_sp_view_plan act_sp_view_plan) {
            this.f10005b = act_sp_view_plan;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            this.f10005b.X();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_sp_view_plan.kt */
    public static final class j implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final j f10006b = new j();

        j() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public View W(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        File file;
        a.a.a aVar;
        int i2;
        String str;
        int i3;
        String str2;
        JSONArray jSONArray;
        int i4;
        JSONArray jSONArray2;
        int i5;
        String str3;
        String str4;
        JSONArray jSONArray3;
        int i6;
        JSONArray jSONArray4;
        int i7;
        JSONArray jSONArray5;
        int i8;
        JSONArray jSONArray6;
        int i9;
        String str5;
        String str6;
        Act_sp_view_plan act_sp_view_plan = this;
        a.a.a g2 = a.a.a.g();
        File file2 = new File(Environment.getExternalStorageDirectory().toString() + File.separator + "COVIDExports");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String l = gov.va.mobilehealth.ncptsd.covid.CComp.j.l();
        File file3 = new File(file2, "my_safety_plan_" + l + ".pdf");
        String O = gov.va.mobilehealth.ncptsd.covid.CComp.j.O(getApplicationContext(), "template_sp.html");
        z zVar = new z(act_sp_view_plan);
        String str7 = O;
        int i10 = 1;
        for (int i11 = 7; i10 < i11; i11 = 7) {
            if (o.p(getApplicationContext(), i10)) {
                StringBuilder sb = new StringBuilder("<ul>");
                StringBuilder sb2 = new StringBuilder("<ul>");
                String str8 = "builder2.toString()";
                String str9 = "contact";
                String str10 = "builder.toString()";
                switch (i10) {
                    case 1:
                        aVar = g2;
                        i3 = i10;
                        file = file3;
                        Context applicationContext = getApplicationContext();
                        kotlin.m.b.f.c(applicationContext);
                        JSONArray m = o.m(applicationContext);
                        int length = m.length();
                        for (int i12 = 0; i12 < length; i12++) {
                            Iterator<f.a.a.a.b.e.e> it = zVar.V().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    f.a.a.a.b.e.e next = it.next();
                                    kotlin.m.b.f.d(next, "ws");
                                    int a2 = next.a();
                                    Object obj = m.get(i12);
                                    if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next.c());
                                        sb.append("</li>");
                                    }
                                }
                            }
                        }
                        sb.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb3 = sb.toString();
                        kotlin.m.b.f.d(sb3, str10);
                        str2 = n.c(str7, "#STEP1_ITEMS#", sb3, false, 4, null);
                        str7 = str2;
                        i2 = i3;
                        break;
                    case 2:
                        aVar = g2;
                        i3 = i10;
                        file = file3;
                        JSONArray g3 = o.g(this);
                        int length2 = g3.length();
                        for (int i13 = 0; i13 < length2; i13++) {
                            Iterator<f.a.a.a.b.e.a> it2 = zVar.P().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    f.a.a.a.b.e.a next2 = it2.next();
                                    kotlin.m.b.f.d(next2, "cs");
                                    int a3 = next2.a();
                                    Object obj2 = g3.get(i13);
                                    if ((obj2 instanceof Integer) && a3 == ((Integer) obj2).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next2.c());
                                        if (next2.d() != -1) {
                                            sb.append(" (PTSD Coach tool)");
                                        }
                                        sb.append("</li>");
                                    }
                                }
                            }
                        }
                        sb.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb4 = sb.toString();
                        kotlin.m.b.f.d(sb4, str10);
                        str2 = n.c(str7, "#STEP2_ITEMS#", sb4, false, 4, null);
                        str7 = str2;
                        i2 = i3;
                        break;
                    case 3:
                        aVar = g2;
                        i3 = i10;
                        file = file3;
                        int i14 = 3;
                        JSONArray i15 = o.i(act_sp_view_plan, 3);
                        int length3 = i15.length();
                        int i16 = 0;
                        while (i16 < length3) {
                            Iterator<f.a.a.a.b.e.d> it3 = zVar.Q(i14).iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    f.a.a.a.b.e.d next3 = it3.next();
                                    kotlin.m.b.f.d(next3, str9);
                                    i5 = length3;
                                    int c2 = next3.c();
                                    str3 = str9;
                                    Object obj3 = i15.get(i16);
                                    jSONArray2 = i15;
                                    if ((obj3 instanceof Integer) && c2 == ((Integer) obj3).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next3.d());
                                        if (next3.e() != null) {
                                            sb.append(": ");
                                            sb.append(next3.e());
                                        }
                                        sb.append("</li>");
                                    } else {
                                        length3 = i5;
                                        it3 = it3;
                                        str9 = str3;
                                        i15 = jSONArray2;
                                    }
                                } else {
                                    jSONArray2 = i15;
                                    i5 = length3;
                                    str3 = str9;
                                }
                            }
                            i16++;
                            length3 = i5;
                            str9 = str3;
                            i15 = jSONArray2;
                            i14 = 3;
                        }
                        JSONArray k2 = o.k(this);
                        int length4 = k2.length();
                        int i17 = 0;
                        while (i17 < length4) {
                            Iterator<f.a.a.a.b.e.c> it4 = zVar.T().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    f.a.a.a.b.e.c next4 = it4.next();
                                    kotlin.m.b.f.d(next4, "place");
                                    int a4 = next4.a();
                                    i4 = length4;
                                    Object obj4 = k2.get(i17);
                                    jSONArray = k2;
                                    if ((obj4 instanceof Integer) && a4 == ((Integer) obj4).intValue()) {
                                        sb2.append("<li>");
                                        sb2.append(next4.c());
                                        sb2.append("</li>");
                                    } else {
                                        length4 = i4;
                                        k2 = jSONArray;
                                    }
                                } else {
                                    jSONArray = k2;
                                    i4 = length4;
                                }
                            }
                            i17++;
                            length4 = i4;
                            k2 = jSONArray;
                        }
                        sb.append("</ul>");
                        sb2.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb5 = sb.toString();
                        kotlin.m.b.f.d(sb5, str10);
                        String str11 = n.c(str7, "#STEP3.1_ITEMS#", sb5, false, 4, null);
                        String sb6 = sb2.toString();
                        kotlin.m.b.f.d(sb6, str8);
                        str2 = n.c(str11, "#STEP3.2_ITEMS#", sb6, false, 4, null);
                        str7 = str2;
                        i2 = i3;
                        break;
                    case 4:
                        aVar = g2;
                        i3 = i10;
                        file = file3;
                        int i18 = 4;
                        JSONArray i19 = o.i(act_sp_view_plan, 4);
                        int length5 = i19.length();
                        int i20 = 0;
                        while (i20 < length5) {
                            Iterator<f.a.a.a.b.e.d> it5 = zVar.Q(i18).iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    f.a.a.a.b.e.d next5 = it5.next();
                                    kotlin.m.b.f.d(next5, str9);
                                    i6 = length5;
                                    int c3 = next5.c();
                                    Object obj5 = i19.get(i20);
                                    jSONArray3 = i19;
                                    if ((obj5 instanceof Integer) && c3 == ((Integer) obj5).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next5.d());
                                        if (next5.e() != null) {
                                            sb.append(": ");
                                            sb.append(next5.e());
                                        }
                                        sb.append("</li>");
                                    } else {
                                        length5 = i6;
                                        it5 = it5;
                                        i19 = jSONArray3;
                                    }
                                } else {
                                    jSONArray3 = i19;
                                    i6 = length5;
                                }
                            }
                            i20++;
                            length5 = i6;
                            i19 = jSONArray3;
                            i18 = 4;
                        }
                        sb.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb7 = sb.toString();
                        kotlin.m.b.f.d(sb7, str10);
                        str4 = n.c(str7, "#STEP4_ITEMS#", sb7, false, 4, null);
                        str7 = str4;
                        i2 = i3;
                        break;
                    case 5:
                        aVar = g2;
                        i3 = i10;
                        file = file3;
                        int i21 = 5;
                        JSONArray i22 = o.i(act_sp_view_plan, 5);
                        int length6 = i22.length();
                        int i23 = 0;
                        while (i23 < length6) {
                            Iterator<f.a.a.a.b.e.d> it6 = zVar.Q(i21).iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    f.a.a.a.b.e.d next6 = it6.next();
                                    kotlin.m.b.f.d(next6, str9);
                                    int c4 = next6.c();
                                    i7 = length6;
                                    Object obj6 = i22.get(i23);
                                    jSONArray4 = i22;
                                    if ((obj6 instanceof Integer) && c4 == ((Integer) obj6).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next6.d());
                                        if (next6.e() != null) {
                                            sb.append(" - ");
                                            sb.append(next6.e());
                                        }
                                        if (next6.f() != null) {
                                            String f2 = next6.f();
                                            kotlin.m.b.f.d(f2, "contact.street");
                                            if (f2.length() > 0) {
                                                sb.append(" - ");
                                                sb.append(next6.f());
                                            }
                                        }
                                        sb.append("</li>");
                                    } else {
                                        length6 = i7;
                                        i22 = jSONArray4;
                                    }
                                } else {
                                    jSONArray4 = i22;
                                    i7 = length6;
                                }
                            }
                            i23++;
                            length6 = i7;
                            i22 = jSONArray4;
                            i21 = 5;
                        }
                        sb.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb8 = sb.toString();
                        kotlin.m.b.f.d(sb8, str10);
                        str4 = n.c(str7, "#STEP5_ITEMS#", sb8, false, 4, null);
                        str7 = str4;
                        i2 = i3;
                        break;
                    case 6:
                        aVar = g2;
                        JSONArray j2 = o.j(this);
                        file = file3;
                        int length7 = j2.length();
                        i3 = i10;
                        int i24 = 0;
                        while (i24 < length7) {
                            Iterator<f.a.a.a.b.e.b> it7 = zVar.R().iterator();
                            while (true) {
                                if (it7.hasNext()) {
                                    i9 = length7;
                                    f.a.a.a.b.e.b next7 = it7.next();
                                    str6 = str8;
                                    kotlin.m.b.f.d(next7, "idea");
                                    int c5 = next7.c();
                                    str5 = str10;
                                    Object obj7 = j2.get(i24);
                                    jSONArray6 = j2;
                                    if ((obj7 instanceof Integer) && c5 == ((Integer) obj7).intValue()) {
                                        sb.append("<li>");
                                        sb.append(next7.d());
                                        sb.append("</li>");
                                    } else {
                                        str8 = str6;
                                        length7 = i9;
                                        str10 = str5;
                                        j2 = jSONArray6;
                                    }
                                } else {
                                    jSONArray6 = j2;
                                    i9 = length7;
                                    str5 = str10;
                                    str6 = str8;
                                }
                            }
                            i24++;
                            str8 = str6;
                            length7 = i9;
                            str10 = str5;
                            j2 = jSONArray6;
                        }
                        int i25 = 6;
                        JSONArray i26 = o.i(act_sp_view_plan, 6);
                        int length8 = i26.length();
                        int i27 = 0;
                        while (i27 < length8) {
                            Iterator<f.a.a.a.b.e.d> it8 = zVar.Q(i25).iterator();
                            while (true) {
                                if (it8.hasNext()) {
                                    f.a.a.a.b.e.d next8 = it8.next();
                                    kotlin.m.b.f.d(next8, str9);
                                    int c6 = next8.c();
                                    i8 = length8;
                                    Object obj8 = i26.get(i27);
                                    jSONArray5 = i26;
                                    if ((obj8 instanceof Integer) && c6 == ((Integer) obj8).intValue()) {
                                        sb2.append("<li>");
                                        sb2.append(next8.d());
                                        if (next8.e() != null) {
                                            sb2.append(": ");
                                            sb2.append(next8.e());
                                        }
                                        sb2.append("</li>");
                                    } else {
                                        it8 = it8;
                                        length8 = i8;
                                        i26 = jSONArray5;
                                    }
                                } else {
                                    jSONArray5 = i26;
                                    i8 = length8;
                                }
                            }
                            i27++;
                            length8 = i8;
                            i26 = jSONArray5;
                            i25 = 6;
                        }
                        sb.append("</ul>");
                        sb2.append("</ul>");
                        kotlin.m.b.f.d(str7, "basic_template");
                        String sb9 = sb.toString();
                        kotlin.m.b.f.d(sb9, str10);
                        String str12 = n.c(str7, "#STEP6.1_ITEMS#", sb9, false, 4, null);
                        String sb10 = sb2.toString();
                        kotlin.m.b.f.d(sb10, str8);
                        str4 = n.c(str12, "#STEP6.2_ITEMS#", sb10, false, 4, null);
                        str7 = str4;
                        i2 = i3;
                        break;
                    default:
                        aVar = g2;
                        file = file3;
                        i2 = i10;
                        continue;
                }
            } else {
                aVar = g2;
                i2 = i10;
                file = file3;
                if (i2 == 3) {
                    kotlin.m.b.f.d(str7, "basic_template");
                    str = n.c(n.c(str7, "#STEP3.1_ITEMS#", "<i>Not yet completed</i>", false, 4, null), "#STEP3.2_ITEMS#", "<i>Not yet completed</i>", false, 4, null);
                } else if (i2 == 6) {
                    kotlin.m.b.f.d(str7, "basic_template");
                    str = n.c(n.c(str7, "#STEP6.1_ITEMS#", "<i>Not yet completed</i>", false, 4, null), "#STEP6.2_ITEMS#", "<i>Not yet completed</i>", false, 4, null);
                } else {
                    kotlin.m.b.f.d(str7, "basic_template");
                    str = n.c(str7, "#STEP" + i2 + "_ITEMS#", "<i>Not yet completed</i>", false, 4, null);
                }
                str7 = str;
            }
            i10 = i2 + 1;
            act_sp_view_plan = this;
            g2 = aVar;
            file3 = file;
        }
        g2.d(getApplicationContext(), str7, file3);
        Uri z = gov.va.mobilehealth.ncptsd.covid.CComp.j.z(this, file3);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.my_safety_plan));
        intent.putExtra("android.intent.extra.STREAM", z);
        startActivity(Intent.createChooser(intent, getString(R.string.send_safety_plan)));
        gov.va.mobilehealth.ncptsd.covid.CComp.n.a(getApplicationContext());
    }

    public final int Y() {
        return this.w;
    }

    public final void Z() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(this, getString(R.string.do_you_really_want_export_assessment_data));
        h2.k(R.string.go_on, new i(this));
        h2.h(R.string.cancel, j.f10006b);
        h2.a().show();
    }

    public final void a0() {
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = f.a.a.a.b.o.sp_view_plan_step1_txt_name;
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView, "sp_view_plan_step1_txt_name");
        sb.append(appCompatTextView.getText().toString());
        sb.append(" ");
        int i4 = f.a.a.a.b.o.sp_view_plan_step1_txt_step;
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(i4);
        kotlin.m.b.f.d(appCompatTextView2, "sp_view_plan_step1_txt_step");
        sb.append(appCompatTextView2.getText().toString());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        int i5 = f.a.a.a.b.o.sp_view_plan_step2_txt_name;
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(i5);
        kotlin.m.b.f.d(appCompatTextView3, "sp_view_plan_step2_txt_name");
        sb3.append(appCompatTextView3.getText().toString());
        sb3.append(" ");
        int i6 = f.a.a.a.b.o.sp_view_plan_step2_txt_step;
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(i6);
        kotlin.m.b.f.d(appCompatTextView4, "sp_view_plan_step2_txt_step");
        sb3.append(appCompatTextView4.getText().toString());
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        int i7 = f.a.a.a.b.o.sp_view_plan_step3_txt_name;
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) W(i7);
        kotlin.m.b.f.d(appCompatTextView5, "sp_view_plan_step3_txt_name");
        sb5.append(appCompatTextView5.getText().toString());
        sb5.append(" ");
        int i8 = f.a.a.a.b.o.sp_view_plan_step3_txt_step;
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) W(i8);
        kotlin.m.b.f.d(appCompatTextView6, "sp_view_plan_step3_txt_step");
        sb5.append(appCompatTextView6.getText().toString());
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        int i9 = f.a.a.a.b.o.sp_view_plan_step4_txt_name;
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) W(i9);
        kotlin.m.b.f.d(appCompatTextView7, "sp_view_plan_step4_txt_name");
        sb7.append(appCompatTextView7.getText().toString());
        sb7.append(" ");
        int i10 = f.a.a.a.b.o.sp_view_plan_step4_txt_step;
        AppCompatTextView appCompatTextView8 = (AppCompatTextView) W(i10);
        kotlin.m.b.f.d(appCompatTextView8, "sp_view_plan_step4_txt_step");
        sb7.append(appCompatTextView8.getText().toString());
        String sb8 = sb7.toString();
        StringBuilder sb9 = new StringBuilder();
        int i11 = f.a.a.a.b.o.sp_view_plan_step5_txt_name;
        AppCompatTextView appCompatTextView9 = (AppCompatTextView) W(i11);
        kotlin.m.b.f.d(appCompatTextView9, "sp_view_plan_step5_txt_name");
        sb9.append(appCompatTextView9.getText().toString());
        sb9.append(" ");
        int i12 = f.a.a.a.b.o.sp_view_plan_step5_txt_step;
        AppCompatTextView appCompatTextView10 = (AppCompatTextView) W(i12);
        kotlin.m.b.f.d(appCompatTextView10, "sp_view_plan_step5_txt_step");
        sb9.append(appCompatTextView10.getText().toString());
        String sb10 = sb9.toString();
        StringBuilder sb11 = new StringBuilder();
        int i13 = f.a.a.a.b.o.sp_view_plan_step6_txt_name;
        AppCompatTextView appCompatTextView11 = (AppCompatTextView) W(i13);
        kotlin.m.b.f.d(appCompatTextView11, "sp_view_plan_step6_txt_name");
        sb11.append(appCompatTextView11.getText().toString());
        sb11.append(" ");
        int i14 = f.a.a.a.b.o.sp_view_plan_step6_txt_step;
        AppCompatTextView appCompatTextView12 = (AppCompatTextView) W(i14);
        kotlin.m.b.f.d(appCompatTextView12, "sp_view_plan_step6_txt_step");
        sb11.append(appCompatTextView12.getText().toString());
        String sb12 = sb11.toString();
        if (o.r(getApplicationContext(), 1)) {
            int i15 = f.a.a.a.b.o.sp_view_plan_step1_layout;
            i2 = i9;
            ((LinearLayoutTracking) W(i15)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i3)).setTextColor(-1);
            ((AppCompatTextView) W(i4)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking = (LinearLayoutTracking) W(i15);
            kotlin.m.b.f.d(linearLayoutTracking, "sp_view_plan_step1_layout");
            linearLayoutTracking.setContentDescription(sb2 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 1)) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step1_check_img);
                kotlin.m.b.f.d(appCompatImageView, "sp_view_plan_step1_check_img");
                appCompatImageView.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking2 = (LinearLayoutTracking) W(i15);
                kotlin.m.b.f.d(linearLayoutTracking2, "sp_view_plan_step1_layout");
                linearLayoutTracking2.setContentDescription(sb2 + " " + getString(R.string.completed) + " " + getString(R.string.button));
            }
        } else {
            i2 = i9;
            int i16 = f.a.a.a.b.o.sp_view_plan_step1_layout;
            ((LinearLayoutTracking) W(i16)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            ((AppCompatTextView) W(i3)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            ((AppCompatTextView) W(i4)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step1_check_img);
            kotlin.m.b.f.d(appCompatImageView2, "sp_view_plan_step1_check_img");
            appCompatImageView2.setVisibility(4);
            LinearLayoutTracking linearLayoutTracking3 = (LinearLayoutTracking) W(i16);
            kotlin.m.b.f.d(linearLayoutTracking3, "sp_view_plan_step1_layout");
            linearLayoutTracking3.setContentDescription(sb2 + " " + getString(R.string.button));
        }
        if (o.r(getApplicationContext(), 2)) {
            int i17 = f.a.a.a.b.o.sp_view_plan_step2_layout;
            ((LinearLayoutTracking) W(i17)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i5)).setTextColor(-1);
            ((AppCompatTextView) W(i6)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking4 = (LinearLayoutTracking) W(i17);
            kotlin.m.b.f.d(linearLayoutTracking4, "sp_view_plan_step2_layout");
            linearLayoutTracking4.setContentDescription(sb4 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 2)) {
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step2_check_img);
                kotlin.m.b.f.d(appCompatImageView3, "sp_view_plan_step2_check_img");
                appCompatImageView3.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking5 = (LinearLayoutTracking) W(i17);
                kotlin.m.b.f.d(linearLayoutTracking5, "sp_view_plan_step2_layout");
                linearLayoutTracking5.setContentDescription(sb4 + " " + getString(R.string.completed) + " " + getString(R.string.button));
            }
        } else {
            int i18 = f.a.a.a.b.o.sp_view_plan_step2_layout;
            ((LinearLayoutTracking) W(i18)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            ((AppCompatTextView) W(i5)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            ((AppCompatTextView) W(i6)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step2_check_img);
            kotlin.m.b.f.d(appCompatImageView4, "sp_view_plan_step2_check_img");
            appCompatImageView4.setVisibility(4);
            LinearLayoutTracking linearLayoutTracking6 = (LinearLayoutTracking) W(i18);
            kotlin.m.b.f.d(linearLayoutTracking6, "sp_view_plan_step2_layout");
            linearLayoutTracking6.setContentDescription(sb4 + " " + getString(R.string.button));
        }
        if (o.r(getApplicationContext(), 3)) {
            int i19 = f.a.a.a.b.o.sp_view_plan_step3_layout;
            ((LinearLayoutTracking) W(i19)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i7)).setTextColor(-1);
            ((AppCompatTextView) W(i8)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking7 = (LinearLayoutTracking) W(i19);
            kotlin.m.b.f.d(linearLayoutTracking7, "sp_view_plan_step3_layout");
            linearLayoutTracking7.setContentDescription(sb6 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 3)) {
                AppCompatImageView appCompatImageView5 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step3_check_img);
                kotlin.m.b.f.d(appCompatImageView5, "sp_view_plan_step3_check_img");
                appCompatImageView5.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking8 = (LinearLayoutTracking) W(i19);
                kotlin.m.b.f.d(linearLayoutTracking8, "sp_view_plan_step3_layout");
                linearLayoutTracking8.setContentDescription(sb6 + " " + getString(R.string.completed) + " " + getString(R.string.button));
            }
        } else {
            int i20 = f.a.a.a.b.o.sp_view_plan_step3_layout;
            ((LinearLayoutTracking) W(i20)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            ((AppCompatTextView) W(i7)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            ((AppCompatTextView) W(i8)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
            AppCompatImageView appCompatImageView6 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step3_check_img);
            kotlin.m.b.f.d(appCompatImageView6, "sp_view_plan_step3_check_img");
            appCompatImageView6.setVisibility(4);
            LinearLayoutTracking linearLayoutTracking9 = (LinearLayoutTracking) W(i20);
            kotlin.m.b.f.d(linearLayoutTracking9, "sp_view_plan_step3_layout");
            linearLayoutTracking9.setContentDescription(sb6 + " " + getString(R.string.button));
        }
        if (o.r(getApplicationContext(), 4)) {
            int i21 = f.a.a.a.b.o.sp_view_plan_step4_layout;
            ((LinearLayoutTracking) W(i21)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i2)).setTextColor(-1);
            ((AppCompatTextView) W(i10)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking10 = (LinearLayoutTracking) W(i21);
            kotlin.m.b.f.d(linearLayoutTracking10, "sp_view_plan_step4_layout");
            linearLayoutTracking10.setContentDescription(sb8 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 4)) {
                AppCompatImageView appCompatImageView7 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step4_check_img);
                kotlin.m.b.f.d(appCompatImageView7, "sp_view_plan_step4_check_img");
                appCompatImageView7.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking11 = (LinearLayoutTracking) W(i21);
                kotlin.m.b.f.d(linearLayoutTracking11, "sp_view_plan_step4_layout");
                linearLayoutTracking11.setContentDescription(sb8 + " " + getString(R.string.completed) + " " + getString(R.string.button));
            }
        } else {
            int i22 = f.a.a.a.b.o.sp_view_plan_step4_layout;
            ((LinearLayoutTracking) W(i22)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            ((AppCompatTextView) W(i2)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            ((AppCompatTextView) W(i10)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
            AppCompatImageView appCompatImageView8 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step4_check_img);
            kotlin.m.b.f.d(appCompatImageView8, "sp_view_plan_step4_check_img");
            appCompatImageView8.setVisibility(4);
            LinearLayoutTracking linearLayoutTracking12 = (LinearLayoutTracking) W(i22);
            kotlin.m.b.f.d(linearLayoutTracking12, "sp_view_plan_step4_layout");
            linearLayoutTracking12.setContentDescription(sb8 + " " + getString(R.string.button));
        }
        if (o.r(getApplicationContext(), 5)) {
            int i23 = f.a.a.a.b.o.sp_view_plan_step5_layout;
            ((LinearLayoutTracking) W(i23)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i11)).setTextColor(-1);
            ((AppCompatTextView) W(i12)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking13 = (LinearLayoutTracking) W(i23);
            kotlin.m.b.f.d(linearLayoutTracking13, "sp_view_plan_step5_layout");
            linearLayoutTracking13.setContentDescription(sb10 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 5)) {
                AppCompatImageView appCompatImageView9 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step5_check_img);
                kotlin.m.b.f.d(appCompatImageView9, "sp_view_plan_step5_check_img");
                appCompatImageView9.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking14 = (LinearLayoutTracking) W(i23);
                kotlin.m.b.f.d(linearLayoutTracking14, "sp_view_plan_step5_layout");
                linearLayoutTracking14.setContentDescription(sb10 + " " + getString(R.string.completed) + " " + getString(R.string.button));
            }
        } else {
            int i24 = f.a.a.a.b.o.sp_view_plan_step5_layout;
            ((LinearLayoutTracking) W(i24)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
            ((AppCompatTextView) W(i11)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
            ((AppCompatTextView) W(i12)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
            AppCompatImageView appCompatImageView10 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step5_check_img);
            kotlin.m.b.f.d(appCompatImageView10, "sp_view_plan_step5_check_img");
            appCompatImageView10.setVisibility(4);
            LinearLayoutTracking linearLayoutTracking15 = (LinearLayoutTracking) W(i24);
            kotlin.m.b.f.d(linearLayoutTracking15, "sp_view_plan_step5_layout");
            linearLayoutTracking15.setContentDescription(sb10 + " " + getString(R.string.button));
        }
        if (o.r(getApplicationContext(), 6)) {
            int i25 = f.a.a.a.b.o.sp_view_plan_step6_layout;
            ((LinearLayoutTracking) W(i25)).setBackgroundResource(R.drawable.custom_btn_green_very_rounded);
            ((AppCompatTextView) W(i13)).setTextColor(-1);
            ((AppCompatTextView) W(i14)).setTextColor(-1);
            LinearLayoutTracking linearLayoutTracking16 = (LinearLayoutTracking) W(i25);
            kotlin.m.b.f.d(linearLayoutTracking16, "sp_view_plan_step6_layout");
            linearLayoutTracking16.setContentDescription(sb12 + " " + getString(R.string.seen) + " " + getString(R.string.button));
            if (o.p(getApplicationContext(), 6)) {
                AppCompatImageView appCompatImageView11 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step6_check_img);
                kotlin.m.b.f.d(appCompatImageView11, "sp_view_plan_step6_check_img");
                appCompatImageView11.setVisibility(0);
                LinearLayoutTracking linearLayoutTracking17 = (LinearLayoutTracking) W(i25);
                kotlin.m.b.f.d(linearLayoutTracking17, "sp_view_plan_step6_layout");
                linearLayoutTracking17.setContentDescription(sb12 + " " + getString(R.string.completed) + " " + getString(R.string.button));
                return;
            }
            return;
        }
        int i26 = f.a.a.a.b.o.sp_view_plan_step6_layout;
        ((LinearLayoutTracking) W(i26)).setBackgroundResource(R.drawable.custom_btn_white_very_rounded);
        ((AppCompatTextView) W(i13)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_4a));
        ((AppCompatTextView) W(i14)).setTextColor(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
        AppCompatImageView appCompatImageView12 = (AppCompatImageView) W(f.a.a.a.b.o.sp_view_plan_step6_check_img);
        kotlin.m.b.f.d(appCompatImageView12, "sp_view_plan_step6_check_img");
        appCompatImageView12.setVisibility(4);
        LinearLayoutTracking linearLayoutTracking18 = (LinearLayoutTracking) W(i26);
        kotlin.m.b.f.d(linearLayoutTracking18, "sp_view_plan_step6_layout");
        linearLayoutTracking18.setContentDescription(sb12 + " " + getString(R.string.button));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        kotlin.m.b.f.e(context, "base");
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    public void finish() {
        gov.va.mobilehealth.ncptsd.covid.CComp.n.h(getApplicationContext(), TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.x));
        super.finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_sp_view_plan);
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step1_layout)).setOnClickListener(new a(this));
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step2_layout)).setOnClickListener(new b(this));
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step3_layout)).setOnClickListener(new c(this));
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step4_layout)).setOnClickListener(new d(this));
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step5_layout)).setOnClickListener(new e(this));
        ((LinearLayoutTracking) W(f.a.a.a.b.o.sp_view_plan_step6_layout)).setOnClickListener(new f(this));
        ((ImageViewTracking) W(f.a.a.a.b.o.sp_view_plan_img_share)).setOnClickListener(new g(this));
        ((AppCompatButton) W(f.a.a.a.b.o.sp_view_plan_btn_national_suicide)).setOnClickListener(new h(this));
        this.x = System.currentTimeMillis();
        T((Toolbar) W(f.a.a.a.b.o.sp_view_plan_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.x(true);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.s(true);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.m.b.f.e(strArr, "permissions");
        kotlin.m.b.f.e(iArr, "grantResults");
        if (i2 == this.w) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                Z();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, vainstrum.Components.a
    public void onResume() {
        a0();
        super.onResume();
    }
}
