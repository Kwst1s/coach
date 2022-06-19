package vainstrum.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import k.b.b;
import k.d;
import org.json.JSONException;
import org.json.JSONObject;

public class TextViewTracking extends AppCompatTextView {

    /* renamed from: f  reason: collision with root package name */
    private String f11068f;

    /* renamed from: g  reason: collision with root package name */
    private String f11069g = null;

    public TextViewTracking(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context, attributeSet);
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f10762a);
        this.f11068f = obtainStyledAttributes.getString(d.f10763b);
        obtainStyledAttributes.recycle();
    }

    public CharSequence getAccessibilityClassName() {
        if (isClickable()) {
            return Button.class.getName();
        }
        return super.getAccessibilityClassName();
    }

    public String getForceName() {
        return this.f11069g;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(16);
    }

    public boolean performClick() {
        try {
            JSONObject f2 = b.f(getContext(), this.f11068f);
            if (f2 != null) {
                String str = this.f11069g;
                if (str == null) {
                    str = f2.getString("name");
                }
                k.b.d.a(str);
            } else {
                String str2 = this.f11069g;
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
        this.f11069g = str;
    }

    public void setTrackingId(String str) {
        this.f11068f = str;
    }
}
