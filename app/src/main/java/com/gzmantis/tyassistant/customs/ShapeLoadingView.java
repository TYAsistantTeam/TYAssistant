package com.gzmantis.tyassistant.customs;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.gzmantis.tyassistant.R;

/**
 * Created by LONG on 2018/3/7.
 */

public class ShapeLoadingView extends View {
    private static final float genhao3 = 1.732051F;
    private static final float mTriangle2Circle = 0.2555555F;
    private float mAnimPercent;
    private float mControlX = 0.0F;
    private float mControlY = 0.0F;
    public boolean mIsLoading = false;
    private float mMagicNumber = 0.5522848F;
    private Paint mPaint;
    private Shape mShape = Shape.SHAPE_CIRCLE;

    public ShapeLoadingView(Context paramContext) {
        super(paramContext);
        init();
    }

    public ShapeLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public ShapeLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @TargetApi(21)
    public ShapeLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(R.color.triangle));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        setBackgroundColor(getResources().getColor(R.color.view_bg));
    }

    private float relativeXFromView(float paramFloat) {
        return paramFloat * getWidth();
    }

    private float relativeYFromView(float paramFloat) {
        return paramFloat * getHeight();
    }

    public void changeShape() {
        this.mIsLoading = true;
        invalidate();
    }

    public Shape getShape() {
        return this.mShape;
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (getVisibility() == View.GONE) {
            switch (mShape.ordinal()) {
                case 1:
                    if (this.mIsLoading) {
                        this.mAnimPercent = (float) (0.1611113D + this.mAnimPercent);
                        Path localPath6 = new Path();
                        localPath6.moveTo(relativeXFromView(0.5F), relativeYFromView(0.0F));
                        if (this.mAnimPercent >= 1.0F) {
                            this.mShape = Shape.SHAPE_CIRCLE;
                            this.mIsLoading = false;
                            this.mAnimPercent = 1.0F;
                        }
                        float f5 = this.mControlX - 1.732051F * relativeXFromView(0.2555555F * this.mAnimPercent);
                        float f6 = this.mControlY - relativeYFromView(0.2555555F * this.mAnimPercent);
                        localPath6.quadTo(relativeXFromView(1.0F) - f5, f6, relativeXFromView(0.9330127F), relativeYFromView(0.75F));
                        localPath6.quadTo(relativeXFromView(0.5F), relativeYFromView(0.75F + 0.2555555F * (2.0F * this.mAnimPercent)), relativeXFromView(0.06698731F), relativeYFromView(0.75F));
                        localPath6.quadTo(f5, f6, relativeXFromView(0.5F), relativeYFromView(0.0F));
                        localPath6.close();
                        paramCanvas.drawPath(localPath6, this.mPaint);
                        invalidate();
                    }
                    Path localPath5 = new Path();
                    this.mPaint.setColor(getResources().getColor(R.color.triangle));
                    localPath5.moveTo(relativeXFromView(0.5F), relativeYFromView(0.0F));
                    localPath5.lineTo(relativeXFromView(1.0F), relativeYFromView(0.8660254F));
                    localPath5.lineTo(relativeXFromView(0.0F), relativeYFromView(0.8660254F));
                    this.mControlX = relativeXFromView(0.2834936F);
                    this.mControlY = relativeYFromView(0.375F);
                    this.mAnimPercent = 0.0F;
                    localPath5.close();
                    paramCanvas.drawPath(localPath5, this.mPaint);
                    break;
                case 2:
                    if (this.mIsLoading) {
                        float f4 = this.mMagicNumber + this.mAnimPercent;
                        this.mAnimPercent = (float) (0.12D + this.mAnimPercent);
                        if (f4 + this.mAnimPercent >= 1.9F) {
                            this.mShape = Shape.SHAPE_RECT;
                            this.mIsLoading = false;
                        }
                        Path localPath4 = new Path();
                        localPath4.moveTo(relativeXFromView(0.5F), relativeYFromView(0.0F));
                        localPath4.cubicTo(relativeXFromView(0.5F + f4 / 2.0F), relativeYFromView(0.0F), relativeXFromView(1.0F), relativeYFromView(0.5F - f4 / 2.0F), relativeXFromView(1.0F), relativeYFromView(0.5F));
                        localPath4.cubicTo(relativeXFromView(1.0F), relativeXFromView(0.5F + f4 / 2.0F), relativeXFromView(0.5F + f4 / 2.0F), relativeYFromView(1.0F), relativeXFromView(0.5F), relativeYFromView(1.0F));
                        localPath4.cubicTo(relativeXFromView(0.5F - f4 / 2.0F), relativeXFromView(1.0F), relativeXFromView(0.0F), relativeYFromView(0.5F + f4 / 2.0F), relativeXFromView(0.0F), relativeYFromView(0.5F));
                        localPath4.cubicTo(relativeXFromView(0.0F), relativeXFromView(0.5F - f4 / 2.0F), relativeXFromView(0.5F - f4 / 2.0F), relativeYFromView(0.0F), relativeXFromView(0.5F), relativeYFromView(0.0F));
                        localPath4.close();
                        paramCanvas.drawPath(localPath4, this.mPaint);
                        invalidate();
                    }
                    this.mPaint.setColor(getResources().getColor(R.color.circle));
                    Path localPath3 = new Path();
                    float f3 = this.mMagicNumber;
                    localPath3.moveTo(relativeXFromView(0.5F), relativeYFromView(0.0F));
                    localPath3.cubicTo(relativeXFromView(0.5F + f3 / 2.0F), 0.0F, relativeXFromView(1.0F), relativeYFromView(f3 / 2.0F), relativeXFromView(1.0F), relativeYFromView(0.5F));
                    localPath3.cubicTo(relativeXFromView(1.0F), relativeXFromView(0.5F + f3 / 2.0F), relativeXFromView(0.5F + f3 / 2.0F), relativeYFromView(1.0F), relativeXFromView(0.5F), relativeYFromView(1.0F));
                    localPath3.cubicTo(relativeXFromView(0.5F - f3 / 2.0F), relativeXFromView(1.0F), relativeXFromView(0.0F), relativeYFromView(0.5F + f3 / 2.0F), relativeXFromView(0.0F), relativeYFromView(0.5F));
                    localPath3.cubicTo(relativeXFromView(0.0F), relativeXFromView(0.5F - f3 / 2.0F), relativeXFromView(0.5F - f3 / 2.0F), relativeYFromView(0.0F), relativeXFromView(0.5F), relativeYFromView(0.0F));
                    this.mAnimPercent = 0.0F;
                    localPath3.close();
                    paramCanvas.drawPath(localPath3, this.mPaint);
                    break;
                case 3:
                    if (this.mIsLoading) {
                        this.mAnimPercent = (float) (0.15D + this.mAnimPercent);
                        if (this.mAnimPercent >= 1.0F) {
                            this.mShape = Shape.SHAPE_TRIANGLE;
                            this.mIsLoading = false;
                            this.mAnimPercent = 1.0F;
                        }
                        Path localPath2 = new Path();
                        localPath2.moveTo(relativeXFromView(0.5F * this.mAnimPercent), 0.0F);
                        localPath2.lineTo(relativeYFromView(1.0F - 0.5F * this.mAnimPercent), 0.0F);
                        float f1 = this.mControlX * this.mAnimPercent;
                        float f2 = (relativeYFromView(1.0F) - this.mControlY) * this.mAnimPercent;
                        localPath2.lineTo(relativeXFromView(1.0F) - f1, relativeYFromView(1.0F) - f2);
                        localPath2.lineTo(f1 + relativeXFromView(0.0F), relativeYFromView(1.0F) - f2);
                        localPath2.close();
                        paramCanvas.drawPath(localPath2, this.mPaint);
                        invalidate();
                    }
                    this.mPaint.setColor(getResources().getColor(R.color.rect));
                    this.mControlX = relativeXFromView(0.06698731F);
                    this.mControlY = relativeYFromView(0.75F);
                    Path localPath1 = new Path();
                    localPath1.moveTo(relativeXFromView(0.0F), relativeYFromView(0.0F));
                    localPath1.lineTo(relativeXFromView(1.0F), relativeYFromView(0.0F));
                    localPath1.lineTo(relativeXFromView(1.0F), relativeYFromView(1.0F));
                    localPath1.lineTo(relativeXFromView(0.0F), relativeYFromView(1.0F));
                    localPath1.close();
                    this.mAnimPercent = 0.0F;
                    paramCanvas.drawPath(localPath1, this.mPaint);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void setVisibility(int paramInt) {
        super.setVisibility(paramInt);
        if (paramInt != View.VISIBLE) {
            return;
        }
        invalidate();
    }

    public enum Shape {
        SHAPE_TRIANGLE,
        SHAPE_RECT,
        SHAPE_CIRCLE;
    }

}