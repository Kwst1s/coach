package j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f10682a = Logger.getLogger(l.class.getName());

    /* access modifiers changed from: package-private */
    /* compiled from: Okio */
    public class a implements s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f10683b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OutputStream f10684c;

        a(u uVar, OutputStream outputStream) {
            this.f10683b = uVar;
            this.f10684c = outputStream;
        }

        @Override // j.s
        public u c() {
            return this.f10683b;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        public void close() {
            this.f10684c.close();
        }

        @Override // j.s
        public void e(c cVar, long j2) {
            v.b(cVar.f10663c, 0, j2);
            while (j2 > 0) {
                this.f10683b.f();
                p pVar = cVar.f10662b;
                int min = (int) Math.min(j2, (long) (pVar.f10698c - pVar.f10697b));
                this.f10684c.write(pVar.f10696a, pVar.f10697b, min);
                int i2 = pVar.f10697b + min;
                pVar.f10697b = i2;
                long j3 = (long) min;
                j2 -= j3;
                cVar.f10663c -= j3;
                if (i2 == pVar.f10698c) {
                    cVar.f10662b = pVar.b();
                    q.a(pVar);
                }
            }
        }

        @Override // j.s, java.io.Flushable
        public void flush() {
            this.f10684c.flush();
        }

        public String toString() {
            return "sink(" + this.f10684c + ")";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Okio */
    public class b implements t {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f10685b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InputStream f10686c;

        b(u uVar, InputStream inputStream) {
            this.f10685b = uVar;
            this.f10686c = inputStream;
        }

        @Override // j.t
        public u c() {
            return this.f10685b;
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f10686c.close();
        }

        public String toString() {
            return "source(" + this.f10686c + ")";
        }

        @Override // j.t
        public long v(c cVar, long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (j2 == 0) {
                return 0;
            } else {
                try {
                    this.f10685b.f();
                    p V = cVar.V(1);
                    int read = this.f10686c.read(V.f10696a, V.f10698c, (int) Math.min(j2, (long) (8192 - V.f10698c)));
                    if (read == -1) {
                        return -1;
                    }
                    V.f10698c += read;
                    long j3 = (long) read;
                    cVar.f10663c += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (l.e(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }
    }

    /* compiled from: Okio */
    class c implements s {
        c() {
        }

        @Override // j.s
        public u c() {
            return u.f10707d;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        public void close() {
        }

        @Override // j.s
        public void e(c cVar, long j2) {
            cVar.b(j2);
        }

        @Override // j.s, java.io.Flushable
        public void flush() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Okio */
    public class d extends a {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Socket f10687k;

        d(Socket socket) {
            this.f10687k = socket;
        }

        /* access modifiers changed from: protected */
        @Override // j.a
        public IOException o(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        @Override // j.a
        public void t() {
            try {
                this.f10687k.close();
            } catch (Exception e2) {
                Logger logger = l.f10682a;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.f10687k, (Throwable) e2);
            } catch (AssertionError e3) {
                if (l.e(e3)) {
                    Logger logger2 = l.f10682a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.f10687k, (Throwable) e3);
                    return;
                }
                throw e3;
            }
        }
    }

    private l() {
    }

    public static s a(File file) {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s b() {
        return new c();
    }

    public static d c(s sVar) {
        return new n(sVar);
    }

    public static e d(t tVar) {
        return new o(tVar);
    }

    static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s f(File file) {
        if (file != null) {
            return g(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s g(OutputStream outputStream) {
        return h(outputStream, new u());
    }

    private static s h(OutputStream outputStream, u uVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (uVar != null) {
            return new a(uVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s i(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            a n = n(socket);
            return n.r(h(socket.getOutputStream(), n));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static t j(File file) {
        if (file != null) {
            return k(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static t k(InputStream inputStream) {
        return l(inputStream, new u());
    }

    private static t l(InputStream inputStream, u uVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (uVar != null) {
            return new b(uVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static t m(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            a n = n(socket);
            return n.s(l(socket.getInputStream(), n));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static a n(Socket socket) {
        return new d(socket);
    }
}
