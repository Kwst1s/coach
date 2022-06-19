package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.l;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.q;
import b.a.j;
import b.a.o.d;
import b.e.g;
import b.h.k.u;
import com.github.mikephil.charting.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppCompatViewInflater */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f209b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f210c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f211d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    private static final g<String, Constructor<? extends View>> f212e = new g<>();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f213a = new Object[2];

    /* access modifiers changed from: private */
    /* compiled from: AppCompatViewInflater */
    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f214b;

        /* renamed from: c  reason: collision with root package name */
        private final String f215c;

        /* renamed from: d  reason: collision with root package name */
        private Method f216d;

        /* renamed from: e  reason: collision with root package name */
        private Context f217e;

        public a(View view, String str) {
            this.f214b = view;
            this.f215c = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f215c, View.class)) != null) {
                        this.f216d = method;
                        this.f217e = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f214b.getId();
            if (id == -1) {
                str = BuildConfig.FLAVOR;
            } else {
                str = " with id '" + this.f214b.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f215c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f214b.getClass() + str);
        }

        public void onClick(View view) {
            if (this.f216d == null) {
                a(this.f214b.getContext());
            }
            try {
                this.f216d.invoke(this.f217e, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || u.N(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f210c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View r(Context context, String str, String str2) {
        String str3;
        g<String, Constructor<? extends View>> gVar = f212e;
        Constructor<? extends View> constructor = gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f209b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f213a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f213a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i2 = 0;
                while (true) {
                    String[] strArr = f211d;
                    if (i2 < strArr.length) {
                        View r = r(context, str, strArr[i2]);
                        if (r != null) {
                            return r;
                        }
                        i2++;
                    } else {
                        Object[] objArr2 = this.f213a;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View r2 = r(context, str, null);
                Object[] objArr3 = this.f213a;
                objArr3[0] = null;
                objArr3[1] = null;
                return r2;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.f213a;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.A3, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(j.B3, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.C3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return (!(context instanceof d) || ((d) context).c() != resourceId) ? new d(context, resourceId) : context;
        }
        return context;
    }

    private void u(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatCheckBox d(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public f e(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatEditText f(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.j g(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.j(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatImageView h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public l i(Context context, AttributeSet attributeSet) {
        return new l(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public o k(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatSeekBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public q m(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatTextView n(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.u o(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.u(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = t(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = n0.b(context2);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = '\r';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view2 = k(context2, attributeSet);
                u(view2, str);
                break;
            case 1:
                view2 = e(context2, attributeSet);
                u(view2, str);
                break;
            case 2:
                view2 = i(context2, attributeSet);
                u(view2, str);
                break;
            case 3:
                view2 = n(context2, attributeSet);
                u(view2, str);
                break;
            case 4:
                view2 = g(context2, attributeSet);
                u(view2, str);
                break;
            case 5:
                view2 = l(context2, attributeSet);
                u(view2, str);
                break;
            case 6:
                view2 = m(context2, attributeSet);
                u(view2, str);
                break;
            case 7:
                view2 = j(context2, attributeSet);
                u(view2, str);
                break;
            case '\b':
                view2 = o(context2, attributeSet);
                u(view2, str);
                break;
            case '\t':
                view2 = h(context2, attributeSet);
                u(view2, str);
                break;
            case '\n':
                view2 = b(context2, attributeSet);
                u(view2, str);
                break;
            case 11:
                view2 = d(context2, attributeSet);
                u(view2, str);
                break;
            case '\f':
                view2 = f(context2, attributeSet);
                u(view2, str);
                break;
            case '\r':
                view2 = c(context2, attributeSet);
                u(view2, str);
                break;
            default:
                view2 = p(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = s(context2, str, attributeSet);
        }
        if (view2 != null) {
            a(view2, attributeSet);
        }
        return view2;
    }
}
