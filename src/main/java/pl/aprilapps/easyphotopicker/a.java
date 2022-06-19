package pl.aprilapps.easyphotopicker;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: ChooserType.kt */
public final class a extends Enum<a> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f11032b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ a[] f11033c;

    static {
        a aVar = new a("CAMERA_AND_DOCUMENTS", 1);
        f11032b = aVar;
        f11033c = new a[]{new a("CAMERA_AND_GALLERY", 0), aVar};
    }

    private a(String str, int i2) {
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f11033c.clone();
    }
}
