package gov.va.mobilehealth.ncptsd.covid.CComp;

import androidx.constraintlayout.widget.i;
import com.github.mikephil.charting.R;
import java.io.File;

/* compiled from: CONF */
public class g {
    public static String A = "covid_tutorial.json";
    public static String A0 = "mood_check";
    public static String B = "distress_meter_text.txt";
    public static String B0 = "find_resources";
    public static String C = "distress_meter_text_popup.txt";
    public static String C0 = "manage_stress";
    public static String D = "calm_chime.mp3";
    public static String E = "send_feedback.json";
    public static String F = "send_feedback2.json";
    public static String G = "share_app.json";
    public static String H = "i_messages_intro.json";
    public static String I = "my_strenght_intro.json";
    public static String J = "intro_my_feelings.json";
    public static String K = "rgb_intro.json";
    public static String L = "appreciation_intro.json";
    public static String M = "find_resources_states.json";
    public static String N = "how_to_use.json";
    public static String O = "privacy_policy.json";
    public static String P = null;
    public static String Q = null;
    public static String R = null;
    public static String S = null;
    public static String T = "time_alone";
    public static String U = "kids";
    public static String V = "partner";
    public static int W = 4000;
    public static String X = "text";
    public static String Y = "memo";
    public static String Z = "music";

    /* renamed from: a  reason: collision with root package name */
    public static String f10081a = "spanish_content";
    public static String a0 = "photo";

    /* renamed from: b  reason: collision with root package name */
    public static String f10082b = "learn";
    public static String b0 = "video";

    /* renamed from: c  reason: collision with root package name */
    public static String f10083c = "assessment";
    public static String c0 = "assessment_feedback_";

    /* renamed from: d  reason: collision with root package name */
    public static String f10084d = "other_assessments";
    public static String d0 = "0_";

    /* renamed from: e  reason: collision with root package name */
    public static String f10085e = "manage";
    public static String e0 = "1_15_";

    /* renamed from: f  reason: collision with root package name */
    public static String f10086f;
    public static String f0 = "16_32_";

    /* renamed from: g  reason: collision with root package name */
    public static String f10087g = "help";
    public static String g0 = "33_80_";

    /* renamed from: h  reason: collision with root package name */
    public static String f10088h = "about";
    public static String h0 = "first.txt";

    /* renamed from: i  reason: collision with root package name */
    public static String f10089i;
    public static String i0 = "decreased.txt";

    /* renamed from: j  reason: collision with root package name */
    public static String f10090j;
    public static String j0 = "no_change.txt";

    /* renamed from: k  reason: collision with root package name */
    public static String f10091k;
    public static String k0 = "increased.txt";
    public static String l;
    public static String l0;
    public static String m;
    public static String m0;
    public static String n = "tones";
    public static String n0;
    public static String o = "safety_plan";
    public static String o0;
    public static String p;
    public static final Integer[] p0 = {2, 3, 4, 5, 6, 7, 1};
    public static String q = "license.txt";
    public static final String[] q0 = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static String r = "assessment_help.json";
    public static final String[] r0 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "Last day"};
    public static String s = "manage_help.json";
    public static final String[] s0 = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    public static String t = "text_header_crisis_resource.json";
    public static final String[] t0 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "Último día"};
    public static String u = "find_professional_care.json";
    public static final int[] u0 = {2, 5, 11, 15, 17, 18, 19, 20, 21, 22, 23, 24, 31, 48, 49, 50, 51, 57, 58, 59, 60, 61, 62, 63, 64, 65, i.E0, i.F0, 106, i.G0, i.H0};
    public static String v = "grow_your_support.json";
    public static String v0 = "notone";
    public static String w = "questions.json";
    public static final Integer[] w0 = {Integer.valueOf((int) R.drawable.si_default_1), Integer.valueOf((int) R.drawable.si_default_2), Integer.valueOf((int) R.drawable.si_default_3), Integer.valueOf((int) R.drawable.si_default_4), Integer.valueOf((int) R.drawable.si_default_5), Integer.valueOf((int) R.drawable.si_default_6), Integer.valueOf((int) R.drawable.si_default_7)};
    public static String x = "symptoms.json";
    public static final String[] x0 = {"img_alt1", "img_alt2", "img_alt3", "img_alt4", "img_alt5", "img_alt6", "img_alt7"};
    public static String y = "tools.json";
    public static final Integer[] y0 = {35, 38, 40, 44, 7, 47, 8, 9, 10, 21, 22, 23, 11, 15, 31, 17, 48, 18, 19, 57, 58, 59, 60, 61, 62, 63, 64, 65};
    public static String z = "tools_clustered.json";
    public static String z0 = "learn";

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("manage");
        String str = File.separator;
        sb.append(str);
        sb.append("tools_intro");
        f10086f = sb.toString();
        f10089i = f10085e + str + "tools";
        f10090j = f10089i + str + "texts";
        f10091k = f10085e + str + "tools" + str + "family_audio";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f10085e);
        sb2.append(str);
        sb2.append("audio");
        l = sb2.toString();
        m = f10081a + str + f10085e + str + "audio";
        p = "safety_plan" + str + "guns_safety" + str;
        P = f10087g + str + "winding_down_help.txt";
        Q = f10087g + str + "activities_keep_awake_help.txt";
        R = f10087g + str + "activities_cant_sleep_help.txt";
        S = f10087g + str + "activities_help_wakeup_help.txt";
        l0 = "help" + str + "im_affect_help.json";
        m0 = "help" + str + "im_feel_help.json";
        n0 = "help" + str + "im_because_help.json";
        o0 = "help" + str + "n_str_help.json";
    }
}
