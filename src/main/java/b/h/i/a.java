package b.h.i;

import android.text.SpannableStringBuilder;
import com.github.mikephil.charting.BuildConfig;
import java.util.Locale;

/* compiled from: BidiFormatter */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    static final d f2543d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f2544e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    private static final String f2545f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    static final a f2546g;

    /* renamed from: h  reason: collision with root package name */
    static final a f2547h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2548a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2549b;

    /* renamed from: c  reason: collision with root package name */
    private final d f2550c;

    /* renamed from: b.h.i.a$a  reason: collision with other inner class name */
    /* compiled from: BidiFormatter */
    public static final class C0043a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2551a;

        /* renamed from: b  reason: collision with root package name */
        private int f2552b;

        /* renamed from: c  reason: collision with root package name */
        private d f2553c;

        public C0043a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            return z ? a.f2547h : a.f2546g;
        }

        private void c(boolean z) {
            this.f2551a = z;
            this.f2553c = a.f2543d;
            this.f2552b = 2;
        }

        public a a() {
            if (this.f2552b == 2 && this.f2553c == a.f2543d) {
                return b(this.f2551a);
            }
            return new a(this.f2551a, this.f2552b, this.f2553c);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: BidiFormatter */
    public static class b {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f2554f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f2555a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2556b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2557c;

        /* renamed from: d  reason: collision with root package name */
        private int f2558d;

        /* renamed from: e  reason: collision with root package name */
        private char f2559e;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f2554f[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f2555a = charSequence;
            this.f2556b = z;
            this.f2557c = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < 1792 ? f2554f[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i2 = this.f2558d;
            do {
                int i3 = this.f2558d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2555a;
                int i4 = i3 - 1;
                this.f2558d = i4;
                charAt = charSequence.charAt(i4);
                this.f2559e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f2558d = i2;
            this.f2559e = ';';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f2558d;
                if (i2 >= this.f2557c) {
                    return 12;
                }
                CharSequence charSequence = this.f2555a;
                this.f2558d = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f2559e = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char charAt;
            int i2 = this.f2558d;
            while (true) {
                int i3 = this.f2558d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2555a;
                int i4 = i3 - 1;
                this.f2558d = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f2559e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f2558d;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2555a;
                        int i6 = i5 - 1;
                        this.f2558d = i6;
                        charAt = charSequence2.charAt(i6);
                        this.f2559e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f2558d = i2;
            this.f2559e = '>';
            return 13;
        }

        private byte i() {
            char charAt;
            int i2 = this.f2558d;
            while (true) {
                int i3 = this.f2558d;
                if (i3 < this.f2557c) {
                    CharSequence charSequence = this.f2555a;
                    this.f2558d = i3 + 1;
                    char charAt2 = charSequence.charAt(i3);
                    this.f2559e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i4 = this.f2558d;
                            if (i4 >= this.f2557c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2555a;
                            this.f2558d = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f2559e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f2558d = i2;
                    this.f2559e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            char charAt = this.f2555a.charAt(this.f2558d - 1);
            this.f2559e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f2555a, this.f2558d);
                this.f2558d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2558d--;
            byte c2 = c(this.f2559e);
            if (!this.f2556b) {
                return c2;
            }
            char c3 = this.f2559e;
            if (c3 == '>') {
                return h();
            }
            return c3 == ';' ? f() : c2;
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            char charAt = this.f2555a.charAt(this.f2558d);
            this.f2559e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f2555a, this.f2558d);
                this.f2558d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2558d++;
            byte c2 = c(this.f2559e);
            if (!this.f2556b) {
                return c2;
            }
            char c3 = this.f2559e;
            if (c3 == '<') {
                return i();
            }
            return c3 == '&' ? g() : c2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            this.f2558d = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f2558d < this.f2557c && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                break;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                break;
                            case 18:
                                i4--;
                                i3 = 0;
                                break;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f2558d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            this.f2558d = this.f2557c;
            int i2 = 0;
            int i3 = 0;
            while (this.f2558d > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i3 != 0) {
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i3 == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i3 == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i3 != 0) {
                                    break;
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == 0) {
                    return -1;
                } else {
                    if (i3 != 0) {
                    }
                }
                i3 = i2;
            }
            return 0;
        }
    }

    static {
        d dVar = e.f2575c;
        f2543d = dVar;
        f2546g = new a(false, 2, dVar);
        f2547h = new a(true, 2, dVar);
    }

    a(boolean z, int i2, d dVar) {
        this.f2548a = z;
        this.f2549b = i2;
        this.f2550c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0043a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f2548a && (a2 || b(charSequence) == 1)) {
            return f2544e;
        }
        if (this.f2548a) {
            return (!a2 || b(charSequence) == -1) ? f2545f : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f2548a && (a2 || a(charSequence) == 1)) {
            return f2544e;
        }
        if (this.f2548a) {
            return (!a2 || a(charSequence) == -1) ? f2545f : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }

    public boolean d() {
        return (this.f2549b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f2550c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a2 ? e.f2574b : e.f2573a));
        }
        if (a2 != this.f2548a) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a2 ? e.f2574b : e.f2573a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f2550c, true);
    }

    public String k(String str, d dVar, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z).toString();
    }
}
