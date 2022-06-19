package b.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import b.i.a.b;

/* compiled from: CursorAdapter */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f2707b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f2708c;

    /* renamed from: d  reason: collision with root package name */
    protected Cursor f2709d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f2710e;

    /* renamed from: f  reason: collision with root package name */
    protected int f2711f;

    /* renamed from: g  reason: collision with root package name */
    protected C0050a f2712g;

    /* renamed from: h  reason: collision with root package name */
    protected DataSetObserver f2713h;

    /* renamed from: i  reason: collision with root package name */
    protected b f2714i;

    /* access modifiers changed from: private */
    /* renamed from: b.i.a.a$a  reason: collision with other inner class name */
    /* compiled from: CursorAdapter */
    public class C0050a extends ContentObserver {
        C0050a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            a.this.i();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: CursorAdapter */
    public class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f2707b = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f2707b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    @Override // b.i.a.b.a
    public void a(Cursor cursor) {
        Cursor j2 = j(cursor);
        if (j2 != null) {
            j2.close();
        }
    }

    @Override // b.i.a.b.a
    public Cursor b() {
        return this.f2709d;
    }

    @Override // b.i.a.b.a
    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    /* access modifiers changed from: package-private */
    public void f(Context context, Cursor cursor, int i2) {
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f2708c = true;
        } else {
            this.f2708c = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f2709d = cursor;
        this.f2707b = z;
        this.f2710e = context;
        this.f2711f = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f2712g = new C0050a();
            this.f2713h = new b();
        } else {
            this.f2712g = null;
            this.f2713h = null;
        }
        if (z) {
            C0050a aVar = this.f2712g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2713h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f2707b || (cursor = this.f2709d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2707b) {
            return null;
        }
        this.f2709d.moveToPosition(i2);
        if (view == null) {
            view = g(this.f2710e, this.f2709d, viewGroup);
        }
        e(view, this.f2710e, this.f2709d);
        return view;
    }

    public Filter getFilter() {
        if (this.f2714i == null) {
            this.f2714i = new b(this);
        }
        return this.f2714i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f2707b || (cursor = this.f2709d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f2709d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f2707b || (cursor = this.f2709d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f2709d.getLong(this.f2711f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2707b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2709d.moveToPosition(i2)) {
            if (view == null) {
                view = h(this.f2710e, this.f2709d, viewGroup);
            }
            e(view, this.f2710e, this.f2709d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void i() {
        Cursor cursor;
        if (this.f2708c && (cursor = this.f2709d) != null && !cursor.isClosed()) {
            this.f2707b = this.f2709d.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f2709d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0050a aVar = this.f2712g;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2713h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2709d = cursor;
        if (cursor != null) {
            C0050a aVar2 = this.f2712g;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f2713h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2711f = cursor.getColumnIndexOrThrow("_id");
            this.f2707b = true;
            notifyDataSetChanged();
        } else {
            this.f2711f = -1;
            this.f2707b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
