package com.google.android.exoplayer2.text.p;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: TtmlRenderUtil */
public final class d {
    public static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, e eVar) {
        if (eVar.h() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(eVar.h()), i2, i3, 33);
        }
        if (eVar.m()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (eVar.n()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (eVar.k()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(eVar.c()), i2, i3, 33);
        }
        if (eVar.j()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(eVar.b()), i2, i3, 33);
        }
        if (eVar.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(eVar.d()), i2, i3, 33);
        }
        if (eVar.i() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(eVar.i()), i2, i3, 33);
        }
        int f2 = eVar.f();
        if (f2 == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) eVar.e(), true), i2, i3, 33);
        } else if (f2 == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.e()), i2, i3, 33);
        } else if (f2 == 3) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.e() / 100.0f), i2, i3, 33);
        }
    }

    static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    public static e d(e eVar, String[] strArr, Map<String, e> map) {
        if (eVar == null && strArr == null) {
            return null;
        }
        int i2 = 0;
        if (eVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (eVar == null && strArr.length > 1) {
            e eVar2 = new e();
            int length = strArr.length;
            while (i2 < length) {
                eVar2.a(map.get(strArr[i2]));
                i2++;
            }
            return eVar2;
        } else if (eVar == null || strArr == null || strArr.length != 1) {
            if (!(eVar == null || strArr == null || strArr.length <= 1)) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    eVar.a(map.get(strArr[i2]));
                    i2++;
                }
            }
            return eVar;
        } else {
            eVar.a(map.get(strArr[0]));
            return eVar;
        }
    }
}
