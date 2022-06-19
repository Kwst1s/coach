package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import b.h.j.h;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatTextClassifierHelper */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private TextView f735a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f736b;

    r(TextView textView) {
        h.c(textView);
        this.f735a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f736b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f735a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f736b = textClassifier;
    }
}
