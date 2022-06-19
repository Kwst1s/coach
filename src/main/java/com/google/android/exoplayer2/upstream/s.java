package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.d0;

public final /* synthetic */ class s {
    public static /* synthetic */ boolean a(String str) {
        String h0 = d0.h0(str);
        return !TextUtils.isEmpty(h0) && (!h0.contains("text") || h0.contains("text/vtt")) && !h0.contains("html") && !h0.contains("xml");
    }
}
