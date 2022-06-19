package pl.aprilapps.easyphotopicker;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;

/* compiled from: Intents.kt */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f11052a = new f();

    private f() {
    }

    private final void b(Context context, Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    public final Intent a(Context context, Uri uri) {
        kotlin.m.b.f.f(context, "context");
        kotlin.m.b.f.f(uri, "fileUri");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            intent.putExtra("output", uri);
            b(context, intent, uri);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return intent;
    }

    public final void c(Context context, Uri uri) {
        kotlin.m.b.f.f(context, "context");
        kotlin.m.b.f.f(uri, "uri");
        context.revokeUriPermission(uri, 3);
    }
}
