package com.devbrackets.android.exomedia.core.exception;

import android.media.MediaPlayer;

public class NativeMediaPlaybackException extends Exception {
    public NativeMediaPlaybackException(int i2, int i3) {
        super(MediaPlayer.class.getName() + " has had the error " + i2 + " with extras " + i3);
    }
}
