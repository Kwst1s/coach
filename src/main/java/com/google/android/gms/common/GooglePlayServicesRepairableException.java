package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    public GooglePlayServicesRepairableException(int i2, @RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        super(str, intent);
    }
}