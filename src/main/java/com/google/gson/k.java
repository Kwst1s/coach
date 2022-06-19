package com.google.gson;

import com.google.gson.stream.a;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class k {
    public i a() {
        if (d()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m b() {
        if (f()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n c() {
        if (g()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof i;
    }

    public boolean e() {
        return this instanceof l;
    }

    public boolean f() {
        return this instanceof m;
    }

    public boolean g() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            a aVar = new a(stringWriter);
            aVar.W(true);
            com.google.gson.u.k.a(this, aVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
