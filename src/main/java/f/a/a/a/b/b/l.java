package f.a.a.a.b.b;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: lambda */
public final /* synthetic */ class l implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q0 f8972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f8973c;

    public /* synthetic */ l(q0 q0Var, RecyclerView.d0 d0Var) {
        this.f8972b = q0Var;
        this.f8973c = d0Var;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f8972b.A(this.f8973c, view, motionEvent);
    }
}
