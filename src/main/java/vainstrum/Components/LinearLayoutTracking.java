package vainstrum.Components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import k.b.b;
import k.d;
import org.json.JSONException;
import org.json.JSONObject;

public class LinearLayoutTracking extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private String f11065b;

    /* renamed from: c  reason: collision with root package name */
    private String f11066c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f11067d = null;

    public LinearLayoutTracking(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f10762a);
        this.f11065b = obtainStyledAttributes.getString(d.f10763b);
        obtainStyledAttributes.recycle();
    }

    public CharSequence getAccessibilityClassName() {
        if (isClickable()) {
            return Button.class.getName();
        }
        return super.getAccessibilityClassName();
    }

    public String getForceName() {
        return this.f11066c;
    }

    public String getForceView() {
        return this.f11067d;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(16);
    }

    public boolean performClick() {
        try {
            if (this.f11065b != null) {
                JSONObject f2 = b.f(getContext(), this.f11065b);
                if (f2 != null) {
                    String str = this.f11066c;
                    if (str == null) {
                        str = f2.getString("name");
                    }
                    k.b.d.a(str);
                } else {
                    String str2 = this.f11066c;
                    if (str2 != null) {
                        k.b.d.a(str2);
                    }
                }
            } else {
                String str3 = this.f11066c;
                if (str3 != null) {
                    k.b.d.a(str3);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.performClick();
    }

    public void setForceName(String str) {
        this.f11066c = str;
    }

    public void setForceView(String str) {
        this.f11067d = str;
    }

    public void setTrackingId(String str) {
        this.f11065b = str;
    }
}
