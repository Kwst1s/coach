package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.k.e;
import b.f.b.k.h;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: ConstraintHelper */
public abstract class b extends View {

    /* renamed from: b  reason: collision with root package name */
    protected int[] f904b;

    /* renamed from: c  reason: collision with root package name */
    protected int f905c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f906d;

    /* renamed from: e  reason: collision with root package name */
    protected h f907e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f908f;

    /* renamed from: g  reason: collision with root package name */
    protected String f909g;

    /* renamed from: h  reason: collision with root package name */
    protected String f910h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<Integer, String> f911i;

    public b(Context context) {
        super(context);
        this.f904b = new int[32];
        this.f908f = false;
        this.f911i = new HashMap<>();
        this.f906d = context;
        h(null);
    }

    private void a(String str) {
        if (str != null && str.length() != 0 && this.f906d != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int g2 = g(trim);
            if (g2 != 0) {
                this.f911i.put(Integer.valueOf(g2), trim);
                b(g2);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void b(int i2) {
        if (i2 != getId()) {
            int i3 = this.f905c + 1;
            int[] iArr = this.f904b;
            if (i3 > iArr.length) {
                this.f904b = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f904b;
            int i4 = this.f905c;
            iArr2[i4] = i2;
            this.f905c = i4 + 1;
        }
    }

    private void c(String str) {
        if (!(str == null || str.length() == 0 || this.f906d == null)) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).U)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        b(childAt.getId());
                    }
                }
            }
        }
    }

    private int f(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f906d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int g(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object g2 = constraintLayout.g(0, str);
            if (g2 instanceof Integer) {
                i2 = ((Integer) g2).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = f(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = h.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.f906d.getResources().getIdentifier(str, "id", this.f906d.getPackageName()) : i2;
    }

    /* access modifiers changed from: protected */
    public void d() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            e((ConstraintLayout) parent);
        }
    }

    /* access modifiers changed from: protected */
    public void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : Utils.FLOAT_EPSILON;
        for (int i2 = 0; i2 < this.f905c; i2++) {
            View i3 = constraintLayout.i(this.f904b[i2]);
            if (i3 != null) {
                i3.setVisibility(visibility);
                if (elevation > Utils.FLOAT_EPSILON && Build.VERSION.SDK_INT >= 21) {
                    i3.setTranslationZ(i3.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f904b, this.f905c);
    }

    /* access modifiers changed from: protected */
    public void h(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.J0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.V0) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f909g = string;
                    setIds(string);
                } else if (index == i.W0) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f910h = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void i(e eVar, boolean z) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
    }

    public void m(ConstraintLayout constraintLayout) {
        String str;
        int f2;
        if (isInEditMode()) {
            setIds(this.f909g);
        }
        h hVar = this.f907e;
        if (hVar != null) {
            hVar.c();
            for (int i2 = 0; i2 < this.f905c; i2++) {
                int i3 = this.f904b[i2];
                View i4 = constraintLayout.i(i3);
                if (i4 == null && (f2 = f(constraintLayout, (str = this.f911i.get(Integer.valueOf(i3))))) != 0) {
                    this.f904b[i2] = f2;
                    this.f911i.put(Integer.valueOf(f2), str);
                    i4 = constraintLayout.i(f2);
                }
                if (i4 != null) {
                    this.f907e.a(constraintLayout.j(i4));
                }
            }
            this.f907e.b(constraintLayout.f859d);
        }
    }

    public void n() {
        if (this.f907e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ConstraintLayout.b) layoutParams).m0 = (e) this.f907e;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f909g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f910h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f908f) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.f909g = str;
        if (str != null) {
            int i2 = 0;
            this.f905c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.f910h = str;
        if (str != null) {
            int i2 = 0;
            this.f905c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    c(str.substring(i2));
                    return;
                } else {
                    c(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f909g = null;
        this.f905c = 0;
        for (int i2 : iArr) {
            b(i2);
        }
    }

    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f909g == null) {
            b(i2);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f904b = new int[32];
        this.f908f = false;
        this.f911i = new HashMap<>();
        this.f906d = context;
        h(attributeSet);
    }
}
