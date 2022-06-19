package pl.aprilapps.easyphotopicker;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.m.b.f;

/* compiled from: Files.kt */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f11048a = new e();

    /* access modifiers changed from: package-private */
    /* compiled from: Files.kt */
    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f11049b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11050c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f11051d;

        a(List list, String str, Context context) {
            this.f11049b = list;
            this.f11050c = str;
            this.f11051d = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 257
            */
            throw new UnsupportedOperationException("Method not decompiled: pl.aprilapps.easyphotopicker.e.a.run():void");
        }
    }

    /* compiled from: Files.kt */
    public static final class b implements MediaScannerConnection.OnScanCompletedListener {
        b() {
        }

        public void onScanCompleted(String str, Uri uri) {
            f.f(str, "path");
            f.f(uri, "uri");
            String simpleName = b.class.getSimpleName();
            Log.d(simpleName, "Scanned " + str + ':');
            String simpleName2 = b.class.getSimpleName();
            Log.d(simpleName2, "-> uri=" + uri);
        }
    }

    private e() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void c(File file, File file2) {
        l(new FileInputStream(file), file2);
    }

    private final String f() {
        return "ei_" + System.currentTimeMillis();
    }

    private final String g(Context context, Uri uri) {
        if (f.a(uri.getScheme(), "content")) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    private final Uri h(Context context, File file) {
        Context applicationContext = context.getApplicationContext();
        f.b(applicationContext, "context.applicationContext");
        String packageName = applicationContext.getPackageName();
        Uri e2 = b.h.d.b.e(context, packageName + ".easyphotopicker.fileprovider", file);
        f.b(e2, "FileProvider.getUriForFi…context, authority, file)");
        return e2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void j(Context context, List<? extends File> list) {
        String[] strArr = new String[list.size()];
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = ((File) list.get(i2)).toString();
        }
        MediaScannerConnection.scanFile(context, strArr, null, new b());
    }

    private final File k(Context context) {
        File file = new File(context.getCacheDir(), "EasyImage");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private final void l(InputStream inputStream, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr);
            while (read > 0) {
                fileOutputStream.write(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(Context context, String str, List<? extends File> list) {
        f.f(context, "context");
        f.f(str, "folderName");
        f.f(list, "filesToCopy");
        new Thread(new a(list, str, context)).run();
    }

    public final g e(Context context) {
        f.f(context, "context");
        File createTempFile = File.createTempFile(f(), ".jpg", k(context));
        f.b(createTempFile, "file");
        return new g(h(context, createTempFile), createTempFile);
    }

    public final File i(Context context, Uri uri) {
        f.f(context, "context");
        f.f(uri, "photoUri");
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        File k2 = k(context);
        File file = new File(k2, f() + "." + g(context, uri));
        file.createNewFile();
        f.b(openInputStream, "pictureInputStream");
        l(openInputStream, file);
        return file;
    }
}
