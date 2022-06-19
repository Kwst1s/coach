package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.f;
import b.i.a.c;
import com.github.mikephil.charting.BuildConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* compiled from: SuggestionsAdapter */
class k0 extends c implements View.OnClickListener {
    private final SearchView m;
    private final SearchableInfo n;
    private final Context o;
    private final WeakHashMap<String, Drawable.ConstantState> p;
    private final int q;
    private boolean r = false;
    private int s = 1;
    private ColorStateList t;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    /* access modifiers changed from: private */
    /* compiled from: SuggestionsAdapter */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f674a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f675b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f676c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f677d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f678e;

        public a(View view) {
            this.f674a = (TextView) view.findViewById(16908308);
            this.f675b = (TextView) view.findViewById(16908309);
            this.f676c = (ImageView) view.findViewById(16908295);
            this.f677d = (ImageView) view.findViewById(16908296);
            this.f678e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public k0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.f2710e.getTheme().resolveAttribute(b.a.a.textColorSearchUrl, typedValue, true);
            this.t = this.f2710e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f2710e.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.p.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.o.getResources());
        }
        Drawable m2 = m(componentName);
        if (m2 != null) {
            constantState = m2.getConstantState();
        }
        this.p.put(flattenToShortString, constantState);
        return m2;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n2 = n(this.n.getSearchActivity());
        if (n2 != null) {
            return n2;
        }
        return this.f2710e.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            } else {
                InputStream openInputStream = this.o.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    try {
                        return Drawable.createFromStream(openInputStream, null);
                    } finally {
                        try {
                            openInputStream.close();
                        } catch (IOException e2) {
                            Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                        }
                    }
                } else {
                    throw new FileNotFoundException("Failed to open " + uri);
                }
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
            Drawable k2 = k(str2);
            if (k2 != null) {
                return k2;
            }
            Drawable d2 = b.h.d.a.d(this.o, parseInt);
            A(str2, d2);
            return d2;
        } catch (NumberFormatException unused) {
            Drawable k3 = k(str);
            if (k3 != null) {
                return k3;
            }
            Drawable q2 = q(Uri.parse(str));
            A(str, q2);
            return q2;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable t(Cursor cursor) {
        int i2 = this.x;
        if (i2 == -1) {
            return null;
        }
        Drawable s2 = s(cursor.getString(i2));
        if (s2 != null) {
            return s2;
        }
        return p();
    }

    private Drawable u(Cursor cursor) {
        int i2 = this.y;
        if (i2 == -1) {
            return null;
        }
        return s(cursor.getString(i2));
    }

    private static String w(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // b.i.a.b.a, b.i.a.a
    public void a(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // b.i.a.b.a, b.i.a.a
    public CharSequence c(Cursor cursor) {
        String o2;
        String o3;
        if (cursor == null) {
            return null;
        }
        String o4 = o(cursor, "suggest_intent_query");
        if (o4 != null) {
            return o4;
        }
        if (this.n.shouldRewriteQueryFromData() && (o3 = o(cursor, "suggest_intent_data")) != null) {
            return o3;
        }
        if (!this.n.shouldRewriteQueryFromText() || (o2 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o2;
    }

    @Override // b.i.a.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor v2 = v(this.n, charSequence2, 50);
                if (v2 != null) {
                    v2.getCount();
                    return v2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    @Override // b.i.a.a
    public void e(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i2 = this.z;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f674a != null) {
            z(aVar.f674a, w(cursor, this.u));
        }
        if (aVar.f675b != null) {
            String w2 = w(cursor, this.w);
            if (w2 != null) {
                charSequence = l(w2);
            } else {
                charSequence = w(cursor, this.v);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f674a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f674a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f674a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f674a.setMaxLines(1);
                }
            }
            z(aVar.f675b, charSequence);
        }
        ImageView imageView = aVar.f676c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f677d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i4 = this.s;
        if (i4 == 2 || (i4 == 1 && (i3 & 1) != 0)) {
            aVar.f678e.setVisibility(0);
            aVar.f678e.setTag(aVar.f674a.getText());
            aVar.f678e.setOnClickListener(this);
            return;
        }
        aVar.f678e.setVisibility(8);
    }

    @Override // b.i.a.a
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View g2 = g(this.f2710e, this.f2709d, viewGroup);
            if (g2 != null) {
                ((a) g2.getTag()).f674a.setText(e2.toString());
            }
            return g2;
        }
    }

    @Override // b.i.a.a
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View h2 = h(this.f2710e, this.f2709d, viewGroup);
            if (h2 != null) {
                ((a) h2.getTag()).f674a.setText(e2.toString());
            }
            return h2;
        }
    }

    @Override // b.i.a.c, b.i.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h2 = super.h(context, cursor, viewGroup);
        h2.setTag(new a(h2));
        ((ImageView) h2.findViewById(f.edit_query)).setImageResource(this.q);
        return h2;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.U((CharSequence) tag);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable r(Uri uri) {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f2710e.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    public Cursor v(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f2710e.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public void x(int i2) {
        this.s = i2;
    }
}
