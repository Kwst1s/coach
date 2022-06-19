package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.d0;
import com.squareup.picasso.t;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: PicassoExecutorService */
public class v extends ThreadPoolExecutor {

    /* compiled from: PicassoExecutorService */
    private static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: b  reason: collision with root package name */
        private final c f8785b;

        a(c cVar) {
            super(cVar, null);
            this.f8785b = cVar;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            t.f r = this.f8785b.r();
            t.f r2 = aVar.f8785b.r();
            return r == r2 ? this.f8785b.f8673b - aVar.f8785b.f8673b : r2.ordinal() - r.ordinal();
        }
    }

    v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d0.c());
    }

    private void b(int i2) {
        setCorePoolSize(i2);
        setMaximumPoolSize(i2);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    b(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            b(3);
                            return;
                        default:
                            b(3);
                            return;
                    }
            }
            b(2);
        } else if (type == 1 || type == 6 || type == 9) {
            b(4);
        } else {
            b(3);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }
}
