package b.k.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: ExifInterface */
public class a {
    private static final c A = new c("StripOffsets", 273, 3);
    private static final c[] B;
    private static final c[] C;
    private static final c[] D;
    private static final c[] E;
    static final c[][] F;
    private static final c[] G = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private static final HashMap<Integer, c>[] H;
    private static final HashMap<String, c>[] I;
    private static final HashSet<String> J = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private static final HashMap<Integer, Integer> K = new HashMap<>();
    static final Charset L;
    static final byte[] M;
    public static final int[] m = {8, 8, 8};
    public static final int[] n = {8};
    static final byte[] o = {-1, -40, -1};
    private static final byte[] p = {79, 76, 89, 77, 80, 0};
    private static final byte[] q = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat r;
    static final String[] s = {BuildConfig.FLAVOR, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] t = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] u = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final c[] v;
    private static final c[] w;
    private static final c[] x;
    private static final c[] y;
    private static final c[] z;

    /* renamed from: a  reason: collision with root package name */
    private final String f2747a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager.AssetInputStream f2748b;

    /* renamed from: c  reason: collision with root package name */
    private int f2749c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, b>[] f2750d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Integer> f2751e;

    /* renamed from: f  reason: collision with root package name */
    private ByteOrder f2752f = ByteOrder.BIG_ENDIAN;

    /* renamed from: g  reason: collision with root package name */
    private int f2753g;

    /* renamed from: h  reason: collision with root package name */
    private int f2754h;

    /* renamed from: i  reason: collision with root package name */
    private int f2755i;

    /* renamed from: j  reason: collision with root package name */
    private int f2756j;

    /* renamed from: k  reason: collision with root package name */
    private int f2757k;
    private int l;

    /* access modifiers changed from: private */
    /* compiled from: ExifInterface */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2764a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2765b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f2766c;

        b(int i2, int i3, byte[] bArr) {
            this.f2764a = i2;
            this.f2765b = i3;
            this.f2766c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.L);
            return new b(2, bytes.length, bytes);
        }

        public static b b(long j2, ByteOrder byteOrder) {
            return c(new long[]{j2}, byteOrder);
        }

        public static b c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.t[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b d(d dVar, ByteOrder byteOrder) {
            return e(new d[]{dVar}, byteOrder);
        }

        public static b e(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.t[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (d dVar : dVarArr) {
                wrap.putInt((int) dVar.f2771a);
                wrap.putInt((int) dVar.f2772b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        public static b f(int i2, ByteOrder byteOrder) {
            return g(new int[]{i2}, byteOrder);
        }

        public static b g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.t[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (k2 instanceof String) {
                return Double.parseDouble((String) k2);
            } else {
                if (k2 instanceof long[]) {
                    long[] jArr = (long[]) k2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof int[]) {
                    int[] iArr = (int[]) k2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof double[]) {
                    double[] dArr = (double[]) k2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof d[]) {
                    d[] dVarArr = (d[]) k2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int i(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (k2 instanceof String) {
                return Integer.parseInt((String) k2);
            } else {
                if (k2 instanceof long[]) {
                    long[] jArr = (long[]) k2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof int[]) {
                    int[] iArr = (int[]) k2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String j(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                return null;
            }
            if (k2 instanceof String) {
                return (String) k2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (k2 instanceof long[]) {
                long[] jArr = (long[]) k2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k2 instanceof int[]) {
                int[] iArr = (int[]) k2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k2 instanceof double[]) {
                double[] dArr = (double[]) k2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(k2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) k2;
                while (i2 < dVarArr.length) {
                    sb.append(dVarArr[i2].f2771a);
                    sb.append('/');
                    sb.append(dVarArr[i2].f2772b);
                    i2++;
                    if (i2 != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x0196 A[SYNTHETIC, Splitter:B:138:0x0196] */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x01a3 A[SYNTHETIC, Splitter:B:146:0x01a3] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object k(java.nio.ByteOrder r11) {
            /*
            // Method dump skipped, instructions count: 458
            */
            throw new UnsupportedOperationException("Method not decompiled: b.k.a.a.b.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + a.s[this.f2764a] + ", data length:" + this.f2766c.length + ")";
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExifInterface */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f2771a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2772b;

        d(long j2, long j3) {
            if (j3 == 0) {
                this.f2771a = 0;
                this.f2772b = 1;
                return;
            }
            this.f2771a = j2;
            this.f2772b = j3;
        }

        public double a() {
            double d2 = (double) this.f2771a;
            double d3 = (double) this.f2772b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f2771a + "/" + this.f2772b;
        }
    }

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        v = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        w = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        x = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        y = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        z = cVarArr5;
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        B = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        C = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        D = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        E = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        F = cVarArr10;
        H = new HashMap[cVarArr10.length];
        I = new HashMap[cVarArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        L = forName;
        M = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        r = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr11 = F;
            if (i2 < cVarArr11.length) {
                H[i2] = new HashMap<>();
                I[i2] = new HashMap<>();
                c[] cVarArr12 = cVarArr11[i2];
                for (c cVar : cVarArr12) {
                    H[i2].put(Integer.valueOf(cVar.f2767a), cVar);
                    I[i2].put(cVar.f2768b, cVar);
                }
                i2++;
            } else {
                HashMap<Integer, Integer> hashMap = K;
                c[] cVarArr13 = G;
                hashMap.put(Integer.valueOf(cVarArr13[0].f2767a), 5);
                hashMap.put(Integer.valueOf(cVarArr13[1].f2767a), 1);
                hashMap.put(Integer.valueOf(cVarArr13[2].f2767a), 2);
                hashMap.put(Integer.valueOf(cVarArr13[3].f2767a), 3);
                hashMap.put(Integer.valueOf(cVarArr13[4].f2767a), 7);
                hashMap.put(Integer.valueOf(cVarArr13[5].f2767a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    public a(String str) {
        Throwable th;
        c[][] cVarArr = F;
        this.f2750d = new HashMap[cVarArr.length];
        this.f2751e = new HashSet(cVarArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f2748b = null;
            this.f2747a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    u(fileInputStream2);
                    b(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                b(fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    private void A(C0055a aVar) {
        HashMap<String, b> hashMap = this.f2750d[4];
        b bVar = hashMap.get("Compression");
        if (bVar != null) {
            int i2 = bVar.i(this.f2752f);
            this.f2753g = i2;
            if (i2 != 1) {
                if (i2 == 6) {
                    m(aVar, hashMap);
                    return;
                } else if (i2 != 7) {
                    return;
                }
            }
            if (s(hashMap)) {
                n(aVar, hashMap);
                return;
            }
            return;
        }
        this.f2753g = 6;
        m(aVar, hashMap);
    }

    private void B(int i2, int i3) {
        if (!this.f2750d[i2].isEmpty() && !this.f2750d[i3].isEmpty()) {
            b bVar = this.f2750d[i2].get("ImageLength");
            b bVar2 = this.f2750d[i2].get("ImageWidth");
            b bVar3 = this.f2750d[i3].get("ImageLength");
            b bVar4 = this.f2750d[i3].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int i4 = bVar.i(this.f2752f);
                int i5 = bVar2.i(this.f2752f);
                int i6 = bVar3.i(this.f2752f);
                int i7 = bVar4.i(this.f2752f);
                if (i4 < i6 && i5 < i7) {
                    HashMap<String, b>[] hashMapArr = this.f2750d;
                    HashMap<String, b> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            }
        }
    }

    private void C(C0055a aVar, int i2) {
        b bVar;
        b bVar2;
        b bVar3 = this.f2750d[i2].get("DefaultCropSize");
        b bVar4 = this.f2750d[i2].get("SensorTopBorder");
        b bVar5 = this.f2750d[i2].get("SensorLeftBorder");
        b bVar6 = this.f2750d[i2].get("SensorBottomBorder");
        b bVar7 = this.f2750d[i2].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f2764a == 5) {
                d[] dVarArr = (d[]) bVar3.k(this.f2752f);
                if (dVarArr == null || dVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                    return;
                }
                bVar2 = b.d(dVarArr[0], this.f2752f);
                bVar = b.d(dVarArr[1], this.f2752f);
            } else {
                int[] iArr = (int[]) bVar3.k(this.f2752f);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                bVar2 = b.f(iArr[0], this.f2752f);
                bVar = b.f(iArr[1], this.f2752f);
            }
            this.f2750d[i2].put("ImageWidth", bVar2);
            this.f2750d[i2].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            z(aVar, i2);
        } else {
            int i3 = bVar4.i(this.f2752f);
            int i4 = bVar6.i(this.f2752f);
            int i5 = bVar7.i(this.f2752f);
            int i6 = bVar5.i(this.f2752f);
            if (i4 > i3 && i5 > i6) {
                b f2 = b.f(i4 - i3, this.f2752f);
                b f3 = b.f(i5 - i6, this.f2752f);
                this.f2750d[i2].put("ImageLength", f2);
                this.f2750d[i2].put("ImageWidth", f3);
            }
        }
    }

    private void D(InputStream inputStream) {
        B(0, 5);
        B(0, 4);
        B(5, 4);
        b bVar = this.f2750d[1].get("PixelXDimension");
        b bVar2 = this.f2750d[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.f2750d[0].put("ImageWidth", bVar);
            this.f2750d[0].put("ImageLength", bVar2);
        }
        if (this.f2750d[4].isEmpty() && t(this.f2750d[5])) {
            HashMap<String, b>[] hashMapArr = this.f2750d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!t(this.f2750d[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void a() {
        String d2 = d("DateTimeOriginal");
        if (d2 != null && d("DateTime") == null) {
            this.f2750d[0].put("DateTime", b.a(d2));
        }
        if (d("ImageWidth") == null) {
            this.f2750d[0].put("ImageWidth", b.b(0, this.f2752f));
        }
        if (d("ImageLength") == null) {
            this.f2750d[0].put("ImageLength", b.b(0, this.f2752f));
        }
        if (d("Orientation") == null) {
            this.f2750d[0].put("Orientation", b.b(0, this.f2752f));
        }
        if (d("LightSource") == null) {
            this.f2750d[1].put("LightSource", b.b(0, this.f2752f));
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static long[] c(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private b f(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < F.length; i2++) {
            b bVar = this.f2750d[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(b.k.a.a.C0055a r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 410
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.a.a.g(b.k.a.a$a, int, int):void");
    }

    private int h(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (o(bArr)) {
            return 4;
        }
        if (q(bArr)) {
            return 9;
        }
        if (p(bArr)) {
            return 7;
        }
        return r(bArr) ? 10 : 0;
    }

    private void i(C0055a aVar) {
        k(aVar);
        b bVar = this.f2750d[1].get("MakerNote");
        if (bVar != null) {
            C0055a aVar2 = new C0055a(bVar.f2766c);
            aVar2.G(this.f2752f);
            byte[] bArr = p;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.F(0);
            byte[] bArr3 = q;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.F(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.F(12);
            }
            y(aVar2, 6);
            b bVar2 = this.f2750d[7].get("PreviewImageStart");
            b bVar3 = this.f2750d[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.f2750d[5].put("JPEGInterchangeFormat", bVar2);
                this.f2750d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.f2750d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.k(this.f2752f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    b f2 = b.f(i2, this.f2752f);
                    b f3 = b.f(i3, this.f2752f);
                    this.f2750d[0].put("ImageWidth", f2);
                    this.f2750d[0].put("ImageLength", f3);
                }
            }
        }
    }

    private void j(C0055a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        g(aVar, i2, 5);
        aVar.F((long) i3);
        aVar.G(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == A.f2767a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b f2 = b.f(readShort, this.f2752f);
                b f3 = b.f(readShort2, this.f2752f);
                this.f2750d[0].put("ImageLength", f2);
                this.f2750d[0].put("ImageWidth", f3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void k(C0055a aVar) {
        b bVar;
        v(aVar, aVar.available());
        y(aVar, 0);
        C(aVar, 0);
        C(aVar, 5);
        C(aVar, 4);
        D(aVar);
        if (this.f2749c == 8 && (bVar = this.f2750d[1].get("MakerNote")) != null) {
            C0055a aVar2 = new C0055a(bVar.f2766c);
            aVar2.G(this.f2752f);
            aVar2.F(6);
            y(aVar2, 9);
            b bVar2 = this.f2750d[9].get("ColorSpace");
            if (bVar2 != null) {
                this.f2750d[1].put("ColorSpace", bVar2);
            }
        }
    }

    private void l(C0055a aVar) {
        k(aVar);
        if (this.f2750d[0].get("JpgFromRaw") != null) {
            g(aVar, this.l, 5);
        }
        b bVar = this.f2750d[0].get("ISO");
        b bVar2 = this.f2750d[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.f2750d[1].put("PhotographicSensitivity", bVar);
        }
    }

    private void m(C0055a aVar, HashMap hashMap) {
        int i2;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int i3 = bVar.i(this.f2752f);
            int min = Math.min(bVar2.i(this.f2752f), aVar.available() - i3);
            int i4 = this.f2749c;
            if (i4 == 4 || i4 == 9 || i4 == 10) {
                i2 = this.f2754h;
            } else {
                if (i4 == 7) {
                    i2 = this.f2755i;
                }
                if (i3 > 0 && min > 0 && this.f2747a == null && this.f2748b == null) {
                    aVar.F((long) i3);
                    aVar.readFully(new byte[min]);
                    return;
                }
                return;
            }
            i3 += i2;
            if (i3 > 0) {
            }
        }
    }

    private void n(C0055a aVar, HashMap hashMap) {
        b bVar = (b) hashMap.get("StripOffsets");
        b bVar2 = (b) hashMap.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] c2 = c(bVar.k(this.f2752f));
            long[] c3 = c(bVar2.k(this.f2752f));
            if (c2 == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (c3 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j2 = 0;
                for (long j3 : c3) {
                    j2 += j3;
                }
                byte[] bArr = new byte[((int) j2)];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < c2.length; i4++) {
                    int i5 = (int) c2[i4];
                    int i6 = (int) c3[i4];
                    int i7 = i5 - i2;
                    if (i7 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    aVar.F((long) i7);
                    int i8 = i2 + i7;
                    byte[] bArr2 = new byte[i6];
                    aVar.read(bArr2);
                    i2 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i3, i6);
                    i3 += i6;
                }
            }
        }
    }

    private static boolean o(byte[] bArr) {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = o;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean p(byte[] bArr) {
        C0055a aVar = new C0055a(bArr);
        ByteOrder w2 = w(aVar);
        this.f2752f = w2;
        aVar.G(w2);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean q(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean r(byte[] bArr) {
        C0055a aVar = new C0055a(bArr);
        ByteOrder w2 = w(aVar);
        this.f2752f = w2;
        aVar.G(w2);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 85;
    }

    private boolean s(HashMap hashMap) {
        b bVar;
        b bVar2 = (b) hashMap.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.k(this.f2752f);
        int[] iArr2 = m;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f2749c != 3 || (bVar = (b) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i2 = bVar.i(this.f2752f);
        if ((i2 != 1 || !Arrays.equals(iArr, n)) && (i2 != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    private boolean t(HashMap hashMap) {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.i(this.f2752f) <= 512 && bVar2.i(this.f2752f) <= 512;
    }

    private void u(InputStream inputStream) {
        for (int i2 = 0; i2 < F.length; i2++) {
            try {
                this.f2750d[i2] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f2749c = h(bufferedInputStream);
        C0055a aVar = new C0055a(bufferedInputStream);
        switch (this.f2749c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                k(aVar);
                break;
            case 4:
                g(aVar, 0, 0);
                break;
            case 7:
                i(aVar);
                break;
            case 9:
                j(aVar);
                break;
            case 10:
                l(aVar);
                break;
        }
        A(aVar);
        a();
    }

    private void v(C0055a aVar, int i2) {
        ByteOrder w2 = w(aVar);
        this.f2752f = w2;
        aVar.G(w2);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i3 = this.f2749c;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i4 = readInt - 8;
            if (i4 > 0 && aVar.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private ByteOrder w(C0055a aVar) {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void x(byte[] bArr, int i2) {
        C0055a aVar = new C0055a(bArr);
        v(aVar, bArr.length);
        y(aVar, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y(b.k.a.a.C0055a r25, int r26) {
        /*
        // Method dump skipped, instructions count: 808
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.a.a.y(b.k.a.a$a, int):void");
    }

    private void z(C0055a aVar, int i2) {
        b bVar;
        b bVar2 = this.f2750d[i2].get("ImageLength");
        b bVar3 = this.f2750d[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.f2750d[i2].get("JPEGInterchangeFormat")) != null) {
            g(aVar, bVar.i(this.f2752f), i2);
        }
    }

    public String d(String str) {
        b f2 = f(str);
        if (f2 != null) {
            if (!J.contains(str)) {
                return f2.j(this.f2752f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = f2.f2764a;
                if (i2 == 5 || i2 == 10) {
                    d[] dVarArr = (d[]) f2.k(this.f2752f);
                    if (dVarArr == null || dVarArr.length != 3) {
                        Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVarArr[0].f2771a) / ((float) dVarArr[0].f2772b))), Integer.valueOf((int) (((float) dVarArr[1].f2771a) / ((float) dVarArr[1].f2772b))), Integer.valueOf((int) (((float) dVarArr[2].f2771a) / ((float) dVarArr[2].f2772b))));
                }
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + f2.f2764a);
                return null;
            }
            try {
                return Double.toString(f2.h(this.f2752f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int e(String str, int i2) {
        b f2 = f(str);
        if (f2 == null) {
            return i2;
        }
        try {
            return f2.i(this.f2752f);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b.k.a.a$a  reason: collision with other inner class name */
    /* compiled from: ExifInterface */
    public static class C0055a extends InputStream implements DataInput {

        /* renamed from: f  reason: collision with root package name */
        private static final ByteOrder f2758f = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: g  reason: collision with root package name */
        private static final ByteOrder f2759g = ByteOrder.BIG_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        private DataInputStream f2760b;

        /* renamed from: c  reason: collision with root package name */
        private ByteOrder f2761c;

        /* renamed from: d  reason: collision with root package name */
        final int f2762d;

        /* renamed from: e  reason: collision with root package name */
        int f2763e;

        public C0055a(InputStream inputStream) {
            this.f2761c = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2760b = dataInputStream;
            int available = dataInputStream.available();
            this.f2762d = available;
            this.f2763e = 0;
            this.f2760b.mark(available);
        }

        public long E() {
            return ((long) readInt()) & 4294967295L;
        }

        public void F(long j2) {
            int i2 = this.f2763e;
            if (((long) i2) > j2) {
                this.f2763e = 0;
                this.f2760b.reset();
                this.f2760b.mark(this.f2762d);
            } else {
                j2 -= (long) i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void G(ByteOrder byteOrder) {
            this.f2761c = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f2760b.available();
        }

        public int l() {
            return this.f2763e;
        }

        @Override // java.io.InputStream
        public int read() {
            this.f2763e++;
            return this.f2760b.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f2763e++;
            return this.f2760b.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int i2 = this.f2763e + 1;
            this.f2763e = i2;
            if (i2 <= this.f2762d) {
                int read = this.f2760b.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f2763e += 2;
            return this.f2760b.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i2, int i3) {
            int i4 = this.f2763e + i3;
            this.f2763e = i4;
            if (i4 > this.f2762d) {
                throw new EOFException();
            } else if (this.f2760b.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() {
            int i2 = this.f2763e + 4;
            this.f2763e = i2;
            if (i2 <= this.f2762d) {
                int read = this.f2760b.read();
                int read2 = this.f2760b.read();
                int read3 = this.f2760b.read();
                int read4 = this.f2760b.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f2761c;
                    if (byteOrder == f2758f) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f2759g) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f2761c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int i2 = this.f2763e + 8;
            this.f2763e = i2;
            if (i2 <= this.f2762d) {
                int read = this.f2760b.read();
                int read2 = this.f2760b.read();
                int read3 = this.f2760b.read();
                int read4 = this.f2760b.read();
                int read5 = this.f2760b.read();
                int read6 = this.f2760b.read();
                int read7 = this.f2760b.read();
                int read8 = this.f2760b.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f2761c;
                    if (byteOrder == f2758f) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == f2759g) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f2761c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i2 = this.f2763e + 2;
            this.f2763e = i2;
            if (i2 <= this.f2762d) {
                int read = this.f2760b.read();
                int read2 = this.f2760b.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2761c;
                    if (byteOrder == f2758f) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f2759g) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f2761c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f2763e += 2;
            return this.f2760b.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f2763e++;
            return this.f2760b.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int i2 = this.f2763e + 2;
            this.f2763e = i2;
            if (i2 <= this.f2762d) {
                int read = this.f2760b.read();
                int read2 = this.f2760b.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2761c;
                    if (byteOrder == f2758f) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f2759g) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f2761c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i2) {
            int min = Math.min(i2, this.f2762d - this.f2763e);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f2760b.skipBytes(min - i3);
            }
            this.f2763e += i3;
            return i3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read = this.f2760b.read(bArr, i2, i3);
            this.f2763e += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            int length = this.f2763e + bArr.length;
            this.f2763e = length;
            if (length > this.f2762d) {
                throw new EOFException();
            } else if (this.f2760b.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public C0055a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ExifInterface */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f2767a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2768b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2769c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2770d;

        c(String str, int i2, int i3) {
            this.f2768b = str;
            this.f2767a = i2;
            this.f2769c = i3;
            this.f2770d = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            int i3;
            int i4 = this.f2769c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f2770d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            if ((i4 == 12 || i3 == 12) && i2 == 11) {
                return true;
            }
            return false;
        }

        c(String str, int i2, int i3, int i4) {
            this.f2768b = str;
            this.f2767a = i2;
            this.f2769c = i3;
            this.f2770d = i4;
        }
    }

    public a(InputStream inputStream) {
        c[][] cVarArr = F;
        this.f2750d = new HashMap[cVarArr.length];
        this.f2751e = new HashSet(cVarArr.length);
        if (inputStream != null) {
            this.f2747a = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f2748b = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.f2748b = null;
            }
            u(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
