package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import b.l.c;

/* access modifiers changed from: package-private */
/* compiled from: FragmentLayoutInflaterFactory */
public class k implements LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    private final m f1280b;

    k(m mVar) {
        this.f1280b = mVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.f1280b);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f2773a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(c.f2774b);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.f2775c, -1);
        String string = obtainStyledAttributes.getString(c.f2776d);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f1280b.X(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f1280b.Y(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f1280b.X(id);
        }
        if (m.s0(2)) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
        }
        if (fragment == null) {
            fragment = this.f1280b.h0().a(context.getClassLoader(), attributeValue);
            fragment.n = true;
            fragment.w = resourceId != 0 ? resourceId : id;
            fragment.x = id;
            fragment.y = string;
            fragment.o = true;
            m mVar = this.f1280b;
            fragment.s = mVar;
            j<?> jVar = mVar.o;
            fragment.t = jVar;
            fragment.A0(jVar.h(), attributeSet, fragment.f1211c);
            this.f1280b.d(fragment);
            this.f1280b.D0(fragment);
        } else if (!fragment.o) {
            fragment.o = true;
            j<?> jVar2 = this.f1280b.o;
            fragment.t = jVar2;
            fragment.A0(jVar2.h(), attributeSet, fragment.f1211c);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        m mVar2 = this.f1280b;
        if (mVar2.n >= 1 || !fragment.n) {
            mVar2.D0(fragment);
        } else {
            mVar2.E0(fragment, 1);
        }
        View view2 = fragment.H;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.H.getTag() == null) {
                fragment.H.setTag(string);
            }
            return fragment.H;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
