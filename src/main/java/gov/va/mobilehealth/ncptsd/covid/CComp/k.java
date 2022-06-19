package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.e;
import f.a.a.a.b.d.i;
import f.a.a.a.b.d.j;
import f.a.a.a.b.d.p;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.m.b.d;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: C_FKT.kt */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10124a = new a(null);

    /* compiled from: C_FKT.kt */
    public static final class a {

        /* access modifiers changed from: package-private */
        /* renamed from: gov.va.mobilehealth.ncptsd.covid.CComp.k$a$a  reason: collision with other inner class name */
        /* compiled from: C_FKT.kt */
        public static final class DialogInterface$OnClickListenerC0229a implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Activity f10125b;

            DialogInterface$OnClickListenerC0229a(Activity activity) {
                this.f10125b = activity;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a aVar = k.f10124a;
                Context applicationContext = this.f10125b.getApplicationContext();
                f.d(applicationContext, "activity.applicationContext");
                if (aVar.l(applicationContext) == 2) {
                    Context applicationContext2 = this.f10125b.getApplicationContext();
                    f.d(applicationContext2, "activity.applicationContext");
                    aVar.r(applicationContext2);
                }
                Context applicationContext3 = this.f10125b.getApplicationContext();
                f.d(applicationContext3, "activity.applicationContext");
                aVar.s(applicationContext3);
                Context applicationContext4 = this.f10125b.getApplicationContext();
                f.d(applicationContext4, "activity.applicationContext");
                aVar.t(applicationContext4);
                dialogInterface.dismiss();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: C_FKT.kt */
        public static final class b implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Activity f10126b;

            b(Activity activity) {
                this.f10126b = activity;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a aVar = k.f10124a;
                Context applicationContext = this.f10126b.getApplicationContext();
                f.d(applicationContext, "activity.applicationContext");
                aVar.r(applicationContext);
                j.M(this.f10126b, "https://redcap.stanford.edu/surveys/?s=NPH4YWATPM");
                dialogInterface.dismiss();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: C_FKT.kt */
        public static final class c implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Activity f10127b;

            c(Activity activity) {
                this.f10127b = activity;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a aVar = k.f10124a;
                Context applicationContext = this.f10127b.getApplicationContext();
                f.d(applicationContext, "activity.applicationContext");
                aVar.r(applicationContext);
                dialogInterface.dismiss();
            }
        }

        private a() {
        }

        public final void a(Context context) {
            f.e(context, "context");
            int i2 = j.s(context).getInt("nsessions", 0);
            SharedPreferences.Editor u = j.u(context);
            f.c(u);
            u.putInt("nsessions", i2 + 1).apply();
        }

        public final Uri b(Activity activity, u uVar) {
            IOException e2;
            f.e(activity, "activity");
            f.e(uVar, "helper");
            try {
                String[] strArr = {"Date", "GAD1", "GAD2", "GAD3", "GAD4", "GAD5", "GAD6", "GAD7", "Total Score"};
                File externalFilesDir = activity.getExternalFilesDir(null);
                f.c(externalFilesDir);
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, f.a(b0.a(Act_home.U), "es") ? "Seguimiento_de_ansiedad_GAD7_COVIDCoach_" + j.l() + ".csv" : "TrackAnxiety_GAD7_COVIDCoach_" + j.l() + ".csv");
                if (file.exists()) {
                    file.delete();
                }
                ArrayList<f.a.a.a.b.d.b> n0 = uVar.n0(411);
                au.com.bytecode.opencsv.a aVar = new au.com.bytecode.opencsv.a(new FileWriter(file));
                ArrayList arrayList = new ArrayList();
                arrayList.add(strArr);
                f.d(n0, "assessments");
                int size = n0.size();
                char c2 = 0;
                int i2 = 0;
                while (i2 < size) {
                    f.a.a.a.b.d.b bVar = n0.get(i2);
                    f.d(bVar, "assess");
                    int size2 = bVar.d().size() + 2;
                    String[] strArr2 = new String[size2];
                    for (int i3 = 0; i3 < size2; i3++) {
                        strArr2[i3] = BuildConfig.FLAVOR;
                    }
                    try {
                        String g2 = g(bVar.a());
                        f.c(g2);
                        strArr2[c2] = g2;
                        ArrayList<p> d2 = bVar.d();
                        int size3 = d2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            int i5 = i4 + 1;
                            p pVar = d2.get(i4);
                            f.d(pVar, "qPoints[j]");
                            strArr2[i5] = String.valueOf(pVar.a());
                            i4 = i5;
                        }
                        strArr2[bVar.d().size() + 1] = String.valueOf(bVar.c());
                        arrayList.add(strArr2);
                        i2++;
                        c2 = 0;
                    } catch (IOException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        return null;
                    }
                }
                aVar.F(arrayList);
                aVar.close();
                return b.h.d.b.e(activity, activity.getPackageName() + ".provider", file);
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return null;
            }
        }

        public final Uri c(Activity activity, v vVar) {
            IOException e2;
            f.e(activity, "activity");
            f.e(vVar, "helper");
            try {
                String[] strArr = {"Goal Text", "Date", "Progress"};
                File externalFilesDir = activity.getExternalFilesDir(null);
                f.c(externalFilesDir);
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, "SetAGoal_COVIDCoach_" + j.l() + ".csv");
                if (file.exists()) {
                    file.delete();
                }
                ArrayList<i> J = vVar.J();
                au.com.bytecode.opencsv.a aVar = new au.com.bytecode.opencsv.a(new FileWriter(file));
                ArrayList arrayList = new ArrayList();
                arrayList.add(strArr);
                int size = J.size();
                char c2 = 0;
                int i2 = 0;
                while (i2 < size) {
                    i iVar = J.get(i2);
                    f.d(iVar, "goalData[i]");
                    i iVar2 = iVar;
                    ArrayList<j> f2 = iVar2.f();
                    f.c(f2);
                    int size2 = f2.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        String[] strArr2 = new String[3];
                        for (int i4 = 0; i4 < 3; i4++) {
                            strArr2[i4] = BuildConfig.FLAVOR;
                        }
                        if (i3 == 0) {
                            strArr2[c2] = iVar2.a();
                        } else {
                            strArr2[c2] = BuildConfig.FLAVOR;
                        }
                        ArrayList<j> f3 = iVar2.f();
                        f.c(f3);
                        try {
                            String h2 = h(f3.get(i3).a());
                            f.c(h2);
                            strArr2[1] = h2;
                            StringBuilder sb = new StringBuilder();
                            ArrayList<j> f4 = iVar2.f();
                            f.c(f4);
                            sb.append(String.valueOf(f4.get(i3).c()));
                            sb.append("%");
                            strArr2[2] = sb.toString();
                            arrayList.add(strArr2);
                            i3++;
                            c2 = 0;
                        } catch (IOException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    i2++;
                    c2 = 0;
                }
                aVar.F(arrayList);
                aVar.close();
                return b.h.d.b.e(activity, activity.getPackageName() + ".provider", file);
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return null;
            }
        }

        public final Uri d(Activity activity, u uVar) {
            IOException e2;
            f.e(activity, "activity");
            f.e(uVar, "helper");
            try {
                String[] strArr = {"Date", "PHQ1", "PHQ2", "PHQ3", "PHQ4", "PHQ5", "PHQ6", "PHQ7", "PHQ8", "PHQ9", "Total Score"};
                File externalFilesDir = activity.getExternalFilesDir(null);
                f.c(externalFilesDir);
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, f.a(b0.a(Act_home.U), "es") ? "Seguimiento_de_animo_PHQ9_COVIDCoach_" + j.l() + ".csv" : "TrackMood_PHQ9_COVIDCoach_" + j.l() + ".csv");
                if (file.exists()) {
                    file.delete();
                }
                ArrayList<f.a.a.a.b.d.b> n0 = uVar.n0(b.a.j.D0);
                au.com.bytecode.opencsv.a aVar = new au.com.bytecode.opencsv.a(new FileWriter(file));
                ArrayList arrayList = new ArrayList();
                arrayList.add(strArr);
                f.d(n0, "assessments");
                int size = n0.size();
                char c2 = 0;
                int i2 = 0;
                while (i2 < size) {
                    f.a.a.a.b.d.b bVar = n0.get(i2);
                    f.d(bVar, "assess");
                    int size2 = bVar.d().size() + 2;
                    String[] strArr2 = new String[size2];
                    for (int i3 = 0; i3 < size2; i3++) {
                        strArr2[i3] = BuildConfig.FLAVOR;
                    }
                    try {
                        String g2 = g(bVar.a());
                        f.c(g2);
                        strArr2[c2] = g2;
                        ArrayList<p> d2 = bVar.d();
                        int size3 = d2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            int i5 = i4 + 1;
                            p pVar = d2.get(i4);
                            f.d(pVar, "qPoints[j]");
                            strArr2[i5] = String.valueOf(pVar.a());
                            i4 = i5;
                        }
                        strArr2[bVar.d().size() + 1] = String.valueOf(bVar.c());
                        arrayList.add(strArr2);
                        i2++;
                        c2 = 0;
                    } catch (IOException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        return null;
                    }
                }
                aVar.F(arrayList);
                aVar.close();
                return b.h.d.b.e(activity, activity.getPackageName() + ".provider", file);
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return null;
            }
        }

        public final Uri e(Activity activity, u uVar) {
            IOException e2;
            f.e(activity, "activity");
            f.e(uVar, "helper");
            try {
                String[] strArr = {"Date", "WEMWBS1", "WEMWBS2", "WEMWBS3", "WEMWBS4", "WEMWBS5", "WEMWBS6", "WEMWBS7", "WEMWBS8", "WEMWBS9", "WEMWBS10", "WEMWBS11", "WEMWBS12", "WEMWBS13", "WEMWBS14", "Total Score"};
                File externalFilesDir = activity.getExternalFilesDir(null);
                f.c(externalFilesDir);
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, f.a(b0.a(Act_home.U), "es") ? "Seguimiento_de_bienestar_WEMWBS_COVIDCoach_" + j.l() + ".csv" : "TrackWellBeing_WEMWBS_COVIDCoach_" + j.l() + ".csv");
                if (file.exists()) {
                    file.delete();
                }
                ArrayList<f.a.a.a.b.d.b> n0 = uVar.n0(224);
                au.com.bytecode.opencsv.a aVar = new au.com.bytecode.opencsv.a(new FileWriter(file));
                ArrayList arrayList = new ArrayList();
                arrayList.add(strArr);
                f.d(n0, "assessments");
                int size = n0.size();
                char c2 = 0;
                int i2 = 0;
                while (i2 < size) {
                    f.a.a.a.b.d.b bVar = n0.get(i2);
                    f.d(bVar, "assess");
                    int size2 = bVar.d().size() + 2;
                    String[] strArr2 = new String[size2];
                    for (int i3 = 0; i3 < size2; i3++) {
                        strArr2[i3] = BuildConfig.FLAVOR;
                    }
                    try {
                        String g2 = g(bVar.a());
                        f.c(g2);
                        strArr2[c2] = g2;
                        ArrayList<p> d2 = bVar.d();
                        int size3 = d2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            int i5 = i4 + 1;
                            p pVar = d2.get(i4);
                            f.d(pVar, "qPoints[j]");
                            strArr2[i5] = String.valueOf(pVar.a());
                            i4 = i5;
                        }
                        strArr2[bVar.d().size() + 1] = String.valueOf(bVar.c());
                        arrayList.add(strArr2);
                        i2++;
                        c2 = 0;
                    } catch (IOException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        return null;
                    }
                }
                aVar.F(arrayList);
                aVar.close();
                return b.h.d.b.e(activity, activity.getPackageName() + ".provider", file);
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                return null;
            }
        }

        public final void f(Activity activity, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            Uri h2;
            Uri d2;
            Uri b2;
            Uri e2;
            Uri c2;
            f.e(activity, "activity");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            u uVar = new u(activity);
            v vVar = new v(activity);
            if (z && vVar.M() && (c2 = c(activity, vVar)) != null) {
                arrayList.add(c2);
            }
            if (z2 && m.d0(activity, 224) && (e2 = e(activity, uVar)) != null) {
                arrayList.add(e2);
            }
            if (z3 && m.d0(activity, 411) && (b2 = b(activity, uVar)) != null) {
                arrayList.add(b2);
            }
            if (z4 && m.d0(activity, b.a.j.D0) && (d2 = d(activity, uVar)) != null) {
                arrayList.add(d2);
            }
            if (z5 && m.d0(activity, b.a.j.I0) && (h2 = m.h(activity, uVar)) != null) {
                arrayList.add(h2);
            }
            if (!arrayList.isEmpty()) {
                Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.setType("message/rfc822");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                intent.putExtra("android.intent.extra.SUBJECT", "COVID Coach Data");
                intent.putExtra("android.intent.extra.TEXT", activity.getString(R.string.ptsd_assessments));
                activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.send_assessment_via_email)));
                return;
            }
            j.V(activity, activity.getString(R.string.to_export_need_to_do_assessment));
        }

        public final String g(long j2) {
            return j2 != -1 ? new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(j2)) : BuildConfig.FLAVOR;
        }

        public final String h(long j2) {
            if (j2 == -1) {
                return BuildConfig.FLAVOR;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d, yyy", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm aa", Locale.getDefault());
            return simpleDateFormat.format(Long.valueOf(j2)) + " at " + simpleDateFormat2.format(Long.valueOf(j2));
        }

        public final boolean i(Context context) {
            f.e(context, "context");
            return j.s(context).getBoolean("can_feedback_dialog_be_shown", true);
        }

        public final String j(long j2) {
            Calendar instance = Calendar.getInstance();
            f.d(instance, "calendar");
            instance.setTimeInMillis(j2);
            String num = Integer.toString(instance.get(1));
            f.d(num, "Integer.toString(calendar.get(Calendar.YEAR))");
            String format = new SimpleDateFormat("MMMM").format(instance.getTime());
            String num2 = Integer.toString(instance.get(5));
            f.d(num2, "Integer.toString(calenda…t(Calendar.DAY_OF_MONTH))");
            return format + ' ' + num2 + ' ' + num;
        }

        public final long k(Context context) {
            f.e(context, "context");
            SharedPreferences s = j.s(context);
            f.c(s);
            return s.getLong("maybe_feedback_time", -1);
        }

        public final int l(Context context) {
            f.e(context, "context");
            return j.s(context).getInt("maybe_times", 0);
        }

        public final int m(Context context) {
            f.e(context, "context");
            return j.s(context).getInt("nsessions", 0);
        }

        public final ArrayList<e> n(Context context) {
            f.e(context, "context");
            ArrayList<e> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(j.N(context, g.A));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String str = null;
                String string = j.F(jSONObject, "text") ? jSONObject.getString("text") : null;
                if (j.F(jSONObject, "img")) {
                    str = jSONObject.getString("img");
                }
                arrayList.add(new e(string, str));
            }
            return arrayList;
        }

        public final void o(Activity activity) {
            f.e(activity, "activity");
            Context applicationContext = activity.getApplicationContext();
            f.d(applicationContext, "activity.applicationContext");
            if (i(applicationContext)) {
                Context applicationContext2 = activity.getApplicationContext();
                f.d(applicationContext2, "activity.applicationContext");
                long k2 = k(applicationContext2);
                Context applicationContext3 = activity.getApplicationContext();
                f.d(applicationContext3, "activity.applicationContext");
                int m = m(applicationContext3);
                Context applicationContext4 = activity.getApplicationContext();
                f.d(applicationContext4, "activity.applicationContext");
                int l = l(applicationContext4);
                if (l == 1) {
                    if (m >= 6) {
                        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - k2) >= 1) {
                            u(activity, false);
                        }
                    }
                } else if (l == 2) {
                    if (m >= 10) {
                        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - k2) >= ((long) 7)) {
                            u(activity, true);
                        }
                    }
                } else if (m == 4) {
                    u(activity, false);
                }
            }
        }

        public final boolean p(int i2) {
            for (int i3 : g.u0) {
                if (i2 == i3) {
                    return true;
                }
            }
            return false;
        }

        public final boolean q(int i2) {
            if (i2 == 11 || i2 == 15) {
                return true;
            }
            if (17 <= i2 && 19 >= i2) {
                return true;
            }
            if ((21 <= i2 && 23 >= i2) || i2 == 31) {
                return true;
            }
            if (48 > i2 || 51 < i2) {
                return 57 <= i2 && 65 >= i2;
            }
            return true;
        }

        public final void r(Context context) {
            f.e(context, "context");
            j.u(context).putBoolean("can_feedback_dialog_be_shown", false).apply();
        }

        public final void s(Context context) {
            f.e(context, "context");
            SharedPreferences.Editor u = j.u(context);
            f.c(u);
            u.putLong("maybe_feedback_time", System.currentTimeMillis()).apply();
        }

        public final void t(Context context) {
            f.e(context, "context");
            int i2 = j.s(context).getInt("maybe_times", 0);
            SharedPreferences.Editor u = j.u(context);
            f.c(u);
            u.putInt("maybe_times", i2 + 1).apply();
        }

        public final void u(Activity activity, boolean z) {
            f.e(activity, "activity");
            b.a h2 = j.h(activity, activity.getString(R.string.would_like_help_make_better));
            h2.m(R.string.please_share_feedback);
            h2.k(R.string.yes_excl, new b(activity));
            h2.h(R.string.no_dont_ask_me_again, new c(activity));
            if (!z) {
                h2.i(R.string.maybe_ask_me_later, new DialogInterface$OnClickListenerC0229a(activity));
            }
            androidx.appcompat.app.b a2 = h2.a();
            f.d(a2, "builder.create()");
            a2.show();
            Button e2 = a2.e(-2);
            f.d(e2, "dialog.getButton(AlertDialog.BUTTON_NEGATIVE)");
            ViewGroup.LayoutParams layoutParams = e2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = -1;
            e2.setGravity(8388613);
            e2.setLayoutParams(layoutParams2);
            if (!z) {
                Button e3 = a2.e(-3);
                f.d(e3, "dialog.getButton(AlertDialog.BUTTON_NEUTRAL)");
                ViewGroup.LayoutParams layoutParams3 = e3.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                layoutParams4.width = -1;
                e3.setGravity(8388613);
                e3.setLayoutParams(layoutParams4);
            }
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }
}
