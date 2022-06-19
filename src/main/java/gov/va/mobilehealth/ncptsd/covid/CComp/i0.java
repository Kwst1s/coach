package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.c;
import com.github.mikephil.charting.BuildConfig;
import k.b.d;

/* compiled from: StandardActivity */
public class i0 extends c {
    private String t;

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        d.i();
        super.onBackPressed();
    }

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

    public void startActivity(Intent intent, Bundle bundle) {
        intent.putExtra("parent_activity", getTitle().toString().replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim());
        super.startActivity(intent, bundle);
    }

    @Override // androidx.fragment.app.d
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        intent.putExtra("parent_activity", getTitle().toString().replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim());
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        this.t = getString(i2);
        ((App) getApplication()).e(this.t);
        super.setTitle(i2);
    }
}
