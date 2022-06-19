package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.r.j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f3666a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f3667b = new b();

    /* access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f3668a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f3669b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f3670a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f3670a) {
                poll = this.f3670a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* access modifiers changed from: package-private */
        public void b(a aVar) {
            synchronized (this.f3670a) {
                if (this.f3670a.size() < 10) {
                    this.f3670a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f3666a.get(str);
            if (aVar == null) {
                aVar = this.f3667b.a();
                this.f3666a.put(str, aVar);
            }
            aVar.f3669b++;
        }
        aVar.f3668a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.f3666a.get(str);
            j.d(aVar2);
            aVar = aVar2;
            int i2 = aVar.f3669b;
            if (i2 >= 1) {
                int i3 = i2 - 1;
                aVar.f3669b = i3;
                if (i3 == 0) {
                    a remove = this.f3666a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f3667b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f3669b);
            }
        }
        aVar.f3668a.unlock();
    }
}
