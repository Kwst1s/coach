package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import vainstrum.Components.LinearLayoutTracking;

public class LinearLayoutButtonRole extends LinearLayoutTracking {
    public LinearLayoutButtonRole(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // vainstrum.Components.LinearLayoutTracking
    public CharSequence getAccessibilityClassName() {
        if (isClickable()) {
            return Button.class.getName();
        }
        return super.getAccessibilityClassName();
    }

    @Override // vainstrum.Components.LinearLayoutTracking
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(16);
    }
}
