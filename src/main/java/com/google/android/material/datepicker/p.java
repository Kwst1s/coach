package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* access modifiers changed from: package-private */
/* compiled from: PickerFragment */
public abstract class p<S> extends Fragment {
    protected final LinkedHashSet<o<S>> X = new LinkedHashSet<>();

    p() {
    }

    /* access modifiers changed from: package-private */
    public boolean K1(o<S> oVar) {
        return this.X.add(oVar);
    }

    /* access modifiers changed from: package-private */
    public void L1() {
        this.X.clear();
    }
}
