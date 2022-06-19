package okhttp3.internal.http2;

/* compiled from: ErrorCode */
public enum a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f10880b;

    private a(int i2) {
        this.f10880b = i2;
    }

    public static a a(int i2) {
        a[] values = values();
        for (a aVar : values) {
            if (aVar.f10880b == i2) {
                return aVar;
            }
        }
        return null;
    }
}
