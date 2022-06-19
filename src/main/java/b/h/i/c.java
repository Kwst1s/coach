package b.h.i;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* compiled from: PrecomputedTextCompat */
public class c implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    private final Spannable f2562b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2563c;

    /* renamed from: d  reason: collision with root package name */
    private final PrecomputedText f2564d;

    public a a() {
        return this.f2563c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f2562b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i2) {
        return this.f2562b.charAt(i2);
    }

    public int getSpanEnd(Object obj) {
        return this.f2562b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2562b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f2562b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f2564d.getSpans(i2, i3, cls) : (T[]) this.f2562b.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.f2562b.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2562b.nextSpanTransition(i2, i3, cls);
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2564d.removeSpan(obj);
        } else {
            this.f2562b.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2564d.setSpan(obj, i2, i3, i4);
        } else {
            this.f2562b.setSpan(obj, i2, i3, i4);
        }
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.f2562b.subSequence(i2, i3);
    }

    public String toString() {
        return this.f2562b.toString();
    }

    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f2565a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f2566b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2567c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2568d;

        /* renamed from: b.h.i.c$a$a  reason: collision with other inner class name */
        /* compiled from: PrecomputedTextCompat */
        public static class C0044a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f2569a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f2570b;

            /* renamed from: c  reason: collision with root package name */
            private int f2571c;

            /* renamed from: d  reason: collision with root package name */
            private int f2572d;

            public C0044a(TextPaint textPaint) {
                this.f2569a = textPaint;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    this.f2571c = 1;
                    this.f2572d = 1;
                } else {
                    this.f2572d = 0;
                    this.f2571c = 0;
                }
                if (i2 >= 18) {
                    this.f2570b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2570b = null;
                }
            }

            public a a() {
                return new a(this.f2569a, this.f2570b, this.f2571c, this.f2572d);
            }

            public C0044a b(int i2) {
                this.f2571c = i2;
                return this;
            }

            public C0044a c(int i2) {
                this.f2572d = i2;
                return this;
            }

            public C0044a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2570b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            }
            this.f2565a = textPaint;
            this.f2566b = textDirectionHeuristic;
            this.f2567c = i2;
            this.f2568d = i3;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f2567c != aVar.b() || this.f2568d != aVar.c())) || this.f2565a.getTextSize() != aVar.e().getTextSize() || this.f2565a.getTextScaleX() != aVar.e().getTextScaleX() || this.f2565a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i2 >= 21 && (this.f2565a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f2565a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f2565a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f2565a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i2 >= 17 && !this.f2565a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f2565a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2565a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f2567c;
        }

        public int c() {
            return this.f2568d;
        }

        public TextDirectionHeuristic d() {
            return this.f2566b;
        }

        public TextPaint e() {
            return this.f2565a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f2566b == aVar.d();
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return b.h.j.c.b(Float.valueOf(this.f2565a.getTextSize()), Float.valueOf(this.f2565a.getTextScaleX()), Float.valueOf(this.f2565a.getTextSkewX()), Float.valueOf(this.f2565a.getLetterSpacing()), Integer.valueOf(this.f2565a.getFlags()), this.f2565a.getTextLocales(), this.f2565a.getTypeface(), Boolean.valueOf(this.f2565a.isElegantTextHeight()), this.f2566b, Integer.valueOf(this.f2567c), Integer.valueOf(this.f2568d));
            } else if (i2 >= 21) {
                return b.h.j.c.b(Float.valueOf(this.f2565a.getTextSize()), Float.valueOf(this.f2565a.getTextScaleX()), Float.valueOf(this.f2565a.getTextSkewX()), Float.valueOf(this.f2565a.getLetterSpacing()), Integer.valueOf(this.f2565a.getFlags()), this.f2565a.getTextLocale(), this.f2565a.getTypeface(), Boolean.valueOf(this.f2565a.isElegantTextHeight()), this.f2566b, Integer.valueOf(this.f2567c), Integer.valueOf(this.f2568d));
            } else if (i2 >= 18) {
                return b.h.j.c.b(Float.valueOf(this.f2565a.getTextSize()), Float.valueOf(this.f2565a.getTextScaleX()), Float.valueOf(this.f2565a.getTextSkewX()), Integer.valueOf(this.f2565a.getFlags()), this.f2565a.getTextLocale(), this.f2565a.getTypeface(), this.f2566b, Integer.valueOf(this.f2567c), Integer.valueOf(this.f2568d));
            } else if (i2 >= 17) {
                return b.h.j.c.b(Float.valueOf(this.f2565a.getTextSize()), Float.valueOf(this.f2565a.getTextScaleX()), Float.valueOf(this.f2565a.getTextSkewX()), Integer.valueOf(this.f2565a.getFlags()), this.f2565a.getTextLocale(), this.f2565a.getTypeface(), this.f2566b, Integer.valueOf(this.f2567c), Integer.valueOf(this.f2568d));
            } else {
                return b.h.j.c.b(Float.valueOf(this.f2565a.getTextSize()), Float.valueOf(this.f2565a.getTextScaleX()), Float.valueOf(this.f2565a.getTextSkewX()), Integer.valueOf(this.f2565a.getFlags()), this.f2565a.getTypeface(), this.f2566b, Integer.valueOf(this.f2567c), Integer.valueOf(this.f2568d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2565a.getTextSize());
            sb.append(", textScaleX=" + this.f2565a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2565a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                sb.append(", letterSpacing=" + this.f2565a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2565a.isElegantTextHeight());
            }
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f2565a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.f2565a.getTextLocale());
            }
            sb.append(", typeface=" + this.f2565a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.f2565a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2566b);
            sb.append(", breakStrategy=" + this.f2567c);
            sb.append(", hyphenationFrequency=" + this.f2568d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f2565a = params.getTextPaint();
            this.f2566b = params.getTextDirection();
            this.f2567c = params.getBreakStrategy();
            this.f2568d = params.getHyphenationFrequency();
            int i2 = Build.VERSION.SDK_INT;
        }
    }
}
