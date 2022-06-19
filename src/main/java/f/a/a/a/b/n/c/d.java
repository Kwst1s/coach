package f.a.a.a.b.n.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.j;
import b.h.d.e.f;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.b.w;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp.Act_assessment;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: Frag_assessment_history_graph */
public class d extends vainstrum.Components.b {
    private LineChart c0;
    private RelativeLayout d0;
    private FloatingActionButton e0;
    private FloatingActionButton f0;
    private RecyclerView g0;
    private AppCompatButton h0;
    private ArrayList<ArrayList<f.a.a.a.b.d.b>> i0;
    private int j0 = 0;

    /* compiled from: Frag_assessment_history_graph */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            d dVar = d.this;
            dVar.j0--;
            d.this.c2();
        }
    }

    /* compiled from: Frag_assessment_history_graph */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            d.this.j0++;
            d.this.c2();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_assessment_history_graph */
    public class c implements IAxisValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f9659a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f9660b;

        c(d dVar, ArrayList arrayList, SimpleDateFormat simpleDateFormat) {
            this.f9659a = arrayList;
            this.f9660b = simpleDateFormat;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float f2, AxisBase axisBase) {
            return this.f9660b.format(Long.valueOf(((f.a.a.a.b.d.b) this.f9659a.get((int) f2)).a()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.n.c.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_assessment_history_graph */
    public class C0217d implements IAxisValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f9661a;

        C0217d(d dVar, ArrayList arrayList) {
            this.f9661a = arrayList;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float f2, AxisBase axisBase) {
            return (String) this.f9661a.get((int) f2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_assessment_history_graph */
    public class e implements Comparator<Entry> {
        e(d dVar) {
        }

        /* renamed from: a */
        public int compare(Entry entry, Entry entry2) {
            return Float.compare(entry.getX(), entry2.getX());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2(View view) {
        F1(new Intent(p1(), Act_assessment.class));
    }

    public void Y1() {
        ArrayList<f.a.a.a.b.d.b> o0 = new u(n1()).o0(j.I0);
        this.i0 = new ArrayList<>();
        ArrayList<f.a.a.a.b.d.b> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < o0.size(); i2++) {
            arrayList.add(o0.get(i2));
            if (arrayList.size() == 7) {
                Collections.reverse(arrayList);
                this.i0.add(arrayList);
                arrayList = new ArrayList<>();
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.reverse(arrayList);
            this.i0.add(arrayList);
        }
        Collections.reverse(this.i0);
        this.j0 = this.i0.size() - 1;
    }

    public void b2() {
        if (this.i0.size() == 1) {
            this.e0.l();
            this.f0.l();
            return;
        }
        this.e0.setAlpha(1.0f);
        this.f0.setAlpha(1.0f);
        this.e0.setClickable(true);
        this.f0.setClickable(true);
        int i2 = this.j0;
        if (i2 == 0) {
            this.e0.setAlpha(0.4f);
            this.e0.setClickable(false);
        } else if (i2 == this.i0.size() - 1) {
            this.f0.setAlpha(0.4f);
            this.f0.setClickable(false);
        }
    }

    public void c2() {
        ArrayList<f.a.a.a.b.d.b> arrayList = this.i0.get(this.j0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        ArrayList arrayList2 = new ArrayList();
        this.c0.getXAxis().setAxisMinimum(Utils.FLOAT_EPSILON);
        this.c0.getXAxis().setAxisMaximum(6.0f);
        if (arrayList.size() == 7) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f.a.a.a.b.d.b bVar = arrayList.get(i2);
                Calendar.getInstance().setTimeInMillis(bVar.a());
                arrayList2.add(new Entry((float) i2, (float) bVar.c()));
            }
            this.c0.getXAxis().setValueFormatter(new c(this, arrayList, simpleDateFormat));
        } else {
            ArrayList arrayList3 = new ArrayList();
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                f.a.a.a.b.d.b bVar2 = arrayList.get(i4);
                Calendar.getInstance().setTimeInMillis(bVar2.a());
                arrayList2.add(new Entry((float) i4, (float) bVar2.c()));
                arrayList3.add(simpleDateFormat.format(Long.valueOf(bVar2.a())));
                i3 = i4;
            }
            while (i3 < 7) {
                arrayList3.add(BuildConfig.FLAVOR);
                i3++;
            }
            this.c0.getXAxis().setValueFormatter(new C0217d(this, arrayList3));
        }
        if (!arrayList2.isEmpty()) {
            Collections.sort(arrayList2, new e(this));
            LineDataSet lineDataSet = new LineDataSet(arrayList2, BuildConfig.FLAVOR);
            lineDataSet.setCircleColorHole(-1);
            lineDataSet.setCircleColor(b.h.d.a.b(n1(), R.color.colorAccent));
            lineDataSet.setColor(b.h.d.a.b(n1(), R.color.colorAccent));
            lineDataSet.setLineWidth(1.5f);
            lineDataSet.setCircleRadius(6.0f);
            lineDataSet.setCircleHoleRadius(4.0f);
            lineDataSet.setDrawCircleHole(true);
            lineDataSet.setDrawValues(false);
            this.c0.setData(new LineData(lineDataSet));
            this.c0.notifyDataSetChanged();
            this.c0.invalidate();
        } else {
            this.c0.setData(new LineData(new ArrayList()));
            this.c0.notifyDataSetChanged();
            this.c0.invalidate();
        }
        b2();
        this.g0.setAdapter(new w(n1(), new u(n1()).o0(j.I0), j.I0));
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_history_graph, viewGroup, false);
        this.c0 = (LineChart) inflate.findViewById(R.id.history_graph_chart);
        this.d0 = (RelativeLayout) inflate.findViewById(R.id.history_graph_chart_layout);
        this.e0 = (FloatingActionButton) inflate.findViewById(R.id.history_graph_btn_previous);
        this.f0 = (FloatingActionButton) inflate.findViewById(R.id.history_graph_btn_next);
        this.g0 = (RecyclerView) inflate.findViewById(R.id.history_graph_rview_details);
        this.h0 = (AppCompatButton) inflate.findViewById(R.id.history_graph_btn_take_assessment);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.history_graph_layout_btn_take_assessment);
        this.g0.setLayoutManager(new LinearLayoutManager(n1()));
        this.g0.setHasFixedSize(false);
        this.g0.setNestedScrollingEnabled(false);
        this.h0.setOnClickListener(new a(this));
        double r = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n1());
        Double.isNaN(r);
        double r2 = (double) gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n1());
        Double.isNaN(r2);
        this.d0.getLayoutParams().width = (int) (r / 1.25d);
        this.d0.getLayoutParams().height = (int) (r2 / 1.3d);
        this.c0.setDragEnabled(false);
        this.c0.setScaleEnabled(false);
        this.c0.setPinchZoom(false);
        this.c0.setDoubleTapToZoomEnabled(false);
        this.c0.setHighlightPerDragEnabled(false);
        this.c0.setHighlightPerTapEnabled(false);
        this.c0.getLegend().setEnabled(false);
        Description description = new Description();
        description.setText(BuildConfig.FLAVOR);
        this.c0.setDescription(description);
        this.c0.getAxisLeft().setAxisMaximum(80.0f);
        this.c0.getAxisLeft().setAxisMinimum(Utils.FLOAT_EPSILON);
        this.c0.getAxisLeft().setAxisLineWidth(2.0f);
        this.c0.getAxisRight().setEnabled(false);
        this.c0.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.c0.getXAxis().setAxisLineWidth(2.0f);
        this.c0.getXAxis().enableGridDashedLine(3.0f, 2.0f, Utils.FLOAT_EPSILON);
        this.c0.getXAxis().setLabelCount(6, false);
        this.c0.getXAxis().setDrawGridLines(true);
        this.c0.getAxisLeft().setDrawLabels(true);
        this.c0.getAxisLeft().setDrawGridLines(true);
        this.c0.getAxisLeft().enableGridDashedLine(3.0f, 2.0f, Utils.FLOAT_EPSILON);
        this.c0.getAxisLeft().setLabelCount(9, true);
        YAxis axisLeft = this.c0.getAxisLeft();
        double dimensionPixelSize = (double) K().getDimensionPixelSize(R.dimen.txt_little);
        Double.isNaN(dimensionPixelSize);
        axisLeft.setTextSize((float) (dimensionPixelSize / 1.5d));
        this.c0.setVisibleXRangeMaximum(7.0f);
        this.c0.getXAxis().setAxisMinimum(Utils.FLOAT_EPSILON);
        this.c0.getXAxis().setAxisMaximum(6.0f);
        this.c0.getAxisLeft().setTypeface(f.b(n1(), R.font.font_regular));
        this.c0.getXAxis().setTypeface(f.b(n1(), R.font.font_regular));
        this.e0.setOnClickListener(new a());
        this.f0.setOnClickListener(new b());
        Y1();
        c2();
        return inflate;
    }
}
