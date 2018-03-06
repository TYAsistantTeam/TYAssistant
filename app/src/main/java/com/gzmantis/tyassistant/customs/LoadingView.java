package com.gzmantis.tyassistant.customs;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

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
//    private ShapeLoadingView mShapeLoadingView;
    private int mTextAppearance;

    public LoadingView(Context paramContext)
    {
        super(paramContext);
    }
}
