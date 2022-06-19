package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.h.j.d;
import b.h.k.d0.c;
import b.h.k.u;
import c.e.a.b.f;
import com.google.android.material.internal.k;
import java.util.Calendar;

/* access modifiers changed from: package-private */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f7661b;

    class a extends b.h.k.a {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // b.h.k.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter().h());
        } else if (i2 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    /* renamed from: b */
    public m getAdapter() {
        return (m) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        m b2 = getAdapter();
        d<?> dVar = b2.f7725c;
        c cVar = b2.f7727e;
        Long c2 = b2.getItem(b2.b());
        Long c3 = b2.getItem(b2.h());
        for (d<Long, Long> dVar2 : dVar.c()) {
            F f2 = dVar2.f2586a;
            if (f2 != null) {
                if (dVar2.f2587b != null) {
                    long longValue = f2.longValue();
                    long longValue2 = dVar2.f2587b.longValue();
                    if (!d(c2, c3, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean d2 = k.d(this);
                        if (longValue < c2.longValue()) {
                            i3 = b2.b();
                            if (b2.f(i3)) {
                                i2 = 0;
                            } else if (!d2) {
                                i2 = materialCalendarGridView.getChildAt(i3 - 1).getRight();
                            } else {
                                i2 = materialCalendarGridView.getChildAt(i3 - 1).getLeft();
                            }
                        } else {
                            materialCalendarGridView.f7661b.setTimeInMillis(longValue);
                            i3 = b2.a(materialCalendarGridView.f7661b.get(5));
                            i2 = c(materialCalendarGridView.getChildAt(i3));
                        }
                        if (longValue2 > c3.longValue()) {
                            i5 = Math.min(b2.h(), getChildCount() - 1);
                            if (b2.g(i5)) {
                                i4 = getWidth();
                            } else if (!d2) {
                                i4 = materialCalendarGridView.getChildAt(i5).getRight();
                            } else {
                                i4 = materialCalendarGridView.getChildAt(i5).getLeft();
                            }
                        } else {
                            materialCalendarGridView.f7661b.setTimeInMillis(longValue2);
                            i5 = b2.a(materialCalendarGridView.f7661b.get(5));
                            i4 = c(materialCalendarGridView.getChildAt(i5));
                        }
                        int itemId = (int) b2.getItemId(i3);
                        int itemId2 = (int) b2.getItemId(i5);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + cVar.f7680a.c();
                            int bottom = childAt.getBottom() - cVar.f7680a.b();
                            if (!d2) {
                                i7 = numColumns > i3 ? 0 : i2;
                                i6 = i5 > numColumns2 ? getWidth() : i4;
                            } else {
                                int i8 = i5 > numColumns2 ? 0 : i4;
                                i6 = numColumns > i3 ? getWidth() : i2;
                                i7 = i8;
                            }
                            canvas.drawRect((float) i7, (float) top, (float) i6, (float) bottom, cVar.f7687h);
                            itemId++;
                            materialCalendarGridView = this;
                            b2 = b2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7661b = s.k();
        if (i.k2(getContext())) {
            setNextFocusLeftId(f.cancel_button);
            setNextFocusRightId(f.confirm_button);
        }
        u.m0(this, new a(this));
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof m) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
    }
}
