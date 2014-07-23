package com.lang;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 771407 on 7/21/2014.
 */
public class BulletTextView extends TextView {

    private Context context;
    public static final String BULLET = "&#8226;";
    public static final String BR_TEXT = "<br/>";

    public BulletTextView(Context context) {
        super(context);
        if (!isInEditMode())
            init(context);
    }

    public BulletTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init(context);
    }

    public BulletTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init(context);
    }

    private void init(Context context) {
        this.context = context;
        setTextAppearance(context, R.style.BulletTextApperance);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        text = Html.fromHtml(BULLET + text + BR_TEXT);
        super.setText(text, type);
    }

}
