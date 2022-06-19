package com.bumptech.glide.load.m.p;

import java.io.File;

/* compiled from: FileService */
class a {
    a() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
