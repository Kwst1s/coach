package com.google.android.vending.licensing;

import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import java.util.regex.Pattern;

/* compiled from: ResponseData */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f8268a;

    /* renamed from: b  reason: collision with root package name */
    public int f8269b;

    /* renamed from: c  reason: collision with root package name */
    public String f8270c;

    /* renamed from: d  reason: collision with root package name */
    public String f8271d;

    /* renamed from: e  reason: collision with root package name */
    public String f8272e;

    /* renamed from: f  reason: collision with root package name */
    public long f8273f;

    /* renamed from: g  reason: collision with root package name */
    public String f8274g;

    public static l a(String str) {
        int indexOf = str.indexOf(58);
        String str2 = BuildConfig.FLAVOR;
        if (-1 != indexOf) {
            String substring = str.substring(0, indexOf);
            if (indexOf < str.length()) {
                str2 = str.substring(indexOf + 1);
            }
            str = substring;
        }
        String[] split = TextUtils.split(str, Pattern.quote("|"));
        if (split.length >= 6) {
            l lVar = new l();
            lVar.f8274g = str2;
            lVar.f8268a = Integer.parseInt(split[0]);
            lVar.f8269b = Integer.parseInt(split[1]);
            lVar.f8270c = split[2];
            lVar.f8271d = split[3];
            lVar.f8272e = split[4];
            lVar.f8273f = Long.parseLong(split[5]);
            return lVar;
        }
        throw new IllegalArgumentException("Wrong number of fields.");
    }

    public String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.f8268a), Integer.valueOf(this.f8269b), this.f8270c, this.f8271d, this.f8272e, Long.valueOf(this.f8273f)});
    }
}
