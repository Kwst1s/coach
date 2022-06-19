package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* compiled from: DateSelector */
public interface d<S> extends Parcelable {
    String a(Context context);

    int b(Context context);

    Collection<b.h.j.d<Long, Long>> c();

    boolean e();

    Collection<Long> f();

    S h();

    void i(long j2);

    View j(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, o<S> oVar);
}
