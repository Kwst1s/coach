package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import b.a.j;
import f.a.a.a.b.a.a;
import f.a.a.a.b.a.b;
import f.a.a.a.b.d.r;
import gov.va.mobilehealth.ncptsd.covid.CComp.c0;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverAnxiety;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverGoal;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverPTSDSymptoms;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverQuotes;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverTool;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverTrackMood;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverWellBeing;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverWindingDown;
import gov.va.mobilehealth.ncptsd.covid.ReceiversBroad.AlarmReceiverWorryTime;
import java.util.Calendar;

/* compiled from: C_F_Reminders */
public class q {

    /* compiled from: C_F_Reminders */
    static class a implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10136b;

        a(View view) {
            this.f10136b = view;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            s.a(this.f10136b);
        }
    }

    /* compiled from: C_F_Reminders */
    static class b implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10137b;

        b(View view) {
            this.f10137b = view;
        }

        public void onCancel(DialogInterface dialogInterface) {
            s.a(this.f10137b);
        }
    }

    /* compiled from: C_F_Reminders */
    static class c implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10138b;

        c(View view) {
            this.f10138b = view;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            s.a(this.f10138b);
        }
    }

    /* compiled from: C_F_Reminders */
    static class d implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10139b;

        d(View view) {
            this.f10139b = view;
        }

        public void onCancel(DialogInterface dialogInterface) {
            s.a(this.f10139b);
        }
    }

    /* compiled from: C_F_Reminders */
    static class e implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10140b;

        e(View view) {
            this.f10140b = view;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            s.a(this.f10140b);
        }
    }

    /* compiled from: C_F_Reminders */
    static class f implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f10141b;

        f(View view) {
            this.f10141b = view;
        }

        public void onCancel(DialogInterface dialogInterface) {
            s.a(this.f10141b);
        }
    }

    public static void A(Activity activity, String str, View view, int i2, c0.g gVar, a.i iVar) {
        if (s.m(activity)) {
            f.a.a.a.b.a.a aVar = new f.a.a.a.b.a.a(activity);
            if (b0.a(activity).equals("es")) {
                aVar.e(str, i2, 7, g.s0, iVar, false);
            } else {
                aVar.e(str, i2, 7, g.q0, iVar, false);
            }
            aVar.setOnDismissListener(new a(view));
            aVar.setOnCancelListener(new b(view));
            aVar.show();
            return;
        }
        c0 c0Var = new c0(activity);
        if (b0.a(activity).equals("es")) {
            c0Var.c(i2, 6, g.s0, gVar);
        } else {
            c0Var.c(i2, 6, g.q0, gVar);
        }
        c0Var.setOnDismissListener(new c(view));
        c0Var.setOnCancelListener(new d(view));
        c0Var.show();
    }

    public static void B(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_anxiety", true).commit();
            long c2 = c(context, "reminder_anxiety_time");
            String string = j.s(context).getString("reminder_anxiety_frequency", "weekly");
            if (c2 == -1) {
                Calendar instance = Calendar.getInstance();
                c2 = v(instance.get(7), instance.getTimeInMillis());
                j.u(context).putLong("reminder_anxiety_time", c2).commit();
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance2.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance2.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 200, AlarmReceiverAnxiety.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_anxiety", false).commit();
        a(context, "reminder_anxiety", 200, AlarmReceiverAnxiety.class);
    }

    public static void C(Context context, boolean z) {
        if (z) {
            j.u(context).putBoolean("reminder_quote", true).commit();
            long c2 = c(context, "reminder_quote_time");
            if (c2 == -1) {
                Calendar d2 = s.d();
                d2.set(11, 10);
                d2.set(12, 0);
                d2.set(13, 0);
                d2.set(14, 0);
                d2.set(7, 2);
                c2 = s(d2.getTimeInMillis());
                j.u(context).putLong("reminder_quote_time", c2).commit();
            }
            Calendar.getInstance().setTimeInMillis(c2);
            q(context, s(c2), j.G0, AlarmReceiverQuotes.class, true);
            return;
        }
        j.u(context).putBoolean("reminder_quote", false).commit();
        a(context, "reminder_quote", j.G0, AlarmReceiverQuotes.class);
    }

    public static void D(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_goal", true).commit();
            long c2 = c(context, "reminder_goal_time");
            String string = j.s(context).getString("reminder_goal_frequency", "daily");
            if (c2 == -1) {
                Calendar instance = Calendar.getInstance();
                c2 = v(instance.get(7), instance.getTimeInMillis());
                j.u(context).putLong("reminder_goal_time", c2).commit();
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance2.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance2.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 154, AlarmReceiverGoal.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_goal", false).commit();
        a(context, "reminder_goal", 154, AlarmReceiverGoal.class);
    }

    public static void E(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_ptsd_symptoms", true).commit();
            long c2 = c(context, "reminder_ptsd_symptoms_time");
            String string = j.s(context).getString("reminder_ptsd_symptoms_frequency", "weekly");
            if (c2 == -1) {
                Calendar instance = Calendar.getInstance();
                c2 = v(instance.get(7), instance.getTimeInMillis());
                j.u(context).putLong("reminder_ptsd_symptoms_time", c2).commit();
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance2.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance2.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 154, AlarmReceiverPTSDSymptoms.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_ptsd_symptoms", false).commit();
        a(context, "reminder_ptsd_symptoms", 154, AlarmReceiverPTSDSymptoms.class);
    }

    public static void F(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_try_tool_mood", true).commit();
            long c2 = c(context, "reminder_try_tool_time");
            String string = j.s(context).getString("reminder_try_tool_frequency", "daily");
            if (c2 == -1) {
                Calendar d2 = s.d();
                d2.set(11, 10);
                d2.set(12, 0);
                d2.set(13, 0);
                d2.set(14, 0);
                d2.set(7, 2);
                c2 = s(d2.getTimeInMillis());
                j.u(context).putLong("reminder_try_tool_time", c2).commit();
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 211, AlarmReceiverTool.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_try_tool_mood", false).commit();
        a(context, "reminder_try_tool_mood", 211, AlarmReceiverTool.class);
    }

    public static void G(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_track_mood", true).commit();
            long c2 = c(context, "reminder_track_mood_time");
            String string = j.s(context).getString("reminder_track_mood_frequency", "weekly");
            if (c2 == -1) {
                Calendar instance = Calendar.getInstance();
                c2 = v(instance.get(7), instance.getTimeInMillis());
                j.u(context).putLong("reminder_track_mood_time", c2).commit();
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance2.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance2.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 201, AlarmReceiverTrackMood.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_track_mood", false).commit();
        a(context, "reminder_track_mood", 201, AlarmReceiverTrackMood.class);
    }

    public static void H(Context context, boolean z, String str) {
        long s;
        if (z) {
            j.u(context).putBoolean("reminder_well_being", true).commit();
            long c2 = c(context, "reminder_well_being_time");
            String string = j.s(context).getString("reminder_well_being_frequency", "weekly");
            if (c2 == -1) {
                Calendar instance = Calendar.getInstance();
                c2 = v(instance.get(7), instance.getTimeInMillis());
                j.u(context).putLong("reminder_well_being_time", c2).commit();
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(c2);
            if (string.equals("weekly")) {
                s = v(instance2.get(7), c2);
            } else if (string.equals("monthly")) {
                s = t(context, instance2.get(5), c2, str);
            } else {
                s = s(c2);
            }
            q(context, s, 199, AlarmReceiverWellBeing.class, false);
            return;
        }
        j.u(context).putBoolean("reminder_well_being", false).commit();
        a(context, "reminder_well_being", 199, AlarmReceiverWellBeing.class);
    }

    public static void I(Context context, boolean z) {
        if (z) {
            j.u(context).putBoolean("winding_down_reminder", true).commit();
            long c2 = c(context, "winding_down_reminder_time");
            if (c2 == -1) {
                Calendar d2 = s.d();
                d2.set(11, 10);
                d2.set(12, 0);
                d2.set(13, 0);
                d2.set(14, 0);
                d2.set(7, 2);
                c2 = s(d2.getTimeInMillis());
                j.u(context).putLong("winding_down_reminder_time", c2).commit();
            }
            Calendar.getInstance().setTimeInMillis(c2);
            q(context, s(c2), j.G0, AlarmReceiverWindingDown.class, false);
            return;
        }
        j.u(context).putBoolean("winding_down_reminder", false).commit();
        a(context, "winding_down_reminder", 112, AlarmReceiverWorryTime.class);
    }

    public static void J(Context context, boolean z) {
        if (z) {
            j.u(context).putBoolean("worry_time_reminder", true).commit();
            long c2 = c(context, "worry_time_reminder_time");
            if (c2 == -1) {
                Calendar d2 = s.d();
                d2.set(11, 10);
                d2.set(12, 0);
                d2.set(13, 0);
                d2.set(14, 0);
                d2.set(7, 2);
                c2 = s(d2.getTimeInMillis());
                j.u(context).putLong("worry_time_reminder_time", c2).commit();
            }
            Calendar.getInstance().setTimeInMillis(c2);
            q(context, s(c2), 112, AlarmReceiverWorryTime.class, false);
            return;
        }
        j.u(context).putBoolean("worry_time_reminder", false).commit();
        a(context, "worry_time_reminder", 112, AlarmReceiverWorryTime.class);
    }

    public static void a(Context context, String str, int i2, Class cls) {
        j.u(context).putBoolean(str, false).apply();
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, i2, new Intent(context, cls), 134217728));
    }

    private static boolean b(Calendar calendar, Calendar calendar2) {
        return calendar.getTimeInMillis() - calendar2.getTimeInMillis() > 0;
    }

    public static long c(Context context, String str) {
        return j.s(context).getLong(str, -1);
    }

    public static boolean d(Context context) {
        return j.s(context).getBoolean("reminder_anxiety", false);
    }

    public static boolean e(Context context) {
        return j.s(context).getBoolean("reminder_quote", false);
    }

    public static boolean f(Context context) {
        return j.s(context).getBoolean("reminder_goal", false);
    }

    public static boolean g(Context context) {
        if (j.s(context).contains("reminder_ptsd_symptoms")) {
            if (!(j.s(context).getAll().get("reminder_ptsd_symptoms") instanceof String)) {
                return j.s(context).getBoolean("reminder_ptsd_symptoms", false);
            }
            E(context, true, "ptsd_symptoms_lastday");
        }
        return false;
    }

    public static boolean h(Context context) {
        return j.s(context).getBoolean("reminder_try_tool_mood", false);
    }

    public static boolean i(Context context) {
        return j.s(context).getBoolean("reminder_track_mood", false);
    }

    public static boolean j(Context context) {
        return j.s(context).getBoolean("reminder_well_being", false);
    }

    public static boolean k(Context context) {
        return j.s(context).getBoolean("winding_down_reminder", false);
    }

    public static boolean l(Context context) {
        return j.s(context).getBoolean("worry_time_reminder", false);
    }

    private static void q(Context context, long j2, int i2, Class cls, boolean z) {
        Intent intent = new Intent(context, cls);
        if (z) {
            r q = m.q(context);
            intent.putExtra("message", q.c());
            intent.putExtra("index", q.a());
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.setExact(0, j2, broadcast);
    }

    public static long r(int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, i2);
        instance2.set(12, i3);
        instance2.set(13, 0);
        if (!b(instance2, instance)) {
            instance2.add(5, 1);
        }
        instance2.set(13, 0);
        instance2.set(14, 0);
        return instance2.getTimeInMillis();
    }

    public static long s(long j2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        int i2 = instance2.get(11);
        int i3 = instance2.get(12);
        instance3.set(11, i2);
        instance3.set(12, i3);
        instance3.set(13, 0);
        instance3.set(14, 0);
        if (!b(instance3, instance)) {
            instance3.add(5, 1);
        }
        return instance3.getTimeInMillis();
    }

    public static long t(Context context, int i2, long j2, String str) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        int i3 = instance2.get(11);
        int i4 = instance2.get(12);
        boolean t = j.t(context, str, false);
        if (t) {
            instance3.set(5, instance3.getActualMaximum(5));
        } else {
            instance3.set(5, i2);
        }
        instance3.set(11, i3);
        instance3.set(12, i4);
        instance3.set(13, 0);
        instance3.set(14, 0);
        if (!b(instance3, instance)) {
            instance3.add(2, 1);
            if (t) {
                instance3.set(5, instance3.getActualMaximum(5));
            } else {
                instance3.set(5, i2);
            }
        }
        return instance3.getTimeInMillis();
    }

    public static long u(Context context, long j2, int i2, int i3, String str) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        boolean t = j.t(context, str, false);
        instance2.set(11, i2);
        instance2.set(12, i3);
        instance2.set(13, 0);
        if (!b(instance2, instance)) {
            instance2.add(2, 1);
            if (t) {
                instance2.set(5, instance2.getActualMaximum(5));
            } else {
                instance2.set(5, instance2.get(5));
            }
        }
        instance2.set(13, 0);
        instance2.set(14, 0);
        return instance2.getTimeInMillis();
    }

    public static long v(int i2, long j2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        int i3 = instance2.get(11);
        int i4 = instance2.get(12);
        instance3.set(7, i2);
        instance3.set(11, i3);
        instance3.set(12, i4);
        instance3.set(13, 0);
        instance3.set(14, 0);
        if (!b(instance3, instance)) {
            instance3.add(4, 1);
        }
        return instance3.getTimeInMillis();
    }

    public static long w(long j2, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        instance2.set(11, i2);
        instance2.set(12, i3);
        instance2.set(13, 0);
        if (!b(instance2, instance)) {
            instance2.add(5, 7);
        }
        instance2.set(13, 0);
        instance2.set(14, 0);
        return instance2.getTimeInMillis();
    }

    public static void x(Context context, String str, long j2) {
        j.u(context).putLong(str, j2).commit();
    }

    public static void y(Activity activity, String str, View view, int i2, a.i iVar) {
        f.a.a.a.b.a.a aVar = new f.a.a.a.b.a.a(activity);
        if (b0.a(activity).equals("es")) {
            aVar.e(str, i2, 29, g.t0, iVar, true);
        } else {
            aVar.e(str, i2, 29, g.r0, iVar, true);
        }
        aVar.setOnDismissListener(new e(view));
        aVar.setOnCancelListener(new f(view));
        aVar.show();
    }

    public static void z(Activity activity, String str, View view, TimePickerDialog.OnTimeSetListener onTimeSetListener, b.f fVar, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        int i3 = instance.get(12);
        if (s.m(activity)) {
            f.a.a.a.b.a.b bVar = new f.a.a.a.b.a.b(activity);
            bVar.g(str, j2, fVar);
            bVar.setOnDismissListener(new e(view));
            bVar.setOnCancelListener(new b(view));
            bVar.show();
            return;
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, onTimeSetListener, i2, i3, false);
        timePickerDialog.setOnDismissListener(new c(view));
        timePickerDialog.setOnCancelListener(new d(view));
        timePickerDialog.show();
    }
}
