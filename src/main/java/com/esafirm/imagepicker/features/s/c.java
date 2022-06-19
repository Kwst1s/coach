package com.esafirm.imagepicker.features.s;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import b.h.d.b;
import com.esafirm.imagepicker.features.u.a;
import com.esafirm.imagepicker.helper.e;
import java.io.File;
import java.io.Serializable;
import java.util.Locale;

/* compiled from: DefaultCameraModule */
public class c implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private String f4559b;

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(d dVar, Context context, Uri uri, String str, Uri uri2) {
        e c2 = e.c();
        c2.a("File " + str + " was scanned successfully: " + uri2);
        if (str == null) {
            e.c().a("This should not happen, go back to Immediate implemenation");
            str = this.f4559b;
        }
        dVar.a(c.c.a.i.c.a(str));
        com.esafirm.imagepicker.helper.c.h(context, uri);
    }

    public Intent a(Context context, a aVar) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File a2 = com.esafirm.imagepicker.helper.c.a(aVar.g());
        if (a2 == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        Uri e2 = b.e(applicationContext, String.format(Locale.ENGLISH, "%s%s", applicationContext.getPackageName(), ".imagepicker.provider"), a2);
        this.f4559b = "file:" + a2.getAbsolutePath();
        intent.putExtra("output", e2);
        com.esafirm.imagepicker.helper.c.d(context, intent, e2);
        return intent;
    }

    public void c(Context context, Intent intent, d dVar) {
        if (dVar != null) {
            String str = this.f4559b;
            if (str == null) {
                e.c().d("currentImagePath null. This happen if you haven't call #getCameraIntent() or the activity is being recreated");
                dVar.a(null);
                return;
            }
            Uri parse = Uri.parse(str);
            if (parse != null) {
                MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{parse.getPath()}, null, new a(this, dVar, context, parse));
                return;
            }
            return;
        }
        throw new IllegalStateException("OnImageReadyListener must not be null");
    }

    public void f() {
        if (this.f4559b != null) {
            File file = new File(this.f4559b);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
