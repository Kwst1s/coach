package f.a.a.a.b.f;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.c;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import at.grabner.circleprogress.CircleProgressView;
import com.github.mikephil.charting.R;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: FragDialogDownload */
public class i extends c {
    private CircleProgressView l0;
    private float m0 = Utils.FLOAT_EPSILON;

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void L0() {
        super.L0();
        Dialog O1 = O1();
        if (O1 != null) {
            O1.setCancelable(false);
            O1.getWindow().setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.c
    public void M1() {
        try {
            super.M1();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.c
    public void U1(m mVar, String str) {
        try {
            u j2 = mVar.j();
            j2.f(this, str);
            j2.j();
        } catch (IllegalStateException e2) {
            Log.d("ABSDIALOGFRAG", "Exception", e2);
        }
    }

    public void V1(float f2) {
        CircleProgressView circleProgressView = this.l0;
        if (circleProgressView != null) {
            circleProgressView.setMaxValue(f2);
        }
    }

    public void W1(float f2) {
        CircleProgressView circleProgressView = this.l0;
        if (circleProgressView != null) {
            circleProgressView.l(this.m0, f2, 350);
            this.m0 = f2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_frag_download, viewGroup, false);
        this.l0 = (CircleProgressView) inflate.findViewById(R.id.download_pview);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.download_txt);
        O1().requestWindowFeature(1);
        O1().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.l0.p();
        this.l0.l(Utils.FLOAT_EPSILON, this.m0, 350);
        return inflate;
    }
}
