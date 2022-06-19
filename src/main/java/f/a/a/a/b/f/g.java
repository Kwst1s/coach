package f.a.a.a.b.f;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

/* compiled from: lambda */
public final /* synthetic */ class g implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f9321a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9322b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f9323c;

    public /* synthetic */ g(j jVar, String str, int i2) {
        this.f9321a = jVar;
        this.f9322b = str;
        this.f9323c = i2;
    }

    public final void onTimeSet(TimePicker timePicker, int i2, int i3) {
        this.f9321a.A2(this.f9322b, this.f9323c, timePicker, i2, i3);
    }
}
