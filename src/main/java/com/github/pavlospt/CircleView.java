package com.github.pavlospt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;

public class CircleView extends View {
    private static boolean A = true;
    private static boolean B = true;
    private static float C = 25.0f;
    private static float D = 20.0f;
    private static float E = 0.0f;
    private static int F = -16711681;
    private static int G = -1;
    private static int H = -12303292;
    private static float I = 5.0f;
    private static float J = 0.9f;
    private static int w = -16711681;
    private static int x = -1;
    private static String y = "Title";
    private static String z = "Subtitle";

    /* renamed from: b  reason: collision with root package name */
    private int f4702b = w;

    /* renamed from: c  reason: collision with root package name */
    private int f4703c = x;

    /* renamed from: d  reason: collision with root package name */
    private int f4704d = F;

    /* renamed from: e  reason: collision with root package name */
    private int f4705e = G;

    /* renamed from: f  reason: collision with root package name */
    private int f4706f = H;

    /* renamed from: g  reason: collision with root package name */
    private String f4707g = y;

    /* renamed from: h  reason: collision with root package name */
    private String f4708h = z;

    /* renamed from: i  reason: collision with root package name */
    private float f4709i = C;

    /* renamed from: j  reason: collision with root package name */
    private float f4710j = D;

    /* renamed from: k  reason: collision with root package name */
    private float f4711k = I;
    private float l = J;
    private float m = E;
    private boolean n = A;
    private boolean o = B;
    private TextPaint p;
    private TextPaint q;
    private Paint r;
    private Paint s;
    private Paint t;
    private RectF u;
    private int v;

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    private void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f4712a, i2, 0);
        int i3 = a.m;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f4707g = obtainStyledAttributes.getString(i3);
        }
        int i4 = a.f4720i;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f4708h = obtainStyledAttributes.getString(i4);
        }
        this.f4702b = obtainStyledAttributes.getColor(a.f4721j, w);
        this.f4703c = obtainStyledAttributes.getColor(a.f4718g, x);
        this.f4705e = obtainStyledAttributes.getColor(a.f4713b, G);
        this.f4704d = obtainStyledAttributes.getColor(a.f4716e, F);
        this.f4706f = obtainStyledAttributes.getColor(a.f4714c, H);
        this.f4709i = obtainStyledAttributes.getDimension(a.f4722k, C);
        this.f4710j = obtainStyledAttributes.getDimension(a.f4719h, D);
        this.f4711k = obtainStyledAttributes.getFloat(a.f4717f, I);
        this.l = obtainStyledAttributes.getFloat(a.f4715d, J);
        this.m = obtainStyledAttributes.getFloat(a.l, E);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.p = textPaint;
        textPaint.setFlags(1);
        this.p.setTypeface(Typeface.defaultFromStyle(0));
        this.p.setTextAlign(Paint.Align.CENTER);
        this.p.setLinearText(true);
        this.p.setColor(this.f4702b);
        this.p.setTextSize(this.f4709i);
        TextPaint textPaint2 = new TextPaint();
        this.q = textPaint2;
        textPaint2.setFlags(1);
        this.q.setTypeface(Typeface.defaultFromStyle(0));
        this.q.setTextAlign(Paint.Align.CENTER);
        this.q.setLinearText(true);
        this.q.setColor(this.f4703c);
        this.q.setTextSize(this.f4710j);
        Paint paint = new Paint();
        this.r = paint;
        paint.setFlags(1);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setColor(this.f4704d);
        this.r.setStrokeWidth(this.f4711k);
        Paint paint2 = new Paint();
        this.s = paint2;
        paint2.setFlags(1);
        this.s.setStyle(Paint.Style.FILL);
        this.s.setColor(this.f4705e);
        Paint paint3 = new Paint();
        this.t = paint3;
        paint3.setFlags(1);
        this.t.setStyle(Paint.Style.FILL);
        this.t.setColor(this.f4706f);
        this.u = new RectF();
    }

    private void b() {
        this.s.setColor(this.f4705e);
        this.r.setColor(this.f4704d);
        this.t.setColor(this.f4706f);
        invalidate();
    }

    private void c() {
        this.p.setColor(this.f4702b);
        this.q.setColor(this.f4703c);
        this.p.setTextSize(this.f4709i);
        this.q.setTextSize(this.f4710j);
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f4705e;
    }

    public int getFillColor() {
        return this.f4704d;
    }

    public float getFillRadius() {
        return this.l;
    }

    public int getStrokeColor() {
        return this.f4704d;
    }

    public float getStrokeWidth() {
        return this.f4711k;
    }

    public int getSubtitleColor() {
        return this.f4703c;
    }

    public float getSubtitleSize() {
        return this.f4710j;
    }

    public String getSubtitleText() {
        return this.f4708h;
    }

    public int getTitleColor() {
        return this.f4702b;
    }

    public float getTitleSize() {
        return this.f4709i;
    }

    public float getTitleSubtitleSpace() {
        return this.m;
    }

    public String getTitleText() {
        return this.f4707g;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.u;
        int i2 = this.v;
        rectF.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) i2, (float) i2);
        this.u.offset((float) ((getWidth() - this.v) / 2), (float) ((getHeight() - this.v) / 2));
        float strokeWidth = (float) ((int) ((this.r.getStrokeWidth() / 2.0f) + 0.5f));
        this.u.inset(strokeWidth, strokeWidth);
        float centerX = this.u.centerX();
        float centerY = this.u.centerY();
        canvas.drawArc(this.u, Utils.FLOAT_EPSILON, 360.0f, true, this.s);
        canvas.drawCircle(centerX, centerY, ((((float) (this.v / 2)) * this.l) + 0.5f) - this.r.getStrokeWidth(), this.t);
        int i3 = (int) centerX;
        int descent = (int) (centerY - ((this.p.descent() + this.p.ascent()) / 2.0f));
        canvas.drawOval(this.u, this.r);
        if (this.n) {
            canvas.drawText(this.f4707g, (float) i3, (float) descent, this.p);
        }
        if (this.o) {
            canvas.drawText(this.f4708h, (float) i3, ((float) (descent + 20)) + this.m, this.q);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int resolveSize = View.resolveSize(96, i2);
        int resolveSize2 = View.resolveSize(96, i3);
        this.v = Math.min(resolveSize, resolveSize2);
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public void setBackgroundColor(int i2) {
        this.f4705e = i2;
        b();
    }

    public void setFillColor(int i2) {
        this.f4706f = i2;
        b();
    }

    public void setFillRadius(float f2) {
        this.l = f2;
        invalidate();
    }

    public void setShowSubtitle(boolean z2) {
        this.o = z2;
        invalidate();
    }

    public void setShowTitle(boolean z2) {
        this.n = z2;
        invalidate();
    }

    public void setStrokeColor(int i2) {
        this.f4704d = i2;
        b();
    }

    public void setSubtitleColor(int i2) {
        this.f4703c = i2;
        c();
    }

    public void setSubtitleSize(float f2) {
        this.f4710j = f2;
        c();
    }

    public void setSubtitleText(String str) {
        this.f4708h = str;
        invalidate();
    }

    public void setTitleColor(int i2) {
        this.f4702b = i2;
        c();
    }

    public void setTitleSize(float f2) {
        this.f4709i = f2;
        c();
    }

    public void setTitleSubtitleSpace(float f2) {
        this.m = f2;
        c();
    }

    public void setTitleText(String str) {
        this.f4707g = str;
        invalidate();
    }

    public void setBackgroundColor(float f2) {
        this.f4711k = f2;
        invalidate();
    }
}
