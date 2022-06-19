package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.f;
import com.github.mikephil.charting.BuildConfig;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: g  reason: collision with root package name */
    private static final StackTraceElement[] f3647g = new StackTraceElement[0];

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f3648b;

    /* renamed from: c  reason: collision with root package name */
    private f f3649c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.load.a f3650d;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f3651e;

    /* renamed from: f  reason: collision with root package name */
    private String f3652f;

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable th2 : ((GlideException) th).f()) {
                a(th2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void c(List<Throwable> list, Appendable appendable) {
        try {
            d(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void d(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).i(appendable);
            } else {
                e(th, appendable);
            }
            i2 = i3;
        }
    }

    private static void e(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void i(Appendable appendable) {
        e(this, appendable);
        c(f(), new a(appendable));
    }

    public List<Throwable> f() {
        return this.f3648b;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> g() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f3652f);
        Class<?> cls = this.f3651e;
        String str = BuildConfig.FLAVOR;
        sb.append(cls != null ? ", " + this.f3651e : str);
        sb.append(this.f3650d != null ? ", " + this.f3650d : str);
        if (this.f3649c != null) {
            str = ", " + this.f3649c;
        }
        sb.append(str);
        List<Throwable> g2 = g();
        if (g2.isEmpty()) {
            return sb.toString();
        }
        if (g2.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(g2.size());
            sb.append(" causes:");
        }
        for (Throwable th : g2) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void h(String str) {
        List<Throwable> g2 = g();
        int size = g2.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), g2.get(i2));
            i2 = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void j(f fVar, com.bumptech.glide.load.a aVar) {
        k(fVar, aVar, null);
    }

    /* access modifiers changed from: package-private */
    public void k(f fVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.f3649c = fVar;
        this.f3650d = aVar;
        this.f3651e = cls;
    }

    public void l(Exception exc) {
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        i(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f3652f = str;
        setStackTrace(f3647g);
        this.f3648b = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        i(printWriter);
    }

    /* access modifiers changed from: private */
    public static final class a implements Appendable {

        /* renamed from: b  reason: collision with root package name */
        private final Appendable f3653b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3654c = true;

        a(Appendable appendable) {
            this.f3653b = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? BuildConfig.FLAVOR : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) {
            boolean z = false;
            if (this.f3654c) {
                this.f3654c = false;
                this.f3653b.append("  ");
            }
            if (c2 == '\n') {
                z = true;
            }
            this.f3654c = z;
            this.f3653b.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence a2 = a(charSequence);
            append(a2, 0, a2.length());
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i2, int i3) {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f3654c) {
                this.f3654c = false;
                this.f3653b.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f3654c = z;
            this.f3653b.append(a2, i2, i3);
            return this;
        }
    }
}
