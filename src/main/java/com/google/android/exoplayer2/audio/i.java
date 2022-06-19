package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: AudioCapabilities */
public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final i f4786c = new i(new int[]{2}, 2);

    /* renamed from: a  reason: collision with root package name */
    private final int[] f4787a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4788b;

    public i(int[] iArr, int i2) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f4787a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f4787a = new int[0];
        }
        this.f4788b = i2;
    }

    public static i a(Context context) {
        return b(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static i b(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f4786c;
        }
        return new i(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean c(int i2) {
        return Arrays.binarySearch(this.f4787a, i2) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!Arrays.equals(this.f4787a, iVar.f4787a) || this.f4788b != iVar.f4788b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f4788b + (Arrays.hashCode(this.f4787a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f4788b + ", supportedEncodings=" + Arrays.toString(this.f4787a) + "]";
    }
}
