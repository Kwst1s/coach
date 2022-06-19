package vainstrum.Components;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.BuildConfig;
import java.util.concurrent.TimeUnit;
import k.b.d;

/* compiled from: Fragment_Tracking */
public class b extends Fragment {
    private String X;
    private long Y;
    private String Z;
    private boolean a0 = false;
    private boolean b0 = false;

    /* compiled from: Fragment_Tracking */
    class a implements Runnable {
        a() {
        }

        public void run() {
            if (b.this.n() != null) {
                if (b.this.n().getIntent() != null && b.this.n().getIntent().getExtras() != null && b.this.Z == null && !b.this.a0) {
                    b bVar = b.this;
                    bVar.Z = bVar.n().getIntent().getStringExtra("parent_activity");
                }
                if (b.this.X == null) {
                    b bVar2 = b.this;
                    bVar2.X = bVar2.n().getTitle().toString();
                }
            }
            b.this.Y = System.currentTimeMillis();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void E0() {
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(Intent intent, Bundle bundle) {
        if (this.X == null) {
            this.X = n().getTitle().toString();
        }
        intent.putExtra("parent_activity", this.X.replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim());
        super.G1(intent, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(Intent intent, int i2, Bundle bundle) {
        if (this.X == null) {
            this.X = n().getTitle().toString();
        }
        intent.putExtra("parent_activity", this.X.replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim());
        super.I1(intent, i2, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void L0() {
        new Handler().postDelayed(new a(), 450);
        super.L0();
    }

    @Override // androidx.fragment.app.Fragment
    public void M0() {
        Q1();
        super.M0();
    }

    public void Q1() {
        if (!this.b0) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.Y);
            String str = this.X;
            if (str != null) {
                d.n(n(), str.replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim().trim(), this.Z, seconds);
            }
            d.d();
        }
    }

    public String R1() {
        return this.X;
    }

    public void S1(String str) {
        this.X = str;
    }

    public void T1(boolean z) {
        this.b0 = z;
    }

    public void U1(boolean z) {
        this.a0 = z;
    }

    public void V1(String str) {
        if (str != null) {
            this.Z = str.replaceAll("heading", BuildConfig.FLAVOR).replaceAll("Heading", BuildConfig.FLAVOR).trim();
        }
    }
}
