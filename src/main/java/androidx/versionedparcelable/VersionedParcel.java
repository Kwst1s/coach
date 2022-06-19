package androidx.versionedparcelable;

import android.os.Parcelable;
import b.e.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    protected final a<String, Method> f1851a;

    /* renamed from: b  reason: collision with root package name */
    protected final a<String, Method> f1852b;

    /* renamed from: c  reason: collision with root package name */
    protected final a<String, Class> f1853c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        this.f1851a = aVar;
        this.f1852b = aVar2;
        this.f1853c = aVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: androidx.versionedparcelable.VersionedParcel */
    /* JADX WARN: Multi-variable type inference failed */
    private void N(b bVar) {
        try {
            I(c(bVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Class c(Class<? extends b> cls) {
        Class cls2 = this.f1853c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1853c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = this.f1851a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f1851a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) {
        Method method = this.f1852b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f1852b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    /* access modifiers changed from: protected */
    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    /* access modifiers changed from: protected */
    public <T extends b> void K(T t, VersionedParcel versionedParcel) {
        try {
            e(t.getClass()).invoke(null, t, versionedParcel);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public void L(b bVar) {
        if (bVar == null) {
            I(null);
            return;
        }
        N(bVar);
        VersionedParcel b2 = b();
        K(bVar, b2);
        b2.a();
    }

    public void M(b bVar, int i2) {
        w(i2);
        L(bVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    public boolean h(boolean z, int i2) {
        if (!m(i2)) {
            return z;
        }
        return g();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        if (!m(i2)) {
            return bArr;
        }
        return i();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        if (!m(i2)) {
            return charSequence;
        }
        return k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean m(int i2);

    /* access modifiers changed from: protected */
    public <T extends b> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (T) ((b) d(str).invoke(null, versionedParcel));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int o();

    public int p(int i2, int i3) {
        if (!m(i3)) {
            return i2;
        }
        return o();
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t, int i2) {
        return !m(i2) ? t : (T) q();
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    public String t(String str, int i2) {
        if (!m(i2)) {
            return str;
        }
        return s();
    }

    /* access modifiers changed from: protected */
    public <T extends b> T u() {
        String s = s();
        if (s == null) {
            return null;
        }
        return (T) n(s, b());
    }

    public <T extends b> T v(T t, int i2) {
        return !m(i2) ? t : (T) u();
    }

    /* access modifiers changed from: protected */
    public abstract void w(int i2);

    public void x(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void y(boolean z);

    public void z(boolean z, int i2) {
        w(i2);
        y(z);
    }
}
