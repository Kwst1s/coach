package f.a.a.a.b.n.b;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.d.i;
import f.a.a.a.b.d.j;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.VerticalTextView;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import kotlin.j.h;

/* compiled from: Frag_goal_graph.kt */
public final class d extends Fragment {
    private static final String c0 = "goal";
    public static final a d0 = new a(null);
    private i X;
    private LineData Y;
    private int Z;
    public ArrayList<ArrayList<j>> a0;
    private HashMap b0;

    /* compiled from: Frag_goal_graph.kt */
    public static final class a {
        private a() {
        }

        public final String a() {
            return d.c0;
        }

        public final d b(i iVar) {
            kotlin.m.b.f.e(iVar, d.c0);
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putSerializable(a(), iVar);
            dVar.v1(bundle);
            return dVar;
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }

    /* compiled from: Frag_goal_graph.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9647b;

        b(d dVar) {
            this.f9647b = dVar;
        }

        public final void onClick(View view) {
            d dVar = this.f9647b;
            dVar.Q1(dVar.N1() - 1);
            this.f9647b.R1();
        }
    }

    /* compiled from: Frag_goal_graph.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9648b;

        c(d dVar) {
            this.f9648b = dVar;
        }

        public final void onClick(View view) {
            d dVar = this.f9648b;
            dVar.Q1(dVar.N1() + 1);
            this.f9648b.R1();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.n.b.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_goal_graph.kt */
    public static final class C0216d implements IAxisValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f9649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f9650b;

        C0216d(ArrayList arrayList, SimpleDateFormat simpleDateFormat) {
            this.f9649a = arrayList;
            this.f9650b = simpleDateFormat;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public final String getFormattedValue(float f2, AxisBase axisBase) {
            return this.f9650b.format(Long.valueOf(((j) this.f9649a.get((int) f2)).a()));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_goal_graph.kt */
    public static final class e implements IAxisValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f9651a;

        e(ArrayList arrayList) {
            this.f9651a = arrayList;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public final String getFormattedValue(float f2, AxisBase axisBase) {
            return (String) this.f9651a.get((int) f2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_goal_graph.kt */
    public static final class f<T> implements Comparator<Entry> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f9652b = new f();

        f() {
        }

        /* renamed from: a */
        public final int compare(Entry entry, Entry entry2) {
            kotlin.m.b.f.d(entry, "o1");
            float x = entry.getX();
            kotlin.m.b.f.d(entry2, "o2");
            return Float.compare(x, entry2.getX());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_goal_graph.kt */
    public static final class g<T> implements Comparator<Entry> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f9653b = new g();

        g() {
        }

        /* renamed from: a */
        public final int compare(Entry entry, Entry entry2) {
            kotlin.m.b.f.d(entry, "o1");
            float x = entry.getX();
            kotlin.m.b.f.d(entry2, "o2");
            return Float.compare(x, entry2.getX());
        }
    }

    public void K1() {
        HashMap hashMap = this.b0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View L1(int i2) {
        if (this.b0 == null) {
            this.b0 = new HashMap();
        }
        View view = (View) this.b0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.b0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        kotlin.m.b.f.e(view, "view");
        super.N0(view, bundle);
        RelativeLayout relativeLayout = (RelativeLayout) L1(o.goal_graph_layout_graph);
        kotlin.m.b.f.d(relativeLayout, "goal_graph_layout_graph");
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        double p = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.p(n1());
        Double.isNaN(p);
        Double.isNaN(p);
        layoutParams.height = (int) (p / 1.3d);
        int i2 = o.goal_graph_graph;
        LineChart lineChart = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart, "goal_graph_graph");
        lineChart.setDragEnabled(false);
        ((LineChart) L1(i2)).setScaleEnabled(false);
        ((LineChart) L1(i2)).setPinchZoom(false);
        LineChart lineChart2 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart2, "goal_graph_graph");
        lineChart2.setDoubleTapToZoomEnabled(false);
        LineChart lineChart3 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart3, "goal_graph_graph");
        lineChart3.setHighlightPerDragEnabled(false);
        LineChart lineChart4 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart4, "goal_graph_graph");
        lineChart4.setHighlightPerTapEnabled(false);
        LineChart lineChart5 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart5, "goal_graph_graph");
        Legend legend = lineChart5.getLegend();
        kotlin.m.b.f.d(legend, "goal_graph_graph.legend");
        legend.setEnabled(false);
        Description description = new Description();
        description.setText(BuildConfig.FLAVOR);
        LineChart lineChart6 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart6, "goal_graph_graph");
        lineChart6.setDescription(description);
        LineChart lineChart7 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart7, "goal_graph_graph");
        YAxis axisLeft = lineChart7.getAxisLeft();
        kotlin.m.b.f.d(axisLeft, "goal_graph_graph.axisLeft");
        axisLeft.setAxisLineWidth(2.0f);
        LineChart lineChart8 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart8, "goal_graph_graph");
        YAxis axisRight = lineChart8.getAxisRight();
        kotlin.m.b.f.d(axisRight, "goal_graph_graph.axisRight");
        axisRight.setEnabled(false);
        LineChart lineChart9 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart9, "goal_graph_graph");
        XAxis xAxis = lineChart9.getXAxis();
        kotlin.m.b.f.d(xAxis, "goal_graph_graph.xAxis");
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        LineChart lineChart10 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart10, "goal_graph_graph");
        XAxis xAxis2 = lineChart10.getXAxis();
        kotlin.m.b.f.d(xAxis2, "goal_graph_graph.xAxis");
        xAxis2.setAxisLineWidth(2.0f);
        LineChart lineChart11 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart11, "goal_graph_graph");
        lineChart11.getXAxis().disableGridDashedLine();
        LineChart lineChart12 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart12, "goal_graph_graph");
        lineChart12.setExtraTopOffset(30.0f);
        LineChart lineChart13 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart13, "goal_graph_graph");
        lineChart13.getAxisLeft().setDrawGridLines(true);
        LineChart lineChart14 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart14, "goal_graph_graph");
        lineChart14.getXAxis().setDrawGridLines(true);
        LineChart lineChart15 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart15, "goal_graph_graph");
        YAxis axisLeft2 = lineChart15.getAxisLeft();
        kotlin.m.b.f.d(axisLeft2, "goal_graph_graph.axisLeft");
        axisLeft2.setAxisMaximum(100.0f);
        LineChart lineChart16 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart16, "goal_graph_graph");
        YAxis axisLeft3 = lineChart16.getAxisLeft();
        kotlin.m.b.f.d(axisLeft3, "goal_graph_graph.axisLeft");
        axisLeft3.setAxisMinimum(Utils.FLOAT_EPSILON);
        LineChart lineChart17 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart17, "goal_graph_graph");
        lineChart17.getAxisLeft().setLabelCount(11, true);
        ((LineChart) L1(i2)).setVisibleXRangeMaximum(7.0f);
        LineChart lineChart18 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart18, "goal_graph_graph");
        XAxis xAxis3 = lineChart18.getXAxis();
        kotlin.m.b.f.d(xAxis3, "goal_graph_graph.xAxis");
        xAxis3.setAxisMinimum(Utils.FLOAT_EPSILON);
        LineChart lineChart19 = (LineChart) L1(i2);
        kotlin.m.b.f.d(lineChart19, "goal_graph_graph");
        XAxis xAxis4 = lineChart19.getXAxis();
        kotlin.m.b.f.d(xAxis4, "goal_graph_graph.xAxis");
        xAxis4.setAxisMaximum(6.0f);
        int i3 = o.goal_graph_txt_goal;
        AppCompatTextView appCompatTextView = (AppCompatTextView) L1(i3);
        kotlin.m.b.f.d(appCompatTextView, "goal_graph_txt_goal");
        i iVar = this.X;
        kotlin.m.b.f.c(iVar);
        appCompatTextView.setText(iVar.a());
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) L1(i3);
        kotlin.m.b.f.d(appCompatTextView2, "goal_graph_txt_goal");
        i iVar2 = this.X;
        kotlin.m.b.f.c(iVar2);
        appCompatTextView2.setContentDescription(iVar2.a());
        VerticalTextView verticalTextView = (VerticalTextView) L1(o.goal_graph_txt_success);
        kotlin.m.b.f.d(verticalTextView, "goal_graph_txt_success");
        verticalTextView.setTypeface(b.h.d.e.f.b(n1(), R.font.font_semibold));
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) L1(o.goal_graph_txt_date);
        kotlin.m.b.f.d(appCompatTextView3, "goal_graph_txt_date");
        appCompatTextView3.setTypeface(b.h.d.e.f.b(n1(), R.font.font_semibold));
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((FloatingActionButton) L1(o.goal_graph_btn_previous)).setOnClickListener(new b(this));
        ((FloatingActionButton) L1(o.goal_graph_btn_next)).setOnClickListener(new c(this));
        O1();
        R1();
    }

    public final int N1() {
        return this.Z;
    }

    public final void O1() {
        this.a0 = new ArrayList<>();
        ArrayList<j> arrayList = new ArrayList<>();
        i iVar = this.X;
        kotlin.m.b.f.c(iVar);
        ArrayList<j> f2 = iVar.f();
        kotlin.m.b.f.c(f2);
        h.h(f2);
        i iVar2 = this.X;
        kotlin.m.b.f.c(iVar2);
        ArrayList<j> f3 = iVar2.f();
        kotlin.m.b.f.c(f3);
        int size = f3.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar3 = this.X;
            kotlin.m.b.f.c(iVar3);
            ArrayList<j> f4 = iVar3.f();
            kotlin.m.b.f.c(f4);
            arrayList.add(f4.get(i2));
            if (arrayList.size() == 7) {
                h.h(arrayList);
                ArrayList<ArrayList<j>> arrayList2 = this.a0;
                if (arrayList2 != null) {
                    arrayList2.add(arrayList);
                    arrayList = new ArrayList<>();
                } else {
                    kotlin.m.b.f.p("intervals");
                    throw null;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            h.h(arrayList);
            ArrayList<ArrayList<j>> arrayList3 = this.a0;
            if (arrayList3 != null) {
                arrayList3.add(arrayList);
            } else {
                kotlin.m.b.f.p("intervals");
                throw null;
            }
        }
        ArrayList<ArrayList<j>> arrayList4 = this.a0;
        if (arrayList4 != null) {
            h.h(arrayList4);
            ArrayList<ArrayList<j>> arrayList5 = this.a0;
            if (arrayList5 != null) {
                this.Z = arrayList5.size() - 1;
            } else {
                kotlin.m.b.f.p("intervals");
                throw null;
            }
        } else {
            kotlin.m.b.f.p("intervals");
            throw null;
        }
    }

    public final void P1() {
        ArrayList<ArrayList<j>> arrayList = this.a0;
        if (arrayList == null) {
            kotlin.m.b.f.p("intervals");
            throw null;
        } else if (arrayList.size() == 1) {
            ((FloatingActionButton) L1(o.goal_graph_btn_previous)).l();
            ((FloatingActionButton) L1(o.goal_graph_btn_next)).l();
        } else {
            int i2 = o.goal_graph_btn_previous;
            FloatingActionButton floatingActionButton = (FloatingActionButton) L1(i2);
            kotlin.m.b.f.d(floatingActionButton, "goal_graph_btn_previous");
            floatingActionButton.setAlpha(1.0f);
            int i3 = o.goal_graph_btn_next;
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) L1(i3);
            kotlin.m.b.f.d(floatingActionButton2, "goal_graph_btn_next");
            floatingActionButton2.setAlpha(1.0f);
            FloatingActionButton floatingActionButton3 = (FloatingActionButton) L1(i2);
            kotlin.m.b.f.d(floatingActionButton3, "goal_graph_btn_previous");
            floatingActionButton3.setClickable(true);
            FloatingActionButton floatingActionButton4 = (FloatingActionButton) L1(i3);
            kotlin.m.b.f.d(floatingActionButton4, "goal_graph_btn_next");
            floatingActionButton4.setClickable(true);
            int i4 = this.Z;
            if (i4 == 0) {
                FloatingActionButton floatingActionButton5 = (FloatingActionButton) L1(i2);
                kotlin.m.b.f.d(floatingActionButton5, "goal_graph_btn_previous");
                floatingActionButton5.setAlpha(0.4f);
                FloatingActionButton floatingActionButton6 = (FloatingActionButton) L1(i2);
                kotlin.m.b.f.d(floatingActionButton6, "goal_graph_btn_previous");
                floatingActionButton6.setClickable(false);
                return;
            }
            ArrayList<ArrayList<j>> arrayList2 = this.a0;
            if (arrayList2 == null) {
                kotlin.m.b.f.p("intervals");
                throw null;
            } else if (i4 == arrayList2.size() - 1) {
                FloatingActionButton floatingActionButton7 = (FloatingActionButton) L1(i3);
                kotlin.m.b.f.d(floatingActionButton7, "goal_graph_btn_next");
                floatingActionButton7.setAlpha(0.4f);
                FloatingActionButton floatingActionButton8 = (FloatingActionButton) L1(i3);
                kotlin.m.b.f.d(floatingActionButton8, "goal_graph_btn_next");
                floatingActionButton8.setClickable(false);
            }
        }
    }

    public final void Q1(int i2) {
        this.Z = i2;
    }

    public final void R1() {
        String str;
        SimpleDateFormat simpleDateFormat;
        ArrayList<ArrayList<j>> arrayList = this.a0;
        if (arrayList != null) {
            ArrayList<j> arrayList2 = arrayList.get(this.Z);
            kotlin.m.b.f.d(arrayList2, "intervals[curIndexInterval]");
            ArrayList<j> arrayList3 = arrayList2;
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/dd");
            ArrayList arrayList4 = new ArrayList();
            String str2 = "entries[i]";
            if (arrayList3.size() == 7) {
                int size = arrayList3.size();
                int i2 = 0;
                while (i2 < size) {
                    j jVar = arrayList3.get(i2);
                    kotlin.m.b.f.d(jVar, str2);
                    j jVar2 = jVar;
                    Calendar instance = Calendar.getInstance();
                    kotlin.m.b.f.d(instance, "calEntry");
                    instance.setTimeInMillis(jVar2.a());
                    arrayList4.add(new Entry((float) i2, (float) jVar2.c()));
                    i2++;
                    simpleDateFormat2 = simpleDateFormat2;
                }
                LineChart lineChart = (LineChart) L1(o.goal_graph_graph);
                kotlin.m.b.f.d(lineChart, "goal_graph_graph");
                XAxis xAxis = lineChart.getXAxis();
                kotlin.m.b.f.d(xAxis, "goal_graph_graph.xAxis");
                simpleDateFormat = simpleDateFormat2;
                xAxis.setValueFormatter(new C0216d(arrayList3, simpleDateFormat));
                str = str2;
            } else {
                simpleDateFormat = simpleDateFormat2;
                ArrayList arrayList5 = new ArrayList();
                int size2 = arrayList3.size();
                int i3 = 0;
                int i4 = 0;
                while (i3 < size2) {
                    j jVar3 = arrayList3.get(i3);
                    kotlin.m.b.f.d(jVar3, str2);
                    j jVar4 = jVar3;
                    Calendar instance2 = Calendar.getInstance();
                    kotlin.m.b.f.d(instance2, "calEntry");
                    instance2.setTimeInMillis(jVar4.a());
                    arrayList4.add(new Entry((float) i3, (float) jVar4.c()));
                    arrayList5.add(simpleDateFormat.format(Long.valueOf(jVar4.a())));
                    i4 = i3;
                    i3++;
                    str2 = str2;
                }
                str = str2;
                while (i4 <= 6) {
                    arrayList5.add(BuildConfig.FLAVOR);
                    i4++;
                }
                LineChart lineChart2 = (LineChart) L1(o.goal_graph_graph);
                kotlin.m.b.f.d(lineChart2, "goal_graph_graph");
                XAxis xAxis2 = lineChart2.getXAxis();
                kotlin.m.b.f.d(xAxis2, "goal_graph_graph.xAxis");
                xAxis2.setValueFormatter(new e(arrayList5));
            }
            if (!arrayList4.isEmpty()) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{b.h.d.a.b(n1(), R.color.s_chart_0_20), b.h.d.a.b(n1(), R.color.s_chart_21_40), b.h.d.a.b(n1(), R.color.s_chart_41_51), b.h.d.a.b(n1(), R.color.s_chart_61_70), b.h.d.a.b(n1(), R.color.s_chart_71)});
                h.g(arrayList4, f.f9652b);
                LineDataSet lineDataSet = new LineDataSet(arrayList4, BuildConfig.FLAVOR);
                lineDataSet.setCircleColor(b.h.d.a.b(n1(), R.color.colorAccent));
                lineDataSet.setColor(b.h.d.a.b(n1(), R.color.colorAccent));
                lineDataSet.setLineWidth(2.0f);
                lineDataSet.setCircleRadius(5.0f);
                lineDataSet.setDrawValues(false);
                lineDataSet.setDrawFilled(true);
                lineDataSet.setFillDrawable(gradientDrawable);
                this.Y = new LineData(lineDataSet);
                h.g(arrayList4, g.f9653b);
                int i5 = o.goal_graph_graph;
                LineChart lineChart3 = (LineChart) L1(i5);
                kotlin.m.b.f.d(lineChart3, "goal_graph_graph");
                lineChart3.setData(this.Y);
                ((LineChart) L1(i5)).notifyDataSetChanged();
                ((LineChart) L1(i5)).invalidate();
            }
            androidx.fragment.app.d n1 = n1();
            kotlin.m.b.f.d(n1, "requireActivity()");
            LayoutInflater layoutInflater = n1.getLayoutInflater();
            kotlin.m.b.f.d(layoutInflater, "requireActivity().layoutInflater");
            ((TableLayout) L1(o.goal_graph_layout_details)).removeAllViews();
            int size3 = arrayList3.size();
            int i6 = 0;
            while (i6 < size3) {
                j jVar5 = arrayList3.get(i6);
                kotlin.m.b.f.d(jVar5, str);
                j jVar6 = jVar5;
                View inflate = layoutInflater.inflate(R.layout.item_graph_detail_row, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_graph_detail_layout);
                AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.item_graph_txt_1);
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.item_graph_txt_2);
                kotlin.m.b.f.d(appCompatTextView, "txt_1");
                appCompatTextView.setText(Q(R.string.date) + ": " + simpleDateFormat.format(Long.valueOf(jVar6.a())));
                kotlin.m.b.f.d(appCompatTextView2, "txt_2");
                appCompatTextView2.setText(Q(R.string.success_perc) + ": " + String.valueOf(jVar6.c()));
                kotlin.m.b.f.d(linearLayout, "row");
                linearLayout.setContentDescription(Q(R.string.on) + " " + k.f10124a.j(jVar6.a()) + " " + String.valueOf(jVar6.c()) + "% " + Q(R.string.success));
                ((TableLayout) L1(o.goal_graph_layout_details)).addView(inflate);
                i6++;
                str = str;
            }
            P1();
            return;
        }
        kotlin.m.b.f.p("intervals");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            Serializable serializable = o1().getSerializable(c0);
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.Goal");
            this.X = (i) serializable;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.m.b.f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_goal_graph, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        K1();
    }
}
