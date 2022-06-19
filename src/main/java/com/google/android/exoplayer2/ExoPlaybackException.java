package com.google.android.exoplayer2;

import java.io.IOException;

public final class ExoPlaybackException extends Exception {
    private ExoPlaybackException(int i2, Throwable th, int i3) {
        super(th);
    }

    public static ExoPlaybackException a(Exception exc, int i2) {
        return new ExoPlaybackException(1, exc, i2);
    }

    public static ExoPlaybackException c(IOException iOException) {
        return new ExoPlaybackException(0, iOException, -1);
    }

    static ExoPlaybackException d(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException, -1);
    }
}
