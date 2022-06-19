package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f101a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<b> f102b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements g, a {

        /* renamed from: a  reason: collision with root package name */
        private final e f103a;

        /* renamed from: b  reason: collision with root package name */
        private final b f104b;

        /* renamed from: c  reason: collision with root package name */
        private a f105c;

        LifecycleOnBackPressedCancellable(e eVar, b bVar) {
            this.f103a = eVar;
            this.f104b = bVar;
            eVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f103a.c(this);
            this.f104b.e(this);
            a aVar = this.f105c;
            if (aVar != null) {
                aVar.cancel();
                this.f105c = null;
            }
        }

        @Override // androidx.lifecycle.g
        public void d(i iVar, e.a aVar) {
            if (aVar == e.a.ON_START) {
                this.f105c = OnBackPressedDispatcher.this.b(this.f104b);
            } else if (aVar == e.a.ON_STOP) {
                a aVar2 = this.f105c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (aVar == e.a.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* access modifiers changed from: private */
    public class a implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b f107a;

        a(b bVar) {
            this.f107a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f102b.remove(this.f107a);
            this.f107a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f101a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(i iVar, b bVar) {
        e c2 = iVar.c();
        if (c2.b() != e.b.DESTROYED) {
            bVar.a(new LifecycleOnBackPressedCancellable(c2, bVar));
        }
    }

    /* access modifiers changed from: package-private */
    public a b(b bVar) {
        this.f102b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f102b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f101a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
