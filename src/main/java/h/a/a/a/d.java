package h.a.a.a;

import java.io.File;

/* compiled from: FileSource */
public class d implements j {

    /* renamed from: a  reason: collision with root package name */
    private File f10213a;

    /* renamed from: b  reason: collision with root package name */
    private File f10214b;

    public d(File file) {
        this.f10213a = file;
    }

    @Override // h.a.a.a.j
    public h a() {
        if (this.f10214b == null) {
            return null;
        }
        h hVar = new h();
        hVar.n(this.f10214b.getAbsolutePath());
        return hVar;
    }

    @Override // h.a.a.a.j
    public h b() {
        h hVar = new h();
        hVar.n(this.f10213a.getAbsolutePath());
        return hVar;
    }
}
