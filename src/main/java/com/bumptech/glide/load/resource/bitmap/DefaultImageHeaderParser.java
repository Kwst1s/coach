package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.r.j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f4159a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4160b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* access modifiers changed from: private */
    public interface Reader {

        public static final class EndOfFileException extends IOException {
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        long b(long j2);

        int c(byte[] bArr, int i2);

        short d();

        int e();
    }

    private static final class a implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4161a;

        a(ByteBuffer byteBuffer) {
            this.f4161a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long b(long j2) {
            int min = (int) Math.min((long) this.f4161a.remaining(), j2);
            ByteBuffer byteBuffer = this.f4161a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int c(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f4161a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f4161a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short d() {
            if (this.f4161a.remaining() >= 1) {
                return (short) (this.f4161a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int e() {
            return (d() << 8) | d();
        }
    }

    /* access modifiers changed from: private */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4162a;

        b(byte[] bArr, int i2) {
            this.f4162a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i2, int i3) {
            return this.f4162a.remaining() - i2 >= i3;
        }

        /* access modifiers changed from: package-private */
        public short a(int i2) {
            if (c(i2, 2)) {
                return this.f4162a.getShort(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            if (c(i2, 4)) {
                return this.f4162a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f4162a.remaining();
        }

        /* access modifiers changed from: package-private */
        public void e(ByteOrder byteOrder) {
            this.f4162a.order(byteOrder);
        }
    }

    private static final class c implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f4163a;

        c(InputStream inputStream) {
            this.f4163a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long b(long j2) {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f4163a.skip(j3);
                if (skip <= 0) {
                    if (this.f4163a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int c(byte[] bArr, int i2) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f4163a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short d() {
            int read = this.f4163a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int e() {
            return (d() << 8) | d();
        }
    }

    private static int d(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int e(Reader reader, com.bumptech.glide.load.engine.z.b bVar) {
        try {
            int e2 = reader.e();
            if (!g(e2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + e2);
                }
                return -1;
            }
            int i2 = i(reader);
            if (i2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.e(i2, byte[].class);
            try {
                return k(reader, bArr, i2);
            } finally {
                bVar.d(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private ImageHeaderParser.ImageType f(Reader reader) {
        try {
            int e2 = reader.e();
            if (e2 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int d2 = (e2 << 8) | reader.d();
            if (d2 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int d3 = (d2 << 8) | reader.d();
            if (d3 == -1991225785) {
                reader.b(21);
                try {
                    return reader.d() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (d3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                reader.b(4);
                if (((reader.e() << 16) | reader.e()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int e3 = (reader.e() << 16) | reader.e();
                if ((e3 & -256) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i2 = e3 & 255;
                if (i2 == 88) {
                    reader.b(4);
                    return (reader.d() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i2 != 76) {
                    return ImageHeaderParser.ImageType.WEBP;
                } else {
                    reader.b(4);
                    return (reader.d() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean g(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean h(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f4159a.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = f4159a;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }

    private int i(Reader reader) {
        short d2;
        int e2;
        long j2;
        long b2;
        do {
            short d3 = reader.d();
            if (d3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) d3));
                }
                return -1;
            }
            d2 = reader.d();
            if (d2 == 218) {
                return -1;
            }
            if (d2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            e2 = reader.e() - 2;
            if (d2 == 225) {
                return e2;
            }
            j2 = (long) e2;
            b2 = reader.b(j2);
        } while (b2 == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) d2) + ", wanted to skip: " + e2 + ", but actually skipped: " + b2);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short a2 = bVar.a(6);
        if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int d2 = d(b2, i2);
            short a4 = bVar.a(d2);
            if (a4 == 274) {
                short a5 = bVar.a(d2 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = bVar.b(d2 + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) a4) + " formatCode=" + ((int) a5) + " componentCount=" + b3);
                        }
                        int i3 = b3 + f4160b[a5];
                        if (i3 <= 4) {
                            int i4 = d2 + 8;
                            if (i4 < 0 || i4 > bVar.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) a4));
                                }
                            } else if (i3 >= 0 && i3 + i4 <= bVar.d()) {
                                return bVar.a(i4);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a4));
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a5));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a5));
                }
            }
        }
        return -1;
    }

    private int k(Reader reader, byte[] bArr, int i2) {
        int c2 = reader.c(bArr, i2);
        if (c2 != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + c2);
            }
            return -1;
        } else if (h(bArr, i2)) {
            return j(new b(bArr, i2));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        j.d(byteBuffer);
        return f(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
        j.d(inputStream);
        c cVar = new c(inputStream);
        j.d(bVar);
        return e(cVar, bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        j.d(inputStream);
        return f(new c(inputStream));
    }
}
