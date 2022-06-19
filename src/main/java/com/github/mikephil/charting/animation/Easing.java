package com.github.mikephil.charting.animation;

import com.github.mikephil.charting.utils.Utils;

public class Easing {

    /* renamed from: com.github.mikephil.charting.animation.Easing$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
            // Method dump skipped, instructions count: 337
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.animation.Easing.AnonymousClass1.<clinit>():void");
        }
    }

    private static class EasingFunctions {
        public static final EasingFunction EaseInBack = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass23 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2 * f2 * ((f2 * 2.70158f) - 1.70158f);
            }
        };
        public static final EasingFunction EaseInBounce = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass26 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return 1.0f - EasingFunctions.EaseOutBounce.getInterpolation(1.0f - f2);
            }
        };
        public static final EasingFunction EaseInCirc = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass17 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return -(((float) Math.sqrt((double) (1.0f - (f2 * f2)))) - 1.0f);
            }
        };
        public static final EasingFunction EaseInCubic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass5 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2 * f2 * f2;
            }
        };
        public static final EasingFunction EaseInElastic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass20 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 == Utils.FLOAT_EPSILON) {
                    return Utils.FLOAT_EPSILON;
                }
                if (f2 == 1.0f) {
                    return 1.0f;
                }
                float f3 = f2 - 1.0f;
                double asin = (double) (f3 - (0.047746483f * ((float) Math.asin(1.0d))));
                Double.isNaN(asin);
                double d2 = (double) 0.3f;
                Double.isNaN(d2);
                return -(((float) Math.pow(2.0d, (double) (10.0f * f3))) * ((float) Math.sin((asin * 6.283185307179586d) / d2)));
            }
        };
        public static final EasingFunction EaseInExpo = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass14 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2 == Utils.FLOAT_EPSILON ? Utils.FLOAT_EPSILON : (float) Math.pow(2.0d, (double) ((f2 - 1.0f) * 10.0f));
            }
        };
        public static final EasingFunction EaseInOutBack = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass25 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 / 0.5f;
                if (f3 < 1.0f) {
                    return f3 * f3 * ((3.5949094f * f3) - 2.5949094f) * 0.5f;
                }
                float f4 = f3 - 2.0f;
                return ((f4 * f4 * ((3.5949094f * f4) + 2.5949094f)) + 2.0f) * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutBounce = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass28 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 < 0.5f) {
                    return EasingFunctions.EaseInBounce.getInterpolation(f2 * 2.0f) * 0.5f;
                }
                return (EasingFunctions.EaseOutBounce.getInterpolation((f2 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
            }
        };
        public static final EasingFunction EaseInOutCirc = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass19 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float sqrt;
                float f3 = 0.5f;
                float f4 = f2 / 0.5f;
                if (f4 < 1.0f) {
                    f3 = -0.5f;
                    sqrt = ((float) Math.sqrt((double) (1.0f - (f4 * f4)))) - 1.0f;
                } else {
                    float f5 = f4 - 2.0f;
                    sqrt = ((float) Math.sqrt((double) (1.0f - (f5 * f5)))) + 1.0f;
                }
                return sqrt * f3;
            }
        };
        public static final EasingFunction EaseInOutCubic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass7 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 / 0.5f;
                if (f3 < 1.0f) {
                    return 0.5f * f3 * f3 * f3;
                }
                float f4 = f3 - 2.0f;
                return ((f4 * f4 * f4) + 2.0f) * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutElastic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass22 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 == Utils.FLOAT_EPSILON) {
                    return Utils.FLOAT_EPSILON;
                }
                float f3 = f2 / 0.5f;
                if (f3 == 2.0f) {
                    return 1.0f;
                }
                float asin = 0.07161973f * ((float) Math.asin(1.0d));
                if (f3 < 1.0f) {
                    float f4 = f3 - 1.0f;
                    double d2 = (double) ((f4 * 1.0f) - asin);
                    Double.isNaN(d2);
                    double d3 = (double) 0.45000002f;
                    Double.isNaN(d3);
                    return ((float) Math.pow(2.0d, (double) (10.0f * f4))) * ((float) Math.sin((d2 * 6.283185307179586d) / d3)) * -0.5f;
                }
                float f5 = f3 - 1.0f;
                double d4 = (double) ((f5 * 1.0f) - asin);
                Double.isNaN(d4);
                double d5 = (double) 0.45000002f;
                Double.isNaN(d5);
                return (((float) Math.pow(2.0d, (double) (-10.0f * f5))) * ((float) Math.sin((d4 * 6.283185307179586d) / d5)) * 0.5f) + 1.0f;
            }
        };
        public static final EasingFunction EaseInOutExpo = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass16 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3;
                if (f2 == Utils.FLOAT_EPSILON) {
                    return Utils.FLOAT_EPSILON;
                }
                if (f2 == 1.0f) {
                    return 1.0f;
                }
                float f4 = f2 / 0.5f;
                if (f4 < 1.0f) {
                    f3 = (float) Math.pow(2.0d, (double) ((f4 - 1.0f) * 10.0f));
                } else {
                    f3 = (-((float) Math.pow(2.0d, (double) ((f4 - 1.0f) * -10.0f)))) + 2.0f;
                }
                return f3 * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutQuad = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass4 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 / 0.5f;
                if (f3 < 1.0f) {
                    return 0.5f * f3 * f3;
                }
                float f4 = f3 - 1.0f;
                return ((f4 * (f4 - 2.0f)) - 1.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInOutQuart = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass10 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 / 0.5f;
                if (f3 < 1.0f) {
                    return 0.5f * f3 * f3 * f3 * f3;
                }
                float f4 = f3 - 2.0f;
                return ((((f4 * f4) * f4) * f4) - 2.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInOutSine = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass13 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                double d2 = (double) f2;
                Double.isNaN(d2);
                return (((float) Math.cos(d2 * 3.141592653589793d)) - 1.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInQuad = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass2 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2 * f2;
            }
        };
        public static final EasingFunction EaseInQuart = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass8 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2;
            }
        };
        public static final EasingFunction EaseInSine = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass11 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                double d2 = (double) f2;
                Double.isNaN(d2);
                return (-((float) Math.cos(d2 * 1.5707963267948966d))) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutBack = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass24 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * ((f3 * 2.70158f) + 1.70158f)) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutBounce = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass27 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 < 0.36363637f) {
                    return 7.5625f * f2 * f2;
                }
                if (f2 < 0.72727275f) {
                    float f3 = f2 - 0.54545456f;
                    return (7.5625f * f3 * f3) + 0.75f;
                } else if (f2 < 0.90909094f) {
                    float f4 = f2 - 0.8181818f;
                    return (7.5625f * f4 * f4) + 0.9375f;
                } else {
                    float f5 = f2 - 0.95454544f;
                    return (7.5625f * f5 * f5) + 0.984375f;
                }
            }
        };
        public static final EasingFunction EaseOutCirc = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass18 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (float) Math.sqrt((double) (1.0f - (f3 * f3)));
            }
        };
        public static final EasingFunction EaseOutCubic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass6 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutElastic = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass21 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 == Utils.FLOAT_EPSILON) {
                    return Utils.FLOAT_EPSILON;
                }
                if (f2 == 1.0f) {
                    return 1.0f;
                }
                double asin = (double) (f2 - (0.047746483f * ((float) Math.asin(1.0d))));
                Double.isNaN(asin);
                double d2 = (double) 0.3f;
                Double.isNaN(d2);
                return (((float) Math.pow(2.0d, (double) (-10.0f * f2))) * ((float) Math.sin((asin * 6.283185307179586d) / d2))) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutExpo = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass15 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                if (f2 == 1.0f) {
                    return 1.0f;
                }
                return -((float) Math.pow(2.0d, (double) ((f2 + 1.0f) * -10.0f)));
            }
        };
        public static final EasingFunction EaseOutQuad = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass3 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return (-f2) * (f2 - 2.0f);
            }
        };
        public static final EasingFunction EaseOutQuart = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass9 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return -((((f3 * f3) * f3) * f3) - 1.0f);
            }
        };
        public static final EasingFunction EaseOutSine = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass12 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                double d2 = (double) f2;
                Double.isNaN(d2);
                return (float) Math.sin(d2 * 1.5707963267948966d);
            }
        };
        public static final EasingFunction Linear = new EasingFunction() {
            /* class com.github.mikephil.charting.animation.Easing.EasingFunctions.AnonymousClass1 */

            @Override // com.github.mikephil.charting.animation.EasingFunction
            public float getInterpolation(float f2) {
                return f2;
            }
        };

        private EasingFunctions() {
        }
    }

    public enum EasingOption {
        Linear,
        EaseInQuad,
        EaseOutQuad,
        EaseInOutQuad,
        EaseInCubic,
        EaseOutCubic,
        EaseInOutCubic,
        EaseInQuart,
        EaseOutQuart,
        EaseInOutQuart,
        EaseInSine,
        EaseOutSine,
        EaseInOutSine,
        EaseInExpo,
        EaseOutExpo,
        EaseInOutExpo,
        EaseInCirc,
        EaseOutCirc,
        EaseInOutCirc,
        EaseInElastic,
        EaseOutElastic,
        EaseInOutElastic,
        EaseInBack,
        EaseOutBack,
        EaseInOutBack,
        EaseInBounce,
        EaseOutBounce,
        EaseInOutBounce
    }

    public static EasingFunction getEasingFunctionFromOption(EasingOption easingOption) {
        switch (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption[easingOption.ordinal()]) {
            case 2:
                return EasingFunctions.EaseInQuad;
            case 3:
                return EasingFunctions.EaseOutQuad;
            case 4:
                return EasingFunctions.EaseInOutQuad;
            case 5:
                return EasingFunctions.EaseInCubic;
            case 6:
                return EasingFunctions.EaseOutCubic;
            case 7:
                return EasingFunctions.EaseInOutCubic;
            case 8:
                return EasingFunctions.EaseInQuart;
            case 9:
                return EasingFunctions.EaseOutQuart;
            case 10:
                return EasingFunctions.EaseInOutQuart;
            case 11:
                return EasingFunctions.EaseInSine;
            case 12:
                return EasingFunctions.EaseOutSine;
            case 13:
                return EasingFunctions.EaseInOutSine;
            case 14:
                return EasingFunctions.EaseInExpo;
            case 15:
                return EasingFunctions.EaseOutExpo;
            case 16:
                return EasingFunctions.EaseInOutExpo;
            case 17:
                return EasingFunctions.EaseInCirc;
            case 18:
                return EasingFunctions.EaseOutCirc;
            case 19:
                return EasingFunctions.EaseInOutCirc;
            case 20:
                return EasingFunctions.EaseInElastic;
            case 21:
                return EasingFunctions.EaseOutElastic;
            case 22:
                return EasingFunctions.EaseInOutElastic;
            case 23:
                return EasingFunctions.EaseInBack;
            case 24:
                return EasingFunctions.EaseOutBack;
            case 25:
                return EasingFunctions.EaseInOutBack;
            case 26:
                return EasingFunctions.EaseInBounce;
            case 27:
                return EasingFunctions.EaseOutBounce;
            case 28:
                return EasingFunctions.EaseInOutBounce;
            default:
                return EasingFunctions.Linear;
        }
    }
}
