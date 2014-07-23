package com.lang;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by 771407 on 7/21/2014.
 */
public class BorderImageView extends ImageView {
    private Context context;

    public BorderImageView(Context context) {
        super(context);
        init(context);
    }

    public BorderImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BorderImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setBackgroundResource(R.drawable.border_image);
    }

}
