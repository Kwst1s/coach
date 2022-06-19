package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.d0;

/* compiled from: SsUtil */
public final class b {
    public static Uri a(Uri uri) {
        if (d0.h0(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            return uri;
        }
        return Uri.withAppendedPath(uri, "Manifest");
    }
}
