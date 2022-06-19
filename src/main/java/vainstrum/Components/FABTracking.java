package vainstrum.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import k.b.b;
import k.d;
import org.json.JSONException;
import org.json.JSONObject;

public class FABTracking extends FloatingActionButton {
    private String t;
    private String u = null;

    public FABTracking(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x(context, attributeSet);
    }

    private void x(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f10762a);
        this.t = obtainStyledAttributes.getString(d.f10763b);
        obtainStyledAttributes.recycle();
    }

    public String getForceName() {
        return this.u;
    }

    public boolean performClick() {
        try {
            JSONObject f2 = b.f(getContext(), this.t);
            if (f2 != null) {
                String str = this.u;
                if (str == null) {
                    str = f2.getString("name");
                }
                k.b.d.a(str);
            } else {
                String str2 = this.u;
                if (str2 != null) {
                    k.b.d.a(str2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.performClick();
    }

    public void setForceName(String str) {
        this.u = str;
    }

    public void setTrackingId(String str) {
        this.t = str;
    }
}
