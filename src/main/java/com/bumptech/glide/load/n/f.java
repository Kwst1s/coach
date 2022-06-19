package com.bumptech.glide.load.n;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f3991a;

    /* compiled from: FileLoader */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f3992a;

        public a(d<Data> dVar) {
            this.f3992a = dVar;
        }

        @Override // com.bumptech.glide.load.n.o
        public final n<File, Data> b(r rVar) {
            return new f(this.f3992a);
        }
    }

    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            /* renamed from: e */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: FileLoader */
    public static final class c<Data> implements com.bumptech.glide.load.m.d<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final File f3993b;

        /* renamed from: c  reason: collision with root package name */
        private final d<Data> f3994c;

        /* renamed from: d  reason: collision with root package name */
        private Data f3995d;

        c(File file, d<Data> dVar) {
            this.f3993b = file;
            this.f3994c = dVar;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f3994c.a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            Data data = this.f3995d;
            if (data != null) {
                try {
                    this.f3994c.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            try {
                Data c2 = this.f3994c.c(this.f3993b);
                this.f3995d = c2;
                aVar.d(c2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* compiled from: FileLoader */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(File file);
    }

    /* compiled from: FileLoader */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader */
        class a implements d<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f3991a = dVar;
    }

    /* renamed from: c */
    public n.a<Data> a(File file, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(file), new c(file, this.f3991a));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
