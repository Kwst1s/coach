package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import b.h.d.e.f;
import com.github.mikephil.charting.R;
import com.google.android.material.tabs.TabLayout;

public class FontTabLayout extends TabLayout {
    private Typeface R;

    public FontTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        N();
    }

    private void N() {
        this.R = f.b(getContext(), R.font.font_semibold);
    }

    @Override // com.google.android.material.tabs.TabLayout
    public void d(TabLayout.g gVar) {
        super.d(gVar);
        ((TextView) ((ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(gVar.g())).getChildAt(1)).setTypeface(this.R, 0);
    }
}
