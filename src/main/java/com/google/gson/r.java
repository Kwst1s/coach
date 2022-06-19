package com.google.gson;

import com.google.gson.u.m.e;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class r<T> {

    /* compiled from: TypeAdapter */
    class a extends r<T> {
        a() {
        }

        @Override // com.google.gson.r
        public void c(com.google.gson.stream.a aVar, T t) {
            if (t == null) {
                aVar.P();
            } else {
                r.this.c(aVar, t);
            }
        }
    }

    public final r<T> a() {
        return new a();
    }

    public final k b(T t) {
        try {
            e eVar = new e();
            c(eVar, t);
            return eVar.f0();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void c(com.google.gson.stream.a aVar, T t);
}
