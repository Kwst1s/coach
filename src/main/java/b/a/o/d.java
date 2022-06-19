package b.a.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import b.a.i;

/* compiled from: ContextThemeWrapper */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f2060a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f2061b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f2062c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f2063d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f2064e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f2064e == null) {
            Configuration configuration = this.f2063d;
            if (configuration == null) {
                this.f2064e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f2064e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f2063d);
                this.f2064e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f2064e;
    }

    private void d() {
        boolean z = this.f2061b == null;
        if (z) {
            this.f2061b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2061b.setTo(theme);
            }
        }
        e(this.f2061b, this.f2060a, z);
    }

    public void a(Configuration configuration) {
        if (this.f2064e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f2063d == null) {
            this.f2063d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f2060a;
    }

    /* access modifiers changed from: protected */
    public void e(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2062c == null) {
            this.f2062c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2062c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2061b;
        if (theme != null) {
            return theme;
        }
        if (this.f2060a == 0) {
            this.f2060a = i.Theme_AppCompat_Light;
        }
        d();
        return this.f2061b;
    }

    public void setTheme(int i2) {
        if (this.f2060a != i2) {
            this.f2060a = i2;
            d();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f2060a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f2061b = theme;
    }
}
