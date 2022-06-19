package vainstrum.Components;

import android.content.Intent;
import androidx.appcompat.app.c;
import com.github.mikephil.charting.BuildConfig;
import java.util.concurrent.TimeUnit;
import k.b.d;

/* compiled from: Activity_Tracking */
public class a extends c {
    private long t;
    private String u;
    private String v;

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        d.i();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStart() {
        this.t = System.currentTimeMillis();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.u = getIntent().getStringExtra("parent_activity");
        }
        super.onStart();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStop() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.t);
        if (this.v != null) {
            d.n(getApplicationContext(), this.v.trim(), this.u, seconds);
        } else {
            d.n(getApplicationContext(), getTitle().toString().replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim().trim(), this.u, seconds);
        }
        d.d();
        super.onStop();
    }

    @Override // androidx.fragment.app.d
    public void startActivityForResult(Intent intent, int i2) {
        String str = this.v;
        if (str != null) {
            intent.putExtra("parent_activity", str);
        } else {
            intent.putExtra("parent_activity", getTitle().toString().replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim());
        }
        super.startActivityForResult(intent, i2);
    }
}
