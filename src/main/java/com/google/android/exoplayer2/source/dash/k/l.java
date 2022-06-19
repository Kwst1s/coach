package com.google.android.exoplayer2.source.dash.k;

import com.github.mikephil.charting.BuildConfig;
import java.util.Locale;

/* compiled from: UrlTemplate */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f6310a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f6311b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f6312c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6313d;

    private l(String[] strArr, int[] iArr, String[] strArr2, int i2) {
        this.f6310a = strArr;
        this.f6311b = iArr;
        this.f6312c = strArr2;
        this.f6313d = i2;
    }

    public static l b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new l(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    private static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = BuildConfig.FLAVOR;
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            char c2 = 65535;
            if (indexOf == -1) {
                strArr[i3] = strArr[i3] + str.substring(i2);
                i2 = str.length();
            } else if (indexOf != i2) {
                strArr[i3] = strArr[i3] + str.substring(i2, indexOf);
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                strArr[i3] = strArr[i3] + "$";
                i2 += 2;
            } else {
                int i4 = i2 + 1;
                int indexOf2 = str.indexOf("$", i4);
                String substring = str.substring(i4, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i3] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            iArr[i3] = 2;
                            break;
                        case 1:
                            iArr[i3] = 4;
                            break;
                        case 2:
                            iArr[i3] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i3] = str2;
                }
                i3++;
                strArr[i3] = BuildConfig.FLAVOR;
                i2 = indexOf2 + 1;
            }
        }
        return i3;
    }

    public String a(String str, long j2, int i2, long j3) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.f6313d;
            if (i3 < i4) {
                sb.append(this.f6310a[i3]);
                int[] iArr = this.f6311b;
                if (iArr[i3] == 1) {
                    sb.append(str);
                } else if (iArr[i3] == 2) {
                    sb.append(String.format(Locale.US, this.f6312c[i3], Long.valueOf(j2)));
                } else if (iArr[i3] == 3) {
                    sb.append(String.format(Locale.US, this.f6312c[i3], Integer.valueOf(i2)));
                } else if (iArr[i3] == 4) {
                    sb.append(String.format(Locale.US, this.f6312c[i3], Long.valueOf(j3)));
                }
                i3++;
            } else {
                sb.append(this.f6310a[i4]);
                return sb.toString();
            }
        }
    }
}
