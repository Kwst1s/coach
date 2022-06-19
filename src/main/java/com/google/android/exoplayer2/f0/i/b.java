package com.google.android.exoplayer2.f0.i;

import com.google.android.exoplayer2.f0.a;

/* compiled from: SpliceCommand */
public abstract class b implements a.b {
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
