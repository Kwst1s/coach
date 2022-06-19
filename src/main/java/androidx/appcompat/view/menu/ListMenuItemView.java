package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.q0;
import b.a.a;
import b.a.f;
import b.a.g;
import b.a.j;
import b.h.k.u;

public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    private i f283b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f284c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f285d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f286e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f287f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f288g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f289h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f290i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f291j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f292k;
    private int l;
    private Context m;
    private boolean n;
    private Drawable o;
    private boolean p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f291j;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f287f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f284c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f285d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f289h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f290i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f290i.getLayoutParams();
            rect.top += this.f290i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i2) {
        this.f283b = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f283b;
    }

    public void h(boolean z, char c2) {
        int i2 = (!z || !this.f283b.A()) ? 8 : 0;
        if (i2 == 0) {
            this.f288g.setText(this.f283b.h());
        }
        if (this.f288g.getVisibility() != i2) {
            this.f288g.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        u.q0(this, this.f292k);
        TextView textView = (TextView) findViewById(f.title);
        this.f286e = textView;
        int i2 = this.l;
        if (i2 != -1) {
            textView.setTextAppearance(this.m, i2);
        }
        this.f288g = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.f289h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.f290i = (ImageView) findViewById(f.group_divider);
        this.f291j = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f284c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f284c.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f285d != null || this.f287f != null) {
            if (this.f283b.m()) {
                if (this.f285d == null) {
                    g();
                }
                compoundButton2 = this.f285d;
                compoundButton = this.f287f;
            } else {
                if (this.f287f == null) {
                    c();
                }
                compoundButton2 = this.f287f;
                compoundButton = this.f285d;
            }
            if (z) {
                compoundButton2.setChecked(this.f283b.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f287f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f285d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f283b.m()) {
            if (this.f285d == null) {
                g();
            }
            compoundButton = this.f285d;
        } else {
            if (this.f287f == null) {
                c();
            }
            compoundButton = this.f287f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f290i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f283b.z() || this.r;
        if (z || this.n) {
            ImageView imageView = this.f284c;
            if (imageView != null || drawable != null || this.n) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.n) {
                    ImageView imageView2 = this.f284c;
                    if (!z) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f284c.getVisibility() != 0) {
                        this.f284c.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f284c.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f286e.setText(charSequence);
            if (this.f286e.getVisibility() != 0) {
                this.f286e.setVisibility(0);
            }
        } else if (this.f286e.getVisibility() != 8) {
            this.f286e.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        q0 v = q0.v(getContext(), attributeSet, j.L1, i2, 0);
        this.f292k = v.g(j.N1);
        this.l = v.n(j.M1, -1);
        this.n = v.a(j.O1, false);
        this.m = context;
        this.o = v.g(j.P1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        v.w();
        obtainStyledAttributes.recycle();
    }
}
