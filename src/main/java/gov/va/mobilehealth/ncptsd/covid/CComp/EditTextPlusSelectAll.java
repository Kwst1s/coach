package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class EditTextPlusSelectAll extends AppCompatEditText {
    public EditTextPlusSelectAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelectionChanged(int i2, int i3) {
        Editable text = getText();
        if (text != null) {
            setSelection(0, text.length());
        } else {
            super.onSelectionChanged(i2, i3);
        }
    }
}
