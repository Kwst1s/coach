package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.e.a.b.h;
import c.e.a.b.j;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DaysOfWeekAdapter */
class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    private static final int f7689e = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f7690b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7691c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7692d;

    public g() {
        Calendar k2 = s.k();
        this.f7690b = k2;
        this.f7691c = k2.getMaximum(7);
        this.f7692d = k2.getFirstDayOfWeek();
    }

    private int b(int i2) {
        int i3 = i2 + this.f7692d;
        int i4 = this.f7691c;
        return i3 > i4 ? i3 - i4 : i3;
    }

    /* renamed from: a */
    public Integer getItem(int i2) {
        if (i2 >= this.f7691c) {
            return null;
        }
        return Integer.valueOf(b(i2));
    }

    public int getCount() {
        return this.f7691c;
    }

    public long getItemId(int i2) {
        return 0;
    }

    @SuppressLint({"WrongConstant"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f7690b.set(7, b(i2));
        textView.setText(this.f7690b.getDisplayName(7, f7689e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(j.mtrl_picker_day_of_week_column_header), this.f7690b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
