package b.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.x;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater */
public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f2077e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f2078f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f2079a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f2080b;

    /* renamed from: c  reason: collision with root package name */
    Context f2081c;

    /* renamed from: d  reason: collision with root package name */
    private Object f2082d;

    /* access modifiers changed from: private */
    /* compiled from: SupportMenuInflater */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f2083c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f2084a;

        /* renamed from: b  reason: collision with root package name */
        private Method f2085b;

        public a(Object obj, String str) {
            this.f2084a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2085b = cls.getMethod(str, f2083c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2085b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2085b.invoke(this.f2084a, menuItem)).booleanValue();
                }
                this.f2085b.invoke(this.f2084a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: SupportMenuInflater */
    public class b {
        b.h.k.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f2086a;

        /* renamed from: b  reason: collision with root package name */
        private int f2087b;

        /* renamed from: c  reason: collision with root package name */
        private int f2088c;

        /* renamed from: d  reason: collision with root package name */
        private int f2089d;

        /* renamed from: e  reason: collision with root package name */
        private int f2090e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2091f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2092g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2093h;

        /* renamed from: i  reason: collision with root package name */
        private int f2094i;

        /* renamed from: j  reason: collision with root package name */
        private int f2095j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f2096k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f2086a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f2081c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f2081c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    ((i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f2077e, g.this.f2079a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            b.h.k.b bVar = this.A;
            if (bVar != null) {
                b.h.k.i.a(menuItem, bVar);
            }
            b.h.k.i.c(menuItem, this.B);
            b.h.k.i.g(menuItem, this.C);
            b.h.k.i.b(menuItem, this.n, this.o);
            b.h.k.i.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                b.h.k.i.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                b.h.k.i.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2093h = true;
            i(this.f2086a.add(this.f2087b, this.f2094i, this.f2095j, this.f2096k));
        }

        public SubMenu b() {
            this.f2093h = true;
            SubMenu addSubMenu = this.f2086a.addSubMenu(this.f2087b, this.f2094i, this.f2095j, this.f2096k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f2093h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f2081c.obtainStyledAttributes(attributeSet, b.a.j.g1);
            this.f2087b = obtainStyledAttributes.getResourceId(b.a.j.i1, 0);
            this.f2088c = obtainStyledAttributes.getInt(b.a.j.k1, 0);
            this.f2089d = obtainStyledAttributes.getInt(b.a.j.l1, 0);
            this.f2090e = obtainStyledAttributes.getInt(b.a.j.m1, 0);
            this.f2091f = obtainStyledAttributes.getBoolean(b.a.j.j1, true);
            this.f2092g = obtainStyledAttributes.getBoolean(b.a.j.h1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            q0 u2 = q0.u(g.this.f2081c, attributeSet, b.a.j.n1);
            this.f2094i = u2.n(b.a.j.q1, 0);
            this.f2095j = (u2.k(b.a.j.t1, this.f2088c) & -65536) | (u2.k(b.a.j.u1, this.f2089d) & 65535);
            this.f2096k = u2.p(b.a.j.v1);
            this.l = u2.p(b.a.j.w1);
            this.m = u2.n(b.a.j.o1, 0);
            this.n = c(u2.o(b.a.j.x1));
            this.o = u2.k(b.a.j.E1, 4096);
            this.p = c(u2.o(b.a.j.y1));
            this.q = u2.k(b.a.j.I1, 4096);
            int i2 = b.a.j.z1;
            if (u2.s(i2)) {
                this.r = u2.a(i2, false) ? 1 : 0;
            } else {
                this.r = this.f2090e;
            }
            this.s = u2.a(b.a.j.r1, false);
            this.t = u2.a(b.a.j.s1, this.f2091f);
            this.u = u2.a(b.a.j.p1, this.f2092g);
            this.v = u2.k(b.a.j.J1, -1);
            this.z = u2.o(b.a.j.A1);
            this.w = u2.n(b.a.j.B1, 0);
            this.x = u2.o(b.a.j.D1);
            String o2 = u2.o(b.a.j.C1);
            this.y = o2;
            boolean z2 = o2 != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (b.h.k.b) e(o2, g.f2078f, g.this.f2080b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u2.p(b.a.j.F1);
            this.C = u2.p(b.a.j.K1);
            int i3 = b.a.j.H1;
            if (u2.s(i3)) {
                this.E = x.e(u2.k(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = b.a.j.G1;
            if (u2.s(i4)) {
                this.D = u2.c(i4);
            } else {
                this.D = null;
            }
            u2.w();
            this.f2093h = false;
        }

        public void h() {
            this.f2087b = 0;
            this.f2088c = 0;
            this.f2089d = 0;
            this.f2090e = 0;
            this.f2091f = true;
            this.f2092g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f2077e = clsArr;
        f2078f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f2081c = context;
        Object[] objArr = {context};
        this.f2079a = objArr;
        this.f2080b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                b.h.k.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f2082d == null) {
            this.f2082d = a(this.f2081c);
        }
        return this.f2082d;
    }

    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof b.h.f.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f2081c.getResources().getLayout(i2);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
