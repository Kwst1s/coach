package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7005a;

    public /* synthetic */ d(String str) {
        this.f7005a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return d0.Q(this.f7005a, runnable);
    }
}
