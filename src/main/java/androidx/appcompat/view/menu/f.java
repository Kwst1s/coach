package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class f extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    g f345b;

    /* renamed from: c  reason: collision with root package name */
    private int f346c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f347d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f348e;

    /* renamed from: f  reason: collision with root package name */
    private final LayoutInflater f349f;

    /* renamed from: g  reason: collision with root package name */
    private final int f350g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f348e = z;
        this.f349f = layoutInflater;
        this.f345b = gVar;
        this.f350g = i2;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        i v = this.f345b.v();
        if (v != null) {
            ArrayList<i> z = this.f345b.z();
            int size = z.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (z.get(i2) == v) {
                    this.f346c = i2;
                    return;
                }
            }
        }
        this.f346c = -1;
    }

    public g b() {
        return this.f345b;
    }

    /* renamed from: c */
    public i getItem(int i2) {
        ArrayList<i> z = this.f348e ? this.f345b.z() : this.f345b.E();
        int i3 = this.f346c;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return z.get(i2);
    }

    public void d(boolean z) {
        this.f347d = z;
    }

    public int getCount() {
        ArrayList<i> z = this.f348e ? this.f345b.z() : this.f345b.E();
        if (this.f346c < 0) {
            return z.size();
        }
        return z.size() - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f349f.inflate(this.f350g, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f345b.F() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f347d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
