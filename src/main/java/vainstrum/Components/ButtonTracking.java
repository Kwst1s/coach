package vainstrum.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import k.b.b;
import k.d;
import org.json.JSONException;
import org.json.JSONObject;

public class ButtonTracking extends AppCompatButton {

    /* renamed from: d  reason: collision with root package name */
    private String f11061d;

    /* renamed from: e  reason: collision with root package name */
    private String f11062e = null;

    public ButtonTracking(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f10762a);
        this.f11061d = obtainStyledAttributes.getString(d.f10763b);
        obtainStyledAttributes.recycle();
    }

    public String getForceName() {
        return this.f11062e;
    }

    public boolean performClick() {
        try {
            JSONObject f2 = b.f(getContext(), this.f11061d);
            if (f2 != null) {
                String str = this.f11062e;
                if (str == null) {
                    str = f2.getString("name");
                }
                k.b.d.a(str);
            } else {
                String str2 = this.f11062e;
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
        this.f11062e = str;
    }

    public void setTrackingId(String str) {
        this.f11061d = str;
    }

    public ButtonTracking(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }
}
