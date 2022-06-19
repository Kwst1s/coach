package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class b {
    public static ApiException a(@RecentlyNonNull Status status) {
        if (status.n()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
