package com.bumptech.glide.load.n;

import android.util.Base64;
import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f3986a;

    /* compiled from: DataUrlLoader */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(String str);
    }

    /* compiled from: DataUrlLoader */
    private static final class b<Data> implements d<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final String f3987b;

        /* renamed from: c  reason: collision with root package name */
        private final a<Data> f3988c;

        /* renamed from: d  reason: collision with root package name */
        private Data f3989d;

        b(String str, a<Data> aVar) {
            this.f3987b = str;
            this.f3988c = aVar;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f3988c.a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            try {
                this.f3988c.b(this.f3989d);
            } catch (IOException unused) {
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
        public void f(f fVar, d.a<? super Data> aVar) {
            try {
                Data c2 = this.f3988c.c(this.f3987b);
                this.f3989d = c2;
                aVar.d(c2);
            } catch (IllegalArgumentException e2) {
                aVar.c(e2);
            }
        }
    }

    /* compiled from: DataUrlLoader */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f3990a = new a(this);

        /* compiled from: DataUrlLoader */
        class a implements a<InputStream> {
            a(c cVar) {
            }

            @Override // com.bumptech.glide.load.n.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Model, InputStream> b(r rVar) {
            return new e(this.f3990a);
        }
    }

    public e(a<Data> aVar) {
        this.f3986a = aVar;
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Data> a(Model model, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(model), new b(model.toString(), this.f3986a));
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean b(Model model) {
        return model.toString().startsWith("data:image");
    }
}
