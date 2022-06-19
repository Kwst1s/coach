package com.google.gson;

import com.google.gson.u.a;
import com.google.gson.u.f;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class n extends k {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8312a;

    public n(Boolean bool) {
        a.b(bool);
        this.f8312a = bool;
    }

    private static boolean l(n nVar) {
        Object obj = nVar.f8312a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f8312a == null) {
            if (nVar.f8312a == null) {
                return true;
            }
            return false;
        } else if (!l(this) || !l(nVar)) {
            Object obj2 = this.f8312a;
            if (!(obj2 instanceof Number) || !(nVar.f8312a instanceof Number)) {
                return obj2.equals(nVar.f8312a);
            }
            double doubleValue = i().doubleValue();
            double doubleValue2 = nVar.i().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (i().longValue() == nVar.i().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean h() {
        if (k()) {
            return ((Boolean) this.f8312a).booleanValue();
        }
        return Boolean.parseBoolean(j());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f8312a == null) {
            return 31;
        }
        if (l(this)) {
            doubleToLongBits = i().longValue();
        } else {
            Object obj = this.f8312a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(i().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public Number i() {
        Object obj = this.f8312a;
        return obj instanceof String ? new f((String) this.f8312a) : (Number) obj;
    }

    public String j() {
        if (m()) {
            return i().toString();
        }
        if (k()) {
            return ((Boolean) this.f8312a).toString();
        }
        return (String) this.f8312a;
    }

    public boolean k() {
        return this.f8312a instanceof Boolean;
    }

    public boolean m() {
        return this.f8312a instanceof Number;
    }

    public boolean n() {
        return this.f8312a instanceof String;
    }

    public n(Number number) {
        a.b(number);
        this.f8312a = number;
    }

    public n(String str) {
        a.b(str);
        this.f8312a = str;
    }
}
