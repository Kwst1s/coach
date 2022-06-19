package gov.va.mobilehealth.ncptsd.covid.CComp;

import androidx.appcompat.app.c;

/* compiled from: Activity_TrackingWithSP */
public class f extends c {
    private String t;

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onResume() {
        if (o.h(getApplicationContext())) {
            o.n(this);
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStart() {
        if (getTitle() != null) {
            this.t = getTitle().toString();
        }
        ((App) getApplication()).e(this.t);
        super.onStart();
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        this.t = charSequence.toString();
        ((App) getApplication()).e(this.t);
        super.setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        this.t = getString(i2);
        ((App) getApplication()).e(this.t);
        super.setTitle(i2);
    }
}
