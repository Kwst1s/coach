package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: MaterialTextInputPicker */
public final class k<S> extends p<S> {
    private int Y;
    private d<S> Z;
    private a a0;

    /* compiled from: MaterialTextInputPicker */
    class a extends o<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s) {
            Iterator<o<S>> it = k.this.X.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    static <T> k<T> M1(d<T> dVar, int i2, a aVar) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        kVar.v1(bundle);
        return kVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        super.K0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.Y = bundle.getInt("THEME_RES_ID_KEY");
        this.Z = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.a0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.Z.j(layoutInflater.cloneInContext(new ContextThemeWrapper(w(), this.Y)), viewGroup, bundle, this.a0, new a());
    }
}
