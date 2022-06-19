package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;

class FragmentStateAdapter$5 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f1894a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f1895b;

    @Override // androidx.lifecycle.g
    public void d(i iVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.f1894a.removeCallbacks(this.f1895b);
            iVar.c().c(this);
        }
    }
}
