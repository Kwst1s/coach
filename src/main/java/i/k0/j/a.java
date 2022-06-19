package i.k0.j;

import j.l;
import j.s;
import j.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileSystem */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10545a = new C0236a();

    /* renamed from: i.k0.j.a$a  reason: collision with other inner class name */
    /* compiled from: FileSystem */
    class C0236a implements a {
        C0236a() {
        }

        @Override // i.k0.j.a
        public void a(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // i.k0.j.a
        public t b(File file) {
            return l.j(file);
        }

        @Override // i.k0.j.a
        public s c(File file) {
            try {
                return l.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.f(file);
            }
        }

        @Override // i.k0.j.a
        public void d(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        d(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        @Override // i.k0.j.a
        public s e(File file) {
            try {
                return l.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.a(file);
            }
        }

        @Override // i.k0.j.a
        public boolean f(File file) {
            return file.exists();
        }

        @Override // i.k0.j.a
        public void g(File file, File file2) {
            a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // i.k0.j.a
        public long h(File file) {
            return file.length();
        }
    }

    void a(File file);

    t b(File file);

    s c(File file);

    void d(File file);

    s e(File file);

    boolean f(File file);

    void g(File file, File file2);

    long h(File file);
}
