package com.bumptech.glide;

import com.bumptech.glide.j;
import com.bumptech.glide.p.k.a;
import com.bumptech.glide.p.k.c;

/* compiled from: TransitionOptions */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private c<? super TranscodeType> f3555b = a.b();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) ((j) super.clone());
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final c<? super TranscodeType> b() {
        return this.f3555b;
    }
}
