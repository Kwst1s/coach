package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer implements u {

    /* renamed from: a  reason: collision with root package name */
    private final u f4600a;

    public static final class ValidationException extends RuntimeException {
        public ValidationException(String str, List<String> list) {
            super(str + ": " + TextUtils.join("\n  - ", list));
        }
    }

    public ValidationEnforcer(u uVar) {
        this.f4600a = uVar;
    }

    private static void b(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }

    @Override // com.firebase.jobdispatcher.u
    public List<String> a(r rVar) {
        return this.f4600a.a(rVar);
    }

    public final void c(r rVar) {
        b(a(rVar));
    }
}
