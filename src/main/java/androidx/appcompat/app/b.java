package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog */
public class b extends g implements DialogInterface {

    /* renamed from: d  reason: collision with root package name */
    final AlertController f160d = new AlertController(getContext(), this, getWindow());

    /* compiled from: AlertDialog */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f161a;

        /* renamed from: b  reason: collision with root package name */
        private final int f162b;

        public a(Context context) {
            this(context, b.g(context, 0));
        }

        public b a() {
            b bVar = new b(this.f161a.f135a, this.f162b);
            this.f161a.a(bVar.f160d);
            bVar.setCancelable(this.f161a.r);
            if (this.f161a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f161a.s);
            bVar.setOnDismissListener(this.f161a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f161a.u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f161a.f135a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f161a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a d(boolean z) {
            this.f161a.r = z;
            return this;
        }

        public a e(View view) {
            this.f161a.f141g = view;
            return this;
        }

        public a f(Drawable drawable) {
            this.f161a.f138d = drawable;
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f161a.f142h = charSequence;
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f161a;
            fVar.l = fVar.f135a.getText(i2);
            this.f161a.n = onClickListener;
            return this;
        }

        public a i(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f161a;
            fVar.o = fVar.f135a.getText(i2);
            this.f161a.q = onClickListener;
            return this;
        }

        public a j(DialogInterface.OnKeyListener onKeyListener) {
            this.f161a.u = onKeyListener;
            return this;
        }

        public a k(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f161a;
            fVar.f143i = fVar.f135a.getText(i2);
            this.f161a.f145k = onClickListener;
            return this;
        }

        public a l(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f161a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public a m(int i2) {
            AlertController.f fVar = this.f161a;
            fVar.f140f = fVar.f135a.getText(i2);
            return this;
        }

        public a n(CharSequence charSequence) {
            this.f161a.f140f = charSequence;
            return this;
        }

        public a(Context context, int i2) {
            this.f161a = new AlertController.f(new ContextThemeWrapper(context, b.g(context, i2)));
            this.f162b = i2;
        }
    }

    protected b(Context context, int i2) {
        super(context, g(context, i2));
    }

    static int g(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button e(int i2) {
        return this.f160d.c(i2);
    }

    public ListView f() {
        return this.f160d.e();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.g
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f160d.f();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f160d.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f160d.i(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Dialog, androidx.appcompat.app.g
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f160d.r(charSequence);
    }
}
