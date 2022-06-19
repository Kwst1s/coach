package f.a.a.a.b.b;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: lambda */
public final /* synthetic */ class o implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f8989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f8990c;

    public /* synthetic */ o(t0 t0Var, RecyclerView.d0 d0Var) {
        this.f8989b = t0Var;
        this.f8990c = d0Var;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f8989b.A(this.f8990c, view, motionEvent);
    }
}
