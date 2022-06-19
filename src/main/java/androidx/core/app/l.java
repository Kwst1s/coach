package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput */
public final class l {
    static RemoteInput a(l lVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(lVar.i()).setLabel(lVar.h()).setChoices(lVar.e()).setAllowFreeFormInput(lVar.c()).addExtras(lVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(lVar.f());
        }
        return addExtras.build();
    }

    static RemoteInput[] b(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[lVarArr.length];
        for (int i2 = 0; i2 < lVarArr.length; i2++) {
            remoteInputArr[i2] = a(lVarArr[i2]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        throw null;
    }

    public Set<String> d() {
        throw null;
    }

    public CharSequence[] e() {
        throw null;
    }

    public int f() {
        throw null;
    }

    public Bundle g() {
        throw null;
    }

    public CharSequence h() {
        throw null;
    }

    public String i() {
        throw null;
    }
}
