package com.gzmantis.tyassistant.customs;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzmantis.tyassistant.R;

/**
 * Created by LONG on 2018/3/6.
 */

public class LoadingView extends FrameLayout {

    private static final int ANIMATION_DURATION = 300;
    private static float mDistance = 200.0F;
    public float factor = 1.2F;
    private ImageView mIndicationIm;
    private String mLoadText;
    private TextView mLoadTextView;
    private ShapeLoadingView mShapeLoadingView;
    private int mTextAppearance;

    public LoadingView(Context paramContext)
    {
        super(paramContext);
    }

    public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet, 0);
        init(paramContext, paramAttributeSet);
    }

    public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    @TargetApi(21)
    public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
        init(paramContext, paramAttributeSet);
    }

    private void init(Context paramContext, AttributeSet paramAttributeSet)
    {
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet,R.styleable.LoadingView);
        this.mLoadText = localTypedArray.getString(0);
        this.mTextAppearance = localTypedArray.getResourceId(1, -1);
        localTypedArray.recycle();
    }

    public int dip2px(float paramFloat)
    {
        return (int)(0.5F + paramFloat * getContext().getResources().getDisplayMetrics().density);
    }

    public void freeFall()
    {
        ShapeLoadingView localShapeLoadingView = this.mShapeLoadingView;
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = mDistance;
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localShapeLoadingView, "translationY", arrayOfFloat);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mIndicationIm, "scaleX", new float[] { 1.0F, 0.2F });
        localObjectAnimator1.setDuration(300L);
        localObjectAnimator1.setInterpolator(new AccelerateInterpolator(this.factor));
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.addListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationCancel(Animator paramAnimator)
            {
            }

            @Override
            public void onAnimationEnd(Animator paramAnimator)
            {
                LoadingView.this.mShapeLoadingView.changeShape();
                LoadingView.this.upThrow();
            }

            @Override
            public void onAnimationRepeat(Animator paramAnimator)
            {
            }

            @Override
            public void onAnimationStart(Animator paramAnimator)
            {
            }
        });
        localAnimatorSet.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View localView = LayoutInflater.from(getContext()).inflate(R.layout.layout_loading_view, null);
        mDistance = dip2px(54.0F);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        this.mShapeLoadingView = ((ShapeLoadingView) localView.findViewById(R.id.shapeLoadingView));
        this.mIndicationIm = ((ImageView) localView.findViewById(R.id.indication));
        this.mLoadTextView = ((TextView) localView.findViewById(R.id.promptTV));
        if (this.mTextAppearance != -1) {
            this.mLoadTextView.setTextAppearance(getContext(), this.mTextAppearance);
        }
        setLoadingText(this.mLoadText);
        addView(localView, localLayoutParams);
        postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LoadingView.this.freeFall();
                        }
                    }
                , 900L);
    }

    public void setLoadingText(CharSequence paramCharSequence)
    {
        if (TextUtils.isEmpty(paramCharSequence)) {
            this.mLoadTextView.setVisibility(View.GONE);
        }

        this.mLoadTextView.setText(paramCharSequence);
        this.mLoadTextView.setVisibility(View.VISIBLE);
    }

    public void upThrow() {
        ShapeLoadingView localShapeLoadingView = this.mShapeLoadingView;
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = mDistance;
        arrayOfFloat[1] = 0.0F;
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localShapeLoadingView, "translationY", arrayOfFloat);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mIndicationIm, "scaleX", new float[]{0.2F, 1.0F});
        ObjectAnimator localObjectAnimator3 = null;

        switch (this.mShapeLoadingView.getShape().ordinal()) {
            case 1:
                localObjectAnimator3 = ObjectAnimator.ofFloat(this.mShapeLoadingView, "rotation", new float[]{0.0F, -120.0F});
                break;
            case 2:
                localObjectAnimator3 = ObjectAnimator.ofFloat(this.mShapeLoadingView, "rotation", new float[]{0.0F, 180.0F});
                break;
            case 3:
                localObjectAnimator3 = ObjectAnimator.ofFloat(this.mShapeLoadingView, "rotation", new float[]{0.0F, 180.0F});
                break;
            default:
                break;
        }

        localObjectAnimator1.setDuration(300L);
        localObjectAnimator3.setDuration(300L);
        localObjectAnimator1.setInterpolator(new DecelerateInterpolator(this.factor));
        localObjectAnimator3.setInterpolator(new DecelerateInterpolator(this.factor));
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.playTogether(new Animator[]{localObjectAnimator1, localObjectAnimator3, localObjectAnimator2});
        localAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(Animator paramAnimator) {
            }

            @Override
            public void onAnimationEnd(Animator paramAnimator) {
                LoadingView.this.freeFall();
            }

            @Override
            public void onAnimationRepeat(Animator paramAnimator) {
            }

            @Override
            public void onAnimationStart(Animator paramAnimator) {
            }
        });
        localAnimatorSet.start();
    }

}
