package b.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor */
final class c implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f2813b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2814c;

    /* renamed from: d  reason: collision with root package name */
    private final File f2815d;

    /* renamed from: e  reason: collision with root package name */
    private final RandomAccessFile f2816e;

    /* renamed from: f  reason: collision with root package name */
    private final FileChannel f2817f;

    /* renamed from: g  reason: collision with root package name */
    private final FileLock f2818g;

    /* access modifiers changed from: package-private */
    /* compiled from: MultiDexExtractor */
    public class a implements FileFilter {
        a(c cVar) {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MultiDexExtractor */
    public static class b extends File {

        /* renamed from: b  reason: collision with root package name */
        public long f2819b = -1;

        public b(File file, String str) {
            super(file, str);
        }
    }

    c(File file, File file2) {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f2813b = file;
        this.f2815d = file2;
        this.f2814c = I(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f2816e = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f2817f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f2818g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException | Error | RuntimeException e2) {
                E(this.f2817f);
                throw e2;
            }
        } catch (IOException | Error | RuntimeException e3) {
            E(this.f2816e);
            throw e3;
        }
    }

    private static void E(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    /* JADX INFO: finally extract failed */
    private static void F(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    Log.i("MultiDex", "Renaming to " + file.getPath());
                    if (!createTempFile.renameTo(file)) {
                        throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                    }
                    return;
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            E(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences G(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long H(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long I(File file) {
        long c2 = d.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean J(Context context, File file, long j2, String str) {
        SharedPreferences G = G(context);
        if (G.getLong(str + "timestamp", -1) == H(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return G.getLong(sb.toString(), -1) != j2;
        }
    }

    private List<b> L(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f2813b.getName() + ".classes";
        SharedPreferences G = G(context);
        int i2 = G.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            b bVar = new b(this.f2815d, str2 + i3 + ".zip");
            if (bVar.isFile()) {
                bVar.f2819b = I(bVar);
                long j2 = G.getLong(str + "dex.crc." + i3, -1);
                long j3 = G.getLong(str + "dex.time." + i3, -1);
                long lastModified = bVar.lastModified();
                if (j3 == lastModified && j2 == bVar.f2819b) {
                    arrayList.add(bVar);
                    i3++;
                    G = G;
                    str2 = str2;
                } else {
                    throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + bVar.f2819b);
                }
            } else {
                throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
            }
        }
        return arrayList;
    }

    private List<b> M() {
        boolean z;
        String str = this.f2813b.getName() + ".classes";
        l();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f2813b);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i2 = 2;
            while (entry != null) {
                b bVar = new b(this.f2815d, str + i2 + ".zip");
                arrayList.add(bVar);
                Log.i("MultiDex", "Extraction is needed for file " + bVar);
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    F(zipFile, entry, bVar, str);
                    try {
                        bVar.f2819b = I(bVar);
                        z = true;
                    } catch (IOException e2) {
                        Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.f2819b);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i3 = i4;
                }
                if (z2) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            throw th;
        }
    }

    private static void N(Context context, String str, long j2, long j3, List<b> list) {
        SharedPreferences.Editor edit = G(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (b bVar : list) {
            edit.putLong(str + "dex.crc." + i2, bVar.f2819b);
            edit.putLong(str + "dex.time." + i2, bVar.lastModified());
            i2++;
        }
        edit.commit();
    }

    private void l() {
        File[] listFiles = this.f2815d.listFiles(new a(this));
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f2815d.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> K(Context context, String str, boolean z) {
        List<b> list;
        List<b> list2;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f2813b.getPath() + ", " + z + ", " + str + ")");
        if (this.f2818g.isValid()) {
            if (z || J(context, this.f2813b, this.f2814c, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list2 = M();
                N(context, str, H(this.f2813b), this.f2814c, list2);
            } else {
                try {
                    list = L(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    list2 = M();
                    N(context, str, H(this.f2813b), this.f2814c, list2);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = list2;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2818g.release();
        this.f2817f.close();
        this.f2816e.close();
    }
}
