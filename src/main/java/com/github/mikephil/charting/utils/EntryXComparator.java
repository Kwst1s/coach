package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

public class EntryXComparator implements Comparator<Entry> {
    public int compare(Entry entry, Entry entry2) {
        float x = entry.getX() - entry2.getX();
        if (x == Utils.FLOAT_EPSILON) {
            return 0;
        }
        return x > Utils.FLOAT_EPSILON ? 1 : -1;
    }
}
