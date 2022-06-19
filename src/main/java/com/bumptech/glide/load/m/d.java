package com.bumptech.glide.load.m;

import com.bumptech.glide.f;

/* compiled from: DataFetcher */
public interface d<T> {

    /* compiled from: DataFetcher */
    public interface a<T> {
        void c(Exception exc);

        void d(T t);
    }

    Class<T> a();

    void b();

    void cancel();

    com.bumptech.glide.load.a e();

    void f(f fVar, a<? super T> aVar);
}
