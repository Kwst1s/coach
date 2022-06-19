package com.google.android.gms.common;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class GooglePlayServicesManifestException extends IllegalStateException {
    public GooglePlayServicesManifestException(int i2, @RecentlyNonNull String str) {
        super(str);
    }
}
