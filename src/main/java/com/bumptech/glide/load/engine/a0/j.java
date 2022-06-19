package com.bumptech.glide.load.engine.a0;

import b.h.j.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k;
import com.bumptech.glide.r.l.a;
import com.bumptech.glide.r.l.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final g<f, String> f3695a = new g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e<b> f3696b = com.bumptech.glide.r.l.a.d(10, new a(this));

    /* compiled from: SafeKeyGenerator */
    class a implements a.d<b> {
        a(j jVar) {
        }

        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: SafeKeyGenerator */
    public static final class b implements a.f {

        /* renamed from: b  reason: collision with root package name */
        final MessageDigest f3697b;

        /* renamed from: c  reason: collision with root package name */
        private final c f3698c = c.a();

        b(MessageDigest messageDigest) {
            this.f3697b = messageDigest;
        }

        @Override // com.bumptech.glide.r.l.a.f
        public c d() {
            return this.f3698c;
        }
    }

    private String a(f fVar) {
        b b2 = this.f3696b.b();
        com.bumptech.glide.r.j.d(b2);
        b bVar = b2;
        try {
            fVar.b(bVar.f3697b);
            return k.s(bVar.f3697b.digest());
        } finally {
            this.f3696b.a(bVar);
        }
    }

    public String b(f fVar) {
        String g2;
        synchronized (this.f3695a) {
            g2 = this.f3695a.g(fVar);
        }
        if (g2 == null) {
            g2 = a(fVar);
        }
        synchronized (this.f3695a) {
            this.f3695a.k(fVar, g2);
        }
        return g2;
    }
}
