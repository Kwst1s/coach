package com.google.gson.u;

import com.google.gson.u.m.m;
import java.io.Writer;

/* compiled from: Streams */
public final class k {
    public static void a(com.google.gson.k kVar, com.google.gson.stream.a aVar) {
        m.X.c(aVar, kVar);
    }

    public static Writer b(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams */
    private static final class a extends Writer {

        /* renamed from: b  reason: collision with root package name */
        private final Appendable f8381b;

        /* renamed from: c  reason: collision with root package name */
        private final C0168a f8382c = new C0168a();

        /* renamed from: com.google.gson.u.k$a$a  reason: collision with other inner class name */
        /* compiled from: Streams */
        static class C0168a implements CharSequence {

            /* renamed from: b  reason: collision with root package name */
            char[] f8383b;

            C0168a() {
            }

            public char charAt(int i2) {
                return this.f8383b[i2];
            }

            public int length() {
                return this.f8383b.length;
            }

            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f8383b, i2, i3 - i2);
            }
        }

        a(Appendable appendable) {
            this.f8381b = appendable;
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            C0168a aVar = this.f8382c;
            aVar.f8383b = cArr;
            this.f8381b.append(aVar, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) {
            this.f8381b.append((char) i2);
        }
    }
}
