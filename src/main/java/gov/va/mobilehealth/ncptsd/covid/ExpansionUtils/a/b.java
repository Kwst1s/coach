package gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/* compiled from: ZipResourceFile */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, a> f10165a = new HashMap<>();

    /* compiled from: ZipResourceFile */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final File f10166a;

        /* renamed from: b  reason: collision with root package name */
        public long f10167b;

        /* renamed from: c  reason: collision with root package name */
        public int f10168c;

        /* renamed from: d  reason: collision with root package name */
        public long f10169d;

        /* renamed from: e  reason: collision with root package name */
        public long f10170e = -1;

        public a(String str, File file, String str2) {
            this.f10166a = file;
        }

        public AssetFileDescriptor a() {
            if (this.f10168c != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f10166a, 268435456), b(), this.f10169d);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public long b() {
            return this.f10170e;
        }

        public void c(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) {
            long j2 = this.f10167b;
            try {
                randomAccessFile.seek(j2);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.f10170e = j2 + 30 + ((long) (byteBuffer.getShort(26) & 65535)) + ((long) (byteBuffer.getShort(28) & 65535));
                } else {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public b(String str) {
        new HashMap();
        ByteBuffer.allocate(4);
        a(str);
    }

    private static int c(RandomAccessFile randomAccessFile) {
        return d(randomAccessFile.readInt());
    }

    private static int d(int i2) {
        return ((i2 & 255) << 24) + ((65280 & i2) << 8) + ((16711680 & i2) >>> 8) + ((i2 >>> 24) & 255);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j2 = 65557;
            if (65557 > length) {
                j2 = length;
            }
            randomAccessFile.seek(0);
            int c2 = c(randomAccessFile);
            if (c2 == 101010256) {
                Log.i("zipro", "Found Zip archive, but it looks empty");
                throw new IOException();
            } else if (c2 == 67324752) {
                randomAccessFile.seek(length - j2);
                ByteBuffer allocate = ByteBuffer.allocate((int) j2);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                }
                if (length2 < 0) {
                    Log.d("zipro", "Zip: EOCD not found, " + str2 + " gov not zip");
                }
                short s = allocate.getShort(length2 + 8);
                long j3 = ((long) allocate.getInt(length2 + 12)) & 4294967295L;
                long j4 = ((long) allocate.getInt(length2 + 16)) & 4294967295L;
                if (j4 + j3 > length) {
                    Log.w("zipro", "bad offsets (dir " + j4 + ", size " + j3 + ", eocd " + length2 + ")");
                    throw new IOException();
                } else if (s != 0) {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j4, j3);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    short s2 = 65535;
                    byte[] bArr = new byte[65535];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(byteOrder);
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < s) {
                        if (map.getInt(i4) == 33639248) {
                            int i5 = map.getShort(i4 + 28) & s2;
                            int i6 = map.getShort(i4 + 30) & s2;
                            int i7 = map.getShort(i4 + 32) & s2;
                            map.position(i4 + 46);
                            map.get(bArr, i2, i5);
                            map.position(i2);
                            String str3 = new String(bArr, i2, i5);
                            a aVar = new a(str2, file, str3);
                            aVar.f10168c = map.getShort(i4 + 10) & 65535;
                            map.getInt(i4 + 12);
                            map.getLong(i4 + 16);
                            map.getLong(i4 + 20);
                            aVar.f10169d = map.getLong(i4 + 24) & 4294967295L;
                            aVar.f10167b = ((long) map.getInt(i4 + 42)) & 4294967295L;
                            allocate2.clear();
                            aVar.c(randomAccessFile, allocate2);
                            this.f10165a.put(str3, aVar);
                            i4 += i5 + 46 + i6 + i7;
                            i3++;
                            str2 = str;
                            file = file;
                            i2 = 0;
                            s2 = 65535;
                        } else {
                            Log.w("zipro", "Missed a central dir sig (at " + i4 + ")");
                            throw new IOException();
                        }
                    }
                } else {
                    Log.w("zipro", "empty archive?");
                    throw new IOException();
                }
            } else {
                Log.v("zipro", "Not a Zip archive");
                throw new IOException();
            }
        } else {
            throw new IOException();
        }
    }

    public AssetFileDescriptor b(String str) {
        a aVar = this.f10165a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }
}
