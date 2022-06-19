package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;

/* access modifiers changed from: package-private */
/* compiled from: SmoothCalendarLayoutManager */
public class q extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager */
    class a extends j {
        a(q qVar, Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.j
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    q(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void J1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.p(i2);
        K1(aVar);
    }
}
